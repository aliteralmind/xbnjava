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
   <P>A {@code Chainable} whose purpose is to configure a single object, particularly a highly-configurable one, as needed by a {@code Needer}--a needable's self-returning function chain in is <I>shareable</I>, meaning it can be used by other classes <I>without those classes having to implement the functions</I>. See {@link com.github.xbn.neederneedable.Needer Needer}. {@code Needable}-s may be used  <A HREF="#direct">directly</A> or <A HREF="#indirect">indirectly</A></P>

   @param  O  The type of needed object.
   @param  R  The type of object needing the {@code O}.

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Needable<O,R extends Needer> extends Chainable  {
   /**
      <P>Must this {@code Needable} be used directly?.</P>

      <a name="indirect"/><H3>Indirect use</H3>

      <P>The primary use of {@code Needable}-s is to make their method-chains available to any <I>needing</I> class--a {@link com.github.xbn.neederneedable.Needer Needer}. For example:

<PRE>public static final void main(String[] ignored)  {
   UserSettings us = (new UserSettings()).
      cfgFavInt().twentySeven().timesTwo().increment().endCfg().  //shared-chain
      name("President Obama");                                    //local-chain
}

   ...

{@literal public FavNumConfigurator4Ndr<UserSettings> cfgFavInt()  {
   FavNumConfigurator4Ndr<UserSettings> fnc = new FavNumConfigurator4Ndr<UserSettings>();
   return  fnc.startConfigReturnNeedable(this);
}}</PRE>

      <P>The needable class, {@code FavNumConfigurator4Ndr}, is only instantiated by the needer. It is recommended that all {@code Needable}-s be named with a {@code ForNeeder} postfix.</P>

      <P><I>All {@code Needable}-s may be <U>indirectly</U> used.</I></P>

      <a name="direct"/><H3>Direct use</H3>

      <P>Some {@code Needable}-s may also allow direct use. That is, the {@code Needable} can be directly instantiated, which implies that the {@code Needer} is ignored. For example</P>

      <BR> &nbsp; &nbsp; {@code int iFav = (new FavNumConfigurator()).
      <BR> &nbsp; &nbsp; twentySeven().timesTwo().increment().get();}</P>

      <P>Where {@code FavNumConfigurator} is a trivial class whose only purpose is to pass in a <I>dummy</I> (ignored) {@code Needer} to its super-{@code Needable}:</P>

<PRE>public class FavNumConfigurator extends FavNumConfigurator4Ndr&lt;{@link com.github.xbn.neederneedable.DummyForNoNeeder DummyForNoNeeder}&gt;  {
   //The only constructor in FavNumConfigurator4Ndr, and in this class,
   //is a zero-parameter constructor, which is implicitly specified.
}</PRE>

      @return  <UL>
         <LI>{@code true}: May be used indirectly or directly. It is safe to call  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(R)</CODE> and {@link #endCfg() endCfg}{@code ()}</LI>
         <LI>{@code false}:  <I>This {@code Needable} instance</I> must be used directly--it is illegal to call {@code startConfigReturnNeedable(R)} and {@code endCfg()}. <I>When this returns {@code false}, YYY</I></LI>
      </UL>
    **/
   boolean isAvailableToNeeder();
   /**
      <P>Start the configuration of a new object. For <A HREF="#indirect">indirect</A> use only.</P>

      <P>This sets<OL>
         <LI>{@code getActiveNeeder()} to {@code true}.</LI>
         <LI>{@link #isNeededUsable() isNeededUsable}{@code ()} as appropriate. <I>The value of {@code isNeededUsable()} must be maintained throughout this classes lifetime.</I></LI>
      </OL></P>

      <P>After calling this function, use the {@code Needable}'s self-returning functions to configure the object. The final call in the chain is always {@link #endCfg() endCfg}{@code ()}.</P>

      @param  needer  The {@code Needer} needing the configured object. May not be {@code null}. Get with {@link #getActiveNeeder() getActiveNeeder}{@code ()}.
      @return  <I>{@code this}</I> {@code Needable}
      @exception  IllegalStateException  If {@code getActiveNeeder()} is {@code null} or {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()} is {@code false}.
    **/
   Needable<O,R> startConfigReturnNeedable(R needer);
   /**
      <P>Is an object currently being configured?.</P>

      @return  {@code true}  If <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(R)</CODE> was called more recently than {@link #endCfg() endCfg}{@code ()}, or {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()} is {@code true}.
    **/
   R getActiveNeeder();
   /**
      <P>Is the currently-being-configured object in a usable state?. Used when portions of the configuration require multiple contiguous steps, which were started but not completed.</P>

      @return  {@code true} If {@link #endCfg() endCfg}{@code ()} can be safely called. Otherwise, the {@code toString()} for this {@code Needable} should contain clear rules on how usability is achieved.
      @exception  IllegalStateException  If {@code getActiveNeeder()} is {@code null}.
      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(R)</CODE>
    **/
   boolean isNeededUsable();
   /**
      <P>Get the fully-configured object, and prepare for the next configuration. For <A HREF="#indirect">indirect</A> use only.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link #getActiveNeeder() getActiveNeeder}().{@link com.github.xbn.neederneedable.Needer#neeadableSetsNeeded(Object) neeadableSetsNeeded}(<I>[the-fully-configured-object]</I>)</CODE></LI>
         <LI>Sets {@code getActiveNeeder()} to {@code null}</LI>
         <LI>Returns the needer.</LI>
      </OL></P>

      @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null} or {@link #isNeededUsable() isNeededUsable}{@code ()} is {@code false}.
      @see <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(R)</CODE>
    **/
   R endCfg();
   /**
      <P>Should all builder-data be re-verified in the enclosing ({@code Needer}) constructor?. Using this flag is only necessary when thread-safety is a concern.</P>

      <P>A {@code Needable} that is also a Builder-pattern (as in Effective Java by Joshua Bloch, 2nd ed, item 2), is implemented as a static enclosing class. Because of this, other threads may change the data before the class is built ({@code build()} is called). This may require a re-verification of all data in the enclosing class. See (viewed 1/5/2014)
      <BR> &nbsp; &nbsp; {@code <A HREF="http://stackoverflow.com/questions/20937880/making-blochs-builder-pattern-thread-safe-rechecking-necessary-in-enclosing-co">http://stackoverflow.com/questions/20937880/making-blochs-builder-pattern-thread-safe-rechecking-necessary-in-enclosing-co</A>}</P>

   <P>{@code java com.github.xbn.examples.neederneedable.ReverifyBuilderInEnclosingCnstrXmpl}</P>

      @return  {@code true}  If the enclosing classes constructor should re-verify all data retrieved from the builder.
   boolean doReverifyInEnclosing();
    **/
}
