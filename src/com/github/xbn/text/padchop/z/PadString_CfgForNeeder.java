/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.text.padchop.z;
   import  com.github.xbn.text.padchop.PadString;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.text.padchop.PadString PadString}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PadString_CfgForNeeder<P extends PadString,R extends Needer> extends PadChopBase_CfgForNeeder<P,R> implements PadString_Fieldable  {
   public char cPad = ' ';
//constructors...START
   /**
      <P>Create a new {@code zPadString_CfgForNeeder} with defaults.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R, int)">this</A>(needer, -1)</CODE></P>
    **/
   public PadString_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <P>Create a new {@code zPadString_CfgForNeeder} with defaults, but a specific goal length.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#PadString_CfgForNeeder(R)">this</A>(R)</CODE></I></LI>
         </UL></P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R, int)">this</A>(needer, goal_len)</CODE></LI>
         <LI>{@link #right() right}{@code ()}</LI>
         <LI>{@link #withSpace() withSpace}{@code ()}</LI>
      </OL></P>
    **/
   public PadString_CfgForNeeder(R needer, int goal_len)  {
      super(needer, goal_len);
      right();
      withSpace();
   }
//constructors...END
//setters...START
   /**
      <P>Declare the length that the string should be chopped to.</P>

      @param  length  May not be less than 0. Get with {@link com.github.xbn.text.padchop.PadString#getGoalLen() getGoalLen}{@code ()}*
      @return  <I>{@code this}</I>
    **/
   public PadString_CfgForNeeder<P,R> goalLen(int length)  {
      iGoalLen = length;
      return  this;
   }
   /**
      <P>Declare that the right side of the string should be chopped.</P>

      <P>This sets {@link com.github.xbn.text.padchop.PadString#isSideRight() isSideRight}{@code ()}* to {@code true}.</P>

      @return  <I>{@code this}</I>
    **/
   public PadString_CfgForNeeder<P,R> right()  {
      bSideRight = true;
      return  this;
   }
   /**
      <P>Declare that the left side of the string should be chopped.</P>

      <P>This sets {@link com.github.xbn.text.padchop.PadString#isSideRight() isSideRight}{@code ()}* to {@code false}.</P>

      @return  <I>{@code this}</I>
      @see  #goalLen(int) goalLen(i)
    **/
   public PadString_CfgForNeeder<P,R> left()  {
      bSideRight = false;
      return  this;
   }
   /**
      <P>Define the character to pad with.</P>

      @param  pad_char  Get with {@link com.github.xbn.text.padchop.PadString#getPadChar() getPadChar}{@code ()}*
      @see  #withSpace()
    **/
   public PadString_CfgForNeeder<P,R> with(char pad_char)  {
      cPad = pad_char;
      return  this;
   }
   /**
      <P>Declare the pad-character to be a space.</P>

      @return  {@link #with(char) with}{@code (' ')}
    **/
   public PadString_CfgForNeeder<P,R> withSpace()  {
      return  with(' ');
   }
//setters...END
   public char getPadChar()  {
      return  cPad;
   }
//other...START
   /**
      <P>Create a new {@code PadString} from the configuration.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #endCfg() endCfg}{@code ()}</I></LI>
         </UL></P>


      @return  <CODE>(new {@link com.github.xbn.text.padchop.PadString#PadString(PadString_Fieldable) PadString}(this))</CODE>
    **/
   public P build()  {
      @SuppressWarnings("unchecked")
      P p = (P)(new PadString(this));
      return  p;
   }
   public PadString_CfgForNeeder<P,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<P> clsp = (Class<P>)(Class)PadString.class;
      startConfigReturnNeedable(needer, clsp);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   public PadString_CfgForNeeder<P,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//other...END
}
