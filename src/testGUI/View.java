package testGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame{

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JPanel title_panel = new JPanel(new BorderLayout());;
    JPanel buttontPanel = new JPanel(new GridLayout(1,3));
    Grid grid = new Grid();
    JButton resetbutoon = new JButton();
    JButton savebutton = new JButton();
    JButton loadbutton = new JButton();


    public View(){

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

        resetbutoon.setText("Reset");
        resetbutoon.setFont(new Font("TimesRoman",Font.BOLD,15));
        resetbutoon.setBackground(new Color(167, 196, 188));
        resetbutoon.setFocusable(false);

        savebutton.setText("Save");
        savebutton.setFont(new Font("TimesRoman",Font.BOLD,15));
        savebutton.setBackground(new Color(167, 196, 188));
        savebutton.setFocusable(false);

        loadbutton.setText("Load");
        loadbutton.setFont(new Font("TimesRoman",Font.BOLD,15));
        loadbutton.setBackground(new Color(167, 196, 188));
        loadbutton.setFocusable(false);

        buttontPanel.add(savebutton);
        buttontPanel.add(resetbutoon);
        buttontPanel.add(loadbutton);

        grid.setBounds(10,185,570,570);
        
        
        frame.setVisible(true);


        //board.setBounds(10,185,570,570);
        //frame.add(board);

       

    }


    public static void main(String[] args){
        new View();
      }

}

class Grid extends JPanel{

    float tableSize = 4;
    float width = 570;
    float height = 570;
    float rowHt = height / (tableSize);
    float rowWid = width / (tableSize);

    void drawGrid(Graphics g){
      Graphics2D g2d = (Graphics2D) g;
      
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
        super.paint(g);
        drawGrid(g);
    
    }

    
    
}

