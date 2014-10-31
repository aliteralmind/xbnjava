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

package  com.github.xbn.number;
	import  com.github.xbn.lang.Invert;
	import  com.github.xbn.lang.Null;
	import  com.github.xbn.number.z.IntInRangeValidator_Cfg;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
	import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Convenience functions for creating {@code IntInRangeValidator}s.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewIntInRangeValidatorFor  {
   private NewIntInRangeValidatorFor()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	public static final IntInRangeValidator unrestricted(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
		return  range(NewIntInRangeFor.UNRESTRICTED,
			nnull, filter_offIfNull, dbgDest_ifNonNull);
	}
		private static final IntInRangeValidator range(IntInRange range, Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
			try  {
				return  new IntInRangeValidator_Cfg().nullOk(nnull.isOk()).
				filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).
				range(range).build();
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(nnull, "nnull", null, rx);
			}
		}
	public static final IntInRangeValidator exactly(Null nnull, Invert invert_dontIfNull, int min_andMax, String minMax_varName, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
		return  range(NewIntInRangeFor.exactly(invert_dontIfNull, min_andMax, minMax_varName),
			nnull, filter_offIfNull, dbgDest_ifNonNull);
	}
	public static final IntInRangeValidator impossible(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
		return  range(NewIntInRangeFor.IMPOSSIBLE,
			nnull, filter_offIfNull, dbgDest_ifNonNull);
	}
/*
	public static final IntInRangeValidator nullBad(IntInRange range, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
		try  {
			return  new IntInRangeValidator_Cfg().nullOk(false).range(range).filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).build();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
		}
	}
 */
}