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
/**
	<p>Has optional extra information intended for display at the end of error messages.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface ExtraErrInfoable  {
	/**
		<p>Set optional extra error infromation</p>

		@param  info  Get with {@link #getExtraErrInfo() getExtraErrInfo}{@code ()}.
	 **/
	void setExtraErrInfo(Object info);
	/**
		<p>Get the optional extra error information.</p>

		@return  <ul>
			<li>A non-{@code null} object, whose {@code toString()} should be appended to the end of error messages.</li>
			<li>{@code null}: If there is no extra information.</li>
		</ul>This is not intended to be displayed in any object's {@code toString()}, or considered when comparing objects for equality or ordering.
		@see  #setExtraErrInfo(Object)
	 **/
	Object getExtraErrInfo();
}
