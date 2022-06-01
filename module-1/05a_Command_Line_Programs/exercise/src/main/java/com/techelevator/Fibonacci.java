package com.techelevator;

import java.util.Scanner;

public class Fibonacci {


	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		String integerInput = userInput.nextLine();
		int number = Integer.parseInt(integerInput);
		int a = 0;
		int b = 1;
		for(int i=0; i<=number; i++){

			System.out.print(a+ " ,");

			int c=a+b;
			a=b;
			b=c;

			if(a>number){
				break;
			}

		}

	}

}
