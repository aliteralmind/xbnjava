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
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.linefilter.entity.LineEntityException;
   import  com.github.xbn.analyze.validate.NullnessValidator;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_Fieldable;
   import  com.github.xbn.analyze.validate.ValueValidator;
/**
   <P>A specialized and simplified block-entity used only to prevent {@code RawBlockEntity}s from incorrectly matching start or end-lines (preventing false-positives). The lines matched by a stealth-block are never kept. More accurately, the lines in a stealth block are only kept if its parent block keeps its {@linkplain com.github.xbn.linefilter.entity.raw.RawBlockEntity#doKeepMidLines() mid-lines}.</P>

<!--
   Originates in
      com.github.xbn.linefilter.StealthBlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity
   ...START
  -->

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_Cfg RawStealthBlockEntity_Cfg}</H3>

   <P><UL>
      <LI>{@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#startValidator(ValueValidator) startValidator}, {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#endValidator(ValueValidator) endValidator}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#filter(RawOnOffEntityFilter) filter}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#keepLines(boolean) keepLines}(b), {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#keepLines() keepLines}(), {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#discardLines() discardLines}(), </LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#reset() reset}, {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}</LI>
   </UL></P>

<!--
   Originates in
      com.github.xbn.linefilter.StealthBlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity
   ...END
  -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RawStealthBlockEntity<L> extends RawBlockEntityBase<L>  {
   private final ValueValidator<L> startVldtr;
   private final ValueValidator<L> endVldtr  ;
   private final boolean           doKeep    ;
   /**
      <P>YYY</P>

      @param  fieldable  May not be {@code null}.
    **/
   public RawStealthBlockEntity(RawStealthBlockEntity_Fieldable<L> fieldable)  {
      super(fieldable);
      startVldtr = fieldable.getStartValidator();
      endVldtr   = fieldable.getEndValidator();
      doKeep     = fieldable.doKeepLines();
   }
   protected RawStealthBlockEntity(RawStealthBlockEntity<L> to_copy, int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);

      startVldtr = RawStealthBlockEntity.getVldtrCopyCINotRestricted(
         to_copy.getStartValidator(), "Start");
      endVldtr = RawStealthBlockEntity.getVldtrCopyCINotRestricted(
         to_copy.getEndValidator(), "End");
      doKeep     = to_copy.doKeepJustAnalyzed();

      resetStateBSE();
      resetCountsBSE();
   }
      private static final <L> ValueValidator<L> getVldtrCopyCINotRestricted(ValueValidator<L> validator, String start_orEnd)  {
         try  {
            if(!validator.getRuleType().isRestricted())  {
               throw  new IllegalArgumentException("to_copy.get" + start_orEnd + "Validator().getRuleType() (" + validator.getRuleType() + ") is not RESTRICTED.");
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(validator,
               "to_copy.get" + start_orEnd + "Validator()", null, rx);
         }
         return  validator.getObjectCopy();
      }
   public void resetState()  {
      super.resetState();
      resetStateBSE();
   }
   protected void resetStateBSE()  {
      getStartValidator().resetState();
      getEndValidator().resetState();
   }
   public void resetCounts()  {
      super.resetCounts();
      resetCountsBSE();
   }
   protected void resetCountsBSE()  {
      getStartValidator().resetCounts();
      getEndValidator().resetCounts();
   }
   protected ValueValidator<L> getStartValidator()  {
      return  startVldtr;
   }
   protected ValueValidator<L> getEndValidator()  {
      return  endVldtr;
   }
   public boolean doKeepJustAnalyzed()  {
      return  doKeep;
   }
   public RawStealthBlockEntity<L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      return  new RawStealthBlockEntity<L>(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("getStartValidator()=[");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      getStartValidator().appendRules(to_appendTo);
      to_appendTo.append("], getEndValidator()=[");
      getEndValidator().appendRules(to_appendTo);
      return  to_appendTo.append("]");
   }
   public L getAlteredPostResetCheck(L line_toValidate, L line_toAlter)  {
      if(!resetStartEndPreFilter_isActiveOrOn(line_toValidate))  {
         return  line_toAlter;
      }

      boolean isStart2 = NullnessValidator.isValidDefensive(
         getStartValidator(), line_toValidate,
         "getStartValidator()", "line_toValidate");
      boolean isEnd2 = NullnessValidator.isValidDefensive(
         getEndValidator(), line_toValidate,
         "getEndValidator()", "line_toValidate");

      if(isStart2  &&  isEnd2)  {
         throw  new LineEntityException(getMostRecentLineNum(), line_toValidate, this, "Start and end lines found on the same line");
      }

      //Not both

      if(!isActive())  {
         if(isStart2)  {
            declareStartLine(true);
            return  declareAlteredReturnLineBodyUnchanged(line_toValidate, line_toAlter, "start");
         }

            //Not active
         //Not start line

         if(isEnd2)  {
            throw  new LineEntityException(getMostRecentLineNum(), line_toValidate, this, "End-line found before stealth block started");
         }

            //Not active
            //Not start line
         //Not end line

         declareAltered(Altered.NO, NeedsToBeDeleted.NO);
         postFilter(line_toAlter);
         return  line_toAlter;

      }

      //Active

      if(isStart2)  {
         throw  new LineEntityException(getMostRecentLineNum(), line_toValidate, this, "Start-line found before previous block closed");
      }

         //Active
      //Not start line

      if(isEnd2)  {
         //isActive set to false on next iteratation.
         declareEndLine(true);
         return  declareAlteredReturnLineBodyUnchanged(line_toValidate, line_toAlter, "end");
      }

         //isActive()=true
         //isStartLine()=false
         //isEndLine()=false, so...
      //isMidLine()=true

      declareMidLine(true);
      return  declareAlteredReturnLineBodyUnchanged(line_toValidate, line_toAlter, "mid");
   }
      private L declareAlteredReturnLineBodyUnchanged(L line_toValidate, L line_toAlter, String start_midEnd)  {
         declareAltered(Altered.YES, NeedsToBeDeleted.NO);
         if(isEveryLineAptrUseableAndInRange())  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " " + start_midEnd + " line");
         }
         postFilter(line_toAlter);
         return  line_toAlter;
      }
   public void declareEndOfInput()  {
      if(isMidLine())  {
         throw  new LineEntityException(-1, null, this, "End of output reached, but block not closed");
      }
      crashIfRequiredAndNeverActive();
   }
   /**
      @param  to_appendTo May not be {@code null}.
      @see  #toString()
    **/
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("getStartValidator()=[").append(getStartValidator()).
            append("], getEndValidator()=[").append(getEndValidator()).append("], ");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      super.appendToString(to_appendTo);

      return  to_appendTo;
   }
   public String getDebuggingPrefix()  {
      return  getDebuggingPrefixPrefixBldr().append("]").toString();
   }
}
