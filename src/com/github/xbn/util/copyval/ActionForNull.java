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
package  com.github.xbn.util.copyval;
/**
	<p>The action taken when attempting to duplicate a value that is {@code null}.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum ActionForNull {
	/**
		<p>The duplicate should also be {@code null}.</p>

		@see  #USE_NON_NULL
		@see  #DELETE
		@see  #CRASH
		@see  #doUseNull()
	 **/
	USE_NULL,
	/**
		<p>The duplicate should be set to a pre-configured non-{@code null} value.</p>

		@see  #USE_NULL
		@see  #doUseNonNull()
		@see  NullHandler#getNonNull()
	 **/
	USE_NON_NULL,
	/**
		<p>The duplicate should not be created.</p>

		@see  #USE_NULL
		@see  #doDelete()
	 **/
	DELETE,
	/**
		<p>Throw an exception.</p>

		@see  #USE_NULL
		@see  #doCrash()
	 **/
	CRASH;
	/**
		<p>Is this {@code eCllLstAryOthr} equal to {@code USE_NULL}?.</p>

		@return  <code>this == {@link #USE_NULL}</code>

		@see  #doUseNonNull()
		@see  #doDelete()
		@see  #doCrash()
	 **/
	public final boolean doUseNull()  {
		return  this == USE_NULL;
	}
	/**
		<p>Is this {@code eCllLstAryOthr} equal to {@code USE_NON_NULL}?.</p>

		@return  <code>this == {@link #USE_NON_NULL}</code>
		@see  #doUseNull()
	 **/
	public final boolean doUseNonNull()  {
		return  this == USE_NON_NULL;
	}
	/**
		<p>Is this {@code eCllLstAryOthr} equal to {@code DELETE}?.</p>

		@return  <code>this == {@link #DELETE}</code>
		@see  #doUseNull()
		@see  #isNparray()
	 **/
	public final boolean doDelete()  {
		return  this == DELETE;
	}
	/**
		<p>Is this {@code eCllLstAryOthr} equal to {@code CRASH}?.</p>

		@return  <code>this == {@link #CRASH}</code>
		@see  #doUseNull()
		@see  #isParray()
	 **/
	public final boolean doCrash()  {
		return  this == CRASH;
	}
};
