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
package  com.github.xbn.examples.analyze.validate;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
	import  com.github.xbn.analyze.validate.NewValueValidatorFor;
/**
   <P>Blindly determine that the first <I>something</I> is valid, and then expire the validator, making all subsequent items invalid.</P>

	<P>{@code java com.github.xbn.examples.analyze.validate.FirstCheckIsAlwaysValidThenExpireXmpl}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class FirstCheckIsAlwaysValidThenExpireXmpl  {
   public static final void main(String[] ignored)  {

		//Set the valid-filter range to be min 1, max 1.
		ValidResultFilter vrf = NewValidResultFilterFor.inUnchangedOutFalse(1, 1, null, null,
			null);  //Debug on: System.out, Off: null

		ValueValidator<Object> vvo = NewValueValidatorFor.<Object>unrestricted(vrf,
			null);  //Debug

		for(int i = 1; i <= 10; i++)  {
			System.out.println(i + " " + vvo.isValid("anything"));
		}
	}
}