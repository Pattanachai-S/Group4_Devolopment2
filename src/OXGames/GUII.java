package OXGames;

import java.awt.*;
import javax.swing.*;

public class GUII extends JFrame {
    
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Tic Tac Toe");

        Container content = frame.getContentPane();

        GridBagLayout gridbaglayout = new GridBagLayout();
        content.setLayout(gridbaglayout);

       //GridBagConstraints constraints = new GridBagConstraints();

        //frame
        frame.setSize(700, 670);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(47, 93, 98));
        frame.setVisible(true);

        //tic tac toe text
        JTextField textfield = new JTextField();
        textfield.setBackground(new Color(223, 238, 234));
		textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("Tahoma",Font.BOLD,50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.weighty = 0.30;
        content.add(textfield, gridBagConstraints);

        // สร้าง panel button
       JPanel resetPanel = new JPanel(new BorderLayout());
       //resetPanel.setBackground(new Color(167, 196, 188));
       gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.gridx = 0;
       gridBagConstraints.gridy = 1;
       gridBagConstraints.fill = GridBagConstraints.BOTH;
       gridBagConstraints.insets = new Insets(0,10,0,5);
       gridBagConstraints.gridwidth = 1;
       gridBagConstraints.gridheight = 1;
       gridBagConstraints.weightx = 1.0;
       gridBagConstraints.weighty = 0.25;
       content.add(resetPanel, gridBagConstraints);

       JButton resetbutoon = new JButton();
       resetbutoon.setText("Reset");
       resetbutoon.setBackground(new Color(167, 196, 188));
       resetbutoon.setFont(new Font("Tahoma",Font.BOLD,20));
       resetbutoon.setFocusable(false);
       //resetbutoon.setHorizontalAlignment(SwingConstants.CENTER);
       resetPanel.add(resetbutoon);
       
       
       JPanel savePanel = new JPanel(new BorderLayout());
       //savePanel.setBackground(new Color(167, 196, 188));
       gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.gridx = 1;
       gridBagConstraints.gridy = 1;
       gridBagConstraints.fill = GridBagConstraints.BOTH;
       gridBagConstraints.insets = new Insets(0,5,0,5);
       gridBagConstraints.gridwidth = 1;
       gridBagConstraints.gridheight = 1;
       gridBagConstraints.weightx = 1.0;
       gridBagConstraints.weighty = 0.25;
       content.add(savePanel, gridBagConstraints);

       JButton savebutton = new JButton();
       savebutton.setText("Save");
       savebutton.setFont(new Font("Tahoma",Font.BOLD,20));
       savebutton.setFocusable(false);
       savebutton.setBackground(new Color(167, 196, 188));
       //savebutton.setHorizontalAlignment(SwingConstants.CENTER);
       savePanel.add(savebutton);

       JPanel loadPanel = new JPanel(new BorderLayout());
       //loadPanel.setBackground(new Color(167, 196, 188));
       gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.gridx = 2;
       gridBagConstraints.gridy = 1;
       gridBagConstraints.fill = GridBagConstraints.BOTH;
       gridBagConstraints.insets = new Insets(0,5,0,10);
       gridBagConstraints.gridwidth = 1;
       gridBagConstraints.gridheight = 1;
       gridBagConstraints.weightx = 1.0;
       gridBagConstraints.weighty = 0.25;
       content.add(loadPanel, gridBagConstraints);

       JButton loadbutton = new JButton();
       loadbutton.setText("Load");
       loadbutton.setFont(new Font("Tahoma",Font.BOLD,20));
       loadbutton.setBackground(new Color(167, 196, 188));
       loadbutton.setFocusable(false);
       //loadbutton.setHorizontalAlignment(SwingConstants.CENTER);
       loadPanel.add(loadbutton);
        
        // สร้าง panel board
        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(new Color(223, 238, 234));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.weighty = 3.0;
        //boardPanel.add(new Drawtable());
        content.add(new Drawtable(), gridBagConstraints);

        
        
//        int table_size = 20;
//        JPanel gameGrid = new JPanel(new GridLayout(table_size, table_size, 2, 2));
//        gameGrid.setBackground(new Color(47, 93, 98));
//        gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 2;
//        gridBagConstraints.fill = GridBagConstraints.BOTH;
//        gridBagConstraints.insets = new Insets(10,10,10,10);
//        gridBagConstraints.gridwidth = 3;
//        gridBagConstraints.gridheight = 3;
//        gridBagConstraints.weightx = 4.0;
//        gridBagConstraints.weighty = 3.0;
//        content.add(gameGrid, gridBagConstraints);
//
//        for (int i = 0; i < table_size; i++) {
//
//            for (int j = 0; j < table_size; j++) {
//                JPanel cellpanel = new JPanel();
//                cellpanel.setBackground(new Color(233,238,234));
//                cellpanel.setPreferredSize(gameGrid.getSize());
//                String name = String.format("[%d, %d]", i, j);
//                cellpanel.setName(name);
//                gameGrid.add(cellpanel);
//            }
//        }
        
        frame.setVisible(true);
    }
    

}
class Drawtable extends JComponent {
    public void paint(Graphics g) {
  
      int size = 5;
      int width = getSize().width;
      int height = getSize().height;
      // draw the rows
      int rowHt = height / (size);
      for (int i = 0; i < size+1; i++){
        g.drawLine(0, i * rowHt, width, i * rowHt);
      }
        
  
      // draw the columns
      int rowWid = width / (size);
      for (int i = 0; i < size+1; i++){
        g.drawLine(i * rowWid, 0, i * rowWid, height);
      }
  
    }
    
  }
