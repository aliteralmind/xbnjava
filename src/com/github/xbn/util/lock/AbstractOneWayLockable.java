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
	<P>Abstract implementation of {@code OneWayLockable}. For classes needing to implement {@code OneWayLockable}, but cannot extend this class, use {@link com.github.xbn.util.lock.OneWayLockableComposer OneWayLockableComposer}.</P>
 **/
public abstract class AbstractOneWayLockable extends AbstractLockable implements OneWayLockable  {
	/**
		<P>Create a new {@code AbstractOneWayLockable}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.util.lock.AbstractLockable#AbstractLockable(boolean) super}{@code (false)}</P>

		@see  #AbstractOneWayLockable(OneWayLockable, boolean) this(owl,b)
	 **/
	public AbstractOneWayLockable()  {
		super(false);
	}
	/**
		<P>Create a new {@code AbstractOneWayLockable} from a {@code OneWayLockable}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.util.lock.AbstractLockable#AbstractLockable(Lockable) super}{@code (to_copy)}</P>
		@see  #AbstractOneWayLockable(boolean) this(b)
	 **/
	public AbstractOneWayLockable(OneWayLockable to_copy)  {
		super(to_copy);
	}
	public void lock()  {
		lock(true);
	}
}
