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
package  com.github.xbn.examples.lang.non_xbn;
   import  java.util.ArrayList;
/**
   <p>Demonstrates {@link java.lang.Comparable Comparable}.<code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html#compareTo(T)">compareTo</a>(T)</code> for sets of three integers.</p>

   <p>{@code java com.github.xbn.examples.lang.non_xbn.ComparableForThreeIntsAsAUnit}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ComparableForThreeIntsAsAUnit  {
   public static final void main(String[] ignored)  {
      String sInput = "1,2,3,5,56,66,44,88,77,99,12,14,25,36,15,17,89,15,17,28,58,95,97,58,64,84,21,23,28,27,36,39";
      String[] asInts = sInput.split(",");

      int iTotalInts = asInts.length;
      ArrayList<ThreeSeries> al3s = new ArrayList<ThreeSeries>(iTotalInts - 2);
      for(int i = 0; i < iTotalInts - 2; i++)  {
         al3s.add(new ThreeSeries(asInts[i], asInts[i + 1], asInts[i + 2]));
      }

      for(int i = 0; i < al3s.size(); i++)  {
         for(int j = i + 1; j < al3s.size(); j++)  {
            ThreeSeries threeSI = al3s.get(i);
            ThreeSeries threeSJ = al3s.get(j);
            int iCompareResult = threeSI.compareTo(threeSJ);

            System.out.println("Comparing " + threeSI + ".compareTo(" + threeSJ + ")=" + iCompareResult + " -- " + ((iCompareResult < 0)
               ?  threeSI + " is LESS than " + threeSJ
               :  (iCompareResult > 0)
                  ?  threeSI + " is GREATER than " + threeSJ
                  :  "EQUAL"));
         }
      }
   }
}
class ThreeSeries implements Comparable<ThreeSeries>  {
   private final int num1;
   private final int num2;
   private final int num3;
   public ThreeSeries(String num_inStr1, String num_inStr2, String num_inStr3)  {
      this(Integer.parseInt(num_inStr1), Integer.parseInt(num_inStr2), Integer.parseInt(num_inStr3));
   }
   public ThreeSeries(int num_1, int num_2, int num_3)  {
      num1 = num_1;
      num2 = num_2;
      num3 = num_3;
   }
   public int get1()  {
      return  num1;
   }
   public int get2()  {
      return  num2;
   }
   public int get3()  {
      return  num3;
   }
   public String toString()  {
      return  "{" + get1() + ", " + get2() + ", " + get3() + "}";
   }
   public int compareTo(ThreeSeries three_series)  {
      int num1Diff = get1() - three_series.get1();
      int num2Diff = get2() - three_series.get2();
      int num3Diff = get3() - three_series.get3();
      return  (num1Diff + num2Diff + num3Diff);
   }
}
