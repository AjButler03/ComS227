package lect042823;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
	public static void main(String args[]) {
		Comparator<String> compareByStrLen = new StrLenComparator();
		
		String[] fruits = { "banana", "apple", "pear" };
		Arrays.sort(fruits);
		
		Arrays.sort(fruits, compareByStrLen);

		System.out.println(Arrays.toString(fruits));
	}
}
// should be separate file, but for sake of example it's here
class StrLenComparator implements Comparator<String> {

	/**
	 * if a > b return positive (+1) if a < b return negative (-1) if a == b return
	 * 0
	 */
	@Override
	public int compare(String a, String b) {
		// if same then value is 0, if a is larger then it's positive,
		// if b is larger then negative
		return a.length() - b.length();
	}

}
