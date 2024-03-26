package lect042623;

public class GasTruck extends Truck implements Fillable{
	private Tank tank;
	
	public GasTruck() {
		tank = new Tank();
	}
	
	@Override
	public void fill() {
		tank.fill();
		
	}

}
