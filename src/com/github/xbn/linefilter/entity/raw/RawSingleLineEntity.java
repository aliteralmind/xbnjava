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
package  com.github.xbn.linefilter.entity.raw;
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_Fieldable;
   import  com.github.xbn.analyze.alter.ValueAlterer;
/**
   <p>A single line that may be kept or discarded by a {@code FilteredIterator}--kept lines are optionally modified.</p>

<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawSingleLineEntity
   ...START
  -->

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_Cfg RawSingleLineEntity_Cfg}</h3>

   <p><ul>
      <li>{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#alterer(ValueAlterer) alterer}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#keepMatchedLines(boolean) keepMatchedLines}(b)</li>
      <li>{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#filter(RawOnOffEntityFilter) filter} </li>
      <li><b>Other:</b> {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#reset() reset}{@code ()}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#chainID(boolean, Object) chainID}</li>
   </ul>

<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawSingleLineEntity
   ...END
  -->

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RawSingleLineEntity<L> extends RawLineEntity<L> implements RawChildEntity<L>  {
   private final ValueAlterer<L,L> alterer;
   private final boolean doKeepMatched;
   /**
      <p>Create a new and <i>temporarily unusable</i> instance from a fieldable.</p>

    * @param  fieldable  May not be {@code null}, and all relevant fields must conform to the restrictions as documented in the <a href="#cfg">setters</a>.
    */
   public RawSingleLineEntity(RawSingleLineEntity_Fieldable<L> fieldable)  {
      super(fieldable);
      alterer = fieldable.getAlterer();
      doKeepMatched = fieldable.doKeepMatched();
   }
   protected RawSingleLineEntity(RawSingleLineEntity<L> to_copy, int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
      alterer = RawLineEntity.getAltererCopyCrashIfMayDelete(
         to_copy.getAlterer(), "to_copy.getAlterer()");
      doKeepMatched = to_copy.doKeepMatched();
      resetStateSLE();
      resetCountsSLE();
   }
   protected ValueAlterer<L,L> getAlterer()  {
      return  alterer;
   }
   public void resetState()  {
      super.resetState();
      resetStateSLE();
   }
   protected void resetStateSLE()  {
      getAlterer().resetState();
   }
   public void resetCounts()  {
      super.resetCounts();
      resetCountsSLE();
   }
   protected void resetCountsSLE()  {
      getAlterer().resetCounts();
   }
   public boolean doKeepMatched()  {
      return  doKeepMatched;
   }
   public boolean isActive()  {
      return  wasAltered();
   }
   public boolean doKeepJustAnalyzed()  {
      return  (!wasAltered() ? false : doKeepMatched());
   }
   public RawSingleLineEntity<L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      return  new RawSingleLineEntity<L>(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      return  getAlterer().appendRules(to_appendTo);
   }
   /**
    * @param  to_appendTo May not be {@code null}.
    * @see  #toString()
    */
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      to_appendTo.append("getAlterer()=").append(getAlterer()).append(", ");

      super.appendToString(to_appendTo);

      return  to_appendTo;
   }
   public L getAlteredPostResetCheck(L line_toAnalyze, L line_toAlter)  {
      incrementFullyActiveCountIfWas();

      if(doAbortIterator())  {
         throw  new IllegalStateException("Already aborted (doAbortIterator()=true). Cannot alter. this=" + this);
      }

      OnOffAbort state = getFilter().getPreState(this, getMostRecentLineNum(), line_toAlter);

      if(state.doAbortIterator())  {

         abortIteratorDeclareNotAltered("this entity: \"" + getName() + "\"", line_toAnalyze);
         return  line_toAlter;

      }

      //Do not abort

      if(!state.isOn())  {
         if(isEveryLineAptrUseableAndInRange())  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " Entity inactive and, according to the filter, off. Returning line unchanged.");
         }
         declareAltered(Altered.NO, NeedsToBeDeleted.NO);
         return  line_toAlter;
      }

      //state.ON

      L alteredLine = AbstractValueAlterer.getAlteredDefensive(
         getAlterer(), line_toAnalyze, line_toAlter,
         "getAlterer()", "line_toAnalyze", "line_toAlter");

      boolean wasAltered = getAlterer().wasAltered();
      if(wasAltered  &&  getDebugAptrLineNumbers().isUseable())  {
         getDebugAptrLineNumbers().appentln("[" + getName() + ":" + getMostRecentLineNum() + "] single-line");
      }

      declareAltered(Altered.getForBoolean(wasAltered),
         NeedsToBeDeleted.getForBoolean(getAlterer().needsToBeDeleted()));

      postFilter(alteredLine);

      return  alteredLine;
   }
      private void incrementFullyActiveCountIfWas()  {
         if(isActive())  {
            //The previous line was active
            incrementFullyActiveCount();
         }
      }

   /**
      <p>Does nothing.</p>
    */
   public void declareEndOfInput()  {
      incrementFullyActiveCountIfWas();
      crashIfRequiredAndNeverActive();
   }
}
