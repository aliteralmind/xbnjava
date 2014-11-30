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
   import  com.github.xbn.text.padchop.PadString;
   import  com.github.xbn.neederneedable.Needer;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.text.padchop.PadString PadString}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PadString_CfgForNeeder<P extends PadString,R extends Needer> extends PadChopBase_CfgForNeeder<P,R> implements PadString_Fieldable  {
   public char cPad = ' ';
//constructors...START
   /**
      <p>Create a new {@code zPadString_CfgForNeeder} with defaults.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R, int)">this</a>(needer, -1)</code></p>
    **/
   public PadString_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <p>Create a new {@code zPadString_CfgForNeeder} with defaults, but a specific goal length.</p>

         <p><i><b>See:</b></i><ul>
         <li><i><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#PadString_CfgForNeeder(R)">this</a>(R)</code></i></li>
         </ul></p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R, int)">this</a>(needer, goal_len)</code></li>
         <li>{@link #right() right}{@code ()}</li>
         <li>{@link #withSpace() withSpace}{@code ()}</li>
      </ol></p>
    **/
   public PadString_CfgForNeeder(R needer, int goal_len)  {
      super(needer, goal_len);
      right();
      withSpace();
   }
//constructors...END
//setters...START
   /**
      <p>Declare the length that the string should be chopped to.</p>

      @param  length  May not be less than 0. Get with {@link com.github.xbn.text.padchop.PadString#getGoalLen() getGoalLen}{@code ()}*
      @return  <i>{@code this}</i>
    **/
   public PadString_CfgForNeeder<P,R> goalLen(int length)  {
      iGoalLen = length;
      return  this;
   }
   /**
      <p>Declare that the right side of the string should be chopped.</p>

      <p>This sets {@link com.github.xbn.text.padchop.PadString#isSideRight() isSideRight}{@code ()}* to {@code true}.</p>

      @return  <i>{@code this}</i>
    **/
   public PadString_CfgForNeeder<P,R> right()  {
      bSideRight = true;
      return  this;
   }
   /**
      <p>Declare that the left side of the string should be chopped.</p>

      <p>This sets {@link com.github.xbn.text.padchop.PadString#isSideRight() isSideRight}{@code ()}* to {@code false}.</p>

      @return  <i>{@code this}</i>
      @see  #goalLen(int) goalLen(i)
    **/
   public PadString_CfgForNeeder<P,R> left()  {
      bSideRight = false;
      return  this;
   }
   /**
      <p>Define the character to pad with.</p>

      @param  pad_char  Get with {@link com.github.xbn.text.padchop.PadString#getPadChar() getPadChar}{@code ()}*
      @return  <i>{@code this}</i>
      @see  #withSpace()
    **/
   public PadString_CfgForNeeder<P,R> with(char pad_char)  {
      cPad = pad_char;
      return  this;
   }
   /**
      <p>Declare the pad-character to be a space.</p>

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
      <p>Create a new {@code PadString} from the configuration.</p>

         <p><i><b>See:</b></i><ul>
         <li><i>{@link #endCfg() endCfg}{@code ()}</i></li>
         </ul></p>


      @return  <code>(new {@link com.github.xbn.text.padchop.PadString#PadString(PadString_Fieldable) PadString}(this))</code>
    **/
   public P build()  {
      @SuppressWarnings("unchecked")
      P p = (P)(new PadString(this));
      return  p;
   }
   /**
      @return  <i>{@code this}</i>
    **/
   public PadString_CfgForNeeder<P,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<P> clsp = (Class<P>)(Class)PadString.class;
      startConfigReturnNeedable(needer, clsp);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

      @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
      @return  <i>{@code this}</i>
    **/
   public PadString_CfgForNeeder<P,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//other...END
}
