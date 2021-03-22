package copyfile;
// **************************************************************************
// CopyFile.java
// 
// Program that prompts the user for a filename, then opens a Scanner to the
// file and copies it, a line at a time, to the standard output.

// Written by Mohammad Rizky Maulidhan (191524049).
// **************************************************************************
import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scFile = null;
        boolean isFound = false;
        String fileName;
        File file;
        
        while(!isFound) {
            System.out.print("Input file name: ");
            fileName = scanner.next();
            file = new File(fileName);
            try {
                scFile = new Scanner(file);
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found!!");
            }
            if (scFile != null)
                isFound = true;
        }
        
    }
    
}
