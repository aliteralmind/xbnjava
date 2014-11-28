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
package  com.github.xbn.linefilter;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>What should be returned by the filtered line iterator?.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum Returns  {
	/**
		<P>YYY.</P>

		@see  #ACTIVE
		@see  #ALL
		@see  #isKept()
	 **/
	KEPT,
	/**
		<P>YYY.</P>

		@see  #KEPT
		@see  #isActive()
	 **/
	ACTIVE,
	/**
		<P>YYY.</P>

		@see  #KEPT
		@see  #isAll()
	 **/
	ALL;
	/**
		<P>Is this {@code Returns} equal to {@code KEPT}?.</P>

		@return  <CODE>this == {@link #KEPT}</CODE>

		@see  #isActive()
		@see  #isAll()
	 **/
	public final boolean isKept()  {
		return  this == KEPT;
	}
	/**
		<P>Is this {@code Returns} equal to {@code ACTIVE}?.</P>

		@return  <CODE>this == {@link #ACTIVE}</CODE>
		@see  #isKept()
	 **/
	public final boolean isActive()  {
		return  this == ACTIVE;
	}
	/**
		<P>Is this {@code Returns} equal to {@code ALL}?.</P>

		@return  <CODE>this == {@link #ALL}</CODE>
		@see  #isKept()
	 **/
	public final boolean isAll()  {
		return  this == ALL;
	}
	/**
		<P>If a <CODE>Returns</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfForbiddenValue(Returns, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(Returns e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
		<P>If a <CODE>Returns</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(Returns, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(Returns e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
