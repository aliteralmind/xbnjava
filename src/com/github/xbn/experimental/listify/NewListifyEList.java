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
	import  com.github.xbn.array.NullContainer;
	import  java.util.Collection;
	import  java.util.List;
	import  com.github.xbn.array.helper.ArrayHelper;
	import  com.github.xbn.array.helper.ArrayHelperBase;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.array.helper.ObjectArrayHelper;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.array.helper.StringArrayHelper;
	import  com.github.xbn.array.helper.StringBuilderArrayHelper;
	import  com.github.xbn.list.CollectionUtil;
	import  com.github.xbn.list.ListUtil;
	import  com.github.xbn.array.primitive.PrimitiveArrayFromCollection;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyBoolable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyByteable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyCharable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyDoubleable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyFloatable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyIntable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyLongable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyShortable;
	import  com.github.xbn.util.copyval.ValueNotCopyable;
	import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
	import  com.github.xbn.util.copyval.ValueCopier;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
	import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
	import  com.github.xbn.util.copyval.SimpleNullHandler;
/**
	<P>Convenience functions for creating listifiers whose raw object is a {@code java.util.List}, and whose vitual elements are of the same type as the raw elements.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewListifyEList<E>  {
   private NewListifyEList()  {
		throw  new IllegalStateException("Do not instantiate");
	}
//static...START
	public static final ListifyBoolable forBoolean(List<Boolean> list, AddRemovable add_rmvbl)  {
		return  (new ListifyBooleanList(list, add_rmvbl));
	}
	public static final ListifyBoolable forBoolean(List<Boolean> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Boolean> null_handler)  {
		return  (new ListifyBooleanList(list, add_rmvbl, null_handler));
	}
	public static final ListifyCharable forCharacter(List<Character> list, AddRemovable add_rmvbl)  {
		return  (new ListifyCharacterList(list, add_rmvbl));
	}
	public static final ListifyCharable forCharacter(List<Character> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Character> null_handler)  {
		return  (new ListifyCharacterList(list, add_rmvbl, null_handler));
	}
	public static final ListifyByteable forByte(List<Byte> list, AddRemovable add_rmvbl)  {
		return  (new ListifyByteList(list, add_rmvbl));
	}
	public static final ListifyByteable forByte(List<Byte> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Byte> null_handler)  {
		return  (new ListifyByteList(list, add_rmvbl, null_handler));
	}
	public static final ListifyShortable forShort(List<Short> list, AddRemovable add_rmvbl)  {
		return  (new ListifyShortList(list, add_rmvbl));
	}
	public static final ListifyShortable forShort(List<Short> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Short> null_handler)  {
		return  (new ListifyShortList(list, add_rmvbl, null_handler));
	}
	public static final ListifyIntable forInteger(List<Integer> list, AddRemovable add_rmvbl)  {
		return  (new ListifyIntegerList(list, add_rmvbl));
	}
	public static final ListifyIntable forInteger(List<Integer> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Integer> null_handler)  {
		return  (new ListifyIntegerList(list, add_rmvbl, null_handler));
	}
	public static final ListifyLongable forLong(List<Long> list, AddRemovable add_rmvbl)  {
		return  (new ListifyLongList(list, add_rmvbl));
	}
	public static final ListifyLongable forLong(List<Long> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Long> null_handler)  {
		return  (new ListifyLongList(list, add_rmvbl, null_handler));
	}
	public static final ListifyFloatable forFloat(List<Float> list, AddRemovable add_rmvbl)  {
		return  (new ListifyFloatList(list, add_rmvbl));
	}
	public static final ListifyFloatable forFloat(List<Float> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Float> null_handler)  {
		return  (new ListifyFloatList(list, add_rmvbl, null_handler));
	}
	public static final ListifyDoubleable forDouble(List<Double> list, AddRemovable add_rmvbl)  {
		return  (new ListifyDoubleList(list, add_rmvbl));
	}
	public static final ListifyDoubleable forDouble(List<Double> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Double> null_handler)  {
		return  (new ListifyDoubleList(list, add_rmvbl, null_handler));
	}
	@SuppressWarnings("unchecked")
	public static final ListifyEListRoot<Object> forObject(List<Object> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListNonPNonW<Object>(list, add_rmvbl, (new ObjectArrayHelper()), (ValueCopier<Object>)ValueNotCopyable.INSTANCE);
	}
	public static final ListifyEListRoot<String> forString(List<String> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListNonPNonW<String>(list, add_rmvbl, (new StringArrayHelper()), OneParamCnstrValueCopier.STRING);
	}
	public static final ListifyEListRoot<StringBuilder> stringBuilder(List<StringBuilder> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListNonPNonW<StringBuilder>(list, add_rmvbl, (new StringBuilderArrayHelper()), OneParamCnstrValueCopier.STRING_BUILDER);
	}
//static...END
}
class ListifyEListNonPNonW<E> extends ListifyEListRoot<E>  {
	public ListifyEListNonPNonW(List<E> list, AddRemovable add_rmvbl, ArrayHelper<E> array_helper, ValueCopier<E> get_valCopy)  {
		super(list, add_rmvbl, array_helper, get_valCopy);
	}
	public ListifyEListNonPNonW(ListifyEListNonPNonW<E> to_copy)  {
		super(to_copy);
	}
	public ListifyEListNonPNonW<E> getObjectCopy()  {
		return  (new ListifyEListNonPNonW<E>(this));
	}
}
class ListifyEListPable<E> extends ListifyEListRoot<E>  {
	public ListifyEListPable(List<E> list, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> primitive_arrHelper, ValueCopier<E> get_valCopy)  {
		super(list, add_rmvbl, primitive_arrHelper, get_valCopy);
	}
	public ListifyEListPable(ListifyEListPable<E> to_copy)  {
		super(to_copy);
	}
	public ListifyEListPable<E> getObjectCopy()  {
		return  (new ListifyEListPable<E>(this));
	}
}
abstract class ListifyEListRoot<E> extends AbstractListify<E>  {
//constructors...START
	/**
		<P>Create a new {@code ListifyEListRoot}.</P>

		YYY

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Object, boolean, ArrayHelper, ValueCopier) super}{@code (raw_obj, add_rmvbl, ah_root, get_valCopy)}</P>
	 **/
	public ListifyEListRoot(List<E> list, AddRemovable add_rmvbl, ArrayHelperBase<E> ah_root, ValueCopier<E> get_valCopy)  {
		super(list, add_rmvbl, ah_root, get_valCopy);
	}
	public ListifyEListRoot(ListifyEListRoot<E> to_copy)  {
		super(to_copy);
	}
//constructors...END
	@SuppressWarnings("unchecked")
	public List<E> getRawEList()  {
		return  (List<E>)getRawObject();
	}
	public final E getElementRTXOkay(int index)  {
		return  getRawEList().get(index);
	}
	public final String[] getStringArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
		return  ListUtil.getStringArrayOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), nnull, ("getRawEList()"));
	}
	public final Object[] getObjectArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
		return  ListUtil.getObjectArrayOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), nnull, "getRawEList()");
	}
	public final E[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
		try  {
			return  ListUtil.getEArrayOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), getArrayHelper().getInitialized(size()), nnull, "getRawEList()");
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final Object getObject(int index)  {
		return  ((Object)get(index));
	}
	public final boolean isNull(int index)  {
		return  (get(index) == null);
	}
	public final E getCopy(int index)  {
		try  {
			return  getValueCopier().getValueCopy(get(index), "get(" + index + ")");
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final int getSizeNPXOkay()  {
		return  getRawEList().size();
	}
	public final List<String> getStringListOrNull(NullContainer nnull, CopyElements copy_elements)  {
		return  ListUtil.getStringListOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), nnull, "getRawEList()");
	}
	public final List<Object> getObjectListOrNull(NullContainer nnull, CopyElements copy_elements)  {
		return  ListUtil.getObjectListOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), nnull, "getRawEList()");
	}
	public final List<E> getEListCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
		return  ListUtil.getEListCopyOrNull(getRawEList(), getGVCIfCopyElements(copy_elements), nnull, "getRawEList()");
	}
	public final Object[] toArray()  {
		try  {
			return  getRawEList().toArray();
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final <T> T[] toArray(T[] array_ofT)  {
		try  {
			return  getRawEList().toArray(array_ofT);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean isEmpty()  {
		try  {
			return  getRawEList().isEmpty();
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final java.util.Iterator<E> iterator()  {
		try  {
			return  getRawEList().iterator();
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
 	public final boolean contains(Object obj)  {
		try  {
			return  getRawEList().contains(obj);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
 	public final boolean containsAll(Collection<?> coll)  {
		try  {
			return  getRawEList().containsAll(coll);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
 	public boolean contains_nullOk(Object obj)  {
		return  CollectionUtil.xItrContainsY_nullOk(iterator(), obj);
	}
 	public boolean containsAll_nullOk(Collection<?> coll)  {
		return  CollectionUtil.xItrContainsAllY_nullOk(iterator(), coll);
	}
	public final void clear()  {
		try  {
			getRawEList().clear();
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean retainAll(Collection<?> coll)  {
		try  {
			return  getRawEList().retainAll(coll);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean removeAll(Collection<?> coll)  {
		try  {
			return  getRawEList().removeAll(coll);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean addAll(Collection<? extends E> coll)  {
		try  {
			return  getRawEList().addAll(coll);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean remove(Object obj)  {
		try  {
			return  getRawEList().remove(obj);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final boolean add(E to_add)  {
		try  {
			return  getRawEList().add(to_add);
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
}
abstract class AbstractListifyEListPable<E> extends ListifyEListPable<E> implements ListifyPrimitiveable<E>  {
	private NullHandlerForPrimitives<E> hnvnb = null;
	@SuppressWarnings("unchecked")
	public AbstractListifyEListPable(List<E> list, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> pa_b, ValueCopier<E> get_valCopy)  {
		this(list, add_rmvbl, pa_b, get_valCopy, SimpleNullHandlerForPrimitives.CRASH);
	}
	public AbstractListifyEListPable(List<E> list, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> pa_b, ValueCopier<E> get_valCopy, NullHandlerForPrimitives<E> null_handler)  {
		super(list, add_rmvbl, pa_b, get_valCopy);
		if(null_handler == null)  {
			throw  new NullPointerException("null_handler");
		}
		hnvnb = null_handler;
	}
	public AbstractListifyEListPable(AbstractListifyEListPable<E> to_copy)  {
		super(to_copy);
	}
	public NullHandlerForPrimitives<E> getNullHandlerForPrimitives()  {
		return  hnvnb;
	}
	@SuppressWarnings("unchecked")
	public PrimitiveArrayHelper<E> getArrayHelper()  {
		return  (PrimitiveArrayHelper<E>)super.getArrayHelper();
	}
	public String toString()  {
		return  super.toString() + ", getNullHandlerForPrimitives()=[" + getNullHandlerForPrimitives() + "]";
	}
	public E getElementCopyCINullAndHNVCrashOrDel(int index)  {
		return  SimpleNullHandler.getCopyCIOrigNullAndActionCrash(getNullHandlerForPrimitives(), true, get(index));
	}
}
class ListifyBooleanList extends AbstractListifyEListPable<Boolean> implements ListifyBoolable  {
	public ListifyBooleanList(List<Boolean> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forBoolean(), (new OneParamCnstrValueCopier<Boolean>(Boolean.class)));
	}
	public ListifyBooleanList(List<Boolean> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Boolean> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forBoolean(), (new OneParamCnstrValueCopier<Boolean>(Boolean.class)), null_handler);
	}
	public boolean getBool(int index)  {
		return  (boolean)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final boolean[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forBoolean(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyBooleanList(ListifyBooleanList to_copy)  {
		super(to_copy);
	}
	public ListifyBooleanList getObjectCopy()  {
		return  (new ListifyBooleanList(this));
	}
}
class ListifyCharacterList extends AbstractListifyEListPable<Character> implements ListifyCharable  {
	public ListifyCharacterList(List<Character> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)));
	}
	public ListifyCharacterList(List<Character> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Character> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)), null_handler);
	}
	public char getChar(int index)  {
		return  (char)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final char[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forCharacter(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyCharacterList(ListifyCharacterList to_copy)  {
		super(to_copy);
	}
	public ListifyCharacterList getObjectCopy()  {
		return  (new ListifyCharacterList(this));
	}
}
class ListifyByteList extends AbstractListifyEListPable<Byte> implements ListifyByteable  {
	public ListifyByteList(List<Byte> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forByte(), (new OneParamCnstrValueCopier<Byte>(Byte.class)));
	}
	public ListifyByteList(List<Byte> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Byte> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forByte(), (new OneParamCnstrValueCopier<Byte>(Byte.class)), null_handler);
	}
	public byte getPByte(int index)  {
		return  (byte)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final byte[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forByte(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyByteList(ListifyByteList to_copy)  {
		super(to_copy);
	}
	public ListifyByteList getObjectCopy()  {
		return  (new ListifyByteList(this));
	}
}
class ListifyShortList extends AbstractListifyEListPable<Short> implements ListifyShortable  {
	public ListifyShortList(List<Short> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forShort(), (new OneParamCnstrValueCopier<Short>(Short.class)));
	}
	public ListifyShortList(List<Short> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Short> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forShort(), (new OneParamCnstrValueCopier<Short>(Short.class)), null_handler);
	}
	public short getPShort(int index)  {
		return  (short)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final short[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forShort(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyShortList(ListifyShortList to_copy)  {
		super(to_copy);
	}
	public ListifyShortList getObjectCopy()  {
		return  (new ListifyShortList(this));
	}
}
class ListifyIntegerList extends AbstractListifyEListPable<Integer> implements ListifyIntable  {
	public ListifyIntegerList(List<Integer> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forInteger(), (new OneParamCnstrValueCopier<Integer>(Integer.class)));
	}
	public ListifyIntegerList(List<Integer> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Integer> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forInteger(), (new OneParamCnstrValueCopier<Integer>(Integer.class)), null_handler);
	}
	public int getInt(int index)  {
		return  (int)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final int[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forInteger(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyIntegerList(ListifyIntegerList to_copy)  {
		super(to_copy);
	}
	public ListifyIntegerList getObjectCopy()  {
		return  (new ListifyIntegerList(this));
	}
}
class ListifyLongList extends AbstractListifyEListPable<Long> implements ListifyLongable  {
	public ListifyLongList(List<Long> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forLong(), (new OneParamCnstrValueCopier<Long>(Long.class)));
	}
	public ListifyLongList(List<Long> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Long> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forLong(), (new OneParamCnstrValueCopier<Long>(Long.class)), null_handler);
	}
	public long getPLong(int index)  {
		return  (long)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final long[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forLong(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyLongList(ListifyLongList to_copy)  {
		super(to_copy);
	}
	public ListifyLongList getObjectCopy()  {
		return  (new ListifyLongList(this));
	}
}
class ListifyFloatList extends AbstractListifyEListPable<Float> implements ListifyFloatable  {
	public ListifyFloatList(List<Float> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forFloat(), (new OneParamCnstrValueCopier<Float>(Float.class)));
	}
	public ListifyFloatList(List<Float> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Float> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forFloat(), (new OneParamCnstrValueCopier<Float>(Float.class)), null_handler);
	}
	public float getPFloat(int index)  {
		return  (float)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final float[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forFloat(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyFloatList(ListifyFloatList to_copy)  {
		super(to_copy);
	}
	public ListifyFloatList getObjectCopy()  {
		return  (new ListifyFloatList(this));
	}
}
class ListifyDoubleList extends AbstractListifyEListPable<Double> implements ListifyDoubleable  {
	public ListifyDoubleList(List<Double> list, AddRemovable add_rmvbl)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forDouble(), (new OneParamCnstrValueCopier<Double>(Double.class)));
	}
	public ListifyDoubleList(List<Double> list, AddRemovable add_rmvbl, NullHandlerForPrimitives<Double> null_handler)  {
		super(list, add_rmvbl, NewPrimitiveArrayHelper.forDouble(), (new OneParamCnstrValueCopier<Double>(Double.class)), null_handler);
	}
	public double getPDouble(int index)  {
		return  (double)getElementCopyCINullAndHNVCrashOrDel(index);
	}
 	public final double[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromCollection.forDouble(getRawEList(), getNullHandlerForPrimitives(), nnull, "getPArrayCopyOrNull(...)");
	}
	public ListifyDoubleList(ListifyDoubleList to_copy)  {
		super(to_copy);
	}
	public ListifyDoubleList getObjectCopy()  {
		return  (new ListifyDoubleList(this));
	}
}
	/**
		<P>YYY</P>

<!--
---nwrqm input---
Boolean list Bool
Double list Double
Float list Float
Long list Long
Integer list Int
Short list Short
Byte list Byte
Character list Char

 -->
	public static final ListifyEListRoot<Boolean> newForBoolean(List<Boolean> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Boolean>(list, add_rmvbl, NewPrimitiveArrayHelper.forBoolean(), (new OneParamCnstrValueCopier<Boolean>(Boolean.class)));
	}
	public static final ListifyEListRoot<Character> newForCharacter(List<Character> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Character>(list, add_rmvbl, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)));
	}
	public static final ListifyEListRoot<Byte> newForByte(List<Byte> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Byte>(list, add_rmvbl, NewPrimitiveArrayHelper.forByte(), (new OneParamCnstrValueCopier<Byte>(Byte.class)));
	}
	public static final ListifyEListRoot<Short> newForShort(List<Short> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Short>(list, add_rmvbl, NewPrimitiveArrayHelper.forShort(), (new OneParamCnstrValueCopier<Short>(Short.class)));
	}
	public static final ListifyEListRoot<Integer> newForInt(List<Integer> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Integer>(list, add_rmvbl, NewPrimitiveArrayHelper.forInteger(), (new OneParamCnstrValueCopier<Integer>(Integer.class)));
	}
	public static final ListifyEListRoot<Long> newForLong(List<Long> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Long>(list, add_rmvbl, NewPrimitiveArrayHelper.forLong(), (new OneParamCnstrValueCopier<Long>(Long.class)));
	}
	public static final ListifyEListRoot<Float> newForFloat(List<Float> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Float>(list, add_rmvbl, NewPrimitiveArrayHelper.forFloat(), (new OneParamCnstrValueCopier<Float>(Float.class)));
	}
	public static final ListifyEListRoot<Double> newForDouble(List<Double> list, AddRemovable add_rmvbl)  {
		return  new ListifyEListRoot<Double>(list, add_rmvbl, NewPrimitiveArrayHelper.forDouble(), (new OneParamCnstrValueCopier<Double>(Double.class)));
	}
	 **/
