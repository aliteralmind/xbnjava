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
 * <p>The direction of movement within a two dimensional array, horizontal, vertical, or diagonal.</p>
 *
 * @see HorizVertDirection
 * @see BoundedMatrix#getNeighbor(int, int, com.github.xbn.util.matrix.MatrixDirection, int, com.github.xbn.util.matrix.EdgeExceeded) BoundedMatrix#getNeighbor
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public enum MatrixDirection  {
	/**
	 * <P>Up.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@code null}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#UP UP}</li>
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
	UP(0, -1, null, HorizVertDirection.UP),
	/**
	 * <P>Down.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@code null}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#DOWN DOWN}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDown()
	 * @see  #isVertical()
	 */
	DOWN(0, 1, null, HorizVertDirection.DOWN),
	/**
	 * <P>Left.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#LEFT LEFT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@code null}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isLeft()
	 * @see  #isHorizontal()
	 */
	LEFT(-1, 0, HorizVertDirection.LEFT, null),
	/**
	 * <P>Right.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 0}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#RIGHT RIGHT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@code null}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isRight()
	 * @see  #isHorizontal()
	 **/
	RIGHT(1, 0, HorizVertDirection.RIGHT, null),
	/**
	 * <P>Diagonal up and to the left.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#LEFT LEFT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#UP UP}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isUpLeft()
	 * @see  #isDiagonal()
	 **/
	UP_LEFT(-1, -1, HorizVertDirection.LEFT, HorizVertDirection.UP),
	/**
	 * <P>Diagonal up and to the right.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#RIGHT RIGHT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#UP UP}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isUpRight()
	 * @see  #isDiagonal()
	 **/
	UP_RIGHT(1, -1, HorizVertDirection.RIGHT, HorizVertDirection.UP),
	/**
	 * <P>Diagonal down and to the left.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code -1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#LEFT LEFT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#DOWN DOWN}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDownLeft()
	 * @see  #isDiagonal()
	 **/
	DOWN_LEFT(-1, 1, HorizVertDirection.LEFT, HorizVertDirection.DOWN),
	/**
	 * <P>Diagonal down and to the right.</P>
	 *
	 * <p>Sets <ul>
	 *    <li>{@link #getHorizIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getVertIncrement()}{@code ()} to {@code 1}</li>
	 *    <li>{@link #getHorizPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#RIGHT RIGHT}</li>
	 *    <li>{@link #getVertPortion()}{@code ()} to {@link HorizVertDirection}.{@link HorizVertDirection#DOWN DOWN}</li>
	 * </ul></p>
	 *
	 * @see  #UP
	 * @see  #isDownRight()
	 * @see  #isDiagonal()
	 **/
	DOWN_RIGHT(1, 1, HorizVertDirection.RIGHT, HorizVertDirection.DOWN);

	private final int horizInc;
	private final int vertInc;
	private final HorizVertDirection horizPortion;
	private final HorizVertDirection vertPortion;
	/**
	 * <p>Configure the value.</p>
	 *
	 * @param  horiz_increment  The value to change the horizontal index by, in order to move to the neighbor in the desired direction. Get with {@link #getHorizIncrement()}.
	 * @param  vert_increment  The value to change the vertical index by. Get with {@link #getVertIncrement()}.
	 */
	MatrixDirection(int horiz_increment, int vert_increment,
				HorizVertDirection horiz_portion, HorizVertDirection vert_portion)  {
		horizInc = horiz_increment;
		vertInc = vert_increment;
		horizPortion = horiz_portion;
		vertPortion = vert_portion;
	}
	/**
	 * <p>The value to change the horizontal index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>horiz_increment</code>, as provided to the {@link #MatrixDirection(int, int) constructor}.
	 */
	public int getHorizIncrement()  {
		return  horizInc;
	}
	/**
	 * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  <code>vert_increment</code>, as provided to the {@link #MatrixDirection(int, int) constructor}.
	 */
	public int getVertIncrement()  {
		return  vertInc;
	}
	/**
	 * <p>The horizontal &quot;part&quot; of the current direction.</p>
	 *
	 * @return  As documented by {@linkplain #UP each value}. Examples: <ul>
	 *    <li>{@link #UP} returns <code>null</code></li>
	 *    <li>{@link #LEFT} returns {@link HorizVertDirection}.{@link HorizVertDirection#LEFT LEFT}</li>
	 *    <li>{@link #DOWN_RIGHT} returns {@link HorizVertDirection}.{@link HorizVertDirection#RIGHT RIGHT}</li>
	 * </ul>
	 */
	public HorizVertDirection getHorizPortion()  {
		return  horizPortion;
	}
	/**
	 * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
	 *
	 * @return  As documented by {@linkplain #UP each value}. Examples: <ul>
	 *    <li>{@link #UP} returns {@link HorizVertDirection}.{@link HorizVertDirection#UP UP}</li>
	 *    <li>{@link #LEFT} returns <code>null</code></li>
	 *    <li>{@link #DOWN_RIGHT} returns {@link HorizVertDirection}.{@link HorizVertDirection#DOWN DOWN}</li>
	 * </ul>
	 */
	public HorizVertDirection getVertPortion()  {
		return  vertPortion;
	}
	/**
	 * <P>Is this direction {@code UP}?.</P>
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
	 * <P>Is this direction {@code DOWN}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isDown()  {
		return  this == DOWN;
	}
	/**
	 * <P>Is this direction {@code RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #RIGHT}</CODE>
	 * @see  #isUp()
	 * @see  #isHorizontal()
	 **/
	public final boolean isRight()  {
		return  this == RIGHT;
	}
	/**
	 * <P>Is this direction {@code LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #LEFT}</CODE>
	 * @see  #isUp()
	 */
	public final boolean isLeft()  {
		return  this == LEFT;
	}
	/**
	 * <P>Is this direction {@code DOWN_RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN_RIGHT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isDownRight()  {
		return  this == DOWN_RIGHT;
	}
	/**
	 * <P>Is this direction {@code DOWN_LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #DOWN_LEFT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isDownLeft()  {
		return  this == DOWN_LEFT;
	}
	/**
	 * <P>Is this direction {@code UP_RIGHT}?.</P>
	 *
	 * @return  <CODE>this == {@link #UP_RIGHT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isUpRight()  {
		return  this == UP_RIGHT;
	}
	/**
	 * <P>Is this direction {@code UP_LEFT}?.</P>
	 *
	 * @return  <CODE>this == {@link #UP_LEFT}</CODE>
	 * @see  #isUp()
	 **/
	public final boolean isUpLeft()  {
		return  this == UP_LEFT;
	}
	/**
	 * Get the opposite direction.
	 * @return <ul>
	 *    <li>{@link #UP} is the opposite of {@link #DOWN}</li>
	 *    <li>{@link #LEFT} is the opposite of {@link #RIGHT}</li>
	 *    <li>{@link #UP_LEFT} is the opposite of {@link #DOWN_RIGHT}</li>
	 *    <li>{@link #DOWN_LEFT} is the opposite of {@link #UP_RIGHT}</li>
	 *    <li>{@link #UP_RIGHT} is the opposite of {@link #DOWN_LEFT}</li>
	 *    <li>{@link #DOWN_RIGHT} is the opposite of {@link #UP_LEFT}</li>
	 * </ul>
	 * @see getPerpendicularTowardsZero()
	 */
	public final MatrixDirection getOpposite()  {
		switch(this)  {
			case UP:          return  DOWN;
			case DOWN:        return  UP;
			case LEFT:        return  RIGHT;
			case RIGHT:       return  LEFT;
			case UP_LEFT:     return  DOWN_RIGHT;
			case UP_RIGHT:    return  DOWN_LEFT;
			case DOWN_LEFT:   return  UP_RIGHT;
			case DOWN_RIGHT:  return  UP_LEFT;
			default:  throw  new IllegalStateException("Unknown MatrixDirection value: " + this);
		}
	}
	/**
	 * <P>Is this direction {@code UP}? or a diagonal containing up?.</P>
	 *
	 * @return  <CODE>({@link #getVertPortion()}{@code ()} == {@link HorizVertDirection}.{@link HorizVertDirection#UP UP})</CODE>
	 *
	 * @see  #hasDown()
	 * @see  #hasLeft()
	 * @see  #hasRight()
	 */
	public final boolean hasUp()  {
		return  (getVertPortion() == HorizVertDirection.UP);
	}
	/**
	 * <P>Is this direction {@code DOWN}, or a diagonal containing down?.</P>
	 *
	 * @return  <CODE>({@link #getVertPortion()}{@code ()} == {@link HorizVertDirection}.{@link HorizVertDirection#DOWN DOWN})</CODE>
	 * @see  #hasUp()
	 */
	public final boolean hasDown()  {
		return  (getVertPortion() == HorizVertDirection.DOWN);
	}
	/**
	 * <P>Is this direction {@code RIGHT}, or a diagonal containing right?.</P>
	 *
	 * @return  <CODE>({@link #getHorizPortion()}{@code ()} == {@link HorizVertDirection}.{@link HorizVertDirection#RIGHT RIGHT})</CODE>
	 * @see  #hasUp()
	 * @see  #isHorizontal()
	 * @see  #hasHorizontal()
	 **/
	public final boolean hasRight()  {
		return  (getHorizPortion() == HorizVertDirection.RIGHT);
	}
	/**
	 * <P>Is this direction {@code LEFT}, or a diagonal containing left?.</P>
	 *
	 * @return  <CODE>({@link #getHorizPortion()}{@code ()} == {@link HorizVertDirection}.{@link HorizVertDirection#LEFT LEFT})</CODE>
	 * @see  #hasUp()
	 */
	public final boolean hasLeft()  {
		return  (getHorizPortion() == HorizVertDirection.LEFT);
	}
	/**
	 * Is this diagonal <i>or</i> horizontal?.
	 * @return <code>({@link #hasRight}()  ||  {@link #hasLeft}())</code>
	 * @@see  #hasVertical()
	 */
	public final boolean hasHorizontal()  {
		return  (hasRight()  ||  hasLeft());
	}
	/**
	 * Is this diagonal <i>or</i> vertical?.
	 * @return <code>({@link #hasUp}()  ||  {@link #hasDown}())</code>
	 * @@see  #hasVertical()
	 */
	public final boolean hasVertical()  {
		return  (hasUp()  ||  hasDown());
	}
	/**
	 * Is <i><code>this</code></i> direction left or right?.
	 * @return <code>({@link #isLeft()}{@code ()}&nbsp; || &nbsp;{@link #isRight()}{@code ()}</code>
	 * @see #isVertical()
	 * @see #isHorizOrVert()
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
	 * Is <i><code>this</code></i> direction up, down, left, or right?.
	 * @return <code>({@link #isHorizontal()}{@code ()}&nbsp; || &nbsp;{@link #isVertical()}{@code ()}</code>
	 * @see #isHorizontal()
	 */
	public final boolean isHorizOrVert()  {
		return  (isHorizontal()  ||  isVertical());
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
	 * If <i><code>this</code></i> direction happens to be diagonal (for
	 * example, {@link #UP_LEFT}), then get its vertical or horizontal
	 * direction (for example, either {@link #UP} or {@link #LEFT}) that
	 * represents the <i>shortest</i> distance from a element to an edge.
	 *
	 * @param  coord May not be <code>null</code>.
	 * @return If <code>coord</code> is already
	 * {@linkplain #isHorizontal() horizontal} or
	 * {@linkplain #isVertical() vertical}, its {@code HorizVertDirection}
	 * equivalent is returned (if <i>{@code this}</i> is
	 * {@code MatrixDirection.UP}, then
	 * <code>HorizVertDirection.{@link HorizVertDirection#UP UP}</code> is
	 * returned).
	 * <br/> &nbsp; &nbsp; <code>(coord.{@link MatrixElement#getHorizIndex() getHorizIndex}() &lt; coord.{@link MatrixElement#getVertIndex() getVertIndex}())</code>
	 * <br/>is <code>true</code>, then this returns the vertical &quot;portion&quot; of
	 * the diagonal direction (if <i><code>this</code></i> is <code>UP_LEFT</code>, then <code>UP</code> is returned). If <code>false</code>, the horizontal portion is returned (for <code>UP_LEFT</code>: <code>LEFT</code>).
	 * @see #isDiagonal()
	 * @see BoundedMatrix#getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection) BoundedMatrix#getNeighborCount
	 */
	public HorizVertDirection getShortestHVForDiagonal(MatrixElement coord)  {
		return  getHVPortion(ShortLong.SHORTEST, coord);
	}
	/**
	 * If <i><code>this</code></i> direction happens to be diagonal (for
	 * example, {@link #UP_LEFT}), then get its vertical or horizontal
	 * direction (for example, either {@link #UP} or {@link #LEFT}) that
	 * represents the <i>longest</i> distance from a element to an edge.
	 *
	 * @param  coord May not be <code>null</code>.
	 * @return If <code>coord</code> is already
	 * {@linkplain #isHorizontal() horizontal} or
	 * {@linkplain #isVertical() vertical}, its {@code HorizVertDirection}
	 * equivalent is returned (if <i>{@code this}</i> is
	 * {@code MatrixDirection.UP}, then
	 * <code>HorizVertDirection.{@link HorizVertDirection#UP UP}</code> is
	 * returned). Otherwise, if
	 * <br/> &nbsp; &nbsp; <code>(coord.{@link MatrixElement#getHorizIndex() getHorizIndex}() &gt; coord.{@link MatrixElement#getVertIndex() getVertIndex}())</code>
	 * <br/>is <code>true</code>, then this returns the vertical &quot;portion&quot; of
	 * the diagonal direction (if <i><code>this</code></i> is <code>UP_LEFT</code>, then <code>UP</code> is returned). If <code>false</code>, the horizontal portion is returned (for <code>UP_LEFT</code>: <code>LEFT</code>).
	 * @see #getShortestHVForDiagonal()
	 * @see #isDiagonal()
	 * @see BoundedMatrix#getNeighborCount(int, int, com.github.xbn.util.matrix.MatrixDirection) BoundedMatrix#getNeighborCount
	 */
	public HorizVertDirection getLongestHVForDiagonal(MatrixElement coord)  {
		return  getHVPortion(ShortLong.LONGEST, coord);
	}
		private enum ShortLong {SHORTEST, LONGEST};
		private HorizVertDirection getHVPortion(ShortLong short_long, MatrixElement coord)  {
			if(isHorizontal())  {
				return  getHorizPortion();
			}  else if(isVertical())  {
				return  getVertPortion();
			}

			//Diagonal

			boolean comparisonPasses = false;
			try  {
				comparisonPasses = ((short_long == ShortLong.SHORTEST)
					?  (coord.getHorizIndex() < coord.getVertIndex())
					:  (coord.getHorizIndex() > coord.getVertIndex()));
			}  catch(NullPointerException npx)  {
				throw  new NullPointerException("coord");
			}
			return  (comparisonPasses ? getVertPortion() : getHorizPortion());
		}
	/**
	 * <P>If an <CODE>MatrixDirection</CODE> is not a required value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfForbiddenValue(MatrixDirection, String, Object) crashIfForbiddenValue(ert,s,o)
	 */
	public void crashIfNotRequiredValue(MatrixDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
	 * <P>If an <CODE>MatrixDirection</CODE> is a forbidden value, crash.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
	 * @see  #crashIfNotRequiredValue(MatrixDirection, String, Object) crashIfNotRequiredValue(ert,s,o)
	 */
	public void crashIfForbiddenValue(MatrixDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
			EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
