package lect020823;

public class Currency {
	private double rate;
	
	public Currency(double givenRate) {
		rate = givenRate;
	}
	public double convert(double amount) {
		return amount * rate;
	}
}
