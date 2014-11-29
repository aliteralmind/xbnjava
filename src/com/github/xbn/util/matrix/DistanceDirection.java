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
package  com.github.xbn.util.matrix;
/**
 * <p>The distance and direction between two elements.</p>
 *
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class DistanceDirection extends AbstractElement  {
	private final MatrixDirection dir;
	/**
	 * <p>Create a new item from its elements.</p>
	 * @param  horiz_away  The number of columns the end is away from
	 * the start element. For example, if the start and end elements
	 * are {@code [1, 1]} and {@code [2, 1]}, respectively, then
	 * {@code horiz_away} is one. Get with {@link #getHorizontal()}.
	 * @param  vert_away  The number of rows the end is away from
	 * the start element. For example, if the start and end elements
	 * are {@code [1, 1]} and {@code [2, 1]}, respectively, then
	 * {@code horiz_away} is zero. If zero, both items are in the same row.
	 * Get with {@link #getVertical()}.
	 */
	public DistanceDirection(int horiz_away, int vert_away)  {
		super(horiz_away, vert_away);
		dir = getDirectionFromDistances(horiz_away, vert_away);
	}
	/**
	 * The direction between the two elements, if it happens to be a
	 * directly horizontal, vertical, or diagonal.
	 * @return  The direction between the two elements. If {@code null},
	 * then either both elements are the same, or the direction is not
	 * directly left, right, up, down, up-left, up-right, down-left, or
	 * down-right.
	 */
	public MatrixDirection getDirection()  {
		return  dir;
	}
	public String toString()  {
		return  super.toString() + ": direction=" +
			((getDirection() != null) ? getDirection() : "SELF-OR-UNKNOWN");
	}
	public static final DistanceDirection newForStartEnd(MatrixElement start,
				MatrixElement end)  {
		return  new DistanceDirection(start.getHorizDistance(end),
			                           start.getVertDistance(end));
	}
	/**
	 *
	 * @param   start  May not be <code>null</code>
	 * @param   end  May not be <code>null</code>
	 * @return  <blockquote><pre>{@link #getDirectionFromDistances(int, int) getDirectionFromDistances}(start.{@link MatrixElement#getHorizDistance(MatrixElement) getHorizDistance}(end),
	 *                                         start.{@link MatrixElement#getVertDistance(MatrixElement) getVertDistance}(end))</pre></blockquote>
	 */
	public static final MatrixDirection getDirectionFromDistances(
				MatrixElement start, MatrixElement end)  {
		return  getDirectionFromDistances(start.getHorizDistance(end),
			                               start.getVertDistance(end));
	}

	/**
	 * Given the relative distances, get the direction between two
	 * elements.
	 * @param  horiz_away  The difference between the start and end
	 * elements' horizontal values. Specifically,
	 * <br/> &nbsp; &nbsp; <code><i>[end-coord]</i>.{@link MatrixElement#getColumnIndex() getColumnIndex}() - <i>[start-coord]</i>.getColumnIndex()</code>
	 * @param  vert_away  The difference between the start and end
	 * elements' vertical values. Specifically,
	 * <br/> &nbsp; &nbsp; <code><i>[end-coord]</i>.{@link MatrixElement#getRowIndex() getRowIndex}() - <i>[start-coord]</i>.getRowIndex()</code>
	 * @return  If the distances are both zero, or the direction is not
	 * directly horizontal, vertical, or forty-five degrees diagonal, this
	 * returns {@code null}. Otherwise, this returns the direction between
	 * the two.
	 * @see #getDirectionFromDistances(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixElement)
	 */
	public static final MatrixDirection getDirectionFromDistances(int horiz_away, int vert_away)  {
		MatrixDirection dir = null;
		if(horiz_away != 0)  {
			if(vert_away == 0)  {
				dir = ((horiz_away < 0) ? MatrixDirection.LEFT : MatrixDirection.RIGHT);
			}  else if(Math.abs(horiz_away) == Math.abs(vert_away))  {
				//Directly diagonal
				if(horiz_away < 0)  {
					//This is to the left
					dir = ((vert_away < 0) ?  MatrixDirection.UP_LEFT: MatrixDirection.DOWN_LEFT);
				}  else  {
					//This is to the right
					dir = ((vert_away < 0) ?  MatrixDirection.UP_RIGHT: MatrixDirection.DOWN_RIGHT);
				}
			}  //Not directly diagonal, vert_awayical, or horizontal

		}  else if(vert_away != 0)  {
			//Horiz is zero, vert_away is not
			dir = ((vert_away < 0) ? MatrixDirection.UP : MatrixDirection.DOWN);
		}
		return  dir;
	}
	/**
	 * @return  <i>{@code this}</i>
	 */
	public DistanceDirection getObjectCopy()  {
		return  this;
	}

}