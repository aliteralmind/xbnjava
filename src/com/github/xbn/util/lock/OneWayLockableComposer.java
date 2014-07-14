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
package  com.github.xbn.util.lock;
/**
   <P>For classes needing to implement {@code OneWayLockable}, that cannot extend {@code AbstractOneWayLockable}. See {@link com.github.xbn.util.lock.LockableComposer LockableComposer} for implementation details.</P>
 **/
public class OneWayLockableComposer extends LockableComposer  {
   /**
      <P>Create a new {@code OneWayLockableComposer}.</P>


      <P>Calls<OL>
         <LI>{@link com.github.xbn.util.lock.LockableComposer#LockableComposer(boolean) super}{@code (false)}</LI>
         <LI> <CODE><I>[{@link com.github.xbn.util.lock.LockableComposer super}]</I>.{@link com.github.xbn.util.lock.LockableComposer#forceUnlock() forceUnlock}()</CODE></LI>
      </OL></P>

      @see  #OneWayLockableComposer(boolean, OneWayLockableComposer) this(b,owlc)
      @see  #OneWayLockableComposer(OneWayLockable) this(owl)
    **/
   public OneWayLockableComposer()  {
      super(false);
   }
   /**
      <P>Create a new {@code OneWayLockableComposer}, as a duplicate of another.</P>

      <P>Calls {@link LockableComposer#LockableComposer(boolean, LockableComposer) super}{@code (ignored, to_copy)}.</P>
      @see  #OneWayLockableComposer(boolean) this(b)
    **/
   public OneWayLockableComposer(boolean ignored, OneWayLockableComposer to_copy)  {
      super(ignored, to_copy);
   }
   /**
      <P>Create a new {@code OneWayLockableComposer}, as a duplicate of another.</P>

      <P>Calls {@link LockableComposer#LockableComposer(Lockable) super}{@code (to_copy)}.</P>
      @see  #OneWayLockableComposer(boolean) this(b)
    **/
   public OneWayLockableComposer(OneWayLockable to_copy)  {
      super(to_copy);
   }
   /**
      <P>Lock--this returns <B>{@code null}</B> (must return &quot;{@code this}&quot; in sub-classes).</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.util.lock.LockableComposer super}]</I>.{@link com.github.xbn.util.lock.LockableComposer#lock(boolean) lock}(true)</CODE></P>
    **/
   public void lock()  {
      lock(true);
   }
//static...START
   public static final void lockIfNNull(OneWayLockable ow_l)  {
      if(ow_l != null)  {
         ow_l.lock();
      }
   }
//static...END
}
