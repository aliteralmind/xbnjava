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
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_Fieldable;
   import  java.util.Objects;
   import  com.github.xbn.analyze.alter.ValueAlterer;
/**
   <P>A single line that may be kept or discarded by a {@code FilteredIterator}--kept lines are optionally modified.</P>

<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawSingleLineEntity
   ...START
  -->

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_Cfg RawSingleLineEntity_Cfg}</H3>

   <P><UL>
      <LI>{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#alterer(ValueAlterer) alterer}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#keepMatchedLines(boolean) keepMatchedLines}(b)</LI>
      <LI>{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#listener(RawEntityOnOffListener) listener} </LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#reset() reset}{@code ()}, {@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#chainID(boolean, Object) chainID}</LI>
   </UL></P>

<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawSingleLineEntity
   ...END
  -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RawSingleLineEntity<O,L extends RawLine<O>> extends RawLineEntity<O,L> implements RawChildEntity<O,L>  {
   private final ValueAlterer<L,O> alterer;
   private final boolean doKeepMatched;
   /**
      <P>Create a new and <I>temporarily unusable</I> instance from a fieldable.</P>

      @param  fieldable  May not be {@code null}, and all its fields must conform to the restrictions as documented in the <A HREF="#cfg">setters</A>.
    **/
   public RawSingleLineEntity(RawSingleLineEntity_Fieldable<O,L> fieldable)  {
      super(fieldable);
      alterer = fieldable.getAlterer();
      doKeepMatched = fieldable.doKeepMatched();
   }
   protected RawSingleLineEntity(RawSingleLineEntity<O,L> to_copy, int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
      alterer = RawLineEntity.getAltererCopyCrashIfMayDelete(
         to_copy.getAlterer(), "to_copy.getAlterer()");
      doKeepMatched = to_copy.doKeepMatched();
      resetStateSLE();
      resetCountsSLE();
   }
   protected ValueAlterer<L,O> getAlterer()  {
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
//System.out.println(getName() + ".doKeepJustAnalyzed: wasAltered()=" + wasAltered() + ", doKeepMatched()=" + doKeepMatched() + "");
      return  (!wasAltered() ? false : doKeepMatched());
   }
   public RawSingleLineEntity<O,L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      return  new RawSingleLineEntity<O,L>(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      return  getAlterer().appendRules(to_appendTo);
   }
   public O getAlteredPostResetCheck(L line_object, O line_body)  {
      incrementFullyActiveCountIfWas();

      if(!getListener().isOn(this, line_object))  {
         try  {
            declareAltered(line_object.getNumber(), Altered.NO, NeedsToBeDeleted.NO);
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(line_object, "line_object", null, rx);
         }
         return  line_body;
      }

      O o = AbstractValueAlterer.getAlteredDefensive(
         getAlterer(), line_object, line_body,
         "getAlterer()", "line_object", "line_body");

      boolean wasAltered = getAlterer().wasAltered();
      if(wasAltered  &&  getDebugAptrLineNumbers().isUseable())  {
         getDebugAptrLineNumbers().appentln("[" + getName() + ":" + line_object.getNumber() + "] single-line");
      }

      declareAltered(line_object.getNumber(),
         Altered.getForBoolean(wasAltered),
         NeedsToBeDeleted.getForBoolean(getAlterer().needsToBeDeleted()));

      return  o;
   }
      private void incrementFullyActiveCountIfWas()  {
         if(isActive())  {
            //The previous line was active
            incrementFullyActiveCount();
         }
      }

   /**
      <P>Does nothing.</P>
    **/
   public void declareEndOfInput()  {
      incrementFullyActiveCountIfWas();
   }
}
