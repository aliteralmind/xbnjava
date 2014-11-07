package  com.github.xbn.test.number;
	import  com.github.xbn.number.IntInRange;
	import  com.github.xbn.number.IntBoundExclusive;
	import  com.github.xbn.number.IntBoundInclusive;
	import  com.github.xbn.number.BoundSide;
	import  org.junit.Test;
	import  static org.junit.Assert.*;

/*

java com.github.xbn.test.number.IntInRange_Unit

 */
public class IntInRange_Unit  {
	public static final void main(String[] as_clp)  {
		IntInRange_Unit unit = new IntInRange_Unit();
		unit.test_basicIsIn();
		unit.test_inverted();
		unit.test_overlapHasBothBounds();
		unit.test_overlapOneBoundNull();
		unit.test_overlapOneBoundNull();
		unit.test_getIntersection();
	}
	@Test
	public void test_basicIsIn()  {
		IntInRange iir = new IntInRange(1, 2);
		assertEquals(false, iir.isIn(0));
		assertEquals(true, iir.isIn(1));
		assertEquals(true, iir.isIn(2));
		assertEquals(false, iir.isIn(3));
	}
	@Test
	public void test_inverted()  {
		IntInRange iir = new IntInRange(1, 2).getInvertedCopy();
		assertEquals(true, iir.isIn(0));
		assertEquals(false, iir.isIn(1));
		assertEquals(false, iir.isIn(2));
		assertEquals(true, iir.isIn(3));
	}
	@Test
	public void test_overlapHasBothBounds()  {
		IntInRange iir = new IntInRange(1, 2);
		assertTrue(iir.doesOverlap(iir));
		assertTrue(iir.doesOverlap(new IntInRange(2, 4)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 2)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 3)));
		assertFalse(iir.doesOverlap(new IntInRange(new IntBoundExclusive(2, null), new IntBoundInclusive(3, null))));
		assertFalse(iir.doesOverlap(new IntInRange(3, 4)));
		assertFalse(iir.doesOverlap(new IntInRange(-1, 0)));
	}
	@Test
	public void test_overlapOneBoundNull()  {
		IntInRange iir = new IntInRange(new IntBoundInclusive(1), null);
		assertTrue(iir.doesOverlap(iir));
		assertTrue(iir.doesOverlap(new IntInRange(2, 4)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 2)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 3)));
		assertTrue(iir.doesOverlap(new IntInRange(new IntBoundExclusive(2, null), new IntBoundInclusive(3, null))));
		assertFalse(iir.doesOverlap(new IntInRange(3, 4)));
		assertFalse(iir.doesOverlap(new IntInRange(-1, 0)));
		assertTrue(iir.doesOverlap(new IntInRange(null, 2)));
		assertTrue(iir.doesOverlap(new IntInRange(null, 4)));
	}
	@Test
	public void test_getIntersection()  {

	}
}
