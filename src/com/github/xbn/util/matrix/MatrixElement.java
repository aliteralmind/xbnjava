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
 * <p>A single index-based location in a rectangular double-array.</p>
 *
 * @see  BoundedMatrix
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class MatrixElement extends AbstractElement  {
	/**
	 * <p>Create a new item from its elements.</p>
	 * @param  col_idx The index of the column. This is intended to be the
	 * element index within a single sub-array. May not be less than zero.
	 * Get with {@link #getColumnIndex()}.
	 * @param  row_index  The index of the row. This is intended to be the
	 * sub-array index as it exists in the overall array. Get with
	 * {@link #getRowIndex()}.
	 */
	public MatrixElement(int row_index, int col_idx)  {
		super(row_index, col_idx);
		if(row_index < 0)  {
			throw  new IllegalArgumentException("row_index (" + row_index + ") is less than zero.");
		}
		if(col_idx < 0)  {
			throw  new IllegalArgumentException("col_idx (" + col_idx + ") is less than zero.");
		}
	}
	/*
	 * <p>The index of this items' sub-array within the overall array.</p>
	 *
	 * @return  <code>row_index</code>, as provided to the
	 * {@link #MatrixElement(int) constructor}.
	public int getRowIndex()  {
		return  getVertical();
	}
	*/
	/*
	 * <p>The index of this item within its sub-array.</p>
	 *
	 * @return  <code>col_idx</code>, as provided to the
	 * {@link #MatrixElement(int, int, O) constructor}.
	public int getColumnIndex()  {
		return  getHorizontal();
	}
	*/
	/**
	 * The horizontal distance (the number of cells away) from <i>{@code this}</i>
	 * element to another.
	 * @param  to_compareTo May not be <code>null</code>
	 * @return <code>(to_compareTo.{@link #getColumnIndex()}() - getColumnIndex())</code>
	 * @see  #getVertDistance()
	 */
	public int getHorizDistance(MatrixElement to_compareTo)  {
		try  {
			return  (to_compareTo.getColumnIndex() - getColumnIndex());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_compareTo");
		}
	}
	/**
	 * The vertical distance (the number of cells away) from <i>{@code this}</i>
	 * element to another.
	 * @param  to_compareTo May not be <code>null</code>
	 * @return <code>(to_compareTo.{@link #getRowIndex()}() - getRowIndex())</code>
	 * @see  #getVertDistance()
	 */
	public int getVertDistance(MatrixElement to_compareTo)  {
		try  {
			return  (to_compareTo.getRowIndex() - getRowIndex());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_compareTo");
		}
	}
	/**
	 * @return  <i>{@code this}</i>
	 */
	public MatrixElement getObjectCopy()  {
		return  this;
	}

}
