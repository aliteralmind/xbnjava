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
package  com.github.xbn.analyze.alter;
	import  java.util.Objects;
	import  com.github.xbn.text.Trim;
	import  static com.github.xbn.lang.XbnConstants.*;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.ObjectOrCrashIfNull;
	import  com.github.xbn.lang.RuleType;
	import  com.github.xbn.lang.XInfoAccumulator;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.analyze.validate.ValidatorComposer;
	import  com.github.xbn.analyze.validate.NewValueValidatorFor;
	import  com.github.xbn.text.StringUtilBase;
/**
	<P>A {@code ValueAlterer} that does one of two things: One action when a condition is met, and another when it is not. Internally this is two {@code ValueAlterer}-s and an <CODE>xbn.analyze.validate.{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}</CODE>, the latter of which is the &quot;alter condition&quot;. If
	<BR> &nbsp; &nbsp; {@link #getCondition() getCondition}{@code ().isValid(V)}
	<BR>is {@code true}, then {@code A} is altered by the {@link #getAlterValid() valid alterer}. Otherwise, it is altered by the {@link #getAlterInvalid() invalid alterer}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class AlterValueWhen<V,A> extends AbstractValueAlterer<V,A>  {
//config
	private final ValueValidator<V>  vv        ;
	private final ValueAlterer<V,A>  avValid   ;
	private final ValueAlterer<V,A>  avInvalid ;
//internal
//cofig
//	private boolean bNoCndValid = false;
//internal
//constructors...START
	/**
		<P>Create a new {@code AlterValueWhen} that makes no alterations.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(
		<BR> &nbsp; &nbsp; (ValueValidator&lt;V&gt;)NewValueValidatorFor.unrestricted(null, null),
		<BR> &nbsp; &nbsp; (new ReturnValueUnchanged&lt;V,A&gt;()), (new ReturnValueUnchanged&lt;V,A&gt;()))</CODE></P>
	 **/
	public AlterValueWhen()  {
		this(
			NewValueValidatorFor.<V>unrestricted(null, null),
			(new ReturnValueUnchanged<V,A>()), (new ReturnValueUnchanged<V,A>()));
	}
	/**
		<P>Create a new {@code AlterValueWhen}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(
		<BR> &nbsp; &nbsp; (ValueValidator&lt;V&gt;)new NewValueValidatorFor.unrestricted(null, null),
		<BR> &nbsp; &nbsp; alter_forValid, (new {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#ReturnValueUnchanged() ReturnValueUnchanged}&lt;A&gt;()))</CODE></P>
	 **/
	public AlterValueWhen(ValueAlterer<V,A> alter_forValid)  {
		this(
			NewValueValidatorFor.<V>unrestricted(null, null),
			alter_forValid, (new ReturnValueUnchanged<V,A>()));
	}
	/**
		<P>Create a new {@code AlterValueWhen} that does nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(condition, alter_forValid, (new ReturnValueUnchanged<V,A>()))</CODE></P>
	 **/
	public AlterValueWhen(ValueValidator<V> condition, ValueAlterer<V,A> alter_forValid)  {
		this(condition, alter_forValid, (new ReturnValueUnchanged<V,A>()));
	}
	/**
		<P>Create a new {@code AlterValueWhen}.</P>

		<P>This calls {@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer() super}{@code ()}, and resets {@link #zresetStateAVW() state} and {@link #zresetCountsAVW() counts}</LI>
		</OL></P>

		<P><I>All parameters must be non-{@code null}. They are also all duplicated internally (defensively copied).</I></P>

		@param  condition  Get with {@link #getCondition() getCondition}{@code ()}.
		@param  alter_forValid  Get with {@link #getAlterValid() getAlterValid}{@code ()}.
		@param  alter_forInvalid  Get with {@link #getAlterInvalid() getAlterInvalid}{@code ()}. When attempting to  <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="getAltered(V, A)">make the alteration</A> and the condition is not met, {@code alter_forInvalid} makes the actual alteration, and therefore determines the value of <I>{@code this}</I> classes {@link com.github.xbn.analyze.alter.Alterer#wasAltered() wasAltered}{@code ()} flag. Therefore, when an alteration is not wanted when the condition is not met, <CODE>alter_forInvalid.{@link com.github.xbn.lang.Expirable#isExpired() isExpired}()</CODE> should be {@code true} (in most cases, expired alterers will return the original value unchanged).
		@see  #AlterValueWhen() this()
		@see  #AlterValueWhen(ValueValidator, ValueAlterer) this(vv,av)
		@see  #AlterValueWhen(AlterValueWhen) this(avw)
	 **/
	public AlterValueWhen(ValueValidator<V> condition, ValueAlterer<V,A> alter_forValid, ValueAlterer<V,A> alter_forInvalid)  {
		super();
		try  {
			vv = condition.getObjectCopy();
			avValid = alter_forValid.getObjectCopy();
			avInvalid = alter_forInvalid.getObjectCopy();
		}  catch(RuntimeException rx)  {
			Objects.requireNonNull(condition, "condition");
			Objects.requireNonNull(alter_forValid, "alter_forValid");
			throw  CrashIfObject.nullOrReturnCause(alter_forInvalid, "alter_forInvalid", null, rx);
		}

		//Never ever call interface functions, directly or indirectly, in a constructor.
		zresetStateAVW();
		zresetCountsAVW();

		if(getAlterValid().isExpired()  &&  getAlterInvalid().isExpired())  {
			declareExpirable();
			declareExpired();
		}
		if(!isExpired())  {
			declareMayDelete(getAlterValid().mayDelete()  &&  getAlterInvalid().mayDelete());
		}
	}
	/**
		<P>Create a new {@code AlterValueWhen} as a duplicate of another.</P>

		<P>This calls<OL>
			<LI>{@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer(ValueAlterer) super}{@code (to_copy)}</LI>
			<LI>{@link #zresetStateAVW() zresetStateAVW}{@code ()}</LI>
		</OL></P>
		@see  #getObjectCopy()
		@see  #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this(vv,av,av,b)
	 **/
	//to_copy is an AlterValueWhen, and therefore DOES have
	//the types as expected, for all three objects.
	public AlterValueWhen(AlterValueWhen<V,A> to_copy)  {
		super(to_copy);
		@SuppressWarnings("unchecked")
		ValueValidator<V> vv2 = (ValueValidator<V>)ObjectOrCrashIfNull.
			<ValueValidator>getCopy(to_copy.getCondition(), ValueValidator.class, "to_copy.getCondition()");
		vv = vv2;

		avValid = getAVCopy(to_copy.getAlterValid(), "to_copy.getAlterValid()");
		avInvalid = getAVCopy(to_copy.getAlterInvalid(), "to_copy.getAlterInvalid()");

		//Never ever call interface functions, directly or indirectly, in a constructor.
		zresetStateAVW();
	}
		private static final <V,A> ValueAlterer<V,A> getAVCopy(ValueAlterer<V,A> alterer, String alter_name)  {
			@SuppressWarnings("unchecked")
			ValueAlterer<V,A> avw2 = (ValueAlterer<V,A>)ObjectOrCrashIfNull.
				<ValueAlterer>getCopy(alterer, ValueAlterer.class, alter_name);
			return  avw2;
		}
//constructors...END
//setters...START
	/**
		<P>Reset non-count state.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link #zresetStateAVW() zresetStateAVW}{@code ()}</P>

		@see  #resetCounts()
	 **/
	public void resetState()  {
		super.resetState();
		zresetStateAVW();
	}
	/**
		<P>Reset non-count state specific to this {@code AlterValueWhen}.</P>

		<P>This calls<OL>
			<LI>{@link #getCondition() getCondition}{@code ().}{@link #resetState() resetState}{@code ()}</LI>
			<LI>{@link #getAlterValid() getAlterValid}{@code ().resetState()}</LI>
			<LI>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetState()}</LI>
		</OL></P>
	 **/
	protected final void zresetStateAVW()  {
		getCondition().resetState();
		getAlterValid().resetState();
		getAlterInvalid().resetState();
	}
	/**
		<P>Reset counters to zero.</P>

		<P>This calls<OL>
			<LI>{@link #zresetCountsAVW() zresetCountsAVW}{@code ()}</LI>
		</OL></P>
		@see  #resetState()
	 **/
	public void resetCounts()  {
		super.resetCounts();
		zresetCountsAVW();
	}
	/**
		<P>Reset counters to zero specific to this {@code AlterValueWhen}.</P>

		<P>This calls<OL>
			<LI>{@link #getCondition() getCondition}{@code ().}{@link #resetCounts() resetCounts}{@code ()}</LI>
			<LI>{@link #getAlterValid() getAlterValid}{@code ().resetCounts()}</LI>
			<LI>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetCounts()}</LI>
		</OL></P>
		@see  #resetCounts()
	 **/
	protected final void zresetCountsAVW()  {
		getCondition().resetCounts();
		getAlterValid().resetCounts();
		getAlterValid().resetCounts();
	}
	/**
		<P>Updates internal state after a manual deletion.</P>

		<P>This calls<OL>
			<LI>{@link #getCondition() getCondition}{@code ().}{@link com.github.xbn.analyze.validate.ValidatorComposer#resetState() resetState}{@code ()}</LI>
			<LI>{@link #getAlterValid() getAlterValid}{@code ().resetForDeletion()}</LI>
			<LI>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetForDeletion()}</LI>
		</OL></P>
	 **/
	public void resetForDeletion()  {
		getCondition().resetState();
		getAlterValid().resetForDeletion();
		getAlterInvalid().resetForDeletion();
	}
//getters...START
	/**
		<P>The alterer used when the condition is met.</P>
	 **/
	public ValueAlterer<V,A> getAlterValid()  {
		return  avValid;
	}
	/**
		<P>The alterer used when the condition is not met.</P>
	 **/
	public ValueAlterer<V,A> getAlterInvalid()  {
		return  avInvalid;
	}
	/**
		<P>The alter-condition.</P>
	 **/
	public ValueValidator<V> getCondition()  {
		return  vv;
	}
	public boolean doesExpire()  {
		return  getCondition().doesExpire();
	}
	public boolean isExpired()  {
		return  getCondition().isExpired();
	}
	public boolean doAutoResetState()  {
		return  getCondition().doAutoResetState();
	}
	public RuleType getRuleType()  {
		return  getCondition().getRuleType();
	}
	/**
		@return  <CODE>{@link #appendRules(StringBuilder) appendRules}(new StringBuilder()).toString()</CODE>
	 **/
	public String getRules()  {
		return  appendRules(new StringBuilder()).toString();
	}
	/**
		@param  to_appendTo May not be {@code null}.
		@see  #getRules()
	 **/
	public StringBuilder appendRules(StringBuilder to_appendTo)  {
		try  {
			getCondition().appendRules(to_appendTo);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}
		return  to_appendTo;
	}
//getters...END
	/**
		<P>Get the altered value, based on the configuration throughout this class.</P>

		@param  to_validate  The object to validate.
		@param  to_alter  The object to alter.
	 **/
	public A getAlteredPostResetCheck(V to_validate, A to_alter)  {
		if(isDebugOn()) { getDebugAptr().appentln("<AVW> to_validate=[" + StringUtilBase.getChopped(Trim.YES, to_validate, 30, "...") + "], to_alter=[" + StringUtilBase.getChopped(Trim.YES, to_alter, 30, "...") + "], [" + this + "]"); }

		if(isExpired())  {
			if(isDebugOn()) { getDebugAptr().appentln("<AVW> isExpired()=true (returning to_alter)"); }
			return  to_alter;
		}

		ValueAlterer<V,A> alterer = (getCondition().isValid(to_validate)
			?  getAlterValid()
			:  getAlterInvalid());

		to_alter = alterer.getAltered(to_validate, to_alter);
		boolean bWsLtrd = getAlterValid().wasAltered();
		boolean bNtbDel = getAlterValid().needsToBeDeleted();

		declareAltered(Altered.getForBoolean(bWsLtrd), NeedsToBeDeleted.getForBoolean(bNtbDel));

		if(isDebugOn()) { getDebugAptr().appentln("<AVW> wasAltered()=" + wasAltered() + ", getCondition().isValid()=" + getCondition().isValid() + ". Returning [" + StringUtilBase.getChopped(Trim.YES, to_alter, 30, "...") + "], needsToBeDeleted()=" + needsToBeDeleted()); }

		return  to_alter;
	}
//debugging...START
	/**
		<P>Turn debugging on or off.</P>

		<P>This calls<OL>
			<LI>{@link #getCondition() getCondition}{@code ().setDebugOn(is_on)}</LI>
			<LI>{@link #getAlterValid() getAlterValid}{@code ().setDebugOn(is_on)}</LI>
			<LI>{@link #getAlterInvalid() getAlterInvalid}{@code ().setDebugOn(is_on)}</LI>
		</OL></P>
	 **/
	public void setDebugOn(boolean is_on)  {
		super.setDebugOn(is_on);
		getCondition().setDebugOn(is_on);
		getAlterValid().setDebugOn(is_on);
		getAlterInvalid().setDebugOn(is_on);
	}
	/**
		<P>Set the debug-writer.</P>

		<P>This calls<OL>
			<LI>{@link #getCondition() getCondition}{@code ().setDebug(destination)}</LI>
			<LI>{@link #getAlterValid() getAlterValid}{@code ().setDebug(destination)}</LI>
			<LI>{@link #getAlterInvalid() getAlterInvalid}{@code ().setDebug(destination)}</LI>
		</OL></P>
		@see  #setDebugOn(boolean) setDebugOn(b)
	 **/
	public void setDebug(Appendable destination, boolean is_on)  {
		super.setDebug(destination, is_on);
		getCondition().setDebug(destination, is_on);
		getAlterValid().setDebug(destination, is_on);
		getAlterInvalid().setDebug(destination, is_on);
	}
//debugging...END
//other...START
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		try  {
			super.appendToString(to_appendTo);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}
		return  to_appendTo.append(": ").append(LINE_SEP).append(" - getCondition()=").append(getCondition()).append(LINE_SEP).
			append(" - getAlterValid()=[").append(getAlterValid()).append("]").append(LINE_SEP).
			append(" - getAlterInvalid()=[").append(getAlterInvalid());
	}
	public Object getExtraErrInfo()  {
		return  getCondition().getExtraErrInfo();
	}
	public void setExtraErrInfo(Object info)  {
		super.setExtraErrInfo(info);
		getCondition().setExtraErrInfo(info);
		getAlterValid().setExtraErrInfo(info);
		getAlterInvalid().setExtraErrInfo(info);
	}
	/**
		@return  <CODE>(new {@link #AlterValueWhen(AlterValueWhen) AlterValueWhen}&lt;V,A&gt;(this))</CODE>
	 **/
	public AlterValueWhen<V,A> getObjectCopy()  {
		return  (new AlterValueWhen<V,A>(this));
	}
/*
	public boolean wasAltered()  {
		return  (getAlterValid().wasAltered()  ||  getAlterInvalid().wasAltered());
	}
	public int getAlteredCount()  {
		return  (getAlterValid().getAlteredCount() + getAlterInvalid().getAlteredCount());
	}
	public int getDeletedCount()  {
		return  (getAlterValid().getDeletedCount() + getAlterInvalid().getDeletedCount());
	}
	public boolean needsToBeDeleted()  {
		return  (getAlterValid().needsToBeDeleted()  ||  getAlterInvalid().needsToBeDeleted());
	}
	public int getAnalyzedCount()  {
		return  getCondition().getAnalyzedCount();
	}
	public boolean wasAnalyzed()  {
		return  getCondition().wasAnalyzed();
	}
	public boolean isDebugOn()  {
		return  getCondition().isDebugOn();
	}
 */

//other...END
	private static final String sERR_FOR_CND = "Error is for [AlterValueWhen].getCondition()";
	public static final void ciConditionNotRqdRuleType(AlterValueWhen<?,?> alterer, RuleType rqd_value, String alter_name, Object xtra_errInfo)  {
		XInfoAccumulator xia = XInfoAccumulator.getAddedOrNew(xtra_errInfo, sERR_FOR_CND);
		try  {
			ValidatorComposer.ciNotRequiredRuleType(alterer.getCondition(), rqd_value, alter_name, xia);
		}  catch(NullPointerException npx)  {
			throw  CrashIfObject.nullOrReturnCause(alterer, alter_name, xia, npx);
		}
	}
	public static final void ciConditionForbiddenRuleType(AlterValueWhen<?,?> alterer, RuleType rqd_value, String alter_name, Object xtra_errInfo)  {
		XInfoAccumulator xia = XInfoAccumulator.getAddedOrNew(xtra_errInfo, sERR_FOR_CND);
		try  {
			ValidatorComposer.ciForbiddenRuleType(alterer.getCondition(), rqd_value, alter_name, xia);
		}  catch(NullPointerException npx)  {
			throw  CrashIfObject.nullOrReturnCause(alterer, alter_name, xia, npx);
		}
	}
}
