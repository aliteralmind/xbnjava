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
   <p>A {@code ValueAlterer} that does one of two things: One action when a condition is met, and another when it is not. Internally this is two {@code ValueAlterer}-s and an <code>xbn.analyze.validate.{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator}</code>, the latter of which is the &quot;alter condition&quot;. If
   <br/> &nbsp; &nbsp; {@link #getCondition() getCondition}{@code ().isValid(V)}
   <br/>is {@code true}, then {@code A} is altered by the {@link #getAlterValid() valid alterer}. Otherwise, it is altered by the {@link #getAlterInvalid() invalid alterer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
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
      <p>Create a new {@code AlterValueWhen} that makes no alterations.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(
      <br/> &nbsp; &nbsp; (ValueValidator&lt;V&gt;)NewValueValidatorFor.unrestricted(null, null),
      <br/> &nbsp; &nbsp; (new ReturnValueUnchanged&lt;V,A&gt;()), (new ReturnValueUnchanged&lt;V,A&gt;()))</code></p>
    */
   public AlterValueWhen()  {
      this(
         NewValueValidatorFor.<V>unrestricted(null, null),
         (new ReturnValueUnchanged<V,A>()), (new ReturnValueUnchanged<V,A>()));
   }
   /**
      <p>Create a new {@code AlterValueWhen}.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(
      <br/> &nbsp; &nbsp; (ValueValidator&lt;V&gt;)new NewValueValidatorFor.unrestricted(null, null),
      <br/> &nbsp; &nbsp; alter_forValid, (new {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#ReturnValueUnchanged() ReturnValueUnchanged}&lt;A&gt;()))</code></p>
    */
   public AlterValueWhen(ValueAlterer<V,A> alter_forValid)  {
      this(
         NewValueValidatorFor.<V>unrestricted(null, null),
         alter_forValid, (new ReturnValueUnchanged<V,A>()));
   }
   /**
      <p>Create a new {@code AlterValueWhen} that does nothing.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this}(condition, alter_forValid, (new ReturnValueUnchanged<V,A>()))</code></p>
    */
   public AlterValueWhen(ValueValidator<V> condition, ValueAlterer<V,A> alter_forValid)  {
      this(condition, alter_forValid, (new ReturnValueUnchanged<V,A>()));
   }
   /**
      <p>Create a new {@code AlterValueWhen}.</p>

      <p>This calls {@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer() super}{@code ()}, and resets {@link #zresetStateAVW() state} and {@link #zresetCountsAVW() counts}</li>
      </ol></p>

      <p><i>All parameters must be non-{@code null}. They are also all duplicated internally (defensively copied).</i></p>

    * @param  condition  Get with {@link #getCondition() getCondition}{@code ()}.
    * @param  alter_forValid  Get with {@link #getAlterValid() getAlterValid}{@code ()}.
    * @param  alter_forInvalid  Get with {@link #getAlterInvalid() getAlterInvalid}{@code ()}. When attempting to  <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getAltered(V, A)">make the alteration</a> and the condition is not met, {@code alter_forInvalid} makes the actual alteration, and therefore determines the value of <i>{@code this}</i> classes {@link com.github.xbn.analyze.alter.Alterer#wasAltered() wasAltered}{@code ()} flag. Therefore, when an alteration is not wanted when the condition is not met, <code>alter_forInvalid.{@link com.github.xbn.lang.Expirable#isExpired() isExpired}()</code> should be {@code true} (in most cases, expired alterers will return the original value unchanged).
    * @see  #AlterValueWhen() this()
    * @see  #AlterValueWhen(ValueValidator, ValueAlterer) this(vv,av)
    * @see  #AlterValueWhen(AlterValueWhen) this(avw)
    */
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
      <p>Create a new {@code AlterValueWhen} as a duplicate of another.</p>

      <p>This calls<ol>
         <li>{@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer(ValueAlterer) super}{@code (to_copy)}</li>
         <li>{@link #zresetStateAVW() zresetStateAVW}{@code ()}</li>
      </ol></p>
    * @see  #getObjectCopy()
    * @see  #AlterValueWhen(ValueValidator, ValueAlterer, ValueAlterer) this(vv,av,av,b)
    */
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
      <p>Reset non-count state.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link #zresetStateAVW() zresetStateAVW}{@code ()}</p>

    * @see  #resetCounts()
    */
   public void resetState()  {
      super.resetState();
      zresetStateAVW();
   }
   /**
      <p>Reset non-count state specific to this {@code AlterValueWhen}.</p>

      <p>This calls<ol>
         <li>{@link #getCondition() getCondition}{@code ().}{@link #resetState() resetState}{@code ()}</li>
         <li>{@link #getAlterValid() getAlterValid}{@code ().resetState()}</li>
         <li>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetState()}</li>
      </ol></p>
    */
   protected final void zresetStateAVW()  {
      getCondition().resetState();
      getAlterValid().resetState();
      getAlterInvalid().resetState();
   }
   /**
      <p>Reset counters to zero.</p>

      <p>This calls<ol>
         <li>{@link #zresetCountsAVW() zresetCountsAVW}{@code ()}</li>
      </ol></p>
    * @see  #resetState()
    */
   public void resetCounts()  {
      super.resetCounts();
      zresetCountsAVW();
   }
   /**
      <p>Reset counters to zero specific to this {@code AlterValueWhen}.</p>

      <p>This calls<ol>
         <li>{@link #getCondition() getCondition}{@code ().}{@link #resetCounts() resetCounts}{@code ()}</li>
         <li>{@link #getAlterValid() getAlterValid}{@code ().resetCounts()}</li>
         <li>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetCounts()}</li>
      </ol></p>
    * @see  #resetCounts()
    */
   protected final void zresetCountsAVW()  {
      getCondition().resetCounts();
      getAlterValid().resetCounts();
      getAlterValid().resetCounts();
   }
   /**
      <p>Updates internal state after a manual deletion.</p>

      <p>This calls<ol>
         <li>{@link #getCondition() getCondition}{@code ().}{@link com.github.xbn.analyze.validate.ValidatorComposer#resetState() resetState}{@code ()}</li>
         <li>{@link #getAlterValid() getAlterValid}{@code ().resetForDeletion()}</li>
         <li>{@link #getAlterInvalid() getAlterInvalid}{@code ().resetForDeletion()}</li>
      </ol></p>
    */
   public void resetForDeletion()  {
      getCondition().resetState();
      getAlterValid().resetForDeletion();
      getAlterInvalid().resetForDeletion();
   }
//getters...START
   /**
      <p>The alterer used when the condition is met.</p>
    */
   public ValueAlterer<V,A> getAlterValid()  {
      return  avValid;
   }
   /**
      <p>The alterer used when the condition is not met.</p>
    */
   public ValueAlterer<V,A> getAlterInvalid()  {
      return  avInvalid;
   }
   /**
      <p>The alter-condition.</p>
    */
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
    * @return  <code>{@link #appendRules(StringBuilder) appendRules}(new StringBuilder()).toString()</code>
    */
   public String getRules()  {
      return  appendRules(new StringBuilder()).toString();
   }
   /**
    * @param  to_appendTo May not be {@code null}.
    * @see  #getRules()
    */
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
      <p>Get the altered value, based on the configuration throughout this class.</p>

    * @param  to_validate  The object to validate.
    * @param  to_alter  The object to alter.
    */
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
      <p>Turn debugging on or off.</p>

      <p>This calls<ol>
         <li>{@link #getCondition() getCondition}{@code ().setDebugOn(is_on)}</li>
         <li>{@link #getAlterValid() getAlterValid}{@code ().setDebugOn(is_on)}</li>
         <li>{@link #getAlterInvalid() getAlterInvalid}{@code ().setDebugOn(is_on)}</li>
      </ol></p>
    */
   public void setDebugOn(boolean is_on)  {
      super.setDebugOn(is_on);
      getCondition().setDebugOn(is_on);
      getAlterValid().setDebugOn(is_on);
      getAlterInvalid().setDebugOn(is_on);
   }
   /**
      <p>Set the debug-writer.</p>

      <p>This calls<ol>
         <li>{@link #getCondition() getCondition}{@code ().setDebug(destination)}</li>
         <li>{@link #getAlterValid() getAlterValid}{@code ().setDebug(destination)}</li>
         <li>{@link #getAlterInvalid() getAlterInvalid}{@code ().setDebug(destination)}</li>
      </ol></p>
    * @see  #setDebugOn(boolean) setDebugOn(b)
    */
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
    * <p>Get a duplicate of this object.</p>
    * @return  <code>(new {@link #AlterValueWhen(AlterValueWhen) AlterValueWhen}&lt;V,A&gt;(this))</code>
    */
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
