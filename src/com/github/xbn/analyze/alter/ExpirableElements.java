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
package  com.github.xbn.analyze.alter;
   import  com.github.xbn.util.EnumUtil;
/**
   <p>Is it required that the elements in an {@code ExpirableAlterList} are expirable?.</p>

 * @see  ExpirableAlterList
 * @see  com.github.xbn.lang.Expirable#doesExpire()
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum ExpirableElements  {
   /**
      <p>Allow non-expirable elements.</p>

    * @see  #REQUIRED
    * @see  #isOptional()
    */
   OPTIONAL,
   /**
      <p>Do not allow.</p>

    * @see  #OPTIONAL
    * @see  #isRequired()
    */
   REQUIRED;
   /**
      <p>Is this {@code ExpirableElements} equal to {@code OPTIONAL}?.</p>

    * @return  <code>this == {@link #OPTIONAL}</code>

    * @see  #isRequired()
    */
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <p>Is this {@code ExpirableElements} equal to {@code REQUIRED}?.</p>

    * @return  <code>this == {@link #REQUIRED}</code>
    * @see  #isOptional()
    */
   public final boolean isRequired()  {
      return  this == REQUIRED;
   }
   /**
      <p>If an <code>ExpirableElements</code> is not a required value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(ExpirableElements, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>ExpirableElements</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(ExpirableElements, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
