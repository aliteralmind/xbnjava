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
   import  java.util.Objects;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.keyed.SimpleNamed;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.linefilter.entity.raw.RawEntityOnOffListener;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.linefilter.entity.raw.z.RawLineEntity_Fieldable;
   import  com.github.xbn.number.CrashIfIntIs;
   import  java.util.Objects;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>The base class for all entities.</P>

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder RawLineEntity_CfgForNeeder}</H3>

   <P><UL>
      <LI>YYY</LI>
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#reset()
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#debugLineNumbers(Appendable)
   com.github.xbn.linefilter.entity.raw.z.RawLineEntity_CfgForNeeder#chainID(boolean, Object)
   </UL></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class RawLineEntity<O,L extends RawLine<O>> extends AbstractValueAlterer<L,O> implements RawChildEntity<O,L>   {
   private final RawParentEntity<O,L> parent         ;
   private final RawParentEntity<O,L> topParent      ;
   private final int                  levelsBelowRoot;
   private final SimpleNamed          smplNamed      ;
   private final TextAppenter         dbgAptrLineNums;
   private final EntityType           type           ;
   private final RawEntityOnOffListener<O,L> listener;
   private final TextAppenter        dbgAptrEveryLine;
   private final LengthInRangeValidator rangeForEveryLineDebug;
   private int fullyActiveCount ;
   private int mostRecentLineNum;
   /**
      <P>Create a new and <I>temporarily unusable</I> instance from a fieldable.</P>

      @param  fieldable  May not be {@code null}, and all its fields must conform to the restrictions as documented in the setters of all sub-classes (<CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/SingleLineEntity.html#cfg">SingleLineEntity</A></CODE>, <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/BlockEntity.html#cfg">BlockEntity</A></CODE>, <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/StealthBlockEntity.html#cfg">StealthBlockEntity</A></CODE>).
    **/
   public RawLineEntity(RawLineEntity_Fieldable<O,L> fieldable)  {
      super();

      declareMayDelete(false);

      try  {
         type = fieldable.getType();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable, "fieldable", null, rx);
      }
      Objects.requireNonNull(type, "fieldable.getType()");

      smplNamed = new SimpleNamed(fieldable.getName());
      if(smplNamed.getName().indexOf('_') != -1)  {
         throw  new IllegalArgumentException("fieldable.getName() (\"" + fieldable.getName() + "\") contains an underscore. Underscores are used to separate parent names from their children names.");
      }
      levelsBelowRoot = -1;
      resetCountsLET();
      listener = fieldable.getListener();
      Objects.requireNonNull(listener, "fieldable.getListener()");

      parent = null;
      topParent = null;

      dbgAptrLineNums = NewTextAppenterFor.appendableUnusableIfNull(
         fieldable.getDebugApblLineNumbers());
      dbgAptrEveryLine = null;
      rangeForEveryLineDebug = null;

      resetLineStateRLE();
   }
   protected RawLineEntity(RawLineEntity<O,L> to_copy, int levels_belowRoot, RawParentEntity<O,L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      super(to_copy);

      type = to_copy.getType();
      CrashIfIntIs.lessThanZero(levels_belowRoot, "levels_belowRoot", null);
      listener = to_copy.getListener().getObjectCopy();

      if(parent == null)  {
         if(levels_belowRoot != 0)  {
            throw  new IllegalArgumentStateException("parent=null, levels_belowRoot=" + levels_belowRoot + ". Root entity must have a levels-below of zero.");
         }
         this.parent = null;
         try  {
            @SuppressWarnings("unchecked")
            RawParentEntity<O,L> top2 = (RawParentEntity<O,L>)to_copy;
            topParent = top2;
         }  catch(ClassCastException ccx)  {
            throw  new ClassCastException("parent is null, but to_copy (" + to_copy.getClass().getName() + ") is not a RawParentEntity<O,L>: " + ccx);
         }
         smplNamed = new SimpleNamed(to_copy.smplNamed.getName());
         levelsBelowRoot = 0;
      }  else  {
         if(levels_belowRoot < 1)  {
            throw  new IllegalArgumentStateException("parent=null, levels_belowRoot=" + levels_belowRoot + ". Non-root entity must have a levels-below greater than zero.");
         }

//			StringBuilder nameBldr = new StringBuilder(to_copy.smplNamed.getName());
         RawParentEntity<O,L> top2 = parent;
         try  {
            while(top2 != null)  {
//					nameBldr.insert(0, '_').insert(0, top2.getName());
               top2 = top2.getParent();
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(parent, "parent", null, rx);
         }
         this.parent = parent;
         topParent = top2;
//			smplNamed = new SimpleNamed(nameBldr.toString());
         smplNamed = new SimpleNamed(to_copy.smplNamed.getName());
         levelsBelowRoot = levels_belowRoot;
      }

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

      @see  com.github.xbn.linefilter.FilteredIterator#FilteredIterator(Iterator, Returns, Appendable, LengthInRangeValidator, RawBlockEntity)
    **/
   public TextAppenter getDebugAptrEveryLine()  {
      return  dbgAptrEveryLine;
   }
   public LengthInRangeValidator getEveryLineDebugRange()  {
      return  rangeForEveryLineDebug;
   }
   public RawParentEntity<O,L> getParent()  {
      return  parent;
   }
   public RawParentEntity<O,L> getTopParent()  {
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
   public int getParentCount()  {
      return  levelsBelowRoot;
   }
   public TextAppenter getDebugAptrLineNumbers()  {
      return  dbgAptrLineNums;
   }
   public RawEntityOnOffListener<O,L> getListener()  {
      return  listener;
   }
   public int getFullyActiveCount()  {
      return  fullyActiveCount;
   }
   protected void incrementFullyActiveCount()  {
      fullyActiveCount++;
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
   protected void declareAltered(int num, Altered altered, NeedsToBeDeleted deleted)  {
      if(!isInitialized())  {
         throw  new IllegalStateException("isInitialized()=false");
      }

      declareAltered(altered, deleted);

      CrashIfIntIs.lessThan(num, (getMostRecentLineNum() + 1), "num", "(getMostRecentLineNum() + 1)", null);
      mostRecentLineNum = num;
   }
   protected boolean isEveryLineAptrUseableAndInRange(int line_num)  {
      return  getDebugAptrEveryLine().isUseable()  &&  getEveryLineDebugRange().isValid(line_num);
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
      to_appendTo.append(getType()).append(", name=\"").append(getName()).append("\" (").
         append((getParentCount() == 0) ? "root entity"
            :  "getParentCount()=" + (new Integer(getParentCount())).toString()).
         append(")").append(LINE_SEP).append(" >>> Alterer info: ");
      super.appendToString(to_appendTo);//.append("\", rules: {{");
//		return  appendRules(to_appendTo).append("}}");
      return  to_appendTo;
   }
   protected static final <L,O> ValueAlterer<L,O> getAltererCopyCrashIfMayDelete(ValueAlterer<L,O> alterer, String alterer_varName)  {
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
   public final RawLineEntity<O,L> getObjectCopy()  {
      throw  new UnsupportedOperationException("Use getAlteredPostResetCheck");
   }
   protected String getDebuggingPrefix(int line_num)  {
      return  getDebuggingPrefixPrefix(line_num) + "] ";
   }
   protected String getDebuggingPrefixPrefix(int line_num)  {
      return  "[" + line_num + ":" + getType() + ":\"" + getName() + "\"";
   }
}
