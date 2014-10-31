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
	import  com.github.xbn.regexutil.IgnoreCase;
	import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
	import  com.github.xbn.io.DebugLevel;
	import  com.github.xbn.io.TextAppenter;
/**
	<P>Basic demonstration of {@code TextAppenter}</P>

	<P>{@code java com.github.xbn.examples.io.TextAppenterWithLevelsAppExample debugoff}
<BR>{@code java com.github.xbn.examples.io.TextAppenterWithLevelsAppExample debugminimal}
<BR>{@code java com.github.xbn.examples.io.TextAppenterWithLevelsAppExample debugverbose}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TextAppenterWithLevelsAppExample  {
	private static final int DEBUG_LEVEL_PARAM_IDX = 0;
	public static final void main(String[] params)  {
		DebugLevel dbgLvl = GetFromCommandLineAtIndex.
			enumValue(params, DEBUG_LEVEL_PARAM_IDX,
				DebugLevel.OFF, IgnoreCase.YES, null,
				"debugoff", "debugminimal", "debugverbose", null, null, null);

		TextAppenter dbgAptrMin = (dbgLvl.isOff()
			?  TextAppenter.UNUSABLE
			:  TextAppenter.CONSOLE);
		TextAppenter dbgAptrVerbose = (dbgLvl.isOnAndAtLeast(2)
			?  TextAppenter.CONSOLE
			:  TextAppenter.UNUSABLE);

		if(dbgAptrMin.isUseable())  {
			dbgAptrMin.appentln(params[DEBUG_LEVEL_PARAM_IDX] +
				" --> DebugLevel." + dbgLvl);
			dbgAptrMin.appentln("Minimally-important debugging information goes here...");
		}

		if(dbgAptrVerbose.isUseable())  {
			dbgAptrVerbose.appentln("Very very verbose and highly-important debugging information...");
		}
	}
}