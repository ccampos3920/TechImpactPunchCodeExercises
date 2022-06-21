package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the fully qualified name of the file that should be searched? ");
		String fileName = sc.nextLine();

		System.out.println("What is the search word you are looking for?");
		String word = sc.nextLine();

		File file = new File(fileName);
		Scanner dataInput = new Scanner(fileName);
		int i = 1;

		while(dataInput.hasNextLine()){
		String lineOfInput = dataInput.nextLine();
		System.out.println(i + " " + lineOfInput);
		i++;
		}

	}

}
