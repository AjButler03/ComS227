package lect042623;

public class ElectricTruck extends Truck implements Chargeable {
	private Battery battery;
	
	public ElectricTruck() {
		battery = new Battery();
	}
	
	@Override
	public void charge() {
		battery.charge();
	}
}
