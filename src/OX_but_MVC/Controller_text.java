package OX_but_MVC;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;



public class Controller_text {
	
	Model model;
	View_text UI;
	Controller_text control = this;
	Scanner input = new Scanner(System.in);  // For in put
	boolean stop_loop = false;  // Boolean of stop main loop
	
	Controller_text(int size){
		// Create Model
		model = new Model();
		model.change_table_size(size);
		// Create GUI
		UI = new View_text(size, this);  // test
		main_loop();

		
	}
	
	public void main_loop() {
		while(!stop_loop) {
			UI.show_table();
			get_input();
			check_game();
		}
	}
	
	
	private void get_input() {
		if (!model.get_game_end()) {
			// If game still playing
			UI.show_player_turn();
		}else {
			// If game is already end
			UI.show_winner((model.get_winner()));
		}
		
		UI.show_get_input();  // show input command :
		String s = input.nextLine();
		try {
			// Convert string to int 
			String[] a = s.split(" ");
			int[] n = {Integer.valueOf(a[0]),Integer.valueOf(a[1])};
			model.fill_table(n[0]-1,n[1]-1);  // input is (y, x) and table it's a (y,x)
			}
		catch(Exception e) {
			if (s.equals("e") || s.equals("exit")) {  
				// If input is e, game will end
				model.set_game_end();
				System.out.print("Exited.");
				stop_loop = true;
				
			}else if (s.equals("s") || s.equals("save")) {
				// If input is s, game will save	
				model.save_file_on_form();
				System.out.print("Game saved.");
				
			}else if (s.equals("l") || s.equals("load")) { 
				// If input is l, game will load		
				model.load_file_on_form();
				System.out.print("Game loaded.");
				
			}else if (s.equals("r") || s.equals("reset")) {  
				// If input is r, game will reset		
				model.reset_table();
				System.out.print("Reset game.");
				
			}else 
				// If input can not match, it will let user take input again
				System.out.println("Try agian.");
		}
	}
	
	private void check_game() {
		int winner = model.get_winner();
		if(winner != 0) {
			if (winner == 3) {
				// If game is draw.
				UI.show_draw();
			}else {
			// If got a winner
				UI.show_winner((winner));
			}
		}
	}
	
	
	/** Return Model. */
	public Model get_model() {
		return model;
	}
	
	/* Event for reset button */
	public void event_reset(ActionEvent e) {
		model.reset_table();
		UI.update();	
		System.out.println("Reset.");
	}
	
	/* Event for save button */
	public void event_save(ActionEvent e) {
		model.save_file_on_form();
		UI.update();
		System.out.println("Save.");
	}
	
	/** Event for load button */
	public void event_load(ActionEvent e) {
		model.load_file_on_form();
		UI.update();
		System.out.println("Load.");
	}
	
	/** Event for show winner */
	public void event_winner(ActionEvent e) {
		int winner = model.get_winner();
		UI.show_winner(winner);
	}
	
	/** Event for show winner */
	public void event_draw(ActionEvent e) {
		UI.show_draw();
	}
	
	public static void main(String[] args) {		
		int size = 3;  // Change table size here
		Controller_text control = new Controller_text(size);
		
	}
}
