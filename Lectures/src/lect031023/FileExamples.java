package lect031023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileExamples {
	public static void main(String args[]) {
		/*
		double number = 2/3.0;
		int integer = 4;
		System.out.printf("The answer is %10.3f and %d", number, integer);
		*/
		
		File file = new File("C:\\Users\\andre\\Documents\\coms227\\Lectures\\src\\ReadMe.txt");
		
		if (file.exists()) {
			System.out.println("File exists");
		} else {
			System.out.println("file does not exist");
		}
		Scanner scnr;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
			return;
		}
		
		readAllLines(scnr);
		scnr.close();
	}
	
	
	public static void readAllLines (Scanner scnr) {
		System.out.println(scnr.nextLine());
		
		while (scnr.hasNextLine()) {
			String line = scnr.nextLine();
			System.out.println(line);
			System.out.println(parseLine(line));
		}
	}
	
	/**
	 * parse a line with format like joe 345 234 456 345
	 * return the name 234
	 * @param line
	 * @return
	 */
	public static String parseLine(String line) {
		Scanner scnr = new Scanner(line);
		String name = scnr.next();
		int sum = 0;
		int count = 0;
		while (scnr.hasNextInt()) {
			sum += scnr.nextInt();
			count++;
		}
		double avg = sum / count;
		scnr.close();
		return name + " " + avg;
	}
}
