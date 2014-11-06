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
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.number.IntInRange;
	import  java.util.Arrays;
/**
 * <p>For traversing the elements in a rectangular double-array, in any
 * direction: up, down, left, right, up-left, up-right, down-left, down-right.</p>
 *
 * @see  GridCoordinate
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class BoundedGrid  {
	private final GridCoordinate[][] coords;
	private final int width;
	/**
	 * <p>Create a new grid with a particular height and width.</p>
	 *
	 * @param   width May not be less than zero. Get with {@link #getWidth()}{@code ()}.
	 * @param   height May not be less than zero. Get with {@link #getHeight()}{@code ()}.
	 *
	 */
	public BoundedGrid(int width, int height)  {
		try  {
			coords = new GridCoordinate[width][height];
		}  catch(ArrayIndexOutOfBoundsException ibx)  {
			throw  new ArrayIndexOutOfBoundsException("width=" + width + ", height=" + height);
		}

		this.width = width;

		for(int i = 0; i < coords.length; i++)  {
			for(int j = 0; j < coords[0].length; j++)  {
				coords[i][j] = new GridCoordinate(i, j);
			}
		}
	}
	/**
	 * <p>The number of elements within each sub-array.</p>
	 *
	 * @return  <code>width</code> as provided to the
	 * {@linkplain #BoundedGrid(int, int) constructor}.
	 */
	public int getWidth()  {
		return  width;
	}
	/**
	 * <p>The number of sub-arrays.</p>
	 *
	 * @return  <code>height</code> as provided to the
	 * {@linkplain #BoundedGrid(int, int) constructor}.
	 */
	public int getHeight()  {
		return  coords.length;
	}
	/**
	 * Get the coordinate at a specific location in the grid.
	 * @param  horiz_idx The element index corresponding to <code>width</code>,
	 * as provided to the {@linkplain #BoundedGrid(int, int) constructor}. Must
	 * be valid given {@link #getWidth()}{@code ()}.
	 * @param  vert_idx The element index corresponding to <code>height</code>,
	 * as provided to the constructor. Must be valid given {@link #getHeight()}{@code ()}.
	 * @return  A <code>GridCoordinate</code> with the provided indexes.
	 * @exception ArrayIndexOutOfBoundsException If either index is invalid.
	 */
	public GridCoordinate getCoordinate(int horiz_idx, int vert_idx)  {
		try  {
			return  coords[horiz_idx][vert_idx];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException("horiz_idx=" + horiz_idx + ", vert_idx=" + vert_idx + ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight());
		}
	}
	/**
	 * Are there at least X-number of neighbors between the item and the edge?.
	 * @param  item  May not be <code>null</code>
	 * @return <code>{@link #isNeighborCountAtLeast(int, int, com.github.xbn.util.grid.GridDirection, int)}(item.getHorizIndex(), item.getVertIndex(), direction, expected)</code>
	 */
	public boolean isNeighborCountAtLeast(GridCoordinate item, GridDirection direction, int expected)  {
		try  {
			return  isNeighborCountAtLeast(item.getHorizIndex(), item.getVertIndex(), direction, expected);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("item");
		}
	}
	/**
	 * Are there at least X-number of neighbors between the item and the edge?.
	 * @return <code>({@link #getNeighborCount(int, int, com.github.xbn.util.grid.GridDirection)}(horiz_idx, vert_idx, direction) &gt;= expected)</code>
	 * @see #isNeighborCountAtLeast(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, int)
	 */
	public boolean isNeighborCountAtLeast(int horiz_idx, int vert_idx, GridDirection direction, int expected)  {
		return  (getNeighborCount(horiz_idx, vert_idx, direction) >= expected);
	}
	/**
	 * <p>How many neighbors are there between an item and the grid's edge?.</p>
	 * @param  item     May not be <code>null</code>.
	 * @return <code>{@link #getNeighborCount(int, int, com.github.xbn.util.grid.GridDirection)}(item.{@link GridCoordinate#getHorizIndex() getHorizIndex}(), item.{@link GridCoordinate#getVertIndex() getVertIndex}(), direction)</code>
	 */
	public int getNeighborCount(GridCoordinate item, GridDirection direction)  {
		try  {
			return  getNeighborCount(item.getHorizIndex(), item.getVertIndex(), direction);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("item");
		}
	}
	/**
	 * <p>How many neighbors are there between an item and the grid's edge?.</p>
	 * @param   direction May not be <code>null</code>.
	 * @return  <code>getHVNeighborCount(hvDirection)</code>
	 * <br/>Where <code>hvDirection</code> is equal to
	 * <br> &nbsp; &nbsp; <code>{@link #getCoordinate(int, int)}(horiz_idx, vert_idx).{@link GridCoordinate#getShortestHVForDiagonal(com.github.xbn.util.grid.GridDirection)}(direction)</code>
	 * @see #getNeighborCount(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection) getNeighborCount(gc,gd)
	 * @see #isNeighborCountAtLeast(int, int, com.github.xbn.util.grid.GridDirection, int) isNeighborCountAtLeast(i,i,gd,i)
	 */
	public int getNeighborCount(int horiz_idx, int vert_idx, GridDirection direction)  {
		GridCoordinate item = getCoordinate(horiz_idx, vert_idx);
		HorizVertDirection hvDirection = null;
		try  {
			hvDirection = direction.getShortestHVForDiagonal(item);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("direction");
		}
		return  getHVNeighborCount(horiz_idx, vert_idx, hvDirection);
	}
	/**
	 * How many neighbors are there between an item and the grid's edge, in
	 * a <i>horizontal or vertical</i> direction only?.
	 * @param  horiz_idx  The index of the element within a sub-array.
	 * Must be a valid index given {@link #getHeight()}{@code ()}.
	 * @param  vert_idx   The index of the sub-array within the overall
	 * array. Must be a valid index given {@link #getHeight()}{@code ()}.
	 * @param  hv_direction May not be <code>null</code>.
	 * @return  The number of neighbor-items between the item and the edge, not
	 * including itself.
	 * @see  #getNeighborCount(int, int, com.github.xbn.util.grid.GridDirection)
	 */
	public int getHVNeighborCount(int horiz_idx, int vert_idx,
				HorizVertDirection hv_direction)  {
		switch(hv_direction)  {
			case UP:  return  vert_idx;
			case DOWN: return  (getHeight() - vert_idx + 1);
			case LEFT: return  horiz_idx;
			case RIGHT: return  (getWidth() - horiz_idx + 1);
		}
		throw  new IllegalArgumentException("Unexpected value for hv_direction: " + hv_direction);
	}
	/**
	 * Get a coordinate next to another.
	 * @param  horiz_idx The element index within a sub-array. Must be valid
	 * given {@link #getWidth()}{@code ()}.
	 * @param  vert_idx  The index of the sub-array within the overall array.
	 * Must be valid given {@link #getHeight()}{@code ()}.
	 * @param  direction May not be <code>null</code>.
	 * @param   doors_down The adjacency of the neighbor. Zero is itself,
	 * one is directly next door in the provided <code>direction</code>,
	 * negative one is directly next door in the opposite <code>direction</code>.
	 * For particularly high or low values, multiple wraps will be made.
	 * @param  crash_or_wrap May not be <code>null</code>.
	 * @return  The grid item that is <code>doors_down</code> elements away
	 * from <code>{@link #get(int, int) get}(horiz_idx, vert_idx)</code>, in
	 * the requested <code>direction</code>. If wrapping and the neighbor is
	 * outside of the grid boundaries, then it wraps around to the other side,
	 * <a href="https://www.youtube.com/watch?v=i3Pr8yC8_F4&t=29s">a la
	 * Asteroids</a>.
	 * @exception IllegalArgumentException  If
	 * <code>crash_or_wrap.{@link EdgeExceeded#CRASH CRASH}</code> and the
	 * edge is exceeded.
	 * @see #getNeighbor(int, int, com.github.xbn.util.grid.GridDirection, int, com.github.xbn.util.grid.EdgeExceeded)
	 */
	public GridCoordinate getNeighbor(int horiz_idx, int vert_idx,
				GridDirection direction, int doors_down, EdgeExceeded crash_or_wrap)  {
		int h = horiz_idx;
		int v = vert_idx;
		try  {
			h += direction.getHorizIncrement() * doors_down;
			if(h < 0)  {
				throwHorizExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
					doors_down, h);
				//Wrap
				while(h < 0)  {
					h += getWidth();
				}
			}  else if(h >= getWidth())  {
				throwHorizExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
					doors_down, h);
				//Wrap
				while(h >= getHeight())  {
					h -= getWidth();
				}
			}
		}  catch(NullPointerException npx)  {
			CrashIfObject.nullOrReturnCause(direction, "direction", null, npx);
		}
		v += direction.getVertIncrement() * doors_down;
		if(v < 0)  {
			throwVertExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
				doors_down, v);
			//Wrap
			while(v < 0)  {
				v += getHeight();
			}
		}  else if(v >= getHeight())  {
			throwVertExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
				doors_down, v);
			//Wrap
			while(v >= getHeight())  {
				v -= getHeight();
			}
		}
		return  getCoordinate(h, v);
	}
	/**
	 * Get the directly adjacent item.
	 * @param  coord         May not be <code>null</code>.
	 * @param  direction         May not be <code>null</code>.
	 * @return <code>{@link #getNeighbor(int, int, com.github.xbn.util.grid.GridDirection, int, com.github.xbn.util.grid.EdgeExceeded) getNeighbor}(coord.{@link GridCoordinate#getHorizIndex()}{@code ()}, coord.{@link GridCoordinate#getVertIndex()}{@code ()},
	 * <br/> &nbsp; &nbsp; {@link GridDirection}.{@link GridDirection#UP UP}, 1, crash_or_wrap)</code>
	 * @see #moveUp(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveUp(gc, ee)
	 * @see #moveDown(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveDown(gc, ee)
	 * @see #moveLeft(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveLeft(gc, ee)
	 * @see #moveRight(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveRight(gc, ee)
	 * @see #moveUpLeft(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveUpLeft(gc, ee)
	 * @see #moveUpRight(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveUpRight(gc, ee)
	 * @see #moveDownLeft(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveDownLeft(gc, ee)
	 * @see #moveDownRight(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.EdgeExceeded) moveDownRight(gc, ee)
	 */
	public GridCoordinate moveNextDoor(GridCoordinate item, GridDirection direction,
				EdgeExceeded crash_or_wrap)  {
		try  {
			return  getNeighbor(item.getHorizIndex(), item.getVertIndex(),
				direction, 1, crash_or_wrap);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("item");
		}
	}
	/**
	 * Get the directly adjacent coordinate, up.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#UP UP}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveUp(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.UP, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, down.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#DOWN DOWN}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveDown(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.DOWN, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, left.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#LEFT LEFT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveLeft(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.LEFT, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, right.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#RIGHT RIGHT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveRight(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.RIGHT, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, up-left.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#UP_LEFT UP_LEFT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveUpLeft(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.UP_LEFT, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, up-right.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#UP_RIGHT UP_RIGHT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveUpRight(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.UP_RIGHT, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, down-left.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#DOWN_LEFT DOWN_LEFT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveDownLeft(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.DOWN_LEFT, crash_or_wrap);
	}
	/**
	 * Get the directly adjacent coordinate, down-right.
	 * @param  item         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.grid.GridCoordinate, com.github.xbn.util.grid.GridDirection, com.github.xbn.util.grid.EdgeExceeded) moveNextDoor}(item, {@link GridDirection}.{@link GridDirection#DOWN_RIGHT DOWN_RIGHT}, crash_or_wrap)</code>
	 */
	public GridCoordinate moveDownRight(GridCoordinate item, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(item, GridDirection.DOWN_RIGHT, crash_or_wrap);
	}
	/**
	 * <p>Get the range of indexes in a single row-or-column unit, that have the
	 * required number of neighbors. This is useful for narrowing down which
	 * items to analyze.</p>
	 * @param  row_col  May not be <code>null</code>.
	 * @param  rc_index  Must be between zero and, if <ul>
	 *    <li><code>row_col.{@link RowColumn#isRow() isRow}()</code>:
	 *    <code>({@link #getWidth()}() - 1)</code></li>
	 *    <li><code>row_col.{@link RowColumn#isColumn() isColumn}()</code>:
	 *    ({@link #getHeigh()}() - 1)</li>
	 * </ul>
	 * @param  direction  May not be <code>null</code>.
	 * @param  neighbor_count The number of expected neighbors between each
	 * item and the edge. If negative, then the opposite of <code>direction</code>
	 * is used.
	 * @return  The range of indexes in the unit that have the
	 * required number of neighbors. If there are no items, this returns
	 * <code>null</code>.
	 */
	public IntInRange getIndexRangeForUnitNeighborCount(RowColumn row_col, int rc_index,
				GridDirection direction, int neighbor_count)  {
		try  {
			if(row_col.isRow())  {

			}
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("row_col");
		}
	}
		private final void throwHorizExceedsIAXIfCrash(
					EdgeExceeded crash_or_wrap, int horiz_idx, GridDirection direction,
					int doors_down, int resulting_idx)  {
			try  {
				if(crash_or_wrap.doCrash())  {
					throw  new IllegalArgumentException(
						"Horizontal index exceeds edge. horiz_idx=" + horiz_idx +
						", direction=" + direction + ", doors_down=" + doors_down +
						", resulting horizontal index after move: " + resulting_idx +
						", getWidth()=" + getWidth() + ".");
				}
			}  catch(NullPointerException npx)  {
				CrashIfObject.nullOrReturnCause(crash_or_wrap, "crash_or_wrap", null, npx);
			}
		}
		private final void throwVertExceedsIAXIfCrash(
					EdgeExceeded crash_or_wrap, int vert_idx, GridDirection direction,
					int doors_down, int resulting_idx)  {
			try  {
				if(crash_or_wrap.doCrash())  {
					throw  new IllegalArgumentException(
						"Vertical index exceeds edge. vert_idx=" + vert_idx +
						", direction=" + direction + ", doors_down=" + doors_down +
						", resulting vertical index after move: " + resulting_idx +
						", getHeight()=" + getHeight() + ".");
				}
			}  catch(NullPointerException npx)  {
				CrashIfObject.nullOrReturnCause(crash_or_wrap, "crash_or_wrap", null, npx);
			}
		}
	/**
	 * Is a iteminate valid?.
	 * @param  grid      May not be <code>null</code>.
	 * @param  horiz_idx Horizontal index.
	 * @param  vert_idx  Vertical index
	 * @return <code>true</code> If the indexes are valid given the grid's {@linkplain #getWidth() width} and {@linkplain #getHeight() height}.
	 */
	public static final boolean isValidCoordinate(BoundedGrid grid, int horiz_idx, int vert_idx)  {
		try  {
			return  (0 <= horiz_idx  &&  horiz_idx < grid.getWidth()  &&
				0 <= vert_idx  &&  vert_idx < grid.getHeight());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("grid");
		}
	}
}
