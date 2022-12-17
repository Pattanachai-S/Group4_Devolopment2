package OXGames;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import broCodeOX.TicTacToe;

public class GUI implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JButton[][] buttons;
	boolean player1_turn;
	
	int table_size;  // number of table length
	
	

	GUI(int game_size){
		
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
					if(player1_turn) {
						if(buttons[i][j].getText()=="") {
							buttons[i][j].setForeground(new Color(255,0,0));
							buttons[i][j].setText("X");
							player1_turn=false;
							textfield.setText("O turn");
	
						}
					}
					else {
						if(buttons[i][j].getText()=="") {
							buttons[i][j].setForeground(new Color(0,0,255));
							buttons[i][j].setText("O");
							player1_turn=true;
							textfield.setText("X turn");
						}
					}
				}
			}			
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
		 GUI game = new GUI(5);  // test
		
	}
}

