package lect020623;

public class Car {
	private GasTank gasTank;
	private double mpg;

	/**
	 * Constructs a new car.
	 */
	public Car(double givenMpg, double givenCapacity) {
		//GasTank gasTank = new GasTank(givenCapacity);
		mpg = givenMpg;
	}

	/**
	 * Returns the current value of the odometer.
	 * 
	 * @return the odometer
	 */
	public double getOdometer() {
		return 0.0;
	}

	/**
	 * returns the amount of gas in the tank as a fraction of the total capacity.
	 * 
	 * @return a value between 0 and 1
	 */
	public double getGasGuage() {
		return gasTank.getContents() / gasTank.getCapacity();
	}

	/**
	 * Fills the gas tank on this car.
	 */
	public void buyGas() {
		gasTank.fill();
	}

	/**
	 * Simulates driving the car for the given number of miles, or until the car
	 * runs out of gas.
	 * 
	 * @param miles
	 */
	public void drive(double miles) {
		double distance = Math.min(miles, gasTank.getContents() * mpg);
		double gallonsUsed = distance / mpg;
		gasTank.use(gallonsUsed);
	}
}