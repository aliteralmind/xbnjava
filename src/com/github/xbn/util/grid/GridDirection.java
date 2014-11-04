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
	import  com.github.xbn.util.EnumUtil;
/**
 * <p>The direction of movement within a two dimensional array.</p>
 *
 * @see BoundedGrid#getNeighbor(int, int, com.github.xbn.util.grid.GridDirection, int, com.github.xbn.util.grid.EdgeExceeded) BoundedGrid#getNeighbor
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public enum GridDirection  {
	/**
	 * <P>Up.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 * </ul></p>
	 *
	 * @see  #DOWN
	 * @see  #LEFT
	 * @see  #RIGHT
	 * @see  #UP_LEFT
	 * @see  #UP_RIGHT
	 * @see  #DOWN_LEFT
	 * @see  #DOWN_RIGHT
	 * @see  #isVertical()
	 */
	UP(0, -1),
	/**
	 * <P>Down.</P>
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
	 * <P>Left.</P>
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
	 * <P>Right.</P>
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
	RIGHT(1, 0),
	/**
	 * <P>Diagonal up and to the left.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isUpLeft()
	 * @see  #isDiagonal()
	 **/
	UP_LEFT(-1, -1),
	/**
	 * <P>Diagonal up and to the right.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isUpRight()
	 * @see  #isDiagonal()
	 **/
	UP_RIGHT(1, -1),
	/**
	 * <P>Diagonal down and to the left.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDownLeft()
	 * @see  #isDiagonal()
	 **/
	DOWN_LEFT(-1, 1),
	/**
	 * <P>Diagonal down and to the right.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDownRight()
	 * @see  #isDiagonal()
	 **/
	DOWN_RIGHT(1, 1);

	private int horizInc = -1;
	private int vertInc = -1;
	/**
	 * <p>Configure the value.</p>
	 *
	 * @param  horiz_increment  The value to change the horizontal index by, in order to move to the neighbor in the desired direction. Get with {@link #getHorizIncrement()}.
	 * @param  vert_increment  The value to change the vertical index by. Get with {@link #getVertIncrement()}.
	 */
	GridDirection(int horiz_increment, int vert_increment)  {
		horizInc = horiz_increment;
		vertInc = vert_increment;
	}
	/**
	 * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>vert_increment</code>, as provided to the {@link #GridDirection(int, int) constructor}.
	 */
	public int getVertIncrement()  {
		return  vertInc;
	}
	/**
	 * <p>The value to change the horizontal index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>horiz_increment</code>, as provided to the {@link #GridDirection(int, int) constructor}.
	 */
	public int getHorizIncrement()  {
		return  horizInc;
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
	 * <P>Is this {@code GridDirection} equal to {@code UP}?.</P>
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
	 * <P>Is this {@code GridDirection} equal to {@code DOWN}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isDown()  {
		return  this == DOWN;
	}
	/**
	 * <P>Is this {@code DownRight} equal to {@code DOWN_RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN_RIGHT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isDownRight()  {
		return  this == DOWN_RIGHT;
	}
	/**
	 * <P>Is this {@code DownLeft} equal to {@code DOWN_LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN_LEFT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isDownLeft()  {
		return  this == DOWN_LEFT;
	}
	/**
	 * <P>Is this {@code UpRight} equal to {@code UP_RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #UP_RIGHT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isUpRight()  {
		return  this == UP_RIGHT;
	}
	/**
	 * <P>Is this {@code UpLeft} equal to {@code UP_LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #UP_LEFT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isUpLeft()  {
		return  this == UP_LEFT;
	}
	/**
	 * <P>Is this {@code GridDirection} equal to {@code LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #LEFT}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isLeft()  {
		return  this == LEFT;
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
	 * Is <i><code>this</code></i> <i>not</i> vertical or horizontal?.
	 * @return <code>!({@link #isHorizontal()}{@code ()}  ||  {@link #isVertical()}{@code ()}</code>
	 * @see #isHorizontal()
	 */
	public final boolean isDiagonal()  {
		return  !(isHorizontal()  ||  isVertical());
	}
	/**
	 * If <i><code>this</code></i> direction happens to be diagonal (for example,
	 * {@link #UP_LEFT}), then get its vertical or horizontal direction
	 * (either {@link #UP} or {@link #LEFT}) that represents the <i>shortest</i>
	 * distance from a coordinate to an edge.
	 *
	 * @param  coord May not be <code>null</code>.
	 * @return If <code>coord</code> is already
	 * {@linkplain #isHorizontal() horizontal} or
	 * {@linkplain #isVertical() vertical}, it is returned unchanged.
	 * Otherwise, if
	 * <br/> &nbsp; &nbsp; <code>(coord.{@link GridCoordinate#getHorizIndex() getHorizIndex}() &lt; coord.{@link GridCoordinate#getVertIndex() getVertIndex}())</code>
	 * <br/>is <code>true</code>, then this returns the vertical &quot;portion&quot; of
	 * the diagonal direction (if <i><code>this</code></i> is <code>UP_LEFT</code>, then <code>UP</code> is returned). If <code>false</code>, the horizontal portion is returned (for <code>UP_LEFT</code>: <code>LEFT</code>).
	 * @see #isDiagonal()
	 * @see BoundedGrid#getNeighborCount(int, int, com.github.xbn.util.grid.GridDirection) BoundedGrid#getNeighborCount
	 */
	public GridDirection getHorizVertIfDiagonal(GridCoordinate coord)  {
		boolean isHorizLessThanVert = false;
		try  {
			isHorizLessThanVert = (coord.getHorizIndex() < coord.getVertIndex());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("coord");
		}
		switch(this)  {
			case UP_LEFT:     return  (isHorizLessThanVert ? UP : LEFT);
			case UP_RIGHT:    return  (isHorizLessThanVert ? UP : RIGHT);
			case DOWN_LEFT:   return  (isHorizLessThanVert ? DOWN : LEFT);
			case DOWN_RIGHT:  return  (isHorizLessThanVert ? DOWN : RIGHT);
			default:          return  this;
		}
	}
	/**
	 * <P>If an <CODE>GridDirection</CODE> is not a required value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfForbiddenValue(GridDirection, String, Object) crashIfForbiddenValue(ert,s,o)
	 */
	public void crashIfNotRequiredValue(GridDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
	 * <P>If an <CODE>GridDirection</CODE> is a forbidden value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfNotRequiredValue(GridDirection, String, Object) crashIfNotRequiredValue(ert,s,o)
	 */
	public void crashIfForbiddenValue(GridDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
