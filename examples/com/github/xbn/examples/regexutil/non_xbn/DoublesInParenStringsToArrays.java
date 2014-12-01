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

package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.Arrays;
   import  java.util.ArrayList;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <p>Takes an input string such as {@code "(1.0,2.0) (2,7.6) (2.1,3.0)"}, and translates each parenthesized set of numbers to an array of doubles.</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.DoublesInParenStringsToArrays}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class DoublesInParenStringsToArrays  {
   public static final void main(String[] ignored)  {
      String input = "(1.0,2.0) (2,7.6) (2.1,3.0)";
      String[] inputs = input.split(" ");

      //"": Dummy string, to reuse matcher
      Matcher mtchrGetNums = Pattern.compile("\\b([\\d.]+)\\b").matcher("");
      for(String s : inputs)  {

         ArrayList<Double> doubleList = new ArrayList<Double>();
         mtchrGetNums.reset(s);
         while(mtchrGetNums.find())  {
            //TODO: Crash if it's not a number!
            doubleList.add(Double.parseDouble(mtchrGetNums.group(0)));
         }

         Double[] doubles = doubleList.toArray(new Double[doubleList.size()]);
         System.out.println(Arrays.toString(doubles));
      }
   }
}
