package lect042423;

public abstract class Vehicle implements Steerable, Fuelable{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	// abstract method; all subclasses of vehicle must have this defined, but it doesn't actually do anything in vehicle itself
	public abstract void drive(int miles);
}
