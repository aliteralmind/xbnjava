/*license*\
	XBN-Java: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.linefilter.entity.z;
	import  com.github.xbn.linefilter.entity.StealthBlockEntity;
	import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
	<p>For directly configuring a {@link com.github.xbn.linefilter.entity.StealthBlockEntity StealthBlockEntity}.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class StealthBlockEntity_Cfg extends StealthBlockEntity_CfgForNeeder<StealthBlockEntity,DummyForNoNeeder>  {
	/**
		<p>Create a new stealth block.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="SingleLineEntity_CfgForNeeder.html#BlockEntity_CfgForNeeder(R, java.lang.String)">super</a>(null, name_ifNonNull)</code></p>

		@param  name_ifNonNull  Descriptive name of this block. If {@code null}, defaults to {@code "stealthblock"}.
	 **/
	public StealthBlockEntity_Cfg(String name_ifNonNull)  {
		super(null, ((name_ifNonNull == null) ? "stealthblock"
			: name_ifNonNull));
	}
}
