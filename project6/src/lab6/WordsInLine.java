package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsInLine {
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("story.txt");
		int count;
		int line = 1;
		Scanner scnr = new Scanner(file);
		while (scnr.hasNextLine()) {
			count = 0;
			Scanner scnr2 = new Scanner(scnr.nextLine());
			while (scnr2.hasNext()){
				scnr2.next();
				count++;
			}
			System.out.println("Line " + line + " has " + count + " words");
			line++;
			scnr2.close();
		}
		scnr.close();
	}
}
