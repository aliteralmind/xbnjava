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
package  com.github.xbn.examples.regexutil;
   import  com.github.xbn.regexutil.IndirectRegexReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
/**
   <p>Demonstrates an <a href="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#indirect">indirect replacement</a> using {@code com.github.xbn.regexutil.RegexReplacer}.</p>

   <p>{@code java com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl1of2}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RegexReplacerIndirectXmpl1of2  {
   public static void main(String[] ignored)  {

      System.out.println("Replace terms 2-3 with uppercase, surrounded by square-brackets:");
      String sFindWhat = "\\b(\\w+)\\b";
      String sToSearch = "one two three four five";
      IndirectRegexReplacer rri = new IndirectRegexReplacer(new RegexReplacer_Cfg().findWhat(sFindWhat).matchRange(2, 3))  {
         public String getIndirectReplacement()  {
            return  "[" + getGroup(1).toUpperCase() + "]";
         }
      };
      System.out.println(rri.getReplaced(sToSearch));
   }
}
