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
/**
	<P>Regex demonstration: Match digits iterspersed throughout an input string that, when joined together, are between 2000 and 4999.</P>

	<P>{@code java com.github.xbn.examples.regexutil.non_xbn.Regex2000To4999Xmpl}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class Regex2000To4999Xmpl  {
	public static final void main(String[] ignored)  {

		Pattern p = Pattern.compile("^([2-4])\\.\\s+(\\d\\d\\d)\\s+ae$");

		String sD1d2 = "$1$2";

		replace(p, "5. 282 ae", sD1d2);
		replace(p, "3. 278 ae", sD1d2);
		replace(p, "4. 113 ae", sD1d2);
	}
	public static final void replace(Pattern to_findPtrn, String text_toSearch, String rplc_with)  {
		System.out.println(to_findPtrn.matcher(text_toSearch).replaceFirst(rplc_with));
	}
}
