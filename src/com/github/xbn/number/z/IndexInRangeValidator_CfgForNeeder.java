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
package  com.github.xbn.number.z;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.number.IndexInRange;
   import  com.github.xbn.number.IndexInRangeValidator;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.number.IntBoundInclusive;
   import  com.github.xbn.number.IntBoundExclusive;
   import  com.github.xbn.text.StringUtilBase;
   import  java.util.Collection;
/**
   <P>YYY</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
/**
   <P>. For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link IndexInRangeValidator}.</P>
 **/
public class IndexInRangeValidator_CfgForNeeder<G extends IndexInRange,V extends IndexInRangeValidator,R extends Needer> extends IntInRangeValidator_CfgForNeeder<G,V,R> implements IndexInRangeValidator_Fieldable<G>  {
   public IndexInRangeValidator_CfgForNeeder(R needer)  {
      this(true, true, needer);
   }
   /**
      <P>YYY</P>

         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="zAbstractValidato_CfgForNeeder.html#zAbstractValidato_CfgForNeeder(boolean, boolean, R)">super</A>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</CODE></LI>

    **/
   public IndexInRangeValidator_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
   }
   /**
      <P>Set information to append to error messages.</P>

      @param  info  If non-{@code null}, this object's {@code toString()} is appended to error messages. Get with {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}{@code ()}*
      @return  <I>{@code this}</I>
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
      oXtraErrInfo = info;
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> range(G range)  {
      super.range(range);
      return  this;
   }
   /**
      <P>Declare if {@code null} is acceptable (pre-inversion).</P>

      @param  is_ok  If {@code true}, {@code null} is acceptable.
      @return  <I>{@code this}</I>
      @see  #invert(boolean)
      @see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean is_ok)  {
      super.nullOk(is_ok);
      return  this;
   }
   /**
      <P>Declare if the rules should be inverted.</P>

      @param  do_invert  If {@code true}, the rules are inverted. Get with {@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}{@code ()}*
      @return  <I>{@code this}</I>
      @see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() NullnessValidator#isNullOkGivenInvert()
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> invert(boolean do_invert)  {
      super.invert(do_invert);
      return  this;
   }
   /**
      <P>Declare no filtering.</P>

      @return  {@link #filter(ValidResultFilter) filter}{@code (null)}
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
      return  filter(null);
   }
   /**
      <P>Set the valid-result filter.</P>

      @param  filter_offIfNull  If {@code null}, the validator is {@link #unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}.
      @return  <I>{@code this}</I>
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
      super.filter(filter_offIfNull);
      return  this;
   }
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public IndexInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   @SuppressWarnings("unchecked")
   public V build()  {
      @SuppressWarnings("unchecked")
      V v = (V)(new IndexInRangeValidator(this));
      return  v;
   }
}
