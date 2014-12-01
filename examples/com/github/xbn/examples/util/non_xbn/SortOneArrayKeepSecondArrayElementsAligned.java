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
   import  java.util.ArrayList;
   import  java.util.Arrays;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Map;
   import  java.util.TreeMap;
/**
    <p>Sorts the <i>first</i> array in a two-dimensional array, and moves all partner elements (in the same &quot;column&quot;) in the <i>second</i> to the same sort-destination index.</p>

    <p>This was used as an answer to
    <br/> &nbsp; &nbsp; <code><a href="http://stackoverflow.com/questions/22418151/sorting-2d-array-but-keeping-column-elements-together">http://stackoverflow.com/questions/22418151/sorting-2d-array-but-keeping-column-elements-together</a></code></p>

   <p>{@code java SortOneArrayKeepSecondArrayElementsAligned}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class SortOneArrayKeepSecondArrayElementsAligned  {
   public static final void main(String[] ignored)  {
      int[][] intArrayArray = new int[][]{
        { 6, 3, 1, 2, 3, 0},
        { 2, 1, 6, 6, 2, 4}};
      output2DArray("Unsorted", intArrayArray);

      Map<Integer,List<TwoInts>> twoIntMap = new TreeMap<Integer,List<TwoInts>>();
      for(int i = 0; i < intArrayArray[0].length; i++)  {
         int intIn0 = intArrayArray[0][i];
         if(!twoIntMap.containsKey(intIn0))  {
            List<TwoInts> twoIntList = new ArrayList<TwoInts>(intArrayArray.length);
            twoIntList.add(new TwoInts(intArrayArray[0][i], intArrayArray[1][i]));
               twoIntMap.put(intIn0, twoIntList);
         }  else  {
            twoIntMap.get(intIn0).add(new TwoInts(intArrayArray[0][i], intArrayArray[1][i]));
         }
      }

      int idx = 0;
      Iterator<Integer> itr2i = twoIntMap.keySet().iterator();
      while(itr2i.hasNext())  {
         List<TwoInts> twoIntList = twoIntMap.get(itr2i.next());
         for(TwoInts twoi : twoIntList)  {
            intArrayArray[0][idx] = twoi.aElement;
            intArrayArray[1][idx++] = twoi.bElement;
         }
      }

      output2DArray("Sorted", intArrayArray);
   }
   private static final void output2DArray(String description, int[][] twoD_array)  {
      System.out.println(description + ":");
      System.out.println("0: " + Arrays.toString(twoD_array[0]));
      System.out.println("1: " + Arrays.toString(twoD_array[1]));
      System.out.println();
   }

}
class TwoInts  {
   public final int aElement;
   public final int bElement;
   public TwoInts(int a_element, int b_element)  {
      aElement = a_element;
      bElement = b_element;
   }
}
