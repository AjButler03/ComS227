package lect042423;

import java.util.ArrayList;

public class TestVehicle {
	public static void driveDistance(Vehicle vehicle, int distance) {
		vehicle.drive(distance);
	}
	
	public static void main(String args[]) {
		Car myCar = new Car();
		Truck myTruck = new Truck();
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(myCar);
		vehicles.add(myTruck);
		
		for (Vehicle v : vehicles) {
			v.drive(100);
		}
		
	}
}
