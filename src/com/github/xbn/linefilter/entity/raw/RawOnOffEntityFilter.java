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
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  com.github.xbn.lang.Copyable;
/**
   <P>Determines when an entity is on, based on some conditions--The three possible states are on, off, and <I>stop the {@code FilteredIterator} right now</I> (abort). When off, lines are never analyzed, meaning it is not possible for it to be {@linkplain RawEntity#isActive() active}.</P>

   @see  RawChildEntity#getFilter()
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface RawOnOffEntityFilter<L> extends Copyable  {
   /**
      <P>Determines the on-off state before the line is ever analyzed by the entity.</P>

      @param  entity_beingFiltered  The entity whose {@linkplain RawChildEntity#getFilter() filter} is <I>this</I> object.
      @param  line_num  The number of theh line that will be analyzed by the entity (assuming this function returns {@link OnOffAbort#ON ON}).
      @param  body_toAlter  The line body that will potentially be altered.
    **/
   OnOffAbort getPreState(RawEntity<L> entity_beingFiltered, int line_num, L body_toAlter);
   /**
      <P>Determines the on-off state after the line has been analyzed by the entity (whether it was determined to be {@linkplain RawEntity#isActive() active} or not).</P>
      @param  entity_beingFiltered  The entity whose {@linkplain RawEntity#getFilter() filter} is <I>this</I> object.
      @param  potentially_alteredBody  The line body that was potentially altered by the entity.
    **/
   OnOffAbort getPostState(RawEntity<L> entity_beingFiltered, int line_num, L potentially_alteredBody);
   RawOnOffEntityFilter<L> getObjectCopy();
   void resetState();
}
