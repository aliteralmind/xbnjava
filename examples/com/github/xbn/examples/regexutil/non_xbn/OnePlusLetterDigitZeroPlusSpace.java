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
   <P>Uses two regular expressions to confirm a string has one-or-more characters <I>and</I> zero-or-more spaces. This is an answer to
   <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/23091427/java-regex-allow-white-spaces-in-the-string">http://stackoverflow.com/questions/23091427/java-regex-allow-white-spaces-in-the-string</A></CODE></P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.OnePlusLetterDigitZeroPlusSpace}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class OnePlusLetterDigitZeroPlusSpace  {
	//"": Unused search string, to reuse the matcher object
	private static final Matcher mtchr1PlusLetterDigitSpc = Pattern.compile("^[a-zA-z0-9 ]+$").matcher("");
	private static final Matcher mtchr0PlusSpc = Pattern.compile("^ *$").matcher("");
	public static final void main(String[] ignored)  {
		test("");
		test(" ");
		test("a");
		test("hello ");
		test(" hello ");
		test("hello there");
	}
	private static final void test(String to_search)  {
		System.out.print("\"" + to_search + "\": ");
		if(mtchr1PlusLetterDigitSpc.reset(to_search).matches()  &&  !mtchr0PlusSpc.reset(to_search).matches())  {
			System.out.println("good");
		}  else  {
			System.out.println("BAD");
		}
	}
}

