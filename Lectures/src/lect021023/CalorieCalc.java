package lect021023;

//import java.util.Scanner;

public class CalorieCalc {
	final static double FEET_PER_STEP = 2.5; // Typical adult
	final static int FEET_PER_MILE = 5280;
	final static double STEPS_PER_MINUTE = 70.0; // Typical adult
	final static double CALORIES_PER_MINUTE_WALKING = 3.5; // Typical adult
	
	
	public static int inputStepsWalked() {
		//Scanner scnr = new Scanner(System.in);
		System.out.print("Enter number of steps walked: ");
		//return scnr.nextInt();
		return 1;
	}
	
	public static double convertStepsToMiles(double steps) {
		return steps * FEET_PER_STEP * (1.0 / FEET_PER_MILE);
	}
	
	public static double convertStepsToCalories(double steps) {
		double minutes = steps / STEPS_PER_MINUTE;
		return minutes * CALORIES_PER_MINUTE_WALKING;
	}
	
	public static void displayResults(double milesWalked, double caloriesTotal) {
		System.out.println("Miles walked: " + milesWalked);
		System.out.println("Calories: " + caloriesTotal);
	}
	
	public static void main(String args[]) {
		// input
		int steps = inputStepsWalked();
		
		// processing
		double milesWalked = convertStepsToMiles(steps);
		double caloriesTotal = convertStepsToCalories(steps);
		
		// output
		displayResults(milesWalked, caloriesTotal);
	}
}

/*
 * methods do one thing and one thing only
 * try to keep main fairly simple, as to keep the programs purpose obvious
 */
