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
	<P>{@code Lockable}s can prevent changes to mutable fields.</P>

	<H3>For classes that extend both {@code com.github.xbn.lang.Copyable} and {@code com.github.xbn.util.lock.Lockable}, the duplicate should always be unlocked.</H3>
 **/
public interface Lockable  {
	/**
		<P>Is the object locked?.</P>

		@see  #lock(boolean) lock(b)
	 **/
	boolean isLocked();
	/**
		<P>Lock or unlock the object.</P>

		@param  do_lock  If {@code true}, then lock the object. If {@code false}, unlock. Get with {@link #isLocked() isLocked}{@code ()}.
		@exception  LockException  If {@link #isLocked() isLocked}{@code ()} is {@code true}, and both {@code do_lock} and {@link #isUnlockable() isUnlockable}{@code ()} are {@code false}.
		@see  #isLocked()
	 **/
	void lock(boolean do_lock);

	/**
		<P>Is the object unlockable?.</P>
		@see  #lock(boolean) lock(b)
	 **/
	boolean isUnlockable();
}
