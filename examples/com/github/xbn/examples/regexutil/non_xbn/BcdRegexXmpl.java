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
    import  java.util.regex.Matcher;
    import  java.util.regex.Pattern;
/**
   <P>Regex and non-regex example of finding the number of matches in a string.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.BcdRegexXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
**/
public class BcdRegexXmpl  {
   public static final void main(String[] ignored)  {
      String sSentence = "abcd bcdd";
      int iBcds = 0;
      int iIdx = 0;
      while(true)  {
         int iBcdIdx = sSentence.indexOf("bcd", iIdx);
         if(iBcdIdx == -1)  {
            break;
         }
         iIdx = iBcdIdx + "bcd".length();
         iBcds++;
      }

      System.out.println("Number of 'bcd's (no regex): " + iBcds);

      //Alternatively
      iBcds = 0;
      //Same regex as @la-comadreja, with word-boundaries
      //For multiple "bcd"-s in a single word, remove the "\\b"-s
      Matcher m = Pattern.compile("\\b\\w*bcd\\w*\\b").matcher(sSentence);
      while(m.find())  {
         System.out.println("Found at index " + m.start());
         iBcds++;
      }
      System.out.println("Number of 'bcd's (with regex): " + iBcds);
   }
}
