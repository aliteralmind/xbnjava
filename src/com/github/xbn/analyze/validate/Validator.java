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
   import  com.github.xbn.lang.ExtraErrInfoable;
   import  com.github.xbn.analyze.Analyzer;
      import  com.github.xbn.lang.Ruleable;

/**
   <p>Validates <i>something</i> against a set of rules.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public interface Validator extends Analyzer, Ruleable, ExtraErrInfoable, ValidResultFilterable  {
   /**
      <p>Reset in preparation for the next validation.</p>

      <p>This<ol>
         <li>Calls <code>{@link com.github.xbn.analyze.Analyzer super}.{@link com.github.xbn.analyze.Analyzer#resetState() resetState}()</code></li>
         <li>Sets {@link #isValid() wasValid}{@code ()} to {@code false}</li>
      </ol></p>

    * @see  #resetCounts()
    */
   void resetState();

   /**
      <p>Reset all counters to zero.</p>

      <p>This<ol>
         <li>Calls <code>{@link com.github.xbn.analyze.Analyzer super}.{@link com.github.xbn.analyze.Analyzer#resetCounts() resetCounts}()</code></li>
         <li>Sets {@link #getValidCount() getValidCount}{@code ()} to zero</li>
      </ol></p>

    * @see  #resetState()
    */
   void resetCounts();

   /**
      <p>How many times was the <i>something</i> deemed acceptable?.</p>

    * @see  #resetCounts()
    * @see  com.github.xbn.analyze.Analyzer#getAnalyzedCount() Analyzer#getAnalyzedCount()
    */
   int getValidCount();

   /**
      <p>Was the just analyzed <i>something</i> acceptable?.</p>

    * @return  The same as returned by the most recent call to the validation function, as specified in sub-interfaces (for example: <code>{@link com.github.xbn.analyze.validate.ValueValidator}.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="ValueValidator.html#isValid(O)">isValid</a>(O)</code>
    * @exception  IllegalStateException  If the validation function was not called, or {@link com.github.xbn.analyze.Analyzer#resetState() resetState}{@code ()} was more recently called.
    * @see  #getValidResultSource()
    */
   boolean isValid();
   /**
      <p>What was the final decider of the most recent valid result?. This distinguishes where the final decision of &quot;validness&quot; came from: The pre-filter, the rules, or the post-filter.</p>

    * @return  <ul>
         <li><b><code>{@link com.github.xbn.analyze.validate.ResultReturnedBy ResultReturnedBy}.{@link com.github.xbn.analyze.validate.ResultReturnedBy#PRE_FILTER PRE_FILTER}</code>:</b>  If the <i>something</i> is never validated against the rules, because the {@link com.github.xbn.analyze.validate.ValidResultFilter#getPreAction() pre-filter}'s action is to {@link com.github.xbn.analyze.validate.FilterPreAction#isReturn() return a value}.</li>
         <li><b><code>ResultReturnedBy.{@link com.github.xbn.analyze.validate.ResultReturnedBy#RULES RULES}</code>:</b> If the <i>something</i> is validated against the rules and found valid (post {@link #doInvertRules() invert}), and the {@link com.github.xbn.analyze.validate.ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-filter} &nbsp; {@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED does not change} the follows-the-rules finding.</li>
         <li><b><code>ResultReturnedBy.{@link com.github.xbn.analyze.validate.ResultReturnedBy#POST_FILTER POST_FILTER}</code>:</b> If the <i>something</i> is validated against the rules, but that finding is ignored and overridden by an explicit return-value ({@link com.github.xbn.analyze.validate.FilterAfterValue#TRUE TRUE} or {@link com.github.xbn.analyze.validate.FilterAfterValue#FALSE FALSE}) from the post-filter.</li>
      </ul>
    */
   ResultReturnedBy getValidResultSource();
   /**
      <p>If, according to this validator's rules, the value is valid, should that be changed to invalid?. Inversion only affects the validator's <i>rules</i>. The value potentially returned by {@link ValidResultFilterable#getFilter() filters} (which ignore or suppress the &quot;does-follow-the-rules&quot; finding) are never inverted.</p>

      <p>This is intended only for use with only basic validation rules. It is recommended to prevent this from being {@code true} in situations where the potential for rule-inversion confuses matters.</p>

    * @return  {@code true} If what is normally considered valid, should now be considered invalid. This value should never change.
    * @see  #isValid()
    * @see  #getValidResultSource()
    */
   boolean doInvertRules();
}
