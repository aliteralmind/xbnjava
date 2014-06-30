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
package  com.github.xbn.linefilter.entity.raw.z;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity RawStealthBlockEntity}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class RawStealthBlockEntity_CfgForNeeder<L,M extends RawStealthBlockEntity<L>,R extends Needer> extends RawLineEntity_CfgForNeeder<L,M,R> implements RawStealthBlockEntity_Fieldable<L>  {
   public ValueValidator<L> startValidator;
   public ValueValidator<L> endValidator  ;
//constructors...START
   /**
      <P>Create a new instance.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RawLineEntity_CfgForNeeder.html#RawLineEntity_CfgForNeeder(R, com.github.xbn.linefilter.entity.EntityType, java.lang.String)">super</A>(needer, {@link com.github.xbn.linefilter.entity.EntityType}.{@link com.github.xbn.linefilter.entity.EntityType#STEALTH_BLOCK STEALTH_BLOCK}, name)</CODE></LI>
         <LI>{@link #resetRSBECFN() resetRSBECFN}{@code ()}</LI>
      </OL></P>
    **/
   public RawStealthBlockEntity_CfgForNeeder(R needer, String name)  {
      super(needer, EntityType.STEALTH_BLOCK, name);
      resetRSBECFN();
   }
   /**
      <P>Reverts configuration so a line never matches.</P>

      <P>Equal to {@link #resetRSBECFN() resetRSBECFN}{@code ()}</P>

      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> reset()  {
      resetRSBECFN();
      return  this;
   }
   /**
      <P>Reset configuration specific to this {@code RawStealthBlockEntity_CfgForNeeder}.</P>

      <P>This calls<UL>
         <LI><CODE>{@link #startValidator(ValueValidator) startValidator}(null)</CODE></LI>
         <LI><CODE>{@link #endValidator(ValueValidator) endValidator}(null)</CODE></LI>
      </UL></P>

      @see  #reset()
    **/
   protected final void resetRSBECFN()  {
      startValidator(null);
      endValidator(null);
   }
//self-returning setters...START
   /**
      <P>Output the line number of each start and end line in block.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
      dbgApblLineNums = dest_ifNonNull;
      return  this;
   }
   /**
      <P>Set the validator that detects the start line.</P>

      @param  start_validator  May not be {@code null}, and <CODE>start_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</CODE> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getStartValidator() getStartValidator}{@code ()}*
      @return  <I>{@code this}</I>
      @see  #endValidator(ValueValidator) endValidator
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startValidator(ValueValidator<L> start_validator)  {
      startValidator = start_validator;
      return  this;
   }
   /**
      <P>Set the validator that detects the end line.</P>

      @param  end_validator  May not be {@code null}, and <CODE>end_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</CODE> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getEndValidator() getEndValidator}{@code ()}*
      @return  <I>{@code this}</I>
      @see  #endValidator(ValueValidator) endValidator
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> endValidator(ValueValidator<L> end_validator)  {
      endValidator = end_validator;
      return  this;
   }
   /**
      <P>Set the on-off filter.</P>

      @param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> filter(RawOnOffEntityFilter<L> filter)  {
      filterIfNonNull = filter;
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//self-returning setters...END
   public String toString()  {
      return  super.toString() + ", getStartValidator()=" + getStartValidator() + ", getEndValidator()=" + getEndValidator();
   }
   /**
      <P>Create a new {@code RawStealthBlockEntity} as configured.</P>

      @return  <CODE>(M)(new xbn.text.line.RawStealthBlockEntity#RawStealthBlockEntity(RawStealthBlockEntity_Fieldable)&lt;O,L&gt;(this))</CODE>
    **/
   public M build()  {
      @SuppressWarnings("unchecked")
      M m = (M)(new RawStealthBlockEntity<L>(this));
      return  m;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
      Class<M> cblmo = (Class<M>)(Class)RawStealthBlockEntity.class;
      startConfig(needer, cblmo);
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
      startConfigReturnNeedable(needer, needed_class);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
//getters...START
   public ValueValidator<L> getStartValidator()  {
      return  startValidator;
   }
   public ValueValidator<L> getEndValidator()  {
      return  endValidator;
   }
//getters...END
}
