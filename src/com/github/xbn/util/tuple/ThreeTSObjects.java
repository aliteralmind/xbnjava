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
package  com.github.xbn.util.tuple;
/**
	<P>Holds three objects.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ThreeTSObjects extends TwoTSObjects  {
	private Object o3;
//constructors...START
	public ThreeTSObjects(Object o_1, Object o_2, Object o_3)  {
		this("ThreeTSObjects", o_1, o_2, o_3);
	}
	protected ThreeTSObjects(String this_classesNonFQClsNmForErrMsg, Object o_1, Object o_2, Object o_3)  {
		super(this_classesNonFQClsNmForErrMsg, o_1, o_2);
		set3(o_3);
	}
//constructors...END
	public Object get3()  {
		return  o3;
	}
	public ThreeTSObjects set3(Object o_3)  {
		o3 = o_3;
		return  this;
	}
	public ThreeTSObjects set(Object o_1, Object o_2, Object o_3)  {
		set(o_1, o_2);
		return  set3(o_3);
	}
	public String getJoined()  {
		return  appendJoined(new StringBuilder(), get3()).toString();
	}
}