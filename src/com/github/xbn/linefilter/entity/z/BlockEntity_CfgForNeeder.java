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
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity RawBlockEntity}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class BlockEntity_CfgForNeeder<M extends BlockEntity,R extends Needer> extends RawBlockEntity_CfgForNeeder<String,M,R>  {
//constructors...START
   /**
      <p>Create a new instance.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/linefilter/entity/raw/z/RawBlockEntity_CfgForNeeder.html#RawBlockEntity_CfgForNeeder(R, java.lang.String)">super</a>(needer, name)</code></p>
    */
   public BlockEntity_CfgForNeeder(R needer, String name)  {
      super(needer, name);
   }
   /**
      <p>Reverts configuration so a line never matches.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder super}.{@link com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder#reset() reset}()</code></p>

    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> reset()  {
      super.reset();
      return  this;
   }
//self-returning setters...START
   /**
      <p>Output the line number of each start and end line in block.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
      super.debugLineNumbers(dest_ifNonNull);
      return  this;
   }
   /**
      <p>Set the alterer that matches and optionally modifies the block's start line.</p>

    * @param  start_alterer  May not be {@code null}, and <code>start_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getStartAlterer() getStartAlterer}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public BlockEntity_CfgForNeeder<M,R> startAlter(ValueAlterer<String,String> start_alterer)  {
      super.startAlter(start_alterer);
      return  this;
   }
   /**
      <p>Set the alterer that optionally modifies all lines between the start and end.</p>

    * @param  mid_alterer  May not be {@code null}, and <code>mid_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getMidAlterer() getMidAlterer}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public BlockEntity_CfgForNeeder<M,R> midAlter(ValueAlterer<String,String> mid_alterer)  {
      super.midAlter(mid_alterer);
      return  this;
   }
   /**
      <p>Set the alterer that matches and optionally modifies the block's end line.</p>

    * @param  required  If {@link com.github.xbn.linefilter.entity.EndRequired#YES YES}, it is required that the end line exists somewhere after every start line (and before the {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput() end of input}). May not be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isEndRequired() isEndRequired}{@code ()}*.
    * @param  end_alterer  May not be {@code null}, and <code>end_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getEndAlterer() getEndAlterer}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public BlockEntity_CfgForNeeder<M,R> endAlter(EndRequired required, ValueAlterer<String,String> end_alterer)  {
      super.endAlter(required, end_alterer);
      return  this;
   }
   /**
      <p>Child entities are recognized on the start and end lines.</p>

    * @return  <code>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(true, true)</code>
    */
   public BlockEntity_CfgForNeeder<M,R> startEndLinesInclusive()  {
      return  startEndLinesInclusive(true, true);
   }
   /**
      <p>Child entities are not recognized on the start or end lines.</p>

    * @return  <code>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(false, false)</code>
    */
   public BlockEntity_CfgForNeeder<M,R> startEndLinesExclusive()  {
      return  startEndLinesInclusive(false, false);
   }
   /**
      <p>Should child entities be allowed to exist on the same line as the block's start and end-lines?.</p>

      <p>No matter what these values are set to, the start and end lines in a block may never be on the same line.</p>

    * @param  start  If {@code true}, child entities may exist or begin on its parent block's start line. If {@code false}, child entities are not <i>searched for</i> until the line after its parent's start line. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isStartLineInclusive() isStartLineInclusive}{@code ()}*. <i>A single-line child entity existing on its parent's start line will not be recognized. A child block entity that begins on its parent's start line will likely result in an &quot;end line found before block started&quot; error.</i>
    * @param  end  If {@code true}, child entities may exist or end on its parent end line. If {@code false}, child entities must end on a line previous to its parent's end line (or its {@linkplain #endAlter(EndRequired, ValueAlterer) end required} setting must be {@link com.github.xbn.linefilter.entity.EndRequired#NO NO}). Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isEndLineInclusive() isEndLineInclusive}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #startEndLinesInclusive()
    * @see  #startEndLinesExclusive()
    */
   public BlockEntity_CfgForNeeder<M,R> startEndLinesInclusive(boolean start, boolean end)  {
      isStartIncl = start;
      isEndIncl = end;
      return  this;
   }
   /**
      <p>Declare any sub-entities.</p>

    * @param  children  May not be {@code null}, and no element may be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getRawChildList() getRawChildList}{@code ()}* and {@link com.github.xbn.linefilter.entity.BlockEntity#getChildList() getChildList}{@code ()}*. It is assumed that children are valid (for example, that the parent entity is not an element in its own child array).
    * @return  <i>{@code this}</i>
    * @see  #children(TextChildEntity...)
    */
   public BlockEntity_CfgForNeeder<M,R> children(RawChildEntity<String>[] children)  {
      super.children(children);
      return  this;
   }
   /**
      <p>Declare any sub-entities.</p>

    * @param  children  May not be {@code null}, and no element may be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getRawChildList() getRawChildList}{@code ()}* and {@link com.github.xbn.linefilter.entity.BlockEntity#getChildList() getChildList}{@code ()}*. It is assumed that children are valid (for example, that the parent entity is not an element in its own child array).
    * @return  <i>{@code this}</i>
    * @see  #children(RawChildEntity[])
    */
   public BlockEntity_CfgForNeeder<M,R> children(TextChildEntity... children)  {
      super.children(children);
      return  this;
   }
   /**
      <p>Keep all active lines.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</code>
    */
   public BlockEntity_CfgForNeeder<M,R> keepAll()  {
      return  keepStartMidEnd(true, true, true);
   }
   /**
      <p>Keep all active lines.</p>

    * @param  all  May not be {@code null}.
    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(all.{@link com.github.xbn.linefilter.entity.KeepMatched#isYes() isYes}(), all.isYes(), all.isYes())</code>
   public BlockEntity_CfgForNeeder<M,R> keep(KeepMatched all)  {
      return  keepStartMidEnd(
         ObjectOrCrashIfNull.get(all, "all").isYes(),
         all.isYes(), all.isYes());
   }
    */
   /**
      <p>Keep all active lines.</p>

    * @param  all  May not be {@code null}.
    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(all.{@link com.github.xbn.linefilter.KeepUnmatched#isYes() isYes}(), all.isYes(), all.isYes())</code>
   public BlockEntity_CfgForNeeder<M,R> keep(KeepUnmatched all)  {
      return  keepStartMidEnd(
         ObjectOrCrashIfNull.get(all, "all").isYes(),
         all.isYes(), all.isYes());
   }
    */

   /**
      <p>Discard all active lines.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(false, false, false)</code>
    */
   public BlockEntity_CfgForNeeder<M,R> keepNone()  {
      return  keepStartMidEnd(false, false, false);
   }
   /**
      <p>Keep only thes lines between the start and ends.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</code>
    */
   public BlockEntity_CfgForNeeder<M,R> keepMidsOnly()  {
      return  keepStartMidEnd(false, true, false);
   }
   /**
      <p>Should the start, middle, or end lines be kept?. A {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept} line may or may not be {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active}.</p>

      <p>A line is {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active} if it was altered. However, &quot;altered&quot; simply means that the altered flag (as returned by {@code RawEntity.isActive()}) was set to {@code true}. <i>This does not mean the line is actually modified.</i>

      A line may be kept even if it is not altered (although a line may be altered and then immediately discarded--not kept--it is pointless to do so).</p>

    * @param  do_keepStart  If {@code true}, and the current line is the block's start line, it is returned by the {@linkplain com.github.xbn.linefilter.FilteredIterator#next() filtered iterator}. If {@code false}, it is discarded. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepStartLine() doKeepStartLine}{@code ()}*.
    * @param  do_keepMids  If {@code true}, and the current line is between the start and end lines, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepMidLines() doKeepMidLines}{@code ()}*.
    * @param  do_keepEnd  If {@code true}, and the current line is the block's end line, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepEndLine() doKeepEndLine}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #keepAll()
    * @see  #keepMidsOnly()
    * @see  #startAlter(ValueAlterer) startAlter
    * @see  #midAlter(ValueAlterer) midAlter
    * @see  #endAlter(EndRequired, ValueAlterer) endAlter
    */
   public BlockEntity_CfgForNeeder<M,R> keepStartMidEnd(boolean do_keepStart, boolean do_keepMids, boolean do_keepEnd)  {
      super.keepStartMidEnd(do_keepStart, do_keepMids, do_keepEnd);
      return  this;
   }
   /**
      <p>Set the on-off filter.</p>

    * @param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> filter(RawOnOffEntityFilter<String> filter)  {
      super.filter(filter);
      return  this;
   }
   /**
      <p>Is it required that this entity be found somewhere in the input?.</p>

    * @param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
    */
   public BlockEntity_CfgForNeeder<M,R> required(boolean b)  {
      super.required(b);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
      <p>Create a new {@code BlockEntity} as configured.</p>

    * @return  <code>(M)(new xbn.text.line.BlockEntity#BlockEntity(RawBlockEntity_Fieldable)(this))</code>
    */
   public M build()  {
      @SuppressWarnings("unchecked")
      M m = (M)(new BlockEntity(this));
      return  m;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer)  {
      super.startConfigReturnNeedable(needer);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public BlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
      super.startConfigReturnNeedable(needer, needed_class);
      return  this;
   }
//self-returning setters...END
}
