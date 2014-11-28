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
package  com.github.xbn.linefilter.entity.z;
	import  com.github.xbn.linefilter.entity.TextChildEntity;
	import  com.github.xbn.linefilter.entity.EndRequired;
	import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
	import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder;
	import  com.github.xbn.linefilter.entity.BlockEntity;
	import  com.github.xbn.analyze.alter.ValueAlterer;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity RawBlockEntity}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class BlockEntity_CfgForNeeder<M extends BlockEntity,R extends Needer> extends RawBlockEntity_CfgForNeeder<String,M,R>  {
//constructors...START
	/**
		<P>Create a new instance.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/raw/z/RawBlockEntity_CfgForNeeder.html#RawBlockEntity_CfgForNeeder(R, java.lang.String)">super</A>(needer, name)</CODE></P>
	 **/
	public BlockEntity_CfgForNeeder(R needer, String name)  {
		super(needer, name);
	}
	/**
		<P>Reverts configuration so a line never matches.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder super}.{@link com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder#reset() reset}()</CODE></P>

		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> reset()  {
		super.reset();
		return  this;
	}
//self-returning setters...START
	/**
		<P>Output the line number of each start and end line in block.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
		super.debugLineNumbers(dest_ifNonNull);
		return  this;
	}
	/**
		<P>Set the alterer that matches and optionally modifies the block's start line.</P>

		@param  start_alterer  May not be {@code null}, and <CODE>start_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</CODE> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getStartAlterer() getStartAlterer}{@code ()}*
		@return  <I>{@code this}</I>
		@see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
	 **/
	public BlockEntity_CfgForNeeder<M,R> startAlter(ValueAlterer<String,String> start_alterer)  {
		super.startAlter(start_alterer);
		return  this;
	}
	/**
		<P>Set the alterer that optionally modifies all lines between the start and end.</P>

		@param  mid_alterer  May not be {@code null}, and <CODE>mid_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</CODE> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getMidAlterer() getMidAlterer}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
	 **/
	public BlockEntity_CfgForNeeder<M,R> midAlter(ValueAlterer<String,String> mid_alterer)  {
		super.midAlter(mid_alterer);
		return  this;
	}
	/**
		<P>Set the alterer that matches and optionally modifies the block's end line.</P>

		@param  required  If {@link com.github.xbn.linefilter.entity.EndRequired#YES YES}, it is required that the end line exists somewhere after every start line (and before the {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput() end of input}). May not be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isEndRequired() isEndRequired}{@code ()}*.
		@param  end_alterer  May not be {@code null}, and <CODE>end_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</CODE> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getEndAlterer() getEndAlterer}{@code ()}*
		@return  <I>{@code this}</I>
		@see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
	 **/
	public BlockEntity_CfgForNeeder<M,R> endAlter(EndRequired required, ValueAlterer<String,String> end_alterer)  {
		super.endAlter(required, end_alterer);
		return  this;
	}
	/**
		<P>Child entities are recognized on the start and end lines.</P>

		@return  <CODE>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(true, true)</CODE>
	 **/
	public BlockEntity_CfgForNeeder<M,R> startEndLinesInclusive()  {
		return  startEndLinesInclusive(true, true);
	}
	/**
		<P>Child entities are not recognized on the start or end lines.</P>

		@return  <CODE>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(false, false)</CODE>
	 **/
	public BlockEntity_CfgForNeeder<M,R> startEndLinesExclusive()  {
		return  startEndLinesInclusive(false, false);
	}
	/**
		<P>Should child entities be allowed to exist on the same line as the block's start and end-lines?.</P>

		<P>No matter what these values are set to, the start and end lines in a block may never be on the same line.</P>

		@param  start  If {@code true}, child entities may exist or begin on its parent block's start line. If {@code false}, child entities are not <I>searched for</I> until the line after its parent's start line. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isStartLineInclusive() isStartLineInclusive}{@code ()}*. <I>A single-line child entity existing on its parent's start line will not be recognized. A child block entity that begins on its parent's start line will likely result in an &quot;end line found before block started&quot; error.</I>
		@param  end  If {@code true}, child entities may exist or end on its parent end line. If {@code false}, child entities must end on a line previous to its parent's end line (or its {@linkplain #endAlter(EndRequired, ValueAlterer) end required} setting must be {@link com.github.xbn.linefilter.entity.EndRequired#NO NO}). Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isEndLineInclusive() isEndLineInclusive}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  #startEndLinesInclusive()
		@see  #startEndLinesExclusive()
	 **/
	public BlockEntity_CfgForNeeder<M,R> startEndLinesInclusive(boolean start, boolean end)  {
		isStartIncl = start;
		isEndIncl = end;
		return  this;
	}
	/**
		<P>Declare any sub-entities.</P>

		@param  children  May not be {@code null}, and no element may be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getRawChildList() getRawChildList}{@code ()}* and {@link com.github.xbn.linefilter.entity.BlockEntity#getChildList() getChildList}{@code ()}*. It is assumed that children are valid (for example, that the parent entity is not an element in its own child array).
		@return  <I>{@code this}</I>
		@see  #children(TextChildEntity...)
	 **/
	public BlockEntity_CfgForNeeder<M,R> children(RawChildEntity<String>[] children)  {
		super.children(children);
		return  this;
	}
	/**
		<P>Declare any sub-entities.</P>

		@param  children  May not be {@code null}, and no element may be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getRawChildList() getRawChildList}{@code ()}* and {@link com.github.xbn.linefilter.entity.BlockEntity#getChildList() getChildList}{@code ()}*. It is assumed that children are valid (for example, that the parent entity is not an element in its own child array).
		@return  <I>{@code this}</I>
		@see  #children(RawChildEntity[])
	 **/
	public BlockEntity_CfgForNeeder<M,R> children(TextChildEntity... children)  {
		super.children(children);
		return  this;
	}
	/**
		<P>Keep all active lines.</P>

		@return  <CODE>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</CODE>
	 **/
	public BlockEntity_CfgForNeeder<M,R> keepAll()  {
		return  keepStartMidEnd(true, true, true);
	}
	/**
		<P>Keep all active lines.</P>

		@param  all  May not be {@code null}.
		@return  <CODE>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(all.{@link com.github.xbn.linefilter.KeepMatched#isYes() isYes}(), all.isYes(), all.isYes())</CODE>
	public BlockEntity_CfgForNeeder<M,R> keep(KeepMatched all)  {
		return  keepStartMidEnd(
			ObjectOrCrashIfNull.get(all, "all").isYes(),
			all.isYes(), all.isYes());
	}
	 */
	/**
		<P>Keep all active lines.</P>

		@param  all  May not be {@code null}.
		@return  <CODE>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(all.{@link com.github.xbn.linefilter.KeepUnmatched#isYes() isYes}(), all.isYes(), all.isYes())</CODE>
	public BlockEntity_CfgForNeeder<M,R> keep(KeepUnmatched all)  {
		return  keepStartMidEnd(
			ObjectOrCrashIfNull.get(all, "all").isYes(),
			all.isYes(), all.isYes());
	}
	 */

	/**
		<P>Discard all active lines.</P>

		@return  <CODE>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(false, false, false)</CODE>
	 **/
	public BlockEntity_CfgForNeeder<M,R> keepNone()  {
		return  keepStartMidEnd(false, false, false);
	}
	/**
		<P>Keep only thes lines between the start and ends.</P>

		@return  <CODE>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</CODE>
	 **/
	public BlockEntity_CfgForNeeder<M,R> keepMidsOnly()  {
		return  keepStartMidEnd(false, true, false);
	}
	/**
		<P>Should the start, middle, or end lines be kept?. A {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept} line may or may not be {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active}.</P>

		<P>A line is {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active} if it was altered. However, &quot;altered&quot; simply means that the altered flag (as returned by {@code RawEntity.isActive()}) was set to {@code true}. <I>This does not mean the line is actually modified.</I>

		A line may be kept even if it is not altered (although a line may be altered and then immediately discarded--not kept--it is pointless to do so).</P>

		@param  do_keepStart  If {@code true}, and the current line is the block's start line, it is returned by the {@linkplain com.github.xbn.linefilter.FilteredIterator#next() filtered iterator}. If {@code false}, it is discarded. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepStartLine() doKeepStartLine}{@code ()}*.
		@param  do_keepMids  If {@code true}, and the current line is between the start and end lines, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepMidLines() doKeepMidLines}{@code ()}*.
		@param  do_keepEnd  If {@code true}, and the current line is the block's end line, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepEndLine() doKeepEndLine}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  #keepAll()
		@see  #keepMidsOnly()
		@see  #startAlter(ValueAlterer) startAlter
		@see  #midAlter(ValueAlterer) midAlter
		@see  #endAlter(EndRequired, ValueAlterer) endAlter
	 **/
	public BlockEntity_CfgForNeeder<M,R> keepStartMidEnd(boolean do_keepStart, boolean do_keepMids, boolean do_keepEnd)  {
		super.keepStartMidEnd(do_keepStart, do_keepMids, do_keepEnd);
		return  this;
	}
	/**
		<P>Set the on-off filter.</P>

		@param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> filter(RawOnOffEntityFilter<String> filter)  {
		super.filter(filter);
		return  this;
	}
	/**
		<P>Is it required that this entity be found somewhere in the input?.</P>

		@param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
	 **/
	public BlockEntity_CfgForNeeder<M,R> required(boolean b)  {
		super.required(b);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	/**
		<P>Create a new {@code BlockEntity} as configured.</P>

		@return  <CODE>(M)(new xbn.text.line.BlockEntity#BlockEntity(RawBlockEntity_Fieldable)(this))</CODE>
	 **/
	public M build()  {
		@SuppressWarnings("unchecked")
		M m = (M)(new BlockEntity(this));
		return  m;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer)  {
		super.startConfigReturnNeedable(needer);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public BlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
		super.startConfigReturnNeedable(needer, needed_class);
		return  this;
	}
//self-returning setters...END
}
