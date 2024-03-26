package lect022423;

public class LeapYearCalculator {
	/**
	 * every year that divides by 4 is a leap year except if it divides by 100 then
	 * it is not a leap year except if it divides by 400, in which case it is a leap
	 * year
	 * 
	 */
	public static boolean isLeapYear(int year) {
		boolean answer = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					answer = true;
				}
			} else {
				answer = true;
			}
		}

		return answer;
	}

	public static boolean isLeapYearV2(int year) {
		boolean answer = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			answer = true;
		}
		return answer;
	}

	// if we are just evaluating true/ false, why not just return the true/false
	// expression itself?
	public static boolean isLeapYearV3(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	/**
	 * print all leap year between start and end years
	 * 
	 * @param startYear
	 * @param endYear
	 */
	public static void displayLeapYears(int startYear, int endYear) {
		int year = startYear;
		while (year <= endYear) {
			if (isLeapYearV3(year)) {
				System.out.println(year + " is a leap year");
			}
			year++;
		}
	}

	public static void main(String args[]) {
		displayLeapYears(2000, 2100);
	}
}
