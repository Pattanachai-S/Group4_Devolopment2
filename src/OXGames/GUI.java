package OXGames;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import OXGames.Main;

public class GUI implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JButton[][] buttons;
	boolean player1_turn;
	
	int table_size;  // number of table length
	Main data;  // data of table
	
	

	GUI(int game_size,Main data){
		
		this.table_size = game_size;
		this.data = data;
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
		// Create button for table
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				buttons[i][j] = new JButton();
				button_panel.add(buttons[i][j]);
				buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,100));
				buttons[i][j].setFocusable(false);  // It's text pointer
				buttons[i][j].addActionListener(this);
			}
		}
		
		// Add label to frame
		frame.add(title_panel,BorderLayout.NORTH);  // Add title_panel to frame on top screen
		frame.add(button_panel);  // Add table to frame
		
		// Start 1st turn
		//firstTurn();  	
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<table_size;i++) {
			for(int j=0;j<table_size;j++) {
				if(e.getSource()==buttons[i][j]) {
					this.data.action(i, j);
				}
			}
		}
		update_buttons();
	}
		

	
	public void update_buttons() {
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
		draw_win();
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
	
	void draw_win() {
		int winner = data.get_winner();
		if (winner == 1) {
			textfield.setText("O is Winner!");
		}else if (winner == 2) {
			textfield.setText("X is Winner!");
		}else if (winner == 3) {
			textfield.setText("Draw!!");
		}
	}
	
	
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		textfield.setText("O turn");
	}
	
	public static void main(String[] args) {
		int size = 3;
		Main table = new Main();
		table.change_table_size(size);
		GUI game = new GUI(size, table);  // test
		
	}
}

