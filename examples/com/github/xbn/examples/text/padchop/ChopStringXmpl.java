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
package  com.github.xbn.examples.text.padchop;
	import  com.github.xbn.text.padchop.ChopString;
	import  com.github.xbn.text.padchop.z.ChopString_Cfg;
/**
	<P>Demonstration of {@code com.github.xbn.text.padchop.}{@link com.github.xbn.text.padchop.ChopString ChopString}.</P>

	<P>{@code java com.github.xbn.examples.text.padchop.ChopStringXmpl}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ChopStringXmpl  {
	public static final void main(String[] ignored)  {
								//28 characters
		String sToChop = "Hi Ho! Kermit The Frog here.";
			System.out.println("Original: \"" + sToChop + "\"");
			System.out.println();

		System.out.println("--Chop to 20 characters (original " + sToChop.length() + ")");

			ChopString cs = new ChopString_Cfg(20).build();
			System.out.println(cs.getChopped(sToChop));
			System.out.println();

		System.out.println("--With ellipsis:");

			new ChopString_Cfg(20).ddd().build().
				appendChoppedlns(2, System.out, sToChop);

		System.out.println("--Hanging ellipsis:");

			new ChopString_Cfg(20).ddd().maxOverhang().build().
				appendChoppedlns(2, System.out, sToChop);

		System.out.println("--Custom (and flush) ellipsis:");

			new ChopString_Cfg(20).ddd("~~~").noOverhang().build().
				appendChoppedlns(2, System.out, sToChop);
	}
}
