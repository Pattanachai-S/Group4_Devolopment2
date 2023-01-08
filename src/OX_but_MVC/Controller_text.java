package OX_but_MVC;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;



public class Controller_text {
	
	Model table;
	View_text UI;
	Controller_text control = this;
	Scanner input = new Scanner(System.in);  // For in put
	
	Controller_text(int size){
		// Create Model
		table = new Model(this);
		table.change_table_size(size);
		// Create GUI
		UI = new View_text(size, this);  // test
		main_loop();

		
	}
	
	public void main_loop() {
		UI.show_table();
		while(!table.get_game_end()) {
			UI.show_table();
			wait_action();
			check_game();
		}
	}
	
	
	private void wait_action() {
		UI.show_player_turn();
		String s = input.nextLine();
		try {
			// Convert string to int 
			String[] a = s.split(" ");
			int[] n = {Integer.valueOf(a[0]),Integer.valueOf(a[1])};
			table.action(n[1]-1,n[0]-1);  // swap index because on table it's a (y,x)
			}
		catch(Exception e) {
			if (s.equals("e")) {  // If input is e, game will end
				System.out.print("Exit.");
				table.set_game_end();
			}else
			System.out.println("Try agian.");
		}
	}
	
	private void check_game() {
		int winner = table.get_winner();
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
		return table;
	}
	
	/* Event for reset button */
	public void event_reset(ActionEvent e) {
		table.reset_table();
		UI.update();	
		System.out.println("Reset.");
	}
	
	/* Event for save button */
	public void event_save(ActionEvent e) {
		table.save_file_on_form();
		UI.update();
		System.out.println("Save.");
	}
	
	/** Event for load button */
	public void event_load(ActionEvent e) {
		table.load_file_on_form();
		UI.update();
		System.out.println("Load.");
	}
	
	/** Event for show winner */
	public void event_winner(ActionEvent e) {
		int winner = table.get_winner();
		UI.show_winner(winner);
	}
	
	/** Event for show winner */
	public void event_draw(ActionEvent e) {
		UI.show_draw();
	}
	
	public static void main(String[] args) {		
		int size = 2;  // Change table size here
		Controller_text control = new Controller_text(size);
		
	}
}
