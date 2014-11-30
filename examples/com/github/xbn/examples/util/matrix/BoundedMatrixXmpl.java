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
package  com.github.xbn.examples.util.matrix;
   import  com.github.xbn.util.matrix.BoundedMatrix;
   import  com.github.xbn.util.matrix.EdgeExceeded;
   import  com.github.xbn.util.matrix.MatrixDirection;
   import  com.github.xbn.util.matrix.MatrixElement;
/**
 * <p>A basic demonstration of {@link com.github.xbn.util.matrix.BoundedMatrix}.</p>
 *
 * <p><code>java  com.github.xbn.examples.util.matrix.BoundedMatrixXmpl</code></p>
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class BoundedMatrixXmpl  {
   public static final void main(String[] cmd_lineParams)  {
      BoundedMatrix matrix = new BoundedMatrix(20); //20x20 square
      MatrixElement element = matrix.get(3,5);
      MatrixElement element2 = matrix.getNeighbor(element,
         MatrixDirection.DOWN_RIGHT, 3, EdgeExceeded.CRASH);
      MatrixElement element3 = matrix.moveDown(element2, EdgeExceeded.CRASH);

      System.out.println("First:  " + element);
      System.out.println("Second: " + element2);
      System.out.println("Third:  " + element3);

      System.out.println("The third element has the following neighbor counts:");
      System.out.println("   up=        " +
         matrix.getNeighborCount(element3, MatrixDirection.UP));
      System.out.println("   up-right=  " +
         matrix.getNeighborCount(element3, MatrixDirection.UP_RIGHT));
      System.out.println("   right=     " +
         matrix.getNeighborCount(element3, MatrixDirection.RIGHT));
      System.out.println("   down-right=" +
         matrix.getNeighborCount(element3, MatrixDirection.DOWN_RIGHT));
      System.out.println("   down=      " +
         matrix.getNeighborCount(element3, MatrixDirection.DOWN));
      System.out.println("   down-left= " +
         matrix.getNeighborCount(element3, MatrixDirection.DOWN_LEFT));
      System.out.println("   left=      " +
         matrix.getNeighborCount(element3, MatrixDirection.LEFT));
      System.out.println("   up-left=   " +
         matrix.getNeighborCount(element3, MatrixDirection.UP_LEFT));
   }
}
