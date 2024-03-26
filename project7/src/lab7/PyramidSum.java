package lab7;

public class PyramidSum {
	public static int maxVal(int[] arr, int start, int end) {
		
		// basecase
		if (start == end) {
			return arr[start];
		}
		int midPoint = (start + end) / 2;
		
		return Math.max(maxVal(arr, start, midPoint), maxVal(arr, midPoint + 1, end));
		
	}
	
	public static int getPyramidCount(int levels) {
		
		if (levels == 1) {
			return 1;
		}
		
		return (levels * levels) + getPyramidCount(levels - 1);
	}
	
	public static void main(String args[]) {
		int porgusborg = getPyramidCount(7);
		System.out.println(porgusborg);
		
		int[] test = {3, 4, 5, 1, 2, 3, 2};
	    int result = maxVal(test, 0, test.length -1);
	    System.out.println(result);
	}
}
