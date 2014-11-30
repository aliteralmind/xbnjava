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
   import  com.github.xbn.list.lister.LLConfigBase;
   import  com.github.xbn.neederneedable.AbstractNeedableWithSubs;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.text.padchop.NewVzblPadChopFor;
   import  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring an {@link com.github.xbn.list.lister.LLConfigBase LLConfigBase}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class LLConfigBase_CfgForNeeder<O,L extends LLConfigBase<O>,R extends Needer> extends AbstractNeedableWithSubs<L,R> implements LLConfigBase_Fieldable  {
//state
   public String                 sIfNull   ;
   public String                 sIfNonNull;
   public String                 sPrefix   ;
   public String                 sPostfix  ;
   public VzblPadChop            vpcFinal  ;
//	public ValueValidator<Integer> vv4LLen   ;
//	public String                 sIfLLen   ;
//internal                                        //Leave the space on the end
   /**
      <p>Create a new {@code LLConfigBase_CfgForNeeder} with defaults.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/chain/AbstractNeedableWithSubs.html#AbstractNeedableWithSubs(boolean, boolean, R)">super</a>(true, true, needer)</code></li>
         <li>{@link #resetLLCB() resetLLCB}{@code ()}</li>
      </ol></p>
    **/
   public LLConfigBase_CfgForNeeder(R needer)  {
      super(true, true, needer);
      resetLLCB();
   }
   /**
      <p>Revert configuration to <i>nothing</i>.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #resetLLCB() resetLLCB}{@code ()}</p>
    **/
   public void declareReset()  {
      resetLLCB();
   }
   /**
      <p>Revert configuration to <i>nothing</i>.</p>

      <p>This calls<ol>
         <li>{@link #setIfNull(String) setIfNull(null)}</li>
         <li>{@link #setIfNonNull(String) setIfNonNull(null)}</li>
         <li>{@link #setPrePost(String, String) setPrePost(null, null)}</li>
      </ol></p>
      @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#LLConfigBase_CfgForNeeder(R)">this</a>(R)</code>
      @see  #setIfNull(String) setIfNull(s)
    **/
   protected final void resetLLCB()  {
      setIfNull(null);
      setIfNonNull(null);
      setPrePost(null, null);
      declareFinalOutputUnaltered();
   }
   /**
      <p>Short circuit: Declare what to display when the list-or-element is {@code null}. Short-circuit <a href="#short_circuit">definition</a>.</p>

         @param  alt_display  If {@code null}, this is ignored (&quot;{@code null}&quot; is displayed). Otherwise may not be empty. Get with {@link #getIfNull() getIfNull}{@code ()}

      @see  #setIfNonNull(String) setIfNonNull(av)
      @see  #setPrePost(String, String) setPrePost(s,s)
      @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#LLConfigBase_CfgForNeeder(R)">this</a>(R)</code>
    **/
   public void setIfNull(String alt_display)  {
      sIfNull = alt_display;
   }
   /**
      <p>Short circuit: Declare what to display when the list-or-element is <i>not</i> {@code null}. Short-circuit <a href="#short_circuit">definition</a>.</p>

      @param  alt_display  If {@code null}, this is ignored (the element's {@code toString()} is displayed). Otherwise may not be empty. Get with {@link #getIfNonNull() getIfNonNull}{@code ()}
      @see  #setIfNull(String) setIfNull(s)
    **/
   public void setIfNonNull(String alt_display)  {
      sIfNonNull = alt_display;
   }
   /**
      <p>Set the prefix and postfix--only applicable when no short-circuits are used.</p>

      @param  prefixfix  May not be empty. Get with {@link #getPrefix() getPrefix}{@code ()}
      @param  postfixfix  May not be empty. Get with {@link #getPostfix() getPostfix}{@code ()}
      @see  #setIfNull(String) setIfNull(s)
    **/
   public void setPrePost(String prefixfix, String postfixfix)  {
      sPrefix = prefixfix;
      sPostfix = postfixfix;
   }
   public void declareFinalOutputUnaltered()  {
      vpcFinal = NewVzblPadChopFor.doesNothing();
   }
   public VzblPadChop_CfgForNeeder<VzblPadChop,LLConfigBase_CfgForNeeder<O,L,R>> cfgVPCFinalOutput(int goal_len)  {
      return  (new VzblPadChop_CfgForNeeder<VzblPadChop,LLConfigBase_CfgForNeeder<O,L,R>>(this, goal_len));
   }
   public VzblPadChop_CfgForNeeder<VzblPadChop,LLConfigBase_CfgForNeeder<O,L,R>> cfgVPCFinalOutput()  {
      return  (new VzblPadChop_CfgForNeeder<VzblPadChop,LLConfigBase_CfgForNeeder<O,L,R>>(this));
   }
//setters...END
   public String getIfNull()  {
      return  sIfNull;
   }
   public String getIfNonNull()  {
      return  sIfNonNull;
   }
   public String getPrefix()  {
      return  sPrefix;
   }
   public String getPostfix()  {
      return  sPostfix;
   }
   public VzblPadChop getVPCFinalOutput()  {
      return  vpcFinal;
   }
//getters...START
   /**
      @return  <i>{@code this}</i>
    **/
   public LLConfigBase_CfgForNeeder<O,L,R> startConfigReturnNeedable(R needer, Class<L> expected_type)  {
      startConfig(needer, expected_type);
      return  this;
   }
   public void neeadableSetsNeeded(Object fully_configured)  {
      vpcFinal = (VzblPadChop)setGetNeededEndConfig(fully_configured);
   }
}
