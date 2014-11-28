/*license*\
	XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

	Copyright (C) 2014, Jeff Epstein

	This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

	This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)		(*Two tabs plus this comment, to force this phrase to be (a) imported, and (b) with NO autotext*)
\*license*/
package  com.github.xbn.array.primitive;
	import  com.github.xbn.array.z.XbnIbxBase_Cfg;
	import  com.github.xbn.lang.CrashIfObject;
/**
	<P>Determine if an object is a primitive or wrapper array, and get the length of an object known to be a primitive array.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ObjThatIsPrimitiveArrayUtil  {
//internal
	private static final Class<?>[] clsWRAPPER_ARRAY_TYPES = {
		Boolean[].class, Character[].class,
		Byte[].class, Short[].class, Integer[].class,
		Long[].class, Float[].class, Double[].class};
	private static final Class<?>[] clsPRIMITIVE_ARRAY_TYPES = {
		boolean[].class, char[].class,
		byte[].class, short[].class, int[].class,
		long[].class, float[].class, double[].class};
	private ObjThatIsPrimitiveArrayUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<P>Get the length of a primitive array <I>as held in an object</I>.</P>

		@return  <CODE>{@link #getLengthFromUnknownAsObject(Object, String, Object) getLengthFromUnknownAsObject}(objThatIs_primArray, &quot;objThatIs_primArray&quot;, null)</CODE>
	 **/
	public static final int getLengthFromUnknownAsObject(Object objThatIs_primArray)  {
		return  getLengthFromUnknownAsObject(objThatIs_primArray, "objThatIs_primArray", null);
	}
	/**
		<P>Get the length of a primitive array <I>as held in an object</I>.</P>

		<P><I>This function originates in {@link com.github.xbn.array.z.XbnIbxBase_Cfg XbnIbxBase_Cfg} because that class must be compiled before this one.</I></P>

		@param  objThatIs_primArray  May not be {@code null}, and must be a primitive array.
		@param  obj_name  Descriptive name of {@code objThatIs_primArray}. <I>Should</I> not be {@code null} or empty.
		@param  xtra_errInfo  Optional extra information for the potential error message.
		@return  <CODE>{@link com.github.xbn.array.z.XbnIbxBase_Cfg XbnIbxBase_Cfg}.{@link com.github.xbn.array.z.XbnIbxBase_Cfg#getLengthFromUnknownAsObject(Object, String, Object) getLengthFromUnknownAsObject}(objThatIs_primArray, obj_name, xtra_errInfo)</CODE>
		@see  #getLengthFromUnknownAsObject(Object)
	 **/
	public static final int getLengthFromUnknownAsObject(Object objThatIs_primArray, String obj_name, Object xtra_errInfo)  {
		return  XbnIbxBase_Cfg.getLengthFromUnknownAsObject(objThatIs_primArray, obj_name, xtra_errInfo);
	}
	/**
		<P>Is the provided object actually an array of primitives?.</P>

		@param  objThatMayBe_primArray  May not be {@code null}.
		@return  {@link #isPrimitiveType(Class) isPrimitiveType}{@code (objThatMayBe_primArray.getClass())}
	 **/
	public static final boolean isPrimitive(Object objThatMayBe_primArray)  {
		try  {
			return  isPrimitiveType(objThatMayBe_primArray.getClass());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(objThatMayBe_primArray, "objThatMayBe_primArray", null, rx);
		}
	}
	/**
		<P>Is a class-type a primitive array?</P>

		<P>Idea from (viewed 12/5/2013)
		<BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/5606338/cast-primitive-type-array-into-object-array-in-java/">http://stackoverflow.com/questions/5606338/cast-primitive-type-array-into-object-array-in-java/</A></CODE></P>

		@return  {@code true}  If
		<BR> &nbsp; &nbsp; {@code objThatMayBe_primArray.getClass().isAssignableFrom(clsPType)}
		<BR>is {@code true}, where {@code clsPType} is equal to one of the following:<UL>
			<LI>{@code boolean[].class}, {@code char[].class}</LI>
			<LI>{@code byte[].class}, {@code short[].class}, {@code int[].class}, {@code long[].class}</LI>
			<LI>{@code float[].class}, {@code double[].class}</LI>
		</UL>
		@see  #isPrimitive(Object)
	 **/
	public static final boolean isPrimitiveType(Class<?> clss)  {
		try  {
			for(Class<?> clsPType : clsPRIMITIVE_ARRAY_TYPES){
				if(clss.isAssignableFrom(clsPType)){
					return  true;
				}
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(clss, "clss", null, rx);
		}
		return  false;
	}
	public static final boolean isWrapper(Object objThatMayBeAPWArray)  {
		try  {
			return  isWrapperType(objThatMayBeAPWArray.getClass());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(objThatMayBeAPWArray, "objThatMayBeAPWArray", null, rx);
		}
	}
	public static final boolean isWrapperType(Class<?> clss)  {
		try  {
			for(Class<?> clsPType : clsWRAPPER_ARRAY_TYPES){
				if(clss.isAssignableFrom(clsPType)){
					return  true;
				}
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(clss, "clss", null, rx);
		}
		return  false;
	}
}
