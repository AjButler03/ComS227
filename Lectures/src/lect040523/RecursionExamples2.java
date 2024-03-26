package lect040523;

import java.io.File;
import java.util.ArrayList;

public class RecursionExamples2 {
	
	/**
	 * finding all permutations of a string's characters
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static ArrayList<String> permutations(String s){
		ArrayList<String> list = new ArrayList<String>();
		
		// base case
		if (s.length() == 1) {
			list.add(s);
			return list;
		}
		
		// recursive case
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String sub = s.substring(0, i) + s.substring(i + 1);
			
			ArrayList<String> subList = permutations(sub);
			
			for (String subStr : subList) {
				list.add(ch + subStr);
			}
		}
		
		return list;
	}
	
	/**
	 * lists files and directories contained in the specified directory
	 * @param f
	 */
	public static void listOneLevel(File f) {
		File[] files = f.listFiles();
		
		for (File g : files) {
			System.out.println(g.getName() + " is a directory " + g.isDirectory());
		}
	}
	
	/**
	 * lists all files and directories under directory
	 * @param f
	 */
	public static void listAllFiles(File f) {
		// base case
		if (f.isFile()) {
			System.out.println("File: " + f.getName());
		}
		
		File[] subFiles = f.listFiles();
		
		for (File g : subFiles) {
			if (g.isFile()) {
				System.out.println("File: " + g.getName());
			} else {
				System.out.println("Directory: " + g.getName());
				listAllFiles(g);
			}
		}
	}
	
	private static String makeSpaces(int spaces) {
		String s = "";
		for (int i = 0; i < spaces; i++) {
			s += "   ";
		}
		
		return s;
	}
	
	/**
	 * lists all files and directories under directory
	 * now with indentation
	 * @param f
	 */
	public static void listAllFiles2(File f, int depth) {
		// base case
		if (f.isFile()) {
			System.out.println(makeSpaces(depth) + "File: " + f.getName());
		}
		
		File[] subFiles = f.listFiles();
		
		for (File g : subFiles) {
			if (g.isFile()) {
				System.out.println(makeSpaces(depth) + "File: " + g.getName());
			} else {
				System.out.println(makeSpaces(depth) + "Directory: " + g.getName());
				listAllFiles2(g, depth + 1);
			}
		}
	}
	
	
	/**
	 * arraysum; adds all integers in an array.
	 * @param arr
	 * @return
	 */
	public static int arraySum(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		return arraySumRun(arr, start, end);
	}
	
	/**
	 * background code for arraySum; recursive solution.
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int arraySumRun(int[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		}
		int midval = (start + end) / 2;
		
		return arraySumRun(arr, start, midval) + arraySumRun(arr, midval + 1, end);
	}
	
	
	public static void main(String args[]) {
		System.out.println(permutations("abc"));
		File file = new File(".");
		//listOneLevel(file);
		System.out.println("");
		//listAllFiles(file);
		listAllFiles2(file, 0);
		System.out.println("");
		int[] arr = {5, 5, 5, 5, 5, 5};
		
		System.out.println(arraySum(arr));
		
	}
}
