package parseint;
// ****************************************************************
// ParseInts.java
// 
// Reads a line of text and prints the integers in the line.
//
// Modified by Mohammad Rizky Maulidhan (191524049).
// ****************************************************************
import java.util.Scanner;
public class ParseInts{
    public static void main(String[] args){
        int val, sum=0;
        Scanner scan = new Scanner(System.in);
        String line;
        
        System.out.println("Enter a line of text");
        Scanner scanLine = new Scanner(scan.nextLine());
        
        while (scanLine.hasNext()){
            // Try statement 
            try{
                val = Integer.parseInt(scanLine.next());
                sum += val;
            }
            // Catch a NumberFormatException with empty body
            catch(NumberFormatException ex){
            }
        }
        System.out.println("The sum of the integers on this line is " + sum);
    }
}