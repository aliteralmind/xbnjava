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
package  com.github.xbn.regexutil;
   import  com.github.xbn.util.EnumUtil;
/**
   <p>When searching for text with a {@code java.util.regex.Matcher}, what search-function should the matcher use? {@code find()}, {@code matches()}, {@code lookingAt()}, or custom.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum MatcherUses  {
   /**
      <p>Use <code>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#find() find}()</code>.</p>

    * @see  #MATCHES
    * @see  #LOOKING_AT
    * @see  #CUSTOM
    * @see  #isFind()
    */
   FIND,
   /**
      <p>Use <code>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#matches() matches}()</code>.</p>

    * @see  #FIND
    * @see  #isMatches()
    */
   MATCHES,
   /**
      <p>Use <code>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#lookingAt() lookingAt}()</code>.</p>

    * @see  #FIND
    * @see  #isLookingAt()
    */
   LOOKING_AT,
   /**
      <p>Uses something other than, or some combination of, <code>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#find() find}()</code>, {@link java.util.regex.Matcher#matches() matches}{@code ()}, and {@link java.util.regex.Matcher#lookingAt() lookingAt}{@code ()}.</p>

    * @see  #FIND
    * @see  #isCustom()
    */
   CUSTOM;
   /**
      <p>Is this {@code MatcherUses} equal to {@code FIND}?.</p>

    * @return  <code>this == {@link #FIND}</code>

    * @see  #isMatches()
    * @see  #isLookingAt()
    * @see  #isCustom()
    */
   public final boolean isFind()  {
      return  this == FIND;
   }
   /**
      <p>Is this {@code MatcherUses} equal to {@code MATCHES}?.</p>

    * @return  <code>this == {@link #MATCHES}</code>

    * @see  #isFind()
    */
   public final boolean isMatches()  {
      return  this == MATCHES;
   }
   /**
      <p>Is this {@code MatcherUses} equal to {@code LOOKING_AT}?.</p>

    * @return  <code>this == {@link #LOOKING_AT}</code>

    * @see  #isFind()
    */
   public final boolean isLookingAt()  {
      return  this == LOOKING_AT;
   }
   /**
      <p>Is this {@code MatcherUses} equal to {@code CUSTOM}?.</p>

    * @return  <code>this == {@link #CUSTOM}</code>

    * @see  #isFind()
    */
   public final boolean isCustom()  {
      return  this == CUSTOM;
   }

   /**
      <p>If an <code>MatcherUses</code> is not a required value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(MatcherUses, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(MatcherUses rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>MatcherUses</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(MatcherUses, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(MatcherUses rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
