package lect032923;

import java.util.Arrays;

public class Arrays2D {
	
	// using normal for loops
	/**
	 * calculating the sum of every item in a 2d array of integers
	 * @param arr
	 * @return
	 */
	public static int calcSum(int[][] arr) {
		int sum = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				sum += arr[row][col];
			}
		}
		
		return sum;
	}
	
	// using for each loops
	public static int calcSum2(int[][] arr) {
		int sum = 0;
		for (int[] row : arr) {
			for (int value : row) {
				sum += value;
			}
		}
		
		return sum;
	}
	/**
	 * calculating the sum of each column; like if you were adding for financial reasons
	 * @param arr
	 * @return
	 */
	public static int[] calcSumOfColumns(int[][] arr) {
		int[] sums = new int[arr[0].length];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				sums[col] += arr[row][col];
			}
		}
		return sums;
	}
	
	public static void main(String args[]) {
		int[][] arr = new int[2][3]; // 2 rows, 3 columns
		
		System.out.println(arr[0][2]);
		
		//int[] row0 = arr[0];
		
		// can replace pointer
		arr[0] = new int[10];
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		arr[0][2] = 42;
		
		// copy 2D array
		// version 1
//		int[][] copyArr = arr;
//		// no do; only copies pointer. The original array is still un-copied.
//		copyArr[1][1] = 100;
//		System.out.println(arr[1][1]);
		
		// version 2
		// copies outer array, but still only copies the pointers that are stored inside.
//		int[][] copyArr = Arrays.copyOf(arr,  arr.length);
//		
//		copyArr[1][1] = 100;
//		System.out.println(arr[1][1]);
		
		// version 3
		/*
		int[][] copyArr = new int[arr.length][arr[0].length];
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				copyArr[row][col] = arr[row][col];
			}
		}
		
		copyArr[1][1] = 100;
		System.out.println(arr[1][1]);
		*/
		
		// version 4
		int[][] copyArr = new int[arr.length][];
		
		for (int row = 0; row < arr.length; row++) {
			copyArr[row] = Arrays.copyOf(arr[row], arr[row].length);
		}
		
		copyArr[1][1] = 100;
		System.out.println(arr[1][1]);
		
		
	}
}
