package movablecircle;

//******************************************************************
//  CirclePanel.java
//
//  A panel with a circle drawn in the center and buttons on the 
//  bottom that move the circle.
//
//  Modified by Mohammad Rizky Maulidhan (191524049).
//******************************************************************

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;

    //---------------------------------------------------------------
    //Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        //Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2); 

        c = Color.green;

        //Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        //Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
        
        //Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        //Add Mnumonicts to move buttons
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);

        //Add Tooltips to buttons
        left.setToolTipText("Move circle left 20.");
        right.setToolTipText("Move circle right 20.");
        up.setToolTipText("Move circle up 20.");
        down.setToolTipText("Move circle down 20.");

        //Need a panel to put the buttons on or they'll be on
        //top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);

        //Add the button panels to the bottom of the main panel
        this.add(buttonPanel, "South");
    }

    //---------------------------------------------------------------
    //Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }

    //---------------------------------------------------------------
    //Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;

        //---------------------------------------------------------------
        //Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        //---------------------------------------------------------------
        //Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            left.setEnabled(true);
            right.setEnabled(true);
            up.setEnabled(true);
            down.setEnabled(true);
            
            x += dx;
            y += dy;

            if(x > getSize().getWidth() - 85)
                right.setEnabled(false);
            if(x < 20)
                left.setEnabled(false);
            if(y > getSize().getHeight() - 115)
                down.setEnabled(false);
            if(y < 20)
                up.setEnabled(false);

            repaint();
        }
    }
}