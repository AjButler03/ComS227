package lect022723;
import java.util.Scanner;
public class EggsProblem {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("How many eggs? ");
		int eggs = scnr.nextInt();
		System.out.println("DO you want brown eggs? (yes/no)");
		String brown = scnr.next();
		int flats = eggs / 30;
		eggs %= 30;
		int dozens = eggs / 12;
		eggs %= 12;
		int halfDozens = (eggs + 5) / 6;
		
		double price = flats * 6.5 + dozens * 3 + halfDozens * 2;
		
		if (brown.equals("yes")) {
			price *= 1.2;
		}
		System.out.println("Total: " + price);
		scnr.close();
	}
}
