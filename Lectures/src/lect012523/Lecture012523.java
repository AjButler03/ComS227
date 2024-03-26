package lect012523;

public class Lecture012523 {
	
	// method definition (function, but java has to be special)
	private static String greet(int id) {
		return "Hello user " + id + "!";
	}
	
	public static void main(String args[]) {
		
		// doubles are stored in a limited space (64 bits), so there is a limit to their precision.
		// this can lead to some inaccuracies.
//		double d = 29;
//		double d2 = d/ 100 * 100;
//		System.out.println(d);
//		System.out.println(d2);
		
		// compiles, but will be a runtime exception
		// int datatype does not have any provision for infinity or undefined
//		int x = 1 / 0;
//		System.out.println(x);
		
		// double has the provision for infinity, so it can actually run w/o runtime exception.
//		double x = 1.0 / 0.0;
//		System.out.println(x);
		
		// calling math library
//		System.out.println(Math.sqrt(25));
		// doubles have concept of undef, or not a number (NaN)
//		System.out.println(Math.sqrt(-25));
		
		System.out.println(greet(1));
		System.out.println(greet(2));
		
		
		
	}
}
