package com.techelevator;

public class TempConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String tempInput = userInput.nextLine();
		int temperature = Integer.parseInt(tempInput);

		System.out.print("Is the temperature in (C)elsiusk or (F)ahrenheit?: ");
		String scaleInput= userInput.nextLine();

	}

}
