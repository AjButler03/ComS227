package lect041223;

// import java.util.Arrays;

public class BinarySearch {
	public static boolean contains(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return true;
			}
		}
		return false;
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		// base case for if not found
		if (start > end) {
			return -1;
		}
		// recursive case
		int midval = (start + end) /2;
		if (arr[midval] == target) {
			return midval;
		} else if (target < arr[midval]) {
			return binarySearch(arr, target, start, midval-  1);
		} else {
			return binarySearch(arr, target, midval + 1, end);
		} 
	}
	
//	public static void mergeSort(int[] arr) {
//		// base case
//		if (arr.length <= 1) {
//			return;
//		}
//		
//		// split into two new arrays
//		int firstLength = arr.length /2;
//		int[] first = Arrays.copyOf(arr,  firstLength);
//		int[] second = Arrays.copyOfRange(arr, firstLength +1, arr.length -1);
//		
//		mergeSort(first);
//		mergeSort(second);
//		
//		merge(first, second, arr);
//	}
//	
//	
//	public static void merge(int[] a, int[] b, int[] arr) {
//		int[] result
//		
//		int i = 0; 
//		int j = 0;
//		final int iMax = a.length;
//		final int jMax = b.length;
//		int k = 0;
//		
//		while (i < iMax && j < jMax){
//			if (a[i] < b[j]) {
//				result[k] = a[i];
//				i++;
//				k++;
//			}
//		}
//		
//	}
	
	
	public static void main(String args[]) {
		int[] arr = {1, 2, 5, 6, 10, 12, 25, 40, 45, 67, 78, 89};
		System.out.println(binarySearch(arr, 12, 0, arr.length));
	}
}
