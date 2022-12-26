package OX_but_MVC;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.Line2D;

import OXGames.Main;




public class View{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JPanel graphics_panel = new JPanel();
	JPanel right_panel = new JPanel();
	JButton[][] buttons;
	JButton button_reset = new JButton();
	JButton button_save = new JButton();
	JButton button_load = new JButton();
	JEditorPane editorPane = new JEditorPane();
	Graphics g1;
	int table_size;  // number of table length
	Model data;  // data of table
	Controller Control;

	View(int game_size,Model table,Controller Control){
		
		this.Control = Control;
		this.table_size = game_size;
		this.data = table;
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
//		create_buttons(); // Create button for table
		
		
		
				
		////// Right panel //////
		//// setting buttons ////
		// a reset button
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 50));
		button_reset.setText("Reset");
		button_reset.setFocusable(false);
		button_reset.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.even_reset(e);
			}
		});
		
		// a save button
		button_save.setText("save");
		button_save.setFocusable(false);
		button_save.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.even_save(e);
			}
		});

		// a load button
		button_load.setText("load");
		button_load.setFocusable(false);
		button_load.addActionListener(new ActionListener() {  
			// when action to the button
			public void actionPerformed(ActionEvent e) {
				Control.even_load(e);
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
		frame.add(right_panel,BorderLayout.EAST);  // Add right_panel to frame on right screen
//		frame.add(graphics_panel);  // Add graphics_panel for draw something
		frame.setVisible(true);  // update to JFrame
		
		/** For test draw OX*/
		graphics_panel = new JPanel(){
		    public void paintComponent(Graphics g) {
		    	g = g1;
		        g.drawOval(10, 10, 100, 2100);
		    }
		};
		graphics_panel.paint(g1);
	}
	
	
	/** Create table of buttons*/
	private void create_buttons() {
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				buttons[i][j] = new JButton();
				button_panel.add(buttons[i][j]);
				buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,75));
				buttons[i][j].setFocusable(false);  // It's text pointer
				buttons[i][j].addActionListener(Control);
			}
		}
	}	

	
	public void update() {
		// Update everything to GUI
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				if(data.get_data(i, j) ==  0) {
					draw_no(i,j);
				}else if(data.get_data(i, j) ==  1) {
					draw_O(i,j);
				}else if(data.get_data(i, j) ==  2) {
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
		int winner = data.get_winner();
		if (winner == 0) {
			textfield.setText("Turn player "+ data.get_turn());
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
	
	/** Draw O*/
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
	
	/** Draw X*/
	public static void paint2(Graphics g,int x,int y, int r) {
		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
		int s = 10;  // size
		g2.setStroke(new BasicStroke(s));
		g2.drawLine(x-r/2, y-r/2, x+r/2, y+r/2);	// it is ULtoDR
		g2.drawLine(x+r/2, y-r/2, x-r/2, y+r/2);	// it is URtoDL

	}
	
	/** Draw O*/
	public static void paint3(Graphics g,int x,int y, int r) {
		g.setColor(Color.blue);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.blue);
		int s = 5;  // size
		g2.setStroke(new BasicStroke(s));
		g2.drawRoundRect(x-r/2, y-r/2, r, r, r, r);  // x, y, height, width, round edges, round edges
	}
	
	
	public static void main(String[] args) {
		/** for testing*/
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

