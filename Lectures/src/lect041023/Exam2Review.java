package lect041023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam2Review {
	
	/**
	 * changing all vowels in a string to be underscores
	 * @param str
	 * @return
	 */
	public static String BalnkVowels(String str) {
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				result += "_";
			}else {
				result += ch;
			}
		}
		return result;
	}
	
	/**
	 * removing duplicate integers from array of integers
	 * @param arr
	 * @return
	 */
//	public static int[] removeDuplicates(int[] arr) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for (int i = 0; i < arr.length; i++) {
//			boolean isDup = false;
//			for (int j =0; j < arr.length; j++) {
//				if (arr[i] == arr[j]) {
//					isDup = true;
//				}
//			}
//			if (!isDup) {
//				list.add(arr[i]);
//			}
//		}
//		
//		int[] result = new int[list.size()];
//		for (int i = 0; i < result.length; i++) {
//			
//		}
//	}
	
	/**
	 * finding palindromes in file
	 * Grammer class given (in theory, not actually a file I have)
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<String> readPalidromes(String fileName) throws FileNotFoundException{
		ArrayList<String> result = new ArrayList<String>();
		
		File file = new File(fileName);
		Scanner scnr = new Scanner (file);
		while (scnr.hasNext()){
//			String word = scnr.next();
//			if(Grammar.isPalinDrome(word)) {
//				result.add(word);
//			}
		}
		scnr.close();
		return result;
	}
	
	
	/**
	 * shifts items or something I didn't type fast enough
	 * @param arr
	 * @return
	 */
//	public static int[][] rightShifts(int[] arr){
//		int [][] arr2d = new int[arr.length][arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i; j < arr.length; j++) {
//				
//			}
//		}
//	}
	
	
	public static void main(String args[]) {
		
	}
}
