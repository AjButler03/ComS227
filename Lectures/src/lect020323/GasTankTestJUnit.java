package lect020323;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class GasTankTestJUnit {
private GasTank gt;
	@Before
	public void setup() {
		gt = new GasTank(10);
	}

	private double testErr = 0.1;

	@Test
	public void testNew() {

		assertEquals("New gas tank should have capacity 10", 10, gt.getCapacity(), testErr);

	}
	@Test
	public void testAdd() {
		gt.add(5);
		assertEquals("After adding 5 gallons, expect level 5", 5, gt.getLevel(), testErr);
		gt.add(15);
		assertEquals("After adding 15 gallons, expect level 10", 5, gt.getLevel(), testErr);
	}
}