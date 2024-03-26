package lect021523;
/**
 * Base price is price_per_item * items
 * regular shipping cost is Cost_per_Shirt * item
 * for order of 25 or more shipping is free
 * 
 * tax is base price * tax_rate
 * no tax if state resident
 * @author andre
 *
 */
public class Order {
	public static final double PRICE = 10.0;
	public static final double SHIPPING_COST_PER_SHIRT = 2.0;
	public static final double FREE_SHIPPING_THRESHOLD = 25.0;
	public static final double TAX_RATE = 0.05;
	
	private int numShirts;
	private boolean isResident;
	
	public double orderTotal() {
		double total;
		if (numShirts >= FREE_SHIPPING_THRESHOLD) {
			if (isResident) {
				total = numShirts * PRICE;
			} else {
				total = numShirts * PRICE * TAX_RATE;
			}
		} else {
			if (isResident) {
				total = numShirts * PRICE + (numShirts * SHIPPING_COST_PER_SHIRT);
			} else {
				total = numShirts * PRICE * TAX_RATE + (numShirts * SHIPPING_COST_PER_SHIRT);
			}
		}
		return total;
	}
}
