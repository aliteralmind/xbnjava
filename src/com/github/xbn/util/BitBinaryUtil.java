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
package  com.github.xbn.util;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Determine if a bit-flag-integer has a particular flag, and some debugging utilities.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class BitBinaryUtil  {
   public static final int VALUE_OF_31ST_ONE_BIT = Integer.parseInt("1000000000000000000000000000000", 2);
   public static final int INT_WITH_NO_BIT_FLAGS = 0;
   private BitBinaryUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static String debugDoesAllHaveBit(int all_flags, int flag_toFind)  {
      return  debugDoesAllHaveBit(16, all_flags, flag_toFind);
   }
   public static String debugDoesAllHaveBit(int bits_toPadTo, int all_flags, int flag_toFind)  {
      String allFlagsStr = String.format("all_flags:    %1$-" + bits_toPadTo + "s%n",
         Integer.toBinaryString(all_flags));
      String oneFlagStr = String.format( "flag_toFind:  %1$-" + flag_toFind + "s%n",
         Integer.toBinaryString(all_flags));
      String sMasked = String.format(    "Masked:       %1$-" + flag_toFind + "s%n",
         Integer.toBinaryString(all_flags & flag_toFind));

      return  "(" + allFlagsStr + " & " + oneFlagStr + ")=" + sMasked + LINE_SEP +
         "all_flags:   " + allFlagsStr + LINE_SEP +
         "flag_toFind: " + oneFlagStr + LINE_SEP +
         "Masked:      " + sMasked;
   }
   public static boolean doesIntHaveBit(int all_flags, int flag_toFind)  {
      return  ((all_flags  &  flag_toFind) != 0);
   }
   /**
      <p>Gets the binary representation of a signed integer, with the &quot;sign bit&quot; removed (31 bits, with the most significant bit, the 32nd, removed).</p>

{@.codelet.and.out com.github.xbn.examples.util.GetIntAsZeroPadded31BitStringNoSignDemo%eliminateCommentBlocksAndPackageDecl()}

      @return  <code>{@link #getIntAsZeroPaddedBinaryStringToLength(int, int) getIntAsZeroPaddedBinaryStringToLength}(num, 32).substring(1, 32)</code>
    **/
   public static final String getIntAsZeroPadded31BitStringNoSign(int num)  {
      return  getIntAsZeroPaddedBinaryStringToLength(num, 32).substring(1, 32);
   }
   /**
      <p>Gets the binary representation of an integer, as a string and with zero padding.</p>

      @return  <code>String.{@link java.lang.String#format(String, Object...) format}(&quot;%&quot; + bit_length + &quot;s&quot;, {@link java.lang.Integer#toBinaryString(int) toBinaryString}(num)).replace(' ', '0')</code>
      @see  #getLongAsZeroPaddedBinaryStringToLength(long, int)
      @see  #getIntAsZeroPadded31BitStringNoSign(int)
    **/
   public static final String getIntAsZeroPaddedBinaryStringToLength(int num, int bit_length)  {
      return  String.format("%" + bit_length + "s", Integer.toBinaryString(num)).replace(' ', '0');
   }
   /**
      <p>Gets the binary representation of a long, as a string and with zero padding.</p>

{@.codelet.and.out com.github.xbn.examples.util.GetZeroPaddedBinaryStringToLengthDemo%eliminateCommentBlocksAndPackageDecl()}

      @return  <code>String.{@link java.lang.String#format(String, Object...) format}(&quot;%&quot; + bit_length + &quot;s&quot;, {@link java.lang.Long#toBinaryString(long) toBinaryString}(num)).replace(' ', '0')</code>
      @see  #getIntAsZeroPaddedBinaryStringToLength(int, int)
    **/
   public static final String getLongAsZeroPaddedBinaryStringToLength(long num, int bit_length)  {
      return  String.format("%" + bit_length + "s", Long.toBinaryString(num)).replace(' ', '0');
   }
   public static final int twoExponentOfHighestOneBitAtMost(int all_flags, int maxTwoExponentOfTwo_0Thr30Incl)  {
      if(maxTwoExponentOfTwo_0Thr30Incl < 0  ||  maxTwoExponentOfTwo_0Thr30Incl > 30)  {
         throw  new IllegalArgumentException("maxTwoExponentOfTwo_0Thr30Incl (" + maxTwoExponentOfTwo_0Thr30Incl + ") must be between 1 and 31, inclusive");
      }

      //Index of first one bit:
      int currentBitMask = VALUE_OF_31ST_ONE_BIT >> (30 - maxTwoExponentOfTwo_0Thr30Incl);
      int exponent = maxTwoExponentOfTwo_0Thr30Incl;
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
   public static final int twoExponentOfLowestOneBitAtLeast(int all_flags, int minTwoExponentOfTwo_0Thr30Incl)  {
      if(minTwoExponentOfTwo_0Thr30Incl < 0  ||  minTwoExponentOfTwo_0Thr30Incl > 30)  {
         throw  new IllegalArgumentException("minTwoExponentOfTwo_0Thr30Incl (" + minTwoExponentOfTwo_0Thr30Incl + ") must be between 1 and 30, inclusive.");
      }

      //Index of first one bit:
      int currentBitMask = 1 << minTwoExponentOfTwo_0Thr30Incl;
      int exponent = minTwoExponentOfTwo_0Thr30Incl;
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

}
