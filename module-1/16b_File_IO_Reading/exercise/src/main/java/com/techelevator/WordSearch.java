package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;


public class WordSearch {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("What is the fully qualified name of the file that should be searched? ");
		String filePath = sc.nextLine();

		System.out.println("What is the search word you are looking for? ");
		String word = sc.nextLine();

		System.out.println("Should the search be case sensitive? (Y\\N)? ");
		String caseS = sc.nextLine();

		File file = new File(filePath);

		int i = 0;
		try (Scanner fileInput = new Scanner(file)) {
			while (fileInput.hasNextLine()) {
				String lineOfInput = fileInput.nextLine();
				i++;

				if(caseS.equals("Y")) {
					if (lineOfInput.contains(word)) {
						System.out.println(i + ") " + lineOfInput);
					}
				}
				else{
					if(lineOfInput.toLowerCase().contains(word.toLowerCase())){
						System.out.println(i + ") " + lineOfInput);
					}
				}

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("The file was not found: " + filePath);
		}

	}

}