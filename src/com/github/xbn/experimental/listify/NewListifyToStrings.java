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
	import  com.github.xbn.text.StringWithNullDefault;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.experimental.listify.backend.AbstractListifyToStrings;
	import  java.util.Iterator;
	import  java.util.List;
	import  org.apache.commons.collections4.iterators.ArrayIterator;
	import  com.github.xbn.array.ArrayUtil;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.list.ListUtil;
/**
	<p>Convenience functions for creating listifiers whose raw object is a list or array (primitive or non-primitive), and whose virtual elements are the <i>{@code toString()}-s</i> of the raw elements.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewListifyToStrings  {
   private NewListifyToStrings()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	public static final <R> Listify<String> forList(List<R> list)  {
		return  (new LFListForToStrings<R>(list));
	}
	public <R> Listify<String> forNonPArray(R[] array)  {
		return  (new LFNonPArrayForToStrings<R>(array));
	}
	public Listify<String> forBooleanArray(boolean[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Boolean>(prim_array, NewPrimitiveArrayHelper.forBoolean()));
	}
	public Listify<String> forCharArray(char[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Character>(prim_array, NewPrimitiveArrayHelper.forCharacter()));
	}
	public Listify<String> forPByteArray(byte[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Byte>(prim_array, NewPrimitiveArrayHelper.forByte()));
	}
	public Listify<String> forPShortArray(short[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Short>(prim_array, NewPrimitiveArrayHelper.forShort()));
	}
	public Listify<String> forIntArray(int[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Integer>(prim_array, NewPrimitiveArrayHelper.forInteger()));
	}
	public Listify<String> forPLongArray(long[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Long>(prim_array, NewPrimitiveArrayHelper.forLong()));
	}
	public Listify<String> forPFloatArray(float[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Float>(prim_array, NewPrimitiveArrayHelper.forFloat()));
	}
	public Listify<String> forPDoubleArray(double[] prim_array)  {
		return  (new LFPrimitiveArrayForToStrings<Double>(prim_array, NewPrimitiveArrayHelper.forDouble()));
	}
}

class LFListForToStrings<R> extends AbstractListifyToStrings  {
	public LFListForToStrings(List<R> list)  {
		super(list);
	}
	public LFListForToStrings(LFListForToStrings<R> to_copy)  {
		super(to_copy);
	}
	@SuppressWarnings("unchecked")
	public List<R> getRawList()  {
		return  (List<R>)getRawObject();
	}
	public final String getElementRTXOkay(int index)  {
		return  StringWithNullDefault.get(getRawList().get(index), null);
	}
	public final String[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements ignored)  {
		try  {
			return  ListUtil.getStringArrayOrNull(getRawList(), null, null_ok, "getRawList()");
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	protected final int getSizeNPXOkay()  {
		return  getRawList().size();
	}
	public final Iterator<String> iterator()  {
		try  {
			return  (new ArrayIterator<String>(getEArrayCopyOrNull(NullContainer.BAD, CopyElements.NO)));
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public LFListForToStrings<R> getObjectCopy()  {
		return  (new LFListForToStrings<R>(this));
	}
}
class LFNonPArrayForToStrings<R> extends AbstractListifyToStrings  {
	public LFNonPArrayForToStrings(R[] array)  {
		super(array);
	}
	public LFNonPArrayForToStrings(LFNonPArrayForToStrings<R> to_copy)  {
		super(to_copy);
	}
	@SuppressWarnings("unchecked")
	public final R[] getRawEArray()  {
		return  (R[])getRawObject();
	}
	public final String getElementRTXOkay(int index)  {
		return  StringWithNullDefault.get(getRawEArray()[index], null);
	}
	public final String[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements ignored)  {
		try  {
			return  ArrayUtil.getStringArrayOrNull(getRawEArray(), null_ok, "getRawEArray()");
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	protected final int getSizeNPXOkay()  {
		return  getRawEArray().length;
	}
	public final Iterator<String> iterator()  {
		try  {
			return  (new ArrayIterator<String>(getEArrayCopyOrNull(NullContainer.BAD, CopyElements.NO)));
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public LFNonPArrayForToStrings<R> getObjectCopy()  {
		return  (new LFNonPArrayForToStrings<R>(this));
	}
}
class LFPrimitiveArrayForToStrings<R> extends AbstractListifyToStrings  {
	private PrimitiveArrayHelper<R> pab = null;
	public LFPrimitiveArrayForToStrings(Object obj_thatIsPrimArr, PrimitiveArrayHelper<R> pa_b)  {
		super(obj_thatIsPrimArr);
		if(pa_b == null)  {
			throw  new NullPointerException("pa_b");
		}
		pab = pa_b;
	}
	public LFPrimitiveArrayForToStrings(LFPrimitiveArrayForToStrings<R> to_copy)  {
		super(to_copy);
	}
	public PrimitiveArrayHelper<R> getArrayHelperForP()  {
		return  pab;
	}
	public final String getElementRTXOkay(int index)  {
		return  StringWithNullDefault.get(getArrayHelperForP().getWrapper(getRawObject(), index, "getRawObject()"), null);
	}
	public final String[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements ignored)  {
		try  {
			return  getArrayHelperForP().getStringArrayOrNull(getRawObject(), null_ok, "getRawObject()");
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	protected final int getSizeNPXOkay()  {
		return  getArrayHelperForP().getLength(getRawObject(), "getRawObject()");
	}
	public final Iterator<String> iterator()  {
		try  {
			return  (new ArrayIterator<String>(getEArrayCopyOrNull(NullContainer.BAD, null)));
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public LFPrimitiveArrayForToStrings<R> getObjectCopy()  {
		return  (new LFPrimitiveArrayForToStrings<R>(this));
	}
}
