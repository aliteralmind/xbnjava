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
package  com.github.xbn.analyze.alter;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.analyze.validate.Validator;
   import  com.github.xbn.analyze.Analyzer;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.analyze.AnalyzerComposer;
/**
   <P>For classes needing to implement {@code Alterer}, that cannot extend {@code AbstractAlterer}. See {@link com.github.xbn.analyze.alter.AbstractAlterer AbstractAlterer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class AltererComposer extends AnalyzerComposer  {
//state
   private int     iLtrd  ;  //Altered count (includes deletions)
   private int     iDltd  ;  //Deleted count
   private boolean bNtbDel;
   private boolean bWLtrd ;
   private boolean bDnDl  ;
//internal
//constructor...START
   /**
      <P>Create a new {@code AltererComposer}.</P>

      <P>This calls<OL>
         <LI>{@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer() super}{@code ()}</LI>
         <LI>{@link #zresetStateAC() zresetStateAC}{@code ()}</LI>
         <LI>{@link #zresetCountsAC() zresetCountsAC}{@code ()}</LI>
      </OL></P>

      @see  #AltererComposer(boolean, AltererComposer) this(b,ab)
      @see  #AltererComposer(Alterer) this(ltr)
    **/
   public AltererComposer()  {
      super();

      //Never ever call interface functions, directly or indirectly, in a constructor.
      zresetStateAC();
      zresetCountsAC();
   }
   /**
      <P>Create a new {@code AltererComposer} as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(boolean, AnalyzerComposer) super}{@code (ignored, to_copy)}</LI>
         <LI>Sets<OL>
            <LI>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</LI>
            <LI>{@link #getAlteredCount() getAlteredCount}{@code ()} to {@code to_copy.getAlteredCount()}</LI>
            <LI>{@link #getDeletedCount() getDeletedCount}{@code ()} to {@code to_copy.getDeletedCount()}</LI>
         </OL></LI>
         <LI>Calls {@link #zresetStateAC() zresetStateAC}{@code ()} &nbsp; &nbsp; <I>(as specified by  <CODE><I>[{@link com.github.xbn.analyze.Analyzer Analyzer}]</I>.{@link com.github.xbn.analyze.Analyzer#getObjectCopy() getObjectCopy}()</CODE>)</I></LI>
      </OL></P>
      @param  to_copy  May not be {@code null}
      @see  #getObjectCopy()
      @see  #AltererComposer() this()
    **/
   public AltererComposer(boolean ignored, AltererComposer to_copy)  {
      super(ignored, to_copy);
      iLtrd = to_copy.getAlteredCount();
      iDltd = to_copy.getDeletedCount();
      zresetStateAC();
   }
   /**
      <P>Create a new {@code AltererComposer} from an {@code Alterer}.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(Analyzer) super}{@code (to_copy)}</LI>
         <LI>Sets<OL>
            <LI>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</LI>
            <LI>{@link #getAlteredCount() getAlteredCount}{@code ()} to {@code to_copy.getAlteredCount()}</LI>
            <LI>{@link #getDeletedCount() getDeletedCount}{@code ()} to {@code to_copy.getDeletedCount()}</LI>
         </OL></LI>
         <LI>Calls {@link #zresetStateAC() zresetStateAC}{@code ()} &nbsp; &nbsp; <I>(as specified by  <CODE><I>[{@link com.github.xbn.analyze.Analyzer Analyzer}]</I>.{@link com.github.xbn.analyze.Analyzer#getObjectCopy() getObjectCopy}()</CODE>)</I></LI>
      </OL></P>
      @param  to_copy  May not be {@code null}
      @see  #AltererComposer() this()
    **/
   public AltererComposer(Alterer to_copy)  {
      super(to_copy);
      iLtrd = to_copy.getAlteredCount();
      iDltd = to_copy.getDeletedCount();
      zresetStateAC();
   }
//constructor...END
//setters...START
   /**
      <P>Reset non-count state.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #zresetStateAC() zresetStateAC}{@code ()}</P>
    **/
   public void resetState()  {
      super.resetState();
      zresetStateAC();
   }
   /**
      <P>Reset non-count state specific to this {@code AltererComposer}.</P>

      <P>This sets<UL>
         <LI>{@link #wasAltered() wasAltered}{@code ()},</LI>
         <LI>{@link #needsToBeDeleted() needsToBeDeleted}{@code ()}</LI>
      </UL>to {@code false}</P>
    **/
   protected final void zresetStateAC()  {
      bWLtrd = false;
      bNtbDel = false;
   }
   /**
      <P>Reset counters to zero.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #zresetCountsAC() zresetCountsAC}{@code ()}</P>
    **/
   public void resetCounts()  {
      super.resetCounts();
      zresetCountsAC();
   }
   /**
      <P>Reset counters specific to this {@code AltererComposer}.</P>

      <P>Sets<UL>
         <LI>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()},</LI>
         <LI>{@link #getAlteredCount() getAlteredCount}{@code ()}, and</LI>
         <LI>{@link #getDeletedCount() getDeletedCount}{@code ()}</LI>
      </UL>to zero.</P>
    **/
   protected final void zresetCountsAC()  {
      iLtrd = 0;
      iDltd = 0;
   }
   public void declareMayDelete_4prot(boolean may_del)  {
      bDnDl = may_del;
   }
   public void declareWasAnalyzedWasDeleted_4prot(boolean was_altered, boolean was_deleted)  {
      if(was_altered  &&  was_deleted)  {
         throw  new IllegalStateException(getXMsg("was_altered and was_deleted are both true.", getExtraErrInfo()));
      }
      if(was_altered)  {
         declareAlteredNotDeleted_4prot();
      }  else if(was_deleted)  {
         declareDeletedNotAltered_4prot();
      }  else  {
         declareAnalyzed_4prot();
      }
   }
   public void declareAlteredNotDeleted_4prot()  {
      declareAnalyzed_4prot();
      bWLtrd = true;
      bNtbDel = false;
      iLtrd++;
   }
   /**
      <P>Declare that an alteration or deletion occurred.</P>

      <P>This<OL>
         <LI>Calls  <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer super}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#declareAnalyzed_4prot() declareAnalyzed_4prot}()</CODE></LI>
         <LI>Sets {@link #wasAltered() wasAltered}{@code ()} to {@code false}</LI>
         <LI>Sets {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} to {@code true}</LI>
      </OL></P>

      @see  #declareAlteredNotDeleted_4prot()
    **/
   public void declareDeletedNotAltered_4prot()  {
      if(mayDelete())  {
         throw  new IllegalArgumentException("mayDelete() is true.");
      }
      declareAnalyzed_4prot();
      bWLtrd = false;
      bNtbDel = true;
   }
//setters...END
//getters...START
   public boolean wasAltered()  {
      return  bWLtrd;
   }
   /**
      @return  {@code true}  If it is possible that an alteration may {@link #needsToBeDeleted() delete the element}.
      @see  #declareMayDelete_4prot(boolean)
    **/
   public boolean mayDelete()  {
      return  bDnDl;
   }
   public int getAlteredCount()  {
      return  iLtrd;
   }
   public int getDeletedCount()  {
      return  iDltd;
   }
   public boolean needsToBeDeleted()  {
      return  bNtbDel;
   }
   public void declareExpired_4prot()  {
      super.declareExpired_4prot();
      bDnDl = true;
   }
   /**
      @return  <CODE>(({@link #getAlteredCount() getAlteredCount}() != 0))</CODE>
    **/
   public boolean isComplete()  {
      return  (getAlteredCount() != 0);
   }
   /**
      @return  <CODE>{@link #appendToString(StringBuilder) appendToString}(to_appendTo)</CODE>
    **/
   public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
      if(isComplete())  {
         throw  new IllegalStateException("isComplete() is true.");
      }
      return  appendToString(to_appendTo);
   }
//getters...END
//main functionality...START
   public void resetForDeletion()  {
      if(needsToBeDeleted())  {
         iLtrd++;
         iDltd++;
      }
      resetState();
   }
//main functionality...END
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo).append(", ").
         append(mayDelete() ? "may-delete" : "does-not-delete").append(", ");

      if(!wasAltered())  {
         to_appendTo.append("not-altered");
      }  else  {
         to_appendTo.append("altered");
         if(needsToBeDeleted())  {
            to_appendTo.append(" (needsToBeDeleted()=true)");
         }
      }
      to_appendTo.append(", totals:[altered=").append(getAlteredCount()).
         append(", deleted=").append(getDeletedCount()).append("]");
      return  to_appendTo;
   }
   /**
      <P><I>Do not use--override if a copy is needed.</I></P>

      @exception  UnsupportedOperationException
    **/
   public AltererComposer getObjectCopy()  {
      throw  new UnsupportedOperationException("getObjectCopy");
   }
}
