package lect022723;

public class Loan {
	private double annualRate;
	private double balance;
	public Loan(double rate, double startBalance) {
		
	}
	
	public void makePayment(double payment) {
		balance = getPayoffAmount() - payment;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getPayoffAmount() {
		return balance + balance * annualRate / 12.0;
	}
}

