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
package  com.github.xbn.linefilter.entity;
/**
   <p>When the fully-active count is out of range, when should the out-of-range state (on/off/abort) be returned: immediately, or only when the <i>next</i> active line is found?.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum OutOfRangeResponseWhen  {
   /**
      <p>YYY.</p>

      @see  #NEXT_ACTIVE_LINE
      @see  #isImmediate()
    **/
   IMMEDIATE,
   /**
      <p>YYY.</p>

      @see  #IMMEDIATE
      @see  #isNextActiveLine()
    **/
   NEXT_ACTIVE_LINE;
   /**
      <p>Is this {@code OutOfRangeResponseWhen} equal to {@code IMMEDIATE}?.</p>

      @return  <code>this == {@link #IMMEDIATE}</code>

      @see  #isNextActiveLine()
    **/
   public final boolean isImmediate()  {
      return  this == IMMEDIATE;
   }
   /**
      <p>Is this {@code OutOfRangeResponseWhen} equal to {@code NEXT_ACTIVE_LINE}?.</p>

      @return  <code>this == {@link #NEXT_ACTIVE_LINE}</code>
      @see  #isImmediate()
    **/
   public final boolean isNextActiveLine()  {
      return  this == NEXT_ACTIVE_LINE;
   }
};
