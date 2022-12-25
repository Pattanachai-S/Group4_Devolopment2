package OX_but_MVC;
import java.awt.*;
import java.awt.event.*;

// Run project on this class
public class Controller implements ActionListener{
	Model table;
	View GUI;
	
	Controller(int size){
		// Create Model
		table = new Model();
		table.change_table_size(size);
		// Create GUI
		GUI = new View(size, table,this);  // test
		table.UI = GUI;

		
	}
	
	// for all event
	public void actionPerformed(ActionEvent e) {   // This run when having any event in-game  
		//  loop for checking all buttons in the table
		for(int i=0;i<table.table_size;i++) {
			for(int j=0;j<table.table_size;j++) {
				if(e.getSource()==GUI.buttons[i][j]) {  
					// If having an event on this button
					this.table.action(i, j);  // run action(x,y) on this button
				}
			}
		}
		GUI.update();  // Update everything to GUI
	}
	
	public static void main(String[] args) {
		int size = 4;
		Controller control = new Controller(size);

		
	}
	
	
}