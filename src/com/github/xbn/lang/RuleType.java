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
package  com.github.xbn.lang;
   import  com.github.xbn.util.EnumUtil;
/**
   <p>How restrictive is a {@code Ruleable} object?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum RuleType {
   /**
      <p>It is not possible to violate the rules.</p>

    * @see  #RESTRICTED
    * @see  #IMPOSSIBLE
    * @see  #isUnrestricted()
    */
   UNRESTRICTED,
   /**
      <p>It is possible to either follow or violate the rules.</p>

    * @see  #UNRESTRICTED
    * @see  #isRestricted()
    */
   RESTRICTED,
   /**
      <p>It is not possible to conform to the rules.</p>

    * @see  #UNRESTRICTED
    * @see  #isImpossible()
    */
   IMPOSSIBLE;
   /**
      <p>Is this {@code RuleType} equal to {@code UNRESTRICTED}?.</p>

    * @return  <code>this == {@link #UNRESTRICTED}</code>

    * @see  #isRestricted()
    * @see  #isImpossible()
    */
   public final boolean isUnrestricted()  {
      return  this == UNRESTRICTED;
   }
   /**
      <p>Is this {@code RuleType} equal to {@code RESTRICTED}?.</p>

    * @return  <code>this == {@link #RESTRICTED}</code>
    * @see  #isUnrestricted()
    */
   public final boolean isRestricted()  {
      return  this == RESTRICTED;
   }
   /**
      <p>Is this {@code RuleType} equal to {@code IMPOSSIBLE}?.</p>

    * @return  <code>this == {@link #IMPOSSIBLE}</code>
    * @see  #isUnrestricted()
    * @see  #isRestricted()
    */
   public final boolean isImpossible()  {
      return  this == IMPOSSIBLE;
   }
   /**
      <p>If an <code>RuleType</code> is not a required value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;RuleType&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(RuleType, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(RuleType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>RuleType</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;RuleType&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(RuleType, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(RuleType rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
