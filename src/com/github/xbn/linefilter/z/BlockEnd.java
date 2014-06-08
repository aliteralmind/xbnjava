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
package  com.github.xbn.linefilter.z;
/**
   <P>Is the block-end line in a {@code LineFilter} is optional or required?--this is used by <CODE>{@link com.github.xbn.linefilter.z.LineFilter_CfgForNeeder LineFilter_CfgForNeeder}.{@link com.github.xbn.linefilter.z.LineFilter_CfgForNeeder#end(BlockEnd, ValueAlterer) end}(av,b)</CODE>.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum BlockEnd  {
   /**
      <P>It is okay for block-end marks (lines) to not exist. Blocks are automatically closed when a new block is {@link com.github.xbn.linefilter.LineFilter#getActiveBlockStartLineNum() opened}, or at the {@link com.github.xbn.linefilter.LineFilter#declareAllLinesAnalyzed() end of input}.</P>

      @see  #REQUIRED
      @see  #isOptional()
    **/
   OPTIONAL,
   /**
      <P>Block-end marks (line) must exist.</P>

      @see  #OPTIONAL
      @see  #isRequired()
    **/
   REQUIRED;
   /**
      <P>Is this {@code BlockEnd} equal to {@code OPTIONAL}?.</P>

      @return  <CODE>this == {@link #OPTIONAL}</CODE>

      @see  #isRequired()
    **/
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <P>Is this {@code BlockEnd} equal to {@code REQUIRED}?.</P>

      @return  <CODE>this == {@link #REQUIRED}</CODE>
      @see  #isOptional()
    **/
   public final boolean isRequired()  {
      return  this == REQUIRED;
   }
   /**
      <P>Get a {@code BlockEnd} from an actual boolean.</P>

      @return  <CODE>(b ? {@link #REQUIRED} : {@link #OPTIONAL})</CODE>
    **/
   public static final BlockEnd getForBoolean(boolean b)  {
      return  (b ? REQUIRED : OPTIONAL);
   }
};
