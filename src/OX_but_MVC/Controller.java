package OX_but_MVC;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

// Run project on this class
public class Controller implements ActionListener{
	MouseListener mouse_listener = new MouseListener();
	Model table;
	View GUI;
	
	Controller(int size){
		// Create Model
		table = new Model();
		table.change_table_size(size);
		// Create GUI
		GUI = new View(size, this);  // test
		table.UI = GUI;

		
	}
	
	/* for all event */
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
	
	/** event when mouse clicked*/
	public void mouseClicked(MouseEvent e) 
    {
        // Finds the location of the mouse
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();

        // Gets the x -> and y co-ordinates
        int x = (int) b.getX();
        int y = (int) b.getY();
        System.out.println("Mouse x: " + x);
        System.out.println("Mouse y: " + y);

//        // Determines which tile the click occured on
//        int xTile = x/tileSize;
//        int yTile = y/tileSize;
//
//        System.out.println("X Tile: " + xTile);
//        System.out.println("Y Tile: " + yTile);

    }
	
	/* Even for reset button */
	public void event_reset(ActionEvent e) {
		table.reset_table();
		GUI.update();	
	}
	
	/* Even for save button */
	public void event_save(ActionEvent e) {
		table.save_file_on_form();
		GUI.update();
	}
	
	/** Even for load button */
	public void event_load(ActionEvent e) {
		table.load_file_on_form();
		GUI.update();
	}
	
	/** Return Model. */
	public Model get_model() {
		
		return table;
	}
	
	
	public static void main(String[] args) {
		int size = 4;
		Controller control = new Controller(size);

		
	}
	
	private class MouseListener extends MouseAdapter 
	{
		PointerInfo info;
		Point location ;
	    public void mouseClicked(MouseEvent e) 
	    {
	        // Finds the location of the mouse
	    	info = MouseInfo.getPointerInfo();
	    	location = info.getLocation();
	        int x = (int) location.getX();
	        int y = (int) location.getY();
	        System.out.println("Mouse : " + x+","+ y);
	    }
	}
}