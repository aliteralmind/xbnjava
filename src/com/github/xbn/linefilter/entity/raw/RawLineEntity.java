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
   import  com.github.xbn.linefilter.entity.LineEntityException;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.keyed.SimpleNamed;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.raw.z.RawLineEntity_Fieldable;
   import  com.github.xbn.number.CrashIfIntIs;
   import  com.github.xbn.number.LengthInRange;
   import  java.util.Objects;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>The base class for all entities.</P>

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder RawLineEntity_CfgForNeeder}</H3>

   <P><UL>
      <LI>YYY</LI>
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#reset()
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#debugLineNumbers(Appendable)
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#chainID(boolean, Object)
   </UL></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class RawLineEntity<L> extends AbstractValueAlterer<L,L> implements RawChildEntity<L>   {
   private final RawParentEntity<L> parent         ;
   private final RawParentEntity<L> topParent      ;
   private final int                  levelsBelowRoot;
   private final SimpleNamed          smplNamed      ;
   private final TextAppenter         dbgAptrLineNums;
   private final EntityType           type           ;
   private final RawOnOffEntityFilter<L> filter;
   private final TextAppenter        dbgAptrEveryLine;
   private final LengthInRange rangeForEveryLineDebug;
   private boolean isRqd            ;
   private int     mostRecentLineNum;
   private int     fullyActiveCount ;
   private boolean doAbortItr       ;
   /**
      <P>Create a new and <I>temporarily unusable</I> instance from a fieldable.</P>

      @param  fieldable  May not be {@code null}, and all its fields must conform to the restrictions as documented in the setters of all sub-classes (<CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/SingleLineEntity.html#cfg">SingleLineEntity</A></CODE>, <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/BlockEntity.html#cfg">BlockEntity</A></CODE>, <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/StealthBlockEntity.html#cfg">StealthBlockEntity</A></CODE>).
    **/
   public RawLineEntity(RawLineEntity_Fieldable<L> fieldable)  {
      super();

      declareMayDelete(false);

      try  {
         type = fieldable.getType();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable, "fieldable", null, rx);
      }
      Objects.requireNonNull(type, "fieldable.getType()");

      smplNamed = new SimpleNamed(fieldable.getName());
      isRqd = fieldable.isRequired();

      levelsBelowRoot = -1;
      resetCountsLET();

      filter = ((fieldable.getFilterIfNonNull() == null)
         ?  NewRawOnOffEntityFilterFor.<L>alwaysForPrePost(OnOffAbort.ON, OnOffAbort.ON)
         :  fieldable.getFilterIfNonNull());
      Objects.requireNonNull(filter, "fieldable.getFilterIfNonNull()");

      parent = null;
      topParent = null;

      dbgAptrLineNums = NewTextAppenterFor.appendableUnusableIfNull(
         fieldable.getDebugApblLineNumbers());
      dbgAptrEveryLine = null;
      rangeForEveryLineDebug = null;

      resetLineStateRLE();
      resetStateLET();
   }
   protected RawLineEntity(RawLineEntity<L> to_copy, int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy);

      type = to_copy.getType();
      CrashIfIntIs.lessThanZero(levels_belowRoot, "levels_belowRoot", null);
      filter = to_copy.getFilter().getObjectCopy();

      if(parent == null)  {
         if(levels_belowRoot != 0)  {
            throw  new IllegalArgumentStateException("parent=null, levels_belowRoot=" + levels_belowRoot + ". Root entity must have a levels-below of zero.");
         }
         this.parent = null;
         try  {
            @SuppressWarnings("unchecked")
            RawParentEntity<L> top2 = (RawParentEntity<L>)to_copy;
            topParent = top2;
         }  catch(ClassCastException ccx)  {
            throw  new ClassCastException("parent is null, but to_copy (" + to_copy.getClass().getName() + ") is not a RawParentEntity<L>: " + ccx);
         }
         smplNamed = new SimpleNamed(to_copy.smplNamed.getName());
         levelsBelowRoot = 0;
      }  else  {
         if(levels_belowRoot < 1)  {
            throw  new IllegalArgumentStateException("parent=null, levels_belowRoot=" + levels_belowRoot + ". Non-root entity must have a levels-below greater than zero.");
         }

         RawParentEntity<L> top2 = parent;
         try  {
            while(top2 != null)  {
               top2 = top2.getParent();
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(parent, "parent", null, rx);
         }
         this.parent = parent;
         topParent = top2;
         smplNamed = new SimpleNamed(to_copy.smplNamed.getName());
         isRqd = to_copy.isRequired();
         levelsBelowRoot = levels_belowRoot;
      }

      resetStateLET();
      resetCountsLET();

      dbgAptrLineNums = to_copy.getDebugAptrLineNumbers();

      Objects.requireNonNull(dbgAptrEveryLine_ifUseable, "dbgAptrEveryLine_ifUseable");
      Objects.requireNonNull(range_forEveryLineDebug, "range_forEveryLineDebug");

      dbgAptrEveryLine = dbgAptrEveryLine_ifUseable;
      rangeForEveryLineDebug = range_forEveryLineDebug;
      resetLineStateRLE();
   }
   public void resetLineState()  {
      resetLineStateRLE();
   }
   protected void resetLineStateRLE()  {
      mostRecentLineNum = 0;
   }
   /**
      <P>The outputter for diagnostics on every analyzed line.</P>

      @see  com.github.xbn.linefilter.FilteredIterator#FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    **/
   public TextAppenter getDebugAptrEveryLine()  {
      return  dbgAptrEveryLine;
   }
   public LengthInRange getEveryLineDebugRange()  {
      return  rangeForEveryLineDebug;
   }
   public RawParentEntity<L> getParent()  {
      return  parent;
   }
   public RawParentEntity<L> getTopParent()  {
      return  topParent;
   }
   public String getName()  {
      return  smplNamed.getName();
   }
   public String getKey()  {
      return  smplNamed.getKey();
   }
   public EntityType getType()  {
      return  type;
   }
   public boolean isRequired()  {
      return  isRqd;
   }
   public int getParentCount()  {
      return  levelsBelowRoot;
   }
   public TextAppenter getDebugAptrLineNumbers()  {
      return  dbgAptrLineNums;
   }
   public RawOnOffEntityFilter<L> getFilter()  {
      return  filter;
   }
   public int getFullyActiveCount()  {
      return  fullyActiveCount;
   }
   protected void incrementFullyActiveCount()  {
      fullyActiveCount++;
   }
   public void resetState()  {
      super.resetState();
      resetStateLET();
   }
   protected void resetStateLET()  {
      doAbortItr = false;
   }
   public void resetCounts()  {
      super.resetCounts();
      resetCountsLET();
   }
   protected void resetCountsLET()  {
      fullyActiveCount = 0;
   }

   public int getMostRecentLineNum()  {
      return  mostRecentLineNum;
   }
   public abstract boolean isActive();
   public boolean isInitialized()  {
      return  (getParentCount() != -1);
   }
   public boolean doAbortIterator()  {
      return  doAbortItr;
   }
   protected void abortIteratorDeclareNotAltered(String abort_source, L line)  {
      declareAltered(Altered.NO, NeedsToBeDeleted.NO);
      abortIterator(abort_source);
   }
   protected void abortIterator(String abort_source)  {
      if(isEveryLineAptrUseableAndInRange())  {
         getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " ABORT_ENTITY (aborted by " + abort_source + "): Setting doAbortIterator() to true");
      }
      doAbortItr = true;
   }
/*
   protected void declareAltered(L line, Altered altered, NeedsToBeDeleted deleted)  {
      try  {
         declareAltered(line.getNumber(), Altered.NO, NeedsToBeDeleted.NO);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line, "line", null, rx);
      }
   }
   public int getMostRecentLineNum()  {
      return  lineNumAnalyzed;
   }
 */
   public L getAltered(L line_toAnalyze, L line_toAlter)  {
      throw  new UnsupportedOperationException("Use getAltered(int, L, L)");
   }
   public L getAltered(int line_num, L line_toAnalyze, L line_toAlter)  {
      mostRecentLineNum = line_num;
      return  super.getAltered(line_toAnalyze, line_toAlter);
   }
   protected void declareAltered(Altered altered, NeedsToBeDeleted deleted)  {
      if(!isInitialized())  {
         throw  new IllegalStateException("isInitialized()=false");
      }
      if(doAbortIterator())  {
         throw  new IllegalStateException("Already aborted (doAbortIterator()=true). Cannot declare anything altered. this=" + this);
      }

      super.declareAltered(altered, deleted);
   }
   protected void postFilter(L potentially_alteredLine)  {
      if(doAbortIterator())  {
         throw  new IllegalStateException("Already aborted (doAbortIterator()=true). Cannot execute post-filter. this=" + this);
      }

      OnOffAbort state = getFilter().getPostState(this, getMostRecentLineNum(), potentially_alteredLine);
      if(state.doAbortIterator())  {
         abortIterator("post-filter");
         return;
      }

      //Do not abort

      if(state.isOff()  &&  isEveryLineAptrUseableAndInRange())  {
         getDebugAptrEveryLine().appentln(getDebuggingPrefix() + " getPostState(this, original_line, potentially_alteredLine) is OFF.");
      }
   }
   protected boolean isEveryLineAptrUseableAndInRange()  {
      return  getDebugAptrEveryLine().isUseable()  &&  getEveryLineDebugRange().isIn(getMostRecentLineNum());
   }
   public StringBuilder appendParentChainName(StringBuilder to_appendTo, String separator)  {
      try  {
         to_appendTo.append(getName());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      RawParentEntity<L> parent = getParent();
      while(parent != null)  {
         to_appendTo.insert(0, separator).insert(0, parent.getName());
         parent = parent.getParent();
      }
      return  to_appendTo;
   }
   /**
      @return  <CODE>{@link #appendToString(StringBuilder) appendToString}(new StringBuilder()).toString()</CODE>
    **/
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   /**
      @param  to_appendTo May not be {@code null}.
      @see  #toString()
    **/
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("\"");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      appendParentChainName(to_appendTo, "/").append("\", ").
         append(getType()).append(", getMostRecentLineNum()=").append(getMostRecentLineNum());

      if(doAbortIterator())  {
         to_appendTo.append(", doAbortIterator()=true");
      }

      if(isRequired())  {
         to_appendTo.append(", isRequired()=true");
      }

      to_appendTo.append(LINE_SEP).append(" >>> Alterer info: ");
      super.appendToString(to_appendTo);//.append("\", rules: {{");
//		return  appendRules(to_appendTo).append("}}");
      return  to_appendTo;
   }
   protected static final <L> ValueAlterer<L,L> getAltererCopyCrashIfMayDelete(ValueAlterer<L,L> alterer, String alterer_varName)  {
      if(alterer.mayDelete())  {
         throw  new IllegalArgumentException(alterer_varName + ".mayDelete() is true.");
      }
      try  {
         return  alterer.getObjectCopy();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting " + alterer_varName + ".getObjectCopy()");
      }
   }
   /**
      <P><I>Do not use</I>--Use {@code getAlteredPostResetCheck} instead.</P>

      @exception  UnsupportedOperationException
    **/
   public final RawLineEntity<L> getObjectCopy()  {
      throw  new UnsupportedOperationException("Use getAlteredPostResetCheck");
   }
   public String getDebuggingPrefix()  {
      return  getDebuggingPrefixPrefix() + "]";
   }
   protected String getDebuggingPrefixPrefix()  {
      return  "[" + getMostRecentLineNum() + ":" + getType() +
         ":\"" + getName() + "\"" +
         (isActive() ? ":active" : "") +
         (doAbortIterator() ? ":ABORT_ITERATOR" : "");
   }
   protected void crashIfRequiredAndNeverActive()  {
      if(!isRequired())  {
         return;
      }

      if(getFullyActiveCount() == 0)  {
         throw  new LineEntityException(-1, null, this, "Entity is required, but was not found in the input.");
      }
   }
}
