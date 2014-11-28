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
package  com.github.xbn.analyze.alter;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>Is it required that the elements in an {@code ExpirableAlterList} are expirable?.</P>

	@see  ExpirableAlterList
	@see  com.github.xbn.lang.Expirable#doesExpire()
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum ExpirableElements  {
	/**
		<P>Allow non-expirable elements.</P>

		@see  #REQUIRED
		@see  #isOptional()
	 **/
	OPTIONAL,
	/**
		<P>Do not allow.</P>

		@see  #OPTIONAL
		@see  #isRequired()
	 **/
	REQUIRED;
	/**
		<P>Is this {@code ExpirableElements} equal to {@code OPTIONAL}?.</P>

		@return  <CODE>this == {@link #OPTIONAL}</CODE>

		@see  #isRequired()
	 **/
	public final boolean isOptional()  {
		return  this == OPTIONAL;
	}
	/**
		<P>Is this {@code ExpirableElements} equal to {@code REQUIRED}?.</P>

		@return  <CODE>this == {@link #REQUIRED}</CODE>
		@see  #isOptional()
	 **/
	public final boolean isRequired()  {
		return  this == REQUIRED;
	}
	/**
		<P>If an <CODE>ExpirableElements</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
		@see  #crashIfForbiddenValue(ExpirableElements, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<P>If an <CODE>ExpirableElements</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(ExpirableElements, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
};
