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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.linefilter.entity.raw.z.RawLineEntity_Fieldable;
/**
   <P>Base class for blocks and stealth blocks.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class RawBlockEntityBase<O,L extends RawLine<O>> extends RawLineEntity<O,L> implements RawBlockChildEntity<O,L>  {
   public boolean isStartLine ;
   public boolean isMid       ;
   public boolean isEndLine   ;
   public int     startLineNum;
   public RawBlockEntityBase(RawLineEntity_Fieldable<O,L> fieldable)  {
      super(fieldable);
      resetLineStateRBEB();
   }
   protected RawBlockEntityBase(RawBlockEntityBase<O,L> to_copy, int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
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
   protected void declareStartLine(boolean b, int line_num)  {
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
            getDebugAptrLineNumbers().appentln(getDebuggingPrefix(line_num) +
               "block-start");
         }

         startLineNum = line_num;
         isStartLine = b;
      }
   }
   protected boolean resetStartEnd_isInactiveAndOff(L line_object)  {
      //If the previous line was the first or last, it's not any more.
      declareStartLine(false, -1);
      declareEndLine(false, -1);

      if(!isActive()  &&  !getListener().isOn(this, line_object))  {
         int lineNum = RawLine.getNumberCrashIfNull(line_object, "line_object");
         if(isEveryLineAptrUseableAndInRange(lineNum))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(lineNum) + " entity inactive and, according to listener, off. Returning line unchanged.");
         }
         declareAltered(lineNum, Altered.NO, NeedsToBeDeleted.NO);
         return  true;
      }
      return  false;
   }
   protected void declareEndLine(boolean b, int line_num)  {
      if(isEndLine())  {
         if(b)  {
            throw  new IllegalStateException("The previous and current line are both the end line (isEndLine()=true, b=true)");
         }

         startLineNum = -1;
         incrementFullyActiveCount();
         if(isEveryLineAptrUseableAndInRange(line_num))  {
            getDebugAptrEveryLine().appentln(getDebuggingPrefix(line_num) + " previous line end of block");
         }
      }

      isEndLine = b;

      if(b)  {
         if(getDebugAptrLineNumbers().isUseable())  {
            getDebugAptrLineNumbers().appentln(getDebuggingPrefix(line_num) + "block end");
         }
         declareMidLine(false);
      }
   }
   protected void declareMidLine(boolean b)  {
      isMid = b;
   }
   protected StringBuilder getDebuggingPrefixPrefixBldr(int line_num)  {
      StringBuilder to_appendTo = new StringBuilder(getDebuggingPrefixPrefix(line_num));

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
