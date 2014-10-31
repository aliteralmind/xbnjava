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
package  com.github.xbn.linefilter.entity;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>Should the entity be turned on or off, or should the {@code FilteredIterator} be stopped entirely (all remaining lines are discarded)?.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum OnOffAbort  {
	/**
		<P>YYY.</P>

		@see  #OFF
		@see  #ABORT_ITERATOR
		@see  #isOn()
	 **/
	ON,
	/**
		<P>YYY.</P>

		@see  #ON
		@see  #isOff()
	 **/
	OFF,
	/**
		<P>YYY.</P>

		@see  #ON
		@see  #doAbortIterator()
	 **/
	ABORT_ITERATOR;
	/**
		<P>Is this {@code OnOffAbort} equal to {@code ON}?.</P>

		@return  <CODE>this == {@link #ON}</CODE>

		@see  #isOff()
		@see  #doAbortIterator()
	 **/
	public final boolean isOn()  {
		return  this == ON;
	}
	/**
		<P>Is this {@code OnOffAbort} equal to {@code OFF}?.</P>

		@return  <CODE>this == {@link #OFF}</CODE>
		@see  #isOn()
	 **/
	public final boolean isOff()  {
		return  this == OFF;
	}
	/**
		<P>Is this {@code OnOffAbort} equal to {@code ABORT_ITERATOR}?.</P>

		@return  <CODE>this == {@link #ABORT_ITERATOR}</CODE>
		@see  #isOn()
	 **/
	public final boolean doAbortIterator()  {
		return  this == ABORT_ITERATOR;
	}
	/**
		<P>If an <CODE>OnOffAbort</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfForbiddenValue(OnOffAbort, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(OnOffAbort e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
		<P>If an <CODE>OnOffAbort</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(OnOffAbort, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(OnOffAbort e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
