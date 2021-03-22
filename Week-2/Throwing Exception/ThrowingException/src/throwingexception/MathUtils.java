package throwingexception;
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// Modified by Mohammad Rizky Maulidhan (191524049).
// ****************************************************************
public class MathUtils{
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
    public static int factorial(int n){
        // If n is negative number
        if(n<0){
            // Throw an IllegalArgumentException
            throw new IllegalArgumentException (n + " is a negative number.");
        }
        // If n is more than 16
        else if(n>16){
            // Throw an IllegalArgumentException
            throw new IllegalArgumentException (n + " is more than 16.");
        }
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    }
}