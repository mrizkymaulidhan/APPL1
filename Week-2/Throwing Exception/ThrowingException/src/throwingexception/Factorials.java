package throwingexception;
// ****************************************************************
// Factorials.java
// 
// Reads integers from the user and prints the factorial of each.
//
// Modified by Mohammad Rizky Maulidhan (191524049).
// ****************************************************************
import java.util.Scanner;
public class Factorials{
    public static void main(String[] args){
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        while (keepGoing.equals("y") || keepGoing.equals("Y")){
            System.out.print("Enter an integer: ");
            int val = scan.nextInt();
            // Try statement
            try{
                System.out.println("Factorial(" + val +")=" + MathUtils.factorial(val) + "\n");
            }
            // Catch an IllegalArgumentException
            catch(IllegalArgumentException ex){
                System.err.println(ex + "\n");
            }
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
    }
}