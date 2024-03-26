package lect040723;

import java.util.ArrayList;

public class Search {
	
	// helper to find smallest # after certain index
	private static int indexOfMin(int[] arr, int startIdx) {
		int minIdx = startIdx;
		for (int i = startIdx; i < arr.length; i++ ) {
			if (arr[i] < arr[minIdx]){
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	// helper to swap items in array
	private static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		
		arr[from] = arr[to];
		arr[to] = temp;
	}
	
	
	public static void sort(int[] arr) {
		for (int unsortedIdx = 0; unsortedIdx < arr.length; unsortedIdx++) {
			// find the next smallest thing after (and including) unsortedIdx
			int minIdx = indexOfMin(arr, unsortedIdx);
			// swap unsortedIdx for smallest thing
			
			swap(arr, minIdx, unsortedIdx);
}
	}
	
	public static boolean seach(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * fibonacci sequence
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		// base case
		if (n < 2) {
			return n;
		}
		
		// recursion
		return fib(n-2) + fib(n-1);
	}
	
	
	// memoisation
	// remembering calculated values
	
	/**
	 * non-recursive fibonacci sequence
	 * loop based
	 * @param n
	 */
	public static int fibdp(int n) {
		ArrayList<Integer> fibs = new ArrayList<Integer>();
		fibs.add(0);
		fibs.add(1);
		
		for (int i = 2; i < n; i++) {
			int fibi = fibs.get(i-2) + fibs.get(i - 1);
			fibs.add(fibi);
		}
		
		return fibs.get(n - 1);
	}
		
	public static int fib3(int n) {
		int prev1 = 0;
		int prev2 = 1;
		int current = 0;
		
		if (n < 2) {
			return n;
		}
		
		for (int i = 2; i < n; i++) {
			current = prev1 + prev2;
			prev1 = prev2;
			prev2 = current;
		}
		
		return current;
	}
	
	
	public static void main(String args[]) {
		
	}
}
