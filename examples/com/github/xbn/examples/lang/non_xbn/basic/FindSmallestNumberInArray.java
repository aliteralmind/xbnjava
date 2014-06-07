/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

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
   import  java.util.Arrays;
/**
   <P>Looping through an array, find its largest number. This uses <CODE>java.lang.{@link java.lang.Integer}.{@link java.lang.Integer#MAX_VALUE MAX_VALUE}</CODE> as the initial &quot;smallest&quot; value.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.basic.FindSmallestNumberInArray}</P>

   @see  FindLargestNumberInArray
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FindSmallestNumberInArray  {
   public static final void main(String[] ignored)  {
      int[] ai = new int[]{874, 3, 2, -2, 14};

      System.out.println("Finding lowest value in " + Arrays.toString(ai));

      int idxOfLowestNum = -1;
      int iLowestNum = Integer.MAX_VALUE;
      for(int i = 0; i < ai.length; i++)  {
         if(ai[i] < iLowestNum)  {
            idxOfLowestNum = i;
            iLowestNum = ai[i];
         }
         System.out.println("Index " + idxOfLowestNum + "=" + ai[idxOfLowestNum]);
      }
   }
}
