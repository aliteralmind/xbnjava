package  com.github.xbn.test.number;
	import  org.junit.Test;
	import  static org.junit.Assert.*;
	import  com.github.xbn.number.Inclusive;
	import  com.github.xbn.number.BoundSide;
	import  com.github.xbn.number.IntBound;

/*

java com.github.xbn.test.number.IntBound_Unit

 */
public class IntBound_Unit  {
	public static final void main(String[] ignored)  {
		IntBound_Unit unit = new IntBound_Unit();
		unit.test_inclusive();
		unit.test_exclusive();
	}
	@Test
	public void test_inclusive()  {
		IntBound ibMin = new IntBound(1, Inclusive.YES, "the_name");

		assertEquals(1, (int)ibMin.get());
		assertEquals(1, (int)ibMin.getGivenIncl(BoundSide.MIN));
		assertEquals(1, (int)ibMin.getGivenIncl(BoundSide.MAX));
		assertEquals("the_name", ibMin.getName());

		assertEquals(1, (int)ibMin.getInclComparedTo(BoundSide.MIN, 0));
		assertEquals(0, (int)ibMin.getInclComparedTo(BoundSide.MIN, 1));
		assertEquals(-1, (int)ibMin.getInclComparedTo(BoundSide.MIN, 2));
		assertEquals(-2, (int)ibMin.getInclComparedTo(BoundSide.MIN, 3));
	}
	@Test
	public void test_exclusive()  {
		IntBound ibMin = new IntBound(1, Inclusive.NO, null);

		assertEquals(1, (int)ibMin.get());
		assertEquals(2, (int)ibMin.getGivenIncl(BoundSide.MIN));
		assertEquals(0, (int)ibMin.getGivenIncl(BoundSide.MAX));

		assertEquals(0, (int)ibMin.getInclComparedTo(BoundSide.MIN, 2));
		assertEquals(-1, (int)ibMin.getInclComparedTo(BoundSide.MIN, 3));
		assertEquals(0, (int)ibMin.getInclComparedTo(BoundSide.MAX, 0));
		assertEquals(-1, (int)ibMin.getInclComparedTo(BoundSide.MAX, 1));
	}
}
