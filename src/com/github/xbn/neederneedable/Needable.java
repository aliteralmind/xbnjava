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
   <p>A {@code Chainable} whose purpose is to configure a single object, particularly a highly-configurable one, as needed by a {@code Needer}--a needable's self-returning function chain in is <i>shareable</i>, meaning it can be used by other classes <i>without those classes having to implement the functions</i>. See {@link com.github.xbn.neederneedable.Needer Needer}. {@code Needable}-s may be used  <a href="#direct">directly</a> or <a href="#indirect">indirectly</a></p>

   @param  O  The type of needed object.
   @param  R  The type of object needing the {@code O}.

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Needable<O,R extends Needer> extends Chainable  {
   /**
      <p>Must this {@code Needable} be used directly?.</p>

      <A NAME="indirect"></a><h3>Indirect use</h3>

      <p>The primary use of {@code Needable}-s is to make their method-chains available to any <i>needing</i> class--a {@link com.github.xbn.neederneedable.Needer Needer}. For example:

<pre>public static final void main(String[] ignored)  {
   UserSettings us = (new UserSettings()).
      cfgFavInt().twentySeven().timesTwo().increment().endCfg().  //shared-chain
      name("President Obama");                                    //local-chain
}

   ...

{@literal public FavNumConfigurator4Ndr<UserSettings> cfgFavInt()  {
   FavNumConfigurator4Ndr<UserSettings> fnc = new FavNumConfigurator4Ndr<UserSettings>();
   return  fnc.startConfigReturnNeedable(this);
}}</pre>

      <p>The needable class, {@code FavNumConfigurator4Ndr}, is only instantiated by the needer. It is recommended that all {@code Needable}-s be named with a {@code ForNeeder} postfix.</p>

      <p><i>All {@code Needable}-s may be <u>indirectly</u> used.</i></p>

      <A NAME="direct"></a><h3>Direct use</h3>

      <p>Some {@code Needable}-s may also allow direct use. That is, the {@code Needable} can be directly instantiated, which implies that the {@code Needer} is ignored. For example</p>

      <br/> &nbsp; &nbsp; {@code int iFav = (new FavNumConfigurator()).
      <br/> &nbsp; &nbsp; twentySeven().timesTwo().increment().get();}</p>

      <p>Where {@code FavNumConfigurator} is a trivial class whose only purpose is to pass in a <i>dummy</i> (ignored) {@code Needer} to its super-{@code Needable}:</p>

<pre>public class FavNumConfigurator extends FavNumConfigurator4Ndr&lt;{@link com.github.xbn.neederneedable.DummyForNoNeeder DummyForNoNeeder}&gt;  {
   //The only constructor in FavNumConfigurator4Ndr, and in this class,
   //is a zero-parameter constructor, which is implicitly specified.
}</pre>

      @return  <ul>
         <li>{@code true}: May be used indirectly or directly. It is safe to call  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(R)</code> and {@link #endCfg() endCfg}{@code ()}</li>
         <li>{@code false}:  <i>This {@code Needable} instance</i> must be used directly--it is illegal to call {@code startConfigReturnNeedable(R)} and {@code endCfg()}. <i>When this returns {@code false}, YYY</i></li>
      </ul>
    **/
   boolean isAvailableToNeeder();
   /**
      <p>Start the configuration of a new object. For <a href="#indirect">indirect</a> use only.</p>

      <p>This sets<ol>
         <li>{@code getActiveNeeder()} to {@code true}.</li>
         <li>{@link #isNeededUsable() isNeededUsable}{@code ()} as appropriate. <i>The value of {@code isNeededUsable()} must be maintained throughout this classes lifetime.</i></li>
      </ol></p>

      <p>After calling this function, use the {@code Needable}'s self-returning functions to configure the object. The final call in the chain is always {@link #endCfg() endCfg}{@code ()}.</p>

      @param  needer  The {@code Needer} needing the configured object. May not be {@code null}. Get with {@link #getActiveNeeder() getActiveNeeder}{@code ()}.
      @return  <i>{@code this}</i> {@code Needable}
      @exception  IllegalStateException  If {@code getActiveNeeder()} is {@code null} or {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()} is {@code false}.
    **/
   Needable<O,R> startConfigReturnNeedable(R needer);
   /**
      <p>Is an object currently being configured?.</p>

      @return  {@code true}  If <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(R)</code> was called more recently than {@link #endCfg() endCfg}{@code ()}, or {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()} is {@code true}.
    **/
   R getActiveNeeder();
   /**
      <p>Is the currently-being-configured object in a usable state?. Used when portions of the configuration require multiple contiguous steps, which were started but not completed.</p>

      @return  {@code true} If {@link #endCfg() endCfg}{@code ()} can be safely called. Otherwise, the {@code toString()} for this {@code Needable} should contain clear rules on how usability is achieved.
      @exception  IllegalStateException  If {@code getActiveNeeder()} is {@code null}.
      @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(R)</code>
    **/
   boolean isNeededUsable();
   /**
      <p>Get the fully-configured object, and prepare for the next configuration. For <a href="#indirect">indirect</a> use only.</p>

      <p>This<ol>
         <li>Calls <code>{@link #getActiveNeeder() getActiveNeeder}().{@link com.github.xbn.neederneedable.Needer#neeadableSetsNeeded(Object) neeadableSetsNeeded}(<i>[the-fully-configured-object]</i>)</code></li>
         <li>Sets {@code getActiveNeeder()} to {@code null}</li>
         <li>Returns the needer.</li>
      </ol></p>

      @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null} or {@link #isNeededUsable() isNeededUsable}{@code ()} is {@code false}.
      @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(R)</code>
    **/
   R endCfg();
   /**
      <p>Should all builder-data be re-verified in the enclosing ({@code Needer}) constructor?. Using this flag is only necessary when thread-safety is a concern.</p>

      <p>A {@code Needable} that is also a Builder-pattern (as in Effective Java by Joshua Bloch, 2nd ed, item 2), is implemented as a static enclosing class. Because of this, other threads may change the data before the class is built ({@code build()} is called). This may require a re-verification of all data in the enclosing class. See (viewed 1/5/2014)
      <br/> &nbsp; &nbsp; {@code <a href="http://stackoverflow.com/questions/20937880/making-blochs-builder-pattern-thread-safe-rechecking-necessary-in-enclosing-co">http://stackoverflow.com/questions/20937880/making-blochs-builder-pattern-thread-safe-rechecking-necessary-in-enclosing-co</a>}</p>

   <p>{@code java com.github.xbn.examples.neederneedable.ReverifyBuilderInEnclosingCnstrXmpl}</p>

      @return  {@code true}  If the enclosing classes constructor should re-verify all data retrieved from the builder.
   boolean doReverifyInEnclosing();
    **/
}
