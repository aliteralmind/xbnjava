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

package  com.github.xbn.examples.lang.non_xbn;
	import  java.util.Arrays;
/**
   <P>Split four uniform-length strings into a two-dimensional array of characters.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.SplitStringsTo2DCharArray}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class SplitStringsTo2DCharArray  {
   private static final String LINE_SEP = System.getProperty("line.separator", "\r\n");
   public static final void main(String[] ignored)  {
      StringBuilder input = new StringBuilder().
         append("A B C D E F").append(LINE_SEP).
         append("AABG EF 123").append(LINE_SEP).
         append("AD AD POLFE").append(LINE_SEP).
         append("APF PLF ADS").append(LINE_SEP);

      String[] lines = input.toString().split(LINE_SEP);

      //Assumes all lines are the same length
      char[][] charCharArray = new char[lines.length][lines[0].length()];

      for(int i = 0; i < lines.length; i++)  {
         String line = lines[i];
         charCharArray[i] = line.toCharArray();
      }

      for(int i = 0; i < charCharArray.length; i++)  {
         System.out.println(i + ": " + Arrays.toString(charCharArray[i]));
      }
   }
}
