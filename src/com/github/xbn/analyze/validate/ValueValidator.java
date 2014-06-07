package  com.github.xbn.analyze.validate;
/**
   <P>A {@code Validator} for a single object. At its simplest, the object may or may not be {@code null}.</P>

{@.codelet.and.out com.github.xbn.examples.analyze.validate.ValueValidatorXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}
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
