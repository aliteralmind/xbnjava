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
package  com.github.xbn.analyze.validate;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>Exactly what determined the valid-result in a <CODE>Validator</CODE>?: The pre-filter, the validator's rules, or the post-filter?.</P>

	@see  ValidResultFilter
	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum ResultReturnedBy {
	/**
		<P>The valid-result was determined by the pre-filter--the <I>something</I> was never validated against the rules.</P>

		@see  #RULES
		@see  #isPreFilter()
	 **/
	PRE_FILTER,
	/**
		<P>The valid-result was determined by whether the <I>something</I> actually conforms to the (post-inverted) rules.</P>

		@see  #PRE_FILTER
		@see  #POST_FILTER
		@see  #isRules()
		@see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
	 **/
	RULES,
	/**
		<P>The valid-result was determined by the post-filter--although the <I>something</I> was validated against the rules, that result was ignored.</P>

		@see  #RULES
		@see  #isPostFilter()
	 **/
	POST_FILTER;
	/**
		<P>Is this {@code ResultReturnedBy} equal to {@code PRE_FILTER}?.</P>

		@return  <CODE>this == {@link #PRE_FILTER}</CODE>

		@see  #isRules()
		@see  #isPostFilter()
	 **/
	public final boolean isPreFilter()  {
		return  this == PRE_FILTER;
	}
	/**
		<P>Is this {@code ResultReturnedBy} equal to {@code RULES}?.</P>

		@return  <CODE>this == {@link #RULES}</CODE>
		@see  #isPreFilter()
	 **/
	public final boolean isRules()  {
		return  this == RULES;
	}
	/**
		<P>Is this {@code ResultReturnedBy} equal to {@code POST_FILTER}?.</P>

		@return  <CODE>this == {@link #POST_FILTER}</CODE>
		@see  #isPreFilter()
	 **/
	public final boolean isPostFilter()  {
		return  this == POST_FILTER;
	}
	/**
		<P>If an <CODE>ResultReturnedBy</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;ResultReturnedBy&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfForbiddenValue(ResultReturnedBy, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(ResultReturnedBy rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<P>If an <CODE>ResultReturnedBy</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;ResultReturnedBy&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(ResultReturnedBy, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(ResultReturnedBy rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
};
