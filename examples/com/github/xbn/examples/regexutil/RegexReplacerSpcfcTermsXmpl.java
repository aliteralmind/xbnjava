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
package  com.github.xbn.examples.regexutil;
   import  com.github.xbn.regexutil.z.MaxUntilLoopsExceeded;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
/**
   <P>Uses a {@code com.github.xbn.regexutil.RegexReplacer}, to replace specific terms: all, first, &quot;match numbers&quot;, until, or via {@code java.util.regex.}{@code java.util.regex.Matcher#matches() Matcher#matches()} or {@code java.util.regex.}{@code java.util.regex.Matcher#lookingAt() Matcher#lookingAt()}.</P>

   <P>{@code java com.github.xbn.examples.regexutil.RegexReplacerSpcfcTermsXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacerSpcfcTermsXmpl  {
   public static void main(String[] ignored)  {

      String sToSearch = "one two three four five";
      String sFindWhat = "\\b(\\w+)\\b";
      String sRplcWithDirect = "[$1]";

      System.out.println("ALL (all these examples are DIRECT replacements):");
         new RegexReplacer_Cfg().all().direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

         //Equivalent to:
         //	RegexReplacer rr = new RegexReplacer_Cfg().all().build(sFindWhat, sRplcWithDirect);
         //		System.out.println(rr.getReplaced(sToSearch));
         //		System.out.println();

      System.out.println("TERMS 2-3 only:");
         new RegexReplacer_Cfg().matchRange(2, 3).direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

      System.out.println("LOOKING AT:");
         new RegexReplacer_Cfg().lookingAt().direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

      System.out.println("FIRST:");
         sFindWhat = "(\\w{4,})";
         new RegexReplacer_Cfg().first().direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

      System.out.println("MATCHES:");
         sFindWhat = "(.+)";
         new RegexReplacer_Cfg().matches().direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

      sToSearch = "hello hello hello hello hello hello hello";
      sFindWhat = "hello hello";
      sRplcWithDirect = "hello";

      System.out.println("UNTIL (until no more matches found):");
         new RegexReplacer_Cfg().until().direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedlns(2, System.out, sToSearch);

      System.out.println("UNTIL (two loops only):");
         new RegexReplacer_Cfg().until(2, MaxUntilLoopsExceeded.OK).direct(sFindWhat, sRplcWithDirect).
               build().
            appendReplacedlns(2, System.out, sToSearch);
   }
}
