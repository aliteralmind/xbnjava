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
package  com.github.xbn.array.helper;
	import  com.github.xbn.number.CrashIfIntIs;
	import  org.apache.commons.lang3.ArrayUtils;
/**
	<p>{@code ArrayHelper} for objects.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
@SuppressWarnings("unchecked")
public class ObjectArrayHelper extends AbstractArrayHelper<Object>  {
	public ObjectArrayHelper()  {
		super(Object[].class);
	}
	public Object[] getInitialized(int length)  {
		if(length == 0)  {
			return  getEmpty();
		}
		try  {
			return  (new StringBuilder[length]);
		}  catch(RuntimeException rx)  {
			throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
		}
	}
	public Object[] getEmpty()  {
		return  ArrayUtils.EMPTY_OBJECT_ARRAY;
	}
}