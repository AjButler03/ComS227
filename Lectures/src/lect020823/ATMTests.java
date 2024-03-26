package lect020823;

public class ATMTests {
	private static double eurRate = 1.5;
	private static double rubRate = 2.0;
	private static double yenRate = 10.0;
	
	public static void main(String args[]) {
		Currency eur = new Currency(eurRate);
		Currency rub = new Currency(rubRate);
		Currency yen = new Currency(yenRate);
		
		System.out.println(ATM.convert(25.0, eur));
		System.out.println(ATM.convert(25.0, rub));
		System.out.println(ATM.convert(25.0, yen));
	}
}