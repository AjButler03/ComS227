package lect020823;

public class ATM {
	
	public static double convert(double amount, Currency cur) {
		return cur.convert(amount);
	}
}