package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.lang.ExtraErrInfoable;
   import  com.github.xbn.analyze.Analyzer;
      import  com.github.xbn.lang.Ruleable;

/**
   <P>Validates <I>something</I> against a set of rules.</P>
 **/
public interface Validator extends Analyzer, Ruleable, ExtraErrInfoable, ValidResultFilterable  {
   /**
      <P>Reset in preparation for the next validation.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link com.github.xbn.analyze.Analyzer super}.{@link com.github.xbn.analyze.Analyzer#resetState() resetState}()</CODE></LI>
         <LI>Sets {@link #isValid() wasValid}{@code ()} to {@code false}</LI>
      </OL></P>

      @see  #resetCounts()
    **/
   void resetState();

   /**
      <P>Reset all counters to zero.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link com.github.xbn.analyze.Analyzer super}.{@link com.github.xbn.analyze.Analyzer#resetCounts() resetCounts}()</CODE></LI>
         <LI>Sets {@link #getValidCount() getValidCount}{@code ()} to zero</LI>
      </OL></P>

      @see  #resetState()
    **/
   void resetCounts();

   /**
      <P>How many times was the <I>something</I> deemed acceptable?.</P>

      @see  #resetCounts()
      @see  com.github.xbn.analyze.Analyzer#getAnalyzedCount() Analyzer#getAnalyzedCount()
    **/
   int getValidCount();

   /**
      <P>Was the just analyzed <I>something</I> acceptable?.</P>

      @return  The same as returned by the most recent call to the validation function, as specified in sub-interfaces (for example: <CODE>{@link com.github.xbn.analyze.validate.ValueValidator}.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ValueValidator.html#isValid(O)">isValid</A>(O)</CODE>
      @exception  IllegalStateException  If the validation function was not called, or {@link com.github.xbn.analyze.Analyzer#resetState() resetState}{@code ()} was more recently called.
      @see  #getValidResultSource()
    **/
   boolean isValid();
   /**
      <P>What was the final decider of the most recent valid result?. This distinguishes where the final decision of &quot;validness&quot; came from: The pre-filter, the rules, or the post-filter.</P>

      @return  <UL>
         <LI><B><CODE>{@link com.github.xbn.analyze.validate.ResultReturnedBy ResultReturnedBy}.{@link com.github.xbn.analyze.validate.ResultReturnedBy#PRE_FILTER PRE_FILTER}</CODE>:</B>  If the <I>something</I> is never validated against the rules, because the {@link com.github.xbn.analyze.validate.ValidResultFilter#getPreAction() pre-filter}'s action is to {@link com.github.xbn.analyze.validate.FilterPreAction#isReturn() return a value}.</LI>
         <LI><B><CODE>ResultReturnedBy.{@link com.github.xbn.analyze.validate.ResultReturnedBy#RULES RULES}</CODE>:</B> If the <I>something</I> is validated against the rules and found valid (post {@link #doInvertRules() invert}), and the {@link com.github.xbn.analyze.validate.ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-filter} &nbsp; {@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED does not change} the follows-the-rules finding.</LI>
         <LI><B><CODE>ResultReturnedBy.{@link com.github.xbn.analyze.validate.ResultReturnedBy#POST_FILTER POST_FILTER}</CODE>:</B> If the <I>something</I> is validated against the rules, but that finding is ignored and overridden by an explicit return-value ({@link com.github.xbn.analyze.validate.FilterAfterValue#TRUE TRUE} or {@link com.github.xbn.analyze.validate.FilterAfterValue#FALSE FALSE}) from the post-filter.</LI>
      </UL>
    **/
   ResultReturnedBy getValidResultSource();
   /**
      <P>If, according to this validator's rules, the value is valid, should that be changed to invalid?. Inversion only affects the validator's <I>rules</I>. The value potentially returned by {@link ValidResultFilterable#getFilter() filters} (which ignore or suppress the &quot;does-follow-the-rules&quot; finding) are never inverted.</P>

      @return  {@code true} If what is normally considered valid, should now be considered invalid. This value should never change.
      @see  #isValid()
      @see  #getValidResultSource()
    **/
   boolean doInvertRules();
}
