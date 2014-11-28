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
package  com.github.xbn.experimental.listify;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyIntable;
	import  com.github.xbn.experimental.listify.backend.AbstractListifyPArrayDigitLengths;
	import  java.util.Iterator;
	import  java.util.List;
	import  com.github.xbn.array.NewArrayIterator;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.list.ListUtil;
	import  com.github.xbn.experimental.listify.backend.ListifyListOfToStringLengths;
	import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyIntable;
	import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyPrimitiveable;
	import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
	import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
	import  com.github.xbn.util.copyval.SimpleNullHandler;
/**
	<P>Convenience functions for creating listifiers whose virtual elements are <I>lengths</I> of the elements in the raw object.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewListifyIntLengths  {
   private NewListifyIntLengths()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	public static final <R> ListifyIntable forListOfToStringLengths(List<R> list)  {
		return  (new ListifyListOfToStringLengths<R>(list));
	}
	public static final <R> ListifyIntable forListOfToStringLengths(List<R> list, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyListOfToStringLengths<R>(list, null_handler));
	}
	public static final <R> ListifyIntable forListOfNonPArrayLengths(List<R[]> list)  {
		return  (new ListifyListOfNonPArraysLengths<R>(list));
	}
	public static final <R> ListifyIntable forListOfNonPArrayLengths(List<R[]> list, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyListOfNonPArraysLengths<R>(list, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(byte[] obj_thatIsPrimArr)  {
		return  (new ListifyPByteArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(byte[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyPByteArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(int[] obj_thatIsPrimArr)  {
		return  (new ListifyIntArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(int[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyIntArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(long[] obj_thatIsPrimArr)  {
		return  (new ListifyPLongArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(long[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyPLongArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(float[] obj_thatIsPrimArr)  {
		return  (new ListifyPFloatArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(float[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyPFloatArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(double[] obj_thatIsPrimArr)  {
		return  (new ListifyPDoubleArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(double[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyPDoubleArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
	public static final ListifyIntable forPArrayDigitLengths(short[] obj_thatIsPrimArr)  {
		return  (new ListifyPShortArrayDigitLengths(obj_thatIsPrimArr));
	}
	public static final ListifyIntable forPArrayDigitLengths(short[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyPShortArrayDigitLengths(obj_thatIsPrimArr, null_handler));
	}
}
class ListifyListOfNonPArraysLengths<R> extends AbstractListifyIntable  {
	public ListifyListOfNonPArraysLengths(List<R[]> list)  {
		super(list);
	}
	public ListifyListOfNonPArraysLengths(List<R[]> list, NullHandlerForPrimitives<Integer> null_handler)  {
		super(list, null_handler);
	}
	public ListifyListOfNonPArraysLengths(ListifyListOfNonPArraysLengths<R> to_copy)  {
		super(to_copy);
	}
	@SuppressWarnings("unchecked")
	public List<R[]> getRawLOArrays()  {
		return  (List<R[]>)getRawObject();
	}
	public final int getSizeNPXOkay()  {
		return  getRawLOArrays().size();
	}
	public final int getInt(int index)  {
		R[] ae = null;
		try  {
			ae = getRawLOArrays().get(index);
		}  catch(RuntimeException rx)  {
			ciRawObjectNullOrBadIndex(index);
			throw  rx;
		}
		Integer I = ((ae == null) ? null : ae.length);
		return  SimpleNullHandler.getCopyCIOrigNullAndActionCrashOrDel(getNullHandlerForPrimitives(), I);
	}
	public ListifyListOfNonPArraysLengths<R> getObjectCopy()  {
		return  (new ListifyListOfNonPArraysLengths<R>(this));
	}
	public final Iterator<Integer> iterator()  {
		try  {
			return  ListUtil.newIteratorForListOfArraysLengths(getRawLOArrays());
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
}

/**
<!--
---nwrqm input---
PByte byte Byte
PDouble double Double
PFloat float Float
PLong long Long
Int int Integer
PShort short Short
 -->
 **/
class ListifyPByteArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Byte>  {
//constructors...START
	public ListifyPByteArrayDigitLengths(byte[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forByte());
	}
	public ListifyPByteArrayDigitLengths(byte[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forByte(), null_handler);
	}
	public ListifyPByteArrayDigitLengths(ListifyPByteArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyPByteArrayDigitLengths getObjectCopy()  {
		return  (new ListifyPByteArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((byte[])getRawObject());
	}
}
class ListifyPShortArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Short>  {
//constructors...START
	public ListifyPShortArrayDigitLengths(short[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forShort());
	}
	public ListifyPShortArrayDigitLengths(short[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forShort(), null_handler);
	}
	public ListifyPShortArrayDigitLengths(ListifyPShortArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyPShortArrayDigitLengths getObjectCopy()  {
		return  (new ListifyPShortArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((short[])getRawObject());
	}
}
class ListifyIntArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Integer>  {
//constructors...START
	public ListifyIntArrayDigitLengths(int[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forInteger());
	}
	public ListifyIntArrayDigitLengths(int[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forInteger(), null_handler);
	}
	public ListifyIntArrayDigitLengths(ListifyIntArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyIntArrayDigitLengths getObjectCopy()  {
		return  (new ListifyIntArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((int[])getRawObject());
	}
}
class ListifyPLongArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Long>  {
//constructors...START
	public ListifyPLongArrayDigitLengths(long[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forLong());
	}
	public ListifyPLongArrayDigitLengths(long[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forLong(), null_handler);
	}
	public ListifyPLongArrayDigitLengths(ListifyPLongArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyPLongArrayDigitLengths getObjectCopy()  {
		return  (new ListifyPLongArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((long[])getRawObject());
	}
}
class ListifyPFloatArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Float>  {
//constructors...START
	public ListifyPFloatArrayDigitLengths(float[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forFloat());
	}
	public ListifyPFloatArrayDigitLengths(float[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forFloat(), null_handler);
	}
	public ListifyPFloatArrayDigitLengths(ListifyPFloatArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyPFloatArrayDigitLengths getObjectCopy()  {
		return  (new ListifyPFloatArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((float[])getRawObject());
	}
}
class ListifyPDoubleArrayDigitLengths extends AbstractListifyPArrayDigitLengths<Double>  {
//constructors...START
	public ListifyPDoubleArrayDigitLengths(double[] obj_thatIsPrimArr)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forDouble());
	}
	public ListifyPDoubleArrayDigitLengths(double[] obj_thatIsPrimArr, NullHandlerForPrimitives<Integer> null_handler)  {
		super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forDouble(), null_handler);
	}
	public ListifyPDoubleArrayDigitLengths(ListifyPDoubleArrayDigitLengths to_copy)  {
		super(to_copy);
	}
	public ListifyPDoubleArrayDigitLengths getObjectCopy()  {
		return  (new ListifyPDoubleArrayDigitLengths(this));
	}
//constructors...END
	public final Iterator<Integer> iterator()  {
		return  NewArrayIterator.forDigitTSLength((double[])getRawObject());
	}
}
