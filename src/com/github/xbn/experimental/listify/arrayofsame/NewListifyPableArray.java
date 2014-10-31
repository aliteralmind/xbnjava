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
package  com.github.xbn.experimental.listify.arrayofsame;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer;
	import  com.github.xbn.array.primitive.PrimitiveArrayFromWrapper;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyBoolable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyByteable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyCharable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyDoubleable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyFloatable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyIntable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyLongable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyShortable;
	import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
	<P>Convenience functions for creating listifiers whose raw object is a primitive array, and whose virtual elements are of its wrapper-type (such as {@code int[]} and {@code java.lang.Integer}).</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewListifyPableArray  {
   private NewListifyPableArray()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<P>Create a new {@code ListifyBoolable}</P>

		@see  #forBoolean(boolean[]) forBoolean(b[])

		@return  {@code (new }{@link com.github.xbn.experimental.listify.arrayofsame.ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}{@code (prim_array))}
	 **/
	public static final ListifyBoolable forBoolean(boolean[] prim_array)  {
		return  (new ListifyBoolEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyCharable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyCharable forCharacter(char[] prim_array)  {
		return  (new ListifyCharEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyByteable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyByteable forByte(byte[] prim_array)  {
		return  (new ListifyPByteEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyShortable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyShortable forShort(short[] prim_array)  {
		return  (new ListifyPShortEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyIntable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyIntable forInteger(int[] prim_array)  {
		return  (new ListifyIntEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyLongable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyLongable forLong(long[] prim_array)  {
		return  (new ListifyPLongEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyFloatable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>
	 **/
	public static final ListifyFloatable forFloat(float[] prim_array)  {
		return  (new ListifyPFloatEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyDoubleable}</P>

		<P><I>All {@code for[Type](x[])} are derived from {@link #forBoolean(boolean[]) forBoolean(b[])}. <B>Do not change any function except {@code forBoolean(b[])}</B></I></P>

		@return  A class equivalent to <CODE>(new {@link ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}(prim_array))</CODE>

	 **/
	public static final ListifyDoubleable forDouble(double[] prim_array)  {
		return  (new ListifyPDoubleEArray(prim_array));
	}
	/**
		<P>Create a new {@code ListifyBoolable} for an array of {@code java.lang.Boolean}-s.</P>

		@see  #forBoolean(Boolean[]) forBoolean(B[])

		@return  {@code (new }{@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray}{@code (array))}
	 **/
	public static final ListifyBoolable forBoolean(Boolean[] array)  {
		return  (new ListifyBooleanEArray(array));
	}
	/**
		<P>Create a new {@code ListifyBoolable} for an array of {@code java.lang.Boolean}-s.</P>

		@return  {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}

		@see  #forBoolean(Boolean[]) forBoolean(B[])
	 **/
	public static final ListifyBoolable forBoolean(Boolean[] array, NullHandlerForPrimitives<Boolean> hnr_nb)  {
		return  (new ListifyBooleanEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyCharable} for an array of {@code java.lang.Character}-s.</P>

		@see  #forCharacter(Character[]) forCharacter(C[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyCharable forCharacter(Character[] array)  {
		return  (new ListifyCharacterEArray(array));
	}
	/**
		<P>Create a new {@code ListifyCharable} for an array of {@code java.lang.Character}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the char versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyCharable forCharacter(Character[] array, NullHandlerForPrimitives<Character> hnr_nb)  {
		return  (new ListifyCharacterEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyByteable} for an array of {@code java.lang.Byte}-s.</P>

		@see  #forByte(Byte[]) forByte(Y[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyByteable forByte(Byte[] array)  {
		return  (new ListifyByteEArray(array));
	}
	/**
		<P>Create a new {@code ListifyByteable} for an array of {@code java.lang.Byte}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the byte versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyByteable forByte(Byte[] array, NullHandlerForPrimitives<Byte> hnr_nb)  {
		return  (new ListifyByteEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyShortable} for an array of {@code java.lang.Short}-s.</P>

		@see  #forShort(Short[]) forShort(H[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyShortable forShort(Short[] array)  {
		return  (new ListifyShortEArray(array));
	}
	/**
		<P>Create a new {@code ListifyShortable} for an array of {@code java.lang.Short}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the short versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyShortable forShort(Short[] array, NullHandlerForPrimitives<Short> hnr_nb)  {
		return  (new ListifyShortEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyIntable} for an array of {@code java.lang.Integer}-s.</P>

		@see  #forInteger(Integer[]) forInteger(I[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyIntable forInteger(Integer[] array)  {
		return  (new ListifyIntegerEArray(array));
	}
	/**
		<P>Create a new {@code ListifyIntable} for an array of {@code java.lang.Integer}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the int versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyIntable forInteger(Integer[] array, NullHandlerForPrimitives<Integer> hnr_nb)  {
		return  (new ListifyIntegerEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyLongable} for an array of {@code java.lang.Long}-s.</P>

		@see  #forLong(Long[]) forLong(L[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyLongable forLong(Long[] array)  {
		return  (new ListifyLongEArray(array));
	}
	/**
		<P>Create a new {@code ListifyLongable} for an array of {@code java.lang.Long}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the long versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyLongable forLong(Long[] array, NullHandlerForPrimitives<Long> hnr_nb)  {
		return  (new ListifyLongEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyFloatable} for an array of {@code java.lang.Float}-s.</P>

		@see  #forFloat(Float[]) forFloat(F[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyFloatable forFloat(Float[] array)  {
		return  (new ListifyFloatEArray(array));
	}
	/**
		<P>Create a new {@code ListifyFloatable} for an array of {@code java.lang.Float}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the float versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyFloatable forFloat(Float[] array, NullHandlerForPrimitives<Float> hnr_nb)  {
		return  (new ListifyFloatEArray(array, hnr_nb));
	}
	/**
		<P>Create a new {@code ListifyDoubleable} for an array of {@code java.lang.Double}-s.</P>

		@see  #forDouble(Double[]) forDouble(D[])

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[]) ListifyBooleanEArray(array)}
	 **/
	public static final ListifyDoubleable forDouble(Double[] array)  {
		return  (new ListifyDoubleEArray(array));
	}
	/**
		<P>Create a new {@code ListifyDoubleable} for an array of {@code java.lang.Double}-s.</P>

		<P><I>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBoolean(Boolean[]) forBoolean(B[])} and {@link #forBoolean(Boolean[], NullHandlerForPrimitives) forBoolean(B[],hnvnb)}. <B>Do not edit any function except the double versions.</B></I></P>

		@return  The equivalent of {@link com.github.xbn.experimental.listify.arrayofsame.ListifyBooleanEArray#ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) ListifyBooleanEArray(array, hnr_nb)}
	 **/
	public static final ListifyDoubleable forDouble(Double[] array, NullHandlerForPrimitives<Double> hnr_nb)  {
		return  (new ListifyDoubleEArray(array, hnr_nb));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyCharEArray extends AbstractListifyPrimitiveEArray<Character> implements ListifyCharable  {
	public ListifyCharEArray(char[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)));
	}
	public ListifyCharEArray(ListifyCharEArray to_copy)  {
		super(to_copy);
	}
	public final char[] getRawPArray()  {
		return  (char[])getRawObject();
	}
	public final char[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (char[])super.getPArrayCopyOrNull(nnull);
	}
	public final char getChar(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyCharEArray getObjectCopy()  {
		return  (new ListifyCharEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyPByteEArray extends AbstractListifyPrimitiveEArray<Byte> implements ListifyByteable  {
	public ListifyPByteEArray(byte[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forByte(), (new OneParamCnstrValueCopier<Byte>(Byte.class)));
	}
	public ListifyPByteEArray(ListifyPByteEArray to_copy)  {
		super(to_copy);
	}
	public final byte[] getRawPArray()  {
		return  (byte[])getRawObject();
	}
	public final byte[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (byte[])super.getPArrayCopyOrNull(nnull);
	}
	public final byte getPByte(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyPByteEArray getObjectCopy()  {
		return  (new ListifyPByteEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyPShortEArray extends AbstractListifyPrimitiveEArray<Short> implements ListifyShortable  {
	public ListifyPShortEArray(short[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forShort(), (new OneParamCnstrValueCopier<Short>(Short.class)));
	}
	public ListifyPShortEArray(ListifyPShortEArray to_copy)  {
		super(to_copy);
	}
	public final short[] getRawPArray()  {
		return  (short[])getRawObject();
	}
	public final short[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (short[])super.getPArrayCopyOrNull(nnull);
	}
	public final short getPShort(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyPShortEArray getObjectCopy()  {
		return  (new ListifyPShortEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyIntEArray extends AbstractListifyPrimitiveEArray<Integer> implements ListifyIntable  {
	public ListifyIntEArray(int[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forInteger(), (new OneParamCnstrValueCopier<Integer>(Integer.class)));
	}
	public ListifyIntEArray(ListifyIntEArray to_copy)  {
		super(to_copy);
	}
	public final int[] getRawPArray()  {
		return  (int[])getRawObject();
	}
	public final int[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (int[])super.getPArrayCopyOrNull(nnull);
	}
	public final int getInt(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyIntEArray getObjectCopy()  {
		return  (new ListifyIntEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyPLongEArray extends AbstractListifyPrimitiveEArray<Long> implements ListifyLongable  {
	public ListifyPLongEArray(long[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forLong(), (new OneParamCnstrValueCopier<Long>(Long.class)));
	}
	public ListifyPLongEArray(ListifyPLongEArray to_copy)  {
		super(to_copy);
	}
	public final long[] getRawPArray()  {
		return  (long[])getRawObject();
	}
	public final long[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (long[])super.getPArrayCopyOrNull(nnull);
	}
	public final long getPLong(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyPLongEArray getObjectCopy()  {
		return  (new ListifyPLongEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyPFloatEArray extends AbstractListifyPrimitiveEArray<Float> implements ListifyFloatable  {
	public ListifyPFloatEArray(float[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forFloat(), (new OneParamCnstrValueCopier<Float>(Float.class)));
	}
	public ListifyPFloatEArray(ListifyPFloatEArray to_copy)  {
		super(to_copy);
	}
	public final float[] getRawPArray()  {
		return  (float[])getRawObject();
	}
	public final float[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (float[])super.getPArrayCopyOrNull(nnull);
	}
	public final float getPFloat(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyPFloatEArray getObjectCopy()  {
		return  (new ListifyPFloatEArray(this));
	}
}
/**
	<P><I>All {@code Listify<I>[Type]</I>Array} classes are derived from {@link ListifyBoolEArray}. <B>Do not edit any class except {@code ListifyBoolEArray}.</B></I></P>
 **/
class ListifyPDoubleEArray extends AbstractListifyPrimitiveEArray<Double> implements ListifyDoubleable  {
	public ListifyPDoubleEArray(double[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forDouble(), (new OneParamCnstrValueCopier<Double>(Double.class)));
	}
	public ListifyPDoubleEArray(ListifyPDoubleEArray to_copy)  {
		super(to_copy);
	}
	public final double[] getRawPArray()  {
		return  (double[])getRawObject();
	}
	public final double[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  (double[])super.getPArrayCopyOrNull(nnull);
	}
	public final double getPDouble(int index)  {
		try  {
			return  getRawPArray()[index];
		}  catch(RuntimeException rx)  {
			ciArrayNullOrBadIndex(index);
			throw  rx;
		}
	}
	public ListifyPDoubleEArray getObjectCopy()  {
		return  (new ListifyPDoubleEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyCharacterEArray extends AbstractListifyPWrapperEArray<Character> implements ListifyCharable  {
	public ListifyCharacterEArray(Character[] array)  {
		super(array, NewPrimitiveArrayHelper.forCharacter(), Character.class);
	}
	public ListifyCharacterEArray(Character[] array, NullHandlerForPrimitives<Character> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forCharacter(), Character.class, hnr_nb);
	}
	public ListifyCharacterEArray(ListifyCharacterEArray to_copy)  {
		super(to_copy);
	}
 	public final char[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public char getChar(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).charValue();
	}
	public ListifyCharacterEArray getObjectCopy()  {
		return  (new ListifyCharacterEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyByteEArray extends AbstractListifyPWrapperEArray<Byte> implements ListifyByteable  {
	public ListifyByteEArray(Byte[] array)  {
		super(array, NewPrimitiveArrayHelper.forByte(), Byte.class);
	}
	public ListifyByteEArray(Byte[] array, NullHandlerForPrimitives<Byte> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forByte(), Byte.class, hnr_nb);
	}
	public ListifyByteEArray(ListifyByteEArray to_copy)  {
		super(to_copy);
	}
 	public final byte[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public byte getPByte(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).byteValue();
	}
	public ListifyByteEArray getObjectCopy()  {
		return  (new ListifyByteEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyShortEArray extends AbstractListifyPWrapperEArray<Short> implements ListifyShortable  {
	public ListifyShortEArray(Short[] array)  {
		super(array, NewPrimitiveArrayHelper.forShort(), Short.class);
	}
	public ListifyShortEArray(Short[] array, NullHandlerForPrimitives<Short> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forShort(), Short.class, hnr_nb);
	}
	public ListifyShortEArray(ListifyShortEArray to_copy)  {
		super(to_copy);
	}
 	public final short[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public short getPShort(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).shortValue();
	}
	public ListifyShortEArray getObjectCopy()  {
		return  (new ListifyShortEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyIntegerEArray extends AbstractListifyPWrapperEArray<Integer> implements ListifyIntable  {
	public ListifyIntegerEArray(Integer[] array)  {
		super(array, NewPrimitiveArrayHelper.forInteger(), Integer.class);
	}
	public ListifyIntegerEArray(Integer[] array, NullHandlerForPrimitives<Integer> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forInteger(), Integer.class, hnr_nb);
	}
	public ListifyIntegerEArray(ListifyIntegerEArray to_copy)  {
		super(to_copy);
	}
 	public final int[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public int getInt(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).intValue();
	}
	public ListifyIntegerEArray getObjectCopy()  {
		return  (new ListifyIntegerEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyLongEArray extends AbstractListifyPWrapperEArray<Long> implements ListifyLongable  {
	public ListifyLongEArray(Long[] array)  {
		super(array, NewPrimitiveArrayHelper.forLong(), Long.class);
	}
	public ListifyLongEArray(Long[] array, NullHandlerForPrimitives<Long> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forLong(), Long.class, hnr_nb);
	}
	public ListifyLongEArray(ListifyLongEArray to_copy)  {
		super(to_copy);
	}
 	public final long[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public long getPLong(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).longValue();
	}
	public ListifyLongEArray getObjectCopy()  {
		return  (new ListifyLongEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyFloatEArray extends AbstractListifyPWrapperEArray<Float> implements ListifyFloatable  {
	public ListifyFloatEArray(Float[] array)  {
		super(array, NewPrimitiveArrayHelper.forFloat(), Float.class);
	}
	public ListifyFloatEArray(Float[] array, NullHandlerForPrimitives<Float> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forFloat(), Float.class, hnr_nb);
	}
	public ListifyFloatEArray(ListifyFloatEArray to_copy)  {
		super(to_copy);
	}
 	public final float[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public float getPFloat(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).floatValue();
	}
	public ListifyFloatEArray getObjectCopy()  {
		return  (new ListifyFloatEArray(this));
	}
}
/**
	<P><I>All these internal classes are derived from {@code ListifyBooleanEArray}. <B>Do not edit any classes except {@code ListifyBooleanEArray}</B>.</I></P>
 **/
class ListifyDoubleEArray extends AbstractListifyPWrapperEArray<Double> implements ListifyDoubleable  {
	public ListifyDoubleEArray(Double[] array)  {
		super(array, NewPrimitiveArrayHelper.forDouble(), Double.class);
	}
	public ListifyDoubleEArray(Double[] array, NullHandlerForPrimitives<Double> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forDouble(), Double.class, hnr_nb);
	}
	public ListifyDoubleEArray(ListifyDoubleEArray to_copy)  {
		super(to_copy);
	}
 	public final double[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public double getPDouble(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).doubleValue();
	}
	public ListifyDoubleEArray getObjectCopy()  {
		return  (new ListifyDoubleEArray(this));
	}
}
