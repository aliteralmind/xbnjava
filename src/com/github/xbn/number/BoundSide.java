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
package  com.github.xbn.number;
/**
 * <p>Which bound side is it?--min or max?.</p>
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public enum BoundSide {
	/**
	 * <p>The minimum bound side.</p>
	 * @see  #MAX
	 * @see  #isMin()
	 */
	MIN,
	/**
	 * <p>The maximum bound-side.</p>
	 * @see  #MIN
	 * @see  #isMax()
	 */
	MAX;
	/**
	 * <p>Is this {@code BoundSide} equal to {@code MIN}?.</p>
	 * @return  <code>this == {@link #MIN}</code>
	 * @see  #isMax()
	 */
	public final boolean isMin()  {
		return  this == MIN;
	}
	/**
	 * <p>Is this {@code BoundSide} equal to {@code MAX}?.</p>
	 * @return  <code>this == {@link #MAX}</code>
	 * @see  #isMin()
	 */
	public final boolean isMax()  {
		return  this == MAX;
	}
};
