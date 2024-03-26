package test;

public class Exam2Testing {
	public static boolean containsDuplicateMatch(int[] arr, int seqStart, int seqLength) {
		boolean dupFound = false;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			// checking if item at index i matches with item in duplicate;
			// does this by comparing the item to the item in the sequence, and making sure
			// the index does not match (and is thus not detecting the original sequence)
			if (arr[i] == arr[seqStart + count] && i != seqStart + count) {
				count++;
				if (count == seqLength) {
					// dupFound = true;
					return true;
				}
			} else {
				count = 0;
			}
		}
		return dupFound;
	}

	public static void main(String[] args) {
		// example 1; should return true
		int[] arr = { 0, 0, 1, 2, 3, 0, 0, 1, 2, 3, 0 };
		int seqStart = 7;
		int seqLength = 3;
		
		System.out.println("Example #1; expect true");
		System.out.println(containsDuplicateMatch(arr, seqStart, seqLength) + "\n");

		
		
		// example 2; return false
		int[] arr2 = { 0, 0, 1, 2, 1, 2, 3, 3, 0 };
		int seqStart2 = 4;
		int seqLength2 = 3;

		System.out.println("Example #2; expect false");
		System.out.println(containsDuplicateMatch(arr2, seqStart2, seqLength2) + "\n");

		
		
		// example 3; should return true
		int[] arr3 = { 1, 2, 1, 2, 1, 0 };
		int seqStart3 = 2;
		int seqLength3 = 3;

		System.out.println("Example #3; expect true");
		System.out.println(containsDuplicateMatch(arr3, seqStart3, seqLength3) + "\n");
	}

}
