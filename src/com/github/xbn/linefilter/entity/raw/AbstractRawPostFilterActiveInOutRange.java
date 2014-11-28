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
package  com.github.xbn.linefilter.entity.raw;
	import  com.github.xbn.linefilter.entity.OutOfRangeResponseWhen;
	import  com.github.xbn.io.TextAppenter;
	import  com.github.xbn.io.NewTextAppenterFor;
	import  com.github.xbn.linefilter.entity.OnOffAbort;
	import  java.util.Objects;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.number.LengthInRange;
/**
	<P>The base class for {@code PostFilterActiveInOutRange} and {@code PostFilterSelfActiveInOutRange}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractRawPostFilterActiveInOutRange<L> implements RawOnOffEntityFilter<L>  {
	private final LengthInRange range  ;
	private final OnOffAbort    ofaIn  ;
	private final OnOffAbort    ofaOut ;
	private final TextAppenter  dbgAptr;
	private final boolean       doRespondImmediate;
	/**
		<P>Create a new instance from an entity, range, and when-in setting.</P>

		@param  range  May not be {@code null}. Get with {@link #getRange() getRange}{@code ()}
		@param  when_inRange  When {@link OnOffAbort#ON ON} and the {@linkplain RawEntity#getFullyActiveCount() fully-active count} is <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com.github.xbn.number.NumberInRange#isIn(N)">in the range</A>, then the entity is on. May not be {@code null}. Get with {@link #getStateForInRange() getStateForInRange}{@code ()}.
		@param  when_outOfRange  When {@code ON} and the fully-active count is not in the range, then the entity is on. May not be {@code null}. Get with {@link #getStateForOutOfRange() getStateForOutOfRange}{@code ()}.
	 **/
	public AbstractRawPostFilterActiveInOutRange(LengthInRange range, OnOffAbort when_inRange, OnOffAbort when_outOfRange, OutOfRangeResponseWhen response, Appendable debug_ifNonNull)  {
		Objects.requireNonNull(range, "range");
		Objects.requireNonNull(when_inRange, "when_inRange");
		Objects.requireNonNull(when_outOfRange, "when_outOfRange");

		this.range = range;
		ofaIn = when_inRange;
		ofaOut = when_outOfRange;
		try  {
			doRespondImmediate = response.isImmediate();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(response, "response", null, rx);
		}
		dbgAptr = NewTextAppenterFor.appendableUnusableIfNull(debug_ifNonNull);
	}
	public LengthInRange getRange()  {
		return  range;
	}
	public OnOffAbort getStateForInRange()  {
		return  ofaIn;
	}
	public OnOffAbort getStateForOutOfRange()  {
		return  ofaOut;
	}
	public boolean doRespondImmediately()  {
		return  doRespondImmediate;
	}
	public boolean doWaitForNextActiveLine()  {
		return  !doRespondImmediately();
	}
	public TextAppenter getDebugAptr()  {
		return  dbgAptr;
	}
	public final OnOffAbort getPreState(RawEntity<L> ignored, int ignored2, L ignored3)  {
		return  OnOffAbort.ON;
	}
	/**
		@return  If the entity's {@linkplain RawEntity#getFullyActiveCount() active count} is<UL>
			<LI><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/number/NumberInRange.html#isIn(N)">In</A> the range: {@link #getStateForInRange() getStateForInRange}{@code ()}</LI>
			<LI>Not in range and {@link #doWaitForNextActiveLine() doWaitForNextActiveLine}{@code ()} is<UL>
				<LI>{@code true}: {@code getStateForInRange()}</LI>
				<LI>{@code false}: {@link #getStateForOutOfRange() getStateForOutOfRange}{@code ()}</LI>
			</UL></LI>
		</UL>
		@see  #getRange()
	 **/
	protected OnOffAbort getPostStateForCount(RawEntity<L> entity)  {
		boolean isIn = false;
		try  {
			isIn = getRange().isIn(entity.getFullyActiveCount());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(entity, "entity", null, rx);
		}

		if(isIn)  {
			return  returnAndDebug(entity, getStateForInRange());
		}

		//Out of range

		if(doRespondImmediately()  ||  entity.isActive())  {
			return  returnAndDebug(entity, getStateForOutOfRange());
		}

		//Out of range, wait for next active line, and this one is not active

		return  returnAndDebug(entity, getStateForInRange());
	}
		private OnOffAbort returnAndDebug(RawEntity<L> entity, OnOffAbort return_value)  {
			if(getDebugAptr().isUseable())  {
				getDebugAptr().appentln(getClass().getSimpleName() + ".getPostState: " + entity.getDebuggingPrefix() + " (is-" + (entity.isActive()?"":"not-") + "active, active-count=" + entity.getFullyActiveCount() + "), on-off-filter=<" + getClass().getName() + ": " + this + ">, returning " + return_value);
			}
			return  return_value;
		}
	public void resetState()  {
	}
	public String toString()  {
		return  "range=" + getRange() + ", in-range=" + getStateForInRange() + ", out-of-range=" + getStateForOutOfRange() +
		", respond-" + (doRespondImmediately() ? "immediately" : "at-next-active-line");
	}
}
