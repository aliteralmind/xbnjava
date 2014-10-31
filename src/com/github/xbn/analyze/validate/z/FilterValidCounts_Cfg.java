/*license*\
	XBN-Java is a collection of generically-useful non-GUI programming utilities, featuring shareable self-returning method chains, "Listify"-ers, regular expression convenience classes, FilterValidCounts and ValueAlterer, highly-configurable output for strings and lists, and unit-testing example code.

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
package  com.github.xbn.analyze.validate.z;
	import  com.github.xbn.neederneedable.DummyForNoNeeder;
	import  com.github.xbn.analyze.validate.FilterValidCounts;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link com.github.xbn.analyze.validate.FilterValidCounts FilterValidCounts}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FilterValidCounts_Cfg extends FilterValidCounts_CfgForNeeder<FilterValidCounts,DummyForNoNeeder>  {
	public FilterValidCounts_Cfg()  {
		super(false, true, null);
	}
}
