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
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.array.CrashIfIndex;
	import  java.util.Iterator;
/**
	<P>Assists in building iterators over objects of a <I>known quantity</I> of indexable elements, such as arrays and collections--where the start and end indexes can be provided to the constructor, and do not change.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class UnchangingIndexesIterator<E> extends AbstractIterator<E> implements Iterator<E>  {
//state
	protected static final String CNTR_NAME = "[the object being iterated...length is getTotalElementCount()]";
	private IncDecIndexFunctor incDecFnctr;
	private final boolean isLowToHigh;
	public UnchangingIndexesIterator()  {
		this(IteratorDirection.LOW_TO_HIGH);
	}
	public UnchangingIndexesIterator(IteratorDirection direction)  {
		try  {
			isLowToHigh = direction.isLowToHigh();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(direction, "direction", null, rx);
		}
	}
	public boolean isLowToHigh()  {
		return  isLowToHigh;
	}
	protected void declareIndexRange(int idx_start, int idx_endX)  {
		if(idx_endX == -1)  {
			idx_endX = getTotalElementCount();
		}
		CrashIfIndex.rangeBadForLength(idx_start, idx_endX, getTotalElementCount(), "idx_start", "idx_endX", CNTR_NAME);
		incDecFnctr = (isLowToHigh()
			?  new IncrementIndex(idx_start, idx_endX)
			:  new DecrementIndex(idx_start, idx_endX));
	}
	protected void setIndex(int index)  {
		incDecFnctr.setIndex(index);
	}
	public int getIndex()  {
		return  incDecFnctr.getIndex();
	}
	public final boolean hasNext()  {
		return  incDecFnctr.hasNext();
	}
	public int getStartIndex()  {
		return  incDecFnctr.startIdx;
	}
	public int getEndIndexExcl()  {
		return  incDecFnctr.endIdxExcl;
	}
	protected void moveIndexToNext()  {
		incDecFnctr.moveIndexToNext();
	}
	protected void resetIndex()  {
		incDecFnctr.resetIndex();
	}
	/**
		<P>Must be abstract, because setIndexes optionally uses this.</P>
	 **/
	public abstract int getTotalElementCount();
/*stub functions for implements compile...START
	public int getTotalElementCount()  {
		return  -1;
	}
 stub functions for implements compile...END*/
}
abstract class IncDecIndexFunctor  {
	public final int startIdx;
	public final int endIdxExcl;
	protected int currIdx;
	public IncDecIndexFunctor(int start_idx, int end_idxX)  {
		startIdx = start_idx;
		endIdxExcl = end_idxX;
	}
	public int getIndex()  {
		return  currIdx;
	}
	public void setIndex(int index)  {
		crashIfBadIndex(index);
		currIdx = index;
	}
	protected abstract void crashIfBadIndex(int index);
	public abstract void moveIndexToNext();
	public abstract void resetIndex();
	public abstract boolean hasNext();
}
class DecrementIndex extends IncDecIndexFunctor  {
	public DecrementIndex(int start_idx, int end_idxX)  {
		super(start_idx, end_idxX);
		resetIndex();
	}
	public void moveIndexToNext()  {
		currIdx--;
	}
	public void resetIndex()  {
		currIdx = (endIdxExcl - 1);
	}
	public boolean hasNext()  {
		return  (getIndex() <= 0);
	}
	protected void crashIfBadIndex(int index)  {
		if(index < 0  ||  index >= getIndex())  {
			throw  new IllegalArgumentException("index (" + index + ") must be between zero-inclusive and getIndex() (" + getIndex() + ")-exclusive.");
		}
	}
}
class IncrementIndex extends IncDecIndexFunctor  {
	public IncrementIndex(int start_idx, int end_idxX)  {
		super(start_idx, end_idxX);
		currIdx = start_idx;
		resetIndex();
	}
	public void moveIndexToNext()  {
		currIdx++;
	}
	public void resetIndex()  {
		currIdx = startIdx;
	}
	public boolean hasNext()  {
		return  (getIndex() < endIdxExcl);
	}
	protected void crashIfBadIndex(int index)  {
		if(index < getIndex()  ||  index >= endIdxExcl)  {
			throw  new IllegalArgumentException("index (" + index + ") must be between getIndex() (" + getIndex() + "), inclusive, and getEndIndexExcl() (" + endIdxExcl + "), exclusive.");
		}
	}
}
