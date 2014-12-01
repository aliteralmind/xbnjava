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
package  com.github.xbn.analyze.validate;
   import  com.github.xbn.analyze.AnalyzerComposer;
   import  com.github.xbn.analyze.validate.z.Validator_Fieldable;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.RuleType;
/**
   <p>Abstract implementation of {@code Validator}. For classes needing to implement {@code Validator}, that cannot extend this class, see {@code ValidatorComposer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public abstract class AbstractValidator implements Validator  {
   private ValidatorComposer vc = null;
   /**
      <p>Create a new {@code AbstractValidator}.</p>
    */
   protected AbstractValidator(RuleType type, Validator_Fieldable filter)  {
      vc = new ValidatorComposer(type, filter);
   }
   /**
      <p>Create a new {@code AbstractValidator} as a duplicate of another.</p>

      <p>This<ol>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
    */
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
   public TextAppenter debug(Object message)  {
      return  vc.debug(message);
   }
   public void debugln(Object message)  {
      vc.debugln(message);
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
    * @return  <code>true</code> If <code>to_compareTo</code> is non-<code>null</code>, an <code>AbstractValidator</code>, and <code><a href="#areFieldsEqual(xbn.lang.AbstractValidator)">areFieldsEqual</a>((AbstractValidator)to_compareTo)</code> is <code>true</code>. <i>This is implemented as suggested by Joshua Bloch in &quot;Effective Java&quot; (2nd ed, item 8, page 46).</i>
    */
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
   /*
      <p>FUNC_JD_INTRO</p>
    * <p>Equal to
      <br/> &nbsp; &nbsp;{@code <a href="YYY/ValidatorComposer.html"><i>[ValidatorComposer]</i></a>.<a href="YYY/ValidatorComposer.html#setERuleType_4prot(RuleType)">setERuleType_4prot</a>(type)}</p>
   protected void setERuleType(RuleType type)  {
      vc.setERuleType_4prot(type);
   }
    */
   /*
      <p>FUNC_JD_INTRO</p>
    * <p>Equal to
      <br/> &nbsp; &nbsp;{@code <a href="YYY/ValidatorComposer.html"><i>[ValidatorComposer]</i></a>.<a href="YYY/ValidatorComposer.html#setERuleType_4prot(RuleType, String)">setERuleType_4prot</a>(type, type_name)}</p>
   protected void setERuleType(RuleType type, String type_name)  {
      vc.setERuleType_4prot(type, type_name);
   }
    */
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
