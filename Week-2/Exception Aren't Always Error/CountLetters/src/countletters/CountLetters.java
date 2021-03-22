package countletters;
// ****************************************************************
// CountLetters.java
//
// Reads a words from the standard input and prints the number of
// occurences of each letter in that word.
//
// Modified by Mohammad Rizky Maulidhan (191524049).
// ****************************************************************
import java.util.Scanner;
public class CountLetters {
    public static void main(String[] args) {
	int[] counts = new int[26];
	Scanner scan = new Scanner(System.in);
	//get word from user
	System.out.print("Enter a phrase: ");
	String word = scan.nextLine();
	//convert to all upper case
	word = word.toUpperCase();
	//count frequency of each letter in string
	for (int i=0; i < word.length(); i++) {
            // Put the body of the first loop in a try
            try {
		 counts[word.charAt(i)-'A']++;
            }
            // Add a catch that catches the exception
            catch(ArrayIndexOutOfBoundsException e) {
            	System.err.println("\"" + word.charAt(i) + "\"" + " Not a letter");
            }
	}
	//print frequencies
	System.out.println();
	for (int i=0; i < counts.length; i++)
	    if (counts [i] != 0)
		System.out.println((char)(i +'A') + ": " + counts[i]);
    }
}