/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   <P>Determines the final valid-result, <B><U>after</U></B> the <I>something</I> is analyzed against the rules.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum FilterAfterValue {
   /**
      <P>Causes the validity function to return {@code true}, regardless whether the rules are followed.</P>

      <P>This causes the validation function (such as <CODE><I>[{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ValueValidator.html#isValid(O)">isValid</A>(O)</CODE>) to return {@code true} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis} and {@link com.github.xbn.analyze.validate.Validator#getValidCount() valid} counts.</P>

      @see  #FALSE
      @see  #UNCHANGED
      @see  #isTrue()
    **/
   TRUE,
   /**
      <P>Return {@code false}, regardless if the <I>something</I> is valid.</P>

      <P>This causes the validation function (such as <CODE><I>[{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ValueValidator.html#isValid(O)">isValid</A>(O)</CODE>) to return {@code false} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis count}.</P>

      @see  #TRUE
      @see  #isFalse()
    **/
   FALSE,
   /**
      <P>Return the follows-the-rules value (post-inversion) without alteration.</P>

      @see  #TRUE
      @see  #isUnchanged()
      @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    **/
   UNCHANGED;
   /**
      <P>Is this {@code FilterAfterValue} equal to {@code TRUE}?.</P>

      @return  <CODE>this == {@link #TRUE}</CODE>

      @see  #isFalse()
      @see  #isUnchanged()
    **/
   public final boolean isTrue()  {
      return  this == TRUE;
   }
   /**
      <P>Is this {@code FilterAfterValue} equal to {@code FALSE}?.</P>

      @return  <CODE>this == {@link #FALSE}</CODE>
      @see  #isTrue()
    **/
   public final boolean isFalse()  {
      return  this == FALSE;
   }
   /**
      <P>Is this {@code FilterAfterValue} equal to {@code UNCHANGED}?.</P>

      @return  <CODE>this == {@link #UNCHANGED}</CODE>
      @see  #isTrue()
    **/
   public final boolean isUnchanged()  {
      return  this == UNCHANGED;
   }
   /**
      <P>If an <CODE>FilterAfterValue</CODE> is not a required value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;FilterAfterValue&quot;, xtra_errInfo)</CODE></P>
      @see  #crashIfForbiddenValue(FilterAfterValue, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(FilterAfterValue rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <P>If an <CODE>FilterAfterValue</CODE> is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;FilterAfterValue&quot;, xtra_errInfo)</CODE></P>
      @see  #crashIfNotRequiredValue(FilterAfterValue, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
   public void crashIfForbiddenValue(FilterAfterValue rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
