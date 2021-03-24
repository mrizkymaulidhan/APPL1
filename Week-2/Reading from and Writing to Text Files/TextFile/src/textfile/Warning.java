package textfile;

// ****************************************************************************
// Warning.java
//
// Reads student data (name, semester hours, quality points) from a
// text file, computes the GPA, then writes data to another file
// if the student is placed on academic warning.
// ****************************************************************************

import java.util.Scanner;
import java.io.*;

public class Warning {
    public static void main (String[] args) {
        int creditHrs;      // number of semester hours earned
        double qualityPts;  // number of quality points earned
        double gpa;         // grade point (quality point) average
        
        String line, name;
        String inputName = "src/textfile/students.dat";
        String outputName = "src/textfile/warning.dat";
        
        File inFile;
        Scanner scanFile;
        PrintWriter outFile;
        
        try {
            // Set up scanner to input file
            inFile = new File(inputName);
            scanFile = new Scanner(inFile);
            // Set up the output file stream
            outFile = new PrintWriter(new FileWriter(outputName));
            
            // Print a header to the output file
            outFile.println ("============================");
            outFile.println ("Students on Academic Warning");
            outFile.println ("============================\n");
            
            // Process the input file, one token at a time
            while (scanFile.hasNextLine()) {
                String[] dataFile = scanFile.nextLine().split(" ");
                
                // Get the credit hours and quality points and
                name = dataFile[0];
                creditHrs = Integer.parseInt(dataFile[1]);
                qualityPts = Double.parseDouble(dataFile[2]);
                
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                gpa = qualityPts/creditHrs;
                if ((gpa < 1.5 && creditHrs < 30) || 
                        (gpa < 1.75 && creditHrs < 60) ||
                        (gpa < 2.0 && creditHrs >= 60))
                    outFile.write(name + " " + creditHrs + " " + gpa + "\n");
            }
            // Close output file
            outFile.close();
        }catch (FileNotFoundException exception){
            System.out.println ("The file " + inputName + " was not found.");
        }catch (IOException exception){
            System.out.println (exception);
        }catch (NumberFormatException e){
            System.out.println ("Format error in input file: " + e);
        }
    }
}