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

package  com.github.xbn.util.copyval;
/**
   <P>Convenience functions for creating {@code NullHandler}s.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewNullHandlerFor  {
   private NewNullHandlerFor()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<P>A new null handler that always crashes when attempting to use a {@code null} value.</P>

		@return  <CODE>{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives SimpleNullHandlerForPrimitives}.{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives#CRASH CRASH}</CODE>
	 **/
	public static final NullHandlerForPrimitives crash()  {
		return  SimpleNullHandlerForPrimitives.CRASH;
	}
	/**
		<P>A new null handler that always deletes the potentially-{@code null} value from the duplicate (array, list, or other container).</P>

		@return  <CODE>{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives SimpleNullHandlerForPrimitives}.{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives#DELETE DELETE}</CODE>
	 **/
	public static final NullHandlerForPrimitives delete()  {
		return  SimpleNullHandlerForPrimitives.DELETE;
	}
	/**
		<P>A new null handler that always deletes the potentially-{@code null} value from the duplicate (array, list, or other container).</P>

		@return  <CODE>{@link com.github.xbn.util.copyval.SimpleNullHandler SimpleNullHandler}.{@link com.github.xbn.util.copyval.SimpleNullHandler#USE_NULL USE_NULL}</CODE>
	 **/
	public static final NullHandler useNull()  {
		return  SimpleNullHandler.USE_NULL;
	}
}