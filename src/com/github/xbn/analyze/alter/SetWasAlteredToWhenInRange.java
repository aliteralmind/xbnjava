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
/**
	<P>In {@code ReturnValueUnchanged} only, after each call to <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/alter/ReturnValueUnchanged.html#getAltered(V, A)">getAltered</A>(V,A)</CODE>, what should its {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#wasAltered() wasAltered}{@code ()} flag be set to?.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum SetWasAlteredToWhenInRange {
	/**
		<P>Set {@code wasAltered()} to {@code false}.</P>

		@see  #FALSE
		@see  #isTrue()
	 **/
	TRUE,
	/**
		<P>Set {@code wasAltered()} to {@code true}.</P>

		@see  #TRUE
		@see  #isFalse()
	 **/
	FALSE;
	/**
		<P>Is this {@code SetWasAlteredToWhenInRange} equal to {@code TRUE}?.</P>

		@return  <CODE>this == {@link #TRUE}</CODE>

		@see  #isFalse()
	 **/
	public final boolean isTrue()  {
		return  this == TRUE;
	}
	/**
		<P>Is this {@code SetWasAlteredToWhenInRange} equal to {@code FALSE}?.</P>

		@return  <CODE>this == {@link #FALSE}</CODE>
		@see  #isTrue()
	 **/
	public final boolean isFalse()  {
		return  this == FALSE;
	}
};
