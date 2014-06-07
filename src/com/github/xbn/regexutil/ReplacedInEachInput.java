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
package  com.github.xbn.regexutil;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>Broadly defines which matches, within <I>each input string</I>, should be replaced by a {@code RegexReplacer}.</P>

   @see  RegexReplacer
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum ReplacedInEachInput {
   /**
      <P>Replace first match only.</P>

      @see  #LOOKING_AT
      @see  #MATCHES
      @see  #MATCH_NUMBERS
      @see  #ALL
      @see  #UNTIL
      @see  #isFirst()
    **/
   FIRST,
   /**
      <P>Replace the first match only, and only if it begins at index zero.</P>

      @see  #FIRST
      @see  #isLookingAt()
      @see  java.util.regex.Matcher#lookingAt() Matcher#lookingAt()
    **/
   LOOKING_AT,
   /**
      <P>Replace the entire string only.</P>

      @see  #FIRST
      @see  #isMatches()
      @see  java.util.regex.Matcher#matches() Matcher#matches()
    **/
   MATCHES,
   /**
      <P>Replace specific matches, such as the second through fourth.</P>

      @see  #FIRST
    **/
   MATCH_NUMBERS,
   /**
      <P>Replace all matches.</P>

      @see  #FIRST
      @see  #isAll()
    **/
   ALL,
   /**
      <P>Replace all matches repeatedly, until no more matches are found.</P>

      @see  #FIRST
      @see  #isUntil()
    **/
   UNTIL;
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code FIRST}?.</P>

      @return  <CODE>this == {@link #FIRST}</CODE>

      @see  #isMatchNumbers()
      @see  #isLookingAt()
      @see  #isMatches()
      @see  #isAll()
      @see  #isUntil()
    **/
   public final boolean isFirst()  {
      return  this == FIRST;
   }
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code MATCHES}?.</P>

      @return  <CODE>this == {@link #MATCHES}</CODE>
      @see  #isFirst()
    **/
   public final boolean isMatches()  {
      return  this == MATCHES;
   }
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code LOOKING_AT}?.</P>

      @return  <CODE>this == {@link #LOOKING_AT}</CODE>
      @see  #isFirst()
    **/
   public final boolean isLookingAt()  {
      return  this == LOOKING_AT;
   }
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code MATCH_NUMBERS}?.</P>

      @return  <CODE>this == {@link #MATCH_NUMBERS}</CODE>
      @see  #isFirst()
    **/
   public final boolean isMatchNumbers()  {
      return  this == MATCH_NUMBERS;
   }
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code MATCH_NUMBERS}?.</P>

      @return  <CODE>this == {@link #ALL}</CODE>
      @see  #isFirst()
    **/
   public final boolean isAll()  {
      return  this == ALL;
   }
   /**
      <P>Is this {@code ReplacedInEachInput} equal to {@code UNTIL}?.</P>

      @return  <CODE>this == {@link #UNTIL}</CODE>
      @see  #isFirst()
    **/
   public final boolean isUntil()  {
      return  this == UNTIL;
   }
   /**
      <P>If an <CODE>ReplacedInEachInput</CODE> is not a required value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfForbiddenValue(ReplacedInEachInput, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(ReplacedInEachInput rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <P>If an <CODE>ReplacedInEachInput</CODE> is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, bad_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfNotRequiredValue(ReplacedInEachInput, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
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
