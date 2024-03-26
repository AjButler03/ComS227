package lect04172023;

public class Vehicle {
	private String name;
	private int odometer;
	//private GasTank gasTank;

	public void drive(int miles) {
		if (miles >= 0) {
			odometer += miles;
			//gasTank.useFuel(miles / 5);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getName() {
		return name;
	}
}
