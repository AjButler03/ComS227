package lect012723;

import java.awt.Rectangle;

public class Lecture012723 {
	
	private static double findArea(double width, double height) {
		double area = width * height;
		return area;
	}
	
	public static double average(double x, double y) {
		return (x + y) / 2;
	}
	
	public static void main(String args[]) {
		
		Rectangle happyRectangle = new Rectangle(10, 50);
		Rectangle sadRectangle = new Rectangle(10, 70);
		
		// calling a thing, something something
		System.out.println(happyRectangle.getWidth());
		System.out.println(happyRectangle.getHeight());
		
		System.out.println(sadRectangle.getWidth());
		System.out.println(sadRectangle.getHeight());
		
		// calling local static methods within same class (in this case, class Lecture012723).
		// does not require object; simply take in arguments and does it's thing
		System.out.println(average(findArea(5, 5), findArea(10, 5)));
	}
}
