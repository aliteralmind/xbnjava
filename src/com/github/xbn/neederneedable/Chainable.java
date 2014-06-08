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
package  com.github.xbn.neederneedable;
/**
   <P>{@code Chainable} supports self-returning function chains, with the ability to insert arbitrary diagnostic identifiers at any point.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Chainable  {
   /**
      <P>Insert a diagnostic identifier into the chain.</P>

      @param  id  May not be {@code null}. If a string, it <I>should</I> not be empty or invisible. Get with {@link #getChainID() getChainID}{@code ()}.
      @return  The {@code Chainable} instance. This must be overridden by all concrete sub-classes.
    **/
   Chainable chainID(boolean do_setStatic, Object id);
   /**
      <P>The chain id. Any self-returning functions that potentially throw an exception, should append the chain-ids to their message.</P>

<PRE>{@literal public final ChainableClass doSomething()  {
   try  {
      //do stuff
   }  catch(RuntimeException rx)  {
      throw  new RuntimeException("getChainID()=[" + getChainID() + "], getStaticChainID()=[" + getStaticChainID() + "]", rx);
   }
   return  this;
}}</PRE>
    **/
   Object getChainID();
   Object getStaticChainID();
}
