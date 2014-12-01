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
   <p>What counts are filtered?: The total number of analyses, the valid-results, or invalid-results?.</p>

 * @see  FilterValidCounts
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum FilterCountType  {
   /**
      <p>The filter is based on the number of times the <i>something</i> is analyzed, regardless if valid.</p>

    * @see  com.github.xbn.analyze.Analyzer#getAnalyzedCount()
    * @see  #VALID
    * @see  #INVALID
    * @see  #isAll()
    */
   ALL,
   /**
      <p>The filter is based on the number of times the <i>something</i> is determined to be valid (conforms to the rules).</p>

    * @see  #ALL
    * @see  #isValid()
    */
   VALID,
   /**
      <p>The filter is based on the number of times the <i>something</i> is determined to be invalid (does not conform to the rules).</p>

    * @see  #ALL
    * @see  #isInvalid()
    */
   INVALID;
   /**
      <p>Is this {@code FilterCountType} equal to {@code ALL}?.</p>

    * @return  <code>this == {@link #ALL}</code>

    * @see  #isValid()
    * @see  #isInvalid()
    */
   public final boolean isAll()  {
      return  this == ALL;
   }
   /**
      <p>Is this {@code FilterCountType} equal to {@code VALID}?.</p>

    * @return  <code>this == {@link #VALID}</code>
    * @see  #isAll()
    */
   public final boolean isValid()  {
      return  this == VALID;
   }
   /**
      <p>Is this {@code FilterCountType} equal to {@code INVALID}?.</p>

    * @return  <code>this == {@link #INVALID}</code>
    * @see  #isAll()
    */
   public final boolean isInvalid()  {
      return  this == INVALID;
   }
   /**
      <p>If an <code>FilterCountType</code> is not a required value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;FilterCountType&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(FilterCountType, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(FilterCountType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>FilterCountType</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;FilterCountType&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(FilterCountType, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(FilterCountType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
