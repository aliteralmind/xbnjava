/*license*\
   XBN-Java Library

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
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg;
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  java.util.regex.Matcher;
   import  java.util.regex.PatternSyntaxException;
   import  com.github.xbn.util.BitBinaryUtil;
   import  java.util.regex.Pattern;

/**
   <P>Duplicate a pattern, crash if a pattern is {@code null} or a group-number is invalid for a matcher, and other regex-related utilities.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexUtil  {
   private RegexUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final String getRplc1stWInt(String to_search, Pattern find_whatPtrn, int num)  {
      return  find_whatPtrn.matcher(to_search).replaceFirst((new Integer(num)).toString());
   }
   /**
      <P>Does a pattern have the literal bit-flag associated to it?.</P>

      @return  <CODE>{@link com.github.xbn.util.BitBinaryUtil BitBinaryUtil}.{@link com.github.xbn.util.BitBinaryUtil#doesIntHaveBit(int, int) doesIntHaveBit}(pattern_toFind.{@link java.util.regex.Pattern#flags() flags}(), Pattern.{@link java.util.regex.Pattern#LITERAL LITERAL})</CODE>
    **/
   public static final boolean isLiteral(Pattern to_find)  {
      try  {
         return  BitBinaryUtil.doesIntHaveBit(to_find.flags(), Pattern.LITERAL);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_find, "to_find", null, rx);
      }
   }
   /**
      <P>Duplicate a pattern.</P>

      @return  <CODE>{@link #getPatternCopy(Pattern, String) getPatternCopy}(to_find, &quot;getPatternCopy&quot;, &quot;to_find&quot;)</CODE>
    **/
   public static final Pattern getPatternCopy(Pattern to_find)  {
      return  getPatternCopy(to_find, "to_find");
   }
   public static final Pattern getPatternCopyOrNewIfNNull(Pattern to_copy, Pattern newPtrn_ifNonNull)  {
      return  getPatternCopyOrNewIfNNull(to_copy, newPtrn_ifNonNull, "newPtrn_ifNonNull");
   }
   public static final Pattern getPatternCopyOrNewIfNNull(Pattern to_copy, Pattern newPtrn_ifNonNull, String orig_name)  {
      return  ((newPtrn_ifNonNull == null)
         ?  RegexUtil.getPatternCopy(to_copy, orig_name)
         :  RegexUtil.getPatternCopy(newPtrn_ifNonNull));
   }
   /**
      <P>Duplicate a pattern, or return {@code null} if it's {@code null}.</P>

      @return  If <CODE>to_find</CODE> is<UL>
         <LI>{@code null}: {@code null}</LI>
         <LI>non-{@code null}: <CODE>{@link #getPatternCopy(Pattern, String) getPatternCopy}(to_find, null)</CODE></LI>
      </UL>
      @see  #getPatternCopy(Pattern) getPatternCopy(p)
    **/
   public static final Pattern getPatternCopyOrNull(Pattern to_find)  {
      return  ((to_find == null) ? null
         :  getPatternCopy(to_find, null));
   }
   /**
      <P>Get the pattern in a {@code PatternHaser}, or crash if the haser is {@code null}.</P>

      @param  haser  May not be {@code null}.
      @param  haser_name  Descriptive name of {@code haser}. <I>Should</I> not be {@code null} or empty.
      @return  <CODE>haser.{@link com.github.xbn.regexutil.PatternHaser#getPattern() getPattern}()</CODE>
      @see  #getPatternCopy(PatternHaser, String)
    **/
   public static final Pattern getPatternCrashIfHaserNull(PatternHaser haser, String haser_name)  {
      try  {
         return  haser.getPattern();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(haser, haser_name, null, rx);
      }
   }
   /**
      <P>Duplicate the pattern in a {@code PatternHaser}, or crash if the haser is {@code null}.</P>

      @param  haser  May not be {@code null}.
      @return  <CODE>{@link #getPatternCopy(Pattern, String) getPatternCopy}(haser.{@link PatternHaser#getPattern() getPattern}(), haser_name)</CODE>
    **/
   public static final Pattern getPatternCopy(PatternHaser haser, String haser_name)  {
      Pattern p = null;
      try  {
         return  getPatternCopy(haser.getPattern(), haser_name);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(haser, haser_name, null, rx);
      }
   }
   /**
      <P>Duplicate a pattern, or crash if it's {@code null}.</P>

      @param  to_find  May not be {@code null}.
      @param  ptrn_name  Descriptive name {@code to_find}. <I>Should</I> not be {@code null} or empty.
      @see  #getPatternCopy(Pattern) getPatternCopy(p)
      @see  #getPatternCopy(PatternHaser, String) getPatternCopy(ph,s)
      @see  #getPatternCrashIfHaserNull(PatternHaser, String) getPatternCrashIfHaserNull(ph,s)
      @see  #getPatternCopyOrNull(Pattern) getPatternCopyOrNull(p)
    **/
   public static final Pattern getPatternCopy(Pattern to_find, String ptrn_name)  {
      try  {
         return  Pattern.compile(to_find.toString(), to_find.flags());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_find, ptrn_name, null, rx);
      }
   }
   /**
      <P>If a group number is invalid for a given matcher, crash.</P>

      @param  group_num  The group number to retrieve. Must be valid given <CODE>mtchr.{@link java.util.regex.Matcher#groupCount() groupCount}()</CODE>
      @param  mtchr  May not be {@code null}.
      @param  group_numName  Descriptive name of {@code group_num}. <I>Should</I> not be {@code null} or empty.
      @param  mtchr_name  Descriptive name of {@code mtchr}.
      @exception  XbnIndexOutOfBoundsException  If {@code group_num} is invalid.
    **/
   public static final void crashIfBadGroupNumberForCount(int group_num, Matcher mtchr, String group_numName, String mtchr_name)  {
      int igc = -1;
      try  {
         igc = mtchr.groupCount();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(mtchr, "mtchr", null, rx);
      }
      if(group_num < 0  ||  group_num > igc)  {
         throw  new XbnIndexOutOfBoundsException_Cfg().
            badIndex(group_num, group_numName).absMaxX(igc, mtchr_name + ".groupCount()").
            buildWithInfo("Group count is inclusive.");
      }
   }
   /*
      <P>If a group number is invalid for a given matcher, crash. Otherwise, <I>return</I> the causing error.</P>

      <P>This<OL>
         <LI>Calls {@link #crashIfBadGroupNumberForCount(int, Matcher, String, String) crashIfBadGroupNumberForCount}{@code (group_num, mtchr, group_numName, mtchr_name)}</LI>
         <LI>If that throws no exception, then this <I><B>returns</B></I> {@code cause}.</LI>
      </OL></P>

      @param  cause  May not be {@code null}.
   public static final RuntimeException crashIfBadGroupNumberForCountOrReturnCause(int group_num, Matcher mtchr, String group_numName, String mtchr_name, RuntimeException cause)  {
      crashIfBadGroupNumberForCount(group_num, mtchr, group_numName, mtchr_name);
//		xtra_errInfo = XInfoAccumulator.getAddedOrNew(xtra_errInfo,
//			(new StringBuilder("group_num=")).append(group_num).append(", mtchr=[").append(mtchr).append("], group_numName=\"").append(group_numName).append("\", mtchr_name=\"").append(mtchr_name).append("\""));
      return  regetRtxCrashIfNull(cause, "cause");
   }
    */
   /**
      <P>Get a matcher from a pattern, or crash if the pattern is {@code null}.</P>

      @param  to_find  May not be {@code null}.
      @param  to_search  The string to search. May not be {@code null}.
      @param  ptrn_name  Descriptive name for {@code to_find}. <I>Should</I> not be {@code null} or empty.
      @return  <CODE>to_find.{@link java.util.regex.Pattern#matcher(CharSequence) matcher}(to_search)</CODE>
    **/
   public static final Matcher newMatcherForPatternCINull(Pattern to_find, String to_search, String ptrn_name)  {
      try  {
         return  to_find.matcher(to_search);  //Does crash for a null string
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_find, ptrn_name, null, rx);
      }
   }
   /**
      <P>Reset the matcher string, and crash if the string is {@code null}. <CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#reset(CharSequence) reset}</CODE> allows {@code null} strings. This does not.</P>

      @param  matcher  May not be {@code null}.
      @param  to_search  May not be {@code null}.
      @param  toSearch_name  Descriptive name of {@code to_search}. <I>Should</I> not be {@code null} or empty.
    **/
   public static final Matcher resetGetMatcherCINullString(Matcher matcher, String to_search, String toSearch_name)  {
      if(to_search == null)  {
         throw  new NullPointerException(toSearch_name);
      }
      try  {
         return  matcher.reset(to_search);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(matcher, "matcher", null, rx);
      }
   }
}
