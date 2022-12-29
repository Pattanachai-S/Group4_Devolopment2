package XO_MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowNCol {

    JFrame wind = new JFrame();

    RowNCol(){
        wind.setSize(570,570);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setVisible(true);
        wind.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) { }
            public void mouseReleased(MouseEvent me) { }
            public void mouseEntered(MouseEvent me) { }
            public void mouseExited(MouseEvent me) { }
            public void mouseClicked(MouseEvent me) { 
               getRowandCol(me.getX(), me.getY(), 5);
            }
        });
    }

    public static void main(String[] arg){
        new RowNCol();
    }

    public void getRowandCol(int xPosition, int yPosition , int tableSizee){
        
        float cellSz = 570/tableSizee;
        int CellRow = (int) (xPosition/cellSz);
        int CellCol = (int) (yPosition/cellSz);

        //System.out.println("(row,col):" + "(" + CellRow + "," + CellCol + ")"); //test
    }
    
}
