package  com.github.xbn.test.number;
	import  com.github.xbn.number.IntInRange;
	import  com.github.xbn.number.IntBoundExclusive;
	import  com.github.xbn.number.IntBoundInclusive;
	import  com.github.xbn.number.OverlapRequired;
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
		unit.test_getMerged();
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
		IntInRange iir = new IntInRange(new IntBoundInclusive(1, null), null);
		assertTrue(new IntInRange(null, null).doesOverlap(new IntInRange(null, null)));
		assertTrue(iir.doesOverlap(iir));
		assertTrue(iir.doesOverlap(new IntInRange(2, 4)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 2)));
		assertTrue(iir.doesOverlap(new IntInRange(0, 3)));
		assertTrue(iir.doesOverlap(new IntInRange(new IntBoundExclusive(2, null), new IntBoundInclusive(3, null))));
		assertTrue(iir.doesOverlap(new IntInRange(3, 4)));
		assertFalse(iir.doesOverlap(new IntInRange(-1, 0)));
		assertTrue(iir.doesOverlap(new IntInRange(null, new IntBoundInclusive(2, null))));
		assertTrue(iir.doesOverlap(new IntInRange(null, new IntBoundInclusive(4, null))));
	}
	@Test
	public void test_getIntersection()  {
		IntInRange iir1 = new IntInRange(null, null);
		IntInRange iir2 = new IntInRange(null, null);
		//System.out.println(iir1.getOverlapDebugging(iir2));
		assertEquals(new IntInRange(null, null), iir1.getIntersection(iir2));

		iir2 = new IntInRange(1, 1);
		assertEquals(new IntInRange(null, null), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(null, null), iir2.getIntersection(iir1));

		iir1 = new IntInRange(null, new IntBoundInclusive(1, null));
		iir2 = new IntInRange(new IntBoundInclusive(0, null), null);
		assertEquals(new IntInRange(0, 1), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(0, 1), iir2.getIntersection(iir1));

		iir1 = new IntInRange(1, 1);
		iir2 = new IntInRange(1, 1);
		assertEquals(new IntInRange(1, 1), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(1, 1), iir2.getIntersection(iir1));

		iir1 = new IntInRange(1, 1);
		iir2 = new IntInRange(new IntBoundExclusive(1, null), new IntBoundInclusive(1, null));
		assertEquals(new IntInRange(1, 1), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(1, 1), iir2.getIntersection(iir1));

		iir1 = new IntInRange(new IntBoundExclusive(0, null), new IntBoundInclusive(1, null));
		assertEquals(new IntInRange(new IntBoundExclusive(1, null), new IntBoundInclusive(1, null)), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(new IntBoundExclusive(1, null), new IntBoundInclusive(1, null)), iir2.getIntersection(iir1));

		iir1 = new IntInRange(1, 1);
		iir2 = new IntInRange(new IntBoundInclusive(1, null), new IntBoundExclusive(1, null));
		assertEquals(new IntInRange(1, 1), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(1, 1), iir2.getIntersection(iir1));

		iir1 = new IntInRange(new IntBoundInclusive(1, null), new IntBoundExclusive(0, null));
		assertEquals(new IntInRange(new IntBoundInclusive(1, null), new IntBoundExclusive(1, null)), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(new IntBoundInclusive(1, null), new IntBoundExclusive(1, null)), iir2.getIntersection(iir1));

		iir1 = new IntInRange(1, 2);
		iir2 = new IntInRange(2, 3);
		assertEquals(new IntInRange(2, 2), iir1.getIntersection(iir2));
		assertEquals(new IntInRange(2, 2), iir2.getIntersection(iir1));

		iir1 = new IntInRange(1, 2);
		iir2 = new IntInRange(3, 4);
		assertEquals(null, iir1.getIntersection(iir2));
		assertEquals(null, iir2.getIntersection(iir1));
	}
	@Test
	public void test_getMerged()  {
		IntInRange iir1 = new IntInRange(null, null);
		IntInRange iir2 = new IntInRange(null, null);
		assertEquals(new IntInRange(null, null), iir1.getMerged(iir2, OverlapRequired.YES));

		iir2 = new IntInRange(1, 1);
		assertEquals(new IntInRange(null, null), iir1.getMerged(iir2, OverlapRequired.YES));
		assertEquals(new IntInRange(null, null), iir2.getMerged(iir1, OverlapRequired.YES));

		iir1 = new IntInRange(1, 1);
		assertEquals(new IntInRange(1, 1), iir1.getMerged(iir2, OverlapRequired.YES));
		assertEquals(new IntInRange(1, 1), iir2.getMerged(iir1, OverlapRequired.YES));

		iir2 = new IntInRange(new IntBoundExclusive(1, null), new IntBoundInclusive(1, null));
		assertEquals(new IntInRange(1, 1), iir1.getMerged(iir2, OverlapRequired.YES));
		assertEquals(new IntInRange(1, 1), iir2.getMerged(iir1, OverlapRequired.YES));

		iir1 = new IntInRange(new IntBoundExclusive(0, null), new IntBoundInclusive(1, null));
		assertEquals(new IntInRange(new IntBoundExclusive(0, null), new IntBoundInclusive(1, null)), iir1.getMerged(iir2, OverlapRequired.YES));
		assertEquals(new IntInRange(new IntBoundExclusive(0, null), new IntBoundInclusive(1, null)), iir2.getMerged(iir1, OverlapRequired.YES));

		iir1 = new IntInRange(1, 2);
		iir2 = new IntInRange(2, 3);
		assertEquals(new IntInRange(1, 3), iir1.getMerged(iir2, OverlapRequired.YES));
		assertEquals(new IntInRange(1, 3), iir2.getMerged(iir1, OverlapRequired.YES));

		iir1 = new IntInRange(1, 2);
		iir2 = new IntInRange(3, 4);
		try  {
			iir1.getMerged(iir2, OverlapRequired.YES);
			fail("No overlap");
		}  catch(IllegalArgumentException x)  {
			assertTrue(true);
		}
		try  {
			iir1.getMerged(iir1, OverlapRequired.YES);
			fail("No overlap");
		}  catch(IllegalArgumentException x)  {
			assertTrue(true);
		}

		assertEquals(new IntInRange(1, 4), iir1.getMerged(iir2, OverlapRequired.NO));
		assertEquals(new IntInRange(1, 4), iir2.getMerged(iir1, OverlapRequired.NO));
	}
}
