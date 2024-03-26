package lect033123;

public class Recursion {
	public static void foo() {
		foo();
	}
	public static void countUp(int n) {
		// base case is if this is false
		// base case == ending recursion
		if (n > 0) {
			// recursive case
			countUp(n - 1);
			System.out.println(n);
		}
	}
	
	/**
	 * calculating factorial of given integer
	 * 5! = 5 * 4 * 3 * 2 * 1
	 * @param args
	 */
	public static int fac(int n ) {
		
		if (n == 1) {
			return 1;
		}
		// recursive case
		return n * fac(n - 1);
	}
	/**
	 * fibonacci sequence
	 * 0, 1, 1, 2, 5, 8, 13, 21...
	 * @param n nth term of fibonacci
	 * @return
	 */
	public static int fib(int n) {
		// base case
		/*
		if (n == 0) {
			return 0;
		} else if (n <= 2 ) {
			return 1;
		}
		*/
		// simpler base case, says the same thing
		if (n <= 1) {
			return n;
		}
		
		// recursive case
		return fib(n-1) + fib(n-2);
	}
	
	/**
	 * abba --> true
	 * word is the same backwards and forwards
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str) {
		// base case
		if (str.length() <= 1) {
			return true;
		}
		
		//recursive case
		return isPalindrome(str.substring(1, str.length() -1)) 
				&& str.charAt(0) == str.charAt(str.length()-1);
	}
	
	
	public static void main(String args[]) {
		countUp(5);
		System.out.println(fac(5));
		System.out.println(fib(6));
		System.out.println(isPalindrome("abba"));
	}
}
