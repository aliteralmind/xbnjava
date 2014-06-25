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
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.io.TextAppenter;
   import  java.util.ArrayList;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  java.util.Collections;
   import  java.util.Arrays;
   import  java.util.List;
   import  com.github.xbn.linefilter.entity.raw.RawParentEntity;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_Fieldable;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
/**
   <P>Represents a series of lines in a text file, with a distinct start and end line, zero-or-more lines in between, and optional child entities. The start, mid, and end lines may all be optionally kept or discarded--when kept, they may be optionally modified.</P>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...START
  -->

   <P>The start and end lines in a block must exist on separate lines. {@code com.github.xbn.linefilter.*} does not understand blocks that exist entirely on one line, such as
   <BR> &nbsp; &nbsp; <CODE>/<!--->* A valid Java comment *<!--->/</CODE>
   <BR>nor does it distinguish between text that may exist before the start or end line's unique marker:</P>

<BLOCKQUOTE><PRE>This is part of the block /<!--->* As is this
and this
<!--->*<!--->/  and this</PRE></BLOCKQUOTE>

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.z.BlockEntity_Cfg BlockEntity_Cfg}</H3>

   <P><UL>
      <LI><B>Start/mid/end:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startAlter(ValueAlterer) startAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#midAlter(ValueAlterer) midAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) endAlter}</LI>
      <LI><B>Inclusivity:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive() startEndLinesInclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesExclusive() startEndLinesExclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}{@code (b,b)}</LI>
      <LI><B>Keep:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepAll() keepAll}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepMidOnly() keepMidOnly}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepNone() keepNone}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}{@code (b,b,b)}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(RawChildEntity[]) children}{@code (rce[])}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(TextChildEntity...) children}{@code (tce...)}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#listener(EntityOnOffListener) listener}</LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#reset() reset}{@code ()}</LI>
   </UL></P>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...END
  -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BlockEntity extends RawBlockEntity<String,RawLine<String>> implements TextParentEntity  {
   private List<TextChildEntity> childList;
   /**
      <P>Create a new and <I>temporarily unusable</I> instance from a fieldable.</P>

      @param  fieldable  May not be {@code null}, and all its fields must conform to the restrictions as documented in the <A HREF="#cfg">setters</A>.
    **/
   public BlockEntity(RawBlockEntity_Fieldable<String,RawLine<String>> fieldable)  {
      super(fieldable);
   }
   protected BlockEntity(BlockEntity to_copy, int levels_belowRoot, RawParentEntity<String,RawLine<String>> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
/*
   public TextChildEntity getActiveChild()  {
      return  (TextChildEntity)super.getActiveChild();
   }
 */
   public List<TextChildEntity> getChildList()  {
      if(childList == null)  {
         synchronized(children)  {
            if(childList == null)  {
               childList = new ArrayList<TextChildEntity>(children.length);
               for(RawChildEntity<String,RawLine<String>> child : children)  {
                  childList.add((TextChildEntity)child);
               }
               childList = Collections.<TextChildEntity>unmodifiableList(childList);
            }
         }
      }
      return  childList;
   }
   public TextParentEntity getParent()  {
      return  (TextParentEntity)super.getParent();
   }
   public TextParentEntity getTopParent()  {
      return  (TextParentEntity)super.getTopParent();
   }
}
