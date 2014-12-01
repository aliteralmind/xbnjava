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
package  com.github.xbn.linefilter;
   import  com.github.xbn.lang.ExceptionUtil;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  com.github.xbn.linefilter.entity.raw.RawEntity;
   import  com.github.xbn.linefilter.entity.raw.RawSingleLineEntity;
   import  com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.number.NewLengthInRangeFor;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.text.padchop.z.VzblPadChop_Cfg;
   import  com.github.xbn.util.itr.AbstractIterator;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Objects;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>An iterator that filters the elements of another iterator--keeping or discarding those that meet certain conditions, and optionally modifying kept elements.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FilteredIterator<L> extends AbstractIterator<L>  {
   private final RawBlockEntity<L> rootBlock             ;
   private final Returns             returnWhat            ;
   private final TextAppenter        dbgAptrEveryLine      ;
   private final LengthInRange       rangeForEveryLineDebug;
   private Iterator<L>    allLineItr     ;
   protected int          nextLineNum    ;
   protected L            nextLine       ;
   private int            lineNumAnalyzed;
   private RawEntity<L> entityThatAbrtd;
   private static final VzblPadChop VPC_DBG = new VzblPadChop_Cfg(70).
      trim().unescape().cfgChop().ddd().inMiddle().endCfg().build();
   /**
      <p>Create a new instance with a root-block.</p>

    * @param  all_lineItr  The lines to filter. May not be {@code null}.
    * @param  return_what  Which lines should be returned by {@link #next() next}{@code ()}? If<ul>
         <li>{@link com.github.xbn.linefilter.Returns#KEPT KEPT}: Only lines explicitely marked as {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() keepable}.</li>
         <li>{@link com.github.xbn.linefilter.Returns#ACTIVE ACTIVE}: Only lines that are {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() matched} (and potentially modified) by the root block or one of its children.</li>
         <li>{@link com.github.xbn.linefilter.Returns#ALL ALL}: All lines, where unmatched lines are returned unchanged, and matched lines may be modified.</li>
      </ul>May not be {@code null}. Get with {@link #getReturnsWhat() getReturnsWhat}{@code ()}.
    * @param  dbgEveryLine_ifNonNull  If non-{@code null}, information on each line is output by this. Get with {@link #getDebugAptrEveryLine() getDebugAptrEveryLine}{@code ()}.
    * @param  rangeForEveryLineDebug_ifNonNull  If non-{@code null}, this is the line range to debug with {@code dbgAptrEveryLine_ifUseable}. If {@code null}, all lines are debugged. Get with {@link #getEveryLineDebugRange() getEveryLineDebugRange}{@code ()}
    * @param  root_block  Represents the text-document itself, or the largest block within the document that is recognized. May not be {@code null}. Get with {@link #getRawRootBlock() getRawRootBlock}{@code ()}.
    */
   public FilteredIterator(Iterator<L> all_lineItr, Returns return_what, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, RawBlockEntity<L> root_block)  {
      Objects.requireNonNull(return_what, "return_what");
      returnWhat = return_what;

      dbgAptrEveryLine = NewTextAppenterFor.appendableUnusableIfNull(
         dbgEveryLine_ifNonNull);
      rangeForEveryLineDebug = ((rangeForEveryLineDebug_ifNonNull == null)
         ?  NewLengthInRangeFor.UNRESTRICTED
         :  rangeForEveryLineDebug_ifNonNull);

      rootBlock = root_block.getCopyWithParentAssigned(0, null, dbgAptrEveryLine, rangeForEveryLineDebug);
//		rootBlock = new RawBlockEntity<L>(root_block, 0, null, dbgAptrEveryLine, rangeForEveryLineDebug);
      nextLineNum = -1;
      nextLine = null;
      lineNumAnalyzed = 0;
      entityThatAbrtd = null;
      setAllIterator(all_lineItr);
   }
   public boolean wasAllIteratorSet()  {
      if(wasAborted())  {
         return  true;
      }
      return  (allLineItr != null);
   }
   public void setAllIterator(Iterator<L> all_lineItr)  {
      if(wasAllIteratorSet())  {
         throw  new IllegalStateException("wasAllIteratorSet()=true");
      }
      allLineItr = all_lineItr;

      if(allLineItr != null)  {
         hasNext();    //Must be last!
      }
   }
   /**
      <p>What lines are retured by this iterator?.</p>

    * @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    */
   public Returns getReturnsWhat()  {
      return  returnWhat;
   }
   public boolean wasAborted()  {
      return  (getEntityThatAborted() != null);
   }
   public RawEntity<L> getEntityThatAborted()  {
      return  entityThatAbrtd;
   }
   /**
      <p>The outputter for diagnostics on every analyzed line.</p>

    * @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    */
   public TextAppenter getDebugAptrEveryLine()  {
      return  dbgAptrEveryLine;
   }
   public LengthInRange getEveryLineDebugRange()  {
      return  rangeForEveryLineDebug;
   }
   /**
      <p>Is there another line to retrieve?.</p>

    * @return  <ul>
         <li>{@code true}: {@link #next() next}{@code ()} may be safely called.</li>
         <li>{@code false}: No more lines.</li>
      </ul>
    */
   public boolean hasNext()  {
      if(nextLine != null)  {
         return  true;
      }
      if(wasAborted())  {
         return  false;
      }
      L nextLineFromAllItr = null;
      try  {
         while(allLineItr.hasNext())  {
            lineNumAnalyzed++;
            nextLineFromAllItr = allLineItr.next();

            if(isEveryLineAptrUseableAndInRange())  {
               getDebugAptrEveryLine().appentln(getRawRootBlock().getDebuggingPrefix() + " all_lineItr.next() (pre-filtered): " + VPC_DBG.get(nextLineFromAllItr));
            }

            L alteredBody = getRawRootBlock().getAltered(getMostRecentLineNum(), nextLineFromAllItr, nextLineFromAllItr);
            if(getRawRootBlock().doAbortIterator())  {
               allLineItr = null;
               entityThatAbrtd = getRawRootBlock().getEntityThatAborted();
               if(isEveryLineAptrUseableAndInRange())  {
                  getDebugAptrEveryLine().appentln(getRawRootBlock().getDebuggingPrefix() + " *ABORTED* by entity: " + getEntityThatAborted());
               }

               return  false;
            }

            if(getReturnsWhat().isKept())  {
               if(getRawRootBlock().doKeepJustAnalyzed())  {
                  return  setNextLineReturnTrue(alteredBody);
               }

            }  else if(getReturnsWhat().isActive())  {
               if(getRawRootBlock().isActive())  {
                  return  setNextLineReturnTrue(alteredBody);
               }

            }  else if(getReturnsWhat().isAll())  {
               return  setNextLineReturnTrue(alteredBody);

            }  else  {
               throw  new IllegalStateException("Unknown value for getReturnsWhat(): " + getReturnsWhat());
            }
         }
      }  catch(RuntimeException rx)  {
         if(!wasAllIteratorSet())  {
            throw  new IllegalStateException("Must setAllIterator(itr)", rx);
         }
         CrashIfObject.nnull(nextLineFromAllItr, "all_lineItr.next()", null);
         throw  CrashIfObject.nullOrReturnCause(allLineItr, "all_lineItr", null, rx);
      }

      getRawRootBlock().declareEndOfInput();

      return  false;
   }
   /**
      <p>. Set the next line to be returned by {@code next()}.</p>

      <p>This sets {@link #next() next}{@code ()} to {@code altered_body}</p>

    * @param  altered_body  <i>Should</i> not be {@code null}.
    * @see  FilteredLineIterator#setNextLineReturnTrue(String)
    */
   protected boolean setNextLineReturnTrue(L altered_body)  {
      nextLineNum = getMostRecentLineNum();
      nextLine = altered_body;
      debugNextLine(nextLine);
      return  true;
   }
   /**
      <p>. Outputs diagnostics on the just analyzed (and potentially matched and modified) line.</p>

    * @param  altered_line  May not be {@code null}.
    * @see  #getDebugAptrEveryLine()
    */
   protected void debugNextLine(L altered_line)  {
      if(isEveryLineAptrUseableAndInRange())  {
         getDebugAptrEveryLine().appentln(getRawRootBlock().getDebuggingPrefix() + " getReturnsWhat()." + getReturnsWhat() + ". Setting next() to: " + altered_line + "");
      }
   }
   public int getMostRecentLineNum()  {
      return  lineNumAnalyzed;
   }
   public int getNextLineNum()  {
      return  nextLineNum;
   }
   protected boolean isEveryLineAptrUseableAndInRange()  {
      return  getDebugAptrEveryLine().isUseable()  &&  getEveryLineDebugRange().isIn(getMostRecentLineNum());
   }
   /**
      <p>Returns the next filtered line.</p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#setNextLineReturnTrue(L)">setNextLineReturnTrue</a></code>
    */
   public L next()  {
      crashIfNoNext();
      L next2 = nextLine;
      nextLine = null;
      return  next2;
   }
   /**
      <p>The top-most block entity, representing the document itself.</p>

    * @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    * @since  0.1.2
    */
   public RawBlockEntity<L> getRawRootBlock()  {
      return  rootBlock;
   }
   /**
      <p>The currently-active child entity.</p>

    * @return  <code>({@link #getRawActiveChild() getRawActiveChild}() != null)</code>
    * @since  0.1.1
    */
   public boolean hasActiveChild()  {
      return  (getRawActiveChild() != null);
   }
   /**
      <p>The currently-active child entity.</p>

    * @return  <code>{@link #getRawRootBlock() getRawRootBlock}().{@link RawBlockEntity#getRawActiveChild() getRawActiveChild}()</code>
    * @since  0.1.2
    */
   public RawChildEntity<L> getRawActiveChild()  {
      return  getRawRootBlock().getRawActiveChild();
   }
   /**
      <p>The type of the currently-active child.</p>

    * @exception  IllegalStateException  If {@link #hasActiveChild() hasActiveChild}{@code ()} is {@code false}.
    */
   public EntityType getActiveChildType()  {
      try  {
         return  getRawActiveChild().getType();
      }  catch(NullPointerException npx)  {
         throw  new IllegalStateException("hasActiveChild() is false.");
      }
   }
   /**
      <p>Get the active child, which <i>is</i> a block.</p>

    * @return  <code>(RawBlockEntity&lt;L,L&gt;){@link #getRawActiveChild() getRawActiveChild}()</code>
    * @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#BLOCK BLOCK}.
    * @exception  IllegalStateException  If {@link #hasActiveChild() hasActiveChild}{@code ()} is {@code false}.
    * @see  #getRawActiveChildStealthBlock()
    * @see  #getRawActiveChildSingleLine()
    * @since  0.1.2
    */
   public RawBlockEntity<L> getRawActiveChildBlock()  {
      try  {
         RawBlockEntity<L> rbe = (RawBlockEntity<L>)getRawActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         throw  newClassCastExceptionForUnexepectedActiveChildType(ccx);
      }
   }
   /**
      <p>Get the active child, which <i>is</i> a stealth block.</p>

    * @return  <code>(RawStealthBlockEntity&lt;L,L&gt;){@link #getRawActiveChild() getRawActiveChild}()</code>
    * @exception  IllegalStateException  If {@link #hasActiveChild() hasActiveChild}{@code ()} is {@code false}.
    * @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#STEALTH_BLOCK STEALTH_BLOCK}.
    * @see  #getRawActiveChildBlock()
    * @since  0.1.2
    */
   public RawStealthBlockEntity<L> getRawActiveChildStealthBlock()  {
      try  {
         RawStealthBlockEntity<L> rbe = (RawStealthBlockEntity<L>)getRawActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         throw  newClassCastExceptionForUnexepectedActiveChildType(ccx);
      }
   }
   /**
      <p>Get the active child, which <i>is</i> a single-line entity.</p>

    * @return  <code>(RawSingleLineEntity&lt;L,L&gt;){@link #getRawActiveChild() getRawActiveChild}()</code>
    * @exception  IllegalStateException  If {@link #hasActiveChild() hasActiveChild}{@code ()} is {@code false}.
    * @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#SINGLE_LINE SINGLE_LINE}.
    * @see  #getRawActiveChildBlock()
    * @since  0.1.2
    */
   public RawSingleLineEntity<L> getRawActiveChildSingleLine()  {
      try  {
         RawSingleLineEntity<L> rbe = (RawSingleLineEntity<L>)getRawActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         throw  newClassCastExceptionForUnexepectedActiveChildType(ccx);
      }
   }
      private ClassCastException newClassCastExceptionForUnexepectedActiveChildType(ClassCastException cause)  {
         return  ExceptionUtil.returnCauseSetIntoThrowable(cause,
            new ClassCastException("getActiveChildType()=" + getActiveChildType() + ", getRawActiveChild().getClass().getName()=" + getRawActiveChild().getClass().getName()));
      }
   /**
      <p>Immutable list of all child entities.</p>

    * @return  <code>{@link #getRawRootBlock() getRawRootBlock}().{@link RawBlockEntity#getChildList() getChildList}()</code>
    */
   List<RawChildEntity<L>> getEntityList()  {
      return  getRawRootBlock().getRawChildList();
   }
   /**
    * @return  <code>{@link #appendToString(StringBuilder) appendToString}(new StringBuilder()).toString()</code>
    */
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   /**
    * @param  to_appendTo May not be {@code null}.
    * @see  #toString()
    */
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("Returns.").append(getReturnsWhat()).append(", getNextLineNum()=").append(getNextLineNum()).append(", getMostRecentLineNum()=").append(getMostRecentLineNum()).append(", ").append((getEntityThatAborted() == null) ? ""
               :  "getEntityThatAborted()=" + getEntityThatAborted() + ", ").
         append("getRawRootBlock()={(<[").append(LINE_SEP).
               append(getRawRootBlock()).append(LINE_SEP).append("]>)}");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
}
