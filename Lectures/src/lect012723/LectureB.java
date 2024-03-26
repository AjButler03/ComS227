package lect012723;

//import java.util.Scanner;

public class LectureB {
	public static void main(String args[]) {
		System.out.println("Beans");
		String name = "Bob";
		name = "Kim";
		int nameLength = name.length();
		char firstLetter = name.charAt(0);
		System.out.println(nameLength + ", " + firstLetter);
		
		String upperName = name.toUpperCase();
		System.out.println(upperName);
		
		int charIndex = name.indexOf("i");
		System.out.println(charIndex);
		/*
		Scanner scnr = new Scanner(System.in);
		Scanner scnr2 = new Scanner("This is an example of alternate input");
		System.out.println( scnr2.next());
		System.out.println( scnr2.next());
		System.out.println( scnr2.next());
		System.out.println( scnr2.next());
		*/
		}
}
