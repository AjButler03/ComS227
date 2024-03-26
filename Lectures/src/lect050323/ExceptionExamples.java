package lect050323;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class ExceptionExamples {
//	public static double getValueFromFile(File file) throws InvalidFormatException {
//		double result = 0;
//		Scanner scnr = null;
//		
//		try {
//			scnr = new Scanner(file);
//			result = scnr.nextDouble();
//			if (result < 0) {
//				InvalidFormatException e = new InvalidFormatException("File contains negative number");
//				throw e;
//			}
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("File is not available");
//		} finally {
//			// runs regardless of if exception occurred or not
//			scnr.close();
//		}
//		
//		return result;
//	}
//	
//	
//	public static void main(String args[]) {
//		File file = new File("Example.txt");
//		getValueFromFile(file);
//	}
//	
//	class InvalidFormatException extends Exception {
//		public InvalidFormatException(String message) {
//			super(message);
//		}
//	}
//}



// semester is basically over, so I'm not paying attention anymore