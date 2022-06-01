package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String tempInput = userInput.nextLine();
		int temperature = Integer.parseInt(tempInput);

		System.out.print("Is the temperature in (C)elsiusk or (F)ahrenheit?: ");
		String scaleInput= userInput.nextLine();
		if("F".equals(scaleInput)) {
			int temperatureCelsius = (int) ((temperature - 32) / 1.8);
			System.out.println(temperature + " F is " + temperatureCelsius + " C.");
		}
		else if("C".equals(scaleInput)){
			int temperatureFah = (int)((temperature*1.8)+32);
			System.out.println(temperature+ "C is "+temperatureFah+" F.");

		}





	}

}
