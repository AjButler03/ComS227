package mini;

/**
 * Utility class with static methods for loop practice.
 */
public class LoopsInfinityAndBeyond {

	/**
	 * Private constructor to disable instantiation.
	 */
	private LoopsInfinityAndBeyond() {
	}

	/**
	 * Define a flying saucer as the following string pattern: one ‘(‘, followed by
	 * zero to many ‘=’, followed by one ‘)’. Write a Java method that, given a
	 * string find the first instance of a flying saucer (starting from the left)
	 * and return its length. If no flying saucer exists return 0.
	 * <p>
	 * For example: Given: "(==)" Return: 4
	 * <p>
	 * Given: "***()**(===)" Return: 2
	 * <p>
	 * Given: "****(***)" Return: 0
	 * 
	 * @param source input string
	 * @return the length
	 */
	public static int flyingSaucerLength(String source) {
		int length = 0;
		boolean found = false;

		for (int i = 0; i < source.length(); i++) {
			if (source.charAt(i) == '(') {
				found = true;
				length = 1;
			} else if (source.charAt(i) == '=' && found) {
				length++;
			} else if (source.charAt(i) == ')' && found) {
				return length + 1;
			} else {
				found = false;
				length = 0;
			}
		}

		return 0;
	}

	/**
	 * Write a Java method that, given a string which many contain a flying saucer
	 * broken into two parts with characters in between, return a string where the
	 * flying is fixed by removing the in between characters. Look for the two parts
	 * of the flying saucer from left to right and fix the saucer with the first
	 * available parts.
	 * <p>
	 * For example: Given: ***(==****===)*** Return: ***(=====)***
	 * <p>
	 * Given: ***(==****)**=)* Return: ***(==)**=)*
	 * <p>
	 * Given: ***(==)** Return: ***(==)**
	 * 
	 * @param s
	 * @return
	 */
	public static String fixFlyingSaucer(String s) {
		int start = -1; // index of the start of the flying saucer
		int end = -1; // index of the end of the flying saucer
		int equalsCount = 0; // count of the equals signs in the flying saucer

		// find the start and end of the flying saucer
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				start = i;
				equalsCount = 0;
			} else if (s.charAt(i) == ')') {
				end = i;
				break;
			} else if (s.charAt(i) == '=') {
				equalsCount++;
			}
		}

		// if we found the start and end, and there are equals signs, fix the flying
		// saucer
		if (start != -1 && end != -1 && equalsCount > 0) {
			return s.substring(0, start + 1) + repeat('=', equalsCount) + s.substring(end);
		} else {
			return s;
		}
	}

	private static String repeat(char c, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb.toString();

	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, return the number of flying saucers. For this problem a flying
	 * saucer may wrap around from the right side of the string to the left.
	 * <p>
	 * For example: Given: ***(===)*** Return: 1
	 * <p>
	 * Given: =)**(==)**( Return: 2
	 * <p>
	 * Given: ***(=*=)** Return: 0
	 * 
	 * @param s
	 * @return
	 */
	public static int countFlyingSaucers(String s) {
		int count = 0;
		int i = 0;
		boolean endSauce = false;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				int j = i + 1;
				endSauce = false;
				while (!endSauce) {
					if (j < s.length()) {
						if (s.charAt(j) == '=') {
							j++;
						} else if (s.charAt(j) == ')') {
							endSauce = true;
							count++;
						} else {
							endSauce = true;
						}
					} else {
						if (s.charAt(j - s.length()) == '=') {
							j++;
						} else if (s.charAt(j - s.length()) == ')') {
							endSauce = true;
							count++;
						} else {
							endSauce = true;
						}
					}
				}
				i++;
			} else {
				i++;
			}
		}
		return count;
	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, shifts all of the saucers one character to the right. For this
	 * problem a flying saucer may wrap around from the right side of the string to
	 * the left. The returned string should have the same number of characters as
	 * the given string. This is achieved by moving the character to the right of a
	 * saucer to its left. It can be assumed that saucers will never be touching
	 * each other (i.e., there will always be at least one character between any two
	 * saucers). Also, a saucer will not touch itself (e.g., "=)(=").
	 * <p>
	 * For example: Given: ***(===)*** Return: ****(===)**
	 * <p>
	 * Given: =)**(==)**( Return: (=)***(==)*
	 * <p>
	 * Given: a()bcde(=*=)fg Return: ab()cde(=*=)fg
	 * 
	 * @param s
	 * @return
	 */
	public static String flyingSaucersFly(String s) {
		// it is really funny to me that these few commented out lines will get the
		// correct output for all but one test, and the monstrosity below is needed to
		// fix it for that one last test. 80-20 rule is fun.

//		String flight = "";
//		for (int i = 0; i < s.length(); i++) {
//			if (i == 0) {
//				flight += s.charAt(s.length()-1);
//			}else {
//				flight += s.charAt(i-1);
//			}
//		}
//		return flight;

		String modified = "";

		int i = 0;
		boolean endSauce = false;
		boolean isSauce = false;
		int length;
		while (i < s.length()) {
			// detecting and determining length of UFO
			if (s.charAt(i) == '(') {
				int j = i + 1;
				length = 1;
				endSauce = false;
				isSauce = false;
				while (!endSauce) {
					if (j < s.length()) {
						if (s.charAt(j) == '=') {
							j++;
							length++;
						} else if (s.charAt(j) == ')') {
							endSauce = true;
							isSauce = true;
							length++;
						} else {
							endSauce = true;
							modified += s.charAt(i);
						}
					} else {
						if (s.charAt(j - s.length()) == '=') {
							j++;
							length++;
						} else if (s.charAt(j - s.length()) == ')') {
							endSauce = true;
							isSauce = true;
							length++;
						} else {
							endSauce = true;
							modified += s.charAt(i);
						}
					}

					// If potential UFO is found to be a UFO, adding it to modified string
					if (isSauce) {
						modified += s.charAt((i + length) % s.length());
						for (int x = i; x < length + i; x++) {
							String temp = "";

							if (x < s.length() - 1) {
								modified += s.charAt(x);
							} else if (x == s.length() - 1) {
								temp += s.charAt(s.length() - 1);
							}

							modified = temp + modified;
						}
						isSauce = false;
						i += length;
					}
				}
				i++;

				// runs if current character is not '('
				// checks to see if there is a UFO immediately preceding the character
				// if so, does not add character to string at this time, as it will be added to
				// the string before that UFO when it gets detected
			} else {
				if (i == 0) {
					if (s.charAt(s.length() - 1) == ')') {
						endSauce = false;
						int j = s.length() - 2;

						while (!endSauce) {
							if (s.charAt(j) == '=') {
								j--;
							} else if (s.charAt(j) == '(') {
								endSauce = true;
							} else {
								// not a saucer, so adding character to string and ending loop
								endSauce = true;
								modified += s.charAt(i);
							}
						}
					} else {
						modified += s.charAt(i);
					}
				} else {
					if (s.charAt(i - 1) == ')') {
						endSauce = false;
						int j = i - 2;

						while (!endSauce) {
							if (j > 0) {
								if (s.charAt(j) == '=') {
									j--;
								} else if (s.charAt(j) == '(') {
									endSauce = true;
								} else {
									// not a saucer, so adding character to string and ending loop
									endSauce = true;
									modified += s.charAt(i);
								}
							} else {
								j += s.length() - 1;
							}
						}
					} else {
						modified += s.charAt(i);
					}
				}
				i++;
			}
		}
		return modified;
	}
}