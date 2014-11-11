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
	import  com.github.xbn.lang.ObjectOrCrashIfNull;
/**
 * <p>A element that may or may not be occupied.</p>
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class FillableElement extends MatrixElement  {
	private boolean isFilled;
	/**
	 * <p>Create a new instance.</p>
	 *
	 * <p>This calls<ol>
	 *    <li><code>{@link MatrixElement#MatrixElement(int, int) super}(horiz_idx, vert_idx)</code></li>
	 *    <li>{@link #unfill()}{@code ()}</li>
	 * </ol></p>
	 * @@see  #FillableElement(FillableElement)
	 */
	public FillableElement(int horiz_idx, int vert_idx)  {
		super(horiz_idx, vert_idx);
		unfill();
	}
	/**
	 * <p>Create a new instance as a duplicate of another.</p>
	 *
	 * <p>This calls
	 * <br/> &nbsp; &nbsp; <code>super(to_copy.{@link MatrixElement#getHorizIndex() getHorizIndex}(), to_copy.{@link MatrixElement#getVertIndex() getVertIndex}())</code></p>
	 * @param   to_copy  May not be <code>null</code>.
	 * @see #getObjectCopy()
	 * @see #FillableElement()
	 */
	public FillableElement(FillableElement to_copy)  {
		super(ObjectOrCrashIfNull.get(to_copy, "to_copy").getHorizIndex(),
			to_copy.getVertIndex());
	}
	/**
	 * <p>Occupy the element.</p>
	 *
	 * <p>Equal to <code>{@link #fill(boolean) fill}{@code (true)}</code></p>
	 * @return  <i>{@code this}</i>
	 */
	public FillableElement fill()  {
		fill(true);
		return  this;
	}
	/**
	 * <p>Unoccupy the element.</p>
	 *
	 * <p>Equal to <code>{@link #fill(boolean) fill}{@code (true)}</code></p>
	 * @return  <i>{@code this}</i>
	 */
	public FillableElement unfill()  {
		fill(false);
		return  this;
	}
	/**
	 * Declare the element as occupied or not.
	 * @param  is_filled  If {@code true}, the element is filled. Get with {@link #isFilled()}{@code ()}.
	 * @@see  #fill()
	 * @@see  #unfill()
	 */
	public void fill(boolean is_filled)  {
		isFilled = is_filled;
	}
	/**
	 * Is the element occupied?
	 * @return  {@code is_filled} As provided to {@link #fill(boolean) fill}{@code (b)}.
	 */
	public boolean isFilled()  {
		return  isFilled;
	}
	/**
	 * @return  <code>{@link #appendToString(java.lang.StringBuilder)(new {@link java.lang.StringBuilder#StringBuilder() StringBuilder}()).toString()</code>
	 */
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	/**
	 * @param  bldr  May not be <code>null</code>.
	 * @see  #toString()
	 */
	public StringBuilder appendToString(StringBuilder bldr)  {
		super.appendToString(bldr).append(": ");
		if(!isFilled())  {
			bldr.append("un");
		}
		return  bldr.append("filled");
	}
	/**
	 * @return  <CODE>(new {@link #FillableElement(FillableElement) FillableElement}(this))</CODE>
	 */
	public FillableElement getObjectCopy()  {
	  return  (new FillableElement(this));
	}
}
