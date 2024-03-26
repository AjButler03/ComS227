package lab7;

import java.io.File;

public class CheckPoint2 {

	private static int countFiles(File file) {
		int numFiles = 0;

		if (!file.isDirectory()) {
			return numFiles + 1;
		} else {
			// recursively search the subdirectory
			for (File f : file.listFiles()) {
				numFiles += countFiles(f);
			}
		}

		return numFiles;
	}

	public static int countPatterns(int n) {
		// base case(s)
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		// recursive code
		int count = 0;
		count += countPatterns(n - 1);
		count += countPatterns(n - 3);
		return count;
	}

	public static void main(String args[]) {
		File file = new File("../project6");

		int numFiles = countFiles(file);
		System.out.println(numFiles);
		
		System.out.println(countPatterns(9));
		
	}
}
