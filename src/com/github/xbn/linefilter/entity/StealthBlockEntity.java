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
   import  com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawParentEntity;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_Fieldable;
/**
   <P>A specialized and simplified block-entity used only to prevent {@code BlockEntity}s from incorrectly matching start or end-lines (preventing false-positives). Lines in a block stealth entity, even though the entity's {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#isActive() active flag} is {@code true}, are never {@linkplain com.github.xbn.linefilter.FilteredLineIterator#getActiveChild() active} <I>according to {@link com.github.xbn.linefilter.FilteredLineIterator}</I>.</P>

<!--
   Originates in
      com.github.xbn.linefilter.StealthBlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.StealthBlockEntity
   ...START
  -->

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_Cfg StealthBlockEntity_Cfg}</H3>

   <P><UL>
      <LI>{@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#startValidator(ValueValidator) startValidator}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#endValidator(ValueValidator) endValidator}</LI>
      <LI>{@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#listener(EntityOnOffListener) listener}</LI>
      <LI><B>Other:</B> {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#reset() reset}, {@link com.github.xbn.linefilter.entity.z.StealthBlockEntity_CfgForNeeder#chainID(boolean, Object) chainID}</LI>
   </UL></P>

<!--
   Originates in
      com.github.xbn.linefilter.StealthBlockEntity
   required by
      com.github.xbn.linefilter.entity.raw.StealthBlockEntity
   ...END
  -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class StealthBlockEntity extends RawStealthBlockEntity<String,RawLine<String>> implements TextChildEntity  {
   public StealthBlockEntity(RawStealthBlockEntity_Fieldable<String,RawLine<String>> fieldable)  {
      super(fieldable);
   }
   protected StealthBlockEntity(StealthBlockEntity to_copy, int levels_belowRoot, RawParentEntity<String,RawLine<String>> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRangeValidator range_forEveryLineDebug)  {
      super(to_copy, levels_belowRoot, parent, dbgAptrEveryLine_ifUseable, range_forEveryLineDebug);
   }
   public TextParentEntity getParent()  {
      return  (TextParentEntity)getParent();
   }
   public TextParentEntity getTopParent()  {
      return  (TextParentEntity)getTopParent();
   }
}
