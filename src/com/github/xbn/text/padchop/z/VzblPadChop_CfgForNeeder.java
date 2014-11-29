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
/**
	<p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}.</p>

	@see  <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">Definition: indirectly</a>
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
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
		<p>Create a new {@code VzblPadChop_CfgForNeeder} with no goal-length.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#VzblPadChop_CfgForNeeder(R, int)">this</a>(needer, -1)</code></p>
		@see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#VzblPadChop_CfgForNeeder(R, int)">this</a>(R,i)</code>
	 **/
	public VzblPadChop_CfgForNeeder(R needer)  {
		this(needer, -1);
	}
	/**
		<p>Create a new {@code VzblPadChop_CfgForNeeder} with a default goal-length.</p>

			<p>This<ol>
			<li>Calls <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/chain/AbstractNeedableWithSubs.html#AbstractNeedableWithSubs(boolean, boolean, R)">super</a>(true, true, needer)</code></li>
			<li>Calls {@link #reset(int) reset(goal_len)}</li>
		</ol></p>

		@see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#VzblPadChop_CfgForNeeder(R)">this</a>(R)</code>
	 **/
	public VzblPadChop_CfgForNeeder(R needer, int goal_len)  {
		super(true, true, needer);
		resetVPC(goal_len);
	}
//constructors...END
//setters...START
	/**
		<p>Revert all configuration to <i>nothing</i>.</p>

		@return  {@link #reset(int) reset}{@code (-1)}
	 **/
	public VzblPadChop_CfgForNeeder<V,R> reset()  {
		return  reset(-1);
	}
	/**
		<p>Declare a goal-length, but otherwise revert all configuration to <i>nothing</i>.</p>

			<p>This calls<ol>
			<li>{@link #trim(boolean, boolean) trim(false, false)}</li>
			<li>{@link #noEscape() noEscape}{@code ()}</li>
			<li>{@link #cfgPad(boolean, int) cfgPad}{@code (false, goal_len).}{@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#endCfg}{@code ()}</li>
			<li>{@link #cfgChop(boolean, int)}{@code (false, goal_len).}{@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#endCfg}{@code ()}</li>
			<li>{@link #padFirst() padFirst}{@code ()}</li>
		</ol></p>

		@return  <i>{@code this}</i>
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
		<p>Set the desired length for the output.</p>

		<p>This sets<ol>
			<li>The internal {@link PadString} to <code><i>[the internal PadString]</i>.{@link com.github.xbn.text.padchop.PadChopBase#getCopyNewGoalLen(int) getCopyNewGoalLen}(length)</code></li>
			<li>The internal {@link ChopString} to <code><i>[the internal ChopString]</i>.getCopyNewGoalLen(length)</code></li>
		</ol></p>

		@return  <i>{@code this}</i>
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
		<p>Trim the left side of the string.</p>

		@return  {@link #trim(boolean, boolean) trim(true, false)}
	 **/
	public VzblPadChop_CfgForNeeder<V,R> trimLeft()  {
		return  trim(true, false);
	}
	/**
		<p>Trim the right side of the string.</p>

		@return  {@link #trim(boolean, boolean) trim(false, true)}
	 **/
	public VzblPadChop_CfgForNeeder<V,R> trimRight()  {
		return  trim(false, true);
	}
	/**
		<p>Trim both sides of the string.</p>

		@return  {@link #trim(boolean, boolean) trim(true, true)}
	 **/
	public VzblPadChop_CfgForNeeder<V,R> trim()  {
		return  trim(true, true);
	}
	/**
		<p>Declare which sides of the string should be trimmed.</p>

			<p><i><b>See:</b></i><ul>
			<li><i>{@link #trimLeft() trimLeft}{@code ()}, {@link #trimRight() trimRight}{@code ()}, {@link #trim() trim}{@code ()}</i></li>
			</ul></p>

		@param  do_left  If {@code true}, the left side of the string is trimmed. Get with  <code><i>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doTrimLeft() doTrimLeft}()</code>.
		@param  do_right  If {@code true}, the right side of the string is trimmed. Get with  <code><i>[VzblPadChop]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doTrimRight() doTrimRight}()</code>.
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> trim(boolean do_left, boolean do_right)  {
		bTrimLeft = do_left;
		bTrimRight = do_right;
		return  this;
	}
	/**
		<p>Leave control characters alone.</p>

		<p>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <code>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#NOTHING NOTHING}</code></p>

		@return  <i>{@code this}</i>
		@see  #unescape()
	 **/
	public VzblPadChop_CfgForNeeder<V,R> noEscape()  {
		esc = EscapeAction.NOTHING;
		return  this;
	}
	/**
		<p>Unescape control characters.</p>

		<p>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <code>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#UNESCAPE UNESCAPE}</code></p>

		@return  <i>{@code this}</i>
		@see  #noEscape()
		@see  #escape()
	 **/
	public VzblPadChop_CfgForNeeder<V,R> unescape()  {
		esc = EscapeAction.UNESCAPE;
		return  this;
	}
	/**
		<p>EscapeAction control characters.</p>

		<p>This sets {@link VzblPadChop#getEscapeAction() getEscapeAction}{@code ()} to <code>{@link com.github.xbn.text.padchop.EscapeAction EscapeAction}.{@link com.github.xbn.text.padchop.EscapeAction#ESCAPE ESCAPE}</code></p>

		@return  <i>{@code this}</i>
		@see  #unescape()
	 **/
	public VzblPadChop_CfgForNeeder<V,R> escape()  {
		esc = EscapeAction.ESCAPE;
		return  this;
	}
	/**
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> escapeNothingIfNull(EscapeAction action)  {
		esc = ((action == null) ? EscapeAction.NOTHING : action);
		return  this;
	}

	/**
		<p>Turn padding on or off.</p>

		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> pad(boolean is_on)  {
		bPad = is_on;
		return  this;
	}
	/**
		<p>Turn chopping on or off.</p>

		@return  <i>{@code this}</i>
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
		<p>Define chopping configuration.</p>

			<p><i><b>See:</b></i><ul>
			<li><i>{@link #chop(boolean) chop(b)}</i></li>
			</ul></p>

		<p>.............May not be {@code null}, and if {@code is_on} is {@code true}, {@code chpr.getGoalLen()} must be zero or greater. Get with  <code><i>[VzblPadChop]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#getChop() getChop}()</code>. If
		<br/> &nbsp; &nbsp; <code>chpr.{@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}()</code>
		<br/>is different than
		<br/> &nbsp; &nbsp;  <code><i>[the currently-set {@link com.github.xbn.text.padchop.PadString PadString}]</i>.getGoalLen()</code>
		<br/>Then the {@code DifferentGoalLengths} parameter in the {@code VzblPadChop} {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) constructor} dictates the action taken.</p>

		@param  is_on  If {@code true} padding is active. Get with  <code><i>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doPad() doPad}()</code>
	 **/
	public ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>> cfgChop(boolean is_on, int goal_len)  {
		bChop = is_on;
		return  (new ChopString_CfgForNeeder<ChopString,VzblPadChop_CfgForNeeder<V,R>>(this, goal_len));
	}
	public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad(boolean is_on)  {
		return  cfgPad(is_on, padString.getGoalLen());
	}
	/**
		<p>Define padding configuration.</p>

			<p><i><b>See:</b></i><ul>
			<li><i>{@link #pad(boolean) pad(b)}</i></li>
			</ul></p>

		<p>May not be {@code null}, and if {@code is_on} is {@code true}, {@code padr.getGoalLen()} must be zero or greater. Get with  <code><i>[VzblPadChop]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#getPad() getPad}()</code>. If
		<br/> &nbsp; &nbsp; <code>padr.{@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}()</code>
		<br/>is different than
		<br/> &nbsp; &nbsp;  <code><i>[the currently-set {@link com.github.xbn.text.padchop.ChopString ChopString}]</i>.getGoalLen()</code>
		<br/>Then the {@code DifferentGoalLengths} parameter in the {@code VzblPadChop} {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) constructor} dictates the action taken.</p>

		@param  is_on  If {@code true} padding is active. Get with  <code><i>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doPad() doPad}()</code>
	 **/
	public PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>> cfgPad(boolean is_on, int goal_len)  {
		bPad = is_on;
		return  (new PadString_CfgForNeeder<PadString,VzblPadChop_CfgForNeeder<V,R>>(this, goal_len));
	}
	/**
		<p>Pad the string before chopping it.</p>

			<p><i><b>See:</b></i><ul>
			<li><i>{@link #chopFirst() chopFirst}{@code ()}</i></li>
			</ul></p>
Get with  <code><i>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doPadFirst() doPadFirst}()</code>. This is ignored when either padding or chopping is off.
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> padFirst()  {
		bPadFirst = true;
		return  this;
	}
	/**
		<p>Chop the string before padding it.</p>

		<p>Get with  <code><i>[{@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}]</i>.{@link com.github.xbn.text.padchop.VzblPadChop#doPadFirst() doPadFirst}()</code>. This is ignored when either padding or chopping is off.</p>

		@return  <i>{@code this}</i>
		@see  #padFirst()
	 **/
	public VzblPadChop_CfgForNeeder<V,R> chopFirst()  {
		bPadFirst = false;
		return  this;
	}
	/**
		<p>Set debugging.</p>

		@param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> debugTo(Appendable dest_ifNonNull)  {
		apblDebug = dest_ifNonNull;
		return  this;
	}
//setters...END
	/**
		<p>Create a new {@code VzblPadChop} as configured.</p>

		@return  <code>{@link #build(DifferentGoalLengths) build}({@link com.github.xbn.text.padchop.DifferentGoalLengths DifferentGoalLengths}.{@link com.github.xbn.text.padchop.DifferentGoalLengths#IGNORE IGNORE})</code></p>
	 **/
	public V build()  {
		return  build(DifferentGoalLengths.IGNORE);
	}
	/**
		<p>Create a new {@code VzblPadChop} as configured.</p>

		@return  <code>(V)new {@link com.github.xbn.text.padchop.VzblPadChop#VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) VzblPadChop}(id_gl, this)</code>
		@see  #build()
	 **/
	public V build(DifferentGoalLengths id_gl)  {
		@SuppressWarnings("unchecked")
		V v = (V)new VzblPadChop(id_gl, this);
		return  v;
	}
	/**
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> startConfigReturnNeedable(R needer)  {
		startConfig(needer, VzblPadChop.class);
		return  this;
	}
	/**
		@return  <i>{@code this}</i>
	 **/
	public VzblPadChop_CfgForNeeder<V,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	/**
		<p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

		@return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
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
