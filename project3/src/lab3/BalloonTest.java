package lab3;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import balloon3.Balloon;

public class BalloonTest {
	private Balloon b;

	@Before
	public void setup() {
		b = new Balloon(10);
	}

	// test initialization of balloon to given max radius and 0 current radius
	@Test
	public void testInitialRadius() {
		assertEquals(0, b.getRadius());
	}

	@Test
	public void testNegativeRadius() {
		Balloon b2 = new Balloon(-10);
		assertEquals(0, b2.getRadius());
	}

	// test that the balloon inflates correctly
	@Test
	public void testInflate() {
		b.blow(10);
		assertEquals(10, b.getRadius());
	}
	
	// test inflate twice in a row
	@Test
	public void testInflate2() {
		b.blow(5);
		b.blow(5);
		assertEquals(10, b.getRadius());
	}

	// test that the ballon will have radius 0 if overinflated
	@Test
	public void testOverInflate() {
		b.blow(15);
		assertEquals(0, b.getRadius());
	}
	
	//test that overinflating pops the balloon
	@Test
	public void testOverInflatePop() {
		b.blow(15);
		assertEquals(true, b.isPopped());
	}
	// testing that a negative number inputed into blow does not change the radius
	@Test
	public void testNegativeBlow() {
		b.blow((7));
		b.blow(-2);
		assertEquals(7, b.getRadius());
	}

	// test that popping a balloon sets the max diameter to 0
	@Test
	public void testPopRadius() {
		b.blow(7);
		b.pop();
		assertEquals(0, b.getRadius());
	}
	
	// test that popping makes isPopped() return true
	@Test
	public void testPop() {
		b.pop();
		assertEquals(true, b.isPopped());
	}
	
	// test that isPopped() returns false if the balloon has not been popped
	@Test
	public void testNotPopped() {
		assertEquals(false, b.isPopped());
	}
	// test that a popped balloon cannot be inflated
	@Test
	public void testPopInflate() {
		b.blow(7);
		b.pop();
		b.blow(7);
		assertEquals(0, b.getRadius());
	}
	
	// test that the balloon deflates to radius 0
	@Test
	public void testDeflate() {
		b.blow(7);
		b.deflate();
		assertEquals(0, b.getRadius());
	}
	
	// test that a popped balloon that is deflated has radius 0
	@Test
	public void testPoppedDeflate() {
		b.blow(7);
		b.pop();
		b.deflate();
		assertEquals(0, b.getRadius());
	}
	
	// test that deflating a balloon does not pop the ballon
	@Test
	public void testDeflatePop() {
		b.blow(7);
		b.deflate();
		assertEquals(false, b.isPopped());
	}
}
