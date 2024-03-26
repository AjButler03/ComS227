package lect022223;

public class RangesAndLogic {
	public static void main(String args[]) {
		boolean isA = true;
		boolean isB = true;
		int x = 5;
		int age = 67;
		// *, /
		// + -
		// ==, <=, !=
		// &&
		// ||
		// =
		isA = x == 5 && isB || x > 10;
		// true && isB || false
		// true && true
		// true
		
		
		// version 1
		if (isA) {
			System.out.println("A is true");
			if (isB) {
				System.out.println("B is true");
			}
		}
		
		//version 2
		if (isA && isB) {
			System.out.println("A is true");
			System.out.println("B is true");
		} else if (isA) {
			System.out.println("A is true");
		}
		
		
		// version 1
		if (age < 12 || age > 65) {
			System.out.println("discount");
		}
	}
}
