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
   import  com.github.xbn.number.NewLengthInRangeValidatorFor;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.list.lister.LLCfgOverall;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.number.NewLengthInRangeValidatorFor;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  java.util.List;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring an {@link com.github.xbn.list.lister.LLCfgOverall LLCfgOverall}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LLCfgOverall_CfgForNeeder<E,C extends LLCfgOverall<E>,R extends Needer> extends LLConfigBase_CfgForNeeder<List<E>,C,R> implements LLCfgOverall_Fieldable  {
   public ValueValidator<Integer> vvForElementLength;
   public String                 sIfElementLength  ;
//constructors...START
   /**
      <P>Create a new {@code zLLCfgOverall_CfgForNeeder} with defaults.</P>

         <P>This<OL>
         <LI>Calls <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="LLConfigBase_CfgForNeeder.html#LLConfigBase_CfgForNeeder(R)">super</A>(needer)</CODE></LI>
      </OL></P>
    **/
   public LLCfgOverall_CfgForNeeder(R needer)  {
      super(needer);
      resetLCOCFN();
   }
//constructors...END
//setters...START
   public LLCfgOverall_CfgForNeeder<E,C,R> noAltForElementLength(ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  ifElementLength(NewLengthInRangeValidatorFor.impossible(filter_ifNonNull, dbgDest_ifNonNull), null);
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> ifElementLength(ValueValidator<Integer> len_validator, String display_ifValid)  {
      vvForElementLength = len_validator;
      sIfElementLength = display_ifValid;
      return  this;
   }
   public LLCfgOverall_CfgForNeeder<E,C,R> ifNoElements(String alt_display, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  ifElementLength(NewLengthInRangeValidatorFor.onlyZeroValid(Null.BAD, filter_ifNonNull, dbgDest_ifNonNull), alt_display);
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> finalOutputUnaltered()  {
      declareFinalOutputUnaltered();
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> reset()  {
      super.declareReset();
      resetLCOCFN();
      return  this;
   }
   protected void resetLCOCFN()  {
      noAltForElementLength(null, null);
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> ifNull(String alt_display)  {
      setIfNull(alt_display);
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> ifNonNull(String alt_display)  {
      setIfNonNull(alt_display);
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> prePost(String prefixfix, String postfixfix)  {
      setPrePost(prefixfix, postfixfix);
      return  this;
   }
//setters...END
   public ValueValidator<Integer> getVVForElementLength()  {
      return  vvForElementLength;
   }
   public String getIfElementLength()  {
      return  sIfElementLength;
   }
//other...START
   /**
      <P>Create a new {@code LLCfgOverall} from the configuration.</P>

      @return  {@code (new }{@link com.github.xbn.list.lister.LLCfgOverall#LLCfgOverall(zLLCfgOverall_CfgForNeeder) LLCfgOverall}{@code (this, false))}
      @see  #endCfg()
    **/
   public C build()  {
      @SuppressWarnings("unchecked")
      C c = (C)new LLCfgOverall<E>(this);
      return  c;
   }
   /**
      <P>YYY</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code startConfigReturnNeedable(needer, (Class&lt;LLCfgOverall&lt;E&gt;&gt;)((Class)LLCfgOverall.class))}</P>

      @return  <I>{@code this}</I>
      @see  com.github.xbn.neederneedable.Needer#startConfig(Class) Needer#startConfig(cls)
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<C> clsc = (Class<C>)(Class)LLCfgOverall.class;
      startConfigReturnNeedable(needer, clsc);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public LLCfgOverall_CfgForNeeder<E,C,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//other...END
}
