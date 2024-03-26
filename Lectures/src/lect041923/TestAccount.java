package lect041923;

public class TestAccount {
	public static void giveMoney(Account acc) {
		acc.deposit(200);
	}
	
	public static void takeMoney(Account acc) {
		acc.withdraw(150);
	}
	
	
	public static void main(String args[]) {
		CheckingAccount myChecking = new CheckingAccount();
		SavingsAccount mySavings = new SavingsAccount(100);
		
		
		giveMoney(myChecking);
		giveMoney(mySavings);
//		myChecking.deposit(200);
//		mySavings.deposit(200);
		
		
		
//		myChecking.withdraw(150);
//		mySavings.withdraw(150);
		takeMoney(myChecking);
		takeMoney(mySavings);
		
		System.out.println(myChecking.getBalance());
		System.out.println(mySavings.getBalance());
	}
}
