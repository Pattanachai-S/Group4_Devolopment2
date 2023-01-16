package Dice;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class View {
    JFrame frame = new JFrame();
    JPanel head_panel = new JPanel();
    JPanel button_panel = new JPanel(new GridLayout(1,3));
    JLabel head_lable = new JLabel();
    JButton roll_up_Button = new JButton();
    JButton roll_front_Button = new JButton();
    JButton roll_right_Button = new JButton();
    Model model;
    Controller controller;

    DrawDice dice = new DrawDice();

    View(){
        this.model = model;
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(head_panel, BorderLayout.NORTH);
        frame.getContentPane().add(button_panel, BorderLayout.SOUTH);
        frame.setVisible(true);

        head_lable.setText("Dice");
        head_lable.setFont(new Font("Tahoma",Font.BOLD,50));
        head_panel.add(head_lable);

        frame.getContentPane().add(dice, BorderLayout.CENTER);

        roll_up_Button.setText("Roll Up");
        roll_up_Button.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_up_Button.setFocusable(false);

        roll_front_Button.setText("Roll Front");
        roll_front_Button.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_front_Button.setFocusable(false);

        roll_right_Button.setText("Roll Right");
        roll_right_Button.setFont(new Font("TimesRoman",Font.BOLD,15));
        roll_right_Button.setFocusable(false);

        button_panel.add(roll_up_Button);
        button_panel.add(roll_front_Button);
        button_panel.add(roll_right_Button);

    }

    public void set_model(Model model){
        this.model = model;
    }

    public void set_controller(Controller controller){
        this.controller = controller;
    }

    public void add_event_buttons(){
        roll_up_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.event_roll_up(e);
			}
        });
        roll_front_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.event_roll_front(e);
			}
        });
        roll_right_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.event_roll_right(e);
			}
        });
    }

    public void update_numer(){
        dice.number = model.get_front();
    }

    public static void main(String[] args){
        View UI = new View();
    }
}

class DrawDice extends JPanel {

    int WIDTH = 200;
    int HEIGHT = 200;
    int number = 6; //เปลี่ยนตัวเลขเพื่อทดลอง

    public void paint(Graphics g) {
      //g.setColor(Color.RED);
      g.drawRect(200, 50, 200, 200);
      switch(number) {
        case 1:
            drawDot(g, WIDTH / 2, HEIGHT / 2);
            break;
        case 2:
            drawDot(g, WIDTH / 4, HEIGHT / 4);
            drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
            break;
            case 3:
            drawDot(g, WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 2, HEIGHT / 2);
            drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
            break;
        case 4:
            drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 4, HEIGHT / 4);
            drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
            drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
            break;
        case 5:
            drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 2, HEIGHT / 2);
            drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
            drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
            break;
        case 6:
            drawDot(g, 3 * WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 4, HEIGHT / 4);
            drawDot(g, WIDTH / 4, HEIGHT / 2);
            drawDot(g, 3 * WIDTH / 4, HEIGHT / 2);
            drawDot(g, 3 * WIDTH / 4, 3 * HEIGHT / 4);
            drawDot(g, WIDTH / 4, 3 * HEIGHT / 4);
            break;
        }
        //repaint();
    }

    public void drawDot(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.fillOval(x+190, y+40, 20, 20);
    }
  }



