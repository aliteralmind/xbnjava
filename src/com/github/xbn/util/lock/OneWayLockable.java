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
   <p>A {@code Lockable} that cannot be unlocked.</p>
 **/
public interface OneWayLockable extends Lockable  {
   /**
    * @return  <b>{@code false}</b>
    */
   boolean isUnlockable();

   /**
      <p>Shortcut for {@code lock(true)}</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>(OneWayLockable){@link com.github.xbn.util.lock.Lockable super}.{@link com.github.xbn.util.lock.Lockable#lock(boolean) lock}(true)</code></p>
    */
   void lock();
}
