package lect020123;

public class CashRegisterTest {
	public static void main(String args[]) {
		CashRegister r = new CashRegister(0.07);
		r.addTaxableItem(5.99);
		System.out.println(r.getTotal());
		System.out.println("Expected 6.41");
		
		System.out.println(r.getTotalTax());
		System.out.println("expected 0.42");
		
		r.clearRegister();
		System.out.println(r.getTotal());
		System.out.println("Expected 0.0");
		
	}
}
