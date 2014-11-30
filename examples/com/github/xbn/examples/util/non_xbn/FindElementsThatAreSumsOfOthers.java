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
   import  java.util.Iterator;
   import  java.util.Map;
   import  java.util.Set;
   import  java.util.TreeMap;
/**
   <p>Find all elements in an int array that are the sum of two other elements.</p>

   <p>{@code java com.github.xbn.examples.util.non_xbn.FindElementsThatAreSumsOfOthers}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FindElementsThatAreSumsOfOthers  {
   public static final void main(String[] ignored)  {
      int[] ai = new int[]{10, 51, 137, 464, 589, 61, 452};

      //All numbers in a map, key is array-value, value is array-index
      Map<Integer,Integer> mpValIdxAll = new TreeMap<Integer,Integer>();

      for(int i = 0; i < ai.length; i++)  {
         mpValIdxAll.put(ai[i], i);
      }

      //Only those elements in the array that are *sums* of other elements
      //Key is array-index of sum, value is SumInfo object
      Map<Integer,SumInfo> mpValIdxSums = new TreeMap<Integer,SumInfo>();

      for(int i = 0; i < ai.length; i++)  {
         //j + 1: So we don't test the same combination twice.
         for(int j = i + 1; j < ai.length; j++)  {
            int iSum = ai[i] + ai[j];

            if(mpValIdxAll.containsKey(iSum))  {
               //The all-map contains the sum, so add it to the sum-map
               mpValIdxSums.put(mpValIdxAll.get(iSum), new SumInfo(ai[i], i, ai[j], j));
            }
         }
      }

      Set<Integer> stSumIdxs = mpValIdxSums.keySet();
      Iterator<Integer> itrSumIdxs = stSumIdxs.iterator();
      while(itrSumIdxs.hasNext())  {
         int iIdxSum = itrSumIdxs.next();
         SumInfo si = mpValIdxSums.get(iIdxSum);
         System.out.println(ai[iIdxSum] + " (element " + iIdxSum + ")  is the sum of elements " + si.iA + " (idx=" + si.iIdxA + ") and " + si.iB + " (idx=" + si.iIdxB + ")");
      }
   }
}
//The two elements that are a sum of another element
class SumInfo  {
   public final int iA;
   public final int iIdxA;
   public final int iB;
   public final int iIdxB;
   public SumInfo(int addend_a, int index_a, int addend_b, int index_b)  {
      iA = addend_a;
      iIdxA = index_a;
      iB = addend_b;
      iIdxB = index_b;
   }
}
