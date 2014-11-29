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
	import  com.github.xbn.lang.ObjectOrCrashIfNull;
	import  com.github.xbn.array.CrashIfIndex;
	import  com.github.xbn.lang.CrashIfObject;
	import  java.util.Collection;
	import  com.github.xbn.array.helper.ArrayHelperBase;
	import  com.github.xbn.util.copyval.ValueCopier;
/**
	<p>For classes needing to implement {@code Listify}, that cannot extend {@code AbstractListify}.</p>

	@see  AbstractListify
	@author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). <code><a href="http://xbnjava.aliteralmind.com">http://xbnjava.aliteralmind.com</a></code>
 **/
public class ListifyComposer<E>  {//implements Listify<E>  {
	private Object oRaw = null;
	private boolean bARable = false;
	private ArrayHelperBase<E> ahr = null;
	private ValueCopier<E> copyval = null;
//constructors...START
	public ListifyComposer(Object raw_obj, AddRemovable add_rmvbl, ArrayHelperBase<E> array_helper, ValueCopier<E> get_valCopy)  {
		if(get_valCopy == null)  {
			throw  new NullPointerException("get_valCopy");
		}
		if(array_helper == null)  {
			throw  new NullPointerException("array_helper");
		}
		oRaw = raw_obj;
		bARable = add_rmvbl.isYes();
		ahr = array_helper;
		copyval = get_valCopy;
	}
	/**
		<p>Create a new {@code ListifyComposer} as a duplicate of another.</p>

		YYY

		<p>This<ol>
			<li>YYY</li>
		</ol></p>

		@param  to_copy  May not be {@code null}.
	 **/
	@SuppressWarnings("unchecked")
	public ListifyComposer(boolean ignored, ListifyComposer<E> to_copy)  {
		try  {
			oRaw = to_copy.getRawObject();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(ignored, "ignored", null, rx);
		}
		ahr = to_copy.getArrayHelper();
		@SuppressWarnings("unchecked")
		ValueCopier<E> gvc2 = (ValueCopier<E>)ObjectOrCrashIfNull.
			<ValueCopier>getCopy(to_copy.getValueCopier(), ValueCopier.class, "to_copy.getValueCopier()");
		copyval = gvc2;
	}
	/**
		<p>Create a new {@code ListifyComposer} as a duplicate of another.</p>

		YYY

		<p>This<ol>
			<li>YYY</li>
		</ol></p>

		@param  to_copy  May not be {@code null}.
	 **/
	@SuppressWarnings("unchecked")
	public ListifyComposer(Listify<E> to_copy)  {
		try  {
			oRaw = to_copy.getRawObject();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
		ahr = to_copy.getArrayHelper();
		copyval = (ValueCopier<E>)to_copy.getValueCopier().getObjectCopy();
	}
//constructors...END
	/**
		@see  #ListifyComposer(Object, AddRemovable, ArrayHelperBase, ValueCopier) this(o,b,ahb,copyval)
	 **/
	public ArrayHelperBase<E> getArrayHelper()  {
		return  ahr;
	}
	/**
		@see  #ListifyComposer(Object, AddRemovable, ArrayHelperBase, ValueCopier) this(o,b,ahb,copyval)
	 **/
	public final boolean isAddRemovable()  {
		return  bARable;
	}
	/**
		@see  #ListifyComposer(Object, AddRemovable, ArrayHelperBase, ValueCopier) this(o,b,ahb,copyval)
	 **/
	public ValueCopier<E> getValueCopier()  {
		return  copyval;
	}
	/**
		@see  #ListifyComposer(Object, AddRemovable, ArrayHelperBase, ValueCopier) this(o,b,ahb,copyval)
	 **/
	public Object getRawObject()  {
		return  oRaw;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append(", isAddRemovable()=").append(isAddRemovable()).append(", getValueCopier()=[").append(getValueCopier()).append("], getRawObject()=[").append(getRawObject()).append("]");
	}
//static...START
	/**
		<p>If the underlying object is {@code null}, crash. Otherwise, do nothing.</p>

		@param  listifier  May not be {@code null}.
	 **/
	public static final <E> void ciRawObjectNull(Listify<E> listifier)  {
		try  {
			if(listifier.getRawObject() == null)  {
				throw  new NullPointerException("getRawObject()");
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(listifier, "listifier", null, rx);
		}
	}
/*
	public static final <E> RuntimeException ciRawObjectNullOrReturnCause(Listify<E> listifier, RuntimeException cause)  {
		ciRawObjectNull(listifier);
		return  regetRtxCrashIfNull(cause, "cause");
	}
	public static final <E> RuntimeException ciRawObjectNullBadIndexOrReturnCause(Listify<E> listifier, int index, RuntimeException cause)  {
		ciRawObjectNullOrBadIndex(listifier, index);
		return  regetRtxCrashIfNull(cause, "cause");
	}
 */
	public static final <E> void ciRawObjectNullOrBadIndex(Listify<E> listifier, int index)  {
		ciRawObjectNull(listifier);
		CrashIfIndex.badForLength(index, listifier.size(), "index", "getRawObject().size()");
	}
	public static final <E> ValueCopier<E> getGVCIfCopyElements(Listify<E> listifier, CopyElements copy_elements)  {
		try  {
			return  (copy_elements.isYes() ? listifier.getValueCopier() : null);
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(copy_elements, "copy_elements", null);
			throw  CrashIfObject.nullOrReturnCause(listifier, "listifier", null, rx);
		}
	}
//static...END
//Function-names for error-message calling-functions...START
//do-not-use. Override if necessary...START
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public void clear()  {
		throw  new ListifiedNotAddRemovableException("clear");
	}
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public boolean retainAll(Collection<?> coll)  {
		throw  new ListifiedNotAddRemovableException("retainAll");
	}
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public boolean removeAll(Collection<?> coll)  {
		throw  new ListifiedNotAddRemovableException("removeAll");
	}
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public boolean addAll(Collection<? extends E> coll)  {
		throw  new ListifiedNotAddRemovableException("addAll");
	}
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public boolean remove(Object obj)  {
		throw  new ListifiedNotAddRemovableException("remove");
	}
	/**
		<p>Do not use--override if necessary.</p>
	 **/
	public boolean add(E to_add)  {
		throw  new ListifiedNotAddRemovableException("add");
	}
//do-not-use. Override if necessary...END
//Function-names for error-message calling-functions...END
/*stub functions for implements compile...START
	public final String[] getStringArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final Object[] getObjectArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final String getString(int index)  {
		return  null;
	}
	public final Object getObject(int index)  {
		return  null;
	}
	public final E get(int index)  {
		return  null;
	}
	public final boolean isNull(int index)  {
		return  false;
	}
	public final E getCopy(int index)  {
		return  null;
	}
	public final int size()  {
		return  -1;
	}
	public final java.util.List<String> getStringListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final java.util.List<Object> getObjectListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final java.util.List<E> getEListCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final E[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
		return  null;
	}
	public final Object[] toArray()  {
		return  null;
	}
	public final <T> T[] toArray(T[] array_ofT)  {
		return  null;
	}
	public final boolean isEmpty()  {
		return  false;
	}
	public final java.util.Iterator<E> iterator()  {
		return  null;
	}
 	public final boolean contains(Object obj)  {
		return  false;
	}
 	public final boolean containsAll(Collection<?> coll)  {
		return  false;
	}
 	public final boolean contains_nullOk(Object obj)  {
		return  false;
	}
 	public final boolean containsAll_nullOk(Collection<?> coll)  {
		return  false;
	}
 stub functions for implements compile...END*/
}
