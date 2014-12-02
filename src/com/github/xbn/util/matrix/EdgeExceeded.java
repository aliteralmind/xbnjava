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
 * <p>If the grid's boundary is exceeded, should it crash or wrap around, <a href="https://www.youtube.com/watch?v=i3Pr8yC8_F4&t=29s">a la Asteroids</a>?</p>
 *
 * @see BoundedMatrix#getNeighbor(int, int, com.github.xbn.util.matrix.MatrixDirection, int, com.github.xbn.util.matrix.EdgeExceeded) BoundedMatrix#getNeighbor
 * @since  0.1.5
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public enum EdgeExceeded  {
   /**
    * <p>Throw an exception.</p>
    *
    * @see  #WRAP
    * @see  #doCrash()
    */
   CRASH,
   /**
    * <p>Wrap to the item on the other side (moving down-right in a 5x5
    * grid, starting at element {@code [0,4]}, takes you to {@code [1,0]}).</p>
    *
    * @see  #CRASH
    * @see  #doWrap()
    */
   WRAP;
   /**
    * <p>Is this {@code EdgeExceeded} equal to {@code CRASH}?.</p>
    *
    * @return  <code>this == {@link #CRASH}</code>
    *
    * @see  #doWrap()
    */
   public final boolean doCrash()  {
      return  this == CRASH;
   }
   /**
    * <p>Is this {@code EdgeExceeded} equal to {@code WRAP}?.</p>
    *
    * @return  <code>this == {@link #WRAP}</code>
    * @see  #doCrash()
    */
   public final boolean doWrap()  {
      return  this == WRAP;
   }
};
