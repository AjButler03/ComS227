package lect041923;

public class Account {
	private double balance = 0;
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
