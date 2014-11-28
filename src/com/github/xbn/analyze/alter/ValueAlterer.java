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
	import  com.github.xbn.lang.Ruleable;
/**
	<P>An {@code Alterer} that changes a single object.</P>

{@.codelet.and.out com.github.xbn.examples.analyze.alter.ValueAltererXmpl%eliminateCommentBlocksAndPackageDecl()}

	@param  <V>  The type of object to validate (optional--usually the same as {@code A})
	@param  <A>  The type of object to alter (optionally, only when {@code V} is valid)
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface ValueAlterer<V,A> extends Alterer, Ruleable  {
	/**
		<P>Get the altered value. Each call to this function must be preceded by a call to {@link #resetState() resetState}{@code ()}.</P>

		<P>This<OL>
			<LI>Sets {@link com.github.xbn.analyze.Analyzer#wasAnalyzed() wasAnalyzed}{@code ()}* to {@code true} and</LI>
			<LI>Increases {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() getAnalyzedCount}{@code ()}* by one.</LI>
			<LI>When {@code to_validate}<OL>
				<LI>is ignored (not validated): This follows the same steps as if it were deemed valid.</LI>
				<LI>is deemed valid: If the alteration is to<UL>
					<LI>delete the value (such as from the list in which it is an element): This<OL>
						<LI>Sets {@link com.github.xbn.analyze.alter.Alterer#needsToBeDeleted() needsToBeDeleted}{@code ()}* to {@code true}</LI>
						<LI><I><B>Returns</B></I> {@code null}.</LI>
					</OL></LI>
					<LI><I>not</I> delete the value: This<OL>
						<LI>Sets {@link com.github.xbn.analyze.alter.Alterer#wasAltered() wasAltered}{@code ()}* to {@code true},</LI>
						<LI>Increases {@link com.github.xbn.analyze.alter.Alterer#getAlteredCount() getAlteredCount}{@code ()}* by one, and</LI>
						<LI><I><B>Returns</B></I> the altered value.</LI>
					</OL></LI>
				</UL></LI>
				<LI>is deemed invalid: This <U><I>returns</I></U> {@code to_alter}, unchanged.</LI>
			</OL></LI>
		</OL></P>

		@param  to_validate  The value to optionally validate. In many cases this is the same object as {@code to_alter}. When no validation is done, this parameter is ignored.
		@param  to_alter  The value to alter, only when {@code to_validate} is deemed valid.
		@exception  IllegalStateException  If {@code wasAltered()} or {@code needsToBeDeleted()} are {@code true} (must call {@link com.github.xbn.analyze.alter.Alterer#resetState() resetState}{@code ()}* or {@link com.github.xbn.analyze.alter.Alterer#resetForDeletion() resetForDeletion}{@code ()}*).
	 **/
	A getAltered(V to_validate, A to_alter);
//	String getAlteredString(V to_validate, A to_alter);
	ValueAlterer<V,A> getObjectCopy();
}
