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
   <p>Abstract implementation of {@code Needer}. For classes needing to implement {@code Needer}, that cannot extend {@code AbstractNeeder}, see {@link com.github.xbn.neederneedable.NeederComposer NeederComposer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractNeeder implements Needer  {
   private final NeederComposer ndrc;
   /**
      <p>Create a new instance.</p>

      <p>This creates an internal
      <br> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeederComposer#NeederComposer() NeederComposer}{@code ()}</p>
    */
   public AbstractNeeder()  {
      ndrc = new NeederComposer();
   }
   /**
    * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer NeederComposer}]</i>.{@link com.github.xbn.neederneedable.NeederComposer#getNeededType() getNeededType}()</code>
    */
   public Class getNeededType()  {
//	public <O> Class<O> getNeededType()  {
      return  ndrc.getNeededType();
   }
   /**
    * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer NeederComposer}]</i>.{@link com.github.xbn.neederneedable.NeederComposer#isConfigActive() isConfigActive}()</code>
    */
   public boolean isConfigActive()  {
      return  ndrc.isConfigActive();
   }
   /**
      <p>Starts configuration for a specific type of object.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeederComposer NeederComposer}]</i>.{@link com.github.xbn.neederneedable.NeederComposer#startConfig(Class) startConfig}(needed_class)</code></p>
    */
   public void startConfig(Class<?> needed_class)  {
      ndrc.startConfig(needed_class);
   }
   /**
    * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer NeederComposer}]</i>.{@link com.github.xbn.neederneedable.NeederComposer#setGetNeededEndConfig_4prot(Object) setGetNeededEndConfig_4prot}(needed_fullyConfigured)</code>
    */
   protected Object setGetNeededEndConfig(Object needed_fullyConfigured)  {
      return  ndrc.setGetNeededEndConfig_4prot(needed_fullyConfigured);
   }
/*stub functions for non-abstract compile...START
   public void neeadableSetsNeeded(Object fully_configured)  {
   }
 stub functions for non-abstract compile...END*/
}
