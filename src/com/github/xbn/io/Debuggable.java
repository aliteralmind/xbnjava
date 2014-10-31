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
package  com.github.xbn.io;
	import  com.github.xbn.io.z.GetDebugApbl_Fieldable;
/**
	<P>{@code Debuggable}-s provide optional run-time diagnostics.</P>

	@author  Copyright (C) 2014, Jeff Epstein. Released under the LPGL 2.1. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Debuggable extends GetDebugApbl_Fieldable  {
//setters......START
	/**
		<P>Set the writer for debugging output.</P>

		@param  destination  If {@code null}, this also calls {@link #setDebugOn(boolean) setDebugOn(false)}. Get with {@link #getDebugAptr() getDebugAptr}{@code ()}.
	 **/
	void setDebug(Appendable destination, boolean is_on);
	/**
		<P>Turn debugging on or off.</P>

		@param  is_on  If {@code true}, debugging is turned on. Get with {@link #isDebugOn() isDebugOn}{@code ()}.
		@exception  IllegalStateException  If {@link #getDebugAptr() getDebugAptr}{@code ()} is {@code null}.
	 **/
	void setDebugOn(boolean is_on);
//setters......END
//getters...START
	/**
		<P>Is debugging active?.</P>

		@see  #setDebugOn(boolean)
	 **/
	boolean isDebugOn();
	/**
		<P>Get the current debug-writer, <I>which throws {@code RuntimeException}-s only</I>.</P>

		@see  #setDebug(Appendable, boolean)
	 **/
	TextAppenter getDebugAptr();
	Appendable getDebugApbl();
	TextAppenter debug(Object message);
	void debugln(Object message);
//getters...END
}
