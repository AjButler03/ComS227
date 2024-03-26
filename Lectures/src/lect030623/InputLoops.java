package lect030623;

import java.util.Scanner;

public class InputLoops {
	public static void main(String args[]) {
		int counter = 0;
		
		// while loop
		while (counter < 10) {
			// loop body
			counter++;
		}
		
		// for loop
		for (counter = 0; counter < 10; counter++) {
			// loop body
		}
		
		
		// do-while loop
		do {
			// loop body
		} while (counter < 10);
		
		
		
		
		
	}
	
	/**
	 * An input string looks like "12 34 45 56 45"
	 * @param input
	 * @return
	 */
	public static double averageFromStringOfNumbers(String input) {
		double sum = 0;
		int numNumbers = 0;
		Scanner scnr = new Scanner(input);
		
		while (scnr.hasNextDouble()) {
			sum += scnr.nextDouble();
			numNumbers += 1;
		}
		scnr.close();
		return sum / numNumbers;
	}
	
	
	public static double averageFromConsole() {
		double sum = 0;
		int numNumbers = 0;
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter a number (q to quit): ");
		String input = scnr.next();
		
		while (!input.equals("q")) {
			System.out.print("Enter a number (q to quit): ");
			input = scnr.next();
			sum += Double.valueOf(input);
			numNumbers += 1;
		}
		scnr.close();
		return sum / numNumbers;
	}
	
	
	public static double averageFromConsoleV2() {
		double sum = 0;
		int numNumbers = 0;
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter a number (q to quit): ");
		String input;
		
		do {
			System.out.print("Enter a number (q to quit): ");
			input = scnr.next();
			if (!input.equals("q")) {
				sum += Double.valueOf(input);
				numNumbers += 1;
			}
		} while (!input.equals("q"));
		
		scnr.close();
		return sum / numNumbers;
	}
}
