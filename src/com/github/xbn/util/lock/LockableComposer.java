/*license*\
   XBN-Java Library

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
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For classes needing to implement {@code Lockable}, that cannot extend {@code AbstractLockable}.</P>

   <H3>Implementation template (view source)</H3>
 **/
public class LockableComposer  {
   //state
      private boolean bLkd = false;
      private boolean bUnlkbl = false;

   /**
      <P>Create a new {@code LockableComposer}.</P>

      <P>This<OL>
         <LI>Sets {@link #isUnlockable() isUnlockable}{@code ()} to {@code is_unlockable}.</LI>
         <LI>Sets {@link #isLocked() isLocked}{@code ()} to {@code false}.</LI>
      </OL></P>

      @see  #LockableComposer(boolean, LockableComposer) this(b,lc)
      @see  #LockableComposer(Lockable) LockableComposer(lkbl)
    **/
   public LockableComposer(boolean is_unlockable)  {
      bUnlkbl = is_unlockable;
      bLkd = false;
   }
   /**
      <P>Create a new {@code LockableComposer} from a {@code Lockable} object.</P>

      <P>This<OL>
         <LI>Sets {@link #isUnlockable() isUnlockable}{@code ()} to {@code to_copy.isUnlockable()}</LI>
         <LI>Sets {@link #isLocked() isLocked}{@code ()} to {@code false}.</LI>
      </OL></P>
      @see  #LockableComposer(boolean) this(b)
    **/
   public LockableComposer(boolean ignored, LockableComposer to_copy)  {
      try  {
         bUnlkbl = to_copy.isUnlockable();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }

      //Never ever call interface functions, directly or indirectly, in a constructor.
      zlockLB(false);
   }
   /**
      <P>Create a new {@code LockableComposer} from a {@code Lockable} object.</P>

      <P>This<OL>
         <LI>Sets {@link #isUnlockable() isUnlockable}{@code ()} to {@code to_copy.isUnlockable()}</LI>
         <LI>Sets {@link #isLocked() isLocked}{@code ()} to {@code false}.</LI>
      </OL></P>
      @see  #LockableComposer(boolean) this(b)
    **/
   public LockableComposer(Lockable to_copy)  {
      try  {
         bUnlkbl = to_copy.isUnlockable();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }

      //Never ever call interface functions, directly or indirectly, in a constructor.
      zlockLB(false);
   }
   /**
      <P>Can it be unlocked?.</P>

      @return  {@code true}  If it is safe to call {@link #unlock() unlock}{@code ()}
      @see  #LockableComposer(boolean) this(b)
      @see  #forceUnlock_4prot()
    **/
   public boolean isUnlockable()  {
      return  bUnlkbl;
   }
   /**
      <P>Is it locked?.</P>

      @return  <UL>
         <LI><B>{@code true}</B> If {@link #lock(boolean) lock}{@code (b)} was called (more recently than {@link #forceUnlock_4prot() forceUnlock_4prot}{@code ()}).</LI>
         <LI><B>{@code false}</B> If otherwise.</LI>
      </UL>
    **/
   public boolean isLocked()  {
      return  bLkd;
   }
   public void lock()  {
      lock(true);
   }
   public void lock(boolean do_lock)  {
      zlockLB(do_lock);
   }
   protected final void zlockLB(boolean do_lock)  {
      if(isLocked()  &&  !isUnlockable()  &&  !do_lock)  {
         throw  new IllegalStateException("Cannot unlock. isLocked()=" + isLocked() + ", isUnlockable()=" + isUnlockable() + ", do_lock=" + do_lock);
      }

      bLkd = do_lock;
   }
   /**
      <P>Crash if this {@code LockableComposer} is locked.</P>

      @exception  LockException  If {@link #isLocked() isLocked}{@code ()} is {@code true}.

      @see
         <LI>{@link #ciNotLocked() ciNotLocked}{@code ()}</LI>
      </UL>
    **/
   public void ciLocked_4prot()  {
      if(isLocked())  {
         throw  new LockException("isLocked() is true");
      }
   }
   /**
      <P>Crash if this {@code LockableComposer} is unlocked.</P>

      @exception  LockException  If {@link #isLocked() isLocked}{@code ()} is {@code false}.
      @see  #ciLocked(String) ciLocked(s)
    **/
   public void ciNotLocked_4prot()  {
      if(!isLocked())  {
         throw  new LockException("isLocked() is false");
      }
   }
   /**
      <P>Forces {@code isLocked()} to be {@code false}, regardless the value of {@code isUnlockable()}.</P>

      <P>Sets {@link #isLocked() isLocked}{@code ()} to {@code false}.</P>
    **/
   public void forceUnlock_4prot()  {
      bLkd = false;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append("isLocked()=").append(isLocked()).append(", isUnlockable()=").append(isUnlockable());
   }
//static...START
   public static final void lockIfNNull(Lockable lk_bl, boolean do_lock)  {
      if(lk_bl != null)  {
         lk_bl.lock(do_lock);
      }
   }
//static...END
}

