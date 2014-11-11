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
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.number.IndexInRange;
	import  com.github.xbn.lang.ExceptionUtil;
	import  java.util.Arrays;
/**
 * <p>For traversing the },s in a rectangular double-array, in any
 * direction: up, down, left, right, up-left, up-right, down-left,
 * down-right.</p>
 * @see  MatrixElement
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class BoundedMatrix  {
	private final MatrixElement[][] coords;
	private final int width;
	/**
	 * <p>Create a new grid with a particular height and width.</p>
	 * @param  width  May not be less than zero. Get with
	 * {@link #getWidth()}{@code ()}.
	 * @param  height  May not be less than zero. Get with
	 * {@link #getHeight()}{@code ()}.
	 * @see  #BoundedMatrix(com.github.xbn.util.matrix.BoundedMatrix)
	 * @see  #BoundedMatrix(com.github.xbn.util.matrix.MatrixElement[][]) BoundedMatrix(gc[][])
	 */
	public BoundedMatrix(int height, int width)  {
		coords = getArrayFromWidthHeight(height, width);
		this.width = width;
	}
	/**
	 * Create a new instance as a duplicate of another.
	 * @param   to_copy  May not be <code>null</code>
	 * @see  #getObjectCopy()
	 * @see  #BoundedMatrix(int, int)
	 */
	public BoundedMatrix(BoundedMatrix to_copy)  {
		try  {
			coords = new MatrixElement[to_copy.getHeight()][to_copy.getWidth()];
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_copy");
		}
		for(int i = 0; i < coords.length; i++)  {
			for(int j = 0; j < coords[0].length; j++)  {
				coords[i][j] = to_copy.coords[i][j].getObjectCopy();
			}
		}
		width = to_copy.getWidth();
	}
	/*
	 * <p>Create a new instance from a provided element double-array.</p>
	 *
	 * @param   coords  It is <i>assumed</i> that this is non-null, and valid--meaning <code>BoundedMatrix.{@link #crashIfBadCoordsArray(com.github.xbn.util.matrix.MatrixElement[][])}(coords)</code> would not result in a crash.
	 * @@see  #BoundedMatrix(int, int)
	protected BoundedMatrix(MatrixElement[][] coords)  {
		this.coords = coords;
		width = coords[0].length;
	}
	 */
	/**
	 * <p>The number of },s within each sub-array.</p>
	 *
	 * @return  <code>width</code> as provided to the
	 * {@linkplain #BoundedMatrix(int, int) constructor}.
	 */
	public int getWidth()  {
		return  width;
	}
	/**
	 * <p>The number of sub-arrays.</p>
	 *
	 * @return  <code>height</code> as provided to the
	 * {@linkplain #BoundedMatrix(int, int) constructor}.
	 */
	public int getHeight()  {
		return  coords.length;
	}
	public int getItemCount()  {
		return  (getWidth() * getHeight());
	}
	/**
	 * Get the element at a specific location in the grid.
	 * @return  <code>{@link #get(int, int, java.lang.String, java.lang.String) get}(vert_idx, horiz_idx, &quot;horiz_idx&quot;, &quot;vert_idx&quot;)</code>
	 */
	public MatrixElement get(int vert_idx, int horiz_idx)  {
		return  get(vert_idx, horiz_idx, "horiz_idx", "vert_idx");
	}
	/**
	 * Get the element at a specific location in the grid.
	 * @param  horiz_idx The }, index corresponding to
	 * <code>width</code>, as provided to the
	 * {@linkplain #BoundedMatrix(int, int) constructor}. Must be valid given
	 * {@link #getWidth()}{@code ()}.
	 * @param  vert_idx The }, index corresponding to <code>height</code>,
	 * as provided to the constructor. Must be valid given {@link #getHeight()}{@code ()}.
	 * @return  A <code>MatrixElement</code> with the provided indexes.
	 * @exception ArrayIndexOutOfBoundsException If either index is invalid.
	 * @see  #get(int, int)
	 */
	public MatrixElement get(int vert_idx, int horiz_idx, String hi_name, String vi_name)  {
		try  {
			return  coords[vert_idx][horiz_idx];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException(hi_name + "=" + horiz_idx + ", " + vi_name + "=" + vert_idx + ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight());
		}
	}
	/**
	 * Are there at least X-number of neighbors between the element and the
	 * edge?.
	 * @param  element  May not be <code>null</code>
	 * @return <code>{@link #isNeighborCountAtLeast(int, int, com.github.xbn.util.matrix.MatrixDirection, int)}(element.getHorizIndex(), element.getVertIndex(), direction, expected)</code>
	 */
	public boolean isNeighborCountAtLeast(MatrixElement element, MatrixDirection direction, int expected)  {
		try  {
			return  isNeighborCountAtLeast(element.getHorizIndex(), element.getVertIndex(), direction, expected);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("element");
		}
	}
	/**
	 * Are there at least X-number of neighbors between the element and the edge?.
	 * @return <code>({@link #getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection)}(vert_idx, horiz_idx, direction) &gt;= expected)</code>
	 * @see #isNeighborCountAtLeast(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, int)
	 */
	public boolean isNeighborCountAtLeast(int vert_idx, int horiz_idx, MatrixDirection direction, int expected)  {
		return  (getNeighborCount(vert_idx, horiz_idx, direction) >= expected);
	}
	/**
	 * <p>How many neighbors are there between an element and the grid's edge?.</p>
	 * @param  element     May not be <code>null</code>.
	 * @return <code>{@link #getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection)}(element.{@link MatrixElement#getHorizIndex() getHorizIndex}(), element.{@link MatrixElement#getVertIndex() getVertIndex}(), direction)</code>
	 */
	public int getNeighborCount(MatrixElement element, MatrixDirection direction)  {
		try  {
			return  getNeighborCount(element.getHorizIndex(), element.getVertIndex(), direction);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("element");
		}
	}
	/**
	 * <p>How many neighbors are there between an element and the grid's edge?.</p>
	 * @param   direction May not be <code>null</code>.
	 * @return  <code>getVHNeighborCount(hvDirection)</code>
	 * <br/>Where <code>hvDirection</code> is equal to
	 * <br> &nbsp; &nbsp; <code>{@link #get(int, int)}(vert_idx, horiz_idx).{@link MatrixElement#getShortestVHForDiagonal(com.github.xbn.util.matrix.MatrixDirection)}(direction)</code>
	 * @see #getNeighborCount(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection) getNeighborCount(gc,gd)
	 * @see #isNeighborCountAtLeast(int, int, com.github.xbn.util.matrix.MatrixDirection, int) isNeighborCountAtLeast(i,i,gd,i)
	 */
	public int getNeighborCount(int vert_idx, int horiz_idx, MatrixDirection direction)  {
		MatrixElement element = get(vert_idx, horiz_idx);
		VertHorizDirection hvDirection = null;
		try  {
			hvDirection = getShortestVHForDiagonal(vert_idx, horiz_idx, direction);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("direction");
		}
		return  getVHNeighborCount(vert_idx, horiz_idx, hvDirection);
	}
	/**
	 * How many neighbors are there between an element and the grid's edge, in
	 * a <i>horizontal or vertical</i> direction only?.
	 * @param  vert_idx   The index of the sub-array within the overall
	 * array. This <i>should</i> be a valid index given
	 * {@link #getHeight()}{@code ()}.
	 * @param  horiz_idx  The index of an element within the sub-array.
	 * This <i>should</i> be a valid index given {@link #getHeight()}{@code ()}.
	 * @param  hv_direction May not be <code>null</code>.
	 * @return  The number of neighbor-elements between the element and the edge,
	 * not including itself.
	 * @see  #getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection)
	 */
	public int getVHNeighborCount(int vert_idx, int horiz_idx,
				VertHorizDirection hv_direction)  {
		int count = -1;
		switch(hv_direction)  {
			case UP:     count = vert_idx;                        break;
			case DOWN:   count = (getHeight() - (vert_idx + 1));  break;
			case LEFT:   count = horiz_idx;                       break;
			case RIGHT:  count = (getWidth() - (horiz_idx + 1));  break;
			default:
				throw  new IllegalArgumentException("Unexpected value for hv_direction: " + hv_direction);
		}
//System.out.println("hv_direction=" + hv_direction + ", vert_idx=" + vert_idx + ", horiz_idx=" + horiz_idx + ", count=" + count + ", getHeight()=" + getHeight() + ", getWidth()=" + getWidth() + "");
		return  count;
	}
	/**
	 * Get the distance and direction between two elements.
	 * @param  start_vertIdx Vertical index of the start element. Must
	 * be valid given {@link #getHeight()}{@code ()}.
	 * @param  start_horizIdx Horizontal index of the start element. Must
	 * be valid given {@link #getWidth()}{@code ()}.
	 * @param  end_vertIdx Vertical index of the end element. Must
	 * be valid given {@link #getHeight()}{@code ()}.
	 * @param  end_horizIdx Horizontal index of the end element. Must
	 * be valid given {@link #getWidth()}{@code ()}.
	 * @return  <code>start.getDistance(end)</code>
	 * <br/>Where {@code start} is
	 * <br/> &nbsp; &nbsp; <code>{@link #get(int, int) get}(start_vertIdx, start_horizIdx)</code>
	 * <br/>and {@code end} is
	 * <br/> &nbsp; &nbsp; <code>get(end_vertIdx, end_horizIdx)</code>
	 */
	public DistanceDirection getNeighborDistDir(int start_vertIdx, int start_horizIdx,
			                                      int end_vertIdx,   int end_horizIdx)  {
		MatrixElement start = get(start_vertIdx, start_horizIdx,
			"start_vertIdx", "start_horizIdx");
		MatrixElement end = get(end_horizIdx, end_vertIdx,
			"end_vertIdx", "end_horizIdx");
		return  DistanceDirection.newForStartEnd(start, end);
	}
	/**
	 * Get a element that is a neighbor of another.
	 * @param  horiz_idx The }, index within a sub-array. Must be valid
	 * given {@link #getWidth()}{@code ()}.
	 * @param  vert_idx  The index of the sub-array within the overall array.
	 * Must be valid given {@link #getHeight()}{@code ()}.
	 * @param  direction May not be <code>null</code>.
	 * @param   doors_down The adjacency of the neighbor. Zero is itself,
	 * one is directly next door in the provided <code>direction</code>,
	 * negative one is directly next door in the opposite <code>direction</code>.
	 * For particularly high or low values, multiple wraps will be made.
	 * @param  crash_or_wrap May not be <code>null</code>.
	 * @return  The grid element that is <code>doors_down</code> },s away
	 * from <code>{@link #get(int, int) get}(vert_idx, horiz_idx)</code>, in
	 * the requested <code>direction</code>. If wrapping and the neighbor is
	 * outside of the grid boundaries, then it wraps around to the other
	 * side, <a href="https://www.youtube.com/watch?v=i3Pr8yC8_F4&t=29s">a
	 * la Asteroids</a>.
	 * @exception IllegalArgumentException  If
	 * <code>crash_or_wrap.{@link EdgeExceeded#CRASH CRASH}</code> and the
	 * edge is exceeded.
	 * @see #getNeighbor(int, int, com.github.xbn.util.matrix.MatrixDirection, int, com.github.xbn.util.matrix.EdgeExceeded)
	 */
	public MatrixElement getNeighbor(int vert_idx, int horiz_idx,
				MatrixDirection direction, int doors_down, EdgeExceeded crash_or_wrap)  {
		int v = vert_idx;
		int h = horiz_idx;
		try  {
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
		}  catch(NullPointerException npx)  {
			CrashIfObject.nullOrReturnCause(direction, "direction", null, npx);
		}
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
		return  get(v, h);
	}
		private final void throwHorizExceedsIAXIfCrash(
					EdgeExceeded crash_or_wrap, int horiz_idx, MatrixDirection direction,
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
					EdgeExceeded crash_or_wrap, int vert_idx, MatrixDirection direction,
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
	 * If <i><code>this</code></i> direction happens to be diagonal (for
	 * example, {@link #UP_LEFT}), then get its vertical or horizontal
	 * direction (for example, either {@link #UP} or {@link #LEFT}) that
	 * represents the <i>shortest</i> distance from a element to an edge.
	 *
	 * @param  coord May not be <code>null</code>.
	 * @param direction May not be <code>null</code>.
	 * @return If <code>direction</code> is already
	 * {@linkplain MatrixDirection#isVertical() vertical} or
	 * {@linkplain MatrixDirection#isHorizontal() horizontal}, its
	 * {@linkplain MatrixDirection#getVertPortion() vertical} or
	 * {@linkplain MatrixDirection#getHorizPortion() horizontal <i>portion</i>}
	 * is returned. If {@linkplain MatrixDirection#isDiagonal() diagonal},
	 * then the portion whose
	 * {@linkplain #getVHNeighborCount(int, int, com.github.xbn.util.matrix.VertHorizDirection) distance to the edge}
	 * is longest is returned. (In the case of a tie, vertical is returned).
	 * @see #getLongestVHForDiagonal(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection)
	 * @see getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection) BoundedMatrix#getNeighborCount
	 */
	public VertHorizDirection getShortestVHForDiagonal(int vert_idx, int horiz_idx, MatrixDirection direction)  {
		return  getVHPortion(ShortLong.SHORT, vert_idx, horiz_idx, direction);
	}
	/**
	 * If <i><code>this</code></i> direction happens to be diagonal (for
	 * example, {@link #UP_LEFT}), then get its vertical or horizontal
	 * direction (for example, either {@link #UP} or {@link #LEFT}) that
	 * represents the <i>longest</i> distance from a element to an edge.
	 *
	 * @param  vert_idx   The element of the sub-array within the overall
	 * array. This <i>should</i> be a valid index given
	 * {@link #getHeight()}{@code ()}.
	 * @param  horiz_idx  The index of an element within the sub-array.
	 * This <i>should</i> be a valid index given {@link #getHeight()}{@code ()}.
	 * @param direction May not be <code>null</code>.
	 * @return If <code>direction</code> is already
	 * {@linkplain MatrixDirection#isVertical() vertical} or
	 * {@linkplain MatrixDirection#isHorizontal() horizontal}, its
	 * {@linkplain MatrixDirection#getVertPortion() vertical} or
	 * {@linkplain MatrixDirection#getHorizPortion() horizontal <i>portion</i>}
	 * is returned. If {@linkplain MatrixDirection#isDiagonal() diagonal},
	 * then the portion whose
	 * {@linkplain #getVHNeighborCount(int, int, com.github.xbn.util.matrix.VertHorizDirection) distance to the edge}
	 * is shortest is returned. (In the case of a tie, vertical is returned).
	 * @see
	 * @see #isDiagonal()
	 * @see getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection) BoundedMatrix#getNeighborCount
	 */
	public VertHorizDirection getLongestVHForDiagonal(int vert_idx, int horiz_idx, MatrixDirection direction)  {
		return  getVHPortion(ShortLong.LONG, vert_idx, horiz_idx, direction);
	}
		private static enum ShortLong {SHORT, LONG};
		private VertHorizDirection getVHPortion(ShortLong short_long, int vert_idx, int horiz_idx, MatrixDirection direction)  {
			try  {
				if(direction.isVertical())  {
					return  direction.getVertPortion();
				}  else  if(direction.isHorizontal())  {
					return  direction.getHorizPortion();
				}
			}  catch(NullPointerException npx)  {
				throw  CrashIfObject.nullOrReturnCause(direction, "direction", null, npx);
			}

			//Diagonal

			VertHorizDirection vert = direction.getVertPortion();
			VertHorizDirection horiz = direction.getHorizPortion();

			int v = getVHNeighborCount(vert_idx, horiz_idx, vert);
			int h = getVHNeighborCount(vert_idx, horiz_idx, horiz);

			if(v == h)  {
				return  vert;
			}

			//Different

			return  ((short_long == ShortLong.SHORT)
				?  (v < h) ? vert  : horiz
				:  (v < h) ? horiz : vert );
		}
	/**
	 * Get a directly-adjacent element.
	 * @return   <blockquote><pre>{@link #moveNextDoor(int, int, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element.{@link MatrixElement#getVertIndex() getVertIndex}(), element.{@link MatrixElement#getHorizIndex() getHorizIndex}(), direction,
	 *    crash_or_wrap)</pre></blockquote>
	 */
	public MatrixElement moveNextDoor(MatrixElement element, MatrixDirection direction,
				EdgeExceeded crash_or_wrap)  {
		try  {
			return  moveNextDoor(element.getVertIndex(), element.getHorizIndex(), direction,
				crash_or_wrap);
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("element");
		}
	}
	/**
	 * Get a directly-adjacent element.
	 * @param  coord         May not be <code>null</code>.
	 * @param  direction         May not be <code>null</code>.
	 * @return <code>{@link #getNeighbor(int, int, com.github.xbn.util.matrix.MatrixDirection, int, com.github.xbn.util.matrix.EdgeExceeded) getNeighbor}(coord.{@link MatrixElement#getVertIndex() getVertIndex}{@code ()}, coord.{@link MatrixElement#getHorizIndex() getHorizIndex}{@code ()},
	 * <br/> &nbsp; &nbsp; {@link MatrixDirection}.{@link MatrixDirection#UP UP}, 1, crash_or_wrap)</code>
	 * @see #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor(me,md,ee)
	 * @see #moveUp(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveUp(gc, ee)
	 * @see #moveDown(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveDown(gc, ee)
	 * @see #moveLeft(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveLeft(gc, ee)
	 * @see #moveRight(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveRight(gc, ee)
	 * @see #moveUpLeft(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveUpLeft(gc, ee)
	 * @see #moveUpRight(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveUpRight(gc, ee)
	 * @see #moveDownLeft(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveDownLeft(gc, ee)
	 * @see #moveDownRight(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.EdgeExceeded) moveDownRight(gc, ee)
	 */
	public MatrixElement moveNextDoor(int vert_idx, int horiz_idx, MatrixDirection direction,
				EdgeExceeded crash_or_wrap)  {
		return  getNeighbor(vert_idx, horiz_idx, direction, 1, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, up.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#UP UP}, crash_or_wrap)</code>
	 */
	public MatrixElement moveUp(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.UP, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, down.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#DOWN DOWN}, crash_or_wrap)</code>
	 */
	public MatrixElement moveDown(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.DOWN, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, left.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#LEFT LEFT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveLeft(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.LEFT, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, right.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#RIGHT RIGHT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveRight(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.RIGHT, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, up-left.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#UP_LEFT UP_LEFT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveUpLeft(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.UP_LEFT, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, up-right.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#UP_RIGHT UP_RIGHT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveUpRight(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.UP_RIGHT, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, down-left.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#DOWN_LEFT DOWN_LEFT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveDownLeft(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.DOWN_LEFT, crash_or_wrap);
	}
	/**
	 * Get a directly-adjacent element, down-right.
	 * @param  element         May not be <code>null</code>.
	 * @return <code>{@link #moveNextDoor(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixDirection, com.github.xbn.util.matrix.EdgeExceeded) moveNextDoor}(element, {@link MatrixDirection}.{@link MatrixDirection#DOWN_RIGHT DOWN_RIGHT}, crash_or_wrap)</code>
	 */
	public MatrixElement moveDownRight(MatrixElement element, EdgeExceeded crash_or_wrap)  {
		return  moveNextDoor(element, MatrixDirection.DOWN_RIGHT, crash_or_wrap);
	}
	/**
	 * <p>Get the range of indexes in a single row, that have the required
	 * number of neighbors. This is useful for narrowing down which elements
	 * to analyze.</p>
	 * @param  row_idx  <i>Should</i> be between zero and
	 * <code>({@link #getWidth()}() - 1)</code>, inclusive.
	 * @param  direction  May not be <code>null</code>.
	 * @param  neighbor_count The number of required neighbors between each
	 * element and the edge (going in the requsted {@code direction}. If
	 * negative, then
	 * <code>direction.{@link MatrixDirection#getOpposite() getOpposite}()</code>
	 * is used.
	 * @return  The range of indexes in the row that have the required number of
	 * neighbors. If none, this returns <code>null</code>.
 	 * @see  #getColItemIdxRangeForNeighborCount(int, com.github.xbn.util.matrix.MatrixDirection, int)
	 */
	public IndexInRange getRowItemIdxRangeForNeighborCount(int row_idx,
				MatrixDirection direction, int neighbor_count)  {
		if(row_idx < 0  ||  (getWidth() - 1) < row_idx)  {
			throw  new IllegalArgumentException("row_idx (" + row_idx +
				") must be between 0 and (getWidth() - 1) (" + (getWidth() - 1) +
				", inclusive.");
		}
		if(neighbor_count < 0)  {
			neighbor_count = Math.abs(neighbor_count);
			direction = direction.getOpposite();
		}

		VertHorizDirection horizDir = direction.getHorizPortion();
		VertHorizDirection vertDir = direction.getVertPortion();

		if(direction.hasUp()  &&  row_idx < neighbor_count)  {
			return  null;
		}
		if(direction.hasDown()  &&  (getWidth() - neighbor_count) <= row_idx)  {
			return  null;
		}
		if((direction.hasLeft()  ||  direction.hasRight())  &&
				getWidth() <= neighbor_count)  {
			return  null;
		}
		if(direction.isUp()  ||  direction.isDown())  {
			//Every element in the row has the required number of elements
			//above or below it
			return  new IndexInRange(0, getWidth());
		}

		//Diagonal

		//Vertically, every element in the row has the required neighbors.
		//Horizontally, some may not.

		int leftIdx = (!direction.hasLeft() ? 0 : neighbor_count);
		int rightIdxExcl = (direction.hasRight()
			?  neighbor_count - getWidth()
			:  getWidth());

		return  new IndexInRange(leftIdx, rightIdxExcl);
	}
	/**
	 * <p>Get the range of indexes in a single column, that have the
	 * required number of neighbors. This is useful for narrowing down which
	 * elements to analyze.</p>
	 * @param  col_idx  <i>Should</i> be between zero and
	 * <code>({@link #getHeight()}() - 1)</code>, inclusive.
	 * @param  direction  May not be <code>null</code>.
	 * @param  neighbor_count The number of required neighbors between each
	 * element and the edge (going in the requsted {@code direction}. If
	 * negative, then
	 *  <code>direction.{@link MatrixDirection#getOpposite() getOpposite}()</code>
	 * is used.
	 * @return  The range of indexes in the column that have the required
	 * number of neighbors. If none, this returns <code>null</code>.
	 * @see  #getRowItemIdxRangeForNeighborCount(int, com.github.xbn.util.matrix.MatrixDirection, int)
	 */
	public IndexInRange getColItemIdxRangeForNeighborCount(int col_idx,
				MatrixDirection direction, int neighbor_count)  {
		if(col_idx < 0  ||  (getHeight() - 1) < col_idx)  {
			throw  new IllegalArgumentException("col_idx (" + col_idx +
				") must be between 0 and (getHeight() - 1) (" + (getHeight() - 1) +
				", inclusive.");
		}
		if(neighbor_count < 0)  {
			neighbor_count = Math.abs(neighbor_count);
			direction = direction.getOpposite();
		}

		VertHorizDirection horizDir = direction.getHorizPortion();
		VertHorizDirection vertDir = direction.getVertPortion();

		if(direction.hasLeft()  &&  col_idx < neighbor_count)  {
			return  null;
		}
		if(direction.hasRight()  &&  (getHeight() - neighbor_count) <= col_idx)  {
			return  null;
		}
		if((direction.hasLeft()  ||  direction.hasRight())  &&
				getHeight() <= neighbor_count)  {
			return  null;
		}
		if(direction.isLeft()  ||  direction.isRight())  {
			//Every element in the col has the required number of elements
			//above or below it
			return  new IndexInRange(0, getHeight());
		}

		//Diagonal

		//Horizontally, every element in the col has the required neighbors.
		//Vertically, some may not.

		int topIdx = (!direction.hasLeft() ? 0 : neighbor_count);
		int bottomIdxExcl = (direction.hasRight()
			?  neighbor_count - getHeight()
			:  getHeight());

		return  new IndexInRange(topIdx, bottomIdxExcl);
	}
	public String toString()  {
		return  "height=" + getHeight() + ", width=" + getWidth();
	}
	/**
	 * @return  <CODE>(new {@link #BoundedMatrix(BoundedMatrix) BoundedMatrix}(this))</CODE>
	 */
	public BoundedMatrix getObjectCopy()  {
		return  (new BoundedMatrix(this));
	}
	/**
	 * Is a element valid for this grid?.
	 * @param  grid      May not be <code>null</code>.
	 * @param  horiz_idx Horizontal index.
	 * @param  vert_idx  Vertical index
	 * @return <code>true</code> If the indexes are valid given the grid's
	 * {@linkplain #getWidth() width} and {@linkplain #getHeight() height}.
	 */
	public static final boolean isValidElement(BoundedMatrix grid, int vert_idx, int horiz_idx)  {
		try  {
			return  (0 <= horiz_idx  &&  horiz_idx < grid.getWidth()  &&
				0 <= vert_idx  &&  vert_idx < grid.getHeight());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("grid");
		}
	}
	public static final void crashIfBadCoordsArray(MatrixElement[][] coords)
	{
		int lenFirst = -1;
		try  {
			lenFirst = coords[0].length;
		}  catch(NullPointerException npx)  {
			CrashIfObject.nnull(coords, "coords", null);
			CrashIfObject.nullOrReturnCause(coords[0], "coords[0]", null, npx);
		}
		for(int i = 0; i < coords.length; i++)  {
			try  {
				if(coords[i].length != lenFirst)  {
					throw  new IllegalArgumentException("coords[" + i + "].length (" +
						coords[i].length + ") is different than coords[0].length (" +
						coords[0].length + ")");
				}
			}  catch(NullPointerException npx)  {
				throw  CrashIfObject.nullOrReturnCause(coords[i], "coords[" + i + "]", null, npx);
			}
			for(int j = 0; j < lenFirst; j++)  {
				MatrixElement coord = coords[i][j];
				try  {
					if(coord.getHorizIndex() != i  ||  coord.getVertIndex() != j)  {
						throw  new IllegalArgumentException("coords[" + i + "][" + j +
							"] has unexpected elements: " + coord);
					}
				}  catch(NullPointerException npx)  {
					throw  CrashIfObject.nullOrReturnCause(coords[i][j], "coords[" +
						i + "][" + j + "]", null, npx);
				}
			}
		}
	}
	/**
	 * Get a new double array of elements with a specific width and
	 * height.
	 * @param  width  May not be less than zero.
	 * @param  height  May not be less than zero.
	 * @return A
	 * <br/> &nbsp; &nbsp; <code>new MatrixElement[height][width]</code>
	 * Where each }, is a <code>MatrixElement</code>, having
	 * {@linkplain MatrixElement#getHorizIndex() horizontal} and
	 * {@linkplain MatrixElement#getVertIndex() vertical} indexes
	 * equivalent to its location in the array (vertical is the sub-array,
	 * horizontal is the }, within that array).
	 */
	public MatrixElement[][] getArrayFromWidthHeight(int height, int width)  {
		MatrixElement[][] coords = null;
		try  {
			coords = new MatrixElement[height][width];
		}  catch(ArrayIndexOutOfBoundsException ibx)  {
			throw  new ArrayIndexOutOfBoundsException("width=" + width + ", height=" + height);
		}

		for(int h = 0; h < height; h++)  {
			for(int w = 0; w < width; w++)  {
				coords[h][w] = new MatrixElement(h, w);
			}
		}
		return  coords;
	}
}
