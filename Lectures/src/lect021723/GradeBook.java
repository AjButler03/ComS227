package lect021723;

public class GradeBook {
	public static String getLetterGrade(int score) {
		String letter = "";
		if (score >= 90) {
			letter = "A";
		} else if (score >= 80) {
			letter = "B";
		} else if (score >= 70) {
			letter = "C";
		} else if (score >= 60) {
			letter = "D";
		} else {
			letter = "F";
		}
		return letter;
	}

	public static String getLetterGrade2(int score) {
		String letter = "F";

		if (score >= 90) {
			letter = "A";
		} else if (score >= 80) {
			letter = "B";
		} else if (score >= 70) {
			letter = "C";
		} else if (score >= 60) {
			letter = "D";
		}
		return letter;
	}

	public static double getPoints(String letter) {
		double points = 0;
		if (letter.equals("A")) {
			points = 100;
		}
		if (letter.equals("B")) {
			points = 85;
		}
		if (letter.equals("C")) {
			points = 75;
		}
		if (letter.equals("D")) {
			points = 65;
		}
		return points;
	}

	public static double getPoints2(String letter) {
		double points = 0;
		if (letter.equals("A")) {
			points = 100;
		} else if (letter.equals("B")) {
			points = 85;
		} else if (letter.equals("C")) {
			points = 75;
		} else if (letter.equals("D")) {
			points = 65;
		}
		return points;
	}
}