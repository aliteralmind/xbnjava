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
package  com.github.xbn.examples.array;
   import  com.github.xbn.array.XIbxBadRange;
   import  com.github.xbn.array.XIbxBadIdx;
   import  com.github.xbn.array.XbnIndexOutOfBoundsException;
   import  com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg;
/**
   <P>Demonstrates building an {@code com.github.xbn.array.}{@link com.github.xbn.array.XbnIndexOutOfBoundsException XbnIndexOutOfBoundsException}.</P>

   <P>{@code java com.github.xbn.examples.array.XbnIndexOutOfBoundsExceptionXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnIndexOutOfBoundsExceptionXmpl  {
   public static final void main(String[] ignored)  {

      System.out.println("--Bad index, given a string's length:");

         XbnIndexOutOfBoundsException xibx = new XbnIndexOutOfBoundsException_Cfg().
            badIndex(-2, "index").absStringLength("Kermit T. Frog", "sName").
            build();

         System.out.println(xibx);
         XIbxBadIdx xdata = xibx.getBadIdxData();
         System.out.println("bad-index=" + xdata.getBadIndex() + " (name=" + xdata.getBadIndexName() + ")");
         System.out.println("container-length=" + xdata.getAbsMaxX() + " (name=" + xdata.getAbsMaxXName() + ")");
         System.out.println();

      System.out.println("--Bad index-range, given an array's length:");

         xibx = new XbnIndexOutOfBoundsException_Cfg().
            badRange(-1, 2, "getMinBound()", "getMaxBound()").absMinAndPArrayLength(1, (new int[]{1, 2, 3, 4})).
            buildWithInfo("Try better indexes next time, please.");

         System.out.println(xibx);
   }
}
