/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.examples.lang.non_xbn;
/**
   <P>Given a word, find the first index at which, when that character is removed, the remaining characters form a palindrome.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.ElimOneCharForPalindrome}</P>

   <P>This is my first code golf:
   <BR> &nbsp; &nbsp; <CODE><A HREF="http://codegolf.stackexchange.com/questions/25279/remove-a-letter-to-make-a-palindrome">http://codegolf.stackexchange.com/questions/25279/remove-a-letter-to-make-a-palindrome</A></CODE></P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class ElimOneCharForPalindrome  {
   public static final void main(String[] ignored)  {
      System.out.println(getEliminateForPalindromeIndex("racercar"));
      System.out.println(getEliminateForPalindromeIndex("racecar"));
   }
   public static final int getEliminateForPalindromeIndex(String oneCharAway_fromPalindrome)  {
      for(int i = 0; i < oneCharAway_fromPalindrome.length(); i++)  {
         String strMinus1Char = oneCharAway_fromPalindrome.substring(0, i) + oneCharAway_fromPalindrome.substring(i + 1);

         String half1 = getFirstHalf(strMinus1Char);
         String half2Reversed = getSecondHalfReversed(strMinus1Char);

         if(half1.length() != half2Reversed.length())  {
            //One half is exactly one character longer
            if(half1.length() > half2Reversed.length())  {
               half1 = half1.substring(0, (half1.length() - 1));
            }  else  {
               half2Reversed = half2Reversed.substring(0, (half2Reversed.length() - 1));
            }
         }

         //System.out.println(i + " " + strMinus1Char + " --> " + half1 + " / " + half2Reversed + "  (minus the singular [non-mirrored] character in the middle, if any)");

         if(half1.equals(half2Reversed))  {
            return  i;
         }
      }
      return  -1;
   }
   public static final String getFirstHalf(String whole_word)  {
      return  whole_word.substring(0, whole_word.length() / 2);
   }
   public static final String getSecondHalfReversed(String whole_word)  {
      return  new StringBuilder(whole_word.substring(whole_word.length() / 2)).reverse().toString();
   }
}
