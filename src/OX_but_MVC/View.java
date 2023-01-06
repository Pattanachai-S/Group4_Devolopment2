package OX_but_MVC;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import testGUI.Grid;
//import testGUI.View;

class Grid extends JPanel{
	
    float tableSize = 4;
    float width = 570;
    float height = 570;
    float rowHt = height / (tableSize);
    float rowWid = width / (tableSize);
    private View myview;
    
    Grid(int size,View view) {
    	tableSize = size;
    	this.myview = view;
    	change_size();
    }
    
    void change_size(){
    	width = 570;
        height = 570;
        rowHt = height / (tableSize);
        rowWid = width / (tableSize);
    }

    void drawGrid(Graphics g){
      Graphics2D g2d = (Graphics2D) g;
      g.setColor(Color.black);
      g2d.setStroke(new BasicStroke(2));  // size of line
      // draw the rows
      for (int i = 0; i < tableSize+1; i++){
        g2d.draw(new Line2D.Float(0, i * rowHt, width, i * rowHt));
      }
        
      // draw the columns
      for (int i = 0; i < tableSize+1; i++){
        g2d.draw(new Line2D.Float(i * rowWid, 0, i * rowWid, height));
      }

    }
    
    
    
    public void paint(Graphics g) {
    	super.paintComponent(g);  // Call the paintComponent method of the superclass
        drawGrid(g);  // Draw the line for table
        myview.draw(g);  // Call the draw method of the View class
        myview.update(g);
        repaint();  // repeat this method all time
        
        // for see console is running.
        /*  
        System.out.println("1");
        System.out.println("111");
        System.out.println("11111");
        */
        
    }   

    /** Draw X*/
	public static void paintX(Graphics g,int x,int y, int r) {
		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
		int s = (int) (r*0.1);  // size
		g2.setStroke(new BasicStroke(s));
		r = (int) (r*0.7);  // reduse size
		g2.drawLine(x-r/2, y-r/2, x+r/2, y+r/2);	// it is ULtoDR
		g2.drawLine(x+r/2, y-r/2, x-r/2, y+r/2);	// it is URtoDL
		
	}
	
	/** Draw O*/ 
	public static void paintO(Graphics g,int x,int y, int r) {
		g.setColor(Color.blue);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.blue);
		int s = (int) (r*0.1);  // size
		g2.setStroke(new BasicStroke(s));
		r = (int) (r*0.7);// reduse size
		g2.drawRoundRect(x-r/2, y-r/2, r, r, r, r);  // x, y, height, width, round edges, round edges
		
	}
    
    public void update(){
    	
    }
   
}


public class View extends JFrame{

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JPanel title_panel = new JPanel(new BorderLayout());;
    JPanel buttontPanel = new JPanel(new GridLayout(1,3));
    Grid grid;
    JButton resetbutoon = new JButton();
    JButton savebutton = new JButton();
    JButton loadbutton = new JButton();
    static Graphics graphics;
    Controller control;

    View(int size, Controller c){
    	
    	control = c;
    	float tableSize = size;
    	grid = new Grid(size,this);
  	
        frame.setSize(605, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(47, 93, 98));
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);


        title_panel.setBackground(Color.BLUE);
        title_panel.setBounds(10, 10, 570, 125);
        
        buttontPanel.setBackground(Color.ORANGE);
        buttontPanel.setBounds(10, 135, 570, 50);

        //boardPanel.setBackground(Color.PINK);
        //boardPanel.setBounds(10, 185, 570, 570);

        frame.add(title_panel);
        frame.add(buttontPanel);
        frame.add(grid);
        //frame.add(boardPanel);

        textfield.setBackground(new Color(223, 238, 234));
			textfield.setForeground(new Color(0,0,0));
        	textfield.setFont(new Font("Tahoma",Font.BOLD,50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		    textfield.setText("Tic-Tac-Toe");

        title_panel.add(textfield);
        
        // a reset button
        resetbutoon.setText("Reset");
        resetbutoon.setFont(new Font("TimesRoman",Font.BOLD,15));
        resetbutoon.setBackground(new Color(167, 196, 188));
        resetbutoon.setFocusable(false);
        resetbutoon.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				control.event_reset(e);
			}
		});
        
        // a save button
        savebutton.setText("Save");
        savebutton.setFont(new Font("TimesRoman",Font.BOLD,15));
        savebutton.setBackground(new Color(167, 196, 188));
        savebutton.setFocusable(false);
        savebutton.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				control.event_save(e);
			}
		});

        // a load button
        loadbutton.setText("Load");
        loadbutton.setFont(new Font("TimesRoman",Font.BOLD,15));
        loadbutton.setBackground(new Color(167, 196, 188));
        loadbutton.setFocusable(false);
        loadbutton.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				control.event_load(e);
			}
		});

        buttontPanel.add(savebutton);
        buttontPanel.add(resetbutoon);
        buttontPanel.add(loadbutton);

        grid.setBounds(10,185,570,570);
        grid.addMouseListener(control.mouse_listener);	
        
        frame.setVisible(true);
        //board.setBounds(10,185,570,570);
        //frame.add(board);
       // paint_grid(100, 100, 1);


    }
    
    /** Draw everything to table*/
    public void draw(Graphics g) {
		graphics = g;	
		for(int i=0;i<control.get_model().get_table_size();i++) {
			for(int j=0;j<control.get_model().get_table_size();j++) {
				paint_grid(i,j,(control.get_model().get_data(i, j)));
			}
		}
		
		
	}
    
    /** paint each cell */
	public void paint_grid(int x, int y,int player) {
    	int table_size = control.get_model().get_table_size();
    	int pointerX = (int) (((get_sizeX_grid()/table_size)*(x+0.5)));
    	int pointerY = (int) (((get_sizeY_grid()/table_size)*(y+0.5)));
    	int size_paint = get_sizeX_grid()/table_size;
    	if (player == 0) {
    		// do nothing
    	}else if (player == 1) {
    		grid.paintO(graphics,pointerX,pointerY,size_paint);
    	}else if (player == 2) {
    		grid.paintX(graphics,pointerX,pointerY,size_paint);
    	}
    	
    }
    

    public void update() {
    	// may do something
    	//System.out.println("updated");
    }
    
    int get_sizeY_grid() {
    	return grid.getHeight();
    }
    
    int get_sizeX_grid() {
    	return grid.getWidth();
    }
    public void show_popUp(String text) {
    	JOptionPane.showMessageDialog(null, text);
    }

    public static void main(String[] args){
    	int size = 4;
    	Controller con = new Controller(size); // test
      }

}




/****
public class View{
	
	
	/**** old class
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JPanel table_panel = new JPanel();
	JPanel graphics_panel = new JPanel();
	JPanel right_panel = new JPanel();
	JButton[][] buttons;
	JButton button_reset = new JButton();
	JButton button_save = new JButton();
	JButton button_load = new JButton();
	JEditorPane editorPane = new JEditorPane();
	Graphics g1;
	int table_size;  // number of table length
	Controller control;

	View(int game_size,Controller Control){
		
		this.control = Control;
		this.table_size = game_size;
		buttons = new JButton[table_size][table_size]; 
		
		// Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		// Head Label
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		// panel of head 
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		title_panel.add(textfield);  // Add text to head panel
		
		// Table
		button_panel.setLayout(new GridLayout(table_size,table_size));
		button_panel.setBackground(new Color(150,150,150));	
		button_panel.addMouseListener(Control.mouse_listener);		
		create_buttons(); // Create button for table
		// Table but no buttons
		table_panel.setLayout(new GridLayout(table_size,table_size));
		table_panel.setBackground(new Color(150,150,150));	
		table_panel.addMouseListener(Control.mouse_listener);		
		
		
				
		////// Right panel //////
		//// setting buttons ////
		// a reset button
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 50));
		button_reset.setText("Reset");
		button_reset.setFocusable(false);
		button_reset.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.event_reset(e);
			}
		});
		
		// a save button
		button_save.setText("save");
		button_save.setFocusable(false);
		button_save.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.event_save(e);
			}
		});

		// a load button
		button_load.setText("load");
		button_load.setFocusable(false);
		button_load.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.event_load(e);
			}
		});
		//// setting buttons End ////
		// add to panel
		right_panel.setLayout(new GridLayout(5,0));
		right_panel.setBackground(new Color(25,25,25));
//		right_panel.add(editorPane);
		right_panel.add(button_reset);
		right_panel.add(button_save);
		right_panel.add(button_load);
		
		////// Right panel End //////

		
		// Add label to frame
		frame.add(title_panel,BorderLayout.NORTH);  // Add title_panel to frame on top screen
		frame.add(button_panel);  // Add table to frame on the middle
		frame.add(table_panel);  // Add table to frame on the middle (it will remove button panel)
		frame.add(right_panel,BorderLayout.EAST);  // Add right_panel to frame on right screen
//		frame.add(graphics_panel);  // Add graphics_panel for draw something
		frame.setVisible(true);  // update to JFrame
		
		/** For test draw OX */ /*
		graphics_panel = new JPanel(){
		    public void paintComponent(Graphics g) {
		    	g = g1;
		        g.drawOval(10, 10, 100, 2100);
		    }
		};
		graphics_panel.paint(g1);
	}
	
	
	/** Create table of buttons*/ /*
	private void create_buttons() {
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				buttons[i][j] = new JButton();
				button_panel.add(buttons[i][j]);
				buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,75));
				buttons[i][j].setFocusable(false);  // It's text pointer
				buttons[i][j].addActionListener(control);
			}
		}
	}	

	
	public void update() {
		// Update everything to GUI
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				if(control.get_model().get_data(i, j) ==  0) {
					draw_no(i,j);
				}else if(control.get_model().get_data(i, j) ==  1) {
					draw_O(i,j);
				}else if(control.get_model().get_data(i, j) ==  2) {
					draw_X(i,j);
				}
			}
		}
		// Panel title
		draw_win();  // Result of game or Show current turn
		frame.setVisible(true);  // update to JFrame
	}
	
	void draw_X(int y, int x){
		buttons[x][y].setForeground(new Color(255,0,0));
		buttons[x][y].setText("X");
	}
	
	void draw_O(int y, int x){
		buttons[x][y].setForeground(new Color(0,0,255));
		buttons[x][y].setText("O");
	}
	
	void draw_no(int y, int x){
		buttons[x][y].setText("");
	}
	
	void paint_O() {
		Graphics g;
	}
	
	void draw_win() {
		// Result of game or Show current turn
		int winner = control.get_model().get_winner();
		if (winner == 0) {
			textfield.setText("Turn player "+ control.get_model().get_turn());
		}else if (winner == 1) {
			textfield.setText("O is Winner!");
		}else if (winner == 2) {
			textfield.setText("X is Winner!");
		}else if (winner == 3) {
			textfield.setText("Draw!!");
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.drawOval(100,100,50,150);
	}
	
	void test_draw() {
		JFrame frame = new JFrame() ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel jp = new JPanel() {
		    public void paintComponent(Graphics g) {
		        g.drawOval(10, 10, 100, 2100);
		    }
		};
		
		frame.add(jp);
		frame.setVisible(true);
	}
	
	/** Draw O*/ /*
	public static void paint1(Graphics g,int x,int y, int r) {
		g.setColor(Color.blue);
		g.fillOval(x - r/2, y - r/2, r, r);  // circle to out ring
		g.setColor(Color.white);
		int s = 10;  // size of ring
		r = r-s;
		g.fillOval(x - r/2, y - r/2, r, r);  // circle to in ring
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.blue);
		g2.drawRoundRect(x-r/2, y-r/2, r, r, r, r);  // x, y, height, width, round edges, round edges
	}
	
	/** Draw X*/ /*
	public static void paint2(Graphics g,int x,int y, int r) {
		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
		int s = 10;  // size
		g2.setStroke(new BasicStroke(s));
		g2.drawLine(x-r/2, y-r/2, x+r/2, y+r/2);	// it is ULtoDR
		g2.drawLine(x+r/2, y-r/2, x-r/2, y+r/2);	// it is URtoDL

	}
	
	/** Draw O*/ /*
	public static void paint3(Graphics g,int x,int y, int r) {
		g.setColor(Color.blue);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.blue);
		int s = 5;  // size
		g2.setStroke(new BasicStroke(s));
		g2.drawRoundRect(x-r/2, y-r/2, r, r, r, r);  // x, y, height, width, round edges, round edges
	}
	
	
	public static void main(String[] args) {
		/** for testing*/ /*
		JFrame frame = new JFrame() ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel jp = new JPanel() {
		    public void paintComponent(Graphics g) {
		    	g.setColor(Color.blue);
//		        g.drawOval(300, 300, 100, 100);
		        paint1(g,200,200,50);
		        paint2(g,300,300,50);
		        paint3(g,300,200,50);
		    }
		};
		
		frame.add(jp);
		frame.setVisible(true);
	
	}
}

*/

