package lect041923;

public class SavingsAccount extends Account{
	private double minBalance;
	
	public SavingsAccount(double minBalance) {
		this.minBalance = minBalance;
	}
	
	@Override
	public void withdraw(double amount) {
		if(getBalance() - amount >= minBalance) {
			super.withdraw(amount);
		}
	}
	
}
