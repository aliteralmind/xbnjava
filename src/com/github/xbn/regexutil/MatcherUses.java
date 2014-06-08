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
   <P>When searching for text with a {@code java.util.regex.Matcher}, what search-function should the matcher use? {@code find()}, {@code matches()}, {@code lookingAt()}, or custom.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum MatcherUses  {
   /**
      <P>Use <CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#find() find}()</CODE>.</P>

      @see  #MATCHES
      @see  #LOOKING_AT
      @see  #CUSTOM
      @see  #isFind()
    **/
   FIND,
   /**
      <P>Use <CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#matches() matches}()</CODE>.</P>

      @see  #FIND
      @see  #isMatches()
    **/
   MATCHES,
   /**
      <P>Use <CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#lookingAt() lookingAt}()</CODE>.</P>

      @see  #FIND
      @see  #isLookingAt()
    **/
   LOOKING_AT,
   /**
      <P>Uses something other than, or some combination of, <CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#find() find}()</CODE>, {@link java.util.regex.Matcher#matches() matches}{@code ()}, and {@link java.util.regex.Matcher#lookingAt() lookingAt}{@code ()}.</P>

      @see  #FIND
      @see  #isCustom()
    **/
   CUSTOM;
   /**
      <P>Is this {@code MatcherUses} equal to {@code FIND}?.</P>

      @return  <CODE>this == {@link #FIND}</CODE>

      @see  #isMatches()
      @see  #isLookingAt()
      @see  #isCustom()
    **/
   public final boolean isFind()  {
      return  this == FIND;
   }
   /**
      <P>Is this {@code MatcherUses} equal to {@code MATCHES}?.</P>

      @return  <CODE>this == {@link #MATCHES}</CODE>

      @see  #isFind()
    **/
   public final boolean isMatches()  {
      return  this == MATCHES;
   }
   /**
      <P>Is this {@code MatcherUses} equal to {@code LOOKING_AT}?.</P>

      @return  <CODE>this == {@link #LOOKING_AT}</CODE>

      @see  #isFind()
    **/
   public final boolean isLookingAt()  {
      return  this == LOOKING_AT;
   }
   /**
      <P>Is this {@code MatcherUses} equal to {@code CUSTOM}?.</P>

      @return  <CODE>this == {@link #CUSTOM}</CODE>

      @see  #isFind()
    **/
   public final boolean isCustom()  {
      return  this == CUSTOM;
   }

   /**
      <P>If an <CODE>MatcherUses</CODE> is not a required value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfForbiddenValue(MatcherUses, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(MatcherUses rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <P>If an <CODE>MatcherUses</CODE> is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfNotRequiredValue(MatcherUses, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
   public void crashIfForbiddenValue(MatcherUses rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
