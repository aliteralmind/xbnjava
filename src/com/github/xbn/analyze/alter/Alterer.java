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
	<P>{@code Alterer}s change something.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Alterer extends Analyzer  {
	/**
		<P>Reset all state but counts.</P>

		<P>Sets {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} and {@link #wasAltered() wasAltered}{@code ()} to {@code false}.</P>

		@see  #resetCounts()
		@see  #mayDelete()
		@see  #isExpired()
	 **/
	void resetState();

	/**
		<P>Reset all counts.</P>

		<P>Sets<UL>
			<LI>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()},</LI>
			<LI>{@link #getAlteredCount() getAlteredCount}{@code ()}, and</LI>
			<LI>{@link #getDeletedCount() getDeletedCount}{@code ()}</LI>
		</UL>to zero.</P>
		@see  #resetState()
	 **/
	void resetCounts();
	/**
		<P>Was the thing actually altered <I>by this {@code Alterer}</I>?.</P>

		<P>If the alteration was made by this {@code Alterer}, then this function will return {@code true}. If ({@link #mayDelete() mayDelete}{@code ()} is {@code true} and) it needs to be deleted, then
		<BR> &nbsp; &nbsp; {@link #wasAltered() wasAltered}{@code ()}
		<BR>will be {@code false}, and
		<BR> &nbsp; &nbsp; {@link #needsToBeDeleted() needsToBeDeleted}{@code ()}
		<BR>will be {@code true}. Delete the element and then call {@link #resetForDeletion() resetForDeletion}{@code ()}.</P>

		@return <UL>
			<LI><B>{@code true}:</B>  When the thing was altered by this {@code Alterer} class.</LI>
			<LI><B>{@code false}:</B> If {@code needsToBeDeleted()} is {@code true}, then it must be manually deleted. Otherwise, the value was not altered, and does not need to be (this case is only possible when there is a condition that must be met before the alteration can take place).</LI>
			</UL></LI>
		</UL>
	 **/
	boolean wasAltered();
	/**
		<P>Updates the necessary count after a manual deletion, and ends with a call to {@code resetState()}.  This needs to be called even if no further alterations/analyses are needed.</P>

		<P>Steps<OL>
			<LI>If {@link #needsToBeDeleted() needsToBeDeleted}{@code ()} is {@code true}, this<OL>
				<LI>Increments {@link #getAlteredCount() getAlteredCount}{@code ()} and {@link #getDeletedCount() getDeletedCount}{@code ()}</LI>
				<LI>Sets {@code needsToBeDeleted()} to {@code false}.</LI>
			</OL></LI>
			<LI>Calls {@link #resetState() resetState}{@code ()}</LI>
		</OL></P>

		@see  #wasAltered()
	 **/
	void resetForDeletion();
	/**
		<P>When the thing-to-be-altered must be manually deleted.</P>

		@return  {@code false}  If {@link #mayDelete() mayDelete}{@code ()} is {@code false}.
		@see  #wasAltered()
	 **/
	boolean needsToBeDeleted();
	/**
		<P>Is it possible that the alteration may be a deletion?. This value must never change.</P>

		<P>This is useful when the length of a container must be known before its elements are altered, such as when creating arrays. When there is a possibility of deletion, elements must be altered and held in a temporary container before the array can be created. When {@code true}, the need for a temporary container is avoided.</P>

		@return  <UL>
			<LI>{@code true}  It is possible for the alteration to be a {@link #needsToBeDeleted() deletion}.</LI>
			<LI>{@code false} When {@link #isExpired() isExpired}{@code ()} is {@code true}, or the alteration will never be a deletion.</LI>
		</UL>
		@see  com.github.xbn.lang.Expirable#isExpired()
	 **/
	boolean mayDelete();
	/**
		<P>How many <I>things</I> were analyzed (regardless if altered)?.</P>

		@return  {@link #getAlteredCount() getAlteredCount}{@code ()}. <I>Sub-classes may require certain conditions to be met before an alteration is made. In this case, this will be greater-than-or-equal-to {@code getAlteredCount()}.</I>

		@see  #getDeletedCount()
		@see  #getAlteredCount()
	 **/
	int getAnalyzedCount();
	/**
		<P>How many things were deleted?.</P>

		@return  The number of <I>things</I> deleted since the last call {@link #resetCounts() resetCounts}{@code ()}. This is always less-than-or-equal-to {@link #getAlteredCount() getAlteredCount}{@code ()}.
		@see  #getAnalyzedCount()
	 **/
	int getDeletedCount();
	/**
		<P>How many things were actually altered?. This number includes the amount of {@link #getDeletedCount() deletions} made.</P>

		@see  #getAnalyzedCount()
		@see  #isComplete()
	 **/
	int getAlteredCount();
	/**
		<P>Is it required that this alterer actually makes an alteration?.</P>
	 **/
	boolean isRequired();
	/**
		<P>Was an alteration made (at any time in the past) and, if a multi-part alteration, did it finish?.</P>

		@return  If {@link #isRequired() isRequired}{@code ()} is {@code false}, this always returns {@code true}. Otherwise, at it's simplest, this can return
		<BR> &nbsp; &nbsp; <CODE>({@link #getAlteredCount() getAlteredCount}() != 0)</CODE>
		@see  #appendIncompleteInfo(StringBuilder)
	 **/
	boolean isComplete();
	/**
		<P>When a multi-step alteration did not finish, append the information about the incomplete steps.</P>

		<P>At it's simplest, this should just append the value of the alterer's {@code toString()}.</P>

		@param  to_appendTo  May not be {@code null}.
		@return  {@code to_appendTo}
		@exception  IllegalStateException  If {@link #isComplete() isComplete}{@code ()} is {@code true}.
	 **/
	StringBuilder appendIncompleteInfo(StringBuilder to_appendTo);
}
