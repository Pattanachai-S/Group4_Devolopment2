package OX_but_MVC;
import java.util.Scanner;  // For input
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Model {
	
	static int table_size = 3;
	static int[][] table = new int[table_size][table_size]; 	
	static boolean game_end = false; 
	static int winner;
	static int turn_count = 1;
	static int player_turn = 1;
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	View UI;
	
	Model(){
		reset_table();
	}
	
	private static char[] type(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	void reset_table() {
		// Reset game data
		for (int i = 0; i < table_size; i++) {
			for (int j = 0; j < table_size; j++) {
				table[i][j] = 0;
			}
		}
		turn_count = 1;
		player_turn = 1;
		game_end = false;
		winner = 0;
	}
	
	static void show_table() {
		// print the table
		for (int i = 0; i < table_size; i++) {
			System.out.print("\n");    // new line
			for (int j = 0; j < table_size; j++) {
				show_sym(table[j][i]);    // show symbol
				System.out.print(" ");    // space
			}
		}
		System.out.print("\n");    // new line
		System.out.print("\n");    // Space
	}
	
	static void show_sym(int x) {
		if (x == 0){
			System.out.print("_");
		}else if(x == 1) {
			System.out.print("O");
		}else if(x == 2) {
			System.out.print("X");
		}
	}
	
	public static void action(int x, int y) {	
		check_action(x, y);
	}

	static void check_action(int x,int y) {
		// checking this action can do or not
		int n = table[y][x];
		if (!game_end) {
			if (n == 0) {
				table[y][x] = player_turn;
				// check win,tie
				check_win();
				check_draw();
				// change turn and add turn counter
				change_turn();
	
			}else {
				System.out.println("You can not action this cell.");
			}
			show_table();
		}else {  // If game is ended
			System.out.println("Game are Ended.");
		}
	
	}
	
	static void change_turn() {
		if (player_turn == 1) {
			player_turn = 2;
		}else if(player_turn == 2) {
			player_turn = 1;
		}turn_count++;
	}
	
	static void check_win() {
		int d1 =0; // diagonal_win ULtoDR counter
		int d2 =0; // diagonal_win URtoDL counter
		for(int i=0;i<table_size;i++) {
			int h =0; // horizon_win counter
			int v =0; // vertical_win counter			
			for(int j=0;j<table_size;j++) {
				if(table[i][j] == player_turn) {  // horizon_win
					h++;
				}if(table[j][i] == player_turn) { // vertical_win 
					v++;
				}
			}if(h == table_size || v == table_size) { // If someone win the game on horizon or vertical
				game_end = true;
				winner = player_turn;
				show_winner();
			}if(table[i][i] == player_turn) {  // diagonal_win ULtoDR
				d1++;
			}if(table[i][table_size-1-i] == player_turn) {  // diagonal_win URtoDL
				d2++;
			}
		}if(d1 == table_size || d2 == table_size) { // If someone win the game on diagonal
			game_end = true;
			winner = player_turn;
			show_winner();
		}
		
	}
	
	static void check_draw() {
		int n = table_size*table_size;
		if (turn_count == n) {
			game_end = true;
			winner = 3;  // It is a tie.
			show_draw();
		}
	}
	
	private static void show_draw() {
		show_table();
		System.out.println("Draw!");
	}

	static void show_winner() {
	    show_table();
		System.out.println("Player " + String.valueOf(winner) + " Win!");
	}
	
	void change_table_size(int n) {
		table_size = n;
		table = new int[table_size][table_size]; 
		turn_count = 1;
		player_turn = 1;
		reset_table();
		show_table();
	}
	
	int get_data(int x, int y) {
		return table[x][y];
	}
	
	int get_turn() {
		return player_turn;
	}
	
	int get_winner() {
		return winner;
	}
	
	
	
	public void save_file() {
		// Convert data in the table to String then save to file
		try {  
			// try to run the code (It's trying if have any errors will skip to catch())
			FileWriter myWriter = new FileWriter("save.txt");  // open file
			String save = "";  // declare String save
			for (int i = 0; i < table_size; i++) {
					for (int j = 0; j < table_size; j++) {
						save += get_data(j , i);    // what in table  swap i,j cuz it (y,x)
						save += " ";    // space for ez to read on text file
					}if (i != table_size -1) {
						save += "\n";    // new line for table but do not on last row
					}
			}
		myWriter.write(save);  // add every thing in String save to file
		myWriter.close();  // close file
		System.out.println("Successfully wrote to the file.");
	    }
		catch (IOException e) {
	    // If can not run every code in try, run code below
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	    }
	}
	
	public void load_file() {
		// Convert data in the file to the table
		try {
		      File save = new File("save.txt");  // open file
		      Scanner myReader = new Scanner(save);  // declare file reader 
		      String line = myReader.nextLine();  // load 1st line or next line
		      System.out.println(line);
		      // Find size of table
		      String[] l = line.split(" ");  // Split line with " " then add to array
		      int length = l.length;  // find size of table
		      int[][] load = new int[length][length];  // declare array 2D for table
	    	  int line_counter = 0;  // it's counter how many line
	    	  
	    	  // add 1st row
	    	  for(int i=0;i<length;i++) {
	    		  load[line_counter][i] = Integer.parseInt(l[i]);  // load cell to table
	    	  }line_counter++;	 
	    	  
	    	  // add other row 
		      while (line_counter < length ) {
		    	  	line = myReader.nextLine();
		    	  	System.out.println(line);
		    	  	l = line.split(" ");  // Split line for each row
			    	for(int i=0;i<length;i++) {
			    		load[line_counter][i] = Integer.parseInt(l[i]);  // load cell to table
			    	}
			    	line_counter++;
		      }
		      myReader.close();  // close file
		      System.out.println();
		      
		      // convert to table  
		      int turn = 0;  // counter for finding who next action
		      for(int i=0;i<length;i++) {
		    	  for(int j=0;j<length;j++) {
		    		  // this comment for change size table if "save.txt" have another size
		    		  // But now it's having some errors, Don't focus it.
//		    		  change_table_size(length);
//		    		  UI = new GUI(length,this);
		    		  table[j][i] = load[i][j];  // swap(x,y) coz in table it is (y,x)
		    		  if(load[i][j] != 0) {  
		    			  // checking how many turn pass
		    			  turn++;	
		    			  
		    		  }
		    	  }
		      }
		      // Up date other data
		      if(turn%2 == 0) {
		    	  // find who next
		    	  player_turn = 1; 
		      }else player_turn = 2;
		      // Setting other data
		      game_end = false;
		      turn_count = turn+1;
		      winner = 0;
		      UI.update(); // Update GUI
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
	}
	
	private String change_to_form(int d) {
		if (d == 0) {
			return "n";
		}else if(d == 1) {
			return "o";
		}else if(d == 2) {
			return "x";
		}
		return null;  // return null if wrong arg
	}
	
	private int change_form_to_data(char c) {
		if (c == 'n') {
			return 0;
		}else if(c == 'o') {
			return 1;
		}else if(c == 'x') {
			return 2;
		}
		return 0;  // return 0 if wrong arg
	}
	
	public void save_file_on_form() {
		// Convert data in the table to String then save to file
		try {  
			// try to run the code (It's trying if have any errors will skip to catch())
			FileWriter myWriter = new FileWriter("save.txt");  // open file
			String save = "";  // Find what in data
			for (int i = 0; i < table_size; i++) {
					for (int j = 0; j < table_size; j++) {
						save += change_to_form(get_data(j , i));    // what in table  swap i,j cuz it (y,x)
					}
			}
			
			// Write save of game
			String save_game = "" ;  							// declare String for save
			save_game += Integer.toString(table_size) + "\n";  	// add table size
			save_game += save + "\n";							// save table
			save_game += change_to_form(player_turn) + "\n";		// save player turn
			save_game += Integer.toString(turn_count-1);		// save turn_counter (-1 coz it start with 0)
					
		myWriter.write(save_game);  // add every thing in String save to file
		myWriter.close();  // close file
		System.out.println("Successfully wrote to the file.");
	    }
		catch (IOException e) {
	    // If can not run every code in try, run code below
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	    }
	}
	
	public void load_file_on_form() {
		// Convert data in the file to the table
		try {
		      File save = new File("save.txt");  		// open file
		      Scanner myReader = new Scanner(save); 	// declare file reader 
		      String line = myReader.nextLine();  		// load 1st line or next line
		      int size = Integer.parseInt(line);			// covert to int
		      System.out.println(size);
		      int[][] load = new int[size][size];  		// declare array 2D for table
		      
		      line = myReader.nextLine();				// load next line
		      int pointer = 0;
		      for(int i=0;i<size;i++) {
			    	for(int j=0;j<size;j++) {
			    			load[i][j] = change_form_to_data(line.charAt(pointer));  // load what in table
			    			pointer++;
			    		}	
			    	}
		      
		      line = myReader.nextLine();								// load next line
		      player_turn = change_form_to_data(line.charAt(0)) ;		// turn of player 
		      System.out.println(player_turn);
	      
		      line = myReader.nextLine();								// load next line
		      turn_count = Integer.parseInt(Character.toString(line.charAt(0))) + 1;		// +1 cuz data start with 1
		      System.out.println(turn_count);
		      
		      myReader.close();  // close file
			      
		      // convert to table  	     
		      for(int i=0;i<size;i++) {
		    	  for(int j=0;j<size;j++) {
		    		  table[j][i] = load[i][j];  // swap(x,y) coz in table it is (y,x)
		    		  System.out.println(load[i][j]);
		    	  }
		      }
		      show_table();
		      
		      // Up date other data
		      game_end = false;
		      winner = 0;
		      UI.update(); // Update GUI
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
	}
	
	public static void main(String[] args) {
//		main_loop();  // loop for command line play
		int size = 4;
		Model table = new Model();
		table.change_table_size(size);
		View gui = new View(size, table);  // test
		table.UI = gui;
		
//		table.save_file();
//		table.load_file();
//		table.show_table();
		 
	}
	
		
}
