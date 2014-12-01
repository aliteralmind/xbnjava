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
   import  com.github.xbn.util.matrix.DistanceDirection;
/**
 * <p>Demonstration of <code>com.github.xbn.util.matrix.{@link com.github.xbn.util.matrix.DistanceDirection}</code>.</p>
 *
 * <p><code>java  com.github.xbn.examples.util.matrix.DistanceDirectionXmpl</code></p>
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class DistanceDirectionXmpl  {
   public static final void main(String[] cmd_lineParams)  {
      //Element 0,0 (top left) to 5,5 (bottom right)
      printDirDist(5, 5);
      //5,5  to  0,0
      printDirDist(-5, -5);
      //1,3  to  5,5
      printDirDist(4, 2);
   }
   private static final void printDirDist(int horiz, int vert)  {
      DistanceDirection distDir = new DistanceDirection(horiz, vert);
      System.out.print(distDir.getDirection() + ": ");
      System.out.print("horiz=" + distDir.getHorizDistance());
      System.out.println(", vert=" + distDir.getVertDistance());
   }
}