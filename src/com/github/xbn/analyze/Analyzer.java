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
package  com.github.xbn.analyze;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.lang.Expirable;
   import  com.github.xbn.lang.ExtraErrInfoable;
   import  com.github.xbn.lang.Copyable;
      import  com.github.xbn.io.Debuggable;

/**
   <p>Base class for {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.Validator Validator} and {@code com.github.xbn.analyze.alter.}{@link com.github.xbn.analyze.alter.Alterer Alterer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public interface Analyzer extends Copyable, Debuggable, ExtraErrInfoable, Expirable, ToStringAppendable  {
   /**
      <p>Reset state to defaults. This does not affect configuration or counts.</p>

      <p>This<ol>
         <li>Sets {@link #wasAnalyzed() wasAnalyzed}{@code ()} to {@code false}.</li>
      </ol></p>

      <p>Resets all internal state except counts. This does not change any user-configuration.</p>

    * @see  #resetCounts()
    * @see  #doAutoResetState()
    */
   void resetState();

   /**
      <p>Is state automatically reset before each analysis?.</p>

    * @return  {@code true}  <a href="#resetState()">State</a> is automatically reset.
    */
   boolean doAutoResetState();
   /**
      <p>Reset all counts to zero.</p>

      <p>Sets {@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to zero.</p>
    * @see  #resetState()
    */
   void resetCounts();

   /**
      <p>How many times has something been analyzed?.</p>
    * @see  #resetCounts()
    */
   int getAnalyzedCount();

   /**
      <p>Was something just analyzed?.</p>
    * @see  #resetState() reset()
    */
   boolean wasAnalyzed();

   /**
      <p>Duplicate this {@code Analyzer} that, by default, has the same configuration (state and counts are reset).</p>

    * @return  A non-{@code null} duplicate of this {@code Analyzer}.
    */
   @Override
   Analyzer getObjectCopy();
   /**
      <p>Returns {@code true} if another {@code Analyzer} has the same configuration as this one--state and counts are ignored.</p>

    * @see  #resetState()
    * @see  #resetCounts()
    */
   boolean equals(Object to_compareTo);
}
