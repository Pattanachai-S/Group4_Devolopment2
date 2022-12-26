// Java program to draw a line in Applet

import java.awt.*;
import javax.swing.*;
//import java.awt.geom.Line2D;
//import javafx.scene.paint.Color;

class MyCanvas extends JComponent {
	Graphics g;

	public void paint(Graphics g) {
		// draw and display the line
		g.setColor(Color.PINK);
		g.drawLine(50, 50, 100, 100);
		g.drawLine(50, 100, 100, 50);
		g.setColor(Color.GRAY);
		g.drawArc(150,50,50,50,0,360);
	}
}

public class Drawxo {
	public static void main(String[] a)
	{

		// creating object of JFrame(Window popup)
		JFrame window = new JFrame();

		// setting closing operation
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setting size of the pop window
		window.setBounds(50, 50, 500, 500);

		// setting canvas for draw
		window.getContentPane().add(new MyCanvas());

		// set visibility
		window.setVisible(true);
	}
}