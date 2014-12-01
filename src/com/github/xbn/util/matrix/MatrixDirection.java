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
 * <p>The direction of movement within a two dimensional array, in one of the eight-main directions: up, down, left, right, up-left, up-right, down-left, down-right.</p>
 *
 * @see VertHorizDirection
 * @see BoundedMatrix#getNeighbor(int, int, com.github.xbn.util.matrix.MatrixDirection, int, com.github.xbn.util.matrix.EdgeExceeded) BoundedMatrix#getNeighbor
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public enum MatrixDirection  {
   /**
    * <p>Up.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code 0}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#UP UP}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@code null}</li>
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
   UP(-1, 0, VertHorizDirection.UP, null),
   /**
    * <p>Down.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code 0}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#DOWN DOWN}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@code null}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isDown()
    * @see  #isVertical()
    */
   DOWN(1, 0, VertHorizDirection.DOWN, null),
   /**
    * <p>Left.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code 0}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@code null}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#LEFT LEFT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isLeft()
    * @see  #isHorizontal()
    */
   LEFT(0, -1, null, VertHorizDirection.LEFT),
   /**
    * <p>Right.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code 0}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@code null}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#RIGHT RIGHT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isRight()
    * @see  #isHorizontal()
    */
   RIGHT(0, 1, null, VertHorizDirection.RIGHT),
   /**
    * <p>Diagonal, up and to the left.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#UP UP}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#LEFT LEFT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isUpLeft()
    * @see  #isDiagonal()
    */
   UP_LEFT(-1, -1, VertHorizDirection.UP, VertHorizDirection.LEFT),
   /**
    * <p>Diagonal, up and to the right.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#UP UP}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#RIGHT RIGHT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isUpRight()
    * @see  #isDiagonal()
    */
   UP_RIGHT(-1, 1, VertHorizDirection.UP, VertHorizDirection.RIGHT),
   /**
    * <p>Diagonal, down and to the left.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code -1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#DOWN DOWN}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#LEFT LEFT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isDownLeft()
    * @see  #isDiagonal()
    */
   DOWN_LEFT(1, -1, VertHorizDirection.DOWN, VertHorizDirection.LEFT),
   /**
    * <p>Diagonal, down and to the right.</p>
    *
    * <p>Sets <ul>
    *    <li>{@link #getVertIncrement() getVertIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getHorizIncrement() getHorizIncrement}{@code ()} to {@code 1}</li>
    *    <li>{@link #getVertPortion() getVertPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#DOWN DOWN}</li>
    *    <li>{@link #getHorizPortion() getHorizPortion}{@code ()} to {@link VertHorizDirection}.{@link VertHorizDirection#RIGHT RIGHT}</li>
    * </ul></p>
    *
    * @see  #UP
    * @see  #isDownRight()
    * @see  #isDiagonal()
    */
   DOWN_RIGHT(1, 1, VertHorizDirection.DOWN, VertHorizDirection.RIGHT);

      private final int vertInc;
      private final int horizInc;
      private final VertHorizDirection vertPortion;
      private final VertHorizDirection horizPortion;

   /**
    * <p>Configure the value.</p>
    *
    * @param  horiz_increment  The value to change the horizontal index by, in order to move to the neighbor in the desired direction. Get with {@link #getHorizIncrement()}.
    * @param  vert_increment  The value to change the vertical index by. Get with {@link #getVertIncrement()}.
    */
   MatrixDirection(int vert_increment, int horiz_increment,
            VertHorizDirection vert_portion, VertHorizDirection horiz_portion)  {
      vertInc = vert_increment;
      horizInc = horiz_increment;
      vertPortion = vert_portion;
      horizPortion = horiz_portion;
   }
   /**
    * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
    *
    * @return  As documented by each value.
    * @see  #UP
    */
   public int getVertIncrement()  {
      return  vertInc;
   }
   /**
    * <p>The value to change the horizontal index by, in order to move to the neighbor in the desired direction.</p>
    *
    * @return  As documented by each value.
    * @see  #UP
    */
   public int getHorizIncrement()  {
      return  horizInc;
   }
   /**
    * <p>The value to change the vertical index by, in order to move to the neighbor in the desired direction.</p>
    *
    * @return  As documented by each value.
    * @see  #UP
    */
   public VertHorizDirection getVertPortion()  {
      return  vertPortion;
   }
   /**
    * <p>The horizontal &quot;part&quot; of the current direction.</p>
    *
    * @return  As documented by {@linkplain #UP each value}. Examples: <ul>
    *    <li>{@link #UP} returns <code>null</code></li>
    *    <li>{@link #LEFT} returns {@link VertHorizDirection}.{@link VertHorizDirection#LEFT LEFT}</li>
    *    <li>{@link #DOWN_RIGHT} returns {@link VertHorizDirection}.{@link VertHorizDirection#RIGHT RIGHT}</li>
    * </ul>
    */
   public VertHorizDirection getHorizPortion()  {
      return  horizPortion;
   }
   /**
    * <p>Is this direction {@code UP}?.</p>
    *
    * @return  <code>this == {@link #UP}</code>
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
    * <p>Is this direction {@code DOWN}?.</p>
    *
    * @return  <code>this == {@link #DOWN}</code>
    * @see  #isUp()
    */
   public final boolean isDown()  {
      return  this == DOWN;
   }
   /**
    * <p>Is this direction {@code RIGHT}?.</p>
    *
    * @return  <code>this == {@link #RIGHT}</code>
    * @see  #isUp()
    * @see  #isHorizontal()
    */
   public final boolean isRight()  {
      return  this == RIGHT;
   }
   /**
    * <p>Is this direction {@code LEFT}?.</p>
    *
    * @return  <code>this == {@link #LEFT}</code>
    * @see  #isUp()
    */
   public final boolean isLeft()  {
      return  this == LEFT;
   }
   /**
    * <p>Is this direction {@code DOWN_RIGHT}?.</p>
    *
    * @return  <code>this == {@link #DOWN_RIGHT}</code>
    * @see  #isUp()
    */
   public final boolean isDownRight()  {
      return  this == DOWN_RIGHT;
   }
   /**
    * <p>Is this direction {@code DOWN_LEFT}?.</p>
    *
    * @return  <code>this == {@link #DOWN_LEFT}</code>
    * @see  #isUp()
    */
   public final boolean isDownLeft()  {
      return  this == DOWN_LEFT;
   }
   /**
    * <p>Is this direction {@code UP_RIGHT}?.</p>
    *
    * @return  <code>this == {@link #UP_RIGHT}</code>
    * @see  #isUp()
    */
   public final boolean isUpRight()  {
      return  this == UP_RIGHT;
   }
   /**
    * <p>Is this direction {@code UP_LEFT}?.</p>
    *
    * @return  <code>this == {@link #UP_LEFT}</code>
    * @see  #isUp()
    */
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
    * </ul>
    * @see VertHorizDirection#getPerpendicularTowardsZero()
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
    * <p>Is this direction {@code UP}? or a diagonal containing up?.</p>
    *
    * @return  <code>({@link #getVertPortion() getVertPortion}{@code ()} == {@link VertHorizDirection}.{@link VertHorizDirection#UP UP})</code>
    *
    * @see  #hasDown()
    * @see  #hasLeft()
    * @see  #hasRight()
    */
   public final boolean hasUp()  {
      return  (getVertPortion() == VertHorizDirection.UP);
   }
   /**
    * <p>Is this direction {@code DOWN}, or a diagonal containing down?.</p>
    *
    * @return  <code>({@link #getVertPortion() getVertPortion}{@code ()} == {@link VertHorizDirection}.{@link VertHorizDirection#DOWN DOWN})</code>
    * @see  #hasUp()
    */
   public final boolean hasDown()  {
      return  (getVertPortion() == VertHorizDirection.DOWN);
   }
   /**
    * <p>Is this direction {@code RIGHT}, or a diagonal containing right?.</p>
    *
    * @return  <code>({@link #getHorizPortion() getHorizPortion}{@code ()} == {@link VertHorizDirection}.{@link VertHorizDirection#RIGHT RIGHT})</code>
    * @see  #hasUp()
    * @see  #isHorizontal()
    * @see  #hasHorizontal()
    */
   public final boolean hasRight()  {
      return  (getHorizPortion() == VertHorizDirection.RIGHT);
   }
   /**
    * <p>Is this direction {@code LEFT}, or a diagonal containing left?.</p>
    *
    * @return  <code>({@link #getHorizPortion() getHorizPortion}{@code ()} == {@link VertHorizDirection}.{@link VertHorizDirection#LEFT LEFT})</code>
    * @see  #hasUp()
    */
   public final boolean hasLeft()  {
      return  (getHorizPortion() == VertHorizDirection.LEFT);
   }
   /**
    * Is this diagonal <i>or</i> vertical?.
    * @return <code>({@link #hasUp}()  ||  {@link #hasDown}())</code>
    * @see  #hasVertical()
    */
   public final boolean hasVertical()  {
      return  (hasUp()  ||  hasDown());
   }
   /**
    * Is this diagonal <i>or</i> horizontal?.
    * @return <code>({@link #hasRight}()  ||  {@link #hasLeft}())</code>
    * @see  #hasVertical()
    */
   public final boolean hasHorizontal()  {
      return  (hasRight()  ||  hasLeft());
   }
   /**
    * Is <i><code>this</code></i> direction up or down?.
    * @return <code>({@link #isUp() isUp}{@code ()}&nbsp; || &nbsp;{@link #isDown() isDown}{@code ()}</code>
    * @see #isHorizontal()
    */
   public final boolean isVertical()  {
      return  (isUp()  ||  isDown());
   }
   /**
    * Is <i><code>this</code></i> direction left or right?.
    * @return <code>({@link #isLeft() isLeft}{@code ()}&nbsp; || &nbsp;{@link #isRight() isRight}{@code ()}</code>
    * @see #isVertical()
    * @see #isVertOrHoriz()
    * @see #isDiagonal()
    */
   public final boolean isHorizontal()  {
      return  (isLeft()  ||  isRight());
   }
   /**
    * Is <i><code>this</code></i> direction up, down, left, or right?.
    * @return <code>({@link #isVertical() isVertical}{@code ()}&nbsp; || &nbsp;{@link #isHorizontal() isHorizontal}{@code ()}</code>
    */
   public final boolean isVertOrHoriz()  {
      return  (isVertical()  ||  isHorizontal());
   }
   /**
    * Is <i><code>this</code></i> <i>not</i> vertical or horizontal?.
    * @return <code>!({@link #isVertical() isVertical}{@code ()}  ||  {@link #isHorizontal() isHorizontal}{@code ()}</code>
    */
   public final boolean isDiagonal()  {
      return  !(isVertical()  ||  isHorizontal());
   }
   /**
    * <p>If an <code>MatrixDirection</code> is not a required value, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
    * @see  #crashIfForbiddenValue(MatrixDirection, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(MatrixDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
         EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
   /**
    * <p>If an <code>MatrixDirection</code> is a forbidden value, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
    * @see  #crashIfNotRequiredValue(MatrixDirection, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(MatrixDirection e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
         EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
};
