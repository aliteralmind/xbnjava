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
package  com.github.xbn.examples.util.non_xbn;
/**
   <P>Given a 31-bit binary-int, as a string (representing an int with zero or more bit-flags, where the most-significant-bit, the &quot;sign bit&quot;, is removed), get the <I>inverted</I> index of the first one-bit (if the left-most bit is a 1, 31 is the result).</P>

   <P>{@code java com.github.xbn.examples.util.non_xbn.TwoExponentHighestOneBitUsingInts}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TwoExponentHighestOneBitUsingInts  {
   public static final int VALUE_OF_31ST_ONE_BIT = Integer.parseInt("1000000000000000000000000000000", 2);
   public static final void main(String[] ignored)  {
      //One bit
         test(VALUE_OF_31ST_ONE_BIT);
         test(Integer.parseInt("0000100000000000000000000000000", 2));
         test(Integer.parseInt("0000000000000000000000000000010", 2));
         test(Integer.parseInt("0000000000000000000000000000000", 2));

      //Two
         test(Integer.parseInt("0110000000000000000000000000000", 2));
         test(Integer.parseInt("0000000000000000000000000000011", 2));
   }
   private static final void test(int num)  {
      System.out.println("Testing: 31-bit binary=" + getIntAsZeroPadded31BitStringNoSign(num) + ", int=" + num);
      int exponent = twoExponentOfHighestOneBit(num);
      System.out.println("   Highest one-bit is two-to-the-exponent-of: " + exponent);
      if(exponent > 0)  {
         System.out.println("   Next-highest one-bit is two-to-the-exponent-of: " + twoExponentOfHighestOneBitAtMost(num, (exponent - 1)));
      }

      exponent = twoExponentOfLowestOneBit(num);
      System.out.println("   Lowest one-bit is two-to-the-exponent-of: " + exponent);
      if(exponent != -1  &&  exponent < 30)  {
         System.out.println("   Next-highest one-bit is two-to-the-exponent-of: " + twoExponentOfLowestOneBitAtLeast(num, (exponent + 1)));
      }
      System.out.println();

   }
   public static final int twoExponentOfHighestOneBit(int all_flags)  {
      return  twoExponentOfHighestOneBitAtMost(all_flags, 30);
   }
   public static final int twoExponentOfHighestOneBitAtMost(int all_flags, int twoExponentOfTwo_max0Thr30Incl)  {
      if(twoExponentOfTwo_max0Thr30Incl < 0  ||  twoExponentOfTwo_max0Thr30Incl > 30)  {
         throw  new IllegalArgumentException("twoExponentOfTwo_max0Thr30Incl (" + twoExponentOfTwo_max0Thr30Incl + ") must be between 1 and 31, inclusive");
      }

      //Index of first one bit:
      int currentBitMask = VALUE_OF_31ST_ONE_BIT >> (30 - twoExponentOfTwo_max0Thr30Incl);
      int exponent = twoExponentOfTwo_max0Thr30Incl;
      while(exponent >= 0)  {
//System.out.println("   high.currentBitMask=" + getIntAsZeroPadded31BitStringNoSign(currentBitMask) + ", exponent=" + exponent + "");
//System.out.println("   high.all_flags=     " + getIntAsZeroPadded31BitStringNoSign(all_flags));
         if((all_flags & currentBitMask) == currentBitMask)  {
            return  exponent;
         }
//System.out.println();
         exponent--;
         currentBitMask >>= 1;
      }
      return  -1;
   }
   public static final int twoExponentOfLowestOneBit(int all_flags)  {
      return  twoExponentOfLowestOneBitAtLeast(all_flags, 0);
   }
   public static final int twoExponentOfLowestOneBitAtLeast(int all_flags, int twoExponentOfTwo_min0Thr30Incl)  {
      if(twoExponentOfTwo_min0Thr30Incl < 0  ||  twoExponentOfTwo_min0Thr30Incl > 30)  {
         throw  new IllegalArgumentException("twoExponentOfTwo_min0Thr30Incl (" + twoExponentOfTwo_min0Thr30Incl + ") must be between 1 and 30, inclusive.");
      }

      //Index of first one bit:
      int currentBitMask = 1 << twoExponentOfTwo_min0Thr30Incl;
      int exponent = twoExponentOfTwo_min0Thr30Incl;
      while(exponent <= 30)  {
//System.out.println("   low.currentBitMask=" + getIntAsZeroPadded31BitStringNoSign(currentBitMask) + ", exponent=" + exponent + "");
//System.out.println("   low.all_flags=     " + getIntAsZeroPadded31BitStringNoSign(all_flags));
         if((all_flags & currentBitMask) == currentBitMask)  {
            return  exponent;
         }
//System.out.println();
         exponent++;
         currentBitMask <<= 1;
      }
      return  -1;
   }
   public static final String getIntAsZeroPadded31BitStringNoSign(int num)  {
      return  String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0').substring(1, 32);
   }
}
