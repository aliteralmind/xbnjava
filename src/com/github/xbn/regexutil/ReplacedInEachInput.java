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
   <p>Broadly defines which matches, <i>within each input string</i>, should be replaced by a {@code RegexReplacer}.</p>

 * @see  RegexReplacer
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum ReplacedInEachInput {
   /**
      <p>Replace first match only.</p>

    * @see  #LOOKING_AT
    * @see  #MATCHES
    * @see  #MATCH_NUMBERS
    * @see  #ALL
    * @see  #UNTIL
    * @see  #isFirst()
    */
   FIRST,
   /**
      <p>Replace the first match only, and only if it begins at index zero.</p>

    * @see  #FIRST
    * @see  #isLookingAt()
    * @see  java.util.regex.Matcher#lookingAt() Matcher#lookingAt()
    */
   LOOKING_AT,
   /**
      <p>Replace the entire string only.</p>

    * @see  #FIRST
    * @see  #isMatches()
    * @see  java.util.regex.Matcher#matches() Matcher#matches()
    */
   MATCHES,
   /**
      <p>Replace specific matches, such as the second through fourth.</p>

    * @see  #FIRST
    */
   MATCH_NUMBERS,
   /**
      <p>Replace all matches.</p>

    * @see  #FIRST
    * @see  #isAll()
    */
   ALL,
   /**
      <p>Replace all matches repeatedly, until no more matches are found.</p>

    * @see  #FIRST
    * @see  #isUntil()
    */
   UNTIL;
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code FIRST}?.</p>

    * @return  <code>this == {@link #FIRST}</code>

    * @see  #isMatchNumbers()
    * @see  #isLookingAt()
    * @see  #isMatches()
    * @see  #isAll()
    * @see  #isUntil()
    */
   public final boolean isFirst()  {
      return  this == FIRST;
   }
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code MATCHES}?.</p>

    * @return  <code>this == {@link #MATCHES}</code>
    * @see  #isFirst()
    */
   public final boolean isMatches()  {
      return  this == MATCHES;
   }
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code LOOKING_AT}?.</p>

    * @return  <code>this == {@link #LOOKING_AT}</code>
    * @see  #isFirst()
    */
   public final boolean isLookingAt()  {
      return  this == LOOKING_AT;
   }
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code MATCH_NUMBERS}?.</p>

    * @return  <code>this == {@link #MATCH_NUMBERS}</code>
    * @see  #isFirst()
    */
   public final boolean isMatchNumbers()  {
      return  this == MATCH_NUMBERS;
   }
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code MATCH_NUMBERS}?.</p>

    * @return  <code>this == {@link #ALL}</code>
    * @see  #isFirst()
    */
   public final boolean isAll()  {
      return  this == ALL;
   }
   /**
      <p>Is this {@code ReplacedInEachInput} equal to {@code UNTIL}?.</p>

    * @return  <code>this == {@link #UNTIL}</code>
    * @see  #isFirst()
    */
   public final boolean isUntil()  {
      return  this == UNTIL;
   }
   /**
      <p>If an <code>ReplacedInEachInput</code> is not a required value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(ReplacedInEachInput, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(ReplacedInEachInput rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>ReplacedInEachInput</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, bad_value, this_enumsVarName, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(ReplacedInEachInput, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(ReplacedInEachInput bad_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, bad_value, this_enumsVarName, xtra_errInfo);
   }
   public static final MatcherUses getMatcherUsesFrom(ReplacedInEachInput what)  {
      switch (what) {
         case FIRST:
            return  MatcherUses.FIND;
         case LOOKING_AT:
            return  MatcherUses.LOOKING_AT;
         case MATCHES:
            return  MatcherUses.MATCHES;
         default:
            return  MatcherUses.CUSTOM;

      }
   }
};
