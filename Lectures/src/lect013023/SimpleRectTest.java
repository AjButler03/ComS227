package lect013023;

public class SimpleRectTest {
	public static void main(String args[]) {
		
		// variable r of type SimpleRectangle
		SimpleRectangle r1;
		// calling constructors
		r1 = new SimpleRectangle(10, 5);
		SimpleRectangle r2 = new SimpleRectangle(100, 100);
		
		// calling accessors
		System.out.println("r1 width and height");
		System.out.println(r1.getHeight());
		System.out.println(r1.getWidth());
		
		System.out.println("r2 width and height");
		System.out.println(r2.getHeight());
		System.out.println(r2.getWidth());
		
		System.out.println("area of r1 and r2");
		System.out.println(r1.getArea());
		System.out.println(r2.getArea());
		
		// call grow
		r1.grow(2,2);
		System.out.println("Height: " + r1.getHeight() + " Width: " + r1.getWidth());
		
		
	}
}
