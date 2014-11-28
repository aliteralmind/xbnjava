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
package  com.github.xbn.examples.io;
	import  com.github.xbn.io.NewTextAppenterFor;
	import  com.github.xbn.io.TextAppenter;
/**
	<P>Basic demonstration of using {@code TextAppenter} to optionally debug an object.</P>

	<P>{@code java com.github.xbn.examples.io.TextAppenterObjectDebugging}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TextAppenterObjectDebugging  {
	public static final void main(String[] params)  {
		new AnObjectThatNeedsDebugging(1, null).doSomeComplicatedStuff();
		new AnObjectThatNeedsDebugging(2, System.out).doSomeComplicatedStuff();
	}
}
class AnObjectThatNeedsDebugging  {
	private final int id;
	private final TextAppenter dbgAptr;
	public AnObjectThatNeedsDebugging(int id, Appendable debug_ifNonNull)  {
		this.id = id;
		dbgAptr = NewTextAppenterFor.appendableUnusableIfNull(debug_ifNonNull);
	}
	public void doSomeComplicatedStuff()  {
		if(dbgAptr.isUseable())  {
			dbgAptr.appentln("[id=" + id +
			   "] About to do some complicated stuff...");
		}

		//complicated stuff goes here

		if(dbgAptr.isUseable())  {
			dbgAptr.appentln("[id=" + id + "] DONE");
		}
	}
}