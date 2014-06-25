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
package  com.github.xbn.text.padchop.z;
   import  com.github.xbn.text.padchop.ChopString;
   import  com.github.xbn.text.padchop.EscapeAction;
   import  com.github.xbn.text.padchop.DifferentGoalLengths;
   import  com.github.xbn.text.padchop.PadChopBase;
   import  com.github.xbn.text.padchop.PadString;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.neederneedable.AbstractNeedableWithSubs;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.lang.IllegalArgumentStateException;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}.</P>

   @see  <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">Definition: indirectly</A>
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class VzblPadChop_CfgForNeeder<V extends VzblPadChop,R extends Needer> extends AbstractNeedableWithSubs<VzblPadChop,R> implements VzblPadChop_Fieldable  {
   public boolean      bTrimRight;
   public boolean      bTrimLeft ;
   public EscapeAction esc       ;
   public boolean      bPad      ;
   public boolean      bChop     ;
   public PadString    padString ;
   public ChopString   chopString;
   public boolean      bPadFirst ;
   public Appendable   apblDebug ;

   public boolean doTrimLeft()  {
      return  bTrimLeft;
   }
   public boolean doTrimRight()  {
      return  bTrimRight;
   }
   public EscapeAction getEscapeAction()  {
      return  esc;
   }
   public boolean doPad()  {
      return  bPad;
   }
   public boolean doChop()  {
      return  bChop;
   }
   public PadString getPad()  {
      return  padString;
   }
   public ChopString getChop()  {
      return  chopString;
   }
   public boolean doPadFirst()  {
      return  bPadFirst;
   }
   public Appendable getDebugApbl()  {
      return  apblDebug;
   }
//constructors...START
   /**
      <P>Create a new {@code VzblPadChop_CfgForNeeder} with no goal-length.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#VzblPadChop_CfgForNeeder(R, int)">this</A>(needer, -1)</CODE></P>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#VzblPadChop_CfgForNeeder(R, int)">this</A>(R,i)</CODE>
    **/
   public VzblPadChop_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <P>Create a new {@code VzblPadChop_CfgForNeeder} with a default goal-length.</P>

         <P>This<OL>
         <LI>Calls <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/chain/AbstractNeedableWithSubs.html#AbstractNeedableWithSubs(boolean, boolean, R)">super</A>(true, true, needer)</CODE></LI>
         <LI>Calls {@link #reset(int) reset(goal_len)}</LI>
      </OL></P>

      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#VzblPadChop_CfgForNeeder(R)">this</A>(R)</CODE>
    **/
   public VzblPadChop_CfgForNeeder(R needer, int goal_len)  {
      super(true, true, needer);
      resetVPC(goal_len);
   }
//constructors...END
//setters...START
   /**
      <P>Revert all configuration to <I>nothing</I>.</P>

      @return  {@link #reset(int) reset}{@code (-1)}
    **/
   public VzblPadChop_CfgForNeeder<V,R> reset()  {
      return  reset(-1);
   }
   /**
      <P>Declare a goal-length, but otherwise revert all configuration to <I>nothing</I>.</P>

         <P>This calls<OL>
         <LI>{@link #trim(boolean, boolean) trim(false, false)}</LI>
         <LI>{@link #noEscape() noEscape}{@code ()}</LI>
         <LI>{@link #cfgPad(boolean, int) cfgPad}{@code (false, goal_len).}{@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#endCfg}{@code ()}</LI>
         <LI>{@link #cfgChop(boolean, int)}{@code (false, goal_len).}{@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#endCfg}{@code ()}</LI>
         <LI>{@link #padFirst() padFirst}{@code ()}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
      @see  #reset()
      @see  #goalLen(int) goalLen(i)
    **/
   public VzblPadChop_CfgForNeeder<V,R> reset(int goal_len)  {
      resetVPC(goal_len);
      return  this;
   }
   protected final void resetVPC(int goal_len)  {
      try  {
         trim(false, false);
         noEscape();
         cfgPad(false, goal_len).endCfg();
         cfgChop(false, goal_len).endCfg();
         padFirst();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException(getChainIDForXMsg(null).toString(), rx);
      }
   }
   /**
      <P>Set the desired length for the output.</P>

      <P>This sets<OL>
         <LI>The internal {@link PadString} to <CODE><I>[the internal PadString]</I>.{@link com.github.xbn.text.padchop.PadChopBase#getCopyNewGoalLen(int) getCopyNewGoalLen}(length)</CODE></LI>
         <LI>The internal {@link ChopString} to <CODE><I>[the internal ChopString]</I>.getCopyNewGoalLen(length)</CODE></LI>
      </OL></P>

      @return  <I>{@code this}</I>
      @see  #reset(int) reset(i)
    **/
   public VzblPadChop_CfgForNeeder<V,R> goalLen(int length)  {
      try  {
         padString = padString.getCopyNewGoalLen(length);
         chopString = chopString.getCopyNewGoalLen(length);
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException(getChainIDForXMsg(null).toString(), rx);
      }
      return  this;
   }
   /**
      <P>Trim the left side of the string.</P>

      @return  {@link #trim(boolean, boolean) trim(true, false)}
    **/
   public VzblPadChop_CfgForNeeder<V,R> trimLeft()  {
      return  trim(true, false);
   }
   /**
      <P>Trim the right side of the string.</P>

      @return  {@link #trim(boolean, boolean) trim(false, true)}
    **/
   public VzblPadChop_CfgForNeeder<V,R> trimRight()  {
      return  trim(false, true);
   }
   /**
      <P>Trim both sides of the string.</P>

      @return  {@link #trim(boolean, boolean) trim(true, true)}
    **/
   public VzblPadChop_CfgForNeeder<V,R> trim()  {
      return  trim(true, true);
   }
   /**
      <P>Declare which sides of the string should be trimmed.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #trimLeft() trimLeft}{@code ()}, {@link #trimRight() trimRight}{@code ()}, {@link #trim() trim}{@code ()}</I></LI>
         </UL></P>

      @param  do_left  If {@code true}, the left side of the string is trimmed. Get with  <CODE><I>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doTrimLeft() doTrimLeft}()</CODE>.
      @param  do_right  If {@code true}, the right side of the string is trimmed. Get with  <CODE><I>[VzblPadChop]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doTrimRight() doTrimRight}()</CODE>.
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> trim(boolean do_left, boolean do_right)  {
      bTrimLeft = do_left;
      bTrimRight = do_right;
      return  this;
   }
   /**
      <P>Leave control characters alone.</P>

      <P>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <CODE>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#NOTHING NOTHING}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #unescape()
    **/
   public VzblPadChop_CfgForNeeder<V,R> noEscape()  {
      esc = EscapeAction.NOTHING;
      return  this;
   }
   /**
      <P>Unescape control characters.</P>

      <P>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <CODE>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#UNESCAPE UNESCAPE}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #noEscape()
      @see  #escape()
    **/
   public VzblPadChop_CfgForNeeder<V,R> unescape()  {
      esc = EscapeAction.UNESCAPE;
      return  this;
   }
   /**
      <P>EscapeAction control characters.</P>

      <P>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <CODE>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#ESCAPE ESCAPE}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #unescape()
    **/
   public VzblPadChop_CfgForNeeder<V,R> escape()  {
      esc = EscapeAction.ESCAPE;
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> escapeNothingIfNull(EscapeAction action)  {
      esc = ((action == null) ? EscapeAction.NOTHING : action);
      return  this;
   }

   /**
      <P>Turn padding on or off.</P>

      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> pad(boolean is_on)  {
      bPad = is_on;
      return  this;
   }
   /**
      <P>Turn chopping on or off.</P>

      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> chop(boolean is_on)  {
      bChop = is_on;
      return  this;
   }
   public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad()  {
      return  cfgPad(true, padString.getGoalLen());
   }
   public ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>> cfgChop()  {
      return  cfgChop(true, chopString.getGoalLen());
   }
   public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad(int goal_len)  {
      return  cfgPad(true, goal_len);
   }
   public ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>> cfgChop(int goal_len)  {
      return  cfgChop(true, goal_len);
   }
   public ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>> cfgChop(boolean is_on)  {
      return  cfgChop(is_on, chopString.getGoalLen());
   }
   /**
      <P>Define chopping configuration.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #chop(boolean) chop(b)}</I></LI>
         </UL></P>

      <P>.............May not be {@code null}, and if {@code is_on} is {@code true}, {@code chpr.getGoalLen()} must be zero or greater. Get with  <CODE><I>[VzblPadChop]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#getChop() getChop}()</CODE>. If
      <BR> &nbsp; &nbsp; <CODE>chpr.{@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}()</CODE>
      <BR>is different than
      <BR> &nbsp; &nbsp;  <CODE><I>[the currently-set {@link com.github.xbn.text.padchop.PadString PadString}]</I>.getGoalLen()</CODE>
      <BR>Then the {@code DifferentGoalLengths} parameter in the {@code VzblPadChop} {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) constructor} dictates the action taken.</P>

      @param  is_on  If {@code true} padding is active. Get with  <CODE><I>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doPad() doPad}()</CODE>
    **/
   public ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>> cfgChop(boolean is_on, int goal_len)  {
      bChop = is_on;
      return  (new ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>>(this, goal_len));
   }
   public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad(boolean is_on)  {
      return  cfgPad(is_on, padString.getGoalLen());
   }
   /**
      <P>Define padding configuration.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #pad(boolean) pad(b)}</I></LI>
         </UL></P>

      <P>May not be {@code null}, and if {@code is_on} is {@code true}, {@code padr.getGoalLen()} must be zero or greater. Get with  <CODE><I>[VzblPadChop]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#getPad() getPad}()</CODE>. If
      <BR> &nbsp; &nbsp; <CODE>padr.{@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}()</CODE>
      <BR>is different than
      <BR> &nbsp; &nbsp;  <CODE><I>[the currently-set {@link com.github.xbn.text.padchop.ChopString ChopString}]</I>.getGoalLen()</CODE>
      <BR>Then the {@code DifferentGoalLengths} parameter in the {@code VzblPadChop} {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) constructor} dictates the action taken.</P>

      @param  is_on  If {@code true} padding is active. Get with  <CODE><I>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doPad() doPad}()</CODE>
    **/
   public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad(boolean is_on, int goal_len)  {
      bPad = is_on;
      return  (new PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>>(this, goal_len));
   }
   /**
      <P>Pad the string before chopping it.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #chopFirst() chopFirst}{@code ()}</I></LI>
         </UL></P>
Get with  <CODE><I>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doPadFirst() doPadFirst}()</CODE>. This is ignored when either padding or chopping is off.
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> padFirst()  {
      bPadFirst = true;
      return  this;
   }
   /**
      <P>Chop the string before padding it.</P>

      <P>Get with  <CODE><I>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</I>.{@link com.github.xbn.text.padchop.VzblPadChop#doPadFirst() doPadFirst}()</CODE>. This is ignored when either padding or chopping is off.</P>

      @return  <I>{@code this}</I>
      @see  #padFirst()
    **/
   public VzblPadChop_CfgForNeeder<V,R> chopFirst()  {
      bPadFirst = false;
      return  this;
   }
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
//setters...END
   /**
      <P>Create a new {@code VzblPadChop} as configured.</P>

      @return  <CODE>{@link #build(DifferentGoalLengths) build}({@link com.github.xbn.text.padchop.DifferentGoalLengths DifferentGoalLengths}.{@link com.github.xbn.text.padchop.DifferentGoalLengths#IGNORE IGNORE})</CODE></P>
    **/
   public V build()  {
      return  build(DifferentGoalLengths.IGNORE);
   }
   /**
      <P>Create a new {@code VzblPadChop} as configured.</P>

      @return  <CODE>(V)new {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) VzblPadChop}(id_gl, this)</CODE>
      @see  #build()
    **/
   public V build(DifferentGoalLengths id_gl)  {
      @SuppressWarnings("unchecked")
      V v = (V)new VzblPadChop(id_gl, this);
      return  v;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> startConfigReturnNeedable(R needer)  {
      startConfig(needer, VzblPadChop.class);
      return  this;
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public VzblPadChop_CfgForNeeder<V,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   @SuppressWarnings("unchecked")
   public void neeadableSetsNeeded(Object fully_configured)  {
      PadChopBase pcb = (PadChopBase)setGetNeededEndConfig(fully_configured);
      if(getNeededType().isAssignableFrom(PadString.class))  {
         padString = (PadString)pcb;
      }  else if(getNeededType().isAssignableFrom(ChopString.class))  {
         chopString = (ChopString)pcb;
      }  else  {
         throw  new IllegalStateException("getNeededType()=" + getNeededType() + ", fully_configured.getClass().getName()=" + fully_configured.getClass().getName());
      }
   }
}
