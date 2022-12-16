package OXGames;
import java.util.Scanner;  // For input

public class Main {
	
	static int[][] table = new int[3][3]; 
	static int player = 1;
	static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	static boolean game_end = false; 
	static int winner;
	static int turn_count = 1;
	
	public static void main(String[] args) {
	    create_table();
	    main_loop();
	  }
	
	public static void main_loop() {
		while(!game_end) {
			 show_table();
			 wait_action();
		}
	}
	
	public static void wait_action() {
		System.out.print("Turn player "+String.valueOf(player) +": ");
		String c = myObj.nextLine();
		if (c == "e") {
			game_end = true;
		}
		int a;
		try {
			a = Integer.valueOf(c);  // Convert string to int
			}
			catch(Exception e) {
			a = 99; // to wrong number and said "try again."
			}
		
		action(a, player);
	}
	
	static void create_table() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = 0;
			}
		}
	}
	
	static void show_table() {
		for (int i = 0; i < 3; i++) {
			System.out.print("\n");    // new line
			for (int j = 0; j < 3; j++) {
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
	
	static void action(int n,int player) {
		n = n-1;
		if (n/3 >=3 || n/3 < 0 ) {   // Have no cell
			System.out.print("Try agian.");
		}else if (n/3 >=2 ) {    // cell 7 8 9
			check_action(0,n%3, player);
		}else if (n/3 >=1 ) {    // cell 4 5 6
			check_action(1,n%3, player);
		}else if (n/3 >=0 ) {    // cell 1 2 3
			check_action(2,n%3, player);
		}else {
			System.out.print("Try agian.");
		}

	}
	
	static void check_action(int x,int y,int a) {
		int n = table[x][y];
		if (n == 0) {
			table[x][y] = a;
			check_win();
			check_draw();
			change_turn();
		}else {
			System.out.print("You can not action this cell.");
		}
	}
	
	static void change_turn() {
		if (player == 1) {
			player = 2;
		}else if(player == 2) {
			player = 1;
		}turn_count++;
	}
	
	static void check_win() {
		int d1 =0; // diagonal_win ULtoDR counter
		int d2 =0; // diagonal_win URtoDL counter
		for(int i=0;i<3;i++) {
			int h =0; // horizon_win counter
			int v =0; // vertical_win counter			
			for(int j=0;j<3;j++) {
				if(table[i][j] == player) {  // horizon_win
					h++;
				}if(table[j][i] == player) { // vertical_win 
					v++;
				}
			}if(h == 3 || v == 3) { // If someone win the game on horizon or vertical
				game_end = true;
				winner = player;
				show_winner();
			}if(table[i][i] == player) {  // diagonal_win ULtoDR
				d1++;
			}if(table[i][2-i] == player) {  // diagonal_win URtoDL
				d2++;
			}
		}if(d1 == 3 || d2 == 3) { // If someone win the game on diagonal
			game_end = true;
			winner = player;
			show_winner();
		}
		
	}
	
	static void check_draw() {
		if (turn_count == 9) {
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
		
		
}
