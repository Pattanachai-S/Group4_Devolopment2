package OXGames;

public class Main {
	
	static int[][] table = new int[3][3]; 
	
	public static void main(String[] args) {
	    Main main = new Main();
	    create_table();
	    show_table();
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
	
	
		
	
}
