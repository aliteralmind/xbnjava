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
 * <p>A single index-based location in a rectangular double-array.</p>
 *
 * @see  BoundedGrid
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class GridCoordinate extends AbstractCoordinate  {
	/**
	 * <p>Create a new item from its coordinates.</p>
	 * @param  horiz_idx The index of this item within its sub-array. May
	 * not be less than zero. Get with {@link #getHorizIndex()}.
	 * @param  vert_idx  The index of this items' sub-array within the
	 * overall array. May not be less than zero. Get with {@link #getVertIndex()}.
	 */
	public GridCoordinate(int horiz_idx, int vert_idx)  {
		super(horiz_idx, vert_idx);
		if(horiz_idx < 0)  {
			throw  new IllegalArgumentException("horiz_idx (" + horiz_idx + ") is less than zero.");
		}
		if(vert_idx < 0)  {
			throw  new IllegalArgumentException("vert_idx (" + vert_idx + ") is less than zero.");
		}
	}
	/**
	 * <p>The index of this item within its sub-array.</p>
	 *
	 * @return  <code>horiz_idx</code>, as provided to the
	 * {@link #GridCoordinate(int, int, O) constructor}.
	*/
	public int getHorizIndex()  {
		return  getHorizontal();
	}
	/**
	 * <p>The index of this items' sub-array within the overall array.</p>
	 *
	 * @return  <code>vert_idx</code>, as provided to the
	 * {@link #GridCoordinate(int) constructor}.
	*/
	public int getVertIndex()  {
		return  getVertical();
	}
	/**
	 * The difference in the horizontal indexes between this and another
	 * coordinate.
	 * @param  to_compareTo May not be <code>null</code>
	 * @return <code>({@link #getHorizIndex()}() - to_compareTo.getHorizIndex())</code>
	 * @see  #getVertDistance()
	 */
	public int getHorizDistance(GridCoordinate to_compareTo)  {
		try  {
			return  (getHorizIndex() - to_compareTo.getHorizIndex());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_compareTo");
		}
	}
	/**
	 * The difference in the vertical indexes between this and another
	 * coordinate.
	 * @param  to_compareTo May not be <code>null</code>
	 * @return <code>({@link #getVertIndex()}() - to_compareTo.getVertIndex())</code>
	 * @see  #getVertDistance()
	 */
	public int getVertDistance(GridCoordinate to_compareTo)  {
		try  {
			return  (getVertIndex() - to_compareTo.getVertIndex());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_compareTo");
		}
	}
	public DistanceDirection getDistance(GridCoordinate to_compareTo)  {
		return  new DistanceDirection(getHorizDistance(to_compareTo),
			                           getVertDistance(to_compareTo));
	}
}
