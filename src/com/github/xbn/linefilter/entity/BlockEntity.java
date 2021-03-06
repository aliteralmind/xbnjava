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
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.io.TextAppenter;
   import  java.util.ArrayList;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  java.util.Collections;
   import  java.util.List;
   import  com.github.xbn.linefilter.entity.raw.RawParentEntity;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_Fieldable;
/**
   <p>Represents a series of lines in a text file, with a distinct start and end line, zero-or-more lines in between, and optional child entities. The start, mid, and end lines may all be optionally kept or discarded--when kept, they may be optionally modified.</p>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...START
  -->

   <p>The start and end lines in a block must exist on separate lines. {@code com.github.xbn.linefilter.*} does not understand blocks that exist entirely on one line, such as
   <br/> &nbsp; &nbsp; <code>/<!--->* A valid Java comment *<!--->/</code>
   <br/>nor does it distinguish between text that may exist before the start or end line's unique marker:</p>

<blockquote><pre>This is part of the block /<!--->* As is this
and this
<!--->*<!--->/  and this</pre></blockquote>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.linefilter.entity.z.BlockEntity_Cfg BlockEntity_Cfg}</h3>

   <p><ul>
      <li><b>Start/mid/end:</b> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startAlter(ValueAlterer) startAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#midAlter(ValueAlterer) midAlter}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) endAlter}</li>
      <li><b>Inclusivity:</b> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive() startEndLinesInclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesExclusive() startEndLinesExclusive}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startEndLinesInclusive(boolean, boolean) startEndLinesInclusive}{@code (b,b)}</li>
      <li><b>Keep:</b> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepAll() keepAll}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepMidsOnly() keepMidsOnly}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepNone() keepNone}{@code ()}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}{@code (b,b,b)}</li>
      <li>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(RawChildEntity[]) children}{@code (rce[])}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(TextChildEntity...) children}{@code (tce...)}</li>
      <li>{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#filter(RawOnOffEntityFilter) filter}</li>
      <li><b>Other:</b> {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#reset() reset}{@code ()}</li>
   </ul></p>

<!--
   Originates in
      com.github.xbn.linefilter.BlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.RawBlockEntity
   ...END
  -->

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class BlockEntity extends RawBlockEntity<String> implements TextParentEntity  {
   private List<TextChildEntity> childList;
   /**
      <p>Create a new and <i>temporarily unusable</i> instance from a fieldable.</p>

    * @param  fieldable  May not be {@code null}, and all relevant fields must conform to the restrictions as documented in the <a href="#cfg">setters</a>.
    */
   public BlockEntity(RawBlockEntity_Fieldable<String> fieldable)  {
      super(fieldable);
   }
   protected BlockEntity(BlockEntity to_copy, int levels_belowRoot, RawParentEntity<String> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
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
               for(RawChildEntity<String> child : children)  {
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
   /**
    * @since  0.1.2
    **/
   public BlockEntity getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<String> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      return  new BlockEntity(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
}
