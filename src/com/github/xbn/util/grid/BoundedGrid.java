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
package  com.github.xbn.util;
	import  com.github.xbn.lang.CrashIfObject;
	import  java.util.Arrays;
/**
 * <p>For traversing the elements in a rectangular double-array, in any
 * direction: up, down, left, right, up-left, up-right, down-left, down-right.</p>
 *
 * @see  GridItem
 * @since  0.1.4.2
 * author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class BoundedGrid<O>  {
	private final GridItem<O>[][] items = null;
	private final int subArrayLen = -1;
	/**
	 * <p>Create a new instance from a double-array of items.</p>
	 *
	 * @param  items  The items. May not be <code>null</code>, and each
	 * sub-array must be non-<code>null</code> and the same length. All
	 * arrays are duplicated internally, but the item-elements are not. Get
	 * with {@link #getItems()}.
	 */
	public BoundedGrid(GridItem<O> items)  {
		int len = -1;

		try  {
			len = items.length;
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("items");
		}
		try  {
			subArrayLen = items[0].length;
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("items[0]");
		}

		this.items[][] = new GridItem<O>[len][subArrayLen];

		for(int i = 1; i < len; i++)  {
			try  {
				if(items[i].length != subArrayLen)  {
					throw  new IllegalArgumentException("The length of items[" + i +
					 "] (" + items[i].length + ") is different than items[" + i +
					 "] (" + subArrayLen + ").");
				}
			}  catch(NullPointerException npx)  {
				throw  new NullPointerException("items[" + i + "]");
			}
		}
		this.items = Arrays.copyOf(items, len);
	}
	/**
	 * <p>The number of elements within each sub-array.</p>
	 *
	 * @return  <code>items[0].length</code>, where <code>items</code> is as
	 * provided to the
	 * {@link #BoundedGrid(com.github.xbn.util.grid.GridItem<O>) constructor}.
	 */
	public GridItem<O> getHorizLength()  {
		return  subArrayLen;
	}
	/**
	 * <p>The number of sub-arrays.</p>
	 *
	 * @return  <code>items.length</code>, where <code>items</code> is as
	 * provided to the
	 * {@link #BoundedGrid(com.github.xbn.util.grid.GridItem<O>) constructor}.
	 */
	public GridItem<O> getVertLength()  {
		return  items.length;
	}
	/**
	 * Get a grid-item at a specific coordinate.
	 * @param  horiz_idx The element index within a sub-array. Must be valid
	 * given {@link #getHorizLength()}{@code ()}.
	 * @param  vert_idx  The index of the sub-array within the overall array.
	 * Must be valid given {@link #getVertLength()}{@code ()}.
	 * @return  <code>items[horiz_idx][vert_idx]</code>, where <code>items</code>
	 * is as provided to the
	 * {@link #BoundedGrid(com.github.xbn.util.grid.GridItem<O>) constructor}.
	 */
	public GridItem<O> get(int horiz_idx, int vert_idx)  {
		try  {
			return  items[horiz_idx][vert_idx];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException("Invalid coordinate: horiz_idx=" + horiz_idx + ", vert_idx=" + vert_idx + ", getHorizLength()=" + getHorizLength() + ", getVertLength()=" + getVertLength());
		}
	}
	public boolean isValidCoordinate(int horiz_idx, int vert_idx)  {
		return  (0 <= horiz_idx  &&  horiz_idx < getHorizLength()  &&
			0 <= vert_idx  &&  vert_idx < getVertLength());
	}
	/**
	 * How many neighbors are there between an item and the grid's edge, in
	 * the given direction?.
	 * @param   direction May not be <code>null</code>.
	 * @return  <code>getHorizVertNeighborCountFor(dirHorizVert)</code>
	 * <br/>Where <code>dirHorizVert</code> is equal to
	 * <br> &nbsp; &nbsp; <code>{@link #getItem(int, int)}(horiz_idx, vert_idx).{@link GridItem#getHorizVertDirectionForItem(com.github.xbn.util.grid.GridDirection)}(direction)</code>
	 */
	public int getNeighborCount(int horiz_idx, int vert_idx, GridDirection direction)  {
		dirHorizVert = getItem(horiz_idx, vert_idx).getHorizVertDirectionForItem(direction);
		return  getHorizVertNeighborCountFor(dirHorizVert);
	}
	/**
	 * How many neighbors are there between an item and the grid's edge, in
	 * the given <i>horizontal or vertical</i> direction?.
	 *
	 * @param  horiz_idx  The index of the element within a sub-array.
	 * Must be a valid index given {@link #getVertLength()}{@code ()}.
	 * @param  vert_idx   The index of the sub-array within the overall
	 * array. Must be a valid index given {@link #getVertLength()}{@code ()}.
	 * @param  direction The direction to search. May not be <code>null</code>,
	 * and must be {@link GridDirection.UP UP}, {@link GridDirection.DOWN DOWN},
	 * {@link GridDirection.LEFT LEFT}, or {@link GridDirection.RIGHT RIGHT}.
	 * @return  The number of items between the item and the edge, not
	 * including the item itself.
	 * @see  #getNeighborCount(int, int, com.github.xbn.util.grid.GridDirection)
	 */
	public int getHorizVertNeighborCountFor(int horiz_idx, int vert_idx,
				GridDirection direction)  {
		switch(dirHorizVert)  {
			case UP:  return  vert_idx;
			case DOWN: return  (getVertLength() - vert_idx + 1);
			case LEFT: return  horiz_idx;
			case RIGHT: return  (getHorizLength() - horiz_idx + 1);
		}
		throw  new IllegalArgumentException("direction (" + direction +
			") must be UP, DOWN, LEFT, or RIGHT.");
	}
	/**
	 * Get a grid item that is next to another.
	 * @param  horiz_idx The element index within a sub-array. Must be valid
	 * given {@link #getHorizLength()}{@code ()}.
	 * @param  vert_idx  The index of the sub-array within the overall array.
	 * Must be valid given {@link #getVertLength()}{@code ()}.
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
	 */
	public GridItem<O> getNeighbor(int horiz_idx, int vert_idx,
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
					h += getHorizLength();
				}
			}  else if(h >= getHorizLength())  {
				throwHorizExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
					doors_down, h);
				//Wrap
				while(h >= getVertLength())  {
					h -= getHorizLength();
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
				v += getVertLength();
			}
		}  else if(v >= getVertLength())  {
			throwVertExceedsIAXIfCrash(crash_or_wrap, horiz_idx, direction,
				doors_down, v);
			//Wrap
			while(v >= getVertLength())  {
				v -= getVertLength();
			}
		}
		return  getItem(h, v);
	}
	private static final IllegalArgumentException throwHorizExceedsIAXIfCrash(
				EdgeExceeded crash_or_wrap, int horiz_idx, GridDirection direction,
				int doors_down, int resulting_idx)  {
		try  {
			if(crash_or_wrap.doCrash())  {
				return  new IllegalArgumentException("Horizontal index exceeds edge: horiz_idx (" +
					horiz_idx + ") plus [doors_down (" + doors_down +
					") * direction.getHorizIncrement() (" + direction.getHorizIncrement() +
					")] is " + resulting_idx + " (getHorizLength()=" + getHorizLength() + ").");
			}
		}  catch(NullPointerException npx)  {
			CrashIfObject.nnullOrReturnCause(crash_or_wrap, "crash_or_wrap", null, npx);
		}
	}
	private static final IllegalArgumentException throwVertExceedsIAXIfCrash(
				EdgeExceeded crash_or_wrap, int vert_idx, GridDirection direction,
				int doors_down, int resulting_idx)  {
		try  {
			if(crash_or_wrap.doCrash())  {
				return  new IllegalArgumentException("Vertical index exceeds edge: vert_idx (" +
					vert_idx + ") plus [doors_down (" + doors_down +
					") * direction.getVertIncrement() (" + direction.getVertIncrement() +
					")] is " + resulting_idx + " (getVertLength()=" + getVertLength() + ").");
			}
		}  catch(NullPointerException npx)  {
			CrashIfObject.nnullOrReturnCause(crash_or_wrap, "crash_or_wrap", null, npx);
		}
	}
}