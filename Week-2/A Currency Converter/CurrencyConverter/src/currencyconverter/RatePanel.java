package currencyconverter;

// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
//
// Modified by Mohammad Rizky Maulidhan (191524049)
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class RatePanel extends JPanel {
    private String[] currencyName;
    private double[] exrate;
    private JLabel title;
    private JLabel result;
    private JComboBox currencyBox;
    private JTextField cost = new JTextField("0");
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel () {        
        title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 25));
                
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        
        exrate = new double [] {0.0, 
            1.2103, 0.7351, 
            0.0091, 0.6969, 
            0.0222, 0.0880};
        
        result = new JLabel ("...............");

        JLabel costLabel = new JLabel("Cost Value");
        
        JLabel currencyLabel = new JLabel("Currency Name");
        currencyBox = new JComboBox(currencyName);
        currencyBox.addActionListener(new ComboListener());
        
        add(title);
        add(result);
        add(costLabel);
        add(cost);
        add(currencyLabel);
        add(currencyBox);
        
        this.setBackground(new Color(200,200,200));
        this.setLayout(new GridLayout(7,4,1,1));
        this.setBorder(new EmptyBorder(20, 20, 0, 20));
    }
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed (ActionEvent event) {
            int index = currencyBox.getSelectedIndex();
            result.setText (cost.getText() + " " + currencyName[index] +
            " is " + (exrate[index] * Integer.valueOf(cost.getText())) + " U.S. Dollars.");
        }
    }
}   