package Dice;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class View {
    JFrame frame = new JFrame();
    JPanel dice_panel = new JPanel();;

    static Graphics graphics;
    View(){
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
        //frame.getContentPane().setLayout(null);
        frame.setVisible(true);
    }

/* 
    public void paint(Graphics g) {
    	super.paintComponent(g);  // Call the paintComponent method of the superclass

        repaint();  // repeat this method all time

        
    }  */
    public void draw_point(Graphics g, int n){
        if(n == 1){
            g.drawRect(200,200,120,120);
        }
    }

    public static void main(String[] args){
        View UI = new View();
        UI.draw_point(1);
    }
}
