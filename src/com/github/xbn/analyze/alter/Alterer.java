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
	import  com.github.xbn.analyze.Analyzer;
/**
	<p>{@code Alterer}s change something.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Alterer extends Analyzer  {
	/**
		<p>Reset all state but counts.</p>

		<p>Sets {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} and {@link #wasAltered() wasAltered}{@code ()} to {@code false}.</p>

		@see  #resetCounts()
		@see  #mayDelete()
		@see  #isExpired()
	 **/
	void resetState();

	/**
		<p>Reset all counts.</p>

		<p>Sets<ul>
			<li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()},</li>
			<li>{@link #getAlteredCount() getAlteredCount}{@code ()}, and</li>
			<li>{@link #getDeletedCount() getDeletedCount}{@code ()}</li>
		</ul>to zero.</p>
		@see  #resetState()
	 **/
	void resetCounts();
	/**
		<p>Was the thing actually altered <i>by this {@code Alterer}</i>?.</p>

		<p>If the alteration was made by this {@code Alterer}, then this function will return {@code true}. If ({@link #mayDelete() mayDelete}{@code ()} is {@code true} and) it needs to be deleted, then
		<br/> &nbsp; &nbsp; {@link #wasAltered() wasAltered}{@code ()}
		<br/>will be {@code false}, and
		<br/> &nbsp; &nbsp; {@link #needsToBeDeleted() needsToBeDeleted}{@code ()}
		<br/>will be {@code true}. Delete the element and then call {@link #resetForDeletion() resetForDeletion}{@code ()}.</p>

		@return <ul>
			<li><b>{@code true}:</b>  When the thing was altered by this {@code Alterer} class.</li>
			<li><b>{@code false}:</b> If {@code needsToBeDeleted()} is {@code true}, then it must be manually deleted. Otherwise, the value was not altered, and does not need to be (this case is only possible when there is a condition that must be met before the alteration can take place).</li>
			</ul></li>
		</ul>
	 **/
	boolean wasAltered();
	/**
		<p>Updates the necessary count after a manual deletion, and ends with a call to {@code resetState()}.  This needs to be called even if no further alterations/analyses are needed.</p>

		<p>Steps<ol>
			<li>If {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} is {@code true}, this<ol>
				<li>Increments {@link #getAlteredCount() getAlteredCount}{@code ()} and {@link #getDeletedCount() getDeletedCount}{@code ()}</li>
				<li>Sets {@code needsToBeDeleted()} to {@code false}.</li>
			</ol></li>
			<li>Calls {@link #resetState() resetState}{@code ()}</li>
		</ol></p>

		@see  #wasAltered()
	 **/
	void resetForDeletion();
	/**
		<p>When the thing-to-be-altered must be manually deleted.</p>

		@return  {@code false}  If {@link #mayDelete() mayDelete}{@code ()} is {@code false}.
		@see  #wasAltered()
	 **/
	boolean needsToBeDeleted();
	/**
		<p>Is it possible that the alteration may be a deletion?. This value must never change.</p>

		<p>This is useful when the length of a container must be known before its elements are altered, such as when creating arrays. When there is a possibility of deletion, elements must be altered and held in a temporary container before the array can be created. When {@code true}, the need for a temporary container is avoided.</p>

		@return  <ul>
			<li>{@code true}  It is possible for the alteration to be a {@link #needsToBeDeleted() deletion}.</li>
			<li>{@code false} When {@link #isExpired() isExpired}{@code ()} is {@code true}, or the alteration will never be a deletion.</li>
		</ul>
		@see  com.github.xbn.lang.Expirable#isExpired()
	 **/
	boolean mayDelete();
	/**
		<p>How many <i>things</i> were analyzed (regardless if altered)?.</p>

		@return  {@link #getAlteredCount() getAlteredCount}{@code ()}. <i>Sub-classes may require certain conditions to be met before an alteration is made. In this case, this will be greater-than-or-equal-to {@code getAlteredCount()}.</i>

		@see  #getDeletedCount()
		@see  #getAlteredCount()
	 **/
	int getAnalyzedCount();
	/**
		<p>How many things were deleted?.</p>

		@return  The number of <i>things</i> deleted since the last call {@link #resetCounts() resetCounts}{@code ()}. This is always less-than-or-equal-to {@link #getAlteredCount() getAlteredCount}{@code ()}.
		@see  #getAnalyzedCount()
	 **/
	int getDeletedCount();
	/**
		<p>How many things were actually altered?. This number includes the amount of {@link #getDeletedCount() deletions} made.</p>

		@see  #getAnalyzedCount()
		@see  #isComplete()
	 **/
	int getAlteredCount();
	/**
		<p>Is it required that this alterer actually makes an alteration?.</p>
	 **/
	boolean isRequired();
	/**
		<p>Was an alteration made (at any time in the past) and, if a multi-part alteration, did it finish?.</p>

		@return  If {@link #isRequired() isRequired}{@code ()} is {@code false}, this always returns {@code true}. Otherwise, at it's simplest, this can return
		<br/> &nbsp; &nbsp; <code>({@link #getAlteredCount() getAlteredCount}() != 0)</code>
		@see  #appendIncompleteInfo(StringBuilder)
	 **/
	boolean isComplete();
	/**
		<p>When a multi-step alteration did not finish, append the information about the incomplete steps.</p>

		<p>At it's simplest, this should just append the value of the alterer's {@code toString()}.</p>

		@param  to_appendTo  May not be {@code null}.
		@return  {@code to_appendTo}
		@exception  IllegalStateException  If {@link #isComplete() isComplete}{@code ()} is {@code true}.
	 **/
	StringBuilder appendIncompleteInfo(StringBuilder to_appendTo);
}
