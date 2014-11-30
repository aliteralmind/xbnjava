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
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.linefilter.entity.raw.z.RawLineEntity_Fieldable;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Base class for blocks and stealth blocks.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class RawBlockEntityBase<L> extends RawLineEntity<L> implements RawBlockChildEntity<L>  {
   public boolean isStartLine ;
   public boolean isMid       ;
   public boolean isEndLine   ;
   public int     startLineNum;
   public RawBlockEntityBase(RawLineEntity_Fieldable<L> fieldable)  {
      super(fieldable);
      resetLineStateRBEB();
   }
   protected RawBlockEntityBase(RawBlockEntityBase<L> to_copy, int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
      resetLineStateRBEB();
   }
   public void resetLineState()  {
      super.resetLineState();
      resetLineStateRBEB();
   }
   protected void resetLineStateRBEB()  {
      isStartLine = false;
      isMid       = false;
      isEndLine   = false;
      startLineNum = -1;
   }
   public boolean isStartLine()  {
      return  isStartLine;
   }
   public boolean isMidLine()  {
      return  isMid;
   }
   public boolean isEndLine()  {
      return  isEndLine;
   }
   public int getStartLineNum()  {
      return  startLineNum;
   }
   public boolean isActive()  {
      return  (getStartLineNum() != -1);
   }
   protected void declareStartLine(boolean b)  {
      if(isStartLine())  {
         //The previous line was the start line
         if(b)  {
            throw  new IllegalStateException("The previous and current line are both the start line. isStartLine()=true, b=true");
         }

         isStartLine = false;
         declareMidLine(true);
      }

      if(b)  {
         if(getDebugAptrLineNumbers().isUseable())  {
            getDebugAptrLineNumbers().appentln(getDebuggingPrefix() +
               " block-start");
         }

         startLineNum = getMostRecentLineNum();
         isStartLine = b;
      }
   }
   protected boolean resetStartEndPreFilter_isActiveOrOn(L line_toAnalyze)  {
      if(doAbortIterator())  {
         throw  new IllegalStateException("Already aborted (doAbortIterator()=true). Cannot execute pre-filter. this=" + this);
      }

      //If the previous line was the first or last, it's not any more.
      declareStartLine(false);
      declareEndLine(false);

      OnOffAbort state = getFilter().getPreState(this, getMostRecentLineNum(), line_toAnalyze);
      if(state.doAbortIterator())  {
         abortIteratorDeclareNotAltered("this entity (\"" + getName() + "\")", line_toAnalyze);
         return  false;
      }

      //Do not abort

      if(state.isOn())  {
         return  true;
      }

      //state.OFF

      if(isActive())  {
         throw  new IllegalStateException(getDebuggingPrefix() + " getPreState(this, line_toAnalyze) is OFF, but this " + getType() + " entity is active--meaning open but not yet closed. OnOffAbort." + OnOffAbort.ABORT_ITERATOR + " can occur at any time. OnOffAbort.OFF is only legal when the entity is inactive--the *previous* line was inactive, given this pre-filter occurs before the current line is analyzed by the entity." + LINE_SEP + " - getFilter()=" + getFilter() + LINE_SEP + " - this=" + this);
      }

      //state.OFF and entity inactive

      if(isEveryLineAptrUseableAndInRange())  {
         getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " getPreState(this, line_toAnalyze) is OFF. Declaring not altered, returning line unchanged.");
      }
      declareAltered(Altered.NO, NeedsToBeDeleted.NO);
      return  false;
   }
   protected void declareEndLine(boolean b)  {
      if(isEndLine())  {

         //The *previous* line was the end line.

         if(b)  {
            throw  new IllegalStateException("The previous and current line are both the end line (isEndLine()=true, b=true)");
         }

         startLineNum = -1;
         incrementFullyActiveCount();
         if(isEveryLineAptrUseableAndInRange())  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " previous line end of block. fully-active count incremented to " + getFullyActiveCount());
         }
      }

      isEndLine = b;

      if(b)  {
         if(getDebugAptrLineNumbers().isUseable())  {
            getDebugAptrLineNumbers().appentln(getDebuggingPrefix() + " block end");
         }
         declareMidLine(false);
      }
   }
   protected void declareMidLine(boolean b)  {
      isMid = b;
   }
   protected StringBuilder getDebuggingPrefixPrefixBldr()  {
      StringBuilder to_appendTo = new StringBuilder(getDebuggingPrefixPrefix());

      if(isStartLine())  {
         to_appendTo.append(":start");
      }  else if(getParent() != null  &&  isMidLine())  {
         //Don't print for the root entity
         to_appendTo.append(":(start@=" + getStartLineNum() + ")mid");
      }  else if(isEndLine())  {
         to_appendTo.append(":(start@=" + getStartLineNum() + ")end");
      }

      return  to_appendTo;
   }
}
