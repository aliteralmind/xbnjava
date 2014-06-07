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
package  com.github.xbn.examples.util.non_xbn;
   import  java.util.Iterator;
   import  java.util.Map;
   import  java.util.Set;
   import  java.util.TreeMap;
/**
   <P>Elegant and short solution to finding the number of occurances of each number in an int-array.</P>

   <P>{@code java com.github.xbn.examples.util.non_xbn.IntOccurancesInArrayElegant}</P>

   @see  IntOccurancesInArray
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntOccurancesInArrayElegant  {
   public static final void main(String[] ignored)  {
      int[] ai = new int[]{52, 67, 32, 43, 32, 21, 12, 5, 0, 3, 2, 0, 0};
      int[] aiHits1to100 = new int[101];
      for(int i : ai)  {
         if(i >= 0  &&  i <= 100)  {
            aiHits1to100[i]++;
         }
      }
      for(int i = 0; i < aiHits1to100.length; i++)  {
         int iOccurances = aiHits1to100[i];
         if(iOccurances > 0)  {
            System.out.println("number=" + i + ", occurances=" + iOccurances);
         }

      }
   }
}
