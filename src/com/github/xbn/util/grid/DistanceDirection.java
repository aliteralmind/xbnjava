/*license*\
   XBN-Java: http://xbnjava.aliteralmind.com

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.util.grid;
/**
 * <p>The distance and direction between two coordinates in a rectangular grid.</p>
 *
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class DistanceDirection extends AbstractCoordinate  {
	private final GridDirection dir;
	/**
	 * <p>Create a new item from its coordinates.</p>
	 * @param  horiz The number of columns away, one coordinate is from
	 * another. If zero, both items are in the same column. Get with
	 * {@link #getHorizontal()}.
	 * @param  vert  The number of rows away, one coordinate is from
	 * another. If zero, both items are in the same row. Get with
	 * {@link #getVertical()}.
	 */
	public DistanceDirection(int horiz, int vert)  {
		super(horiz, vert);

		GridDirection tempDir = null;
		if(horiz != 0)  {
			if(vert == 0)  {
				tempDir = ((horiz < 0) ? GridDirection.RIGHT : GridDirection.LEFT);
			}  else if(Math.abs(horiz) == Math.abs(vert))  {
				//Directly diagonal
				if(horiz < 0)  {
					//This is to the left
					tempDir = ((vert < 0) ?  GridDirection.DOWN_RIGHT: GridDirection.UP_RIGHT);
				}  else  {
					//This is to the right
					tempDir = ((vert < 0) ?  GridDirection.DOWN_LEFT: GridDirection.UP_LEFT);
				}
			}  //Not directly diagonal, vertical, or horizontal

		}  else if(vert != 0)  {
			//Horiz is zero, vert is not
			tempDir = ((vert < 0) ? GridDirection.DOWN : GridDirection.UP);
		}
		dir = tempDir;
	}
	/**
	 * The direction between the two coordinates, if it happens to be a
	 * directly horizontal, vertical, or diagonal.
	 * @return  The direction between the two coordinates. If {@code null},
	 * then either both coordinates are the same, or the direction is not
	 * directly left, right, up, down, up-left, up-right, down-left, or
	 * down-right.
	 */
	public GridDirection getGridDirection()  {
		return  dir;
	}
	public String toString()  {
		return  super.toString() + ": direction=" +
			((getGridDirection() != null) ? getGridDirection() : "SELF-OR-UNKNOWN");
	}
}