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
package  com.github.xbn.experimental.listify.arrayofsame;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.primitive.CrashIfObjThatIsPrimitiveArray;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  java.util.Arrays;
   import  java.util.Collection;
   import  java.util.Iterator;
   import  java.util.List;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For building listifiers whose raw object is a primitive array, and whose virtual elements are their wrapper-types (such as {@code int[]} and {@code java.lang.Integer}).</P>

 	@author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyPrimitiveEArray<E> implements ListifyPrimitiveEArray<E>  {
   private ListifyPrimitiveableComposer<E> lpbc = null;
   private ListifyEArrayComposer<E> leac = null;
//constructors...START
   /**
      <P>Create a new {@code AbstractListifyPrimitiveEArray}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Object, ValueCopier) super}{@code (obj_thatIsPrimArr, get_valCopy)}</P>
    **/
   public AbstractListifyPrimitiveEArray(Object obj_thatIsPrimArr, PrimitiveArrayHelper<E> pa_helper, ValueCopier<E> get_valCopy)  {
      leac = new ListifyEArrayComposer<E>(obj_thatIsPrimArr, pa_helper, get_valCopy);
      lpbc = new ListifyPrimitiveableComposer<E>(obj_thatIsPrimArr, AddRemovable.NO, pa_helper, get_valCopy);
      if(obj_thatIsPrimArr != null  &&  !ObjThatIsPrimitiveArrayUtil.isPrimitive(obj_thatIsPrimArr))  {
         throw  new IllegalStateException("obj_thatIsPrimArr is non-null but not a primitive array. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\".");
      }
   }
   public AbstractListifyPrimitiveEArray(Object obj_thatIsPrimArr, PrimitiveArrayHelper<E> pa_helper, ValueCopier<E> get_valCopy, NullHandlerForPrimitives<E> hnr_nb)  {
      leac = new ListifyEArrayComposer<E>(obj_thatIsPrimArr, pa_helper, get_valCopy);
      lpbc = new ListifyPrimitiveableComposer<E>(obj_thatIsPrimArr, AddRemovable.NO, pa_helper, get_valCopy, hnr_nb);
   }
   /**
      <P>Create a new {@code AbstractListifyPrimitiveEArray} as a duplicate of another.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; ...........</P>

      @param  to_copy  May not be {@code null}.
    **/
   public AbstractListifyPrimitiveEArray(ListifyPrimitiveEArray<E> to_copy)  {
      leac = new ListifyEArrayComposer<E>(to_copy);
      lpbc = new ListifyPrimitiveableComposer<E>(getRawObject(), AddRemovable.getForBoolean(isAddRemovable()), getArrayHelper(), getValueCopier(), getNullHandlerForPrimitives());
   }
//constructors...END
   public final Iterator<E> iterator()  {
      return  leac.iterator();
   }
   public final boolean isAddRemovable()  {
      return  leac.isAddRemovable();
   }
   public ValueCopier<E> getValueCopier()  {
      return  leac.getValueCopier();
   }
   public Object getRawObject()  {
      return  leac.getRawObject();
   }
   public String toString()  {
      return  leac.toString();
   }
   public void clear()  {
      leac.clear();
   }
   public boolean retainAll(Collection<?> coll)  {
      return  leac.retainAll(coll);
   }
   public boolean removeAll(Collection<?> coll)  {
      return  leac.removeAll(coll);
   }
   public boolean addAll(Collection<? extends E> coll)  {
      return  leac.addAll(coll);
   }
   public boolean remove(Object obj)  {
      return  leac.remove(obj);
   }
   public boolean add(E to_add)  {
      return  leac.add(to_add);
   }
   public Object getRawPArray()  {
      return  getRawObject();
   }
   /**
      <P>If the array is {@code null}, crash--otherwise, <I>return</I> the error-cause.</P>

      @return  {@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPrimitiveEArray super}.{@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPrimitiveEArray#ciRawObjectNullOrReturnCause_4prot(String, RuntimeException) ciRawObjectNullOrReturnCause_4prot}{@code (cause)}
   protected RuntimeException ciRawObjectNullOrReturnCause(RuntimeException cause)  {
      return  super.ciRawObjectNullOrReturnCause_4prot(cause);
   }
    **/
   /**
      <P>If the array is {@code null}, or an index is bad given its length, crash--otherwise <I>return</I> the causing error.</P>
    **/
   protected void ciArrayNullOrBadIndex(int index)  {
      CrashIfObjThatIsPrimitiveArray.nullOrBadIndex(getRawObject(), index, "index", "getRawPArray()");
   }
 	public boolean contains(Object obj)  {
      return  CollectionUtil.xItrContainsY(iterator(), obj);
   }
 	public boolean containsAll(Collection<?> coll)  {
      return  CollectionUtil.xItrContainsAllY(iterator(), coll);
   }
 	public boolean contains_nullOk(Object obj)  {
      return  CollectionUtil.xItrContainsY_nullOk(iterator(), obj);
   }
 	public boolean containsAll_nullOk(Collection<?> coll)  {
      return  CollectionUtil.xItrContainsAllY_nullOk(iterator(), coll);
   }
//originates in AbstractListify. Needed by AbstractListifyEArray...END
   public final PrimitiveArrayHelper<E> getArrayHelper()  {
      return  (PrimitiveArrayHelper<E>)leac.getArrayHelper();
   }
   public final NullHandlerForPrimitives<E> getNullHandlerForPrimitives()  {
      return  lpbc.getNullHandlerForPrimitives();
   }
   public Object getPArrayCopyOrNull(NullContainer nnull)  {
      return  getArrayHelper().getPArrayCopyOrNull(getRawObject(), nnull, "getRawPArray()");
   }
   public final List<E> getEListCopyOrNull(NullContainer nnull, CopyElements ignored)  {
      return  ArrayUtil.getListOrNull(getEArrayCopyOrNull(nnull, ignored), null, nnull, null);
   }
   public final List<Object> getObjectListOrNull(NullContainer nnull, CopyElements ignored)  {
      return  ArrayUtil.getObjectListOrNull(getEArrayCopyOrNull(nnull, ignored), null, nnull, null);
   }
   public final List<String> getStringListOrNull(NullContainer nnull, CopyElements ignored)  {
      return  ArrayUtil.getStringListOrNull(getEArrayCopyOrNull(nnull, ignored), nnull, null);
   }
   public final int size()  {
      return  getArrayHelper().getLength(getRawObject(), "getRawPArray()");
   }
   public final boolean isEmpty()  {
      return  (size() == 0);
   }
   public final E get(int index)  {
      return  getArrayHelper().getWrapper(getRawObject(), index, "getRawPArray()");
   }
   public final E getCopy(int index)  {
      return  get(index);
   }
   public final E[] getEArrayCopyOrNull(NullContainer nnull, CopyElements ignored)  {
      return  getArrayHelper().getWrapperArrayOrNull(getRawObject(), nnull, "getEArrayCopyOrNull()");
   }
   public final Object getObject(int index)  {
      return  (Object)get(index);
   }
   public final String getString(int index)  {
      return  (String)get(index);
   }
   public final boolean isNull(int index)  {
      //The only reason to call this is to capture a bad index. Otherwise, this could just return false.
      return  (get(index) == null);
   }
   public <T> T[] toArray(T[] array_ofT)  {
      return  getEListCopyOrNull(NullContainer.BAD, CopyElements.NO).toArray(array_ofT);
   }
   public final Object[] getObjectArrayOrNull(NullContainer nnull, CopyElements ignored)  {
      return  getArrayHelper().getObjectArrayOrNull(getRawObject(), nnull, "getRawObject()");
   }
   public final String[] getStringArrayOrNull(NullContainer nnull, CopyElements ignored)  {
      return  getArrayHelper().getStringArrayOrNull(getRawObject(), nnull, "getRawObject()");
   }
   public Object[] toArray()  {
      return  getObjectArrayOrNull(NullContainer.BAD, null);
   }
/*stub functions for non-abstract compile...START
   public Object getRawPArray()  {
      return  null;
   }
   public AbstractListifyPrimitiveEArray getObjectCopy()  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}
