package lect032223;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCodeExamples {

	private static int maxRating = 5;

	public static void makeReverse(int[] arr) {
		int[] reverse = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			reverse[arr.length - i - 1] = arr[i];
		}

		// note: does not work; simply swapping pointers for the arrays
		// arr = reverse;

		// to equate to arrays, you need to actually iterate through and modify the
		// array (unless you are actually returning the 'array', in which case the
		// pointer swap might work)
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reverse[i];
		}
	}

	public static int[] removeElement(int[] arr, int removeIdx) {
		int[] arr2 = new int[arr.length - 1];

		for (int i = 0; i < arr.length; i++) {
			if (i >= removeIdx) {
				arr2[i] = arr[+1];
			} else {
				arr2[i] = arr[i];
			}
		}

		return arr2;
	}

	public static int[] insertElement(int[] arr, int position, int value) {
		int[] arr2 = new int[arr.length + 1];

		for (int i = 0; i < arr2.length; i++) {
			if (i < position) {
				arr2[i] = arr[i];
			} else if (i == position) {
				arr2[i] = value;
			} else {
				arr2[i] = arr[i - 1];
			}
		}

		return arr2;
	}

	public static void main(String args[]) {
		Rectangle[] rects = new Rectangle[2];
		rects[0] = new Rectangle(10, 5);
		rects[1] = new Rectangle(100, 100);

		// copies array correctly, but the array consists of pointers to rectangle
		// objects. Thus, the two arrays reference the same objects.
		Rectangle[] shallowCopyRects = Arrays.copyOf(rects, rects.length);

		System.out.println(shallowCopyRects[0].getWidth());
		rects[0].grow(10, 10);
		System.out.println(shallowCopyRects[0].getWidth());

		int[] ratings = new int[maxRating];
		Scanner scnr = new Scanner(System.in);

		System.out.println("Enter a rating 1 to 5 (or -1 to quit: ");
		// int rating = scnr.nextInt();
		int rating = -1;

		while (rating != -1) {

			ratings[rating - 1]++;

			System.out.println("Enter a rating 1 to 5 (or -1 to quit: ");
			rating = scnr.nextInt();
		}

		String str = Arrays.toString(ratings);
		System.out.println(str);
		scnr.close();
	}
}