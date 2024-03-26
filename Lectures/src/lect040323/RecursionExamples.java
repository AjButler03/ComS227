package lect040323;

//import java.util.ArrayList;

public class RecursionExamples {

	/**
	 * how many permutations of string's characters
	 * 
	 * note: basically trying to recreate the algorithm that you do naturally
	 * @param text
	 * @return
	 */
//	public static ArrayList<String> permutation(String text){
//		ArrayList<String> arr = new ArrayList<String>();
//		
//		// recursion
//		for (int i = 0; i < text.length(); i++) {
//			char c = text.charAt(i);
//			String rest = 
//			arr.addAll(permutation(rest));
//		}
//		return arr;
//	}
	/**
	 * the required moves to move a tower of wider pieces such that a larger piece
	 * never sits on a smaller peg.
	 * 
	 * towers of hanoi
	 * 
	 * @param n
	 * @param srcPeg
	 * @param extraPeg
	 * @param desPeg
	 */
	public static int moves(int n, String srcPeg, String extraPeg, String desPeg) {
		// base case
		if (n == 1) {
			System.out.println("Move " + srcPeg + " to " + desPeg);
			return 1;
		}

		// recursive code
		int numMoves = 0;
		numMoves += moves(n - 1, srcPeg, desPeg, extraPeg);
		numMoves += moves(1, srcPeg, extraPeg, desPeg);
		numMoves += moves(n - 1, extraPeg, extraPeg, desPeg);
		
		return numMoves;
	}

	/**
	 * how many different ways is there to go up a specific number of stairs going 2
	 * or 3 steps at a time? Note: must be exact
	 * 
	 * ex: for 6 steps, you can do 2-2-2 or 3-3, so 2 ways note: assume that if you
	 * need to move 0 steps, then doing nothing is the correct way; so one way.
	 * 
	 * @param n
	 * @return
	 */
	public static int howManyWays(int n) {
		// base case(s)
		if (n == 0) {
			return 1;
		}
		if (n <= 1) {
			return 0;
		}

		// recursive code
		int numberOfWays = 0;
		numberOfWays += howManyWays(n - 2);
		numberOfWays += howManyWays(n - 3);
		return numberOfWays;
	}

	public static void countUp(int n) {
		if (n == 0) {
			return;
		}
		countUp(n - 1);
		System.out.println(n);
	}

	public static void main(String args[]) {
//		countUp(5);
//		System.out.println(howManyWays(6));
		System.out.println(moves(3, "A", "B", "C"));
	}
}
