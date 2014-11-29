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
package  com.github.xbn.util.itr;
/**
	<p>For building iterators on indexable containers, such as arrays and collections.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractIndexableIterator<R,E> extends UnchangingIndexesIterator<E>  {
//state
	private Object oCntr = null;
//internal
	protected static final String XBL_CNTR_OF_R_NAME = "[indexable_cntrOfR, as provided to the AbstractIndexableIterator constructor]";
	public AbstractIndexableIterator(Object indexable_cntrOfR)  {
		this(indexable_cntrOfR, IteratorDirection.LOW_TO_HIGH);
	}
	public AbstractIndexableIterator(Object indexable_cntrOfR, IteratorDirection direction)  {
		this(indexable_cntrOfR, 0, -1, direction);
	}
	public AbstractIndexableIterator(Object indexable_cntrOfR, int idx_start, int idx_endX)  {
		this(indexable_cntrOfR, idx_start, idx_endX, IteratorDirection.LOW_TO_HIGH);
	}
	public AbstractIndexableIterator(Object indexable_cntrOfR, int idx_start, int idx_endX, IteratorDirection direction)  {
		super(direction);
		if(indexable_cntrOfR == null)  {
			throw  new NullPointerException("indexable_cntrOfR");
		}
		oCntr = indexable_cntrOfR;
		declareIndexRange(idx_start, idx_endX);
	}
	protected Object getContainer()  {
		return  oCntr;
	}
	protected abstract R getRawElementRTXOkay(int index);
/*stub functions for non-abstract compile...START
	protected R getRawElementRTXOkay(int index)  {
		return  null;
	}
	public final E next()  {
		return  null;
	}
 stub functions for non-abstract compile...END*/
}
