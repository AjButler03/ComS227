package lect041923;

public class CheckingAccount extends Account{
	
	@Override
	public void withdraw(double amount) {
		if(getBalance() - amount >= 0) {
			super.withdraw(amount);
		}
	}
}
