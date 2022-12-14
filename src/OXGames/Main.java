package OXGames;
import java.util.Scanner;  // For input

public class Main {
	
	static int[][] table = new int[3][3]; 
	static int player = 1;
	static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) {
	    Main main = new Main();
	    create_table();
	    show_table();
	    show_table();
	    main_loop();
	  }
	
	public static void main_loop() {
		while(true) {
			 show_table();
			 wait_action();
		}
	}
	
	public static void wait_action() {
		System.out.print("Turn player "+String.valueOf(player) +": ");
		String c = myObj.nextLine();
		int a = Integer.valueOf(c);  // Convert string to int
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
		if (n/3 >=2 ) {
			check_action(0,n%3, player);
		}else if (n/3 >=1 ) {
			check_action(1,n%3, player);
		}else if (n/3 >=0 ) {
			check_action(2,n%3, player);
		}else {
			System.out.print("Try agian.");
		}
			
	}
	
	static void check_action(int x,int y,int a) {
		int n = table[x][y];
		if (n == 0) {
			table[x][y] = a;
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
		}
	}
	
	
		
	
}
