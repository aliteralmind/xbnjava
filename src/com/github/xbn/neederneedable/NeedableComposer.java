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
package  com.github.xbn.neederneedable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
/**
   <P>For classes that need to implement {@code Needable}, that cannot extend {@code AbstractNeedable}.</P>

   @see  Needable
   @see  AbstractNeedable
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NeedableComposer<O,R extends Needer> extends ChainableComposer  {//  implements Needable<O,R>  {
//state
   private boolean bNdUsbl      = false;
   private boolean bNdUsblAtStrt = false;
   private boolean bAv2Ndr      = false;
   private R       cndr         = null;
//internal: For error messages
//constructors...START
   /**
      <P>Create a new instance and potentially start configuration--this must be implemented as {@code protected}.</P>

      <P>This calls<OL>
         <LI>{@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer() super}{@code ()}</LI>
         <LI>{@link #declareNeededReset_4prot() declareNeededReset_4prot}{@code ()}</LI>
      </OL></P>

      @param  is_avaliableToNeeders  Get with {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()}.
      @param  is_neededUseableAtInit  If {@code true}, the needed object is useable immediately after a configuration is started. Get with {@link #isNeededUseableAtStart() isNeededUseableAtStart}{@code ()}.
    **/
   @CompositionConstructor
   public NeedableComposer(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit)  {
      super();
      bAv2Ndr = is_avaliableToNeeders;
      bNdUsblAtStrt = is_neededUseableAtInit;
      declareNeededReset_4prot();
   }
//constructors...END
//main...START
   /**
      <P>Immediately reverts to as if a configuration was never started. Under most circumstances, this is called by  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</A>(O)</CODE>. <I>If called manually, the {@link #getActiveNeeder() active needer} will be left in an unstable state.</I></P>

      <P>This<OL>
         <LI>Sets {@code getActiveNeeder()} to {@code null}</LI>
         <LI>Sets {@link #isNeededUsable() isNeededUsable}{@code ()} to {@code false}</LI>
         <LI>Calls  <CODE><I>[{@link com.github.xbn.neederneedable.SimpleChainable super}]</I>.{@link com.github.xbn.neederneedable.SimpleChainable#unsetChainID(boolean) unsetChainID}(false)</CODE></LI>
      </OL></P>

      <H3><I>Does this interact acceptably with directly-used {@code Needables}?</I></H3>
    **/
   @CompositionFunction
   public void declareNeededReset_4prot()  {
      cndr = null;
      bNdUsbl = isNeededUseableAtStart();
      unsetChainID(false);
   }
   /**
      <P>Start configuration with a default object--this must be implemented as {@code protected} with the name &quot;{@code startConfig}&quot;.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link #ciActive_4prot() ciActive_4prot}()</CODE></LI>
         <LI>Calls <CODE>needer.{@link com.github.xbn.neederneedable.Needer#startConfig(Class) startConfig}(expected_type)</CODE></LI>
         <LI>Sets {@link #getActiveNeeder() getActiveNeeder}{@code ()} to {@code needer}</LI>
      </OL></P>

      @param  needer  May not be equal to <I>{@code this}</I> (for situations where classes implement both {@code Needable} and {@code Needer}. See {@link com.github.xbn.neederneedable.NeedableWithSubsComposer NeedableWithSubsComposer}).

      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</A>(O)</CODE>
      @see  #declareNeededUseable_4prot(boolean) declareNeededUseable_4prot(b)
    **/
   @CompositionFunction
   public void startConfig_4prot(R needer, Class<O> expected_type)  {
      if(needer == this)  {
         throw  new IllegalArgumentException("needer is the SAME OBJECT as this Needable.");
      }
      ciActive_4prot();
      try  {
         needer.startConfig(expected_type);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(needer, "needer", null, rx);
      }
      cndr = needer;
   }
   /**
      <P>Sets the fully configured object into the {@code Needer} and then ends configuration--this must be implemented as {@code protected} with the name &quot;{@code endCfgWithNeededReturnNeeder}&quot;.</P>

      <P>This<OL>
         <LI>Calls
         <BR> &nbsp; &nbsp; {@link #getActiveNeeder() getActiveNeeder}{@code ().}{@link com.github.xbn.neederneedable.Needer#neeadableSetsNeeded(Object) neeadableSetsNeeded}{@code ()}</LI>
         <LI>Calls {@link #declareNeededReset_4prot() declareNeededReset_4prot}{@code ()} (which sets {@code getActiveNeeder()} to {@code null}).</LI>
         <LI>Returns the (now inactive) {@code Needer}.</LI>
      </OL></P>
      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</A>(R,cls)</CODE>
    **/
   @CompositionFunction
   public R endCfgWithNeededReturnNeeder_4prot(O fully_configured)  {
      ciInactive_4prot();
      if(!isNeededUsable())  {
         throw  new IllegalStateException("isNeededUsable() is false.");
      }

      getActiveNeeder().neeadableSetsNeeded(fully_configured);

      R cndr = getActiveNeeder();
      declareNeededReset_4prot();  //Sets getActiveNeeder() to null.
      return  cndr;
   }
//main...END
//setters...START
   /**
      <P>Declare that {@code endCfg()} may be safely called.--this must be implemented as {@code protected} with the name &quot;{@code declareNeededUseable}&quot;.</P>

      @param  is_usable  If {@code null}, the needed object is ready for use. It may be configured further, or may be retrieved immediately (by first ending the configuration).
      @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null}.
      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</A>(R,cls)</CODE>
    **/
   @CompositionFunction
   public void declareNeededUseable_4prot(boolean is_usable)  {
      ciInactive_4prot();
      bNdUsbl = is_usable;
   }
//setters...END
//getters...START
   /**
      @see  #declareNeededUseable_4prot(boolean)
    **/
   @CompositionFunction
   public boolean isNeededUsable()  {
      ciInactive_4prot();
      return  bNdUsbl;
   }
   /**
      @see  #NeedableComposer(boolean, boolean)
    **/
   @CompositionFunction
   public boolean isNeededUseableAtStart()  {
      return  bNdUsblAtStrt;
   }
   @CompositionFunction
   public R getActiveNeeder()  {
      return  cndr;
   }
   /**
      @see  #NeedableComposer(boolean, boolean)
    **/
   @CompositionFunction
   public boolean isAvailableToNeeder()  {
      return  bAv2Ndr;
   }
//getters...END
//other...START
   //Not a composition-function, because super.toString() already is
   public String toString()  {
      return  super.toString() +
         ((getActiveNeeder() != null) ? ", isNeededUsable()=" + isNeededUsable() : "") +
         ", isNeededUseableAtStart()=" + isNeededUseableAtStart() + ", isAvailableToNeeder()=" + isAvailableToNeeder() + ", getActiveNeeder()=[" + getActiveNeeder() + "]";
   }
   /**
         <P>If a configuration is active, crash.</P>

      @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is non-{@code null}.

      @see  #ciInactive_4prot()
    **/
   @CompositionFunction
   public void ciActive_4prot()  {
      if(getActiveNeeder() != null)  {
         throw  new IllegalStateException("Must endCfg(). getActiveNeeder()=[" + getActiveNeeder() + "]");
      }
   }
   /**
         <P>If no configuration is active, crash.</P>

      @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null}.
      @see  #ciActive_4prot() ciActive_4prot(s)
    **/
   @CompositionFunction
   public void ciInactive_4prot()  {
      if(getActiveNeeder() == null)  {
         throw  new IllegalStateException("Must startConfigReturnNeedable(cndr). getActiveNeeder()=null");
      }
   }
//other...END
}
