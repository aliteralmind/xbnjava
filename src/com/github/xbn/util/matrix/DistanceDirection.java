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
/**
 * <p>The distance and direction between two elements.</p>
 *
 * {@.codelet.and.out com.github.xbn.examples.util.matrix.DistanceDirectionXmpl%eliminateCommentBlocksAndPackageDecl()}
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class DistanceDirection extends AbstractElement  {
   private final MatrixDirection dir;
   /**
    * <p>Create a new item from its elements.</p>
    * @param  horiz_dist  The number of columns the end is away from
    * the start element. For example, if the start and end elements
    * are {@code [1, 1]} and {@code [2, 1]}, respectively, then
    * {@code horiz_dist} is one. Get with {@link #getHorizDistance() getHorizDistance}{@code ()}.
    * @param  vert_dist  The number of rows the end is away from
    * the start element. For example, if the start and end elements
    * are {@code [1, 1]} and {@code [2, 1]}, respectively, then
    * {@code horiz_dist} is zero. If zero, both items are in the same row.
    * Get with {@link #getVertDistance() getVertDistance}{@code ()}.
    */
   public DistanceDirection(int horiz_dist, int vert_dist)  {
      super(horiz_dist, vert_dist);
      dir = getDirectionFromDistances(horiz_dist, vert_dist);
   }
   /**
    * The direction between the two elements, if it happens to be a
    * directly horizontal, vertical, or diagonal.
    * @return  The direction between the two elements. If {@code null},
    * then either both elements are the same, or the direction is not
    * directly left, right, up, down, up-left, up-right, down-left, or
    * down-right.
    */
   public MatrixDirection getDirection()  {
      return  dir;
   }
   /**
    * The number of horizontal spaces the second element is from the first.
    * @return  {@link AbstractElement#getColumnIndex() getColumnIndex}{@code ()} (Equivalent to {@code horiz_dist}, as provided to the {@linkplain #DistanceDirection(int, int) constructor})
    */
   public int getHorizDistance()  {
      return  getColumnIndex();
   }
   /**
    * The number of vertical spaces the second element is from the first.
    * @return  {@link AbstractElement#getRowIndex() getRowIndex}{@code ()} (Equivalent to {@code vert_dist}, as provided to the {@linkplain #DistanceDirection(int, int) constructor})
    */
   public int getVertDistance()  {
      return  getRowIndex();
   }
   /**
    * @return  <code>{@link #appendToString(java.lang.StringBuilder) appendToString}(new {@link java.lang.StringBuilder#StringBuilder() StringBuilder}()).toString()</code>
    */
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   /**
    * @param  bldr  May not be <code>null</code>.
    * @see  #toString()
    */
   public StringBuilder appendToString(StringBuilder bldr)  {
      try  {
         bldr.append("[horiz=").append(getHorizDistance()).append(",vert=").append(getVertDistance()).append("]").append("direction=").
            append((getDirection() != null) ? getDirection()
               :  "SELF-OR-UNKNOWN");
      }  catch(NullPointerException npx)  {
         CrashIfObject.nullOrReturnCause(bldr, "bldr", null, npx);
      }
      return  bldr;
   }
   public static final DistanceDirection newForStartEnd(MatrixElement start,
            MatrixElement end)  {
      return  new DistanceDirection(start.getHorizDistance(end),
                                    start.getVertDistance(end));
   }
   /**
    *
    * @param   start  May not be <code>null</code>
    * @param   end  May not be <code>null</code>
    * @return  <blockquote><pre>{@link #getDirectionFromDistances(int, int) getDirectionFromDistances}(start.{@link MatrixElement#getHorizDistance(MatrixElement) getHorizDistance}(end),
    *                                         start.{@link MatrixElement#getVertDistance(MatrixElement) getVertDistance}(end))</pre></blockquote>
    */
   public static final MatrixDirection getDirectionFromDistances(
            MatrixElement start, MatrixElement end)  {
      return  getDirectionFromDistances(start.getHorizDistance(end),
                                        start.getVertDistance(end));
   }

   /**
    * Given the relative distances, get the direction between two
    * elements.
    * @param  horiz_dist  The difference between the start and end
    * elements' horizontal values. Specifically,
    * <br/> &nbsp; &nbsp; <code><i>[end-coord]</i>.{@link MatrixElement#getColumnIndex() getColumnIndex}() - <i>[start-coord]</i>.getColumnIndex()</code>
    * @param  vert_dist  The difference between the start and end
    * elements' vertical values. Specifically,
    * <br/> &nbsp; &nbsp; <code><i>[end-coord]</i>.{@link MatrixElement#getRowIndex() getRowIndex}() - <i>[start-coord]</i>.getRowIndex()</code>
    * @return  If the distances are both zero, or the direction is not
    * directly horizontal, vertical, or forty-five degrees diagonal, this
    * returns {@code null}. Otherwise, this returns the direction between
    * the two.
    * @see #getDirectionFromDistances(com.github.xbn.util.matrix.MatrixElement, com.github.xbn.util.matrix.MatrixElement)
    */
   public static final MatrixDirection getDirectionFromDistances(int horiz_dist, int vert_dist)  {
      MatrixDirection dir = null;
      if(horiz_dist != 0)  {
         if(vert_dist == 0)  {
            dir = ((horiz_dist < 0) ? MatrixDirection.LEFT : MatrixDirection.RIGHT);
         }  else if(Math.abs(horiz_dist) == Math.abs(vert_dist))  {
            //Directly diagonal
            if(horiz_dist < 0)  {
               //This is to the left
               dir = ((vert_dist < 0) ?  MatrixDirection.UP_LEFT: MatrixDirection.DOWN_LEFT);
            }  else  {
               //This is to the right
               dir = ((vert_dist < 0) ?  MatrixDirection.UP_RIGHT: MatrixDirection.DOWN_RIGHT);
            }
         }  //Not directly diagonal, vert_distical, or horizontal

      }  else if(vert_dist != 0)  {
         //Horiz is zero, vert_dist is not
         dir = ((vert_dist < 0) ? MatrixDirection.UP : MatrixDirection.DOWN);
      }
      return  dir;
   }
   /**
    * <p>Get a reference to <i>this</i> object.</p>
    * @return  <i>{@code this}</i>
    */
   public DistanceDirection getObjectCopy()  {
      return  this;
   }

}
