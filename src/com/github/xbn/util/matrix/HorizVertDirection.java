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
	import  com.github.xbn.util.EnumUtil;
/**
 * <p>The direction of movement within a two dimensional array, going horizontal or vertical only.</p>
 *
 * @see MatrixDirection#getShortestHVForDiagonal(MatrixElement)
 * @see MatrixDirection#getLongestHVForDiagonal(MatrixElement)
 * @see BoundedMatrix#getHVNeighborCount(int, int, com.github.xbn.util.matrix.HorizVertDirection) BoundedMatrix#getHVNeighborCount
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public enum HorizVertDirection  {
	/**
	 * <P>Towards the top (zero-th index).</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 * </ul></p>
	 *
	 * @see  #DOWN
	 * @see  #LEFT
	 * @see  #RIGHT
	 * @see  #isVertical()
	 */
	UP(0, -1),
	/**
	 * <P>Towards the bottom (<code>(length - 1)</code> index).</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDown()
	 * @see  #isVertical()
	 */
	DOWN(0, 1),
	/**
	 * <P>Towards the left side (zero-th index).</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 0}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isLeft()
	 * @see  #isHorizontal()
	 */
	LEFT(-1, 0),
	/**
	 * <P>Towards the right side (<code>(length - 1)</code> index).</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 0}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isRight()
	 * @see  #isHorizontal()
	 **/
	RIGHT(1, 0);

	private int horizInc = -1;
	private int vertInc = -1;
	/**
	 * <p>Configure the value.</p>
	 *
	 * @param  horiz_increment  The value to change the horizontal index by, in order to move to the neighbor in the desired direction. Get with {@link #getHorizIncrement()}.
	 * @param  vert_increment  The value to change the vertical index by. Get with {@link #getVertIncrement()}.
	 */
	HorizVertDirection(int horiz_increment, int vert_increment)  {
		horizInc = horiz_increment;
		vertInc = vert_increment;
	}
	/**
	 * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>vert_increment</code>, as provided to the {@link #HorizVertDirection(int, int) constructor}.
	 */
	public int getVertIncrement()  {
		return  vertInc;
	}
	/**
	 * <p>The value to change the horizontal index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>horiz_increment</code>, as provided to the {@link #HorizVertDirection(int, int) constructor}.
	 */
	public int getHorizIncrement()  {
		return  horizInc;
	}
	/**
	 * <P>Is this {@code HorizVertDirection} equal to {@code UP}?.</P>
	 *
	 * @return  <CODE>this == {@link #UP}</CODE>
	 *
	 * @see  #isDown()
	 * @see  #isLeft()
	 * @see  #isRight()
	 * @see  #isUpLeft()
	 * @see  #isUpRight()
	 * @see  #isDownLeft()
	 * @see  #isDownRight()
	 */
	public final boolean isUp()  {
		return  this == UP;
	}
	/**
	 * <P>Is this {@code HorizVertDirection} equal to {@code DOWN}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isDown()  {
		return  this == DOWN;
	}
	/**
	 * <P>Is this {@code HorizVertDirection} equal to {@code LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #LEFT}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isLeft()  {
		return  this == LEFT;
	}
	/**
	 * <P>Is this {@code Right} equal to {@code RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #RIGHT}</CODE>
	 * @see  #isUp()
	 * @see  #isHorizontal()
	 **/
	public final boolean isRight()  {
		return  this == RIGHT;
	}
	/**
	 * Is <i><code>this</code></i> direction left or right?.
	 * @return <code>({@link #isLeft()}{@code ()}&nbsp; || &nbsp;{@link #isRight()}{@code ()}</code>
	 * @see #isVertical()
	 * @see #isDiagonal()
	 */
	public final boolean isHorizontal()  {
		return  (isLeft()  ||  isRight());
	}
	/**
	 * Is <i><code>this</code></i> direction up or down?.
	 * @return <code>({@link #isUp()}{@code ()}&nbsp; || &nbsp;{@link #isDown()}{@code ()}</code>
	 * @see #isHorizontal()
	 */
	public final boolean isVertical()  {
		return  (isUp()  ||  isDown());
	}
	/**
	 * Get the opposite direction.
	 * @return If {@link #UP}, then {@link #DOWN} is returned (and vice-versa). If {@link #LEFT}, then {@link #RIGHT} is returned.
	 * @see getPerpendicularTowardsZero()
	 */
	public final HorizVertDirection getOpposite()  {
		switch(this)  {
			case UP:  return  DOWN;
			case DOWN: return  UP;
			case LEFT: return  RIGHT;
			case RIGHT: return  LEFT;
			default:  throw  new IllegalStateException("Unknown HorizVertDirection value: " + this);
		}
	}
	/**
	 * <p>Get the direction perpendicular to this one, towards the zero-th element.</p>
	 *
	 * <p>To get the perpendicular direction towards length, use
	 	 * <br/><blockquote><code>hvd.getPerpendicularTowardsZero().{@link #getOpposite()}()</code></blockquote></p>
	 * @return If either {@link #UP} or {@link #DOWN}, this returns {@link #LEFT}. If {@code LEFT} or {@link #RIGHT}, this returns {@code UP}.
	 * @see  #getOpposite()
	 */
	public final HorizVertDirection getPerpendicularTowardsZero()  {
		switch(this)  {
			case UP:  return  LEFT;
			case DOWN: return  LEFT;
			case LEFT: return  UP;
			case RIGHT: return  UP;
			default:  throw  new IllegalStateException("Unknown HorizVertDirection value: " + this);
		}
	}
	/**
	 * <P>If an <CODE>HorizVertDirection</CODE> is not a required value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfForbiddenValue(HorizVertDirection, String, Object) crashIfForbiddenValue(ert,s,o)
	 */
	public void crashIfNotRequiredValue(HorizVertDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
	 * <P>If an <CODE>HorizVertDirection</CODE> is a forbidden value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfNotRequiredValue(HorizVertDirection, String, Object) crashIfNotRequiredValue(ert,s,o)
	 */
	public void crashIfForbiddenValue(HorizVertDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
