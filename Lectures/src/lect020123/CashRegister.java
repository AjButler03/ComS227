package lect020123;

/**
 * Model of a cash register that handles taxable and non-taxable items.
 * 
 * @author andre
 *
 */
public class CashRegister {
	private double subTotal;
	private double totalTax;
	private double taxRate;

	public CashRegister(double givenTaxRate) {
		taxRate = givenTaxRate;
		subTotal = 0;
		totalTax = 0;
	}

	/**
	 * Adding item to cart for given price. Adds in tax for that item.
	 * 
	 * @param price
	 */
	public void addTaxableItem(double price) {
		subTotal += price;
		totalTax += price * taxRate;
	}

	/**
	 * Adding an item to total for given price. Does not add tax for item.
	 * 
	 * @param price
	 */
	public void addNonTaxableItem(double price) {
		subTotal += price;
	}

	/**
	 * user pays in cash, returns change.
	 * 
	 * @param amount
	 * @return
	 */
	public double payInCash(double amount) {
		// TODO
		return 0.0;
	}
	
	public double getTotal() {
		return subTotal + totalTax;
	}
	public double getTotalTax() {
		return totalTax;
	}
	public void clearRegister() {
		subTotal = 0;
		totalTax = 0;
	}
}
