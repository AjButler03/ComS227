package lect021723;

/**
 * Base price is price_per_item * items regular shipping cost is Cost_per_Shirt
 * * item for order of 25 or more shipping is free
 * 
 * tax is base price * tax_rate no tax if state resident
 * 
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
		double shipping = 0;
		double tax = 0;

		if (numShirts < FREE_SHIPPING_THRESHOLD) {
			shipping = SHIPPING_COST_PER_SHIRT * numShirts;
		}

		if (!isResident) {
			tax = numShirts * PRICE * TAX_RATE;
		}

		return numShirts * PRICE + shipping + tax;
	}
	
	public double orderTotal5() {
		double total = numShirts * PRICE;

		if (numShirts < FREE_SHIPPING_THRESHOLD) {
			 total += SHIPPING_COST_PER_SHIRT * numShirts;
		}

		if (!isResident) {
			total += numShirts * PRICE * TAX_RATE;
		}

		return total;
	}
	
	public double orderTotal6() {
		double total = numShirts * PRICE;
		
		if (!isResident) {
			total += total * TAX_RATE;
		}
		
		if (numShirts < FREE_SHIPPING_THRESHOLD) {
			 total += SHIPPING_COST_PER_SHIRT * numShirts;
		}

		return total;
	}
}
