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

package  com.github.xbn.examples.lang.non_xbn.basic;
/**
   <p>Compares two strings, character by character, returning the index of the first different character.</p>

   <p>{@code java com.github.xbn.examples.lang.non_xbn.basic.FirstDifferentCharIndex}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class FirstDifferentCharIndex  {
   public static final void main(String[] ignored)  {
      System.out.println("abcdef, abcdef: " + getFirstDiffIndex("abcdef", "abcdef"));
      System.out.println("abcdefghijklmn, abcdefgiijklmn: " + getFirstDiffIndex("abcdefghijklmn", "abcdefgiijklmn"));
   }
   private static final int getFirstDiffIndex(String str1, String str2)  {

      int len1 = str1.length();
      int len2 = str2.length();

      int idx = -1;     //First iteration: inited to -1, incremented to 0
      while(++idx < len1  &&  idx < len1  &&
               str1.charAt(idx) == str2.charAt(idx))  {
         //Does nothing when equal. Breaks when unequal.
      }

      if(idx < len1  ||  idx < len2)  {
         //The index is less than the length of *either* string. So there is a difference.
         return  idx;
      }  else  {
         //The strings are of equal length, and every character is equal.
         return  -1;
      }
      //Main logic...END
   }
}
