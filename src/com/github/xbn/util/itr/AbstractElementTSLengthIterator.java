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
	import  com.github.xbn.util.itr.IteratorDirection;
	import  com.github.xbn.array.CrashIfIndex;
/**
	<P>For building iterators that return, for each element in an indexable container, the <I>length</I> of its {@code toString()}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractElementTSLengthIterator<R> extends AbstractIndexableIterator<R,Integer>  {
//constructors...START
	public AbstractElementTSLengthIterator(Object indexable_cntrOfR)  {
		this(indexable_cntrOfR, 0, -1, IteratorDirection.LOW_TO_HIGH);
	}
	public AbstractElementTSLengthIterator(Object indexable_cntrOfR, IteratorDirection direction)  {
		this(indexable_cntrOfR, 0, -1, direction);
	}
	/**
		<P>Create a new {@code AbstractIsValidElementIterator}.</P>

		YYY

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.util.itr.AbstractIndexableIterator#AbstractIndexableIterator(Object, int, int) super}{@code (indexable_cntrOfR, idx_start, idx_endX)}</P>
	 **/
	public AbstractElementTSLengthIterator(Object indexable_cntrOfR, int idx_start, int idx_endX)  {
		super(indexable_cntrOfR, idx_start, idx_endX, IteratorDirection.LOW_TO_HIGH);
	}
	public AbstractElementTSLengthIterator(Object indexable_cntrOfR, int idx_start, int idx_endX, IteratorDirection direction)  {
		super(indexable_cntrOfR, idx_start, idx_endX, direction);
	}
//constructors...END
	public final Integer next()  {
		R r = null;
		try  {
			r = getRawElementRTXOkay(getIndex());
		}  catch(RuntimeException rx)  {
			CrashIfIndex.badForLength(getIndex(), getTotalElementCount(), "index", XBL_CNTR_OF_R_NAME);
			throw  rx;
		}
		moveIndexToNext();
		return  ((r == null) ? null : r.toString().length());
	}
/*stub functions for non-abstract compile...START
	protected R getRawElementRTXOkay(int index)  {
		return  null;
	}
	public int getTotalElementCount()  {
		return  -1;
	}
 stub functions for non-abstract compile...END*/
}
