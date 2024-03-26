package lab3;

public class Basketball {
	private boolean inflated;
	private double diameter;
	
	
	public Basketball(double givenDiameter) {
		inflated = false;
		diameter = givenDiameter;
	}
	
	public boolean isDribbleable() {
		return inflated;
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public double getCircumference() {
		return 2 * Math.PI * (diameter / 2.0);
	}
	
	public void inflate() {
		inflated = true;
	}
}
