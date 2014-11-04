package  com.github.xbn.examples.util.grid;
	import  org.junit.Test;
	import  static org.junit.Assert.*;
	import  com.github.xbn.util.grid.GridItem;

/*

java com.github.xbn.examples.util.grid.GridItem_Unit

 */
public class GridItem_Unit  {
	public static final void main(String[] ignored)  {
		GridItem_Unit unit = new GridItem_Unit();
		unit.test_goodValues();
		unit.test_badValues();
	}
	@Test
	public void test_goodValues()  {
		GridItem<Integer> item = new GridItem<Integer>(1, 2, 8);
		assertEquals(1, item.getHorizIndex());
		assertEquals(2, item.getVertIndex());
		assertEquals(8, (int)item.get());
	}
	@Test
	public void test_badValues()  {
		try  {
			new GridItem<Integer>(-1, 2, 8);
			fail("Horiz below zero should crash.");
		}  catch(IllegalArgumentException iax)  {
			assertTrue(true);
		}
		try  {
			new GridItem<Integer>(1, -1, 8);
			fail("Vert below zero should crash.");
		}  catch(IllegalArgumentException iax)  {
			assertTrue(true);
		}
	}
}
