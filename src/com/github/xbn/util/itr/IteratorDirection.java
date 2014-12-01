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
package  com.github.xbn.util.itr;
/**
   <p>In which direction should the iterator go?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum IteratorDirection  {
   /**
      <p>YYY.</p>

    * @see  #HIGH_TO_LOW
    * @see  #isLowToHigh()
    */
   LOW_TO_HIGH,
   /**
      <p>YYY.</p>

    * @see  #LOW_TO_HIGH
    * @see  #isHighToLow()
    */
   HIGH_TO_LOW;
   /**
      <p>Is this {@code IteratorDirection} equal to {@code LOW_TO_HIGH}?.</p>

    * @return  <code>this == {@link #LOW_TO_HIGH}</code>
    * @see  #isHighToLow()
    */
   public final boolean isLowToHigh()  {
      return  this == LOW_TO_HIGH;
   }
   /**
      <p>Is this {@code IteratorDirection} equal to {@code HIGH_TO_LOW}?.</p>

    * @return  <code>this == {@link #HIGH_TO_LOW}</code>

    * @see  #isLowToHigh()
    */
   public final boolean isHighToLow()  {
      return  this == HIGH_TO_LOW;
   }
};
