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
	import  com.github.xbn.lang.CrashIfObject;
	import  static com.github.xbn.lang.CrashIfBase.*;
	import  com.github.xbn.analyze.Analyzer;
	import  com.github.xbn.analyze.AnalyzerComposer;
/**
	<p>For classes needing to implement {@code Alterer}, that cannot extend {@code AbstractAlterer}. See {@link com.github.xbn.analyze.alter.AbstractAlterer AbstractAlterer}.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class AltererComposer extends AnalyzerComposer  {
	private final boolean isRequired;
	private int     iLtrd  ;  //Altered count (includes deletions)
	private int     iDltd  ;  //Deleted count
	private boolean bNtbDel;
	private boolean bWLtrd ;
	private boolean bDnDl  ;
//internal
//constructor...START
	/**
		<p>Create a new instance that is required to make an alteration.</p>
	 **/
	public AltererComposer()  {
		this(AlterationRequired.YES);
	}
	/**
		<p>Create a new instance with the required setting.</p>

		<p>This calls<ol>
			<li>{@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer() super}{@code ()}</li>
			<li>{@link #zresetStateAC() zresetStateAC}{@code ()}</li>
			<li>{@link #zresetCountsAC() zresetCountsAC}{@code ()}</li>
		</ol></p>

		@see  #AltererComposer(boolean, AltererComposer) this(b,ab)
		@see  #AltererComposer(Alterer) this(ltr)
	 **/
	public AltererComposer(AlterationRequired required)  {
		try  {
			isRequired = required.isYes();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(required, "required", null, rx);
		}
		//Never ever call interface functions, directly or indirectly, in a constructor.
		zresetStateAC();
		zresetCountsAC();
	}
	/**
		<p>Create a new {@code AltererComposer} as a duplicate of another.</p>

		<p>This<ol>
			<li>Calls {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(boolean, AnalyzerComposer) super}{@code (ignored, to_copy)}</li>
			<li>Sets<ol>
				<li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</li>
				<li>{@link #getAlteredCount() getAlteredCount}{@code ()} to {@code to_copy.getAlteredCount()}</li>
				<li>{@link #getDeletedCount() getDeletedCount}{@code ()} to {@code to_copy.getDeletedCount()}</li>
			</ol></li>
			<li>Calls {@link #zresetStateAC() zresetStateAC}{@code ()} &nbsp; &nbsp; <i>(as specified by  <code><i>[{@link com.github.xbn.analyze.Analyzer Analyzer}]</i>.{@link com.github.xbn.analyze.Analyzer#getObjectCopy() getObjectCopy}()</code>)</i></li>
		</ol></p>
		@param  to_copy  May not be {@code null}
		@see  #getObjectCopy()
		@see  #AltererComposer() this()
	 **/
	public AltererComposer(boolean ignored, AltererComposer to_copy)  {
		super(ignored, to_copy);
		isRequired = to_copy.isRequired();
		iLtrd = to_copy.getAlteredCount();
		iDltd = to_copy.getDeletedCount();
		zresetStateAC();
	}
	/**
		<p>Create a new {@code AltererComposer} from an {@code Alterer}.</p>

		<p>This<ol>
			<li>Calls {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(Analyzer) super}{@code (to_copy)}</li>
			<li>Sets<ol>
				<li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</li>
				<li>{@link #getAlteredCount() getAlteredCount}{@code ()} to {@code to_copy.getAlteredCount()}</li>
				<li>{@link #getDeletedCount() getDeletedCount}{@code ()} to {@code to_copy.getDeletedCount()}</li>
			</ol></li>
			<li>Calls {@link #zresetStateAC() zresetStateAC}{@code ()} &nbsp; &nbsp; <i>(as specified by  <code><i>[{@link com.github.xbn.analyze.Analyzer Analyzer}]</i>.{@link com.github.xbn.analyze.Analyzer#getObjectCopy() getObjectCopy}()</code>)</i></li>
		</ol></p>
		@param  to_copy  May not be {@code null}
		@see  #AltererComposer() this()
	 **/
	public AltererComposer(Alterer to_copy)  {
		super(to_copy);
		isRequired = to_copy.isRequired();
		iLtrd = to_copy.getAlteredCount();
		iDltd = to_copy.getDeletedCount();
		zresetStateAC();
	}
//constructor...END
//setters...START
	/**
		<p>Reset non-count state.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link #zresetStateAC() zresetStateAC}{@code ()}</p>
	 **/
	public void resetState()  {
		super.resetState();
		zresetStateAC();
	}
	/**
		<p>Reset non-count state specific to this {@code AltererComposer}.</p>

		<p>This sets<ul>
			<li>{@link #wasAltered() wasAltered}{@code ()},</li>
			<li>{@link #needsToBeDeleted() needsToBeDeleted}{@code ()}</li>
		</ul>to {@code false}</p>
	 **/
	protected final void zresetStateAC()  {
		bWLtrd = false;
		bNtbDel = false;
	}
	/**
		<p>Reset counters to zero.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link #zresetCountsAC() zresetCountsAC}{@code ()}</p>
	 **/
	public void resetCounts()  {
		super.resetCounts();
		zresetCountsAC();
	}
	/**
		<p>Reset counters specific to this {@code AltererComposer}.</p>

		<p>Sets<ul>
			<li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()},</li>
			<li>{@link #getAlteredCount() getAlteredCount}{@code ()}, and</li>
			<li>{@link #getDeletedCount() getDeletedCount}{@code ()}</li>
		</ul>to zero.</p>
	 **/
	protected final void zresetCountsAC()  {
		iLtrd = 0;
		iDltd = 0;
	}
	public boolean isRequired()  {
		return  isRequired;
	}
	public void declareMayDelete_4prot(boolean may_del)  {
		bDnDl = may_del;
	}
	/**
		<p>YYY</p>
		<p>This<ol>
			<li>Calls  <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer super}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#declareAnalyzed_4prot() declareAnalyzed_4prot}()</code></li>
			<li>Sets {@link #wasAltered() wasAltered}{@code ()} to {@code false}</li>
			<li>Sets {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} to {@code true}</li>
		</ol></p>
	 **/
	public void declareAltered_4prot(Altered altered, NeedsToBeDeleted deleted)  {
		try  {
			if(altered.isYes())  {
				if(deleted.isYes())  {
					throw  new IllegalStateException(getXMsg("altered and deleted are both YES.", getExtraErrInfo()));
				}

				bWLtrd = true;
				bNtbDel = false;
				iLtrd++;

			}  else if(deleted.isYes())  {
				if(mayDelete())  {
					throw  new IllegalArgumentException("deleted.YES, mayDelete()=true.");
				}
				bWLtrd = false;
				bNtbDel = true;
			}
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(altered, "altered", null);
			throw  CrashIfObject.nullOrReturnCause(deleted, "deleted", null, rx);
		}

		declareAnalyzed_4prot();
	}
//setters...END
//getters...START
	public boolean wasAltered()  {
		return  bWLtrd;
	}
	/**
		@return  {@code true}  If it is possible that an alteration may {@link #needsToBeDeleted() delete the element}.
		@see  #declareMayDelete_4prot(boolean)
	 **/
	public boolean mayDelete()  {
		return  bDnDl;
	}
	public int getAlteredCount()  {
		return  iLtrd;
	}
	public int getDeletedCount()  {
		return  iDltd;
	}
	public boolean needsToBeDeleted()  {
		return  bNtbDel;
	}
	public void declareExpired_4prot()  {
		super.declareExpired_4prot();
		bDnDl = true;
	}
	/**
		@return  <code>(({@link #getAlteredCount() getAlteredCount}() != 0))</code>
	 **/
	public boolean isComplete()  {
		return  (getAlteredCount() != 0);
	}
	/**
		@return  <code>{@link #appendToString(StringBuilder) appendToString}(to_appendTo)</code>
	 **/
	public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
		if(isComplete())  {
			throw  new IllegalStateException("isComplete() is true.");
		}
		return  appendToString(to_appendTo);
	}
//getters...END
//main functionality...START
	public void resetForDeletion()  {
		if(needsToBeDeleted())  {
			iLtrd++;
			iDltd++;
		}
		resetState();
	}
//main functionality...END
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		super.appendToString(to_appendTo).append(", ").
			append(mayDelete() ? "may-delete" : "does-not-delete").append(", ");

		if(!wasAltered())  {
			to_appendTo.append("not-altered");
		}  else  {
			to_appendTo.append("altered");
			if(needsToBeDeleted())  {
				to_appendTo.append(" (needsToBeDeleted()=true)");
			}
		}

		if(!isRequired())  {
			to_appendTo.append("optional, ");
		}

		to_appendTo.append(", totals:[altered=").append(getAlteredCount()).
			append(", deleted=").append(getDeletedCount()).append("]");
		return  to_appendTo;
	}
	/**
		<p><i>Do not use--override if a copy is needed.</i></p>

		@exception  UnsupportedOperationException
	 **/
	public AltererComposer getObjectCopy()  {
		throw  new UnsupportedOperationException("getObjectCopy");
	}
}
