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
/**
   <P>A {@code ValueAlterer} that does nothing--the original and altered values are equal.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ReturnValueUnchanged<V,A> extends AbstractValueAlterer<V,A>  {
   private final boolean wasAlteredFlag;
   public ReturnValueUnchanged()  {
      this(AlwaysSetWasAlteredTo.TRUE);
   }
   public ReturnValueUnchanged(AlwaysSetWasAlteredTo set_wasAlteredTo)  {
      super();
      wasAlteredFlag = set_wasAlteredTo.isTrue();
      if(isDebugOn()) { getDebugAptr().appentln("ReturnValueUnchanged.doSetWasAlteredFlagToOnEachCall()=" + doSetWasAlteredFlagToOnEachCall()); }
   }
   public ReturnValueUnchanged(ReturnValueUnchanged<V,A> to_copy)  {
      super(to_copy);
      wasAlteredFlag = to_copy.doSetWasAlteredFlagToOnEachCall();
   }
   public boolean doSetWasAlteredFlagToOnEachCall()  {
      return  wasAlteredFlag;
   }
   public final A getAlteredPostResetCheck(V ignored, A to_alter)  {
      declareWasAnalyzedWasDeleted(doSetWasAlteredFlagToOnEachCall(), false);
      return  to_alter;
   }
   /**
      @return  <CODE>(new {@link #ReturnValueUnchanged(ReturnValueUnchanged) ReturnValueUnchanged}&lt;A&gt;(this))</CODE>
    **/
   public ReturnValueUnchanged<V,A> getObjectCopy()  {
      return  (new ReturnValueUnchanged<V,A>(this));
   }
   public static final <V,A> ReturnValueUnchanged<V,A> newForOnEachCallSetWasAlteredTo(boolean was_alteredFlag)  {
      return  (new ReturnValueUnchanged<V,A>(was_alteredFlag ? AlwaysSetWasAlteredTo.TRUE : AlwaysSetWasAlteredTo.FALSE));
   }
}
