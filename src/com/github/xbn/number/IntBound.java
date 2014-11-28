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
package  com.github.xbn.number;
	import  com.github.xbn.lang.CrashIfObject;
/**
 * <P>{@code NumberBound} for ints.</P>
 * since 0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntBound extends NumberBound<Integer>  {
	/**
	 * @deprecated Use {@link #IntBound(Integer, com.github.xbn.number.Inclusive, java.lang.String) IntBound}{@code (num, is_inclusive, name)}
	 * @since  0.1.4.2
	 */
	public IntBound(Integer num, boolean is_inclusive, String name)  {
		super(num, is_inclusive, name);
	}
	/**
	 * <P>Create a new {@code IntBound}.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp;  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NumberBound#NumberBound(N, boolean, String)">super</A>(num, is_inclusive, name)</CODE></P>
	 * @since  0.1.4.2
	 **/
	public IntBound(Integer num, Inclusive incl, String name)  {
		super(num, incl, name);
	}
	/**
	 * <P>Create a new {@code IntBound} as a duplicate of another.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; {@link NumberBound#NumberBound(NumberBound) super}{@code (to_copy)}</P>
	 * @param  to_copy  May not be {@code null}.
	 **/
	public IntBound(IntBound to_copy)  {
		super(to_copy);
	}
	/**
	 * <P>Get the number as an int.</P>
	 * @return  <CODE>{@link NumberBound#get() get}()*.{@link java.lang.Integer#intValue() intValue}()</CODE>
	 **/
	public int getInt()  {
		return  get().intValue();
	}
	public Integer getGivenIncl(BoundSide min_orMax)  {
		try  {
			return  (isInclusive() ? get() :
				(min_orMax.isMin()
					?  (get() + 1)
					:  (get() - 1)));
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(min_orMax, "min_orMax", null, rx);
		}
	}
	public Integer getInclComparedTo(BoundSide min_orMax, Integer num)  {
		try  {
			return  getGivenIncl(min_orMax).intValue() - num.intValue();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
		}
	}
}
