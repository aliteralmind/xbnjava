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
package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;
/**
   <p>Strip all formatting from a phone number, and capture all major parts.</p>

   <p>{@code java com.github.xbn.examples.txt.regex.non_xbn.StripPhoneFormattingXmpl}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class StripPhoneFormattingXmpl  {
   public static final void main(String[] ignored)  {
      String sToSearch = "1(800) 765-4321 1 877 765-4321 1-855-765-4321 1.800.765.4321 18001231234";

      String sRegex = "\\+?(1?)\\D*(\\d\\d\\d)\\D*(\\d\\d\\d)\\D*(\\d\\d\\d\\d)\\b";
      String sRplcWith = "$1$2$3$4";

      Matcher m = Pattern.compile(sRegex).matcher(sToSearch);
      StringBuffer sb = new StringBuffer();
      while(m.find())  {
         m.appendReplacement(sb, sRplcWith);
      }
      m.appendTail(sb);

      System.out.println("Original: " + sToSearch);
      System.out.println("Stripped: " + sb);
   }
}
