package OX_but_MVC;

public class View_text {
	Controller_text control;
	int table_size;
	
	
	View_text(int size){
		table_size = size;

	}
	
	public void show_table() {
		// print the table
		for (int i = 0; i < table_size; i++) {
			System.out.print("\n");    // new line
			for (int j = 0; j < table_size; j++) {
				System.out.print(player_to_text(control.get_model().get_data(j, i)));    // show symbol
				System.out.print(" ");    // space
			}
		}
		System.out.print("\n");    // new line
//		System.out.print("\n");    // Space
	}
	
	public void show_draw() {
		show_table();
		System.out.println("Draw!");
	}

	public void show_winner(int winner) {  
	    if (winner == 3) {  // if game is tie	
	    	show_draw();
	    }else {  // if have a winner
	    	show_table();
	    	System.out.println("Player " + player_to_text(winner) + " Win!");
	    }
		
	}
	
	private String player_to_text(int p) {
		if (p == 0){
			return ("_");
		}else if(p == 1) {
			return("O");
		}else if(p == 2) {
			return("X");
		}return "";
	}
	
	public void update() {
		show_table();
	}

	public void show_player_turn() {
		System.out.println("Turn player "+String.valueOf(control.get_model().get_turn()));		
	}
	
	public void show_get_input() {
		System.out.print("(row col,save,load,reset)Input: ");
	}
}
