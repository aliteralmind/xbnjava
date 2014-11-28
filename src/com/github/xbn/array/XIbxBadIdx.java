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
package  com.github.xbn.array;
	import  com.github.xbn.text.StringWithNullDefault;
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  com.github.xbn.lang.CrashIfObject;
/**
	<P>Data related to an {@code XbnIndexOutOfBoundsException} when a single <I>index</I> is bad.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XIbxBadIdx extends XIbxData  {
	private int    iBadIdx   = -1  ;
	private String sBadIdxNm = null;
	public XIbxBadIdx(int index)  {
		this(index, null);
	}
	public XIbxBadIdx(int index, String idx_name)  {
		super();
		iBadIdx   = index;
		sBadIdxNm = idx_name;
	}
	public int getBadIndex()  {
		return  iBadIdx;
	}
	public String getBadIndexName()  {
		return  sBadIdxNm;
	}
	public void ciNOTBadForAbsBounds_forCfgBuild()  {
		XIbxBadIdx.ciNOTBadForAbsBounds_forCfgBuild(this);
	}
	public static final void ciNOTBadForAbsBounds_forCfgBuild(XIbxBadIdx bad_idx)  {
		try  {
			if(bad_idx.getBadIndex() >= bad_idx.getAbsMin()  &&
					bad_idx.getBadIndex() < bad_idx.getAbsMaxX())  {
				throw  new IllegalArgumentStateException("The 'bad' index is not bad! getBadIndex()=" + bad_idx.getBadIndex() + ", getAbsMin()=" + bad_idx.getAbsMin() + ", getAbsMaxX()=" + bad_idx.getAbsMaxX());
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(bad_idx, "bad_idx", null, rx);
		}
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		super.appendToString(to_appendTo).append(", ");
		StringWithNullDefault.append(to_appendTo, getBadIndexName(), "[bad-index]");

		return  to_appendTo.append("=").append(getBadIndex());
	}
}
