package  com.github.xbn.analyze.validate;
   import  com.github.xbn.analyze.AnalyzerComposer;
   import  com.github.xbn.analyze.validate.z.Validator_Fieldable;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.RuleType;
   import  static com.github.xbn.lang.XbnConstants.*;

/**
   <P>Abstract implementation of {@code Validator}. For classes needing to implement {@code Validator}, that cannot extend this class, see {@code ValidatorComposer}.</P>
 **/
public abstract class AbstractValidator implements Validator  {
   private ValidatorComposer vc = null;
   /**
      <P>Create a new {@code AbstractValidator}.</P>
    **/
   protected AbstractValidator(RuleType type, Validator_Fieldable filter)  {
      vc = new ValidatorComposer(type, filter);
   }
   /**
      <P>Create a new {@code AbstractValidator} as a duplicate of another.</P>

      <P>This<OL>
         <LI>YYY</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   public AbstractValidator(Validator to_copy)  {
      vc = new ValidatorComposer(to_copy);
   }
   public void resetState()  {
      vc.resetState();
   }
   public void resetCounts()  {
      vc.resetCounts();
   }
   public ResultReturnedBy getValidResultSource()  {
      return  vc.getValidResultSource();
   }
   protected boolean declareGetValidFromPreFilterNoInvert(boolean is_valid)  {
      return  vc.declareGetValidFromPreFilterNoInvert_4prot(is_valid);
   }
   protected boolean declareValidForRulesGetInverted(boolean is_valid)  {
      return  vc.declareValidForRulesGetInverted_4prot(is_valid);
   }
   protected void declarePostFilterReturnValue(FilterAfterValue fp_v, boolean is_valid)  {
      vc.declarePostFilterReturnValue_4prot(fp_v, is_valid);
   }
   public int getValidCount()  {
      return  vc.getValidCount();
   }
   public boolean isValid()  {
      return  vc.isValid();
   }
   public boolean doInvertRules()  {
      return  vc.doInvertRules();
   }
   public final RuleType getRuleType()  {
      return  vc.getRuleType();
   }
   public int getAnalyzedCount()  {
      return  vc.getAnalyzedCount();
   }
   protected void declareAnalyzed()  {
      vc.declareAnalyzed_4prot();
   }
   public boolean doesExpire()  {
      return  vc.doesExpire();
   }
   protected void declareExpired()  {
      vc.declareExpired_4prot();
   }
   public boolean isExpired()  {
      return  vc.isExpired();
   }
   public boolean wasAnalyzed()  {
      return  vc.wasAnalyzed();
   }
   public ValidResultFilter getFilter()  {
      return  vc.getFilter();
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      vc.setDebug(destination, is_on);
   }
   public void setDebugOn(boolean is_on)  {
      vc.setDebugOn(is_on);
   }
   public boolean isDebugOn()  {
      return  vc.isDebugOn();
   }
   public Appendable getDebugApbl()  {
      return  getDebugAptr().getAppendable();
   }
   public TextAppenter getDebugAptr()  {
      return  vc.getDebugAptr();
   }
   public Object getExtraErrInfo()  {
      return  vc.getExtraErrInfo();
   }
   public void setExtraErrInfo(Object info)  {
      vc.setExtraErrInfo(info);
   }
   public final String getRules()  {
      return  appendRules(new StringBuilder()).toString();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  vc.appendToString(to_appendTo).append(", getRules()=").append(getRules());
   }
   /**
      @return  <CODE>true</CODE> If <CODE>to_compareTo</CODE> is non-<CODE>null</CODE>, an <CODE>AbstractValidator</CODE>, and <CODE><A HREF="#areFieldsEqual(xbn.lang.AbstractValidator)">areFieldsEqual</A>((AbstractValidator)to_compareTo)</CODE> is <CODE>true</CODE>. <I>This is implemented as suggested by Joshua Bloch in &quot;Effective Java&quot; (2nd ed, item 8, page 46).</I>
    **/
   @Override
   public boolean equals(Object to_compareTo)  {
      //Check for object equality first, since it's faster than instanceof.
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof AbstractValidator))  {
         //to_compareTo is either null or not an AbstractValidator.
         //java.lang.Object.object(o):
         //   "For any non-null reference value x, x.equals(null) should return false."
         //See the bottom of this class for a counter-argument (which I'm not going with).
         return  false;
      }

      //Safe to cast
      AbstractValidator o = (AbstractValidator)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   public boolean areFieldsEqual(Validator to_compareTo)  {
      return  ValidatorComposer.areValidatorFieldsEqual(this, to_compareTo);
   }
   /**
      <P>FUNC_JD_INTRO</P>
      <P>Equal to
      <BR> &nbsp; &nbsp;{@code <A HREF="YYY/ValidatorComposer.html"><I>[ValidatorComposer]</I></A>.<A HREF="YYY/ValidatorComposer.html#setERuleType_4prot(RuleType)">setERuleType_4prot</A>(type)}</P>
    **/
   protected void setERuleType(RuleType type)  {
      vc.setERuleType_4prot(type);
   }
   /**
      <P>FUNC_JD_INTRO</P>
      <P>Equal to
      <BR> &nbsp; &nbsp;{@code <A HREF="YYY/ValidatorComposer.html"><I>[ValidatorComposer]</I></A>.<A HREF="YYY/ValidatorComposer.html#setERuleType_4prot(RuleType, String)">setERuleType_4prot</A>(type, type_name)}</P>
    **/
   protected void setERuleType(RuleType type, String type_name)  {
      vc.setERuleType_4prot(type, type_name);
   }
   protected void autoResetStateOrCINeedTo()  {
      AnalyzerComposer.autoResetStateOrCINeedTo(this);
   }
   public boolean doAutoResetState()  {
      return  vc.doAutoResetState();
   }
   protected void setAutoResetState(boolean is_auto)  {
      vc.setAutoResetState_4prot(is_auto);
   }
/*stub functions for non-abstract compile...START
   public boolean isValid()  {
      return  false;
   }
stub functions for non-abstract compile...END*/
}
