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
package  com.github.xbn.text.padchop;
	import  com.github.xbn.util.EnumUtil;
/**
	<p>The escape-action to be taken on a string: escape, unescape, or do-nothing.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum EscapeAction  {
	/**
		<p>EscapeAction control characters so they literally display.</p>

		@see  #NOTHING
		@see  #UNESCAPE
		@see  #isEscape()
	 **/
	ESCAPE,
	/**
		<p>Leave all control characters unchanged.</p>

		@see  #ESCAPE
		@see  #isNothing()
	 **/
	NOTHING,
	/**
		<p>Unescape literally-displaying control characters.</p>

		@see  #ESCAPE
		@see  #isUnescape()
	 **/
	UNESCAPE;
	/**
		<p>Is this {@code EscapeAction} equal to {@code ESCAPE}?.</p>

		@return  <code>this == {@link #ESCAPE}</code>

		@see  #isUnescape()
		@see  #isNothing()
	 **/
	public final boolean isEscape()  {
		return  this == ESCAPE;
	}
	/**
		<p>Is this {@code EscapeAction} equal to {@code NOTHING}?.</p>

		@return  <code>this == {@link #NOTHING}</code>
		@see  #isEscape()
	 **/
	public final boolean isNothing()  {
		return  this == NOTHING;
	}
	/**
		<p>Is this {@code EscapeAction} equal to {@code UNESCAPE}?.</p>

		@return  <code>this == {@link #UNESCAPE}</code>
		@see  #isEscape()
	 **/
	public final boolean isUnescape()  {
		return  this == UNESCAPE;
	}
	/**
		<p>If an <code>EscapeAction</code> is not a required value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;EscapeAction&quot;, xtra_errInfo)</code></p>
		@see  #crashIfForbiddenValue(EscapeAction, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(EscapeAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<p>If an <code>EscapeAction</code> is a forbidden value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;EscapeAction&quot;, xtra_errInfo)</code></p>
		@see  #crashIfNotRequiredValue(EscapeAction, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(EscapeAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
}
