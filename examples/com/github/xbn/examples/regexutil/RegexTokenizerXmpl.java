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
   import  com.github.xbn.regexutil.RegexTokenizer;
   import  com.github.xbn.regexutil.z.RegexTokenizer_Cfg;
/**
   <P>Uses a {@code com.github.xbn.regexutil.}{@link com.github.xbn.regexutil.RegexTokenizer RegexTokenizer} to split a string on a regex, optionally returning the regex-separators and/or the &quot;betweens&quot;.</P>

   <P>{@code java com.github.xbn.examples.regexutil.RegexTokenizerXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexTokenizerXmpl  {
   public static final void main(String[] ignored)  {

      String sRENumCommaNum = "(\\b\\d+,\\d+\\b)";
      String sREBetweens = "((?:\\),\\()|(?:(?<!,)\\()|(?:\\)(?!,)))";
      String sToSearch = "(1,2),(3,4),(5,6)";

      System.out.println("Searching: \"" + sToSearch + "\"");

      System.out.println("Numbers:");
         RegexTokenizer rt = new RegexTokenizer_Cfg(sRENumCommaNum).
            separators().toTokenize(sToSearch).
            //debugTo(System.out).
            build();
         while(rt.hasNext())  {
            System.out.println(rt.next().getText());
         }

      System.out.println("Betweens:");
         rt.setNewSearch(sREBetweens, sToSearch, -1);
         while(rt.hasNext())  {
            System.out.println(rt.next().getText());
         }
   }
}


