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

package  com.github.xbn.examples.util.non_xbn;
   import  java.util.Set;
   import  java.util.Iterator;
   import  java.util.TreeMap;
   import  java.util.Map;
/**
   <P>Sorts an array of int arrays, each of length two, using a {@code Comparable} class, via insertion into  a {@code TreeMap}.</P>

   <P>{@code java com.github.xbn.examples.util.non_xbn.SortArrayOfTwoInts}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
/**
   <P>{@code java SortArrayOfTwoInts}</P>
 **/
public class SortArrayOfTwoInts  {
   public static final void main(String[] ignored)  {
      int[][] intArrArrOrig = new int[][]  {
         new int[] {3,0},
         new int[] {0,1},
         new int[] {3,1},
         new int[] {0,2},
         new int[] {3,2},
         new int[] {0,3},
         new int[] {1,3},
         new int[] {2,3},
         new int[] {3,3}};

      System.out.println("Original:");
      for(int i = 0; i < intArrArrOrig.length; i++)  {
         System.out.println("[" + intArrArrOrig[i][0] + ", " + intArrArrOrig[i][1] + "]");
      }

      System.out.println();

      Map<TwoIntsForCompare,Object> twoIntsMap = new TreeMap<TwoIntsForCompare,Object>();
      for(int i = 0; i < intArrArrOrig.length; i++)  {
         twoIntsMap.put(new TwoIntsForCompare(intArrArrOrig[i]), null);
      }

      int[][] intArrArrSorted = new int[intArrArrOrig.length][2];
      Set<TwoIntsForCompare> tifcSet = twoIntsMap.keySet();
      int idx = 0;
      Iterator<TwoIntsForCompare> itrTifc = tifcSet.iterator();
      while(itrTifc.hasNext())  {
         intArrArrSorted[idx++] = itrTifc.next().getArray();
      }

      System.out.println("Sorted:");
      for(int i = 0; i < intArrArrSorted.length; i++)  {
         System.out.println("[" + intArrArrSorted[i][0] + ", " + intArrArrSorted[i][1] + "]");
      }
   }
}
class TwoIntsForCompare implements Comparable<TwoIntsForCompare>  {
   public final int major;
   public final int minor;
   public TwoIntsForCompare(int[] idx0Major_idx1Minor)  {
      this.major = idx0Major_idx1Minor[0];
      this.minor = idx0Major_idx1Minor[1];
   }
   public int compareTo(TwoIntsForCompare to_compareTo)  {
      return  (((major - to_compareTo.major) * 10) +
         (minor - to_compareTo.minor));
   }
   public int[] getArray()  {
      return  (new int[] {major, minor});
   }
}
