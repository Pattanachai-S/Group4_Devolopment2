package OX_but_MVC;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;



public class Controller_text {
	
	Model model;
	View_text UI;
	Controller_text control = this;
	Scanner input = new Scanner(System.in);  // For in put
	
	Controller_text(int size){
		// Create Model
		model = new Model();
		model.change_table_size(size);
		// Create GUI
		UI = new View_text(size, this);  // test
		main_loop();

		
	}
	
	public void main_loop() {
		while(!model.get_game_end()) {
			UI.show_table();
			get_input();
			check_game();
		}
	}
	
	
	private void get_input() {
		UI.show_player_turn();
		String s = input.nextLine();
		try {
			// Convert string to int 
			String[] a = s.split(" ");
			int[] n = {Integer.valueOf(a[0]),Integer.valueOf(a[1])};
			model.action(n[1]-1,n[0]-1);  // swap index because on table it's a (y,x)
			}
		catch(Exception e) {
			if (s.equals("e")) {  // If input is e, game will end
				System.out.print("Exit.");
				model.set_game_end();
			}else if (s.equals("save")) {  // If input is save, game will end				
				model.save_file_on_form();
				System.out.print("Game saved.");
			}else if (s.equals("load")) {  // If input is load, game will end				
				model.load_file_on_form();
				System.out.print("Game loaded.");
			}else if (s.equals("reset")) {  // If input is reset, game will end				
				model.reset_table();
				System.out.print("Reset game.");
			}else 
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
