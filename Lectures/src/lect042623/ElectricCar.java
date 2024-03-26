package lect042623;

public class ElectricCar extends Car implements Chargeable{
	private Battery battery;
	
	public ElectricCar() {
		battery = new Battery();
	}
	
	@Override
	public void charge() {
		battery.charge();
	}
}
