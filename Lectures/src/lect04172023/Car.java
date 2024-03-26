package lect04172023;

// car no like deer
// car 1, deer 1
public class Car extends Vehicle{
	private int seats;
	private GasTank gasTank;
	
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	@Override
	public void drive(int miles) {
		if (miles >= 0) {
			setOdometer(getOdometer() + miles);
			gasTank.useFuel(miles / 5);
		}
	}
	
}
