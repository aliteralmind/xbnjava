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
package  com.github.xbn.analyze.validate;
/**
   <P>A {@code Validator} for a single object. At its simplest, the object may or may not be {@code null}.</P>

{@.codelet.and.out com.github.xbn.examples.analyze.validate.ValueValidatorXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public interface ValueValidator<O> extends Validator  {
   /**
      <P>Validation configuration: Is it acceptable for the value to be {@code null}?.</P>

      @return  {@code true}  If {@code null} is acceptable (pre-{@link com.github.xbn.analyze.validate.Validator#doInvertRules() inversion}).
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#isValid(O)">isValid</A>(O)</CODE>
    **/
   boolean isNullOk();
   /**
      <P>Is the object acceptable?.</P>

      @param  to_validate  The value to test.
      @return  {@code true}: This validator is not {@link com.github.xbn.lang.Expirable#isExpired() expired}, the rules are followed (considering {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inversion}), and the {@link ValidResultFilterable#getFilter() filter} has not altered or suppresed that decision.
      @see  #isNullOk()
      @see   <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#crashIfBadValue(O, java.lang.String)">crashIfBadValue</A>(O,s)</CODE>
      @exception  IllegalStateException  If {@link com.github.xbn.analyze.Analyzer#wasAnalyzed() wasAnalyzed}{@code ()} is true (must call {@link com.github.xbn.analyze.validate.Validator#resetState() resetState}{@code ()}*).
    **/
   boolean isValid(O to_validate);

   /**
      <P>If the value is invalid, crash.</P>

      @param  to_validate  The value to validate.
      @param  vaunmixed_numeratorame  Descriptive name of {@code to_validate}. <I>Should</I> not be {@code null} or empty.
      @exception  IllegalArgumentException  If <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#isValid(O)">isValid</A>(to_validate)</CODE> is {@code false}.
    **/
   void crashIfBadValue(O to_validate, String vaunmixed_numeratorame);
   @Override
   ValueValidator<O> getObjectCopy();
}
