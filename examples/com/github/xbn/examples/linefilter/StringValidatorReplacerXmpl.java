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
package  com.github.xbn.examples.linefilter;
	import  com.github.xbn.analyze.alter.AlterationRequired;
	import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
	import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
	import  com.github.xbn.regexutil.ReplacedInEachInput;
	import  com.github.xbn.regexutil.StringValidatorReplacer;
	import  java.util.regex.Pattern;
/**
	<P>Uses a {@code com.github.xbn.regexutil.}{@link com.github.xbn.regexutil.StringValidatorReplacer StringValidatorReplacer} and {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.FilterValidCounts FilterValidCounts} to replace the second-through-fourth occurances of a string.</P>

	<P>{@code java com.github.xbn.examples.linefilter.StringValidatorReplacerXmpl}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class StringValidatorReplacerXmpl  {
	public static final void main(String[] ignored)  {
		System.out.println("Replacing 2nd-through-4th \"T.\" with \"The\"");

		ValidResultFilter vrf = NewValidResultFilterFor.inUnchangedOutFalse(2, 4, null, null,
			null);     //<--Debug filter: System.out. No debug: null

		StringValidatorReplacer svrTDotToThe234 = AdaptRegexReplacerTo.stringValidator(
			AlterationRequired.YES, Pattern.compile("T.", Pattern.LITERAL),
			"The", ReplacedInEachInput.FIRST, vrf,
				null);  //<--Debug

		for(int i = 0; i < 10; i++)  {
			String sKTF = "Kermit T. Frog";
			if(svrTDotToThe234.isValid(sKTF))  {
				sKTF = svrTDotToThe234.getMostRecent();
			}
			System.out.println(sKTF);
		}
	}
}
