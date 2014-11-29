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
	<p>Should the entity be turned on or off, or should the {@code FilteredIterator} be stopped entirely (all remaining lines are discarded)?.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum OnOffAbort  {
	/**
		<p>YYY.</p>

		@see  #OFF
		@see  #ABORT_ITERATOR
		@see  #isOn()
	 **/
	ON,
	/**
		<p>YYY.</p>

		@see  #ON
		@see  #isOff()
	 **/
	OFF,
	/**
		<p>YYY.</p>

		@see  #ON
		@see  #doAbortIterator()
	 **/
	ABORT_ITERATOR;
	/**
		<p>Is this {@code OnOffAbort} equal to {@code ON}?.</p>

		@return  <code>this == {@link #ON}</code>

		@see  #isOff()
		@see  #doAbortIterator()
	 **/
	public final boolean isOn()  {
		return  this == ON;
	}
	/**
		<p>Is this {@code OnOffAbort} equal to {@code OFF}?.</p>

		@return  <code>this == {@link #OFF}</code>
		@see  #isOn()
	 **/
	public final boolean isOff()  {
		return  this == OFF;
	}
	/**
		<p>Is this {@code OnOffAbort} equal to {@code ABORT_ITERATOR}?.</p>

		@return  <code>this == {@link #ABORT_ITERATOR}</code>
		@see  #isOn()
	 **/
	public final boolean doAbortIterator()  {
		return  this == ABORT_ITERATOR;
	}
	/**
		<p>If an <code>OnOffAbort</code> is not a required value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
		@see  #crashIfForbiddenValue(OnOffAbort, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(OnOffAbort e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
		<p>If an <code>OnOffAbort</code> is a forbidden value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
		@see  #crashIfNotRequiredValue(OnOffAbort, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(OnOffAbort e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
