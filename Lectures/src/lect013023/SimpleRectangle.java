package lect013023;

// class definition
public class SimpleRectangle {
	
	// initializing instance variables
	// note: always make instance variables private or static so that variables are inaccessible outside this class
	private double width;
	private double height;
	
	// constructor
	public SimpleRectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	// "accessor" or "getter" methods, retrieves value from within class.
	//returns the height of the rectangle.
	public double getHeight() {
		return height;
	}
	// returns the width of the rectangle.
	public double getWidth() {
		return width;
	}
	
	public double getArea() {
		return width * height;
	}
	
	/**
	 * Grows the rectangle by the given number of units in the 
	 * horizontal and vertical directions. Grows at twice the 
	 * given values.
	 * 
	 * 
	 * @param w amount to grow horizontal
	 * @param h amount to grow vertical
	 */
	public void grow(double w, double h) {
		height = height + (w * 2);
		width = width + (w * 2);
	}
	
	// mutator (setter) method; sets value for something(s)
	// sets the height of rectangle.
	public void setHeight(double height) {
		// "this" keyword specifies instance variable; as in "the height variable of this object"
		// or, you know, just name the local height newHeight or something.
		this.height = height;
	}
	
	//sets the width of rectangle.
	public void setWidth(double width) {
		this.width = width;
	}
}