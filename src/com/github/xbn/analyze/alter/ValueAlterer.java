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
   <p>An {@code Alterer} that changes a single object.</p>

{@.codelet.and.out com.github.xbn.examples.analyze.alter.ValueAltererXmpl%eliminateCommentBlocksAndPackageDecl()}

   @param  <V>  The type of object to validate (optional--usually the same as {@code A})
   @param  <A>  The type of object to alter (optionally, only when {@code V} is valid)
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface ValueAlterer<V,A> extends Alterer, Ruleable  {
   /**
      <p>Get the altered value. Each call to this function must be preceded by a call to {@link #resetState() resetState}{@code ()}.</p>

      <p>This<ol>
         <li>Sets {@link com.github.xbn.analyze.Analyzer#wasAnalyzed() wasAnalyzed}{@code ()}* to {@code true} and</li>
         <li>Increases {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() getAnalyzedCount}{@code ()}* by one.</li>
         <li>When {@code to_validate}<ol>
            <li>is ignored (not validated): This follows the same steps as if it were deemed valid.</li>
            <li>is deemed valid: If the alteration is to<ul>
               <li>delete the value (such as from the list in which it is an element): This<ol>
                  <li>Sets {@link com.github.xbn.analyze.alter.Alterer#needsToBeDeleted() needsToBeDeleted}{@code ()}* to {@code true}</li>
                  <li><i><b>Returns</b></i> {@code null}.</li>
               </ol></li>
               <li><i>not</i> delete the value: This<ol>
                  <li>Sets {@link com.github.xbn.analyze.alter.Alterer#wasAltered() wasAltered}{@code ()}* to {@code true},</li>
                  <li>Increases {@link com.github.xbn.analyze.alter.Alterer#getAlteredCount() getAlteredCount}{@code ()}* by one, and</li>
                  <li><i><b>Returns</b></i> the altered value.</li>
               </ol></li>
            </ul></li>
            <li>is deemed invalid: This <u><i>returns</i></u> {@code to_alter}, unchanged.</li>
         </ol></li>
      </ol></p>

      @param  to_validate  The value to optionally validate. In many cases this is the same object as {@code to_alter}. When no validation is done, this parameter is ignored.
      @param  to_alter  The value to alter, only when {@code to_validate} is deemed valid.
      @exception  IllegalStateException  If {@code wasAltered()} or {@code needsToBeDeleted()} are {@code true} (must call {@link com.github.xbn.analyze.alter.Alterer#resetState() resetState}{@code ()}* or {@link com.github.xbn.analyze.alter.Alterer#resetForDeletion() resetForDeletion}{@code ()}*).
    **/
   A getAltered(V to_validate, A to_alter);
//	String getAlteredString(V to_validate, A to_alter);
   ValueAlterer<V,A> getObjectCopy();
}
