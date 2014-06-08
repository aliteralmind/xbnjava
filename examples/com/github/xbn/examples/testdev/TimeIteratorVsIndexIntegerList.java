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

package  com.github.xbn.examples.testdev;
   import  com.github.xbn.testdev.TimedTest;
   import  java.util.Arrays;
   import  java.util.List;
/**
   <P>Demonstration of {@code com.github.xbn.testdev.}{@link com.github.xbn.testdev.TimedTest TimedTest}, comparing two ways to iterating through a list: by index or iterator.</P>

   <P>{@code java com.github.xbn.examples.testdev.TimeIteratorVsIndexIntegerList 1000000}</P>

   @see  <CODE><A HREF="http://aliteralmind.wordpress.com/2014/03/22/for_foreach/">http://aliteralmind.wordpress.com/2014/03/22/for_foreach/</A></CODE>
   @see  <CODE><A HREF="http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java">http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java</A></CODE>
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class TimeIteratorVsIndexIntegerList  {
   public static final void main(String[] tryCount_inParamIdx0)  {
      int testCount = TimedTest.getTestCountFromCmdLine(tryCount_inParamIdx0, 0);

      //Test proper...START
         List<Integer> intList = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100});

         TimedTest idxTest = new TimedTest("index");
         TimedTest itrTest = new TimedTest("iterator");

         idxTest.declareStartWithOutput();
            for(int i = 0; i < testCount; i++)  {
               testIndex(intList);
            }
         idxTest.declareEndThenStartNextWithOutput(itrTest);
            for(int i = 0; i < testCount; i++)  {
               testIterator(intList);
            }
         itrTest.declareEndWithOutput();

         System.out.println(idxTest.getTestABTestNanoDifferenceMsg(itrTest));
   }
      private static final void testIndex(List<Integer> int_list)  {
         int total = 0;
         for(int i = 0; i < int_list.size(); i++)  {
            total += int_list.get(i);
         }
      }
      private static final void testIterator(List<Integer> int_list)  {
         int total = 0;
         for(int i : int_list)  {
            total += i;
         }
      }
   //Test proper...END
}
