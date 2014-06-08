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
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <P>Validate a phone number, with accomodation for an initial plus-sign.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.ValidatePhoneNumberWithFormat}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValidatePhoneNumberWithFormat  {
   public static final void main(String[] ignored)  {

      String sOptionalDashSlash = "(?:[-/])?";
      String sOneOrMoreDigitsCAPTURED = "(\\d+)";

      String sREPhone = "" +
         "^(?:[+(])?" +			//+ or (				 [start of line, then optional]
         sOneOrMoreDigitsCAPTURED +
         "(?:\\))?" +			  //Closing )			 [optional]
         sOptionalDashSlash +
         sOneOrMoreDigitsCAPTURED +
         sOptionalDashSlash +
         sOneOrMoreDigitsCAPTURED +
         sOptionalDashSlash +
         "(\\d*)$";				 //one-or-more digits [optional, then end of line]

         //Equivalent to:
         //String sREPhone = "" +
         //	"^(?:[+(])?" +		//+ or (				 [start of line, then optional]
         //	"(\\d+)" +			 //one-or-more digits CAPTURED
         //	"(?:\\))?" +		  //Closing )			 [optional]
         //	"(?:[-/])?" +		 //- or /				 [optional]
         //	"(\\d+)" +			 //one-or-more digits CAPTURED
         //	"(?:[-/])?" +		 //- or /				 [optional]
         //	"(\\d+)" +			 //one-or-more digits CAPTURED
         //	"(?:[-/])?" +		 //- or /				 [optional]
         //	"(\\d*)$";			 //one-or-more digits CAPTURED [optional, then end of line]

      //Create matcher with unused string, so it can be reused in test(m,s)
      Matcher m = Pattern.compile(sREPhone).matcher("");

      test(m, "123-431-123/23");  //true
      test(m, "+312-31-32-53");	//true
      test(m, "(123)456-7890");	//true
      test(m, "000-132+23");		//false
      test(m, "000()312");		  //false
      test(m, "122--231");		  //false
   }
   private static final void test(Matcher method, String to_test)  {
      method.reset(to_test);
      System.out.println(to_test + "  -->  " + method.matches());
   }
}
