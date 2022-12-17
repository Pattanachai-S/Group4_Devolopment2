package OXGames;
import java.util.Scanner;  // For input
import OXGames.GUI;

public class Main {
	
	static int table_size = 5;
	static int[][] table = new int[table_size][table_size]; 
	static int player_turn = 1;
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	static boolean game_end = false; 
	static int winner;
	static int turn_count = 1;
	
	Main(){
		create_table();
	}
	
	public static void main_loop() {
		while(!game_end) {
			 show_table();
			 wait_action();
		}
	}
	
	public static void wait_action() {
		System.out.print("Turn player "+String.valueOf(player_turn) +": ");
		String s = input.nextLine();
		try {
			// Convert string to int 
			String[] a = s.split(" ");
			int[] n = {Integer.valueOf(a[0]),Integer.valueOf(a[1])};
			action(n[0],n[1]);
			
			// Convert string to int for num-pad
//			int a = Integer.valueOf(c);  
//			action_numpad(a);
			}
		catch(Exception e) {
			if (s.equals("e")) {  // If input is e, game will end
				game_end = true;
				System.out.print("Exit.");
			}else
			System.out.print("Try agian.");
		}	
	}
	
	private static char[] type(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	static void create_table() {
		for (int i = 0; i < table_size; i++) {
			for (int j = 0; j < table_size; j++) {
				table[i][j] = 0;
			}
		}
	}
	
	static void show_table() {
		for (int i = 0; i < table_size; i++) {
			System.out.print("\n");    // new line
			for (int j = 0; j < table_size; j++) {
				show_sym(table[i][j]);    // show symbol
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
	
	static void action_numpad(int n) {
		n = n-1;
		if (n/3 >=3 || n/3 < 0 ) {   // Have no cell
			System.out.print("Try agian.");
		}else if (n/3 >=2 ) {    // cell 7 8 9
			check_action(0,n%3);
		}else if (n/3 >=1 ) {    // cell 4 5 6
			check_action(1,n%3);
		}else if (n/3 >=0 ) {    // cell 1 2 3
			check_action(2,n%3);
		}else {
			System.out.print("Try agian.");
		}
	}
	
	static void action(int x, int y) {
		
		check_action(x-1, y-1);
	}
	
	
	
	static void check_action(int x,int y) {
		int n = table[y][x];
		if (n == 0) {
			table[y][x] = player_turn;
			check_win();
			check_draw();
			change_turn();

		}else {
			System.out.print("You can not action this cell.");
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
	
	public static void main(String[] args) {
		 main_loop();  // loop for command line play
//		 GUI game = new GUI(3);  // test
	}
	
		
}
