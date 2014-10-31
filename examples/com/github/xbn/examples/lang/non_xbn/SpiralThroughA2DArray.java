/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.examples.lang.non_xbn;
	import  java.util.NoSuchElementException;
/**
	<P>Uses an iterator-like object to move through a two-dimensional array, starting from the top, left-to-right, down, right-to-left, down, left-to-right, ...</P>

	<P>{@code java com.github.xbn.examples.lang.non_xbn.SpiralThroughA2DArray}</P>
 **/
public class SpiralThroughA2DArray  {
	public static final void main(String[] ignored)  {
		int rows = 10;
		int cols = 10;
		int[][] boardPositions = new int[rows][cols];

		SpiralGridPositionIterator gridPosItr = new SpiralGridPositionIterator(rows, cols);

		int positionNum = rows * cols;  //Start at max and descend

		//Fill the array
			while(gridPosItr.hasNext())  {
				gridPosItr.goToNext();
				//System.out.println("[" + gridPosItr.getRowIdx() + "," + gridPosItr.getColIdx() + "]=" + positionNum);
				boardPositions[gridPosItr.getRowIdx()][gridPosItr.getColIdx()] = positionNum--;
			}

		//Display
			for(int rowIdx = 0; rowIdx < rows; rowIdx++)  {
				for(int colIdx = 0; colIdx < cols; colIdx++)  {
					System.out.print(boardPositions[rowIdx][colIdx] + " ");
				}
				System.out.println();
			}
	}
}

class SpiralGridPositionIterator  {
//config
	public final int rows;
	public final int cols;
//state
	private int rowIdx;
	private int colIdx;
	private boolean isColIdxAsc;
//internal
	private final int colsMinus1;
	private final int rowsMinus1;

	public SpiralGridPositionIterator(int rows, int cols)  {
		this.rows = rows;
		this.cols = cols;

		colIdx = -1;  //MUST initialize to -1  (See "First time is a special case")
		rowIdx = 0;

		isColIdxAsc = true;
		colsMinus1 = cols - 1;
		rowsMinus1 = rows - 1;
	}
	public boolean hasNext()  {
		if(getRowIdx() < rowsMinus1)  {
			return  true;
		}
		return  (isColIdxAsc
				?  getColIdx() < colsMinus1
				:  getColIdx() > 0);
	}
	public void goToNext()  {
		if(colIdx == -1)  {
			//First time is a special case.  (See "MUST initialize to -1")
			colIdx = 0;
			rowIdx = 0;
			return;
		}
		if(!hasNext())  {
			throw  new NoSuchElementException();
		}

		if(isColIdxAsc)  {
			if(getColIdx() < colsMinus1)  {
				colIdx++;
			}  else  {

				//In last column
				isColIdxAsc = !isColIdxAsc;
				rowIdx++;
			}

		//ELSE: Descending
		}  else if(getColIdx() > 0) {
			colIdx--;

		}  else  {

			//In first column
			isColIdxAsc = !isColIdxAsc;
			rowIdx++;
		}
	}
	public int getRowIdx()  {
		return  rowIdx;
	}
	public int getColIdx()  {
		return  colIdx;
	}
}
