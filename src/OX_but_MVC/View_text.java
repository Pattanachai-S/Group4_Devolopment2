package OX_but_MVC;

public class View_text {
	private int table_size;
	private Model model;
	
	View_text(Model model){
		table_size = model.get_size();
		this.model = model;
	}
	
	public void show_table() {
		// print the table
		for (int i = 0; i < table_size; i++) {
			System.out.print("\n");    // new line
			for (int j = 0; j < table_size; j++) {
				System.out.print(player_text_to_print(model.get_valueOFboard(j, i)));    // show symbol
				System.out.print(" ");    // space
			}
		}
		System.out.print("\n");    // new line
//		System.out.print("\n");    // Space
	}

	private String player_text_to_print(String p){
		if (p.equals("N")){
			return "_";

		}else{
			return p;
		}
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
		System.out.println("Turn player "+String.valueOf(model.get_player()));		
	}
	
	public void show_get_input() {
		System.out.print("(row col,save,load,reset)Input: ");
	}
}
