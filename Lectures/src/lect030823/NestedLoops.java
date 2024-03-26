package lect030823;

public class NestedLoops {

	public static boolean hasDuplicates(String text) {
		boolean duplicate = false;
		
		for (int i = 0; i < text.length(); i++) {
			for (int j = i + 1; j < text.length(); j++) {
				if (text.charAt(i) == text.charAt(j)) {
					duplicate = true;
					// forcing end of loops w/o break
					j = text.length();
					i = text.length();
				}
			}
		}
		return duplicate;
	}
	
	// trying to create hasSubstring manually
	public static int indexOf(String text, String sub) {
		int index = -1;
		for (int idText = 0; idText < text.length(); idText++) {
			boolean isSame = true;
			for (int idSub = 0; idSub < sub.length(); idSub++) {
				if (text.charAt(idText + idSub) == sub.charAt(idSub)) {
					isSame = false;
				}
			}
			if (isSame) {
				index = idText;
			}
		}
		
		return index;
	}

	public static void main(String args[]) {
		int x = 0;
		int y = 0;

		while (x < 10) {
			y = 0;
			while (y < 10) {
				System.out.println("X: " + x + " Y: " + y);
				y++;
			}
			x++;
		}
		
		
		System.out.println(hasDuplicates("here"));
		System.out.println(hasDuplicates("bat"));
	}
}
