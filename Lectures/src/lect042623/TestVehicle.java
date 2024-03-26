package lect042623;

import java.util.ArrayList;

public class TestVehicle {
	public static void main(String args[]) {
		ArrayList<Chargeable> chargeables = new ArrayList<Chargeable>();
		
		chargeables.add(new ElectricTruck());
		chargeables.add(new ElectricCar());
		chargeables.add(new Battery());
		
		for (Chargeable c : chargeables) {
			c.charge();
		}
	}
}
