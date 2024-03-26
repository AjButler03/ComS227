package lect032423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListExamples {
	/**
	 * given a string that looks like "23 34 56 67 34"
	 * @param text
	 * @return
	 */
	public static double findMedian(String text) {
		double median;
		Scanner scnr = new Scanner(text);
		int length = 0;
		
		while (scnr.hasNextInt()) {
			length++;
		}
		
		scnr.close();
		int[] values = new int[length];
		scnr = new Scanner(text);
		int i = 0;
		
		while (scnr.hasNextInt()) {
			values[i] = scnr.nextInt();
			i++;
		}
		
		Arrays.sort(values);
		
		// calculating median
		if (values.length % 2 == 0) {
			median = ((values.length / 2) + (values.length / 2 + 1)) / 2 ;
		} else {
			median = values.length / 2 - 1;
		}
		
		scnr.close();
		
		return median;
	}
	
	public static double findMedian2(String text) {
		double median;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scnr = new Scanner(text);
		
		while (scnr.hasNextInt()) {
			list.add(scnr.nextInt());
		}
		
		Collections.sort(list);
		
		if (list.size() % 2 == 0) {
			median = list.get(((list.size() / 2) + (list.size() / 2 + 1)) / 2) ;
		} else {
			median = list.get(list.size() / 2 - 1);
		}
		
		scnr.close();
		
		return median;
		
	}
	
	public static void main(String args[]) {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Bob");
		names.add("Kim");
		names.add("Sue");
		
		names.size();
//		for (int i = 0; i < names.size(); i++) {
//			System.out.println(names.get(i));
//		}
//		System.out.println();
		
		names.add(1, "John");
		names.remove(2);
		
//		// for each name in list of names
//		for (String name : names) {
//			System.out.println(name);
//		}
		
		System.out.println(names);
		names.remove("John");
		System.out.println(names);
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		// creating integer object with value 10
		Integer value = Integer.valueOf(10);
		ids.add(value);
		// works b/c 10 is automatically boxed into an integer object
		ids.add(10);
		
		//Integer value2 = ids.get(0);
		// converting integer object to int
		//int val = value2.intValue();
		// works b/c automatically unboxing object into primitive int
		//val = value2;
		
		
		//infinite loop; not debugging it right now. Should be 10
		//System.out.println(findMedian("12 45 0 5 10"));
		
		// should be 10, probably something wrong with my math.
		System.out.println(findMedian2("12 45 0 5 10"));
		
	}
}
