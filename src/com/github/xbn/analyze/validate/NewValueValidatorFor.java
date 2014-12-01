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
   import  com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.analyze.validate.z.ValueValidator_Cfg;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>YYY</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewValueValidatorFor  {
   private NewValueValidatorFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>Get a new {@code ValueValidator} where {@code null} (or non-{@code null}) is the <i>only good value</i>.</p>

    * @return  If <code>nnull.{@link com.github.xbn.lang.Null#isOk() ok}()</code> is<ul>
         <li>{@code true}: <code>NewValueValidatorFor.&lt;O&gt;{@link #onlyNullGood(ValidResultFilter, Appendable) onlyNullGood}(filter_doNothingIfNull, dbgDest_ifNonNull)</code></li>
         <li>{@code false}: <code>NewValueValidatorFor.&lt;O&gt;{@link #nullBad(ValidResultFilter, Appendable) nullBad}(filter_doNothingIfNull, dbgDest_ifNonNull)</code></li>
      </ul>
    */
   public static final <O> ValueValidator<O> nullIs(Null nnull, ValidResultFilter filter_doNothingIfNull, Appendable dbgDest_ifNonNull)  {
      try  {
         return  (nnull.isOk()
            ?  NewValueValidatorFor.<O>onlyNullGood(filter_doNothingIfNull, dbgDest_ifNonNull)
            :  NewValueValidatorFor.<O>nullBad(filter_doNothingIfNull, dbgDest_ifNonNull));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(nnull, "nnull", null, rx);
      }
   }
   /**
      <p>Get a new {@code ValueValidator} where {@code null} is good, and non-{@code null} is bad.</p>

    * @return  <code>new NullnessValidator.{@link com.github.xbn.analyze.validate.z.ValueValidator_Cfg#ValueValidator_Cfg() Cfg}().{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#nullOk(boolean) nullOk}(false).{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#invert(boolean) invert}(true).{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#build() build}()</code>
    * @see  #nullBad(ValidResultFilter, Appendable) nullBad(vrf,apbl)
    */
   @SuppressWarnings("unchecked")
   public static final <O> ValueValidator<O> onlyNullGood(ValidResultFilter filter_doNothingIfNull, Appendable dbgDest_ifNonNull)  {
      return  buildCIFilterNull(
         new ValueValidator_Cfg().nullOk(false).invert(true).debugTo(dbgDest_ifNonNull).filter(filter_doNothingIfNull));
   }
   /**
      <p>Get a new {@code ValueValidator} where {@code null} is bad, and non-{@code null} is good.</p>

    * @return  <code>new NullnessValidator.{@link com.github.xbn.analyze.validate.z.ValueValidator_Cfg#ValueValidator_Cfg() Cfg}().{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#nullOk(boolean) nullOk}(false).{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#build() build}()</code>

    */
   public static final <O> ValueValidator<O> nullBad(ValidResultFilter filter_doNothingIfNull, Appendable dbgDest_ifNonNull)  {
      return  buildCIFilterNull(
         new ValueValidator_Cfg().nullOk(false).invert(false).debugTo(dbgDest_ifNonNull).filter(filter_doNothingIfNull));
   }
   /**
      <p>Get a new {@code ValueValidator} where anything is good.</p>

    * @return   <code>new NullnessValidator.{@link com.github.xbn.analyze.validate.z.ValueValidator_Cfg#ValueValidator_Cfg() Cfg}().{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#build() build}()</code>

    * @see  #nullBad(ValidResultFilter, Appendable) nullBad
    * @see  #nullIs(Null, ValidResultFilter, Appendable) nullIs
    * @see  #onlyNullGood(ValidResultFilter, Appendable) onlyNullGood
    * @see  #impossible(ValidResultFilter, Appendable) impossible
    */
   public static final <O> ValueValidator<O> unrestricted(ValidResultFilter filter_doNothingIfNull, Appendable dbgDest_ifNonNull)  {
      return  buildCIFilterNull(
         new ValueValidator_Cfg().nullOk(true).invert(false).debugTo(dbgDest_ifNonNull).filter(filter_doNothingIfNull));
   }
      private static final <O> ValueValidator<O> buildCIFilterNull(ValueValidator_CfgForNeeder vvn_cfn)  {
         try  {
            @SuppressWarnings("unchecked")
            ValueValidator<O> vvo = (ValueValidator<O>)vvn_cfn.build();
            return  vvo;
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(vvn_cfn.getFilter(), "filter_doNothingIfNull", null, rx);
         }
      }
   /**
      <p>Get a new {@code ValueValidator} where the value is always bad.</p>

    * @return  <code>new NullnessValidator.{@link com.github.xbn.analyze.validate.z.ValueValidator_Cfg#ValueValidator_Cfg() Cfg}().{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#invert(boolean) invert}(true).{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#build() build}()</code>
    * @see  #nullBad(ValidResultFilter, Appendable) nullBad(vrf,apbl)
    */
   public static final <O> ValueValidator<O> impossible(ValidResultFilter filter_doNothingIfNull, Appendable dbgDest_ifNonNull)  {
      return  buildCIFilterNull(
         new ValueValidator_Cfg().nullOk(true).invert(true).debugTo(dbgDest_ifNonNull).filter(filter_doNothingIfNull));
   }
}
