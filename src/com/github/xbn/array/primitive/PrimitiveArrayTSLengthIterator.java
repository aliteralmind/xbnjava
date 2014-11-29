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
package  com.github.xbn.array.primitive;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.util.itr.AbstractElementTSLengthIterator;
/**
	<p>Iterator that returns the <i>digit count</i> for elements in numeric primitive arrays (ints, longs, floats, etcetera). This is a simple casting of the element to a string, and then retrieving its length. Therefore, the negative and decimal symbols are each counted as one.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PrimitiveArrayTSLengthIterator<R> extends AbstractElementTSLengthIterator<R>  {
	private PrimitiveArrayHelper<R> pah = null;
	public PrimitiveArrayTSLengthIterator(Object obj_thatIsPrimArr, PrimitiveArrayHelper<R> array_helper)  {
		super(obj_thatIsPrimArr);
		if(array_helper == null)  {
			throw  new NullPointerException("array_helper");
		}
		pah = array_helper;
	}
	protected R getRawElementRTXOkay(int index)  {
		return  pah.getWrapper(getContainer(), index, XBL_CNTR_OF_R_NAME);
	}
	public int getTotalElementCount()  {
		return  pah.getLength(getContainer(), XBL_CNTR_OF_R_NAME);
	}
}
