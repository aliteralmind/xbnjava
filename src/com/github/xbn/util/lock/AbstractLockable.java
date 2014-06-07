/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com
   
   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   <P>Abstract implementation of {@code Lockable}. For classes needing to implement {@code Lockable}, but cannot extend this class, use {@link com.github.xbn.util.lock.LockableComposer LockableComposer}.</P>
 **/
public abstract class AbstractLockable implements Lockable  {
   private LockableComposer lc = null;
   /**
      <P>Create a new {@code AbstractLockable}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.util.lock.LockableComposer#LockableComposer(boolean) super}{@code (is_unlockable)}</P>
    **/
   public AbstractLockable(boolean is_unlockable)  {
      lc = new LockableComposer(is_unlockable);
   }
   /**
      <P>Create a new {@code AbstractLockable} from a {@code Lockable} object.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.util.lock.LockableComposer#LockableComposer(Lockable) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #AbstractLockable(boolean, boolean) this(b,b)
    **/
   public AbstractLockable(Lockable to_copy)  {
      lc = new LockableComposer(to_copy);
   }
   protected void forceUnlock()  {
      lc.forceUnlock_4prot();
   }
   /**
      <P>Crash if this {@code LockableComposer} is locked.</P>
    **/
   protected void ciLocked()  {
      lc.ciLocked_4prot();
   }
   /**
      <P>Crash if this {@code LockableComposer} is unlocked.</P>
    **/
   protected void ciNotLocked()  {
      lc.ciNotLocked_4prot();
   }
   public boolean isUnlockable()  {
      return  lc.isUnlockable();
   }
   public boolean isLocked()  {
      return  lc.isLocked();
   }
   public void lock()  {
      lc.lock();
   }
   public void lock(boolean do_lock)  {
      lc.lock(do_lock);
   }
   public String toString()  {
      return  lc.toString();
   }
}
