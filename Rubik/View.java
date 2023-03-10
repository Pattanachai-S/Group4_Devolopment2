package Rubik;

import javax.swing.*;
import java.awt.*;

public class View {
    
    JFrame frame = new JFrame();
    JPanel head_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel roll_panel = new JPanel(new GridLayout(1,6));
    JPanel flip_panel = new JPanel(new GridLayout(4,1));
    JLabel head_lable = new JLabel();
    JButton roll_R = new JButton();
    JButton roll_F = new JButton();
    JButton roll_U = new JButton();
    JButton roll_L = new JButton();
    JButton roll_B = new JButton();
    JButton roll_D = new JButton();
    JButton flip_R = new JButton();
    JButton flip_L = new JButton();
    JButton flip_U = new JButton();
    JButton flip_D = new JButton();

    RubikCube rubik = new RubikCube();

    View(){

        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(head_panel, BorderLayout.NORTH);
        frame.getContentPane().add(roll_panel, BorderLayout.SOUTH);
        frame.getContentPane().add(flip_panel, BorderLayout.EAST);
        frame.setVisible(true);

        frame.getContentPane().add(rubik, BorderLayout.CENTER);


        head_lable.setText("Rubik");
        head_lable.setFont(new Font("Tahoma",Font.BOLD,50));
        head_panel.add(head_lable);

        roll_R.setText("Roll R");
        roll_R.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_R.setFocusable(false);

        roll_F.setText("Roll F");
        roll_F.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_F.setFocusable(false);

        roll_U.setText("Roll U");
        roll_U.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_U.setFocusable(false);

        roll_L.setText("Roll L");
        roll_L.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_L.setFocusable(false);

        roll_B.setText("Roll B");
        roll_B.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_B.setFocusable(false);

        roll_D.setText("Roll D");
        roll_D.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_D.setFocusable(false);

        roll_panel.add(roll_R);
        roll_panel.add(roll_F);
        roll_panel.add(roll_U);
        roll_panel.add(roll_L);
        roll_panel.add(roll_B);
        roll_panel.add(roll_D);

        flip_R.setText("Flip R");
        flip_R.setFont(new Font("TimesRoman",Font.BOLD,15));
        flip_R.setFocusable(false);

        flip_U.setText("Flip U");
        flip_U.setFont(new Font("TimesRoman",Font.BOLD,15));
        flip_U.setFocusable(false);

        flip_L.setText("Flip L");
        flip_L.setFont(new Font("TimesRoman",Font.BOLD,15));
        flip_L.setFocusable(false);

        flip_D.setText("Flip D");
        flip_D.setFont(new Font("TimesRoman",Font.BOLD,15));
        flip_D.setFocusable(false);

        flip_panel.add(flip_R);
        flip_panel.add(flip_U);
        flip_panel.add(flip_L);
        flip_panel.add(flip_D);

    }

    public static void main(String[] args){
        View UI = new View();
    }
}
class RubikCube extends JPanel{

    int originX = 150; //????????????????????? x ?????????????????????????????????
    int originY = 50; //????????????????????? y ?????????????????????????????????
    int squareSize = 100; //???????????????????????????????????????????????????

    public void paint(Graphics g) {
        super.paintComponent(g);
        drawRubik(g);
        repaint();
    }

    //?????????????????????????????????
    public void drawRubik(Graphics g){
        drawSquare(g, 0, 0, 1);
        drawSquare(g, 1, 0, 2);
        drawSquare(g, 2, 0, 3);
        drawSquare(g, 0, 1, 4);
        drawSquare(g, 1, 1, 5);
        drawSquare(g, 2, 1, 6);
        drawSquare(g, 0, 2, 1);
        drawSquare(g, 1, 2, 2);
        drawSquare(g, 2, 2, 3);
    }


    //??????????????????????????????????????????????????????????????????
    private Color rubikColor (int number){
        Color color = null;
        switch(number) {
            case 1:
                color = Color.white;
                break;
            case 2:
                color = Color.red;
                break;
            case 3:
                color = Color.blue;
                break;
            case 4:
                color = Color.orange;
                break;
            case 5:
                color = Color.green;
                break;
            case 6:
                color = Color.yellow;
                break;
            }
        return color;
    }

    //????????????????????????????????????????????????
    public void drawSquare(Graphics g, int col, int row, int num){
        int anchorX = originX + col * squareSize ;
        int anchorY = originY + row * squareSize ;

        g.setColor(rubikColor(num));
        g.fillRect(anchorX, anchorY, squareSize, squareSize);

        g.setColor(Color.black);
        g.drawRect(anchorX, anchorY, squareSize, squareSize);
    }
}
