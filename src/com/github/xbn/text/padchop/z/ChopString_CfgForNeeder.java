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
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.text.padchop.ChopString ChopString}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ChopString_CfgForNeeder<C extends ChopString,R extends Needer> extends PadChopBase_CfgForNeeder<C,R> implements ChopString_Fieldable  {
//state
   public int        iCharsBeforeDDD;
   public int        iDDDOverhang   ;
   public String     sEllipsis      ;
   public Appendable apblDebug      ;
//constructors...START
   /**
      <p>Create a new {@code zChopString_CfgForNeeder} with defaults.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="ChopString_CfgForNeeder.html#ChopString_CfgForNeeder(R, int)">super</a>(needer, -1)</code></p>
    */
   public ChopString_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <p>Create a new {@code zChopString_CfgForNeeder} with defaults, but a specific goal length.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="ChopString_CfgForNeeder.html#ChopString_CfgForNeeder(int, R)">this</a>(goal_len, needer)</code></li>
         <li>{@link #right() right}{@code ()}</li>
         <li>{@link #noDDD() noDDD}{@code ()}</li>
         <li>{@link #atEnd() atEnd}{@code ()}</li>
         <li>{@link #noOverhang() noOverhang}{@code ()}</li>
      </ol>
    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#zChopString_CfgForNeeder(R)">this</a>(R)</code>
    */
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
      <p>Declare the length that the string should be chopped to.</p>

    * @param  goal_len  May not be less than zero. Get with {@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public ChopString_CfgForNeeder<C,R> goalLen(int goal_len)  {
      iGoalLen = goal_len;
      return  this;
   }
   /**
      <p>Declare that the right side of the string should be chopped.</p>

      <p>This sets {@link com.github.xbn.text.padchop.PadChopBase#isSideRight() isSideRight}{@code ()}* to {@code true}.</p>

    * @return  <i>{@code this}</i>
    * @see  #left()
    */
   public ChopString_CfgForNeeder<C,R> right()  {
      bSideRight = true;
      return  this;
   }
   /**
      <p>Declare that the left side of the string should be chopped.</p>

      <p>This sets {@link com.github.xbn.text.padchop.PadChopBase#isSideRight() isSideRight}{@code ()}* to {@code false}.</p>

    * @return  <i>{@code this}</i>
    * @see  #right()
    */
   public ChopString_CfgForNeeder<C,R> left()  {
      bSideRight = false;
      return  this;
   }
   /**
      <p>Do not use an ellipsis.</p>

    * @return  {@link #ddd(String) ddd(null)}
    */
   public ChopString_CfgForNeeder<C,R> noDDD()  {
      return  ddd(null);
   }
   /**
      <p>Use the default ellipsis.</p>

    * @return  {@link #ddd(String) ddd}{@code ("...")}
    */
   public ChopString_CfgForNeeder<C,R> ddd()  {
      return  ddd("...");
   }
   /**
      <p>Set the chop-ellipsis, that visually indicates a chop (for example: &quot;{@code ...}&quot; [dot-dot-dot]).</p>

    * @param  ellipsis  What is added to the end of chopped text. May not be empty. Get with  {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()}*. When {@code null}, there is no ellipsis, and both {@link #getOverhangCount() getOverhangCount}{@code ()} and {@link #getCharsBeforeDDD() getCharsBeforeDDD}{@code ()} are ignored. <i>Notes<ul>
         <li>If this is longer than the {@link ChopString_CfgForNeeder#getGoalLen() goal length}, then when attempting to chop the string, <i><b>an {@code IllegalArgumentException} will be thrown</b></i>.</li>
         <li>In all cases, the ellipsis is displayed in its entirety, even if it contains more characters than the goal length.</li>
      </ul></i>
    * @return  <i>{@code this}</i>
    */
   public ChopString_CfgForNeeder<C,R> ddd(String ellipsis)  {
      sEllipsis = ellipsis;
      return  this;
   }
   /**
      <p>Define the maximum number of characters in the ellipsis that can <i>exceed</i> the chopped string.</p>

      <p>Example is in {@code java com.github.xbn.text.ChopString}</p>

      <p>Notes:<ul>
         <li>This setting is never violated (in no cases is the overhang exceeded).</li>
         <li>See &quot;note 2&quot; in {@link #charsBefore(int) charsBefore}{@code (i)}, regarding precedence.</li>
      </ul>

    * @param  char_len  If {@code -1} or less, or greater than {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()*.length()}, then {@code getOverhangCount()} will return {@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}{@code ()*.length()}. Get with {@link com.github.xbn.text.padchop.ChopString#getOverhangCount() getOverhangCount}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #maxOverhang()
    * @see  #noOverhang()
    */
   public ChopString_CfgForNeeder<C,R> overhang(int char_len)  {
      iDDDOverhang = char_len;
      return  this;
   }
   /**
      <p>The ellipsis always exceeds the chopped string as much as possible.</p>

    * @return  <code>{@link #overhang(int) overhang}({@link com.github.xbn.text.padchop.ChopString#getEllipsis() getEllipsis}()*.length())</code>
    */
   public ChopString_CfgForNeeder<C,R> maxOverhang()  {
      try  {
         return  overhang(sEllipsis.length());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(sEllipsis, "sEllipsis", getChainIDForXMsg("Must set ddd(s). Call to *Overhang() or overhang(i) must follow ddd(s)."), rx);
      }
   }
   /**
      <p>The ellipsis is always contained within the chopped text.</p>

    * @return  <code>{@link #overhang(int) overhang}(0)</code>
    */
   public ChopString_CfgForNeeder<C,R> noOverhang()  {
      return  overhang(0);
   }
   /**
      <p>Set debugging.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public ChopString_CfgForNeeder<C,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }

   /**
      <p>Define the minimum number of characters to display before the chop--therefore defining the <i>location</i> of the chop (and chop-ellipsis).</p>

{@code java com.github.xbn.examples.text.padchop.CharsBeforeChopXmpl}
      <p>Notes:<ol>
         <li><i>This setting is ignored when there is no chop-ellipsis</i>. When {@link #getEllipsis() getEllipsis}{@code ()} is {@code null}, the chop always happens on the end. To force chopping in the middle with no ellipsis, set the ellipsis to the empty string.</li>
         <li>The {@link #getOverhangCount() ddd-max-overhang} setting trumps this min-start-chars setting. That is, when-and-only-when the {@link #getGoalLen() goal length} is short enough, such that the {@link #getEllipsis() chop ellipsis} will not fit <b>unless one of these two settings is violated</b>, the min-start-chars setting <b>will</b> be violated. The max-overhang is never violated.</li>
      </ol>

    * @param  len  The number of characters, <i>starting on the <b>opposite</b> {@link #right() side} of the chop</i>, that must be in the final-result string. Get with {@link com.github.xbn.text.padchop.ChopString#getCharsBeforeDDD() getCharsBeforeDDD}{@code ()}*. When {@code len} is<ul>
         <li>{@link com.github.xbn.text.padchop.ChopString#iIN_MIDDLE}: {@code getCharsBeforeDDD()} is set to <code>({@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}() / 2)</code>. <i>In this case, {@code getOverhangCount()} is ignored.</i></li>
         <li>{@link com.github.xbn.text.padchop.ChopString#iAT_END}:  or greater than {@code <i>[super]</i>.getGoalLen()}: {@code getCharsBeforeDDD()} is set to {@code getGoalLen()}.</li>
         <li>Between {@code 0} and {@code <i>[super]</i>.getGoalLen()} (inclusive): {@code getCharsBeforeDDD()} is set to that number.</li>
      </ul>
    * @return  <i>{@code this}</i>
    */
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
      <p>Create a new {@code ChopString} from the configuration.</p>

         <p><i><b>See:</b></i><ul>
         <li><i>{@link #endCfg() endCfg}{@code ()}</i></li>
         </ul>


    * @return  {@code (new }{@link com.github.xbn.text.padchop.ChopString#ChopString(ChopString_Fieldable) ChopString}{@code (this))}
    */
   public C build()  {
      @SuppressWarnings("unchecked")
      C c = (C)(new ChopString(this));
      return  c;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public ChopString_CfgForNeeder<C,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public ChopString_CfgForNeeder<C,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<C> clsc = (Class<C>)(Class)ChopString.class;
      startConfigReturnNeedable(needer, clsc);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

    * @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    */
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
//other...END
}
