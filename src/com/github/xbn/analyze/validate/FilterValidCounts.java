/*
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */
package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.lang.ExpirableComposer;
   import  com.github.xbn.io.SimpleDebuggable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.analyze.validate.z.FilterValidCounts_Fieldable;
/**
   <P>A valid-result filter that changes the result based on the number of valid, invalid, or total analysis counts.</P>

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg FilterValidCounts_Cfg}</H3>

   <P><UL>
      <LI><B>Convenience builders:</B> {@link com.github.xbn.analyze.validate.NewValidResultFilterFor NewValidResultFilterFor}</LI>
      <LI><B>Count what?</B> <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countAll() countAll}()</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countInvalid() countInvalid}()</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countValid() countValid}()</CODE>
      </LI>
      <LI><B>Pre:</B> <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) preActionBelowInAfter}(fpa,fpa,fpa)</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#preActionProceed_afterFalse() preActionProceed_afterFalse}()</CODE></LI>
      <LI><B>Post:</B> <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter}(fpv,fpv,fpv)</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#inUnchangedOutFalse() inUnchangedOutFalse}()</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#unfiltered() unfiltered}()</CODE></LI>
      <LI><B>Pre and post:</B> <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValueAlwaysUnchanged() postValueAlwaysUnchanged}()</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValue_inUnchanged_outFalse() postValue_inUnchanged_outFalse}()</CODE></LI>
      <LI><B>Other:</B> <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#range(LengthInRange) range}(lir)</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#chainID(boolean, Object) chainID}(b,o)</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#debugTo(Appendable) debugTo}(apbl)</CODE>, <CODE>{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#reset() reset}()</CODE></LI>
   </UL></P>

   <P>{@code java com.github.xbn.examples.analyze.validate.ValidResultFilterXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FilterValidCounts extends SimpleDebuggable implements ValidResultFilter, FilterValidCounts_Fieldable  {
   //configuration
   private final LengthInRange     lir;
   private final FilterCountType   vfc;
   private final FilterAfterValue  fPostBlw;
   private final FilterAfterValue  fPostIn;
   private final FilterPreAction   fPreIn;
   private final FilterAfterValue  fPostAftr;
   private final FilterPreAction   fPreAftr;
   private final FilterPreAction   fPreBlw;
   private final ExpirableComposer ec;

   //counts
   private final ValidCounter validCounts;
   private final CountGetter countGtr;
   /**
      <P>Create a new instance.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.io.SimpleDebuggable#SimpleDebuggable(GetDebugApbl_Fieldable) super}(fieldable)</LI>
         <LI>Sets <I>and validates</I> all fields from {@code fieldable}</LI>
         <LI>Sets {@link #doesExpire() doesExpire}{@code ()} to
         <BR> &nbsp; &nbsp; <CODE>(fieldable.{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Fieldable#getAfterPreAction() getAfterPreAction}().{@link FilterPreAction#isReturn() isReturn}()  ||  !fieldable.{@link com.github.xbn.analyze.validate.z.FilterValidCounts_Fieldable#getAfterAfterValue() getAfterAfterValue}().{@link FilterAfterValue#isUnchanged() isUnchanged}())</CODE></LI>
      </OL></P>

      @see  #FilterValidCounts(FilterValidCounts) this(fvc)
    **/
   public FilterValidCounts(FilterValidCounts_Fieldable fieldable)  {
      super(fieldable);

      crashIfBadFieldsFVC(fieldable);

      vfc = fieldable.getFilterCountType();
      lir = fieldable.getRange();
      fPostAftr = fieldable.getAfterAfterValue();
      fPostBlw = fieldable.getBelowAfterValue();
      fPostIn = fieldable.getInAfterValue();
      fPreAftr = fieldable.getAfterPreAction();
      fPreBlw = fieldable.getBelowPreAction();
      fPreIn = fieldable.getInPreAction();

      if(lir.getMin() == 0)  {
         throw  new IllegalArgumentException("fieldable.getRange().getMin() is zero: " + lir.getMinBound());
      }

      validCounts = new ValidCounter();

      countGtr = getCountGetter(vfc, validCounts);

      ec = new ExpirableComposer(fPreAftr.isReturn()  ||  !fPostAftr.isUnchanged());
   }
   /**
      <P>Crash if any fields are invalid, as specified throughout the setter functions in the builder: {@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder z.FilterValidCounts_CfgForNeeder}</P>
    **/
   public static final void crashIfBadFieldsFVC(FilterValidCounts_Fieldable fieldable)  {
      if(fieldable.getRange() == null)  {
         throw  new NullPointerException("fieldable.getRange() (set range(lir))");
      }
      if(fieldable.getBelowAfterValue() == null)  {
         throw  new NullPointerException("fieldable.getBelowAfterValue() (set with postValueBelowInAfter(fpv,fpv,fpv)");
      }
      if(fieldable.getInAfterValue() == null)  {
         throw  new NullPointerException("fieldable.getInAfterValue() (set with postValueBelowInAfter(fpv,fpv,fpv)");
      }
      if(fieldable.getAfterAfterValue() == null)  {
         throw  new NullPointerException("fieldable.getAfterAfterValue() (set with postValueBelowInAfter(fpv,fpv,fpv)");
      }
      if(fieldable.getBelowPreAction() == null)  {
         throw  new NullPointerException("fieldable.getBelowPreAction() (set with preActionBelowInAfter(fpa,fpa,fpa)");
      }
      if(fieldable.getInPreAction() == null)  {
         throw  new NullPointerException("fieldable.getInPreAction() (set with preActionBelowInAfter(fpa,fpa,fpa)");
      }
      if(fieldable.getAfterPreAction() == null)  {
         throw  new NullPointerException("fieldable.getAfterPreAction() (set with preActionBelowInAfter(fpa,fpa,fpa)");
      }
      try  {
         if(!fieldable.getFilterCountType().isAll()  &&
               (!fieldable.getBelowPreAction().isProceed()  ||  !fieldable.getInPreAction().isProceed()))  {
            throw  new IllegalArgumentStateException("fieldable.getFilterCountType() is FilterCountType." + fieldable.getFilterCountType() + ". fieldable.getBelowPreAction() (" + fieldable.getBelowPreAction() + ") and fieldable.getInPreAction() (" + fieldable.getInPreAction() + ") must both be PROCEED. (Otherwise the follows-rules-inverted valid/invalid-count will never increase.)");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable.getFilterCountType(), "fieldable.getFilterCountType()", "set with count*().", rx);
      }
   }
   /**
      <P>Create a new instance as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.io.SimpleDebuggable#SimpleDebuggable(Debuggable) super}(to_copy)</LI>
         <LI>Sets all fields from {@code to_copy}</LI>
      </OL></P>

      @see  #FilterValidCounts(FilterValidCounts_Fieldable) this(fvc_f)
    **/
   public FilterValidCounts(FilterValidCounts to_copy)  {
      super(to_copy);
      vfc = to_copy.getFilterCountType();
      lir = to_copy.getRange();
      fPostAftr = to_copy.getAfterAfterValue();
      fPostBlw = to_copy.getBelowAfterValue();
      fPostIn = to_copy.getInAfterValue();
      fPreAftr = to_copy.getAfterPreAction();
      fPreBlw = to_copy.getBelowPreAction();
      fPreIn = to_copy.getInPreAction();
      validCounts = new ValidCounter(to_copy.validCounts);
      countGtr = getCountGetter(vfc, validCounts);
      ec = new ExpirableComposer(to_copy);
   }
      private static final CountGetter getCountGetter(FilterCountType fc_t, ValidCounter counter)  {
         //Delta, so vf_c doesn't need to be checked each time.
         return  (fc_t.isAll()
            ?  new CGAll(counter, fc_t)
            :  (fc_t.isValid()
               ?  new CGValid(counter, fc_t)
               :  new CGInvalid(counter, fc_t)));
      }

   /**
      <P>The min-max range the count must conform to.</P>

      @return  A non-{@code null} {@code LengthInRange}.
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#range(LengthInRange range) range(lir)
    **/
   public LengthInRange getRange()  {
      return  lir;
   }
   /**
      <P>What is counted?.</P>

      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countAll() FilterValidCounts_Cfg#countAll()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countInvalid() FilterValidCounts_Cfg#countInvalid()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#countValid() FilterValidCounts_Cfg#countValid()
    **/
   public FilterCountType getFilterCountType()  {
      return  vfc;
   }
   /**
      <P>What does the pre-filter do when the count is below the range?.</P>

      <P><I>See:</I><UL>
         <LI><B>Pre:</B> {@code getBelowPreAction()}, {@link #getInPreAction() getInPreAction}{@code ()}, {@link #getAfterPreAction() getAfterPreAction}{@code ()}</LI>
         <LI><B>Post:</B> {@link #getBelowAfterValue() getBelowAfterValue}{@code ()}, {@link #getInAfterValue() getInAfterValue}{@code ()}, {@link #getAfterAfterValue() getAfterAfterValue}{@code ()}</LI>
      </UL></P>

      @see  #getRange()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) FilterValidCounts_Cfg#preActionBelowInAfter(fpa,fpa,fpa)
    **/
   public FilterPreAction getBelowPreAction()  {
      return  fPreBlw;
   }
   /**
      <P>What does the post-filter return when the count is below the range?.</P>

      @see  #getBelowPreAction()
      @see  #getInAfterValue()
      @see  #getAfterAfterValue()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter(fpv,fpv,fpv)
    **/
   public FilterAfterValue getBelowAfterValue()  {
      return  fPostBlw;
   }
   /**
      <P>What does the pre-filter do when the count is in the range?.</P>

      @see  #getBelowPreAction()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) FilterValidCounts_Cfg#preActionBelowInAfter(fpa,fpa,fpa)
    **/
   public FilterPreAction getInPreAction()  {
      return  fPreIn;
   }
   /**
      <P>What does the post-filter return when the count is in the range?.</P>

      @see  #getBelowAfterValue()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter(fpv,fpv,fpv)
    **/
   public FilterAfterValue getInAfterValue()  {
      return  fPostIn;
   }
   /**
      <P>What does the pre-filter do on the iteration <I>after</I> the count has reached the range-maximum?.</P>

      @see  #getBelowPreAction()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) FilterValidCounts_Cfg#preActionBelowInAfter(fpa,fpa,fpa)
    **/
   public FilterPreAction getAfterPreAction()  {
      return  fPreAftr;
   }
   /**
      <P>What does the post-filter return on the iteration <I>after</I> the count has reached the range-maximum?.</P>

      @see  #getBelowAfterValue()
      @see  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg#postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter(fpv,fpv,fpv)
    **/
   public FilterAfterValue getAfterAfterValue()  {
      return  fPostAftr;
   }
   /**
      <P>Get the pre-filter action, given the current count and expiration.</P>

      @return  If {@link #isExpired() isExpired}{@code ()} is<UL>
         <LI>{@code true}: {@link #getAfterPreAction() getAfterPreAction}{@code ()}</LI>
            <LI>Greater than the {@link #getRange() range} maxumum: {@link #getBelowPreAction() getBelowPreAction}{@code ()}</LI>
            <LI>Between the range minimum and maximum (inclusive): {@link #getInPreAction() getInPreAction}{@code ()} &nbsp; &nbsp; (If <B>equal</B> to the maximum and
            <BR> &nbsp; &nbsp;
            <CODE>getBelowPreAction().{@link FilterPreAction#isReturn() isReturn}()</CODE>
            <BR>is {@code true}, then {@link #isExpired() isExpired}{@code ()} is set to {@code true})</LI>
         </UL><B>Note:</B> No counts are incremented by this function. {@link FilterValidCounts} only count the number of times the <I>something</I> is validated against the <I><B>rules</B></I>, and it [post {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inversion}] is determined to be valid.)
      @see  #getAfterValueFromInvertedRules(boolean) getAfterValueFromInvertedRules(b)
    **/
   public FilterPreAction getPreAction()  {
      if(isDebugOn())  { getDebugAptr().appentln("<FVC> getPreAction(): " + toString()); }

      if(isExpired())  {
         FilterPreAction fpa = getAfterPreAction();
         if(isDebugOn()) { getDebugAptr().appentln("<FVC>    isExpired()=true. returning FilterPreAction." + getAfterPreAction() + ", " + countGtr); }
         return  fpa;
      }

      int iCount = countGtr.getCount();
      int iMinCmprdToCount = getRange().getInclMinComparedToOrIfNoMin(iCount, 0);
      int iMaxCmprdToCount = getRange().getInclMaxComparedToOrIfNoMax(iCount, 0);

      FilterPreAction fpa = null;
      if(iMinCmprdToCount > 0)  {            //(count < min)
         fpa = getBelowPreAction();

      //ELSE: count is greater-than-or-equal-to min
      }  else  {
         if(iMaxCmprdToCount > 0)  {          //(count < max)
            //In bounds
            fpa = getInPreAction();

         }  else if(iMaxCmprdToCount == 0)  { //(count == max)
            fpa = getInPreAction();

            if(fpa.isReturn())  {
               if(isDebugOn())  { getDebugAptr().appentln("<FVC>    Max bound reached and getAfterPreAction().isReturn() is true. Expiring"); }

               ec.declareExpired_4prot();
            }
         }
      }

      if(isDebugOn())  {
         getDebugAptr().appentln("<FVC>    Returning FilterPreAction." + fpa + ". FilterCountType." + countGtr.fct + "=" + iCount + ", " + countGtr);
      }

      return  fpa;
   }
   /**
      <P>Get the post-filter action, given the current count, expiration, and if the (post-inverted) rules are followed. This increases {@link #getAnalyzedCount() getAnalyzedCount}{@code ()} by one.</P>

      @param  are_postInvertRulesFollowed  Does the <I>something</I> follow the rules? If {@code true}, the rules are followed (or it doesn't, but the rules are {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}). When {@code true}, {@link #getValidCount() getValidCount}{@code ()} are increased by one. When {@code false}, {@link #getInvalidCount() getInvalidCount}{@code ()} is increased. <B>Note:</B> {@link FilterValidCounts} only count the number of times the <I>something</I> is validated against the <I><B>rules</B></I>, and it [post inversion] is determined to be valid. Regardless the {@code FilterAfterValue} returned by this function, the counts are only affected by the value of this parameter.)
      @return  If {@link #isExpired() isExpired}{@code ()} is<UL>
         <LI>{@code true}: {@link #getAfterAfterValue() getAfterAfterValue}{@code ()}</LI>
         <LI>{@code false}: If the {@link #getFilterCountType() count} is<UL>
            <LI>Greater than the {@link #getRange() range} maxumum: {@link #getBelowAfterValue() getBelowAfterValue}{@code ()}</LI>
            <LI>Between the range minimum and maximum (inclusive): {@link #getInAfterValue() getInAfterValue}{@code ()} &nbsp; &nbsp; <I>(If <B>equal</B> to the maximum, then {@link #isExpired() isExpired}{@code ()} is set to {@code true})</I></LI>
         </UL></LI>
      </UL>
      @see  #getPreAction()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules()
    **/
   public FilterAfterValue getAfterValueFromInvertedRules(boolean are_postInvertRulesFollowed)  {
      getDebugAptr().appentln("<FVC>    getAfterValueFromInvertedRules(" + are_postInvertRulesFollowed + ")");

      validCounts.declareValid(are_postInvertRulesFollowed);

      if(isExpired())  {
         FilterAfterValue fpv = getAfterAfterValue();

//			boolean bValid = ValidResultFilterUtil.getPostReturnValueFromInvertedRules(fpv, are_postInvertRulesFollowed);

         if(isDebugOn()) { getDebugAptr().appentln("<FVC>       isExpired()=true. returning FilterAfterValue." + getAfterAfterValue() + ", " + countGtr); }

         return  fpv;
      }

      int iCount = countGtr.getCount();
      int iMinCmprdToCount = getRange().getInclMinComparedToOrIfNoMin(iCount, 0);
      int iMaxCmprdToCount = getRange().getInclMaxComparedToOrIfNoMax(iCount, 0);

      FilterAfterValue fpv = null;
      if(iMinCmprdToCount > 0)  {            //(count < min)
         fpv = getBelowAfterValue();

      //ELSE: count is greater-than-or-equal-to min
      }  else  {
         if(iMaxCmprdToCount > 0)  {          //(count < max)
            //In bounds
            fpv = getInAfterValue();

         }  else if(iMaxCmprdToCount == 0)  { //(count == max)
            fpv = getInAfterValue();
            if(isDebugOn())  { getDebugAptr().appentln("<FVC>       Max bound reached. Expiring"); }
            ec.declareExpired_4prot();
         }
      }
      if(isDebugOn())  {
         getDebugAptr().appentln("<FVC>    getAfterValueFromInvertedRules(" + are_postInvertRulesFollowed + ")=" + fpv + ". " + countGtr.fct + "=" + countGtr.getCount() + ", range=<" + getRange().getRules() + ">], " + countGtr);
      }
      return  fpv;
   }
   /**
      @see  #FilterValidCounts(FilterValidCounts_Fieldable) this(fvc_f)
    **/
   public boolean doesExpire()  {
      return  ec.doesExpire();
   }
   /**
      @see  #getPreAction()
      @see  #getAfterValueFromInvertedRules(boolean) getAfterValueFromInvertedRules(b)
    **/
   public boolean isExpired()  {
      return  ec.isExpired();
   }
   /**
      <P>How many times has the <I>something</I> been analyzed against the rules?.</P>

      @see  #getValidCount()
      @see  #getInvalidCount()
      @see  #getAfterValueFromInvertedRules(boolean) getAfterValueFromInvertedRules(b)
    **/
   public int getAnalyzedCount()  {
      return  validCounts.getAnalyzedCount();
   }
   /**
      <P>How many times has the <I>something</I> been analyzed against the rules, and (post-inversion) deemed valid?.</P>

    	@see  #getAnalyzedCount()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules()
    **/
   public int getValidCount()  {
      return  validCounts.getValidCount();
   }
   /**
      <P>How many times has the <I>something</I> been analyzed against the rules, and (post-inversion) deemed invalid?.</P>

    	@see  #getAnalyzedCount()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules()
    **/
   public int getInvalidCount()  {
      return  validCounts.getInvalidCount();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public  boolean doesNothing()  {
      return  (getBelowPreAction().isProceed()  &&
         getBelowAfterValue().isUnchanged()  &&
         getInPreAction().isProceed()  &&
         getInAfterValue().isUnchanged()  &&
         getAfterPreAction().isProceed()  &&
         getAfterAfterValue().isUnchanged());
   }

   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         if(doesNothing())  {
            return  to_appendTo.append("unfiltered");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      to_appendTo.append("range=").append(getRange()).append(", ");
      to_appendTo.append(countGtr.toString()).
         append(", FilterCountType.").append(countGtr.fct).append(", below=[pre=").
         append(getBelowPreAction()).append(",post=").
         append(getBelowAfterValue()).append("]").append(", in=[").
         append(getInPreAction()).append(",").append(getInAfterValue()).append("], after=[").
         append(getAfterPreAction()).append(",").
         append(getAfterAfterValue()).append("], ");
      return  ec.appendToString(to_appendTo);
   }
   /**
      <P>Duplicate this <CODE>FilterValidCounts</CODE>.</P>

      @return  <CODE>(new <A HREF="#FilterValidCounts(FilterValidCounts)">FilterValidCounts</A>(this))</CODE>
    **/
   public FilterValidCounts getObjectCopy()  {
      return  (new FilterValidCounts(this));
   }
   /**
    	@return  <CODE>true</CODE> If {@code to_compareTo} is non-{@code null}, a {@code FilterValidCounts}, and all its fields {@linkplain #areFieldsEqual(FilterValidCounts) are equal}. This is implemented as suggested by Joshua Bloch in &quot;Effective Java&quot; (2nd ed, item 8, page 46).
    **/
   @Override
   public boolean equals(Object to_compareTo)  {
      //Check for object equality first, since it's faster than instanceof.
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof FilterValidCounts))  {
         //to_compareTo is either null or not an FilterValidCounts.
         //java.lang.Object.object(o):
         // "For any non-null reference value x, x.equals(null) should return false."
         //See the bottom of this class for a counter-argument (which I'm not going with).
         return  false;
      }

      //Safe to cast
      FilterValidCounts o = (FilterValidCounts)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   /**
      <P>Are all relevant fields equal?.</P>

      @param  to_compareTo  May not be {@code null}.
    **/
   public boolean areFieldsEqual(FilterValidCounts to_compareTo)  {
      try  {
         return  (getRange().equals(to_compareTo.getRange())  &&
            getFilterCountType() ==  to_compareTo.getFilterCountType()  &&
            getBelowAfterValue() ==  to_compareTo.getBelowAfterValue()  &&
            getInAfterValue() ==  to_compareTo.getInAfterValue()  &&
            getInPreAction() ==  to_compareTo.getInPreAction()  &&
            getAfterAfterValue() ==  to_compareTo.getAfterAfterValue()  &&
            getAfterPreAction() ==  to_compareTo.getAfterPreAction()  &&
            doesExpire() ==  to_compareTo.doesExpire()  &&
            isExpired() ==  to_compareTo.isExpired());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_compareTo, "to_compareTo", null, rx);
      }
   }
   public int hashCode()  {
      return  27 * getRange().hashCode() +
         getFilterCountType().ordinal() +
         getBelowAfterValue().ordinal() +
         getInAfterValue().ordinal() +
         getInPreAction().ordinal() +
         getAfterAfterValue().ordinal() +
         getAfterPreAction().ordinal() +
         (doesExpire() ? 1 : 0) +
         (isExpired() ? 1 : 0);
   }

}
abstract class CountGetter  {
   protected final ValidCounter validCounts;
   public final FilterCountType fct;
   public CountGetter(ValidCounter counter, FilterCountType fc_t)  {
      validCounts = counter;
      fct = fc_t;
   }
   public abstract int getCount();
   public String toString()  {
      return  "follows-rules-inverted:" + validCounts.toString();
   }
}
class CGAll extends CountGetter  {
   public CGAll(ValidCounter counter, FilterCountType fc_t)  {
      super(counter, fc_t);
   }
   public int getCount()  {
      return  validCounts.getAnalyzedCount();
   }
}
class CGValid extends CountGetter  {
   public CGValid(ValidCounter counter, FilterCountType fc_t)  {
      super(counter, fc_t);
   }
   public int getCount()  {
      return  validCounts.getValidCount();
   }
}
class CGInvalid extends CountGetter  {
   public CGInvalid(ValidCounter counter, FilterCountType fc_t)  {
      super(counter, fc_t);
   }
   public int getCount()  {
      return  validCounts.getAnalyzedCount() - validCounts.getValidCount();
   }
}
class ValidCounter  {
   private int iVld  ;
   private int iInvld;
   public ValidCounter()  {
      resetVC();
   }
   public ValidCounter(ValidCounter to_copy)  {
      iVld = to_copy.getValidCount();
      iInvld = to_copy.getInvalidCount();
   }
   public void reset()  {
      resetVC();
   }
   protected final void resetVC()  {
      iVld  = 0;
      iInvld = 0;
   }
   public void declareValid(boolean is_valid)  {
      if(is_valid)  {
         iVld++;
      }  else  {
         iInvld++;
      }
   }
   public int getAnalyzedCount()  {
      return  (getValidCount() + getInvalidCount());
   }
   public int getValidCount()  {
      return  iVld;
   }
   public int getInvalidCount()  {
      return  iInvld;
   }
   public String toString()  {
      return  "analyzed/valid/invalid=[" + getAnalyzedCount() + "," + getValidCount() + "," + getInvalidCount() + "]";
   }
}
