/*license*\
	XBN-Java Library

	Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

	This software is dual-licensed under the:
	- Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
	- Apache Software License (ASL) version 2.0.

	Either license may be applied at your discretion. More information may be found at
	- http://en.wikipedia.org/wiki/Multi-licensing.

	The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
	- LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
	- ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.analyze.validate;
	import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Convenience functions for {@code ValidResultFilter}s.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class ValidResultFilterUtil  {
	private ValidResultFilterUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<P>Get the final is-valid value from the filter and post-inverted follows-rules boolean.</P>

		<P>This calls<OL>
			<LI><CODE>filter.{@link ValidResultFilter#getAfterValueFromInvertedRules(boolean) getAfterValueFromInvertedRules}(are_postInvertRulesFollowed)</CODE></LI>
			<LI><CODE>getPostReturnValueFromInvertedRules(<I>[return-value-from-step-1]</I>, are_postInvertRulesFollowed)</CODE></LI>
		</OL></P>

		@param  filter  May not be {@code null}.
		@param  are_postInvertRulesFollowed  Does the <I>something</I> follow the rules (post-{@link com.github.xbn.analyze.validate.Validator#doInvertRules() inversion})?
		@see  #getPostReturnValueFromInvertedRules(FilterAfterValue, boolean) getPostReturnValueFromInvertedRules(fpv,b)
	 **/
	public static final boolean getPostReturnValueFromInvertedRules(ValidResultFilter filter, boolean are_postInvertRulesFollowed)  {
		FilterAfterValue fpv = null;
		try  {
			fpv = filter.getAfterValueFromInvertedRules(are_postInvertRulesFollowed);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(filter, "filter", null, rx);
		}
		return  getPostReturnValueFromInvertedRules(fpv, are_postInvertRulesFollowed);
	}
	/**
		<P>Get the final is-valid value from the post-inverted rules.</P>

		@return  <CODE>(fp_v.{@link FilterAfterValue#isUnchanged() isUnchanged}() ? are_postInvertRulesFollowed : fp_v.{@link FilterAfterValue#isTrue() isTrue}())</CODE>
		@see  #getPostReturnValueFromInvertedRules(ValidResultFilter, boolean) getPostReturnValueFromInvertedRules(vrf,b)
	 **/
	public static final boolean getPostReturnValueFromInvertedRules(FilterAfterValue fp_v, boolean are_postInvertRulesFollowed)  {
		return  (fp_v.isUnchanged() ? are_postInvertRulesFollowed : fp_v.isTrue());
	}
}
