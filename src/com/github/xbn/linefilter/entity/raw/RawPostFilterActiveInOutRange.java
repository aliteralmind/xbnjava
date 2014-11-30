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
package  com.github.xbn.linefilter.entity.raw;
   import  com.github.xbn.linefilter.entity.OutOfRangeResponseWhen;
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  java.util.Objects;
   import  com.github.xbn.number.LengthInRange;
/**
   <p>A {@code RawOnOffEntityFilter} that is dependant on a specific entity's fully-active count being in a range.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RawPostFilterActiveInOutRange<L> extends AbstractRawPostFilterActiveInOutRange<L>  {
   private final RawEntity<L> entity;
   /**
      <p>Create a new instance from an entity, range, and when-in setting.</p>

      @param  entity_toTrack  The entity whose {@linkplain RawEntity#getFullyActiveCount() active count} should be monitored. Get with {@link #getEntityToTrack() getEntityToTrack}{@code ()}.
    **/
   public RawPostFilterActiveInOutRange(RawEntity<L> entity_toTrack, LengthInRange range, OnOffAbort when_inRange, OnOffAbort when_outOfRange, OutOfRangeResponseWhen response, Appendable debug_ifNonNull)  {
      super(range, when_inRange, when_outOfRange, response, debug_ifNonNull);
      Objects.requireNonNull(entity_toTrack, "entity_toTrack");
      entity = entity_toTrack;
   }
   /**
      @return  <code>{@link AbstractRawPostFilterActiveInOutRange#getPostStateForCount(RawEntity) getStateForCount}({@link #getEntityToTrack() getEntityToTrack}())</code>
    **/
   public OnOffAbort getPostState(RawEntity<L> ignored, int ignored2, L ignored3)  {
      return  getPostStateForCount(getEntityToTrack());
   }
   public RawEntity<L> getEntityToTrack()  {
      return  entity;
   }
   /**
    * <p>Get a reference to <i>this</i> object.</p>
    **/
   public RawPostFilterActiveInOutRange<L> getObjectCopy()  {
      return  this;
   }
   public String toString()  {
      return  super.toString() + ", entity=\"" + getEntityToTrack().getName() + "\"";
   }
}
