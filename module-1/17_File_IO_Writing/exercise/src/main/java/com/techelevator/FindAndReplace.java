package com.techelevator;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;

public class FindAndReplace {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // User questions/input
    System.out.println("What is the search word? ");
    String sWord = sc.nextLine();

    System.out.println("What is the replacement word? ");
    String rWord = sc.nextLine();

    System.out.println("What is the source file? ");
    String sFile = sc.nextLine();

    System.out.println("What is the destination file? ");
    String dFile = sc.nextLine();

    File sourceFile = new File(sFile);
    File destinationFile  = new File(dFile);

    try(Scanner dataInput = new Scanner(sourceFile.getAbsoluteFile());
        PrintWriter dataOutput = new PrintWriter(destinationFile.getAbsoluteFile())){
            while(dataInput.hasNextLine()){
                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replaceAll(sWord, rWord));

            }

    }
    catch (FileNotFoundException e) {
        System.out.println("The file " + sFile + " Was not found, please try again");
    }

    }


}
