package integerlist;

// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// ****************************************************************
import java.util.Scanner;

public class IntegerListTest
{
    static IntegerList list = new IntegerList (10);
    static Scanner scan = new  Scanner (System.in);

    // ------------------------------------------------------------------
    // Creates a list, then repeatedly print the menu and do what the
    // user asks until they quit.
    // ------------------------------------------------------------------
    public static void main(String[] args)
    {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
            {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
            }
    }

    // -------------------------------------
    //  Does what the menu item calls for.
    // -------------------------------------
    public static void dispatch(int choice)
    {
        int loc, oldVal, newVal;
        switch(choice)
            {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("How big should the list be?");
                int size = scan.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                list.selectionSort();
                break;
            case 3:
                System.out.print("Enter the value to look for: ");
                loc = list.search(scan.nextInt());
                if (loc != -1)
                    System.out.println("Found at location " + loc);
                else
                    System.out.println("Not in list");
                break;
            case 4:
                System.out.print("Enter the value to replace: ");
                oldVal = scan.nextInt();
                System.out.print("Enter the new value: ");
                newVal = scan.nextInt();
                list.replaceFirst(oldVal, newVal);
                break;
            case 5:
                System.out.print("Enter the value to replace: ");
                oldVal = scan.nextInt();
                System.out.print("Enter the new value: ");
                newVal = scan.nextInt();
                list.replaceAll(oldVal, newVal);
                break;
            case 7:
                list.print();
                break;
            default:
                System.out.println("Sorry, invalid choice");
            }
    }

    // -------------------------------------
    //   Prints the menu of user's choices.
    // -------------------------------------
    public static void printMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Create new list elements (** do this first!! **)");
        System.out.println("2: Sort the list using selection sort");
        System.out.println("3: Find an element in the list using linear search");
        System.out.println("4: Replace an element in the list");
        System.out.println("5: Replace all elements in the list");
        System.out.println("6: Sort the list as descending order");
        System.out.println("7: Print the list");
        System.out.print("\nEnter your choice: ");
    }
}