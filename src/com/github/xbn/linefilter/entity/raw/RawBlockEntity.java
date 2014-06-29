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
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.array.CrashIfArray;
   import  com.github.xbn.array.Duplicates;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.NullElement;
   import  com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.linefilter.entity.LineEntityException;
   import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_Fieldable;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.util.BooleanUtil;
   import  java.util.Arrays;
   import  java.util.Collections;
   import  java.util.List;
   import  java.util.Objects;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Represents a series of <I>things</I>, with a distinct start and end item, zero-or-more items in between, and optional child entities. The start, mid, and end items may all be optionally kept or discarded--when kept, they may be optionally modified.</P>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...START
  -->

   <P>The start and end lines in a block must exist on separate lines. {@code com.github.xbn.linefilter.*} does not understand blocks that exist entirely on one line, such as
   <BR> &nbsp; &nbsp; <CODE>/<!--->* A valid Java comment *<!--->/</CODE>
   <BR>nor does it distinguish between text that may exist before the start or end line's unique marker:</P>

<BLOCKQUOTE><PRE>This is part of the block /<!--->* As is this
and this
<!--->*<!--->/  and this</PRE></BLOCKQUOTE>

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_Cfg RawBlockEntity_Cfg}</H3>

   <P><UL>
      <LI><B>Start/mid/end:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startAlter(ValueAlterer) startAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#midAlter(ValueAlterer) midAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) endAlter}</LI>
      <LI><B>Inclusivity:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive() startEndLinesInclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesExclusive() startEndLinesExclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}{@code (b,b)}</LI>
      <LI><B>Keep:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepAll() keepAll}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepMidsOnly() keepMidsOnly}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepNone() keepNone}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}{@code (b,b,b)}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(RawChildEntity[]) children}{@code (rce[])}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(TextChildEntity...) children}{@code (tce...)}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#filter(RawEntityOnOffFilter) filter}</LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#reset() reset}{@code ()}</LI>
   </UL></P>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...END
  -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RawBlockEntity<O,L extends RawLine<O>> extends RawBlockEntityBase<O,L> implements RawParentEntity<O,L>  {
   private final ValueAlterer<L,O>         startAlter  ;
   private final ValueAlterer<L,O>         midAlter    ;
   private final ValueAlterer<L,O>         endAlter    ;
   protected final RawChildEntity<O,L>[]   children    ;
   protected RawChildEntity<O,L> entityThatAbrtd;
   private final boolean         doKeepStart    ;
   private final boolean         doKeepMid      ;
   private final boolean         doKeepEnd      ;
   private final boolean         isEndRqd       ;
   private final boolean         isStartIncl    ;
   private final boolean         isEndIncl      ;
   private List<RawChildEntity<O,L>> childList;
/*
   public boolean     isStartLine;
   public boolean     isActive   ;
   public boolean     isEndLine  ;
 */
   public RawChildEntity<O,L> activeChild;
   /**
      <P>YYY</P>

      @param  fieldable  May not be {@code null}.
    **/
   public RawBlockEntity(RawBlockEntity_Fieldable<O,L> fieldable)  {
      super(fieldable);
      startAlter = fieldable.getStartAlterer();
      midAlter = fieldable.getMidAlterer();
      endAlter = fieldable.getEndAlterer();
      children = fieldable.getChildren();
      isEndRqd = fieldable.isEndRequired();
      doKeepStart = fieldable.doKeepStartLine();
      doKeepMid = fieldable.doKeepMidLines();
      doKeepEnd = fieldable.doKeepEndLine();
      isStartIncl = fieldable.isStartLineInclusive();
      isEndIncl = fieldable.isEndLineInclusive();
      childList = null;
   }
   public RawBlockEntity(RawBlockEntity<O,L> to_copy, int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);

      startAlter = RawLineEntity.getAltererCopyCrashIfMayDelete(
         to_copy.getStartAlterer(), "to_copy.getStartAlterer()");
      midAlter = RawLineEntity.getAltererCopyCrashIfMayDelete(
         to_copy.getMidAlterer(), "to_copy.getMidAlterer()");
      endAlter = RawLineEntity.getAltererCopyCrashIfMayDelete(
         to_copy.getEndAlterer(), "to_copy.getEndAlterer()");

      isEndRqd = to_copy.isEndRequired();
      doKeepStart = to_copy.doKeepStartLine();
      doKeepMid = to_copy.doKeepMidLines();
      doKeepEnd = to_copy.doKeepEndLine();
      isStartIncl = to_copy.isStartLineInclusive();
      isEndIncl = to_copy.isEndLineInclusive();

      CrashIfArray.bad(to_copy.children, "to_copy.<internal sub-entity array>",
         NullContainer.BAD, 0, null, NullElement.BAD, 0, null, Duplicates.OK);

      int levelsBelowRootPlus1 = getParentCount() + 1;
      @SuppressWarnings("unchecked")
      RawChildEntity<O,L>[] children2 = (RawChildEntity<O,L>[])new RawChildEntity[to_copy.children.length];
      for(int i = 0; i < to_copy.children.length; i++)  {
         RawChildEntity<O,L> child = to_copy.children[i];
         try  {
            children2[i] = child.getCopyWithParentAssigned(levelsBelowRootPlus1, this, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
         }  catch(RuntimeException rx)  {
            throw  new RuntimeException("Attempting to_copy.<internal-children-array>[" + i + "].getCopyWithParentAssigned(" + levelsBelowRootPlus1 + ", ...)", rx);
         }
      }
      children = children2;

      resetStateBE();
      resetCountsBE();
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) BlockEntity_CfgForNeeder#keepStartMidEnd
      @see  #doKeepJustAnalyzed()
    **/
   public boolean doKeepStartLine()  {
      return  doKeepStart;
   }
   public boolean doKeepJustAnalyzed()  {
      if(!isActive())  {
         if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=FALSE: Inactive");
         }

         return  false;
      }

      //active

      if(isStartLine())  {
         return  doKeepStartOrEndLine(isStartLineInclusive(), doKeepStartLine(), "Start");
      }

      //isStartLine()=false

      if(isEndLine())  {
         return  doKeepStartOrEndLine(isEndLineInclusive(), doKeepEndLine(), "End");
      }

      //mid-line

      assert  isMidLine()  :  "isActive()=" + isActive() + ", isStartLine()=" + isStartLine() + ", isEndLine()=" + isEndLine() + ", isMidLine()=" + isMidLine() + " (NOT mid line?)";

      if(getActiveChild() != null)  {
         boolean doKeepChild = getActiveChild().doKeepJustAnalyzed();
         if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=" +
               BooleanUtil.toUpperCase(doKeepChild) +
                  ": getActiveChild().doKeepJustAnalyzed()=" + doKeepChild);
         }
         return  doKeepChild;
      }

      if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
         getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=" +
            BooleanUtil.toUpperCase(doKeepMidLines()));
      }

      return  doKeepMidLines();

   }
      private boolean doKeepStartOrEndLine(boolean is_inclusive, boolean do_keep, String start_end)  {
         if(!is_inclusive)  {
            if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
               getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=" +
                  BooleanUtil.toUpperCase(do_keep));
            }
            return  do_keep;

         }

         //is_inclusive=true

         if(getActiveChild() == null)  {
            if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
               getDebugAptrEveryLine().appentln(getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=" +
                  BooleanUtil.toUpperCase(do_keep) + ": No active child");
            }
            return  do_keep;
         }

            //is_inclusive=true
         //getActiveChild() is non-null

         boolean doKeepChild = getActiveChild().doKeepJustAnalyzed();
         if(isEveryLineAptrUseableAndInRange(getMostRecentLineNum()))  {
            getDebugAptrEveryLine().appentln(
               getDebuggingPrefix(getMostRecentLineNum()) + " doKeepJustAnalyzed()=" +
               BooleanUtil.toUpperCase(doKeepChild) +
               ": getActiveChild().doKeepJustAnalyzed()=" + doKeepChild);
         }
         return  doKeepChild;
      }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) BlockEntity_CfgForNeeder#keepStartMidEnd
      @see  #doKeepJustAnalyzed()
    **/
   public boolean doKeepMidLines()  {
      return  doKeepMid;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) BlockEntity_CfgForNeeder#keepStartMidEnd
      @see  #doKeepJustAnalyzed()
    **/
   public boolean doKeepEndLine()  {
      return  doKeepEnd;
   }
   public boolean isEndRequired()  {
      return  isEndRqd;
   }
   public boolean areStartEndInclusive()  {
      return  (isStartLineInclusive()  &&  isEndLineInclusive());
   }
   public boolean isStartLineInclusive()  {
      return  isStartIncl;
   }
   public boolean isEndLineInclusive()  {
      return  isEndIncl;
   }
   public void resetState()  {
      super.resetState();
      resetStateBE();
   }
   protected void resetStateBE()  {
      getStartAlterer().resetState();
      getMidAlterer().resetState();
      getEndAlterer().resetState();
      entityThatAbrtd = null;
   }
   public void resetCounts()  {
      super.resetCounts();
      resetCountsBE();
   }
   protected void resetCountsBE()  {
      getStartAlterer().resetCounts();
      getMidAlterer().resetCounts();
      getEndAlterer().resetCounts();
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder#startAlter(ValueAlterer) RawBlockEntity_CfgForNeeder#startAlter
    **/
   protected ValueAlterer<L,O> getStartAlterer()  {
      return  startAlter;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder#midAlter(ValueAlterer) RawBlockEntity_CfgForNeeder#midAlter
    **/
   protected ValueAlterer<L,O> getMidAlterer()  {
      return  midAlter;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) RawBlockEntity_CfgForNeeder#endAlter
    **/
   protected ValueAlterer<L,O> getEndAlterer()  {
      return  endAlter;
   }
/*
   public boolean isActive()  {
      return  isActive;
   }
   public boolean isStartLine()  {
      return  isStartLine;
   }
   public boolean isEndLine()  {
      return  isEndLine;
   }
 */
   protected RawChildEntity<O,L> getChild(int index)  {
      try  {
         return  children[index];
      }  catch(ArrayIndexOutOfBoundsException abx)  {
         throw  new XbnIndexOutOfBoundsException_Cfg().
            badIndex(-2, "index").
            absArrayLength(children, "<internal-children-array>").build();
      }
   }
   /**
      <P>The currently active child, if any.</P>
    **/
   public RawChildEntity<O,L> getActiveChild()  {
      return  activeChild;
   }
   /**
      <P>An immutable list of all children.</P>
    **/
   public List<RawChildEntity<O,L>> getRawChildList()  {
      if(childList == null)  {
         synchronized(children)  {
            if(childList == null)  {
               childList = Collections.unmodifiableList(Arrays.asList(children));
            }
         }
      }
      return  childList;
   }
   public boolean doesFollowRulesPreInvert(L line_object)  {
      return  false;
   }
   /**
      <P>Duplicate this <CODE>RawBlockEntity</CODE>.</P>

      @return  <CODE>(new <A HREF="#RawBlockEntity(RawBlockEntity)">RawBlockEntity</A>&lt;O,L&gt;(this, parent))</CODE>
    **/
   public RawBlockEntity<O,L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      return  (new RawBlockEntity<O,L>(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug));
   }
   /**
      @param  to_appendTo May not be {@code null}.
      @see  #toString()
    **/
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         if(isStartLineInclusive() == isEndLineInclusive())  {
            to_appendTo.append("start-and-end-").
               append((isStartLineInclusive() ? "in" : "ex")).append("clusive");
         }  else  {
            to_appendTo.append("start-").
               append(isStartLineInclusive() ? "in" : "ex").append("clusive, end-").
               append(isEndLineInclusive() ? "in" : "ex").append("clusive");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      to_appendTo.append(", end-").append(isEndRequired() ? "required" : "optional").append(", ");
      super.appendToString(to_appendTo).append(LINE_SEP).
         append(" >>> getStartAlterer()=" + getStartAlterer()).append(LINE_SEP).
         append(" >>> getMidAlterer()=" + getMidAlterer()).append(LINE_SEP).
         append(" >>> getEndAlterer()=" + getEndAlterer()).append(LINE_SEP).
         append(" >>> " + children.length + " children");

      if(getActiveChild() != null)  {
         to_appendTo.append(" (active=\"" + getActiveChild().getName() + "\")");
      }

      if(children.length > 0)  {
         to_appendTo.append(": ");
         int lenMinus1 = children.length - 1;
         for(int i = 0; i < children.length; i++)  {
            to_appendTo.append(children[i].getName());

            if(i < lenMinus1)  {
               to_appendTo.append(", ");
            }
         }
      }

      return  to_appendTo;
   }
   /**
      <P>Does not include information on the mid-alterer.</P>
    **/
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("getStartAlterer()=[");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      getStartAlterer().appendRules(to_appendTo);
      to_appendTo.append("], getEndAlterer()=[");
      getEndAlterer().appendRules(to_appendTo);
      to_appendTo.append("], " + children.length + " children");

      String prefix = StringUtil.getStringOfLengthAllCharsEqualTo(3, ' ', null);

      if(getActiveChild() != null)  {
         to_appendTo.append(" (active=" + getActiveChild() + ")");
      }

      if(children.length > 0)  {
         to_appendTo.append(": ");
         int lenMinus1 = children.length - 1;
         for(int i = 0; i < children.length; i++)  {
            RawChildEntity<O,L> sub = children[i];
            to_appendTo.append(sub.getName());

            if(i < lenMinus1)  {
               to_appendTo.append(", ");
            }
         }
      }

      return  to_appendTo;
   }
      private void abortDeclareAbortingChild(RawChildEntity<O,L> child)  {
         entityThatAbrtd = child;
         abortIterator("child entity: \"" + child.getName() + "\"");
      }
   public RawEntity<O,L> getEntityThatAborted()  {
      return  entityThatAbrtd;
   }
   public O getAlteredPostResetCheck(L line_object, O line_body)  {
      if(!resetStartEndPreFilter_isActiveOrOn(line_object, line_body))  {
         if(doAbortIterator())  {
            entityThatAbrtd = this;
         }
         return  line_body;
      }

      //Entity is active, or inactive but getPreFilter(...).ON

      O startAltered = AbstractValueAlterer.getAlteredDefensive(
         getStartAlterer(), line_object, line_body,
         "getStartAlterer()", "line_object", "line_body");
      O endAltered = AbstractValueAlterer.getAlteredDefensive(
         getEndAlterer(), line_object, line_body,
         "getEndAlterer()", "line_object", "line_body");

      boolean isStart2 = getStartAlterer().wasAltered();
      boolean isEnd2 = getEndAlterer().wasAltered();


      if(isStart2  &&  isEnd2)  {
         throw  new LineEntityException(line_object, this, "Block start and end found on the same line");
      }

      //Not both

      int lineNum = line_object.getNumber();

      if(!isActive())  {
         if(isStart2)  {

            assert  (getActiveChild() == null)  :  "isStartLine()=true (actually " + isStartLine() + ") and the active child has not been determined yet. So getActiveChild() should be null, but isn't: " + getActiveChild();

            O alteredBody = getAlteredForStartLineMaybeInclusiveChild(line_object, startAltered);
            return  postFilter_getAlteredLine(line_object, alteredBody);

         }  else if(isEnd2)  {
            throw  new LineEntityException(line_object, this, "End-line found before block started");
         }

         declareAltered(lineNum, Altered.NO, NeedsToBeDeleted.NO);

         //Still not active. Return body unchanged.
         return  postFilter_getAlteredLine(line_object, line_body);
      }

      //isActive()=true

      if(isStart2)  {
         if(isEndRequired())  {
            throw  new LineEntityException(line_object, this, "Start-line found before block closed (and end is required).");
         }

         //Close the previous block
         declareEndLine(true, lineNum);
         if(getActiveChild() != null)  {
            getActiveChild().declareEndOfInput();
            activeChild = null;
         }

         O alteredBody = getAlteredForStartLineMaybeInclusiveChild(line_object, startAltered);
         return  postFilter_getAlteredLine(line_object, alteredBody);

      }

         //isActive()=true
      //isStartLine()=false

      if(isEnd2)  {
         declareEndLine(true, lineNum);
         declareAltered(lineNum, Altered.YES,
            NeedsToBeDeleted.getForBoolean(
               getEndAlterer().needsToBeDeleted()));

         if(!isEndLineInclusive())  {
            if(getActiveChild() != null)  {
               getActiveChild().declareEndOfInput();
               activeChild = null;
            }
            return  postFilter_getAlteredLine(line_object, endAltered);
         }

         //isEndLineInclusive()=true

         if(getActiveChild() != null)  {

            O childAlteredLine = getAlteredLineFromActiveChildOrNull(line_object, line_body, "inclusive end line (start line=" + getStartLineNum() + ")");

            if(getActiveChild() != null)  {
               return  postFilter_getAlteredLine(line_object, childAlteredLine);
            }
         }

         return  postFilter_getAlteredLine(line_object, endAltered);
      }

         //isActive()=true
         //isStartLine()=false
         //isEndLine()=false, so...
      //isMidLine()=true

      declareMidLine(true);
      declareAltered(lineNum, Altered.YES,
         NeedsToBeDeleted.getForBoolean(
            getMidAlterer().needsToBeDeleted()));
      O childAlteredLine = getAlteredLineFromActiveChildOrNull(line_object, line_body, "mid line (start line=" + getStartLineNum() + ")");

      if(getActiveChild() != null)  {
         return  postFilter_getAlteredLine(line_object, childAlteredLine);
      }

      O midAltered = AbstractValueAlterer.getAlteredDefensive(
         getMidAlterer(), line_object, line_body,
         "getMidAlterer()", "line_object", "line_body");
      boolean midLine2 = getMidAlterer().wasAltered();

      if(!midLine2)  {
         throw  new LineEntityException(line_object, this, "This is a mid-line, but the mid-alterer made no alteration (it doesn't actually have to modify the line, but getMidAlterer().wasAltered() must return true).");
      }

      return  postFilter_getAlteredLine(line_object, midAltered);
   }
      private O postFilter_getAlteredLine(L line_object, O altered_body)  {
         if(doAbortIterator())  {
            //Already aborted by a child.
            entityThatAbrtd = this;
            return  altered_body;
         }

         //Not yet aborted.

         postFilter(line_object, altered_body);

         //OnOffAbort.OFF or OnOffAbort.ABORT_ITERATOR


         return  altered_body;
      }
      private O getAlteredLineFromActiveChildOrNull(L line_object, O line_body, String midOr_startEndWIncl)  {
         int lineNum = line_object.getNumber();

         RawChildEntity<O,L> previouslyActive = null;

         if(getActiveChild() != null)  {
            previouslyActive = getActiveChild();

            //A child was active on the last line.

            O alteredFromChild = getActiveChild().getAltered(line_object, line_body);

            if(getActiveChild().wasAltered())  {

               //Still active.
               if(activeChild.doAbortIterator())  {
                  abortDeclareAbortingChild(activeChild);
               }

               return  alteredFromChild;

            }  else  {

               //No longer active.

               if(activeChild.doAbortIterator())  {

                  abortDeclareAbortingChild(activeChild);
               }

               activeChild = null;
            }
         }

         //No child is active

         for(int i = 0; i < children.length; i++)  {
            RawChildEntity<O,L> child = children[i];
            if(child == previouslyActive)  {
               continue;
            }
            O alteredLine = child.getAltered(line_object, line_body);

            if(child.doAbortIterator())  {
               abortDeclareAbortingChild(child);
               return  null;
            }

            if(child.wasAltered())  {
               activeChild = child;

               if(isEveryLineAptrUseableAndInRange(lineNum))  {
                  getDebugAptrEveryLine().appentln(getDebuggingPrefix(lineNum) + " Newly-active child: \"" + child.getName() + "\"");
               }

               return  alteredLine;
            }
         }

         if(isEveryLineAptrUseableAndInRange(lineNum))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(lineNum) + " No active child");
         }

         return  null;
      }
      private O getAlteredForStartLineMaybeInclusiveChild(L line_object, O lineBody_startAltered)  {
         declareStartLine(true, line_object.getNumber());

         declareAltered(line_object.getNumber(), Altered.YES,
            NeedsToBeDeleted.getForBoolean(
               getStartAlterer().needsToBeDeleted()));

         if(!isStartLineInclusive())  {
            return  lineBody_startAltered;
         }

         //isStartLineInclusive()=true

         O childAlteredLine = getAlteredLineFromActiveChildOrNull(line_object, lineBody_startAltered, "start line (inclusive)");

         if(getActiveChild() != null)  {
            return  childAlteredLine;
         }

         return  lineBody_startAltered;
      }
   public void declareEndOfInput()  {
      if(isMidLine()  &&  isEndRequired())  {
         throw  new LineEntityException(null, this, "End of output reached, but block not closed");
      }
      if(getActiveChild() != null)  {
         getActiveChild().declareEndOfInput();
      }
      declareStartLine(false, -1);
      declareMidLine(false);
      declareEndLine(false, -1);
   }
   public String getDebuggingPrefix(int line_num)  {
      StringBuilder bldr = getDebuggingPrefixPrefixBldr(line_num);

      if(isStartLine()  ||  isEndLine())  {
         bldr.append("-").append(isStartLineInclusive() ? "in" : "ex").append("cl");
      }

      if(getActiveChild() != null)  {
         bldr.append(":active-child=\"").append(getActiveChild().getName()).append("\"");
      }

      return  bldr.append("] ").toString();
   }
}
