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
	import  com.github.xbn.lang.ToStringAppendable;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.Copyable;
	import  com.github.xbn.number.NumberUtil;
/**
	<P>Manages a binary search. This only works with indexed and sorted containers, such as {@code List}-s and arrays (containing elements which are, ideally, unique).</P>

{@.codelet.and.out com.github.xbn.examples.array.BinarySearcherXmpl%eliminateCommentBlocksAndPackageDecl()}

	<P>Referring to the container-being-searched, the binary-search <I>data</I> is: <UL>
		<LI>The <B>{@link #getIndexLeft() minimum} and {@link #getIndexRightX() maximum} index bounds:</B> The element-range in which the desired element exists (or would exist given the current ordering). This range is progressively narrowed until the search is complete.</LI>
		<LI>The <B>{@link #getIndexMiddle() middle} index:</B> The next element index to be searched.</LI>
		<LI>The <B>{@link #isOrderAsc() sort-order} direction</B></LI>
	</UL></P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BinarySearcher implements Copyable, ToStringAppendable  {
//config
	private int     iArrayLength = -1;
	private boolean bOrderAsc =    false;
//state
	private int     ixL =          -1;
	private int     ixxRight =     -1;
	private int     ixM =          -1;
	private int     ixMPrev =      -1;
	private int     ix2Ins =       -1;
//constructors...START
	public BinarySearcher()  {
		this(true);
	}
	/**
		<P>Create a new {@code BinarySearcher}.</P>

		@param  is_ascending  If {@code true}, the container is ordered ascending. Get with {@link #isOrderAsc() isOrderAsc}{@code ()}.
		@see  #BinarySearcher(BinarySearcher) this(bs)
	 **/
	public BinarySearcher(boolean is_ascending)  {
		bOrderAsc = is_ascending;
		resetState();
	}
	/**
		<P>Create a new {@code BinarySearcher} as a duplicate of another.</P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	 **/
	public BinarySearcher(BinarySearcher to_copy)  {
		try  {
			iArrayLength = to_copy.iArrayLength;
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
		bOrderAsc = to_copy.bOrderAsc;
		ixL = to_copy.ixL;
		ixxRight = to_copy.ixxRight;
		ixM = to_copy.ixM;
		ixMPrev = to_copy.ixMPrev;
		ix2Ins = to_copy.ix2Ins;
	}
//constructors...END
//setters...START
	/**
		<P>Declare a new container to be searched, and the order direction.</P>

		@param  cntr_length  The length of the container to be searched. May not be less than one. Get with {@link #getContainerLength() getContainerLength}{@code ()}.
		@return  {@link #resetState() resetState}{@code ()}
		@see  #containerLength(int) containerLength(i)
	 **/
	public BinarySearcher containerLength(int cntr_length)  {
		if(cntr_length < 1)  {
			throw new IllegalArgumentException("cntr_length (" + cntr_length + ") is less than one.");
		}
		iArrayLength = cntr_length;
		return  resetState();
	}
	/**
		<P>Prepare for a new search of the current container (container length is unchanged).</P>

		<P>This sets<OL>
			<LI>{@link #getIndexLeft() getIndexLeft}{@code ()} to {@code 0}</LI>
			<LI>{@link #getIndexMiddle() getIndexMiddle}{@code ()} to
			<BR> &nbsp; &nbsp;  <CODE>[{@link #getContainerLength() getContainerLength}() - 1]</CODE></LI>
			<LI>{@link #getIndexMiddle() getIndexMiddle}{@code ()} to
			<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.number.NumberUtil NumberUtil}.{@link com.github.xbn.number.NumberUtil#getMiddleInt(int, int) getMiddleInt}(0, getIndexMiddle())</CODE></LI>
			<LI>Both {@link #getIndexMiddlePrev() getIndexMiddlePrev}{@code ()} and {@link #getIndexInsertAt() getIndexInsertAt}{@code ()} to {@code -1}</LI>
		</OL></P>

		@return  <I>{@code this}</I>
	 **/
	public BinarySearcher resetState()  {
		ixL = 0;
		ixxRight = getContainerLength() - 1;
		ixM = NumberUtil.getMiddleInt(ixL, ixxRight);
		ixMPrev = -1;
		ix2Ins = -1;
		return  this;
	}
//setters...END
//getters...START
	/**
		<P>Get the left-most index that has not yet been searched.</P>

		@return  As initialized by {@link #resetState() resetState}{@code ()} or the {@link #BinarySearcher(BinarySearcher) copy-constructor}, or as updated by {@link #resetIteration(boolean) resetIteration(b)}
		@see  #getContainerLength()
	 **/
	public final int getIndexLeft()  {
		return ixL;
	}
	/**
		<P>Get the next index to analyze.</P>

		@return  As initialized by {@link #resetState() resetState}{@code ()} or the {@link #BinarySearcher(BinarySearcher) copy-constructor}, or as updated by {@link #resetIteration(boolean) resetIteration(b)}
		@see  #getContainerLength()
	 **/
	public final int getIndexMiddle()  {
		return  ixM;
	}
	/**
		<P>Get the next index to analyze.</P>

		@return  As initialized by {@link #resetState() resetState}{@code ()} or the {@link #BinarySearcher(BinarySearcher) copy-constructor}, or as updated by {@link #resetIteration(boolean) resetIteration(b)}
		@see  #getContainerLength()
	 **/
	public final int getIndexMiddlePrev()  {
		return  ixMPrev;
	}
	/**
		<P>Get the next index to analyze.</P>

		@return  As initialized by {@link #resetState() resetState}{@code ()} or the {@link #BinarySearcher(BinarySearcher) copy-constructor}, or as updated by {@link #resetIteration(boolean) resetIteration(b)}
		@see  #getContainerLength()
	 **/
	public final int getIndexInsertAt()  {
		return  ix2Ins;
	}
	/**
		<P>Get the right-most index that has not yet been searched.</P>

		@return  As initialized by {@link #resetState() resetState}{@code ()} or the {@link #BinarySearcher(BinarySearcher) copy-constructor}, or as updated by {@link #resetIteration(boolean) resetIteration(b)}
		@see  #getContainerLength()
	 **/
	public final int getIndexRightX()  {
		return  ixxRight;
	}
	/**
		<P>How many elements are in the container-being-searched?.</P>

		<P><I><B>See:</B><UL>
			<LI>Configuration: <I>This function</I> and {@link #isOrderAsc() isOrderAsc}{@code ()}</LI>
			<LI>State: {@link #getIndexInsertAt() getIndexInsertAt}{@code ()}, {@link #getIndexLeft() getIndexLeft}{@code ()}, {@link #getIndexMiddle() getIndexMiddle}{@code ()}, {@link #getIndexMiddlePrev() getIndexMiddlePrev}{@code ()}, {@link #getIndexRightX() getIndexRightX}{@code ()}</LI>
		</UL></I></P>

		@see  #containerLength(int)
	 **/
	public final int getContainerLength()  {
		return  iArrayLength;
	}
	/**
		<P>How are the elements in the container-being-searhed ordered?.</P>

		@see  #BinarySearcher(boolean) this(b)
		@see  #getContainerLength()
	 **/
	public final boolean isOrderAsc()  {
		return  bOrderAsc;
	}
//getters...END
//other...START
	/**
		<P>Set the indexes for the next search.</P>

		<P><I><B>See:</B><UL>
			<LI>{@link #isDone() isDone}{@code ()}, {@link #getIndexInsertAtN1M1() getIndexInsertAtN1M1}{@code ()}</LI>
		</UL></I></P>

		<P><I>If this is behaving strangely, perhaps the {@link #isOrderAsc() order-direction} is not as expected.</I></P>

		@param  was_itemToFindLessThanMiddleElement  Was the search item less or greater than the element just compared against?  If {@code true}: less.
		@exception  IllegalStateException  If {@link #isDone() isDone}{@code ()} is {@code true}.
	 **/
	public final void resetIteration(boolean was_itemToFindLessThanMiddleElement)  {
		if(isDone())  {
			throw  new IllegalStateException("isDone() is true.");
		}

		if(was_itemToFindLessThanMiddleElement)  {
			//To-search-for is less than the middle elemnt.
				//ixL stays the same.
				ixxRight = (getIndexMiddle() + (isOrderAsc() ? -1 : 1));

		}  else  {
			//To-search-for is greater than middle element.
				ixL = getIndexMiddle() + (isOrderAsc() ? 1 : -1);
				//ixxRight stays the same.;
		}

		ixMPrev = getIndexMiddle();  //ixM

		if(getIndexLeft() >= 0  &&  getIndexLeft() <= getIndexRightX())  {
			ixM = NumberUtil.getMiddleInt(getIndexLeft(), getIndexRightX());
		}  else  {
			ix2Ins = ixMPrev + (was_itemToFindLessThanMiddleElement
				?  (isOrderAsc() ? 0 : 1)
				:  (isOrderAsc() ? 1 : 0));
		}
	}
	/**
		<P>Is the search over?.</P>

		@return  <CODE>({@link #getIndexMiddlePrev() getIndexMiddlePrev}() == {@link #getIndexMiddle() getIndexMiddle}() &nbsp;|| &nbsp;getIndexMiddle() &lt; {@link #getIndexLeft() getIndexLeft}())</CODE>
		@return  {@code true} If you were with me all the while.
		@see  #resetIteration(boolean) resetIteration(b)
	 **/
	public final boolean isDone()  {
		return  (getIndexMiddlePrev() == getIndexMiddle()  ||  getIndexMiddle() < getIndexLeft());
	}
	/**
		<P>Utility: Get the negative index at which to insert, minus 1. This can be used to indicate that an element needs to be inserted at a certain index <I>and does not yet exist in the container.</I></P>

		@return  <CODE>(({@link #getIndexInsertAt() getIndexInsertAt}() * -1) - 1)</CODE>
		@see  #resetIteration(boolean) resetIteration(b)
	 **/
	public final int getIndexInsertAtN1M1()  {
		return  ((getIndexInsertAt() * -1) - 1);
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		try  {
			to_appendTo.append(this.getClass().getName());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}
		to_appendTo.append("getContainerLength()=").append(getContainerLength()).
			append(", isOrderAsc()=").append(isOrderAsc()).
			append(", left/middle/right indexes=[").
				append(getIndexLeft()).append(", ").
				append(getIndexMiddle()).append(", ").
				append(getIndexRightX()).
			append("], getIndexInsertAt()=").append(getIndexInsertAt());
		return  to_appendTo;
	}
	/**
		<P>Get a complete copy of this {@code BinarySearcher}.</P>

		@return  <CODE>(new {@link #BinarySearcher(BinarySearcher) BinarySearcher}(this))</CODE>
	 **/
	public BinarySearcher getObjectCopy()  {
		return  (new BinarySearcher(this));
	}
//other...END
}
