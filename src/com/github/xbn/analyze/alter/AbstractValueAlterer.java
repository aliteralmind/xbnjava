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
   import  com.github.xbn.analyze.AnalyzerComposer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.analyze.Analyzer;
/**
   <P>Abstract implementation of {@code ValueAlterer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractValueAlterer<V,A> implements ValueAlterer<V,A>  {
   private ValueAltererComposer<V,A> avc = null;
   /**
      <P>Create a new {@code AbstractValueAlterer}.</P>

      @see  #AbstractValueAlterer(ValueAlterer) AbstractValueAlterer(ValueAlterer)
    **/
   protected AbstractValueAlterer()  {
      avc = new ValueAltererComposer<V,A>();
   }
   /**
      <P>Create a new {@code AbstractValueAlterer}.</P>

      @see  #AbstractValueAlterer()
    **/
   public AbstractValueAlterer(ValueAlterer<V,A> to_copy)  {
      avc = new ValueAltererComposer<V,A>(to_copy);
   }
   /**
      <P>If the {@code ValueAlterer} needs to have its state reset, crash. This is useful as the first line</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.alter.AltererComposer AltererComposer.}{@link com.github.xbn.analyze.alter.AltererComposer#autoResetStateOrCINeedTo(Analyzer) autoResetStateOrCINeedTo}{@code (this)}</P>
    **/
   public void autoResetStateOrCINeedTo()  {
      AnalyzerComposer.autoResetStateOrCINeedTo(this);
   }
   public String getAlteredString(V to_validate, A to_alter)  {
      A a = getAltered(to_validate, to_alter);
      return  ((a == null) ? null : a.toString());
   }
   public void resetState()  {
      avc.resetState();
   }
   public void resetCounts()  {
      avc.resetCounts();
   }
   public boolean wasAltered()  {
      return  avc.wasAltered();
   }
   public boolean mayDelete()  {
      return  avc.mayDelete();
   }
   protected void declareExpirable()  {
      avc.declareExpirable_4prot();
   }
   protected void declareExpired()  {
      avc.declareExpired_4prot();
   }
   public boolean doesExpire()  {
      return  avc.doesExpire();
   }
   public boolean isExpired()  {
      return  avc.isExpired();
   }
   protected void declareMayDelete(boolean may_del)  {
      avc.declareMayDelete_4prot(may_del);
   }
   public int getAlteredCount()  {
      return  avc.getAlteredCount();
   }
   public int getDeletedCount()  {
      return  avc.getDeletedCount();
   }
   public boolean needsToBeDeleted()  {
      return  avc.needsToBeDeleted();
   }
   public boolean doAutoResetState()  {
      return  avc.doAutoResetState();
   }
   protected void setAutoResetState(boolean is_auto)  {
      avc.setAutoResetState_4prot(is_auto);
   }
   protected void declareAlteredNotDeleted()  {
      avc.declareAlteredNotDeleted_4prot();
   }
   protected void declareWasAnalyzedWasDeleted(boolean was_altered, boolean was_deleted)  {
      avc.declareWasAnalyzedWasDeleted_4prot(was_altered, was_deleted);
   }
   protected void declareDeletedNotAltered()  {
      avc.declareDeletedNotAltered_4prot();
   }
   public void resetForDeletion()  {
      avc.resetForDeletion();
   }
   public int getAnalyzedCount()  {
      return  avc.getAnalyzedCount();
   }
   protected void declareAnalyzed()  {
      avc.declareAnalyzed_4prot();
   }
   public boolean wasAnalyzed()  {
      return  avc.wasAnalyzed();
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      avc.setDebug(destination, is_on);
   }
   public void setDebugOn(boolean is_on)  {
      avc.setDebugOn(is_on);
   }
   public boolean isDebugOn()  {
      return  avc.isDebugOn();
   }
   public final Appendable getDebugApbl()  {
      return  avc.getDebugApbl();
   }
   public final TextAppenter getDebugAptr()  {
      return  avc.getDebugAptr();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  avc.appendToString(to_appendTo);
   }
   public Object getExtraErrInfo()  {
      return  avc.getExtraErrInfo();
   }
   public void setExtraErrInfo(Object info)  {
      avc.setExtraErrInfo(info);
   }
   public final A getAltered(V to_validate, A to_alter)  {
      AltererComposer.autoResetStateOrCINeedTo(this);
      return  getAlteredPostResetCheck(to_validate, to_alter);
   }
   /**
    **/
   public boolean isComplete()  {
      return  avc.isComplete();
   }
   /**
    **/
   public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
      return  avc.appendIncompleteInfo(to_appendTo);
   }
   protected abstract A getAlteredPostResetCheck(V to_validate, A to_alter);
/*stub functions for non-abstract compile...START
 stub functions for non-abstract compile...END*/
}
