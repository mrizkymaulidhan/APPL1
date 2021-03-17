package polysorting;

// *************************************************************
//    WeeklySales.java
//
//    Sorts the sales staff in descending order by sales.
// ************************************************************

import java.util.Scanner;

public class WeeklySales
{
    public static void main(String[] args)
    {
        int i, size, sales;
        String fname, lname;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Total Salesperson: ");
        size = scanner.nextInt();
        
        Salesperson[] salesStaff = new Salesperson[size];

        for(i=0; i<size; i++)
        {
            System.out.print("\nSales "+(i+1));
            System.out.print("\nFirst Name \t: ");
            fname = scanner.next();
            System.out.print("Last Name \t: ");
            lname = scanner.next();
            System.out.print("Total Sales \t: ");
            sales = scanner.nextInt();
            
            salesStaff[i] = new Salesperson(fname, lname, sales);
        }
        
	Sorting.insertionSort(salesStaff);

	System.out.println ("\nRanking of Sales for the Week\n");
	for (Salesperson s : salesStaff)
	    System.out.println (s);
    }
}