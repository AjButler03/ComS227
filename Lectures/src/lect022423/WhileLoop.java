package lect022423;

import java.util.Scanner;

public class WhileLoop {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Continue (y/n): ");
		String input = scnr.next();
		
		while (input.equals("y")) {
			System.out.println("Hello");
			System.out.println("Continue (y/n): ");
			input = scnr.next();
		} 
		System.out.println("Goodbye");
		countToTen();
		System.out.println(howLongDoesItGo(100) + " days");
		scnr.close();
	}
	
	public static void countToTen() {
		int count = 0;
		while (count < 10) {
			count += 1;
			System.out.println(count);
		}
	}
	/**
	 * eat for %20, leave 10% tip, start with d dollars how long until out of money?
	 * @param d
	 * @return
	 */
	public static int howLongDoesItGo(double d) {
		int days = 0;
		// while you can still pay for the $20 meal
		while (d > 20) {
			d -= 20;
			d *= 0.9;
			days ++;
		}
		return days;
	}
}
