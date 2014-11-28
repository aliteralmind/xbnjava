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
	import  com.github.xbn.lang.RuleType;
	import  com.github.xbn.array.CrashIfArray;
	import  com.github.xbn.array.NullElement;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.text.padchop.EscapeAction;
	import  com.github.xbn.text.padchop.NewVzblPadChopFor;
	import  com.github.xbn.text.padchop.VzblPadChop;
	import  java.lang.reflect.Array;
	import  java.util.ArrayList;
	import  java.util.List;
	import  java.util.Objects;
	import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For a series of alterers that potentially expire--once an alter-element is expired, it is removed from the list. When all items are removed, the list itself is expired. This is intended for use in high-iteration loops, where one or more alterations are made once, or a limited number of times. An example is making replacements to each line in a large text file, where only the first match should be replaced.</P>

{@.codelet.and.out com.github.xbn.examples.linefilter.alter.ExpirableTextLineAlterListXmpl%eliminateCommentBlocksAndPackageDecl()}

	@see  com.github.xbn.lang.Expirable#isExpired()
	@see  com.github.xbn.linefilter.alter.ExpirableTextLineAlterList
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class ExpirableAlterList<V,A> extends AbstractValueAlterer<V,A>  {
//state
	private final List<ValueAlterer<V,A>> alterList;
	private final boolean bShrtCrct;
//internal
	private static final VzblPadChop VPC_DBG = NewVzblPadChopFor.trimEscChopWithDDD(true, EscapeAction.ESCAPE, 50);

	/*
		<P>Create a new instance in which expirable elements are optional, and {@code null} elements are forbidden.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #ExpirableAlterList(ValueAlterer[], ExpirableElements, MultiAlterType) this}(xprbl_alterArray, {@link com.github.xbn.analyze.alter.ExpirableElements ExpirableElements}.{@link com.github.xbn.analyze.alter.ExpirableElements#OPTIONAL OPTIONAL}, multi_alterType)</CODE></P>
	public ExpirableAlterList(ValueAlterer<V,A>[] xprbl_alterArray, MultiAlterType multi_alterType)  {
		this(xprbl_alterArray, ExpirableElements.OPTIONAL, multi_alterType);
	}
	 */
	/**
		<P>Create a new instance.</P>

		@param  multi_alterType  May not be {@code null}. Get (the resulting boolean) with {@link com.github.xbn.analyze.alter.MultiAlterType#isShortCircuit() isShortCircuit}{@code ()}. If {@link com.github.xbn.analyze.alter.MultiAlterType#SHORT_CIRCUIT SHORT_CIRCUIT}, then only one element at a maximum may alter the value (the first element whose {@link com.github.xbn.analyze.alter.Alterer#wasAltered() wasAltered}{@code ()} is true, causes <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getAlteredPostResetCheck(V, A)">getAlteredPostResetCheck</A>(V,A)</CODE> to exit.) If {@link com.github.xbn.analyze.alter.MultiAlterType#CUMULATIVE CUMULATIVE}, then the value is altered by all elements in each call to {@code getAlteredPostResetCheck(V,A)}.
		@param  xprbl_lmntsAre  If {@code ExpirableElements.}{@code com.github.xbn.analyze.alter.ExpirableElements#REQUIRED REQUIRED}, then no element in {@code xprbl_alterArray} may be {@link com.github.xbn.lang.Expirable#isExpired() expired}.
		@param  xprbl_alterArray  May not be {@code null}, empty, or contain duplicates, and no element may be {@code null}. Each object in this array is {@link com.github.xbn.lang.Copyable#getObjectCopy() duplicated} internally.
		@exception  IllegalArgumentException  If {@code xprbl_lmntsAre.}{@link com.github.xbn.analyze.alter.ExpirableElements#isRequired() isRequired}{@code ()} is {@code true} and any element's {@link com.github.xbn.lang.Expirable#doesExpire() doesExpire}{@code ()} is {@code false}.
		@see  #ExpirableAlterList(ExpirableAlterList) this(xal)
	 **/
	public ExpirableAlterList(ValueAlterer<V,A>[] xprbl_alterArray, ExpirableElements xprbl_lmntsAre, MultiAlterType multi_alterType, Appendable debug_ifNonNull)  {
		super();
		if(multi_alterType == null)  {
			throw  new NullPointerException("multi_alterType");
		}
		bShrtCrct = multi_alterType.isShortCircuit();

		CrashIfArray.nullEmpty(xprbl_alterArray, "xprbl_alterArray");

		alterList = new ArrayList<ValueAlterer<V,A>>(xprbl_alterArray.length);
		for(int i = 0; i < xprbl_alterArray.length; i++)  {
			ValueAlterer<V,A> avo = xprbl_alterArray[i];
			try  {
				if(xprbl_lmntsAre.isRequired()  &&  !avo.doesExpire())  {
					throw  new IllegalArgumentException("xprbl_alterArray[" + i + "].doesExpire() is false, and xprbl_lmntsAre.isRequired() is true.");
				}
				if(avo.isExpired())  {
					throw  new IllegalArgumentException("xprbl_alterArray[" + i + "].issExpired() is true.");
				}
			}  catch(RuntimeException rx)  {
				Objects.requireNonNull(avo, "xprbl_alterArray[" + i + "]");
				throw  CrashIfObject.nullOrReturnCause(xprbl_lmntsAre, "xprbl_lmntsAre", null, rx);
			}
			if(alterList.contains(avo))  {
				throw  new IllegalArgumentException("Duplicate: xprbl_alterArray[" + i + "]: " + avo);
			}
			alterList.add(avo.getObjectCopy());  //Defensive copy
		}

		setDebug(debug_ifNonNull, (debug_ifNonNull != null));
	}
	/**
		<P>Create a new instance as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer(ValueAlterer) super}(to_copy)</LI>
			<LI>Duplicates the internal list of alters (including state and counts)</LI>
			<LI>Sets {@link #doShortCircuit() doShortCircuit}{@code ()} to {@code to_copy.doShortCircuit()}</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}
		@see  #ExpirableAlterList(ValueAlterer[], ExpirableElements, MultiAlterType, Appendable)
	 **/
	public ExpirableAlterList(ExpirableAlterList<V,A> to_copy)  {
		super(to_copy);
		alterList = new ArrayList<ValueAlterer<V,A>>(to_copy.alterList);
		bShrtCrct = to_copy.doShortCircuit();
	}
	/**
		<P>Should the object be altered, at most, by a single element, or should it be cumulatively altered by every element, every time?.</P>

		@return  <UL>
			<LI>{@code true}: At the most, only one element may alter the object in a single call to  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getAltered(V, A)">getAltered</A>(V,A)</CODE></LI>
			<LI>{@code false}: All elements alter the object, cumulatively, in each call to {@code getAltered(V,A)}.</LI>
		</UL>
		@see  MultiAlterType
	 **/
	public boolean doShortCircuit()  {
		return  bShrtCrct;
	}
	/**
		<P>The number of remaining--non-expired--alter-elements.</P>
	 **/
	public int size()  {
		return  alterList.size();
	}
	/**
		<P>Alter the object, and remove expired alter elements.</P>

		<P>For every alter-element, this calls
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="AbstractValueAlterer.html#getAltered(V, A)">getAltered</A>(to_validate, to_alter)</CODE></P>

		<P>When {@code to_alter} is altered by an element and {@link #doShortCircuit() doShortCircuit}{@code ()} is {@code true} (or that alteration is &quot;{@link com.github.xbn.analyze.alter.Alterer#needsToBeDeleted() needs to be deleted}&quot;), this function exits. Otherwise, the now-altered value of {@code to_alter} is passed to the next element to be further ({@link com.github.xbn.analyze.alter.MultiAlterType#CUMULATIVE cumulatively}) altered.</P>

		@see  <CODE><A HREF="AbstractValueAlterer.html">AbstractValueAlterer</A>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="AbstractValueAlterer.html#getAltered(V, A)">getAltered</A>(V,A)</CODE>
	 **/
	public A getAlteredPostResetCheck(V to_validate, A to_alter)  {
//		if(isDebugOn()) {
//			getDebugAptr().appentln("<XAL>    (" + size() + " elements, " +
//				(isExpired() ? "" : "un") + "expired) to_alter=[" +
//				VPC_DBG.get(to_alter) + "]");
//		}

		for(int i = 0; i < size(); i++)  {
			ValueAlterer<V,A> avo = alterList.get(i);
			if(avo.isExpired())  {
				alterList.remove(i--);
				continue;
			}

			try  {
				to_alter = avo.getAltered(to_validate, to_alter);
			}  catch(RuntimeException rx)  {
				throw  new RuntimeException("Attempting [element " + i + "].getAltered(to_validate, to_alter)." + LINE_SEP +
					" - Element " + i + "=" + avo + LINE_SEP +
					" - to_validate=[" + to_validate + "]" + LINE_SEP +
					" - to_alter=[" + to_alter + "]", rx);
			}

			if(avo.wasAltered())  {
				if(isDebugOn()) { getDebugAptr().appentln("<XAL>    Altered by element " + i + ": to_alter=[" + VPC_DBG.get(to_alter) + "]"); }

				declareAltered(Altered.YES, NeedsToBeDeleted.NO);

			}  else if(avo.needsToBeDeleted())  {
				if(isDebugOn()) { getDebugAptr().appentln("<XAL>    Altered by element " + i + ": to_alter=[" + VPC_DBG.get(to_alter) + "]"); }

				declareAltered(Altered.NO, NeedsToBeDeleted.YES);
			}

			if(avo.isExpired())  {
				alterList.remove(i--);
				if(isDebugOn()) { getDebugAptr().appentln("<XAL>    Element " + (i + 1) + " expired. " + alterList.size() + " remain"); }
			}

			if((wasAltered()  &&  doShortCircuit())  ||  needsToBeDeleted())  {
//				if(isDebugOn()) { getDebugAptr().appentln("<XAL>    EXITING because either doShortCircuit() (currently " + doShortCircuit() + ") or needsToBeDeleted() (currently " + needsToBeDeleted() + ") is true."); }
				break;
			}
		}

		if(isExpired()  &&  isDebugOn()) { getDebugAptr().appentln("<XAL>    EXPIRED"); }

		return  to_alter;
	}
	public void crashIfIncomplete(String msgPrefix_ifNonNull)  {
		if(!isComplete())  {
			throw  new AlterationNotMadeException(
				((msgPrefix_ifNonNull == null) ? "" : msgPrefix_ifNonNull + ": ") +
				appendIncompleteInfo((new StringBuilder())).toString());
		}
	}
	/**
		<P>Did any alterer not make an alteration?. This is intended for use after all alterations are attempted.</P>

		@return  {@code false} If at least one {@linkplain Alterer#isRequired() required} element's {@linkplain com.github.xbn.analyze.alter.Alterer#getAlteredCount() alteration count} is zero.
	 **/
	public boolean isComplete()  {
		for(ValueAlterer<V,A> alterer : alterList)  {
			if(alterer.isRequired()  &&  alterer.getAlteredCount() == 0)  {
				return  false;
			}
		}
		return  true;
	}
	/**
		<P>Append the {@code toString()}s of all elements that made no alteration.</P>
	 **/
	public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
		if(isComplete())  {
			throw  new IllegalStateException("isComplete() is true.");
		}

		to_appendTo.append("Alterations attempted but not made:").append(LINE_SEP);
		for(ValueAlterer<V,A> alterer : alterList)  {
			if(alterer.getAlteredCount() == 0)  {
				to_appendTo.append(" -").
					append(alterer.isRequired() ? "" : "[optional]-").
					append(" ");
				alterer.appendToString(to_appendTo);
				to_appendTo.append(LINE_SEP);
			}
		}
		to_appendTo.delete((to_appendTo.length() - LINE_SEP.length()),
			to_appendTo.length());
		return  to_appendTo;
	}
	/**
		@return  {@code true}
	 **/
	public boolean doesExpire()  {
		return  true;
	}
	/**
		@return  <CODE>({@link #size() size}() == 0)</CODE>
	 **/
	public boolean isExpired()  {
		return  (size() == 0);
	}
	/**
		@return  <CODE>(new {@link #ExpirableAlterList(ExpirableAlterList) ExpirableAlterList}&lt;V,A&gt;(this))</CODE>
	 **/
	public ExpirableAlterList<V,A> getObjectCopy()  {
		return  (new ExpirableAlterList<V,A>(this));
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		super.appendToString(to_appendTo).append("Unexpired alterers:").append(LINE_SEP);
		for(ValueAlterer<V,A> av : alterList)  {
			if(av.isExpired())  {
				continue;
			}
			to_appendTo.append(av).append(LINE_SEP);
		}
		return  to_appendTo;
	}
	/**
		<P>Reset state in preparation for the next alteration.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.alter.AbstractValueAlterer super}.{@link com.github.xbn.analyze.alter.AbstractValueAlterer#resetState() resetState}()</CODE></LI>
			<LI>For every element: {@link com.github.xbn.analyze.alter.Alterer#resetState() resetState}{@code ()}</LI>
		</OL></P>
	 **/
	public void resetState()  {
		super.resetState();
		for(ValueAlterer<V,A> av : alterList)  {
			av.resetState();
		}
	}
	/**
		<P>Reset alter counts to zero.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.alter.AbstractValueAlterer super}.{@link com.github.xbn.analyze.alter.AbstractValueAlterer#resetCounts() resetCounts}()</CODE></LI>
			<LI>For every element: {@link com.github.xbn.analyze.alter.Alterer#resetCounts() resetCounts}{@code ()}</LI>
		</OL></P>
	 **/
	public void resetCounts()  {
		super.resetCounts();
		for(ValueAlterer<V,A> av : alterList)  {
			av.resetCounts();
		}
	}
	/**
		<P>Reset state after a deletion is made.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.alter.AbstractValueAlterer super}.{@link com.github.xbn.analyze.alter.AbstractValueAlterer#resetForDeletion() resetForDeletion}()</CODE></LI>
			<LI>For every element: {@link com.github.xbn.analyze.alter.Alterer#resetForDeletion() resetForDeletion}{@code ()}</LI>
		</OL></P>
	 **/
	public void resetForDeletion()  {
		super.resetForDeletion();
		for(ValueAlterer<V,A> av : alterList)  {
			av.resetForDeletion();
		}
	}
	/**
		<P>Set overall debugging. This does not turn debugging on in any alter-element.</P>

		<P>This calls<OL>
			<LI>{@link com.github.xbn.io.SimpleDebuggable#setDebug(Appendable, boolean) setDebug}{@code (destination, is_on)}</LI>
		</OL></P>
	 **/
	public void setDebug(Appendable destination, boolean is_on)  {
		super.setDebug(destination, is_on);
	}
	/**
		<P>Set extra error information.</P>

		<P>This calls<OL>
			<LI>{@link com.github.xbn.analyze.alter.AbstractValueAlterer#setExtraErrInfo(Object) setExtraErrInfo}{@code (info)}</LI>
			<LI>For every element: {@link com.github.xbn.lang.ExtraErrInfoable#setExtraErrInfo(Object) setExtraErrInfo}{@code (info)}</LI>
		</OL></P>
	 **/
	public void setExtraErrInfo(Object info)  {
		super.setExtraErrInfo(info);
		for(ValueAlterer<V,A> av : alterList)  {
			av.setExtraErrInfo(info);
		}
	}
	/**
		<P>Get a new alterer array from the provided <I>ordered</I> elements, optionally excluding {@code null} elements.</P>

		@param  orderedAlterers_whichMayBeNull  May not be {@code null} and <I>should</I> not be empty or contain duplicates.
		@param  null_element  May not be {@code null}. If {@link com.github.xbn.array.NullElement#OK OK}, {@code null} elements are excluded from the returned array. If {@link com.github.xbn.array.NullElement#BAD BAD}, all elements must be non-{@code null}.
		@param  class_ofTypeL  May not be {@code null}.
		@param  alterers_varName  Descriptive name of {@code orderedAlterers_whichMayBeNull}. <I>Should</I> not be {@code null} or empty.
		@return  A new non-{@code null} array of line-alterers containing all non-{@code null} parameters, if any.
		@exception  NullPointerException  If {@code null_element.isBad()} and an element is null.
	 **/
	public static final <V,A,L extends ValueAlterer<V,A>> L[] getAltererArrayFromOrderedElementsIfNonNull(L[] orderedAlterers_whichMayBeNull, NullElement null_element, Class<L> class_ofTypeL, String alterers_varName)  {

		List<L> alterList = null;
		try  {
			alterList = new ArrayList<L>(orderedAlterers_whichMayBeNull.length);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(orderedAlterers_whichMayBeNull, "orderedAlterers_whichMayBeNull", null, rx);
		}

		for(int i = 0; i < orderedAlterers_whichMayBeNull.length; i++)  {
			L alterer = orderedAlterers_whichMayBeNull[i];
			if(alterer != null)  {
				alterList.add(alterer);
			}  else  {
				try  {
					if(null_element.isBad())  {
						throw  new NullPointerException("Element " + i + " in " + alterers_varName + ".");
					}
				}  catch(RuntimeException rx)  {
					throw  CrashIfObject.nullOrReturnCause(null_element, "null_element", null, rx);
				}
			}
		}
		try  {
			@SuppressWarnings("unchecked")
			L[] alterers = (L[])Array.newInstance(class_ofTypeL, alterList.size());
			return  alterList.toArray(alterers);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(class_ofTypeL, "class_ofTypeL", null, rx);
		}
	}
	public RuleType getRuleType()  {
		if(isExpired())  {
			return  RuleType.UNRESTRICTED;
		}

		int impossibleCount = 0;
		boolean atLeast1IsRestricted = false;
		for(ValueAlterer<V,A> alterer : alterList)  {
			RuleType type = alterer.getRuleType();
			if(type.isRestricted())  {
				atLeast1IsRestricted = true;

			}  else if(type.isImpossible())  {
				impossibleCount++;
			}
		}

		if(impossibleCount == alterList.size())  {
			return  RuleType.IMPOSSIBLE;
		}

		return  (atLeast1IsRestricted
			?  RuleType.RESTRICTED
			:  RuleType.UNRESTRICTED);
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
			to_appendTo.append(LINE_SEP);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}

		int sizeMinus1 = alterList.size() - 1;
		for(int i = 0; i < alterList.size(); i++)  {
			to_appendTo.append(" -" + i + "- ");
			alterList.get(i).appendRules(to_appendTo);
			if(i < sizeMinus1)  {
				to_appendTo.append(LINE_SEP);
			}
		}
		return  to_appendTo;
	}
}