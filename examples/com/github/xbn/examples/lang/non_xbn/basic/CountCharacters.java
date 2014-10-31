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
package  com.github.xbn.examples.lang.non_xbn.basic;
/**
	<P>Find the number of uppercase characters and '<CODE>a</CODE>'s (both lower and uppercase) in a string.</P>

	<P>{@code java com.github.xbn.examples.lang.non_xbn.basic.CountCharacters}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CountCharacters {
	public static void main(String[] ignored) {
	charCount("How many UPPER CASE letters, a's, and 0-9 digits are there in this String?");
	}

public static void charCount(String b) {
	int upper = 0;
	int a = 0;
	for (int i = 0; i < b.length(); i++) {
		char v = b.charAt(i);
		if(v == 'a'  ||  v == 'A')  {
			a++;
		}
		if(Character.isUpperCase(v))  {
			upper++;
		}
	}
	System.out.println("There are " + upper + " upper case letters, and " + a + " lower case a's in the String");


	}
}