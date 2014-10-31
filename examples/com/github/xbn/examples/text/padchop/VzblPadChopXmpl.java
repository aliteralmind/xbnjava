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
	import  com.github.xbn.text.padchop.VzblPadChop;
	import  com.github.xbn.text.padchop.z.VzblPadChop_Cfg;
/**
	<P>Uses {@code com.github.xbn.text.padchop.}{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop} to trim, pad, and chop a string.</P>

	<P>{@code java com.github.xbn.examples.text.padchop.VzblPadChopXmpl}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class VzblPadChopXmpl  {
	public static final void main(String[] ignored)  {
		String s = "Hi Ho! Kermit The Frog here.";

		System.out.println("Chop right to 15, then pad left to 30");
			VzblPadChop padchop = new VzblPadChop_Cfg().
				cfgPad(true, 30).left().endCfg().
				cfgChop(true, 15).ddd().endCfg().
				chopFirst().trimLeft().build();
			System.out.println("[" + padchop.get(s) + "]");
			System.out.println();

		System.out.println("Pad right to 30, chop left to 15");
			new VzblPadChop_Cfg().padFirst().  //debugTo(System.out).
					cfgPad(30).endCfg().
					cfgChop(15).left().endCfg().build().
				appendlns(1, System.out, "[", s, "]");
	}
}
