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
	
	
	/* Even for reset button */
	public void event_reset(ActionEvent e) {
		table.reset_table();
		GUI.update();	
		System.out.println("Reset.");
	}
	
	/* Even for save button */
	public void event_save(ActionEvent e) {
		table.save_file_on_form();
		GUI.update();
		System.out.println("Save.");
	}
	
	/** Even for load button */
	public void event_load(ActionEvent e) {
		table.load_file_on_form();
		GUI.update();
		System.out.println("Load.");
	}
	
	/** Even for show winner */
	public void event_winner(ActionEvent e) {
		String winner = table.get_winner_on_text();
		GUI.show_popUp(winner + " is Win!");
	}
	
	/** Even for show winner */
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
        table.action(pos[0],pos[1]);  // switch x-y couz model table
        GUI.update();
	}
	
	public int[] getRowandCol(int xPosition, int yPosition){
        float size_x = GUI.get_sizeX_grid();
        float size_Y = GUI.get_sizeY_grid();
        //float cellSz = size_x/table.get_table_size();
        int CellRow = (int) (xPosition/size_x);
        int CellCol = (int) (yPosition/size_Y);
        int[] result = new int[2];
        result[0] = CellRow;
        result[1] = CellCol;
        System.out.println("(row,col):" + "(" + CellRow + "," + CellCol + ")"); //test
        return result;
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
	        control.action_from_mouse(x,y);
	        
	    }
	}
}