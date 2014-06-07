/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.examples.array.non_xbn;
   import  java.util.Arrays;
/**
   <P>Copy a subset of an array using <CODE>{@link java.lang.System System}.{@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}(o,i,o,i,i)</CODE>, which is the pre JDK-7 way of copying arrays--in Java 7 use <CODE>{@link java.util.Arrays Arrays}.copyOf(...)</CODE> {@code copyOfRange(...)}</P>

   <P>{@code java com.github.xbn.examples.array.non_xbn.CopyArraySubsetWithArraycopy}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CopyArraySubsetWithArraycopy  {
   public static final void main(String[] ignored)  {
      int[] origInts = new int[] {0, 10, 20, 30, 40};
      int startIdx = 2;
      int newArrayLen = origInts.length - startIdx;
      int[] intsSubset = new int[newArrayLen];
      System.arraycopy(origInts, startIdx, intsSubset, 0, newArrayLen);

      System.out.println("origInts=" + Arrays.toString(origInts));
      System.out.println("intsSubset=" + Arrays.toString(intsSubset));
   }
}

