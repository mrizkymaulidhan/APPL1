package copyfile;
// **************************************************************************
// CopyFile.java
// 
// Program that prompts the user for a filename, then opens a Scanner to the
// file and copies it, a line at a time, to the standard output.
//
// Written by Mohammad Rizky Maulidhan (191524049).
// **************************************************************************
import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        String fileName;
        boolean isFound = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scFile = null;
        File file;
        
        while(!isFound) {
            System.out.print("Input file name: ");
            fileName = scanner.next();
            file = new File("src/copyfile/"+fileName+".txt");
            try {
                scFile = new Scanner(file);
                isFound = true;
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found!!");
            }
        }
        
        if(isFound = true) {
            while (scFile.hasNextLine()){
                 System.out.println(scFile.nextLine());
            }
        }
    }
}