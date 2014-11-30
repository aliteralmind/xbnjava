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
/**
   <p>In {@code ReturnValueUnchanged} only, after each call to <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/analyze/alter/ReturnValueUnchanged.html#getAltered(V, A)">getAltered</a>(V,A)</code>, what should its {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#wasAltered() wasAltered}{@code ()} flag be set to?.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum SetWasAlteredToWhenInRange {
   /**
      <p>Set {@code wasAltered()} to {@code false}.</p>

      @see  #FALSE
      @see  #isTrue()
    **/
   TRUE,
   /**
      <p>Set {@code wasAltered()} to {@code true}.</p>

      @see  #TRUE
      @see  #isFalse()
    **/
   FALSE;
   /**
      <p>Is this {@code SetWasAlteredToWhenInRange} equal to {@code TRUE}?.</p>

      @return  <code>this == {@link #TRUE}</code>

      @see  #isFalse()
    **/
   public final boolean isTrue()  {
      return  this == TRUE;
   }
   /**
      <p>Is this {@code SetWasAlteredToWhenInRange} equal to {@code FALSE}?.</p>

      @return  <code>this == {@link #FALSE}</code>
      @see  #isTrue()
    **/
   public final boolean isFalse()  {
      return  this == FALSE;
   }
};
