package lect050123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExamples {
	public static double findAverageFromFile(File file) {
		Scanner scnr;
		int total = 0;
		int count = 0;
		
		try {
			scnr = new Scanner(file);
			while (scnr.hasNext()) {
				total += scnr.nextInt();
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count != 0) {
			return total / count;
		} else {
			return 0;
		}
		
	}
	
	
	public static void main(String args[]) {
		File file = new File("example.txt");
		findAverageFromFile(file);
		
		System.out.println("Continuing with rest of program");
	}
}
