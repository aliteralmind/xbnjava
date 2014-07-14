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
   import  com.github.xbn.io.TextAppenter;
/**
   <P>Abstract implementation of {@code Alterer}. Classes needing to implement {@code Alterer}, that cannot extend this class, should use {@link com.github.xbn.analyze.alter.AltererComposer AltererComposer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractAlterer implements Alterer  {
   private AltererComposer ac = null;
   /**
      <P>Create a new instance with defaults.</P>

      <P>Sets the internal composer to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.alter.AltererComposer#AltererComposer() AltererComposer}{@code ()}</P>

      @see  #AbstractAlterer(AlterationRequired)
    **/
   protected AbstractAlterer()  {
      ac = new AltererComposer();
   }
   /**
      <P>Create a new {@code AbstractAlterer} with the required setting.</P>

      <P>Sets the internal composer to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.alter.AltererComposer#AltererComposer(AlterationRequired) AltererComposer}{@code (required)}</P>

      @see  #AbstractAlterer()
      @see  #AbstractAlterer(Alterer)
    **/
   protected AbstractAlterer(AlterationRequired required)  {
      ac = new AltererComposer(required);
   }
   /**
      <P>Create a new {@code AbstractAlterer}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.alter.AltererComposer#AltererComposer(Alterer) super}{@code (to_copy)}</P>

      @see  #AbstractAlterer(AlterationRequired)
    **/
   public AbstractAlterer(Alterer to_copy)  {
      ac = new AltererComposer(to_copy);
   }
   public void resetState()  {
      ac.resetState();
   }
   public void resetCounts()  {
      ac.resetCounts();
   }
   public boolean wasAltered()  {
      return  ac.wasAltered();
   }
   public boolean mayDelete()  {
      return  ac.mayDelete();
   }
   public boolean isRequired()  {
      return  ac.isRequired();
   }
   public boolean doesExpire()  {
      return  ac.doesExpire();
   }
   protected void declareExpirable()  {
      ac.declareExpirable_4prot();
   }
   protected void declareExpired()  {
      ac.declareExpired_4prot();
   }
   public boolean isExpired()  {
      return  ac.isExpired();
   }
   public int getAlteredCount()  {
      return  ac.getAlteredCount();
   }
   public int getDeletedCount()  {
      return  ac.getDeletedCount();
   }
   public boolean needsToBeDeleted()  {
      return  ac.needsToBeDeleted();
   }
   public boolean doAutoResetState()  {
      return  ac.doAutoResetState();
   }
   protected void setAutoResetState(boolean is_auto)  {
      ac.setAutoResetState_4prot(is_auto);
   }
   protected void declareAltered(Altered altered, NeedsToBeDeleted deleted)  {
      ac.declareAltered_4prot(altered, deleted);
   }
   public void resetForDeletion()  {
      ac.resetForDeletion();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  ac.appendToString(to_appendTo);
   }
   public int getAnalyzedCount()  {
      return  ac.getAnalyzedCount();
   }
   protected void declareAnalyzed()  {
      ac.declareAnalyzed_4prot();
   }
   public boolean wasAnalyzed()  {
      return  ac.wasAnalyzed();
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      ac.setDebug(destination, is_on);
   }
   public void setDebugOn(boolean is_on)  {
      ac.setDebugOn(is_on);
   }
   public boolean isDebugOn()  {
      return  ac.isDebugOn();
   }
   public final Appendable getDebugApbl()  {
      return  ac.getDebugApbl();
   }
   public final TextAppenter getDebugAptr()  {
      return  ac.getDebugAptr();
   }
   public final TextAppenter debug(Object message)  {
      return  ac.debug(message);
   }
   public final void debugln(Object message)  {
      ac.debugln(message);
   }
   public Object getExtraErrInfo()  {
      return  ac.getExtraErrInfo();
   }
   public void setExtraErrInfo(Object info)  {
      ac.setExtraErrInfo(info);
   }
   /**
    **/
   public boolean isComplete()  {
      return  ac.isComplete();
   }
   /**
    **/
   public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
      return  ac.appendIncompleteInfo(to_appendTo);
   }
}
