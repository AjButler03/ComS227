package lect032023;

import java.util.Arrays;

public class ArrayExamples {
	public static void printReverse(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

	/**
	 * finding if array has any duplicate entries; it either does or it doesn't.
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean hasDuplicate(int[] arr) {
		boolean duplicate = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicate = true;
				}
			}
		}

		return duplicate;
	}

	/**
	 * any negative number entries will be set to zero. note: the array that is
	 * passed to the method is simply a pointer to the actual array. Thus, when the
	 * array is changed in the method, that change persists outside the method.
	 * 
	 * @param arr
	 */
	public static void clampToZero(int[] arr) {
		// declared an array variable
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				arr[i] = 0;
			}
		}
	}

	public static String makeReverse(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		return reverse;
	}

	public static int[] makeReverse2(int[] arr) {
		int[] reverse = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			reverse[arr.length - i - 1] = arr[i];
		}
		return reverse;
	}

	/**
	 * note: the /2 in the for loop is to ensure that everything is 'swapped' only
	 * once; if we iterate through all indexes, then the array will in effect be
	 * reversed, then reversed again.
	 * 
	 * @param arr
	 */
	public static void makeReverse3(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	public static void main(String args[]) {
		// declaring an array variable
		int[] arr;
		// initializing the array
		arr = new int[10];

		arr[0] = 52;
		arr[1] = -34;
		arr[2] = 5;
		arr[3] = 6;
		arr[4] = 7;
		arr[5] = 8;
		arr[6] = -9;
		arr[7] = 10;
		arr[8] = -11;
		arr[9] = 12;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// not wrong, just prints something that is likely unhelpful
		// System.out.println(arr);
		String str = Arrays.toString(arr);
		System.out.println(str);

		clampToZero(arr);
		System.out.println("\n");
		printReverse(arr);
		System.out.println(Arrays.toString(makeReverse2(arr)));
	}
}
