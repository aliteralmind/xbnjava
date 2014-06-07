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
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
/**
   <P>Uses a {@code com.github.xbn.regexutil.RegexReplacer} to replace the second and third matches only.</P>

   <P>{@code java com.github.xbn.examples.regexutil.RegexReplacerValidTermXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacerValidTermXmpl  {
   public static final void main(String[] ignored)  {

      String sToSearch = "one two three four five";
      String sFindWhat = "\\b(\\w+)\\b";
      String sRplcWithDirect = "[$1]";

      System.out.println("Uppercase terms 2 and 3 only:");
         new RegexReplacer_Cfg().matchRange(2, 3).direct(sFindWhat, sRplcWithDirect).build().
            appendReplacedln(System.out, sToSearch);
   }
}
