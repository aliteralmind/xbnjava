/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com
   
   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   import  com.github.xbn.util.EnumUtil;
/**
   <P>When using a series of alterers, should the <I>thing being altered</I> be altered by all of them, cumulatively, or by one-at-the-most?.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum MultiAlterType {
   /**
      <P>Once an alteration is made on the <I>thing</I> by any element, stop.</P>

      @see  #CUMULATIVE
    **/
   SHORT_CIRCUIT,
   /**
      <P>All alter-elements may make alterations on the <I>thing</I>, cumulatively.</P>

      @see  #SHORT_CIRCUIT
    **/
   CUMULATIVE;
   /**
      <P>Is this {@code ExpireListType} equal to {@code SHORT_CIRCUIT}?.</P>

      @return  <CODE>this == {@link #SHORT_CIRCUIT}</CODE>

      @see  #isCumulative()
    **/
   public final boolean isShortCircuit()  {
      return  this == SHORT_CIRCUIT;
   }
   /**
      <P>Is this {@code ExpireListType} equal to {@code CUMULATIVE}?.</P>

      @return  <CODE>this == {@link #CUMULATIVE}</CODE>
      @see  #isShortCircuit()
    **/
   public final boolean isCumulative()  {
      return  this == CUMULATIVE;
   }
};
