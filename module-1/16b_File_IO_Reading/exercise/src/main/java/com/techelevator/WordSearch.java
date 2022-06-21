package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		File file = new File("alices_adventures_in_wonderland.txt");
		Scanner dataInput = new Scanner("alices_adventures_in_wonderland.txt");

		while(!dataInput.hasNextLine()){
		String lineOfInput = dataInput.nextLine();
		System.out.println(lineOfInput + " ");
		}

	}

}
