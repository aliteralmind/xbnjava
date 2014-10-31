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
package  com.github.xbn.array.primitive;
	import  com.github.xbn.array.CrashIfIndex;
/**
	<P>If an object that is <I>known to be a primitive array</I> is {@code null}, or the index for it is invalid, crash--otherwise <I>return</I> the causing error.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CrashIfObjThatIsPrimitiveArray  {
	/**
		<P>If an object that is <I>known to be a primitive array</I> is {@code null}, or the index for it is invalid, crash--otherwise <I>return</I> the causing error.</P>

		@param  objThatIsAPArray  If non-{@code null}, must be an array of a primitive type ({@code boolean}, {@code char}, {@code int}, ...).
		@see  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil#isPrimitiveType(Class) isPrimitiveType(cls)
	 **/
	public static final void nullOrBadIndex(Object objThatIsAPArray, int index, String idx_name, String obj_name)  {
		if(objThatIsAPArray == null)  {
			throw  new NullPointerException(obj_name);
		}
		int iLen = -1;
		if(objThatIsAPArray instanceof boolean[])  {
			iLen = ((boolean[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof char[])  {
			iLen = ((char[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof byte[])  {
			iLen = ((byte[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof short[])  {
			iLen = ((short[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof int[])  {
			iLen = ((int[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof long[])  {
			iLen = ((long[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof float[])  {
			iLen = ((float[])objThatIsAPArray).length;
		}  else if(objThatIsAPArray instanceof double[])  {
			iLen = ((double[])objThatIsAPArray).length;
		}  else  {
			throw  new IllegalArgumentException(obj_name + " should be a primitive array, but is a " + objThatIsAPArray.getClass().getName());
		}

		CrashIfIndex.badForLength(index, iLen, idx_name, obj_name);
	}
	private CrashIfObjThatIsPrimitiveArray()  {
		throw  new IllegalStateException("Do not instantiate.");
	}
}