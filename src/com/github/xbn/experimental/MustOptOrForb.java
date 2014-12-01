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
package  com.github.xbn.experimental;
/**
   <p>Declares if something <i>must</i>, <i>may</i>, or <i>must-not</i> meet a condition.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum MustOptOrForb  {
   /**
      <p>The condition must be met.</p>

    * @see  #OPTIONAL
    * @see  #FORBIDDEN
    * @see  #isMust()
    */
   MUST,
   /**
      <p>The condition may or may not be met.</p>

    * @see  #MUST
    * @see  #isOptional()
    */
   OPTIONAL,
   /**
      <p>The condition may not be met.</p>

    * @see  #MUST
    * @see  #isForbidden()
    */
   FORBIDDEN;
   /**
      <p>Is this {@code MustOptOrForb} equal to {@code MUST}?.</p>

    * @return  <code>this == {@link #MUST}</code>
    * @see  #isOptional()
    * @see  #isForbidden()
    */
   public final boolean isMust()  {
      return  this == MUST;
   }
   /**
      <p>Is this {@code MustOptOrForb} equal to {@code OPTIONAL}?.</p>

    * @return  <code>this == {@link #OPTIONAL}</code>
    * @see  #isMust()
    */
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <p>Is this {@code MustOptOrForb} equal to {@code FORBIDDEN}?.</p>

    * @return  <code>this == {@link #FORBIDDEN}</code>
    * @see  #isMust()
    */
   public final boolean isForbidden()  {
      return  this == FORBIDDEN;
   }
};
