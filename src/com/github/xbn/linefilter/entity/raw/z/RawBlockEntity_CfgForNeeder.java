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
package  com.github.xbn.linefilter.entity.raw.z;
   import  com.github.xbn.analyze.alter.ReturnValueUnchanged;
   import  com.github.xbn.analyze.alter.SetWasAlteredToWhenInRange;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.entity.EndRequired;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.number.NewLengthInRangeFor;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity RawBlockEntity}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class RawBlockEntity_CfgForNeeder<L,M extends RawBlockEntity<L>,R extends Needer> extends RawLineEntity_CfgForNeeder<L,M,R> implements RawBlockEntity_Fieldable<L>  {
   public ValueAlterer<L,L>         startAlter ;
   public ValueAlterer<L,L>         midAlter   ;
   public ValueAlterer<L,L>         endAlter   ;
   public RawChildEntity<L>[]     children   ;
   public boolean                   doKeepStart;
   public boolean                   doKeepMids  ;
   public boolean                   doKeepEnd  ;
   public boolean                   isEndRqd   ;
   public boolean                   isStartIncl;
   public boolean                   isEndIncl  ;
   public static final RawChildEntity[] EMPTY_RAW_CHILDREN_ARRAY = new RawChildEntity[0];
//constructors...START
   /**
      <p>Create a new instance.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="RawLineEntity_CfgForNeeder.html#RawLineEntity_CfgForNeeder(R, com.github.xbn.linefilter.entity.EntityType, java.lang.String)">super</a>(needer, {@link com.github.xbn.linefilter.entity.EntityType}.{@link com.github.xbn.linefilter.entity.EntityType#BLOCK BLOCK}, name)</code></li>
         <li>{@link #resetRBECFN() resetRBECFN}{@code ()}</li>
      </ol></p>
    */
   public RawBlockEntity_CfgForNeeder(R needer, String name)  {
      super(needer, EntityType.BLOCK, name);
      resetRBECFN();
   }
   /**
      <p>Reverts configuration so a line never matches.</p>

    * <p>Equal to {@link #resetRBECFN() resetRBECFN}{@code ()}</p>

    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> reset()  {
      resetRBECFN();
      return  this;
   }
   /**
      <p>Reset configuration specific to this {@code RawStealthBlockEntity_CfgForNeeder}.</p>

      <p>This calls<ol>
         <li><code>{@link #startAlter(ValueAlterer) startAlter}(matchAnythingOnlyOnce)</code>
         <br/>Where {@code matchAnythingOnlyOnce} is a
         <br/> &nbsp; &nbsp; <code>new {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#ReturnValueUnchanged(SetWasAlteredToWhenInRange, LengthInRange) ReturnValueUnchanged}&lt;L,O&gt;(
         {@link com.github.xbn.analyze.alter.SetWasAlteredToWhenInRange}.{@link com.github.xbn.analyze.alter.SetWasAlteredToWhenInRange#TRUE TRUE}, {@link com.github.xbn.number.NewLengthInRangeFor}.{@link com.github.xbn.number.NewLengthInRangeFor#exactly(Invert, int, String) exactly}(1, null))</code></li>
         <li><code>{@link #midAlter(ValueAlterer) midAlter}({@link com.github.xbn.analyze.alter.ReturnValueUnchanged}.
         <br/> &nbsp; &nbsp; &lt;L,O&gt;{@link com.github.xbn.analyze.alter.ReturnValueUnchanged#newForOnEachCallSetWasAlteredTo(boolean) newForOnEachCallSetWasAlteredTo}(true))</code></li>
         <li><code>{@link #endAlter(EndRequired, ValueAlterer) endAlter}({@link com.github.xbn.linefilter.entity.EndRequired}.{@link com.github.xbn.linefilter.entity.EndRequired#NO NO}, ReturnValueUnchanged.
         <br/> &nbsp; &nbsp; &lt;L,O&gt;newForOnEachCallSetWasAlteredTo(false))</code></li>
         <li><code>{@link #children(RawChildEntity[]) children}(new RawChildEntity[]{})</code></li>
         <li><code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</code></li>
         <li>{@link #startEndLinesInclusive() startEndLinesInclusive}{@code ()}</li>
      </ol></p>

    * @see  #reset()
    */
   protected final void resetRBECFN()  {
      ValueAlterer<L,L> matchAnythingOnlyOnce = new ReturnValueUnchanged<L,L>(
         SetWasAlteredToWhenInRange.TRUE, NewLengthInRangeFor.exactly(null, 1, null));
      startAlter(matchAnythingOnlyOnce);

      midAlter(ReturnValueUnchanged.
         <L,L>newForOnEachCallSetWasAlteredTo(true));

      endAlter(EndRequired.NO, ReturnValueUnchanged.
         <L,L>newForOnEachCallSetWasAlteredTo(false));

      @SuppressWarnings("unchecked")
      RawChildEntity<L>[] emptyChildren = (RawChildEntity<L>[])EMPTY_RAW_CHILDREN_ARRAY;
      children(emptyChildren);
      keepStartMidEnd(true, true, true);
      startEndLinesInclusive();
   }
//self-returning setters...START
   /**
      <p>Output the line number of each start and end line in block.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
      dbgApblLineNums = dest_ifNonNull;
      return  this;
   }
   /**
      <p>Set the alterer that matches and optionally modifies the block's start line.</p>

    * @param  start_alterer  May not be {@code null}, and <code>start_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getStartAlterer() getStartAlterer}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> startAlter(ValueAlterer<L,L> start_alterer)  {
      startAlter = start_alterer;
      return  this;
   }
   /**
      <p>Set the alterer that optionally modifies all lines between the start and end.</p>

    * @param  mid_alterer  May not be {@code null}, and <code>mid_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getMidAlterer() getMidAlterer}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> midAlter(ValueAlterer<L,L> mid_alterer)  {
      midAlter = mid_alterer;
      return  this;
   }
   /**
      <p>Set the alterer that matches and optionally modifies the block's end line.</p>

    * @param  required  If {@link com.github.xbn.linefilter.entity.EndRequired#YES YES}, it is required that the end line exists somewhere after every start line (and before the {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput() end of input}). May not be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#isEndRequired() isEndRequired}{@code ()}*.
    * @param  end_alterer  May not be {@code null}, and <code>end_alterer.{@linkplain com.github.xbn.analyze.alter.ValueAlterer#mayDelete() mayDelete}()</code> must be {@code false}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getEndAlterer() getEndAlterer}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> endAlter(EndRequired required, ValueAlterer<L,L> end_alterer)  {
      endAlter = end_alterer;
      try  {
         isEndRqd = required.isYes();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(required, "required", null, rx);
      }
      return  this;
   }
   /**
      <p>Child entities are recognized on the start and end lines.</p>

    * @return  <code>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(true, true)</code>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> startEndLinesInclusive()  {
      return  startEndLinesInclusive(true, true);
   }
   /**
      <p>Child entities are not recognized on the start or end lines.</p>

    * @return  <code>{@link #startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}(false, false)</code>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> startEndLinesExclusive()  {
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
   public RawBlockEntity_CfgForNeeder<L,M,R> startEndLinesInclusive(boolean start, boolean end)  {
      isStartIncl = start;
      isEndIncl = end;
      return  this;
   }
   /**
      <p>Declare any sub-entities.</p>

    * @param  children  May not be {@code null}, and no element may be {@code null}. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#getRawChildList() getRawChildList}{@code ()}* and {@link com.github.xbn.linefilter.entity.BlockEntity#getChildList() getChildList}{@code ()}*. It is assumed that children are valid (for example, that the parent entity is not an element in its own child array).
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> children(RawChildEntity<L>[] children)  {
      this.children = children;
      return  this;
   }
   /**
      <p>Keep all active lines.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</code>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> keepAll()  {
      return  keepStartMidEnd(true, true, true);
   }
   /**
      <p>Keep only thes lines between the start and ends.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(true, true, true)</code>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> keepMidsOnly()  {
      return  keepStartMidEnd(false, true, false);
   }
   /**
      <p>Discard all active lines.</p>

    * @return  <code>{@link #keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(false, false, false)</code>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> keepNone()  {
      return  keepStartMidEnd(false, false, false);
   }
   /**
      <p>Should the start, middle, or end lines be kept?. A {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept} line may or may not be {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active}.</p>

    * @param  do_keepStart  If {@code true}, and the current line is the block's start line, it is returned by the {@linkplain com.github.xbn.linefilter.FilteredIterator#next() filtered iterator}. If {@code false}, it is discarded. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepStartLine() doKeepStartLine}{@code ()}*.
    * @param  do_keepMids  If {@code true}, and the current line is between the start and end lines, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepMidLines() doKeepMidLines}{@code ()}*.
    * @param  do_keepEnd  If {@code true}, and the current line is the block's end line, it is returned by the iterator. Get with {@link com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepEndLine() doKeepEndLine}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #startAlter(ValueAlterer) startAlter
    * @see  #midAlter(ValueAlterer) midAlter
    * @see  #endAlter(EndRequired, ValueAlterer) endAlter
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> keepStartMidEnd(boolean do_keepStart, boolean do_keepMids, boolean do_keepEnd)  {
      doKeepStart = do_keepStart;
      doKeepMids = do_keepMids;
      doKeepEnd = do_keepEnd;
      return  this;
   }
   /**
      <p>Set the on-off filter.</p>

    * @param  filter_ifNonNull  Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> filter(RawOnOffEntityFilter<L> filter_ifNonNull)  {
      filterIfNonNull = filter_ifNonNull;
      return  this;
   }
   /**
      <p>Is it required that this entity be found somewhere in the input?.</p>

    * @param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> required(boolean b)  {
      isRqd = b;
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//self-returning setters...END
   public String toString()  {
      return  super.toString() + ", getStartAlterer()=" + getStartAlterer() + ", getEndAlterer()=" + getEndAlterer();
   }
   /**
      <p>Create a new {@code RawBlockEntity} as configured.</p>

    * @return  <code>(M)(new xbn.text.line.RawBlockEntity#RawBlockEntity(RawBlockEntity_Fieldable)&lt;O,L&gt;(this))</code>
    */
   public M build()  {
      @SuppressWarnings("unchecked")
      M m = (M)(new RawBlockEntity<L>(this));
      return  m;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
      Class<M> cblmo = (Class<M>)(Class)RawBlockEntity.class;
      startConfig(needer, cblmo);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
      startConfigReturnNeedable(needer, needed_class);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

    * @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    */
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
//getters...START
   public ValueAlterer<L,L> getStartAlterer()  {
      return  startAlter;
   }
   public ValueAlterer<L,L> getMidAlterer()  {
      return  midAlter;
   }
   public ValueAlterer<L,L> getEndAlterer()  {
      return  endAlter;
   }
   public boolean isEndRequired()  {
      return  isEndRqd;
   }
   public RawChildEntity<L>[] getChildren()  {
      return  children;
   }
   public boolean doKeepStartLine()  {
      return  doKeepStart;
   }
   public boolean doKeepMidLines()  {
      return  doKeepMids;
   }
   public boolean doKeepEndLine()  {
      return  doKeepEnd;
   }
   public boolean isStartLineInclusive()  {
      return  isStartIncl;
   }
   public boolean isEndLineInclusive()  {
      return  isEndIncl;
   }
//getters...END
}
