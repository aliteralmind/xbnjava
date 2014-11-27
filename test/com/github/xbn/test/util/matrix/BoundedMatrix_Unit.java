package  com.github.xbn.test.util.matrix;
	import  com.github.xbn.number.IndexInRange;
	import  com.github.xbn.util.matrix.BoundedMatrix;
	import  com.github.xbn.util.matrix.MatrixDirection;
	import  com.github.xbn.util.matrix.EdgeExceeded;
	import  com.github.xbn.util.matrix.DistanceDirection;
	import  com.github.xbn.util.matrix.VertHorizDirection;
	import  com.github.xbn.util.matrix.MatrixElement;
	import  org.junit.Test;
	import  static org.junit.Assert.*;

/*

java com.github.xbn.test.util.matrix.BoundedMatrix_Unit

 */
public class BoundedMatrix_Unit  {
	public static final void main(String[] ignored)  {
		BoundedMatrix_Unit unit = new BoundedMatrix_Unit();

		//if(true) return;

		unit.test_basics();
		unit.test_getColItemIdxRangeForNeighborCount_none();
		unit.test_getShortestLongestHVForDiagonal();
		unit.test_neighborCount();
		unit.test_getNeighbor_and_DistDir();
		unit.test_oneAwayFrom00();
		unit.test_oneAwayFrom45();
		unit.test_movementByOne_crash();
		unit.test_movementByOne_success();
		unit.test_getColItemIdxRangeForNeighborCount_whole();
		unit.test_getColItemIdxRangeForNeighborCount_partial();
		unit.test_getColItemIdxRangeForNeighborCount_partialNeg();
		unit.test_getRowItemIdxRangeForNeighborCount_whole();
		unit.test_getRowItemIdxRangeForNeighborCount_partial();
		unit.test_getRowItemIdxRangeForNeighborCount_partialNeg();
		unit.test_getRowItemIdxRangeForNeighborCount_none();
	}
	@Test
	public void test_getColItemIdxRangeForNeighborCount_whole()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		IndexInRange wholeColumn = new IndexInRange(0, matrix.getRowCount());
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.LEFT, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.RIGHT, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP_LEFT, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP_RIGHT, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_LEFT, 0));
		assertEquals(wholeColumn, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_RIGHT, 0));
	}
	@Test
	public void test_getColItemIdxRangeForNeighborCount_partial()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		int height = matrix.getRowCount();
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP, 1));
		assertEquals(new IndexInRange(0, (height - 3)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN, 3));
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP_LEFT, 1));
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP_RIGHT, 1));
		assertEquals(new IndexInRange(0, (height - 1)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_LEFT, 1));
		assertEquals(new IndexInRange(0, (height - 1)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_RIGHT, 1));
	}
	@Test
	public void test_getColItemIdxRangeForNeighborCount_partialNeg()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		int height = matrix.getRowCount();
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN, -1));
		assertEquals(new IndexInRange(0, (height - 3)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP, -3));
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_RIGHT, -1));
		assertEquals(new IndexInRange(1, height), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_LEFT, -1));
		assertEquals(new IndexInRange(0, (height - 1)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP_RIGHT, -1));
		assertEquals(new IndexInRange(0, (height - 1)), matrix.getColItemIdxRangeForNeighborCount(1, MatrixDirection.UP_LEFT, -1));
	}
	@Test
	public void test_getColItemIdxRangeForNeighborCount_none()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP, 5));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.LEFT, 1));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN, 5));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.RIGHT, 6));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP_LEFT, 5));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.UP_RIGHT, 5));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_LEFT, 1));
		assertEquals(null, matrix.getColItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_RIGHT, 5));
	}
	@Test
	public void test_getRowItemIdxRangeForNeighborCount_whole()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		IndexInRange wholeRow = new IndexInRange(0, matrix.getElementsInRowCount());
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.RIGHT, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.LEFT, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP_LEFT, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP_RIGHT, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_LEFT, 0));
		assertEquals(wholeRow, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_RIGHT, 0));
	}
	@Test
	public void test_getRowItemIdxRangeForNeighborCount_partial()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		int width = matrix.getElementsInRowCount();
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.RIGHT, 1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.LEFT, 1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.UP_LEFT, 1));
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.UP_RIGHT, 1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_LEFT, 1));
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_RIGHT, 1));
	}
	@Test
	public void test_getRowItemIdxRangeForNeighborCount_partialNeg()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		int width = matrix.getElementsInRowCount();
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.LEFT, -1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.RIGHT, -1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_RIGHT, -1));
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.DOWN_LEFT, -1));
		assertEquals(new IndexInRange(1, width), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.UP_RIGHT, -1));
		assertEquals(new IndexInRange(0, (width - 1)), matrix.getRowItemIdxRangeForNeighborCount(1, MatrixDirection.UP_LEFT, -1));
	}
	@Test
	public void test_getRowItemIdxRangeForNeighborCount_none()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.LEFT, 6));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN, 5));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP, 1));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.RIGHT, 6));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP_LEFT, 1));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.UP_RIGHT, 1));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_LEFT, 5));
		assertEquals(null, matrix.getRowItemIdxRangeForNeighborCount(0, MatrixDirection.DOWN_RIGHT, 5));
	}
	@Test
	public void test_movementByOne_crash()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		iaxMoveOneFrom00(matrix, MatrixDirection.UP_RIGHT);
		iaxMoveOneFrom00(matrix, MatrixDirection.UP);
		iaxMoveOneFrom00(matrix, MatrixDirection.UP_LEFT);
		iaxMoveOneFrom00(matrix, MatrixDirection.LEFT);
		iaxMoveOneFrom00(matrix, MatrixDirection.DOWN_LEFT);

		iaxMoveOneFrom45(matrix, MatrixDirection.UP_RIGHT);
		iaxMoveOneFrom45(matrix, MatrixDirection.RIGHT);
		iaxMoveOneFrom45(matrix, MatrixDirection.DOWN_RIGHT);
		iaxMoveOneFrom45(matrix, MatrixDirection.DOWN);
		iaxMoveOneFrom45(matrix, MatrixDirection.DOWN_LEFT);
	}
		private void iaxMoveOneFrom00(BoundedMatrix matrix, MatrixDirection dir)  {
			try  {
				matrix.moveNextDoor(0, 0, dir, EdgeExceeded.CRASH);
				fail(dir + " from [0,0]");
			}  catch(IllegalArgumentException x)  {
				assertTrue(true);
			}
		}
	@Test
	public void test_movementByOne_success()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		MatrixElement elem = matrix.get(1, 1);
		assertEquals(new MatrixElement(1, 2), matrix.moveRight(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(2, 2), matrix.moveDownRight(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(2, 1), matrix.moveDown(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(2, 0), matrix.moveDownLeft(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(1, 0), matrix.moveLeft(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(0, 0), matrix.moveUpLeft(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(0, 1), matrix.moveUp(elem, EdgeExceeded.CRASH));
		assertEquals(new MatrixElement(0, 2), matrix.moveUpRight(elem, EdgeExceeded.CRASH));
	}
		private void iaxMoveOneFrom45(BoundedMatrix matrix, MatrixDirection dir)  {
			try  {
				matrix.moveNextDoor(4, 5, dir, EdgeExceeded.CRASH);
				fail(dir + " from [4, 5]");
			}  catch(IllegalArgumentException x)  {
				assertTrue(true);
			}
		}
	@Test
	public void test_neighborCount()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		assertEquals(1, matrix.getNeighborCount(1, 1, MatrixDirection.UP));
		assertEquals(3, matrix.getNeighborCount(1, 1, MatrixDirection.DOWN));
		assertEquals(4, matrix.getNeighborCount(1, 1, MatrixDirection.RIGHT));
		assertEquals(3, matrix.getNeighborCount(1, 1, MatrixDirection.DOWN_RIGHT));
		assertEquals(1, matrix.getNeighborCount(1, 1, MatrixDirection.LEFT));
		assertEquals(1, matrix.getNeighborCount(1, 1, MatrixDirection.DOWN_LEFT));
		assertEquals(1, matrix.getNeighborCount(1, 1, MatrixDirection.UP_RIGHT));
		assertEquals(1, matrix.getNeighborCount(1, 1, MatrixDirection.UP_LEFT));
	}
	@Test
	public void test_getNeighbor_and_DistDir()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		DistanceDirection dd = matrix.getNeighborDistDir(1, 1, 4, 4);
		assertEquals(3, dd.getRowIndex());
		assertEquals(3, dd.getColumnIndex());
		assertEquals(MatrixDirection.DOWN_RIGHT, dd.getDirection());

		dd = matrix.getNeighborDistDir(1, 1, 4, 3);
		assertEquals(3, dd.getRowIndex());
		assertEquals(2, dd.getColumnIndex());
		assertEquals(null, dd.getDirection());

		MatrixElement elem = matrix.getNeighbor(0, 0, MatrixDirection.RIGHT, 3, EdgeExceeded.CRASH);
		assertEquals(matrix.get(0, 3), elem);
		elem = matrix.getNeighbor(0, 0, MatrixDirection.RIGHT, 4, EdgeExceeded.CRASH);
		assertEquals(matrix.get(0, 4), elem);
		try  {
			matrix.getNeighbor(0, 0, MatrixDirection.RIGHT, 6, EdgeExceeded.CRASH);
			fail("Edge exceeded RIGHT");
		}  catch(IllegalArgumentException x)  {
			assertTrue(true);
		}
	}
	@Test
	public void test_oneAwayFrom00()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		exceedEdgeCrashOneAwayFrom00(matrix, MatrixDirection.UP);
		exceedEdgeCrashOneAwayFrom00(matrix, MatrixDirection.LEFT);
		exceedEdgeCrashOneAwayFrom00(matrix, MatrixDirection.UP_LEFT);
		exceedEdgeCrashOneAwayFrom00(matrix, MatrixDirection.UP_RIGHT);
		exceedEdgeCrashOneAwayFrom00(matrix, MatrixDirection.DOWN_LEFT);

		MatrixElement elem = matrix.getNeighbor(0, 0, MatrixDirection.DOWN_LEFT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(1, 5), elem);
		elem = matrix.getNeighbor(0, 0, MatrixDirection.LEFT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(0, 5), elem);
		elem = matrix.getNeighbor(0, 0, MatrixDirection.UP_LEFT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(4, 5), elem);
		elem = matrix.getNeighbor(0, 0, MatrixDirection.UP, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(4, 0), elem);
		elem = matrix.getNeighbor(0, 0, MatrixDirection.UP_RIGHT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(4, 1), elem);
	}
	@Test
	public void test_oneAwayFrom45()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);

		exceedEdgeCrashOneAwayFrom45(matrix, MatrixDirection.UP_RIGHT);
		exceedEdgeCrashOneAwayFrom45(matrix, MatrixDirection.RIGHT);
		exceedEdgeCrashOneAwayFrom45(matrix, MatrixDirection.DOWN_RIGHT);
		exceedEdgeCrashOneAwayFrom45(matrix, MatrixDirection.DOWN);
		exceedEdgeCrashOneAwayFrom45(matrix, MatrixDirection.DOWN_LEFT);

		MatrixElement elem = matrix.getNeighbor(4, 5, MatrixDirection.UP_RIGHT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(3, 0), elem);
		elem = matrix.getNeighbor(4, 5, MatrixDirection.RIGHT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(4, 0), elem);
		elem = matrix.getNeighbor(4, 5, MatrixDirection.DOWN_RIGHT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(0, 0), elem);
		elem = matrix.getNeighbor(4, 5, MatrixDirection.DOWN, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(0, 5), elem);
		elem = matrix.getNeighbor(4, 5, MatrixDirection.DOWN_LEFT, 1, EdgeExceeded.WRAP);
		assertEquals(matrix.get(0, 4), elem);
	}
		private void exceedEdgeCrashOneAwayFrom00(BoundedMatrix matrix, MatrixDirection direction)  {
			try  {
				matrix.getNeighbor(0, 0, direction, 1, EdgeExceeded.CRASH);
				fail("[0, 0], edge exceeded " + direction);
			}  catch(IllegalArgumentException x)  {
				assertTrue(true);
			}
		}
		private void exceedEdgeCrashOneAwayFrom45(BoundedMatrix matrix, MatrixDirection direction)  {
			try  {
				matrix.getNeighbor(4, 5, direction, 1, EdgeExceeded.CRASH);
				fail("[4, 5], edge exceeded " + direction);
			}  catch(IllegalArgumentException x)  {
				assertTrue(true);
			}
		}
	@Test
	public void test_basics()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		assertEquals(5, matrix.getRowCount());
		assertEquals(6, matrix.getElementsInRowCount());
		assertEquals(30, matrix.getElementCount());
		assertEquals(new MatrixElement(0, 0), matrix.get(0, 0));
		assertEquals(new MatrixElement(1, 1), matrix.get(1, 1));
		assertEquals(new MatrixElement(3, 2), matrix.get(3, 2));
		assertEquals(new MatrixElement(4, 5), matrix.get(4, 5));
	}
	@Test
	public void test_getShortestLongestHVForDiagonal()  {
		BoundedMatrix matrix = new BoundedMatrix(5, 6);
		MatrixDirection dir = MatrixDirection.LEFT;
		MatrixElement elem = new MatrixElement(0, 0);
		testShortestLongestHVForDiagonal(matrix, dir, 0, 0, VertHorizDirection.LEFT, VertHorizDirection.LEFT);

		dir = MatrixDirection.DOWN;
		testShortestLongestHVForDiagonal(matrix, dir, 0, 0, VertHorizDirection.DOWN, VertHorizDirection.DOWN);

		//In the case of a tie, vertical is returned
		dir = MatrixDirection.DOWN_RIGHT;
		testShortestLongestHVForDiagonal(matrix, dir, 0, 1, VertHorizDirection.DOWN, VertHorizDirection.DOWN);

		dir = MatrixDirection.DOWN_RIGHT;
		testShortestLongestHVForDiagonal(matrix, dir, 0, 0, VertHorizDirection.DOWN, VertHorizDirection.RIGHT);
	}
		private void testShortestLongestHVForDiagonal(BoundedMatrix matrix, MatrixDirection dir,
				int row_idx, int col_idx,
				VertHorizDirection longest_dir, VertHorizDirection shortest_dir)  {
			assertEquals(longest_dir, matrix.getShortestVHForDiagonal(row_idx, col_idx, dir));
			assertEquals(shortest_dir, matrix.getLongestVHForDiagonal(row_idx, col_idx, dir));
		}

}
