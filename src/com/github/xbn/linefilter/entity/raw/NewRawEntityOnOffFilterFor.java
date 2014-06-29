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
   import  java.util.Objects;
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Convenience functions for creating {@code RawEntityOnOffFilter}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewRawEntityOnOffFilterFor  {
   public static final <O,L extends RawLine<O>> RawEntityOnOffFilter<O,L> alwaysForPrePost(OnOffAbort pre_state, OnOffAbort post_state)  {
      return  new FilterAlways<O,L>(pre_state, post_state);
   }
   private NewRawEntityOnOffFilterFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
class FilterAlways<O,L extends RawLine<O>> implements RawEntityOnOffFilter<O,L>  {
   private final OnOffAbort pre;
   private final OnOffAbort post;
   public FilterAlways(OnOffAbort pre_state, OnOffAbort post_state)  {
      Objects.requireNonNull(pre_state, "pre_state");
      Objects.requireNonNull(post_state, "post_state");
      pre = pre_state;
      post = post_state;
   }
   public FilterAlways(FilterAlways to_copy)  {
      try  {
         pre = to_copy.pre;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      post = to_copy.post;
   }
   public OnOffAbort getPreState(RawEntity<O,L> ignored, RawLine<O> ignored2, O ignored3)  {
      return  getPreState();
   }
   public OnOffAbort getPostState(RawEntity<O,L> ignored, RawLine<O> ignored2, O ignored3)  {
      return  getPostState();
   }
   public RawEntityOnOffFilter<O,L> getObjectCopy()  {
      return  new FilterAlways<O,L>(this);
   }
   public OnOffAbort getPreState()  {
      return  pre;
   }
   public OnOffAbort getPostState()  {
      return  pre;
   }
   public String toString()  {
      return  "NewRawEntityOnOffFilterFor.alwaysPrePost(OnOffAbort." + getPreState() + ", OnOffAbort." + getPostState() + ")";
   }
   public void resetState()  {
   }
}
