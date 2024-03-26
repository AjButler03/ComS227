package lect030123;

public class CountToTen {
	public static void main(String args[]) {
		// 1 initialize
		int count = 1;
		
		// 2 boolean expression
		while (count <= 10) {
			System.out.println(count);
			
			// 3 modify the variable under test
			count++;
		}
		
		
		
		// 1, 2, and 3 in one line
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		System.out.println(reverse("The"));
	}
	
	public static String reverse(String str) {
		String reverseStr = "";
		for (int i = str.length() -1; i >= 0; i--) {
			reverseStr += str.charAt(i);
		}
		return reverseStr;
	}
}