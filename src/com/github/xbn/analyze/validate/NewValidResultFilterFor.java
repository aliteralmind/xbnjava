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

package  com.github.xbn.analyze.validate;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.number.NewLengthInRangeFor;
   import  com.github.xbn.analyze.validate.z.FilterValidCounts_Cfg;
/**
   <P>Convenience functions for creating {@code ValidResultFilter}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewValidResultFilterFor  {
   private NewValidResultFilterFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final FilterValidCounts exactlyOne(Appendable dbgDest_ifNonNull)  {
      return  exactly(1, null, dbgDest_ifNonNull);
   }
   public static final FilterValidCounts exactly(int min_max, String minMax_name, Appendable dbgDest_ifNonNull)  {
      return  inUnchangedOutFalse(min_max, min_max, minMax_name, minMax_name, dbgDest_ifNonNull);
   }
   /**
      <P>A new filter that returns {@code false} when the number of <I>valid results</I> is outside of a specific (inclusive) range--it otherwise the leaves follows-the-rules finding unchanged.</P>

      @param  maxIncl_neg1IfNoMax  If {@code -1}, there is no maximum bound.
      @return  <CODE>FilterValidCounts_Cfg().{@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder#range(LengthInRange) range}(lengthRange).{@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder#inUnchangedOutFalse() inUnchangedOutFalse}().
      <BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder#countValid() countValid}().{@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder#debugTo(Appendable) debugTo}(dbgDest_ifNonNull).{@link com.github.xbn.analyze.validate.z.FilterValidCounts_CfgForNeeder#build() build}()</CODE>
      <BR>Where {@code lengthRange} is equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.number.NewLengthInRangeFor NewLengthInRangeFor}.{@link com.github.xbn.number.NewLengthInRangeFor#minMaxInclusive(Invert, int, int, String, String) minMaxInclusive}(null, inclusive_min, maxIncl_neg1IfNoMax, min_name, max_name)</CODE>
      @see  #unfiltered()
    **/
   public static final FilterValidCounts inUnchangedOutFalse(int inclusive_min, int maxIncl_neg1IfNoMax, String min_name, String max_name, Appendable dbgDest_ifNonNull)  {
      LengthInRange range = ((maxIncl_neg1IfNoMax == -1)
         ?  NewLengthInRangeFor.min(null, inclusive_min, min_name)
         :  NewLengthInRangeFor.minMaxInclusive(null, inclusive_min, maxIncl_neg1IfNoMax, min_name, max_name));
      return  new FilterValidCounts_Cfg().range(range).inUnchangedOutFalse().
         countValid().debugTo(dbgDest_ifNonNull).build();
   }
   /**
      <P>A valid-result filter that does nothing--it always passes the follows-the-rules value unchanged. This is a singleton that never {@link com.github.xbn.lang.Expirable#isExpired() expires}, whose {@link ValidResultFilter#getPreAction() pre-action} is always {@link FilterPreAction#PROCEED PROCEED}, {@link ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-value} is always {@link FilterAfterValue#UNCHANGED UNCHANGED}.</P>

      @return  <CODE>{@link com.github.xbn.analyze.validate.ValidatorComposer ValidatorComposer}.{@link com.github.xbn.analyze.validate.ValidatorComposer#unfiltered() unfiltered}()</CODE>
    **/
   public static final ValidResultFilter unfiltered()  {
      return  ValidatorComposer.unfiltered();
   }
}
