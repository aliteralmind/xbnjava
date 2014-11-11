package  com.github.xbn.util.matrix;
	import  com.github.xbn.util.matrix.DistanceDirection;
	import  com.github.xbn.util.matrix.MatrixElement;
	import  com.github.xbn.util.matrix.MatrixDirection;
	import  org.junit.Test;
	import  static org.junit.Assert.*;

/*

java com.github.xbn.util.matrix.DistanceDirection_Unit

 */
public class DistanceDirection_Unit  {
	public static final void main(String[] ignored)  {
		DistanceDirection_Unit unit = new DistanceDirection_Unit();
		unit.test_getDirectionFromDistances_basicIntsForEachDir();
		unit.test_basicObjCreation();
		unit.test_getDirectionFromDistances_null();
		unit.test_getDirectionFromDistances_nonNull();
	}
	@Test
	public void test_basicObjCreation()  {
		DistanceDirection dd = new DistanceDirection(1, 0);
		assertEquals(1, dd.getHorizontal());
		assertEquals(0, dd.getVertical());
		assertEquals(MatrixDirection.RIGHT, dd.getDirection());
	}
	@Test
	public void test_getDirectionFromDistances_null()  {
		MatrixElement start = new MatrixElement(0, 0);

		assertNull("No direction when end equals start",
			DistanceDirection.getDirectionFromDistances(start, start));
		assertNull("No direction when end equals start",
			DistanceDirection.getDirectionFromDistances(0, 0));

		MatrixElement end = new MatrixElement(1, 2);
		assertNull("Diagonal, but not 45-degrees",
			DistanceDirection.getDirectionFromDistances(start, end));
	}
	@Test
	public void test_getDirectionFromDistances_basicIntsForEachDir()  {
		assertEquals(MatrixDirection.DOWN,
			DistanceDirection.getDirectionFromDistances(0, 1));
		assertEquals(MatrixDirection.UP,
			DistanceDirection.getDirectionFromDistances(0, -1));
		assertEquals(MatrixDirection.LEFT,
			DistanceDirection.getDirectionFromDistances(-1, 0));
		assertEquals(MatrixDirection.RIGHT,
			DistanceDirection.getDirectionFromDistances(1, 0));
		assertEquals(MatrixDirection.DOWN_RIGHT,
			DistanceDirection.getDirectionFromDistances(1, 1));
		assertEquals(MatrixDirection.DOWN_LEFT,
			DistanceDirection.getDirectionFromDistances(-1, 1));
		assertEquals(MatrixDirection.UP_RIGHT,
			DistanceDirection.getDirectionFromDistances(1, -1));
		assertEquals(MatrixDirection.UP_LEFT,
			DistanceDirection.getDirectionFromDistances(-1, -1));
	}
	@Test
	public void test_getDirectionFromDistances_nonNull()  {
		MatrixElement start = new MatrixElement(0, 0);
		MatrixElement end = new MatrixElement(0, 1);
		testForTwoCoordsInclOpposite(start, end, MatrixDirection.DOWN);

		start = new MatrixElement(2, 2);
		end = new MatrixElement(1, 2);
		testForTwoCoordsInclOpposite(start, end, MatrixDirection.LEFT);

		end = new MatrixElement(3, 3);
		testForTwoCoordsInclOpposite(start, end, MatrixDirection.DOWN_RIGHT);

		end = new MatrixElement(3, 1);
		testForTwoCoordsInclOpposite(start, end, MatrixDirection.UP_RIGHT);
	}

	public static final void testForTwoCoordsInclOpposite(MatrixElement start, MatrixElement end, MatrixDirection start_toEndDir)  {
		assertEquals(start_toEndDir,
			DistanceDirection.getDirectionFromDistances(start, end));
		assertEquals(start_toEndDir,
			DistanceDirection.getDirectionFromDistances(start.getHorizDistance(end),
				                                         start.getVertDistance(end)));

		MatrixDirection oppDir = start_toEndDir.getOpposite();
		assertEquals(oppDir, DistanceDirection.getDirectionFromDistances(end, start));
		assertEquals(oppDir,
			DistanceDirection.getDirectionFromDistances(end.getHorizDistance(start),
				                                         end.getVertDistance(start)));
	}

}
