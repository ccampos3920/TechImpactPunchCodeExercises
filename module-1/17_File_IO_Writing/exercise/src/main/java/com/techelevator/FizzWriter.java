package com.techelevator;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		System.out.println("What is the destination file?");
		String dFile = sc.nextLine();

		File destinationFile = new File(dFile);


		try(PrintWriter dataOutput = new PrintWriter(destinationFile.getAbsoluteFile())){
			for(int i = 1; i<301; i++){
				if(i%3==0 && i%5==0){
					dataOutput.println("FizzBuzz");
				}
				else if(i%3==0){
					dataOutput.println("Fizz");
				}
				else if(i%5==0){
					dataOutput.println("Buzz");
				}
				else{
					dataOutput.println(i);
				}
			}

		}
		catch(FileNotFoundException e){
			System.out.println("The destination file "+ dFile + " is not found, please try again.");
		}

	}

}

