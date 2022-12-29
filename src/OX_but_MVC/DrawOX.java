package OX_but_MVC;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Anna
 */
public class DrawOX extends JPanel{
    
    private List<Point> points = new ArrayList<>();
    
    public DrawOX(){
        setBackground(new Color(255,255,255));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                points.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        for (Point p1 : points){
            g2.drawRoundRect(p1.x, p1.y, 60,60,60,60);
        }
        for (Point p2 : points){
            g2.drawString("X",p2.x,p2.y);
        }
            //g2.drawString("X",p.x,p.y);
            //g2.drawLine(p.x,p.y,50,50);
        
    }
    
    public static void main(String [] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame();
                frame.add(new DrawOX());
                frame.setSize(600,600);
                frame.setVisible(true);
            }
        });
    }
    
    
}