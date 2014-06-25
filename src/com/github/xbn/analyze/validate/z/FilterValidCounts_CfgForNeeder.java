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
package  com.github.xbn.analyze.validate.z;
   import  com.github.xbn.analyze.validate.FilterPreAction;
   import  com.github.xbn.analyze.validate.FilterCountType;
   import  com.github.xbn.analyze.validate.FilterAfterValue;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.FilterValidCounts;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For indirectly configuring a {@link FilterValidCounts}.</P>

   @see  <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A>
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FilterValidCounts_CfgForNeeder<F extends FilterValidCounts,R extends Needer> extends AbstractNeedable<F,R> implements FilterValidCounts_Fieldable  {
   public LengthInRange   liRange            ;
   public FilterCountType vfCountType        ;
   public FilterAfterValue vfPostValForBelow  ;
   public FilterAfterValue vfPostValForIn     ;
   public FilterAfterValue vfPostValForAfter  ;
   public FilterPreAction vfPreActionForBelow;
   public FilterPreAction vfPreActionForIn   ;
   public FilterPreAction vfPreActionForAfter;
   public Appendable      apblDebug          ;
//constructors...START
   /**
      <P>Create a new instance.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="AbstractValidator_CfgForNeeder.html#AbstractValidator_CfgForNeeder(boolean, boolean, R)">super</A>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</CODE></LI>
         <LI>{@link #resetVVN() resetVVN}{@code ()}</LI>
      </OL></P>
    **/
   public FilterValidCounts_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
      resetVVN();
   }
   /**
      <P>Reset all configuration so the filter does nothing.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #resetVVN() resetVVN}{@code ()}</P>

      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> reset()  {
      resetVVN();
      return  this;
   }
   /**
      <P>Reset configuration specific to this {@code FilterValidCounts_CfgForNeeder}.</P>

      <P>This<OL>
         <LI>{@link #unfiltered() unfiltered}{@code ()}</LI>
         <LI>{@link #debugTo(Appendable) debugTo}{@code (null)}</LI>
      </OL></P>
    **/
   protected final void resetVVN()  {
      unfiltered();
      debugTo(null);
   }
//constructors...END
//setters...START
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      <P>Set the range that the count must conform to.</P>

      @param  range  May not be {@code null}, and its {@linkplain com.github.xbn.number.IntInRange#getMin() minimum} may not be zero. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}{@code ()}.
      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> range(LengthInRange range)  {
      liRange = range;
      return  this;
   }
   /**
      <P>Do not filter at all.</P>

      <P>This calls<OL>
         <LI><CODE>{@link #range(LengthInRange) range}({@link com.github.xbn.number.LengthInRange LengthInRange}.{@link com.github.xbn.number.LengthInRange#UNRESTRICTED UNRESTRICTED})</CODE></LI>
         <LI>{@link #postValueAlwaysUnchanged() postValueAlwaysUnchanged}{@code ()}</LI>
         <LI><CODE>{@link #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction)}({@link com.github.xbn.analyze.validate.FilterPreAction FilterPreAction}.{@link com.github.xbn.analyze.validate.FilterPreAction#PROCEED PROCEED}, FilterPreAction.PROCEED, FilterPreAction.PROCEED)</CODE></LI>
         <LI>{@link #countValid() countValid}{@code ()}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> unfiltered()  {
      range(LengthInRange.UNRESTRICTED);
      postValueAlwaysUnchanged();
      preActionBelowInAfter(FilterPreAction.PROCEED, FilterPreAction.PROCEED, FilterPreAction.PROCEED);
      return  countValid();
   }
   /**
      <P>If the count is above or below range, return {@code false}, otherwise return true if the <I>something</I> follows-the-rules (post inversion).</P>

      <P>This calls<OL>
         <LI>{@link #preActionProceed_afterFalse() preActionProceed_afterFalse}{@code ()}</LI>
         <LI>{@link #postValue_inUnchanged_outFalse() postValue_inUnchanged_outFalse}{@code ()}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules()
    **/
   public FilterValidCounts_CfgForNeeder<F,R> inUnchangedOutFalse()  {
      preActionProceed_afterFalse();
      return  postValue_inUnchanged_outFalse();
   }
   /**
      <P><B>Post-filter:</B> If the count is in range, return the follows-the-rules (post-inversion) value unchanged. If it is below or above the range, return {@code false}.</P>

      @return  <CODE>{@link #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter}({@link com.github.xbn.analyze.validate.FilterAfterValue FilterAfterValue}.{@link com.github.xbn.analyze.validate.FilterAfterValue#FALSE FALSE}, FilterAfterValue.{@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED UNCHANGED}, FilterAfterValue.FALSE)</CODE>
      @see  com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType()*
    **/
   public FilterValidCounts_CfgForNeeder<F,R> postValue_inUnchanged_outFalse()  {
      return  postValueBelowInAfter(FilterAfterValue.FALSE, FilterAfterValue.UNCHANGED, FilterAfterValue.FALSE);
   }
   /**
      <P><B>Post-filter:</B> Always pass the follows-the-rules (post-inversion) value through unchanged.</P>

      @return  <CODE>{@link #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter}({@link com.github.xbn.analyze.validate.FilterAfterValue FilterAfterValue}.{@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED UNCHANGED}, FilterAfterValue.UNCHANGED, FilterAfterValue.FALSE)</CODE>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> postValueAlwaysUnchanged()  {
      return  postValueBelowInAfter(FilterAfterValue.UNCHANGED, FilterAfterValue.UNCHANGED, FilterAfterValue.UNCHANGED);
   }
   /**
      <P>What should the post-filter do?.</P>

      @param  fpv_below  What to do when the {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() count} is below <CODE>{@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}()*.{@link com.github.xbn.number.NumberInRange#getMinNumber() getMinNumber}()</CODE>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getBelowAfterValue() getBelowAfterValue}{@code ()}{@code ()}.
      @param  fpv_in  What to do when the count is <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/number/NumberInRange.html#isValid(N)">valid</A> according to the range?
      @param  fpv_after  What to do when the count is &quot;greater&quot; than <CODE>getRange()*.{@link com.github.xbn.number.NumberInRange#getMaxNumber() getMaxNumber}()</CODE>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getAfterAfterValue() getAfterAfterValue}{@code ()}{@code ()}. <B><I>Note:</I></B> Since the filter is expired when the maximum is reached, it will never be exceeded. This is therefore, more accurately: &quot;What to do when the maximum has been reached, and this is the first (or subsequent) check <I><B>after</B></I> that?&quot;.
      @return  <I>{@code this}</I>
      @see  #unfiltered()
      @see  #inUnchangedOutFalse()
      @see  #postValueAlwaysUnchanged()
      @see  #postValue_inUnchanged_outFalse()
      @see  #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) preActionBelowInAfter(fpa,fpa,fpa)
    **/
   public FilterValidCounts_CfgForNeeder<F,R> postValueBelowInAfter(FilterAfterValue fpv_below, FilterAfterValue fpv_in, FilterAfterValue fpv_after)  {
      vfPostValForBelow = fpv_below;
      vfPostValForIn = fpv_in;
      vfPostValForAfter = fpv_after;
      return  this;
   }
   /**
      <P><B>Pre-filter:</B> If the count is below-or-equal-to the range max, {@code PROCEED}, otherwise, return {@code false}.</P>

      @return  <CODE>{@link #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction)}({@link com.github.xbn.analyze.validate.FilterPreAction FilterPreAction}.{@link com.github.xbn.analyze.validate.FilterPreAction#PROCEED PROCEED}, FilterPreAction.PROCEED, FilterPreAction.{@link com.github.xbn.analyze.validate.FilterPreAction#RETURN_FALSE RETURN_FALSE})</CODE>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> preActionProceed_afterFalse()  {
      return  preActionBelowInAfter(FilterPreAction.PROCEED, FilterPreAction.PROCEED, FilterPreAction.RETURN_FALSE);
   }
   /**
      <P>What should the post-filter do?.</P>

      @param  fpa_below  What to do when the {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() count} is below <CODE>{@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}()*.{@link com.github.xbn.number.NumberInRange#getMinNumber() getMinNumber}()</CODE>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getBelowAfterValue() getBelowAfterValue}{@code ()}{@code ()}.
      @param  fpa_in  What to do when the count is <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/number/NumberInRange.html#isValid(N)">valid</A> according to the range?
      @param  fpa_after  What to do when the count is &quot;greater&quot; than <CODE>getRange()*.{@link com.github.xbn.number.NumberInRange#getMaxNumber() getMaxNumber}()</CODE>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getAfterAfterValue() getAfterAfterValue}{@code ()}{@code ()}. <B><I>Note:</I></B> Since the filter is expired when the maximum is reached, it will never be exceeded. This is therefore, more accurately: &quot;What to do when the maximum has been reached, and this is the first (or subsequent) check <I><B>after</B></I> that?&quot;.
      @return  <I>{@code this}</I>
      @see  #preActionProceed_afterFalse()
      @see  #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter(fpv,fpv,fpv)
      @see  #unfiltered()
    **/
   public FilterValidCounts_CfgForNeeder<F,R> preActionBelowInAfter(FilterPreAction fpa_below, FilterPreAction fpa_in, FilterPreAction fpa_after)  {
      vfPreActionForBelow = fpa_below;
      vfPreActionForIn = fpa_in;
      vfPreActionForAfter = fpa_after;
      return  this;
   }
   /**
      <P>Count every analysis.</P>

      <P>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <CODE>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#ALL ALL}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #countValid()
      @see  #countInvalid()
    **/
   public FilterValidCounts_CfgForNeeder<F,R> countAll()  {
      vfCountType = FilterCountType.ALL;
      return  this;
   }
   /**
      <P>Count only when the <I>something</I> is deemed valid (post-inversion).</P>

      <P>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <CODE>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#VALID VALID}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #countAll()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    **/
   public FilterValidCounts_CfgForNeeder<F,R> countValid()  {
      vfCountType = FilterCountType.VALID;
      return  this;
   }
   /**
      <P>Count only when the <I>something</I> is deemed invalid (post-inversion).</P>

      <P>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <CODE>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#INVALID INVALID}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #countAll()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    **/
   public FilterValidCounts_CfgForNeeder<F,R> countInvalid()  {
      vfCountType = FilterCountType.INVALID;
      return  this;
   }
//setters...END
   public FilterCountType getFilterCountType()  {
      return  vfCountType;
   }
   public LengthInRange getRange()  {
      return  liRange;
   }
   public FilterAfterValue getBelowAfterValue()  {
      return  vfPostValForBelow;
   }
   public FilterAfterValue getInAfterValue()  {
      return  vfPostValForIn;
   }
   public FilterAfterValue getAfterAfterValue()  {
      return  vfPostValForAfter;
   }
   public FilterPreAction getBelowPreAction()  {
      return  vfPreActionForBelow;
   }
   public FilterPreAction getInPreAction()  {
      return  vfPreActionForIn;
   }
   public FilterPreAction getAfterPreAction()  {
      return  vfPreActionForAfter;
   }
   public Appendable getDebugApbl()  {
      return  apblDebug;
   }

   public String toString()  {
      return  super.toString() + ", 	getFilterCountType()=" + getFilterCountType() + ", pre-below/in/after=[" + getBelowPreAction() + "," + getInPreAction() + "," + getAfterPreAction() + "], post-below/in/after=[" + getBelowAfterValue() + "," + getInAfterValue() + "," + getAfterAfterValue() + "], range=<" + getRange().getRules() + ">, getDebugApbl()=[" + getDebugApbl() + "]";
   }

   /**
      <P>Create a new {@code FilterValidCounts} as configured.</P>

      @return  <CODE>(F)(new {@link com.github.xbn.analyze.validate.FilterValidCounts#FilterValidCounts(FilterValidCounts_Fieldable) FilterValidCounts}(this))</CODE>
    **/
   public F build()  {
      @SuppressWarnings("unchecked")
      F f = (F)(new FilterValidCounts(this));
      return  f;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public FilterValidCounts_CfgForNeeder<F,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<F> clsv = (Class<F>)(Class)FilterValidCounts.class;
      startConfig(needer, clsv);
      return  this;
   }
}
