/*license*\
   XBN-Java Library

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
package  com.github.xbn.examples.util.non_xbn;
/**
   <P>Given a 31-bit binary-int, as a string (representing an int with zero or more bit-flags, where the most-significant-bit, the &quot;sign bit&quot;, is removed), get the <I>inverted</I> index of the first one-bit (if the left-most bit is a 1, 31 is the result).</P>

   <P>{@code java com.github.xbn.examples.util.non_xbn.TwoExponentHighestOneBitUsingBinaryStrings}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TwoExponentHighestOneBitUsingBinaryStrings  {
   public static final void main(String[] ignored)  {
      //One bit
         test("1000000000000000000000000000000");  //VALUE_OF_31ST_ONE_BIT
         test("0000100000000000000000000000000");
         test("0000000000000000000000000000010");
         test("0000000000000000000000000000000");

      //Two
         test("0110000000000000000000000000000");
         test("0000000000000000000000000000011");
   }
   private static final void test(String int_binStr)  {
      int i = Integer.parseInt(int_binStr, 2);
      System.out.println("31-bits: " + int_binStr + ", int: " + i);

      int exponent = getInvertedIndexHighestOneBit(int_binStr);
      System.out.println("      Highest one-bit is two-to-the-exponent-of: " + exponent);

      if(exponent != -1)  {
         exponent = getInvertedIndexHighestOneBit(int_binStr, (exponent - 1));
         System.out.println("      Next-highest one-bit is two-to-the-exponent-of: " + exponent);
      }
      System.out.println();
   }
   public static final int getInvertedIndexHighestOneBit(String all31Bits_zeroPadded)  {
      return  getInvertedIndexHighestOneBit(all31Bits_zeroPadded, 30);
   }
   public static final int getInvertedIndexHighestOneBit(String all31Bits_zeroPadded, int inverted_startIdx)  {
      int idxFirstOneBit = all31Bits_zeroPadded.indexOf("1", (30 - inverted_startIdx));
      if(idxFirstOneBit == -1)  {
         return  -1;
      }
      return  (30 - idxFirstOneBit);
   }
}
