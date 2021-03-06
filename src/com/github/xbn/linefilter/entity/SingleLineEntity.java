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
   import  com.github.xbn.linefilter.entity.raw.RawSingleLineEntity;
   import  com.github.xbn.linefilter.entity.raw.RawParentEntity;
   import  com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_Fieldable;
/**
   <p>A single line of text that may be kept or discarded by a {@code FilteredLineIterator}--kept lines are optionally modified.</p>

<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.SingleLineEntity
   ...START
  -->

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.linefilter.entity.z.SingleLineEntity_Cfg SingleLineEntity_Cfg}</h3>

   <p><ul>
      <li>{@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#alterer(ValueAlterer) alterer}, {@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#keepMatchedLines(boolean) keepMatchedLines}(b)</li>
      <li>{@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#filter(RawOnOffEntityFilter) filter} </li>
      <li><b>Other:</b> {@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#reset() reset}{@code ()}, {@link com.github.xbn.linefilter.entity.z.SingleLineEntity_CfgForNeeder#chainID(boolean, Object) chainID}</li>
   </ul></p>


<!--
   Originates in
      com.github.xbn.linefilter.SingleLineEntity
   required by
      com.github.xbn.linefilter.entity.raw.SingleLineEntity
   ...END
  -->

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SingleLineEntity extends RawSingleLineEntity<String> implements TextChildEntity  {
   /**
      <p>Create a new and <i>temporarily unusable</i> instance from a fieldable.</p>

    * @param  fieldable  May not be {@code null}, and all relevant fields must conform to the restrictions as documented in the <a href="#cfg">setters</a>.
    */
   public SingleLineEntity(RawSingleLineEntity_Fieldable<String> fieldable)  {
      super(fieldable);
   }
   protected SingleLineEntity(SingleLineEntity to_copy, int levels_belowRoot, RawParentEntity<String> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
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
   public SingleLineEntity getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<String> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug)  {
      return  new SingleLineEntity(this, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
}
