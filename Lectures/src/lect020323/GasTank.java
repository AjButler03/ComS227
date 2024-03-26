package lect020323;

public class GasTank {
	
	private double capacity;
	private double level;
	
	public GasTank(double givenCapacity) {
		capacity = givenCapacity;
		level = 0.0;
	}
	
	public void add(double fuelAdded) {
		level += fuelAdded;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public double getLevel() {
		return level;
	}
}