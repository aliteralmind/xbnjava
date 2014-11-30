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
package  com.github.xbn.linefilter;
/**
   <p>If a child block is active on the very first line of the root block, should the text of the {@linkplain #YES child} or {@linkplain #NO parent}-block be returned?</p>

   @see  FilteredLineIterator#appendAllBlockLines(java.lang.StringBuilder, java.lang.String, com.github.xbn.linefilter.StripFinalNewLine, com.github.xbn.linefilter.ChildOnFirstLine) FilteredLineIterator#appendAllBlockLines
   @since  0.1.2
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum ChildOnFirstLine  {
   /**
      <p>Return the child-block.</p>

      @see  #NO
      @see  #isYes()
    **/
   YES,
   /**
      <p>Return the parent block.</p>

      @see  #YES
      @see  #isNo()
    **/
   NO;
   /**
      <p>Is this {@code ChildOnFirstLine} equal to {@code YES}?.</p>

      @return  <code>this == {@link #YES}</code>

      @see  #isNo()
    **/
   public final boolean isYes()  {
      return  this == YES;
   }
   /**
      <p>Is this {@code ChildOnFirstLine} equal to {@code NO}?.</p>

      @return  <code>this == {@link #NO}</code>
      @see  #isYes()
    **/
   public final boolean isNo()  {
      return  this == NO;
   }
   /**
      <p>Return {@code ChildOnFirstLine.YES} if the flag is {@code true}, or {@code NO} if {@code false}.</p>

      @return  <code>(flag ? {@link #YES} : {@link #NO})</code>
    **/
   public static final ChildOnFirstLine getForBoolean(boolean flag)  {
      return  (flag ? YES : NO);
   }
};
