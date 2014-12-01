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
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.neederneedable.Needer;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.number.LengthInRangeValidator LengthInRangeValidator}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class LengthInRangeValidator_CfgForNeeder<G extends LengthInRange,V extends LengthInRangeValidator,R extends Needer> extends IntInRangeValidator_CfgForNeeder<G,V,R> implements LengthInRangeValidator_Fieldable<G>  {
   public LengthInRangeValidator_CfgForNeeder(R needer)  {
      this(true, true, needer);
   }
   /**
      <p>YYY</p>

         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="IntInRangeValidator_CfgForNeeder.html#IntInRangeValidator_CfgForNeeder(boolean, boolean, R)">super</a>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</code></li>

    */
   public LengthInRangeValidator_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
   }
   /**
      <p>Set information to append to error messages.</p>

    * @param  info  If non-{@code null}, this object's {@code toString()} is appended to error messages. Get with {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}{@code ()}*
    * @return  <i>{@code this}</i>
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
      oXtraErrInfo = info;
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> range(G length_range)  {
      super.range(length_range);
      return  this;
   }
   /**
      <p>Declare no filtering.</p>

    * @return  {@link #filter(ValidResultFilter) filter}{@code (null)}
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
      return  filter(null);
   }
   /**
      <p>Set the valid-result filter.</p>

    * @param  filter_offIfNull  If {@code null}, the validator is {@link #unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}.
    * @return  <i>{@code this}</i>
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
      super.filter(filter_offIfNull);
      return  this;
   }
   /**
      <p>Declare if {@code null} is acceptable (pre-inversion).</p>

    * @param  is_ok  If {@code true}, {@code null} is acceptable.
    * @return  <i>{@code this}</i>
    * @see  #invert(boolean)
    * @see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean is_ok)  {
      super.nullOk(is_ok);
      return  this;
   }
   /**
      <p>Declare if the rules should be inverted.</p>

    * @param  do_invert  If {@code true}, the rules are inverted. Get with {@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() NullnessValidator#isNullOkGivenInvert()
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> invert(boolean do_invert)  {
      super.invert(do_invert);
      return  this;
   }
   /**
      <p>Set debugging.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LengthInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   @SuppressWarnings("unchecked")
   public V build()  {
      return  (V)(new LengthInRangeValidator(this));
   }
}
