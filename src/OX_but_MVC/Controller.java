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
	Controller control = this;
	
	Controller(int size){
		// Create Model
		table = new Model(this);
		table.change_table_size(size);
		// Create GUI
		GUI = new View(size, this);  // test

		
	}
	
	/* for all event 
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
	} */
	
	
	/* Event for reset button */
	public void event_reset(ActionEvent e) {
		table.reset_table();
		GUI.update();	
		System.out.println("Reset.");
	}
	
	/* Event for save button */
	public void event_save(ActionEvent e) {
		table.save_file_on_form();
		GUI.update();
		System.out.println("Save.");
	}
	
	/** Event for load button */
	public void event_load(ActionEvent e) {
		table.load_file_on_form();
		GUI.update();
		System.out.println("Load.");
	}
	
	/** Event for show winner */
	public void event_winner(ActionEvent e) {
		String winner = table.get_winner_on_text();
		GUI.show_popUp(winner + " is Winner!");
	}
	
	/** Event for show winner */
	public void event_draw(ActionEvent e) {
		GUI.show_popUp("The game is tied!");
	}
	
	public void GUI_update() {
		GUI.update();
	}
	
	/** Return Model. */
	public Model get_model() {
		return table;
	}
	
	public void action_from_mouse(int x,int y) {
		int[] pos = getRowandCol(x,y);
		int pos0 = pos[0];
		int pos1 = pos[1];
        if(table.action(pos1,pos0)) {  // switch x-y couz model table
        	GUI.paint_grid(pos0,pos1,table.get_turn());
            GUI.update();
        }
        
	}
	
	public int[] getRowandCol(int xPosition, int yPosition){
        float size_x = GUI.get_sizeX_grid();
        float size_y = GUI.get_sizeY_grid();
        float cellSzX = size_x/table.get_table_size();
        float cellSzY = size_y/table.get_table_size();
        int CellRow = (int) (xPosition/cellSzX);
        int CellCol = (int) (yPosition/cellSzY);
        int[] result = new int[2];
        result[0] = CellRow;
        result[1] = CellCol;
        System.out.println("(row,col):" + "(" + CellRow + "," + CellCol + ")"); //test
        return result;
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
//	        int x = (int) location.getX();
//	        int y = (int) location.getY();
	    	int x = (int) e.getX();
	    	int y = (int) e.getY();
	        System.out.println("Mouse : " + x+","+ y);
	        control.action_from_mouse(x,y);
	    }
	}
	
	
	
	
	public static void main(String[] args) {		
		int size = 4;  // Change table size here
		Controller control = new Controller(size);		
	}
	
}
