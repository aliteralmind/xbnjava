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
   import  com.github.xbn.linefilter.entity.LineEntityException;
   import  com.github.xbn.analyze.validate.NullnessValidator;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_Fieldable;
   import  java.util.Objects;
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

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_Cfg RawStealthBlockEntity_Cfg}</H3>

   <P><UL>
      <LI>{@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#startValidator(ValueValidator) startValidator}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#endValidator(ValueValidator) endValidator}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#listener(EntityOnOffListener) listener}</LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#reset() reset}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}</LI>
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
public class RawStealthBlockEntity<O,L extends RawLine<O>> extends RawBlockEntityBase<O,L>  {
   public final ValueValidator<L> startVldtr;
   public final ValueValidator<L> endVldtr  ;
   /**
      <P>YYY</P>

      @param  fieldable  May not be {@code null}.
    **/
   public RawStealthBlockEntity(RawStealthBlockEntity_Fieldable<O,L> fieldable)  {
      super(fieldable);
      startVldtr = fieldable.getStartValidator();
      endVldtr   = fieldable.getEndValidator();
   }
   protected RawStealthBlockEntity(RawStealthBlockEntity<O,L> to_copy, int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);

      startVldtr = RawStealthBlockEntity.getVldtrCopyCINotRestricted(
         to_copy.getStartValidator(), "Start");
      endVldtr = RawStealthBlockEntity.getVldtrCopyCINotRestricted(
         to_copy.getEndValidator(), "End");

      resetStateBSE();
      resetCountsBSE();
   }
      private static final <O,L extends RawLine<O>> ValueValidator<L> getVldtrCopyCINotRestricted(ValueValidator<L> validator, String start_orEnd)  {
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
      return  true;
   }
   public RawStealthBlockEntity<O,L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      return  new RawStealthBlockEntity<O,L>(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
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
   public O getAlteredPostResetCheck(L line_object, O line_body)  {

      if(resetStartEnd_isInactiveAndOff(line_object))  {
         return  line_body;
      }

      boolean isStart2 = NullnessValidator.isValidDefensive(
         getStartValidator(), line_object,
         "getStartValidator()", "line_object");
      boolean isEnd2 = NullnessValidator.isValidDefensive(
         getEndValidator(), line_object,
         "getEndValidator()", "line_object");

      if(isStart2  &&  isEnd2)  {
         throw  new LineEntityException(line_object, this, "Start and end lines found on the same line");
      }

      //Not both

      int lineNum = line_object.getNumber();

      if(!isActive())  {
         if(isStart2)  {
            declareStartLine(true, lineNum);
            return  declareAlteredReturnLineBodyUnchanged(line_object, line_body, "start");
         }

            //Not active
         //Not start line

         if(isEnd2)  {
            throw  new LineEntityException(line_object, this, "End-line found before stealth block started");
         }

            //Not active
            //Not start line
         //Not end line

         declareAltered(line_object.getNumber(),
            Altered.NO, NeedsToBeDeleted.NO);
         return  line_body;

      }

      //Active

      if(isStart2)  {
         throw  new LineEntityException(line_object, this, "Start-line found before previous block closed");
      }

         //Active
      //Not start line

      if(isEnd2)  {
         //isActive set to false on next iteratation.
         declareEndLine(true, lineNum);
         return  declareAlteredReturnLineBodyUnchanged(line_object, line_body, "end");
      }

         //isActive()=true
         //isStartLine()=false
         //isEndLine()=false, so...
      //isMidLine()=true

      declareMidLine(true);
      return  declareAlteredReturnLineBodyUnchanged(line_object, line_body, "mid");
   }
      private O declareAlteredReturnLineBodyUnchanged(L line_object, O line_body, String start_midEnd)  {
         declareAltered(line_object.getNumber(),
            Altered.YES, NeedsToBeDeleted.NO);
         if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + start_midEnd + " line");
         }
         return  line_body;
      }
   public void declareEndOfInput()  {
      if(isMidLine())  {
         throw  new LineEntityException(null, this, "End of output reached, but block not closed");
      }
   }
   protected String getDebuggingPrefix(int line_num)  {
      return  getDebuggingPrefixPrefixBldr(line_num).append("] ").toString();
   }
}
