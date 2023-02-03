package OX_but_MVC;
import java.util.Scanner;  // For input
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Model {
	
	int table_size = 4;
	int[][] table = new int[table_size][table_size]; 	
	boolean game_end = false; 
	int winner;
	int turn_count = 1;
	int player_turn = 1;
	
	Model(int size){
		change_table_size(size);
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
	
	public boolean fill_table(int x,int y) {
		// checking this action can do or not
		boolean ac = false;
		int n = table[y][x];
		if (!game_end) {
			if (n == 0) {
				table[y][x] = player_turn;
				ac = true;
				// check win,tie
				check_win();
				check_draw();
				// change turn and add turn counter
				change_turn();
			}else {
				
			}
		}
		return ac;
	}
	
	public void change_turn() {
		if (player_turn == 1) {
			player_turn = 2;
		}else if(player_turn == 2) {
			player_turn = 1;
		}turn_count++;
	}
	
	private void check_win() {
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
			}if(table[i][i] == player_turn) {  // diagonal_win ULtoDR
				d1++;
			}if(table[i][table_size-1-i] == player_turn) {  // diagonal_win URtoDL
				d2++;
			}
		}if(d1 == table_size || d2 == table_size) { // If someone win the game on diagonal
			game_end = true;
			winner = player_turn;
		}
		
	}
	
	private void check_draw() {
		int n = table_size*table_size;
		if ((turn_count == n) && (game_end == false)) {
			game_end = true;
			winner = 3;  // It is a tie.
		}
	}
		
	public void change_table_size(int n) {
		table_size = n;
		table = new int[table_size][table_size]; 
		turn_count = 1;
		player_turn = 1;
		reset_table();
	}
	
	public int get_data(int x, int y) {
		return table[x][y];
	}
	
	public int get_table_size() {
		return table_size;
	}
	
	public int get_player_turn() {
		return player_turn;
	}
	
	public int get_winner_on_int() {
		return winner;
	}
	
	public boolean get_game_end() {
		return game_end;
	}

	
	public String get_winner() {
		if (winner == 1) {
			return "O";
		}else if (winner == 2) {
			return "X";
		}else if (winner == 3) {
			return "TIE";
		}else{
			return "";
		}
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
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
	}
	
	private String player_int_to_string(int d) {
		if (d == 0) {
			return "n";
		}else if(d == 1) {
			return "o";
		}else if(d == 2) {
			return "x";
		}
		return null;  // return null if wrong arg
	}
	
	private int player_char_to_int(char c) {
		if (c == 'n') {
			return 0;
		}else if(c == 'o') {
			return 1;
		}else if(c == 'x') {
			return 2;
		}
		return 0;  // return 0 if wrong arg
	}

	private int player_string_to_int(String s){
		s = s.toLowerCase();
		if (s == "n") {
			return 0;
		}else if(s == "o") {
			return 1;
		}else if(s == "x") {
			return 2;
		}
		return 0;  // return 0 if wrong arg
	}
	
	
	public void save() {
		// Convert data in the table to String then save to file
		try {  
			// try to run the code (It's trying if have any errors will skip to catch())
			FileWriter myWriter = new FileWriter("save.txt");  // open file
			String save = "";  // Find what in data
			for (int i = 0; i < table_size; i++) {
					for (int j = 0; j < table_size; j++) {
						save += player_int_to_string(get_data(j , i));    // what in table  swap i,j cuz it (y,x)
					}
			}
			
			// Write save of game
			String save_game = "" ;  							// declare String for save
			save_game += Integer.toString(table_size) + "\n";  	// add table size
			save_game += save + "\n";							// save table
			save_game += player_int_to_string(player_turn) + "\n";		// save player turn
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
	
	public void load() {
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
			    			load[i][j] = player_char_to_int(line.charAt(pointer));  // load what in table
			    			pointer++;
			    		}	
			    	}
		      
		      line = myReader.nextLine();								// load next line
		      player_turn = player_char_to_int(line.charAt(0)) ;		// turn of player 
		      System.out.println(player_turn);
	      
		      line = myReader.nextLine();								// load next line
		      turn_count = Integer.parseInt(Character.toString(line.charAt(0))) + 1;		// +1 cuz data start with 1
		      System.out.println(turn_count);
		      
		      myReader.close();  // close file
			      
		      // convert to table  	     
		      for(int i=0;i<size;i++) {
		    	  for(int j=0;j<size;j++) {
		    		  table[j][i] = load[i][j];  // swap(x,y) coz in table it is (y,x)
		    	  }
		      }
		      
		      // Up date other data
		      game_end = false;
		      winner = 0;
		} 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
	}

	// After this it for co-OXGame

	public int get_turn(){
		return turn_count-1; // -1 becouse other group need, how many turn pass.
	}

	public String get_player(){
		return player_int_to_string(get_player_turn()).toUpperCase();
	}

	public String get_valueOFboard(int row,int col){
		return player_int_to_string(get_data(row,col)).toUpperCase();
	}

	public void change_valueOFboard(int row, int col, String value){
		table[row][col] = player_string_to_int(value);
	}

	public int get_size(){
		return get_table_size();
	}

	// IDK what get board lenght do?

	// change_turn() already have

	public void new_game(){
		reset_table();
	}

	public void Action(int row, int col){
		fill_table(row,col);
	}
	
	
	public static void main(String[] args) {

	}
	
		
}
