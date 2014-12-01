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
   <p>When using a series of alterers, should the <i>thing being altered</i> be altered by all of them, cumulatively, or by one-at-the-most?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum MultiAlterType {
   /**
      <p>Once an alteration is made on the <i>thing</i> by any element, stop.</p>

    * @see  #CUMULATIVE
    */
   SHORT_CIRCUIT,
   /**
      <p>All alter-elements may make alterations on the <i>thing</i>, cumulatively.</p>

    * @see  #SHORT_CIRCUIT
    */
   CUMULATIVE;
   /**
      <p>Is this {@code ExpireListType} equal to {@code SHORT_CIRCUIT}?.</p>

    * @return  <code>this == {@link #SHORT_CIRCUIT}</code>

    * @see  #isCumulative()
    */
   public final boolean isShortCircuit()  {
      return  this == SHORT_CIRCUIT;
   }
   /**
      <p>Is this {@code ExpireListType} equal to {@code CUMULATIVE}?.</p>

    * @return  <code>this == {@link #CUMULATIVE}</code>
    * @see  #isShortCircuit()
    */
   public final boolean isCumulative()  {
      return  this == CUMULATIVE;
   }
};
