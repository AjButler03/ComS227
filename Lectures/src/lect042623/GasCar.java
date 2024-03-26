package lect042623;

public class GasCar extends Car implements Fillable{
	private Tank tank;
	
	public GasCar() {
		tank = new Tank();
	}
	
	
	@Override
	public void fill() {
		tank.fill();
		
	}

}
