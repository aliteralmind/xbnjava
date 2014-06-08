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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.text.padchop.ChopString ChopString}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ChopString_CfgForNeeder<C extends ChopString,R extends Needer> extends PadChopBase_CfgForNeeder<C,R> implements ChopString_Fieldable  {
//state
   public int        iCharsBeforeDDD;
   public int        iDDDOverhang   ;
   public String     sEllipsis      ;
   public Appendable apblDebug      ;
//constructors...START
   /**
      <P>Create a new {@code zChopString_CfgForNeeder} with defaults.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ChopString_CfgForNeeder.html#ChopString_CfgForNeeder(R, int)">super</A>(needer, -1)</CODE></P>
    **/
   public ChopString_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <P>Create a new {@code zChopString_CfgForNeeder} with defaults, but a specific goal length.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ChopString_CfgForNeeder.html#ChopString_CfgForNeeder(int, R)">this</A>(goal_len, needer)</CODE></LI>
         <LI>{@link #right() right}{@code ()}</LI>
         <LI>{@link #noDDD() noDDD}{@code ()}</LI>
         <LI>{@link #atEnd() atEnd}{@code ()}</LI>
         <LI>{@link #noOverhang() noOverhang}{@code ()}</LI>
      </OL></P>
      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#zChopString_CfgForNeeder(R)">this</A>(R)</CODE>
    **/
   public ChopString_CfgForNeeder(R needer, int goal_len)  {
      super(needer, goal_len);
      right();
      noDDD();
      atEnd();
      noOverhang();
   }
//constructors...END
//setters...START
   /**
      <P>Declare the length that the string should be chopped to.</P>

      @param  goal_len  May not be less than zero. Get with {@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public ChopString_CfgForNeeder<C,R> goalLen(int goal_len)  {
      iGoalLen = goal_len;
      return  this;
   }
   /**
      <P>Declare that the right side of the string should be chopped.</P>

      <P>This sets {@link com.github.xbn.text.padchop.PadChopBase#isSideRight() isSideRight}{@code ()}* to {@code true}.</P>

      @return  <I>{@code this}</I>
      @see  #left()
    **/
   public ChopString_CfgForNeeder<C,R> right()  {
      bSideRight = true;
      return  this;
   }
   /**
      <P>Declare that the left side of the string should be chopped.</P>

      <P>This sets {@link com.github.xbn.text.padchop.PadChopBase#isSideRight() isSideRight}{@code ()}* to {@code false}.</P>

      @return  <I>{@code this}</I>
      @see  #right()
    **/
   public ChopString_CfgForNeeder<C,R> left()  {
      bSideRight = false;
      return  this;
   }
   /**
      <P>Do not use an ellipsis.</P>

      @return  {@link #ddd(String) ddd(null)}
    **/
   public ChopString_CfgForNeeder<C,R> noDDD()  {
      return  ddd(null);
   }
   /**
      <P>Use the default ellipsis.</P>

      @return  {@link #ddd(String) ddd}{@code ("...")}
    **/
   public ChopString_CfgForNeeder<C,R> ddd()  {
      return  ddd("...");
   }
   /**
      <P>Set the chop-ellipsis, that visually indicates a chop (for example: &quot;{@code ...}&quot; [dot-dot-dot]).</P>

      @param  ellipsis  What is added to the end of chopped text. May not be empty. Get with  {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()}*. When {@code null}, there is no ellipsis, and both {@link #getOverhangCount() getOverhangCount}{@code ()} and {@link #getCharsBeforeDDD() getCharsBeforeDDD}{@code ()} are ignored. <I>Notes<UL>
         <LI>If this is longer than the {@link ChopString_CfgForNeeder#getGoalLen() goal length}, then when attempting to chop the string, <I><B>an {@code IllegalArgumentException} will be thrown</B></I>.</LI>
         <LI>In all cases, the ellipsis is displayed in its entirety, even if it contains more characters than the goal length.</LI>
      </UL></I>
    **/
   public ChopString_CfgForNeeder<C,R> ddd(String ellipsis)  {
      sEllipsis = ellipsis;
      return  this;
   }
   /**
      <P>Define the maximum number of characters in the ellipsis that can <I>exceed</I> the chopped string.</P>

      <P>Example is in {@code java com.github.xbn.text.ChopString}</P>

      <P>Notes:<UL>
         <LI>This setting is never violated (in no cases is the overhang exceeded).</LI>
         <LI>See &quot;note 2&quot; in {@link #charsBefore(int) charsBefore}{@code (i)}, regarding precedence.</LI>
      </UL></P>

      @param  char_len  If {@code -1} or less, or greater than {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()*.length()}, then {@code getOverhangCount()} will return {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()*.length()}. Get with {@link com.github.xbn.text.padchop.ChopString#getOverhangCount() getOverhangCount}{@code ()}*.
      @see  #maxOverhang()
      @see  #noOverhang()
    **/
   public ChopString_CfgForNeeder<C,R> overhang(int char_len)  {
      iDDDOverhang = char_len;
      return  this;
   }
   /**
      <P>The ellipsis always exceeds the chopped string as much as possible.</P>

      @return  <CODE>{@link #overhang(int) overhang}({@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}()*.length())</CODE>
    **/
   public ChopString_CfgForNeeder<C,R> maxOverhang()  {
      try  {
         return  overhang(sEllipsis.length());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(sEllipsis, "sEllipsis", getChainIDForXMsg("Must set ddd(s). Call to *Overhang() or overhang(i) must follow ddd(s)."), rx);
      }
   }
   /**
      <P>The ellipsis is always contained within the chopped text.</P>

      @return  <CODE>{@link #overhang(int) overhang}(0)</CODE>
    **/
   public ChopString_CfgForNeeder<C,R> noOverhang()  {
      return  overhang(0);
   }
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
    **/
   public ChopString_CfgForNeeder<C,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }

   /**
      <P>Define the minimum number of characters to display before the chop--therefore defining the <I>location</I> of the chop (and chop-ellipsis).</P>

{@code java com.github.xbn.examples.text.padchop.CharsBeforeChopXmpl}
      <P>Notes:<OL>
         <LI><I>This setting is ignored when there is no chop-ellipsis</I>. When {@link #getEllipsis() getEllipsis}{@code ()} is {@code null}, the chop always happens on the end. To force chopping in the middle with no ellipsis, set the ellipsis to the empty string.</LI>
         <LI>The {@link #getOverhangCount() ddd-max-overhang} setting trumps this min-start-chars setting. That is, when-and-only-when the {@link #getGoalLen() goal length} is short enough, such that the {@link #getEllipsis() chop ellipsis} will not fit <B>unless one of these two settings is violated</B>, the min-start-chars setting <B>will</B> be violated. The max-overhang is never violated.</LI>
      </OL></P>

      @param  len  The number of characters, <I>starting on the <B>opposite</B> {@link #right() side} of the chop</I>, that must be in the final-result string. Get with {@link com.github.xbn.text.padchop.ChopString#getCharsBeforeDDD() getCharsBeforeDDD}{@code ()}*. When {@code len} is<UL>
         <LI>{@link com.github.xbn.text.padchop.ChopString#iIN_MIDDLE}: {@code getCharsBeforeDDD()} is set to <CODE>({@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}() / 2)</CODE>. <I>In this case, {@code getOverhangCount()} is ignored.</I></LI>
         <LI>{@link com.github.xbn.text.padchop.ChopString#iAT_END}:  or greater than {@code <I>[super]</I>.getGoalLen()}: {@code getCharsBeforeDDD()} is set to {@code getGoalLen()}.</LI>
         <LI>Between {@code 0} and {@code <I>[super]</I>.getGoalLen()} (inclusive): {@code getCharsBeforeDDD()} is set to that number.</LI>
      </UL>
    **/
   public ChopString_CfgForNeeder<C,R> charsBefore(int len)  {
      iCharsBeforeDDD = len;
      return  this;
   }
   public ChopString_CfgForNeeder<C,R> atEnd()  {
      return  charsBefore(ChopString.iAT_END);
   }
   public ChopString_CfgForNeeder<C,R> inMiddle()  {
      return  charsBefore(ChopString.iIN_MIDDLE);
   }
//setters...END
   public int getCharsBeforeDDD()  {
      return  iCharsBeforeDDD;
   }
   public int getOverhangCount()  {
      return  iDDDOverhang;
   }
   public Appendable getDebugApbl()  {
      return  apblDebug;
   }
   public String getEllipsis()  {
      return  sEllipsis;
   }
//other...START
   /**
      <P>Create a new {@code ChopString} from the configuration.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #endCfg() endCfg}{@code ()}</I></LI>
         </UL></P>


      @return  {@code (new }{@link com.github.xbn.text.padchop.ChopString#ChopString(ChopString_Fieldable) ChopString}{@code (this))}
    **/
   public C build()  {
      @SuppressWarnings("unchecked")
      C c = (C)(new ChopString(this));
      return  c;
   }
   public ChopString_CfgForNeeder<C,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   public ChopString_CfgForNeeder<C,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<C> clsc = (Class<C>)(Class)ChopString.class;
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
//other...END
}
