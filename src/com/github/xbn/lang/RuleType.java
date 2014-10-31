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
package  com.github.xbn.lang;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>How restrictive is a {@code Ruleable} object?.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum RuleType {
	/**
		<P>It is not possible to violate the rules.</P>

		@see  #RESTRICTED
		@see  #IMPOSSIBLE
		@see  #isUnrestricted()
	 **/
	UNRESTRICTED,
	/**
		<P>It is possible to either follow or violate the rules.</P>

		@see  #UNRESTRICTED
		@see  #isRestricted()
	 **/
	RESTRICTED,
	/**
		<P>It is not possible to conform to the rules.</P>

		@see  #UNRESTRICTED
		@see  #isImpossible()
	 **/
	IMPOSSIBLE;
	/**
		<P>Is this {@code RuleType} equal to {@code UNRESTRICTED}?.</P>

		@return  <CODE>this == {@link #UNRESTRICTED}</CODE>

		@see  #isRestricted()
		@see  #isImpossible()
	 **/
	public final boolean isUnrestricted()  {
		return  this == UNRESTRICTED;
	}
	/**
		<P>Is this {@code RuleType} equal to {@code RESTRICTED}?.</P>

		@return  <CODE>this == {@link #RESTRICTED}</CODE>
		@see  #isUnrestricted()
	 **/
	public final boolean isRestricted()  {
		return  this == RESTRICTED;
	}
	/**
		<P>Is this {@code RuleType} equal to {@code IMPOSSIBLE}?.</P>

		@return  <CODE>this == {@link #IMPOSSIBLE}</CODE>
		@see  #isUnrestricted()
		@see  #isRestricted()
	 **/
	public final boolean isImpossible()  {
		return  this == IMPOSSIBLE;
	}
	/**
		<P>If an <CODE>RuleType</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;RuleType&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfForbiddenValue(RuleType, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(RuleType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<P>If an <CODE>RuleType</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;RuleType&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(RuleType, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(RuleType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
};
