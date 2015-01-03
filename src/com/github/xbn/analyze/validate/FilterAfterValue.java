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
   import  com.github.xbn.util.EnumUtil;
/**
   <p>Determines the final valid-result, <b><u>after</u></b> the <i>something</i> is analyzed against the rules.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum FilterAfterValue {
   /**
      <p>Causes the validity function to return {@code true}, regardless whether the rules are followed.</p>

      <p>This causes the validation function (such as <code><i>[{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="ValueValidator.html#isValid(O)">isValid</a>(O)</code>) to return {@code true} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis} and {@link com.github.xbn.analyze.validate.Validator#getValidCount() valid} counts.</p>

    * @see  #FALSE
    * @see  #UNCHANGED
    * @see  #isTrue()
    */
   TRUE,
   /**
      <p>Return {@code false}, regardless if the <i>something</i> is valid.</p>

      <p>This causes the validation function (such as <code><i>[{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="ValueValidator.html#isValid(O)">isValid</a>(O)</code>) to return {@code false} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis count}.</p>

    * @see  #TRUE
    * @see  #isFalse()
    */
   FALSE,
   /**
      <p>Return the follows-the-rules value (post-inversion) without alteration.</p>

    * @see  #TRUE
    * @see  #isUnchanged()
    * @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    */
   UNCHANGED;
   /**
      <p>Is this {@code FilterAfterValue} equal to {@code TRUE}?.</p>

    * @return  <code>this == {@link #TRUE}</code>

    * @see  #isFalse()
    * @see  #isUnchanged()
    */
   public final boolean isTrue()  {
      return  this == TRUE;
   }
   /**
      <p>Is this {@code FilterAfterValue} equal to {@code FALSE}?.</p>

    * @return  <code>this == {@link #FALSE}</code>
    * @see  #isTrue()
    */
   public final boolean isFalse()  {
      return  this == FALSE;
   }
   /**
      <p>Is this {@code FilterAfterValue} equal to {@code UNCHANGED}?.</p>

    * @return  <code>this == {@link #UNCHANGED}</code>
    * @see  #isTrue()
    */
   public final boolean isUnchanged()  {
      return  this == UNCHANGED;
   }
   /**
      <p>If an <code>FilterAfterValue</code> is not a required value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;FilterAfterValue&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(FilterAfterValue, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(FilterAfterValue rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>FilterAfterValue</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;FilterAfterValue&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(FilterAfterValue, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(FilterAfterValue rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
