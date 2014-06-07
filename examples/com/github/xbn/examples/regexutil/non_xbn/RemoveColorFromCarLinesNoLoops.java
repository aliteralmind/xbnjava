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
package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;
/**
   <P>Remove the color from multiple input lines, where colors are in a specific column--using no loops.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.RemoveColorFromCarLinesNoLoops}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RemoveColorFromCarLinesNoLoops  {
   public static final void main(String[] ignored)  {

      //Add colors as necessary
      String sColorsNonCaptureOr = "(?:Blue|Red|Purple|Inferno Red)";
      String sRegex = "" +
      "^(\\d+ )" +				//one-or-more digits, then one space
      sColorsNonCaptureOr +	//color
      " (.+)$";					//Everything after the color (space uncaptured)

      String sRplcWith = "$1$2";

      //"": Unused search-string, so matcher can be reused.
      Matcher m = Pattern.compile(sRegex).matcher("");

      String sColorRemoved1 = removeColorFromCarLine(m, "04 Blue Honda Accord", sRplcWith);
      String sColorRemoved2 = removeColorFromCarLine(m, "12 Inferno Red Chevrolet Tahoe", sRplcWith);
      String sColorRemoved3 = removeColorFromCarLine(m, "10 Purple Ford Taurus", sRplcWith);
   }
   private static final String removeColorFromCarLine(Matcher mtchr, String orig_carLine, String rplc_with)  {
      mtchr.reset(orig_carLine);
      if(!mtchr.matches())  {
         throw  new IllegalArgumentException("Does not match: \"" + " + orig_carLine + " + "\", pattern=[" + mtchr.pattern() + "]");
      }

      //Since it matches(s), this is equivalent to "replace the entire line, as a whole"
      String s = mtchr.replaceFirst(rplc_with);
      System.out.println(orig_carLine + "  -->  " + s);
      return  s;
   }
}
