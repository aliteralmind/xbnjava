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
 * <p>A bounded grid whose },s may be occupied or unoccupied.</p>
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class FillableMatrix extends BoundedMatrix  {
	/**
	 * <p>Create a new grid with a particular height and width.</p>
	 */
	public FillableMatrix(int width, int height)  {
		super(width, height);
	}
	/**
	 * Create a new instance as a duplicate of another.
	 */
	public FillableMatrix(FillableMatrix to_copy)  {
		super(to_copy);
	}
	/*
	 * <p>Create a new instance from a provided element double-array.</p>
	protected FillableMatrix(FillableElement[][] coords)  {
		super(coords);
	}
	 */
	public FillableElement get(int horiz_idx, int vert_idx)  {
		return  (FillableElement)super.get(horiz_idx, vert_idx);
	}
	public FillableElement get(int horiz_idx, int vert_idx, String hi_name, String vi_name)  {
		return  (FillableElement)super.get(horiz_idx, vert_idx, hi_name, vi_name);
	}
	public void unfillAll()  {
		fillAll(false);
	}
	public void fillAll()  {
		fillAll(true);
	}
	public void fillAll(boolean is_filled)  {
		for(int i = 0; i < getHeight(); i++)  {
			for(int j = 0; j < getWidth(); j++)  {
				get(i, j).fill(is_filled);
			}
		}
	}
	public boolean areAllFilled()  {
		return  (getFillCount() == getItemCount());
	}
	public boolean areAllUnfilled()  {
		return  (getFillCount() == 0);
	}
	public int getFillCount()  {
		int filled = 0;
		for(int i = 0; i < getHeight(); i++)  {
			for(int j = 0; j < getWidth(); j++)  {
				if(get(i, j).isFilled())  {
					filled++;
				}
			}
		}
		return  filled;
	}
	public FillableMatrix unfill(int horiz_idx, int vert_idx)  {
		return  fill(false, horiz_idx, vert_idx);
	}
	public FillableMatrix fill(int horiz_idx, int vert_idx)  {
		return  fill(true, horiz_idx, vert_idx);
	}
	public FillableMatrix fill(boolean is_filled, int horiz_idx, int vert_idx)  {
		get(horiz_idx, vert_idx, "horiz_idx", "vert_idx").fill(is_filled);
		return  this;
	}
	public boolean isFilled(int horiz_idx, int vert_idx)  {
		return  get(horiz_idx, vert_idx, "horiz_idx", "vert_idx").isFilled();
	}
	/**
	 * Get a new double array of elements with a specific width and
	 * height.
	 * @param  width  May not be less than zero.
	 * @param  height  May not be less than zero.
	 * @return A
	 * <br/> &nbsp; &nbsp; <code>new FillableElement[width][height]</code>
	 * Where each }, is an
	 * {@linkplain FillableElement#isFilled() unfilled}
	 * <code>FillableElement</code>, having
	 * {@linkplain FillableElement#getHorizIndex() horizontal} and
	 * {@linkplain FillableElement#getVertIndex() vertical} indexes
	 * equivalent to its location in the array (vertical is the sub-array,
	 * horizontal is the }, within that array).
	 */
	public MatrixElement[][] getArrayFromWidthHeight(int width, int height)  {
		FillableElement[][] coords = null;
		try  {
			coords = new FillableElement[width][height];
		}  catch(ArrayIndexOutOfBoundsException ibx)  {
			throw  new ArrayIndexOutOfBoundsException("width=" + width + ", height=" + height);
		}

		for(int i = 0; i < coords.length; i++)  {
			for(int j = 0; j < coords[0].length; j++)  {
				coords[i][j] = new FillableElement(i, j);
			}
		}
		return  coords;
	}
	/**
	 * @return  <CODE>(new {@link #FillableMatrix(FillableMatrix) FillableMatrix}(this))</CODE>
	 */
	public FillableMatrix getObjectCopy()  {
		return  (new FillableMatrix(this));
	}
}