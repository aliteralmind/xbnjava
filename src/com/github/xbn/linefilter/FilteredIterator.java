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
   import  com.github.xbn.linefilter.entity.raw.RawEntity;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  com.github.xbn.linefilter.entity.raw.RawSingleLineEntity;
   import  com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.number.NewLengthInRangeFor;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.text.padchop.z.VzblPadChop_Cfg;
   import  com.github.xbn.util.itr.AbstractIterator;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Objects;
/**
   <P>Iterates through a series of <I>things</I>, keeping or discarding those that meet certain conditions, and optionally modifying kept items.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FilteredIterator<O,L extends RawLine<O>> extends AbstractIterator<L>  {
   private final RawBlockEntity<O,L> rootBlock             ;
   private final Returns             returnWhat            ;
   private final TextAppenter        dbgAptrEveryLine      ;
   private final LengthInRange       rangeForEveryLineDebug;
   private Iterator<O>    allLineItr     ;
   protected L            nextLine       ;
   private int            lineNum        ;
   private RawEntity<O,L> entityThatAbrtd;
   private static final VzblPadChop VPC_DBG = new VzblPadChop_Cfg(70).
      trim().unescape().cfgChop().ddd().inMiddle().endCfg().build();
   /**
      <P>Create a new instance with a root-block.</P>

      @param  all_lineItr  The lines to filter. May not be {@code null}.
      @param  return_what  Which lines should be returned by {@link #next() next}{@code ()}? If<UL>
         <LI>{@link com.github.xbn.linefilter.Returns#KEPT KEPT}: Only lines explicitely marked as {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() keepable}.</LI>
         <LI>{@link com.github.xbn.linefilter.Returns#ACTIVE ACTIVE}: Only lines that are {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() matched} (and potentially modified) by the root block or one of its children.</LI>
         <LI>{@link com.github.xbn.linefilter.Returns#ALL ALL}: All lines, where unmatched lines are returned unchanged, and matched lines may be modified.</LI>
      </UL>May not be {@code null}. Get with {@link #getReturnsWhat() getReturnsWhat}{@code ()}.
      @param  dbgEveryLine_ifNonNull  If non-{@code null}, information on each line is output by this. Get with {@link #getDebugAptrEveryLine() getDebugAptrEveryLine}{@code ()}.
      @param  rangeForEveryLineDebug_ifNonNull  If non-{@code null}, this is the line range to debug with {@code dbgAptrEveryLine_ifUseable}. If {@code null}, all lines are debugged. Get with {@link #getEveryLineDebugRange() getEveryLineDebugRange}{@code ()}
      @param  root_block  Represents the text-document itself, or the largest block within the document that is recognized. May not be {@code null}. Get with {@link #getRootBlock() getRootBlock}{@code ()}.
    **/
   public FilteredIterator(Iterator<O> all_lineItr, Returns return_what, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, RawBlockEntity<O,L> root_block)  {
      Objects.requireNonNull(return_what, "return_what");
      returnWhat = return_what;

      dbgAptrEveryLine = NewTextAppenterFor.appendableUnusableIfNull(
         dbgEveryLine_ifNonNull);
      rangeForEveryLineDebug = ((rangeForEveryLineDebug_ifNonNull == null)
         ?  NewLengthInRangeFor.UNRESTRICTED
         :  rangeForEveryLineDebug_ifNonNull);

      rootBlock = new RawBlockEntity<O,L>(root_block, 0, null, dbgAptrEveryLine, rangeForEveryLineDebug);
      nextLine = null;
      lineNum = 0;
      entityThatAbrtd = null;
      setAllIterator(all_lineItr);
   }
   public boolean wasAllIteratorSet()  {
      if(wasAborted())  {
         return  true;
      }
      return  (allLineItr != null);
   }
   public void setAllIterator(Iterator<O> all_lineItr)  {
      if(wasAllIteratorSet())  {
         throw  new IllegalStateException("wasAllIteratorSet()=true");
      }
      allLineItr = all_lineItr;

      if(allLineItr != null)  {
         hasNext();    //Must be last!
      }
   }
   /**
      <P>What lines are retured by this iterator?.</P>

      @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    **/
   public Returns getReturnsWhat()  {
      return  returnWhat;
   }
   public boolean wasAborted()  {
      return  (getEntityThatAborted() != null);
   }
   public RawEntity<O,L> getEntityThatAborted()  {
      return  entityThatAbrtd;
   }
   /**
      <P>The outputter for diagnostics on every analyzed line.</P>

      @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    **/
   public TextAppenter getDebugAptrEveryLine()  {
      return  dbgAptrEveryLine;
   }
   public LengthInRange getEveryLineDebugRange()  {
      return  rangeForEveryLineDebug;
   }
   /**
      <P>Is there another line to retrieve?.</P>

      @return  <UL>
         <LI>{@code true}: {@link #next() next}{@code ()} may be safely called.</LI>
         <LI>{@code false}: No more lines.</LI>
      </UL>
    **/
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
            lineNum++;
            @SuppressWarnings("unchecked")
            L nextLineFromAllItr2 = (L)new RawLine<O>(lineNum, allLineItr.next());
            nextLineFromAllItr = nextLineFromAllItr2;

            if(isEveryLineAptrUseableAndInRange(lineNum))  {
               getDebugAptrEveryLine().appentln(getRootBlock().getDebuggingPrefix(lineNum) + " all_lineItr.next() (pre-filtered): " + VPC_DBG.get(nextLineFromAllItr));
            }

            O alteredBody = getRootBlock().getAltered(nextLineFromAllItr, nextLineFromAllItr.getBody());
            if(getRootBlock().doAbortIterator())  {
               allLineItr = null;
               entityThatAbrtd = getRootBlock().getEntityThatAborted();
               if(isEveryLineAptrUseableAndInRange(lineNum))  {
                  getDebugAptrEveryLine().appentln(getRootBlock().getDebuggingPrefix(lineNum) + " *ABORTED* by entity: " + getEntityThatAborted());
               }

               return  false;
            }

            if(getReturnsWhat().isKept())  {
               if(getRootBlock().doKeepJustAnalyzed())  {
                  return  setNextLineReturnTrue(lineNum, alteredBody);
               }

            }  else if(getReturnsWhat().isActive())  {
               if(getRootBlock().isActive())  {
                  return  setNextLineReturnTrue(lineNum, alteredBody);
               }

            }  else if(getReturnsWhat().isAll())  {
               return  setNextLineReturnTrue(lineNum, alteredBody);

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

      getRootBlock().declareEndOfInput();

      return  false;
   }
   /**
      <P>. Set the next line to be returned by {@code next()}.</P>

      <P>This sets {@link #next() next}{@code ()} to a
      <BR> &nbsp; &nbsp; <CODE>new <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RawLine.html#RawLine(int, O)">RawLine</A>&lt;O&gt;(next_lineFromAllItr.{@link RawLine#getNumber() getNumber}(), altered_body)</CODE></P>

      @param  line_num  YYY
      @param  altered_body  <I>Should</I> not be {@code null}.
      @see  FilteredLineIterator#setNextLineReturnTrue(int, String)
    **/
   protected boolean setNextLineReturnTrue(int line_num, O altered_body)  {
      @SuppressWarnings("unchecked")
      L l = (L)new RawLine<O>(line_num, altered_body);
      nextLine = l;
      debugNextLine(nextLine);
      return  true;
   }
   /**
      <P>. Outputs diagnostics on the just analyzed (and potentially matched and modified) line.</P>

      @param  altered_line  May not be {@code null}.
      @see  #getDebugAptrEveryLine()
    **/
   protected void debugNextLine(L altered_line)  {
      int lineNum = -1;
      try  {
         lineNum = altered_line.getNumber();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(altered_line, "altered_line", null, rx);
      }
      if(isEveryLineAptrUseableAndInRange(lineNum))  {
         getDebugAptrEveryLine().appentln(getRootBlock().getDebuggingPrefix(lineNum) + " getReturnsWhat()." + getReturnsWhat() + ". Setting next() to: " + altered_line + "");
      }
   }
   protected boolean isEveryLineAptrUseableAndInRange(int line_num)  {
      return  getDebugAptrEveryLine().isUseable()  &&  getEveryLineDebugRange().isIn(line_num);
   }
   /**
      <P>Returns the next filtered line.</P>

      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#setNextLineReturnTrue(L, O)">setNextLineReturnTrue</A></CODE>
    **/
   public L next()  {
      crashIfNoNext();
      L next2 = nextLine;
      nextLine = null;
      return  next2;
   }
   /**
      <P>The top-most block entity, representing the document itself.</P>

      @see  #FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity)
    **/
   public RawBlockEntity<O,L> getRootBlock()  {
      return  rootBlock;
   }
   /**
      <P>The currently-active child entity.</P>

      @return  <CODE>{@link #getRootBlock() getRootBlock}().{@link RawBlockEntity#getActiveChild() getActiveChild}()</CODE>
    **/
   public RawChildEntity<O,L> getActiveChild()  {
      return  getRootBlock().getActiveChild();
   }
   /**
      <P>The type of the currently-active child.</P>

      @exception  IllegalStateException  If {@link #getActiveChild() getActiveChild}{@code ()} is {@code null}.
    **/
   public EntityType getActiveChildType()  {
      try  {
         return  getRootBlock().getActiveChild().getType();
      }  catch(NullPointerException npx)  {
         throw  new IllegalStateException("No active entity. getActiveChild() is null.");
      }
   }
   /**
      <P>Get the active child, which <I>is</I> a block.</P>

      @return  <CODE>(RawBlockEntity&lt;O,L&gt;){@link #getActiveChild() getActiveChild}()</CODE>
      @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#BLOCK BLOCK}.
      @exception  IllegalStateException  If {@link #getActiveChild() getActiveChild}{@code ()} is {@code null}.
      @see  #getActiveChildStealthBlock()
      @see  #getActiveChildSingleLine()
    **/
   public RawBlockEntity<O,L> getActiveChildBlock()  {
      try  {
         @SuppressWarnings("unchecked")
         RawBlockEntity<O,L> rbe = (RawBlockEntity<O,L>)getActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         ClassCastException ccx2 = new ClassCastException("getActiveChildType()=" + getActiveChildType() + ", getActiveChild().getClass().getName()=" + getActiveChild().getClass().getName());
         ccx2.initCause(ccx);
         throw  ccx2;
      }
   }
   /**
      <P>Get the active child, which <I>is</I> a stealth block.</P>

      @return  <CODE>(RawStealthBlockEntity&lt;O,L&gt;){@link #getActiveChild() getActiveChild}()</CODE>
      @exception  IllegalStateException  If {@link #getActiveChild() getActiveChild}{@code ()} is {@code null}.
      @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#STEALTH_BLOCK STEALTH_BLOCK}.
      @see  #getActiveChildBlock()
    **/
   public RawStealthBlockEntity<O,L> getActiveChildStealthBlock()  {
      try  {
         @SuppressWarnings("unchecked")
         RawStealthBlockEntity<O,L> rbe = (RawStealthBlockEntity<O,L>)getActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         ClassCastException ccx2 = new ClassCastException("getActiveChildType()=" + getActiveChildType() + ", getActiveChild().getClass().getName()=" + getActiveChild().getClass().getName());
         ccx2.initCause(ccx);
         throw  ccx2;
      }
   }
   /**
      <P>Get the active child, which <I>is</I> a single-line entity.</P>

      @return  <CODE>(RawSingleLineEntity&lt;O,L&gt;){@link #getActiveChild() getActiveChild}()</CODE>
      @exception  IllegalStateException  If {@link #getActiveChild() getActiveChild}{@code ()} is {@code null}.
      @exception  ClassCastException  If {@link #getActiveChildType() getActiveChildType}{@code ()} is not a {@link EntityType#SINGLE_LINE SINGLE_LINE}.
      @see  #getActiveChildBlock()
    **/
   public RawSingleLineEntity<O,L> getActiveChildSingleLine()  {
      try  {
         @SuppressWarnings("unchecked")
         RawSingleLineEntity<O,L> rbe = (RawSingleLineEntity<O,L>)getActiveChild();
         return  rbe;
      }  catch(ClassCastException ccx)  {
         ClassCastException ccx2 = new ClassCastException("getActiveChildType()=" + getActiveChildType() + ", getActiveChild().getClass().getName()=" + getActiveChild().getClass().getName());
         ccx2.initCause(ccx);
         throw  ccx2;
      }
   }
   /**
      <P>Immutable list of all child entities.</P>

      @return  <CODE>{@link #getRootBlock() getRootBlock}().{@link RawBlockEntity#getChildList() getChildList}()</CODE>
    **/
   List<RawChildEntity<O,L>> getEntityList()  {
      return  getRootBlock().getRawChildList();
   }
}
