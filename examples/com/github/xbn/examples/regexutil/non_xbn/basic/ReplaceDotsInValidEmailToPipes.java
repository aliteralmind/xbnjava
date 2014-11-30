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
package  com.github.xbn.examples.regexutil.non_xbn.basic;
      import  java.util.regex.Pattern;
/**
   <p>Replace all dots in a valid email to pipes: {@code '|'}.</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.basic.ReplaceDotsInValidEmailToPipes}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReplaceDotsInValidEmailToPipes  {
   public static final void main(String[] ignored)  {
      Pattern pEmail = Pattern.compile("^\\S+@\\S+.\\S+$");
      test(pEmail, "obama@whitehouse.com");
      test(pEmail, "barack.obama@whitehouse.com");
      test(pEmail, "barack.obama@whitehouse.com.gov.nsa");
      test(pEmail, "barack.obama_BOGUS_whitehouse.com.gov.nsa");
   }
   private static final void test(Pattern pattern_toFind, String potentialEmail_wDots)  {
      System.out.print(potentialEmail_wDots + "	 -->	");

      String sRplcd = null;
      if(pattern_toFind.matcher(potentialEmail_wDots).matches())  {
         sRplcd = potentialEmail_wDots.replaceAll("\\.", "|");
      }  else  {
         sRplcd = "Not an email";
      }
      System.out.println(sRplcd);
   }
}
