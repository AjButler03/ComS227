package lect022723;

import java.util.Random;

public class Exam1Review {
	public static String creatID(String firstName, String lastName) {
		Random rand = new Random();
		String id = "";
		id = id + firstName.charAt(0);
		id += id;
		id += rand.nextInt(50) + 1;
		return id;
	}
}