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
	import  com.github.xbn.linefilter.entity.BlockEntity;
	import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link com.github.xbn.linefilter.entity.BlockEntity BlockEntity}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BlockEntity_Cfg extends BlockEntity_CfgForNeeder<BlockEntity,DummyForNoNeeder>  {
	/**
		<P>Create a new block.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="BlockEntity_CfgForNeeder.html#BlockEntity_CfgForNeeder(R, java.lang.String)">super</A>(null, name_ifNonNull)</CODE></P>

		@param  name_ifNonNull  Descriptive name of this block. If {@code null}, defaults to {@code "block"}.
	 **/
	public BlockEntity_Cfg(String name_ifNonNull)  {
		super(null, ((name_ifNonNull == null) ? "block"
			: name_ifNonNull));
	}
}
