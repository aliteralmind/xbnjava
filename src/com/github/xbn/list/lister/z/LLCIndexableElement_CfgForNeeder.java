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
package  com.github.xbn.list.lister.z;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.list.lister.LLCIndexableElement;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.number.NewLengthInRangeValidatorFor;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring an {@link com.github.xbn.list.lister.LLCIndexableElement LLCIndexableElement}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class LLCIndexableElement_CfgForNeeder<E,C extends LLCIndexableElement<E>,R extends Needer> extends LLCfgElement_CfgForNeeder<E,C,R> implements LLCIndexableElement_Fieldable<E>  {
   public ValueValidator<Integer> vvForElementLength;
   public String                 sIfElementLength  ;
//constructors...START
   /**
      <p>Create a new {@code LLCIndexableElement_CfgForNeeder} with defaults.</p>

         <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="LLCfgElement_CfgForNeeder.html#LLCfgElement_CfgForNeeder(R)">super</a>(needer)</code></li>
      </ol></p>
    */
   public LLCIndexableElement_CfgForNeeder(R needer)  {
      super(needer);
      resetLCXECFN();
   }
//constructors...END
//setters...START
   public LLCIndexableElement_CfgForNeeder<E,C,R> noAltForElementLength()  {
   return  ifElementLength(NewLengthInRangeValidatorFor.impossible(Null.BAD, null, null), null);
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> ifElementLength(ValueValidator<Integer> len_validator, String display_ifValid)  {
      vvForElementLength = len_validator;
      sIfElementLength = display_ifValid;
      return  this;
   }
   public LLCIndexableElement_CfgForNeeder<E,C,R> ifNoElements(String alt_display, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  ifElementLength(NewLengthInRangeValidatorFor.onlyZeroValid(Null.BAD, filter_ifNonNull, dbgDest_ifNonNull), alt_display);
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> finalOutputUnaltered()  {
      declareFinalOutputUnaltered();
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> reset()  {
      super.declareReset();
      resetLCXECFN();
      return  this;
   }
   protected final void resetLCXECFN()  {
      noAltForElementLength();
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> ifNull(String alt_display)  {
      super.setIfNull(alt_display);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> ifNonNull(String alt_display)  {
      super.setIfNonNull(alt_display);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> prePost(String prefixfix, String postfixfix)  {
      super.setPrePost(prefixfix, postfixfix);
      return  this;
   }
//setters...END
//getters...START
   public ValueValidator<Integer> getVVForElementLength()  {
      return  vvForElementLength;
   }
   public String getIfElementLength()  {
      return  sIfElementLength;
   }
//getters...END
//other...START
   /**
      <p>Create a new {@code LLCIndexableElement} from the configuration.</p>

         <p><i><b>See:</b></i><ul>
         <li><i>{@link #endCfg() endCfg}{@code ()}</i></li>
         </ul></p>

    * @return  <code>(new {@link com.github.xbn.list.lister.LLCIndexableElement#LLCIndexableElement(LLCIndexableElement_Fieldable) LLCIndexableElement}&lt;E&gt;(this, false))</code>
    */
   public C build()  {
      @SuppressWarnings("unchecked")
      C c = (C)(new LLCIndexableElement<E>(this));
      return  c;
   }
   /**
      <p>YYY</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="../LLConfigBase.html#startConfigReturnNeedable(R, java.lang.Class)">startConfigReturnNeedable</a>(needer, (Class&lt;LLCIndexableElement&lt;E&gt;&gt;)((Class)LLCIndexableElement.class))</code></p>

    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.neederneedable.Needer#startConfig(Class) Needer#startConfig(cls)
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> startConfigReturnNeedable(R needer)  {

      //See Needer#startConfig(cls)
      @SuppressWarnings("unchecked")
      Class<C> clsc = (Class<C>)(Class)LLCIndexableElement.class;

      startConfigReturnNeedable(needer, clsc);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public LLCIndexableElement_CfgForNeeder<E,C,R> chainID(boolean do_setStatic, Object id)  {
      super.chainID(do_setStatic, id);
      return  this;
   }
//other...END
}
