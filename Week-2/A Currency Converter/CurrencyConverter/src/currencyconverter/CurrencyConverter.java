package currencyconverter;

// ***********************************************************************
// CurrencyConverter.java
//
// Computes the dollar value of the cost of an item in another currency.
//
// Modified by Mohammad Rizky Maulidhan (191524049)
// ***********************************************************************
import java.awt.*;
import javax.swing.*;
public class CurrencyConverter {
    public static void main (String[] args) {
        JFrame frame = new JFrame ("Currency Converter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,200);
        
        RatePanel ratePanel = new RatePanel ();
        frame.getContentPane().add(ratePanel);
        frame.setVisible(true);
    }
} 