package lab5;

import java.util.Scanner;

public class Check1 {
	public static void main(String args[]) {
		// example of getting initials
		System.out.println("Initials of 'Andrew joseph Butler': " + getInitials("Andrew joseph Butler"));
		
		// example of getting index of first vowel in string
		System.out.println("Index of first vowel in 'Hello': " + getFirstVowelIndex("Hello"));
		
		// example of not finding vowel
		System.out.println("Index of first vowel in 'HlFp': " + getFirstVowelIndex("HlFP"));
	}
	
	public static String getInitials(String input) {
		String initialsString = "";
		Scanner scnr = new Scanner(input);
		while (scnr.hasNext()) {
			String temp = scnr.next();
			initialsString += temp.charAt(0);
		}
		scnr.close();
		return initialsString;
	}
	
	public static int getFirstVowelIndex(String input) {
		int index = -1;
		for (int i = 0; i < input.length(); i++) {
			if ("aeiouAEIOU".indexOf(input.charAt(i)) >= 0) {
				index = i;
				break;
			}
		}
		return index;
	}
}
