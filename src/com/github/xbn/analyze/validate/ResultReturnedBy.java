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
   <p>Exactly what determined the valid-result in a <code>Validator</code>?: The pre-filter, the validator's rules, or the post-filter?.</p>

 * @see  ValidResultFilter
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum ResultReturnedBy {
   /**
      <p>The valid-result was determined by the pre-filter--the <i>something</i> was never validated against the rules.</p>

    * @see  #RULES
    * @see  #isPreFilter()
    */
   PRE_FILTER,
   /**
      <p>The valid-result was determined by whether the <i>something</i> actually conforms to the (post-inverted) rules.</p>

    * @see  #PRE_FILTER
    * @see  #POST_FILTER
    * @see  #isRules()
    * @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    */
   RULES,
   /**
      <p>The valid-result was determined by the post-filter--although the <i>something</i> was validated against the rules, that result was ignored.</p>

    * @see  #RULES
    * @see  #isPostFilter()
    */
   POST_FILTER;
   /**
      <p>Is this {@code ResultReturnedBy} equal to {@code PRE_FILTER}?.</p>

    * @return  <code>this == {@link #PRE_FILTER}</code>

    * @see  #isRules()
    * @see  #isPostFilter()
    */
   public final boolean isPreFilter()  {
      return  this == PRE_FILTER;
   }
   /**
      <p>Is this {@code ResultReturnedBy} equal to {@code RULES}?.</p>

    * @return  <code>this == {@link #RULES}</code>
    * @see  #isPreFilter()
    */
   public final boolean isRules()  {
      return  this == RULES;
   }
   /**
      <p>Is this {@code ResultReturnedBy} equal to {@code POST_FILTER}?.</p>

    * @return  <code>this == {@link #POST_FILTER}</code>
    * @see  #isPreFilter()
    */
   public final boolean isPostFilter()  {
      return  this == POST_FILTER;
   }
   /**
      <p>If an <code>ResultReturnedBy</code> is not a required value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;ResultReturnedBy&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(ResultReturnedBy, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(ResultReturnedBy rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>ResultReturnedBy</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;ResultReturnedBy&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(ResultReturnedBy, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(ResultReturnedBy rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
