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
package com.github.xbn.examples.regexutil.non_xbn;
	import  java.util.Scanner;
	import  java.util.regex.Matcher;
	import  java.util.regex.Pattern;
	import  org.apache.commons.lang3.math.NumberUtils;
 /**
	<P>Example code used in my <A HREF="http://aliteralmind.wordpress.com/2014/03/02/regex_numeric_range">blog post</A>: How to use regular expressions to validate number-ranges. This confirms a user-input number is a valid number by reading a string an testing it is numeric before converting it to an it--this loops until a valid number is provided.</P>

	<P>{@code java com.github.xbn.examples.regexutil.non_xbn.UserInputNumInRangeWRegex}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
  **/
 public class UserInputNumInRangeWRegex  {
	public static final void main(String[] ignored)  {

		int num = -1;
		boolean isNum = false;

		int iRangeMax = 2055;

		//"": Dummy string, to reuse matcher
		Matcher mtchrNumNegThrPos = Pattern.compile("-?\\b(20(5[0-5]|[0-4][0-9])|1?[0-9]{1,3})\\b").matcher("");

		do  {
			System.out.print("Enter a number between -" + iRangeMax + " and " + iRangeMax + ": ");
			String strInput = (new Scanner(System.in)).next();
			if(!NumberUtils.isNumber(strInput))  {
				System.out.println("Not a number. Try again.");
			}  else if(!mtchrNumNegThrPos.reset(strInput).matches())  {
				System.out.println("Not in range. Try again.");
			}  else  {
				//Safe to convert
				num = Integer.parseInt(strInput);
				isNum = true;
			}
		}  while(!isNum);

		System.out.println("Number: " + num);
	}
}
