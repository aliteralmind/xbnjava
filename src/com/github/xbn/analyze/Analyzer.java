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
   <P>Base class for {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.Validator Validator} and {@code com.github.xbn.analyze.alter.}{@link com.github.xbn.analyze.alter.Alterer Alterer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public interface Analyzer extends Copyable, Debuggable, ExtraErrInfoable, Expirable, ToStringAppendable  {
   /**
      <P>Reset state to defaults. This does not affect configuration or counts.</P>

      <P>This<OL>
         <LI>Sets {@link #wasAnalyzed() wasAnalyzed}{@code ()} to {@code false}.</LI>
      </OL></P>

      <P>Resets all internal state except counts. This does not change any user-configuration.</P>

      @see  #resetCounts()
      @see  #doAutoResetState()
    **/
   void resetState();

   /**
      <P>Is state automatically reset before each analysis?.</P>

      @return  {@code true}  <A HREF="#resetState()">State</A> is automatically reset.
    **/
   boolean doAutoResetState();
   /**
      <P>Reset all counts to zero.</P>

      <P>Sets {@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to zero.</P>
      @see  #resetState()
    **/
   void resetCounts();

   /**
      <P>How many times has something been analyzed?.</P>
      @see  #resetCounts()
    **/
   int getAnalyzedCount();

   /**
      <P>Was something just analyzed?.</P>
      @see  #resetState() reset()
    **/
   boolean wasAnalyzed();

   /**
      <P>Get a duplicate of this {@code Analyzer} that, by default, is a complete (full-and-deep) copy.</P>

      @return  A duplicate of this {@code Analyzer} as specified above.
    **/
   @Override
   Analyzer getObjectCopy();
   /**
      <P>Returns {@code true} if another {@code Analyzer} has the same configuration as this one--state and counts are ignored.</P>

      @see  #resetState()
      @see  #resetCounts()
    **/
   boolean equals(Object to_compareTo);
}
