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
package  com.github.xbn.analyze.validate.z;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.analyze.validate.NullnessValidator;
	import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring {@code com.github.xbn.analyze.validate.ValueValidator ValueValidator}s that only check null-ness.</P>


	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValueValidator_Cfg<O> extends ValueValidator_CfgForNeeder<O,NullnessValidator<O>,DummyForNoNeeder>  {
	public ValueValidator_Cfg()  {
		super(false, true, null);
	}
	@SuppressWarnings("unchecked")
	public static final <O> ValueValidator_CfgForNeeder<O,NullnessValidator<O>,DummyForNoNeeder> newSameFieldsAs(ValueValidator<O> validator)  {
		try  {
			return  new ValueValidator_Cfg<O>().nullOk(validator.isNullOk()).invert(validator.doInvertRules()).extraErrInfo(validator.getExtraErrInfo()).filter(validator.getFilter()).debugTo(validator.getDebugAptr().getAppendable());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(validator, "validator", null, rx);
		}
	}
}
