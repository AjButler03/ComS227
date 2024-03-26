package lect021523;

public class Max {
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	
	// Version 1
	public static int maxOf3(int a, int b, int c) {
		int max;
		if (a > b) {
			if (a > c) {
				max = a;
			} else {
				max = c;
			}
		} else if (b > a) {
			if ( b > c) {
				max = b;
			} else {
				max = c;
			}
		} else {
			max = c;
		}
		return max;
	}
	
	public static int maxOf3V2(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		} else if (c > max) {
			max = c;
		}
		return max;
	}
}