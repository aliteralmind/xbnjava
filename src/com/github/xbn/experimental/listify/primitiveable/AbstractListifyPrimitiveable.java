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
package  com.github.xbn.experimental.listify.primitiveable;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  java.util.Collection;
   import  java.util.List;
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.experimental.listify.ListifyComposer;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
   <P>Abstract implementation of {@code ListifyPrimitiveable}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyPrimitiveable<E> implements ListifyPrimitiveable<E>  {
   private ListifyPrimitiveableComposer<E> lpc = null;
//constructors...START
   /**
      <P>Create a new {@code AbstractListifyPrimitiveable}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer#ListifyPrimitiveableComposer(Object, boolean, PrimitiveArrayHelper, ValueCopier) super}{@code (raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy)}</P>
    **/
   public AbstractListifyPrimitiveable(Object raw_obj, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> primitive_arrHelper, ValueCopier<E> get_valCopy)  {
      lpc = new ListifyPrimitiveableComposer<E>(raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy);
   }
   /**
      <P>Create a new {@code AbstractListifyPrimitiveable}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer#ListifyPrimitiveableComposer(Object, boolean, PrimitiveArrayHelper, ValueCopier, NullHandlerForPrimitives) super}{@code (raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy, null_handler)}</P>
    **/
   public AbstractListifyPrimitiveable(Object raw_obj, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> primitive_arrHelper, ValueCopier<E> get_valCopy, NullHandlerForPrimitives<E> null_handler)  {
      lpc = new ListifyPrimitiveableComposer<E>(raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy, null_handler);
   }
   /**
      <P>Create a new {@code AbstractListifyPrimitiveable} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer#ListifyPrimitiveableComposer(ListifyPrimitiveable) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   public AbstractListifyPrimitiveable(ListifyPrimitiveable<E> to_copy)  {
      lpc = new ListifyPrimitiveableComposer<E>(to_copy);
   }
//constructors...END
   public final E getCopy(int index)  {
      return  getValueCopier().getValueCopy(get(index), "get(" + index + ")", getNullHandlerForPrimitives());
   }
   public final boolean isAddRemovable()  {
      return  lpc.isAddRemovable();
   }
   public final NullHandlerForPrimitives<E> getNullHandlerForPrimitives()  {
      return  lpc.getNullHandlerForPrimitives();
   }
   public ValueCopier<E> getValueCopier()  {
      return  lpc.getValueCopier();
   }
   public PrimitiveArrayHelper<E> getArrayHelper()  {
      return  lpc.getArrayHelper();
   }
   public Object getRawObject()  {
      return  lpc.getRawObject();
   }
   public String toString()  {
      return  lpc.toString();
   }
   public void clear()  {
      lpc.clear();
   }
   public boolean retainAll(Collection<?> coll)  {
      return  lpc.retainAll(coll);
   }
   public boolean removeAll(Collection<?> coll)  {
      return  lpc.removeAll(coll);
   }
   public boolean addAll(Collection<? extends E> coll)  {
      return  lpc.addAll(coll);
   }
   public boolean remove(Object to_remove)  {
      return  lpc.remove(to_remove);
   }
   public boolean add(E to_add)  {
      return  lpc.add(to_add);
   }
//originates in AbstractListify. Needed by AbstractListifyPrimitiveable...START
   public final String getString(int index)  {
      E e = get(index);
      return  ((e == null) ? null : e.toString());
   }
   public final Object getObject(int index)  {
      return  (Object)get(index);
   }
   public final boolean isEmpty()  {
      return  (size() == 0);
   }
   public final boolean isNull(int index)  {
      return  (get(index) == null);
   }
   public final Object[] toArray()  {
      return  getObjectArrayOrNull(NullContainer.BAD, CopyElements.NO);
   }
   public final <T> T[] toArray(T[] array_ofT)  {
      return  getEListCopyOrNull(NullContainer.OK, CopyElements.NO).toArray(array_ofT);
   }
 	public boolean contains(Object to_find)  {
      return  CollectionUtil.xItrContainsY(iterator(), to_find);
   }
 	public boolean containsAll(Collection<?> coll)  {
      return  CollectionUtil.xItrContainsAllY(iterator(), coll);
   }
 	public boolean contains_nullOk(Object to_find)  {
      return  CollectionUtil.xItrContainsY_nullOk(iterator(), to_find);
   }
 	public boolean containsAll_nullOk(Collection<?> coll)  {
      return  CollectionUtil.xItrContainsAllY_nullOk(iterator(), coll);
   }
   public final List<String> getStringListOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getStringListOrNull(getEArrayCopyOrNull(nnull, copy_elements), NullContainer.OK, null);
   }
   public final List<Object> getObjectListOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectListOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, NullContainer.OK, null);
   }
   public final List<E> getEListCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getListOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, NullContainer.OK, null);
   }
   public final String[] getStringArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getStringArrayOrNull(getEArrayCopyOrNull(nnull, copy_elements), NullContainer.OK, null);
   }
   public final Object[] getObjectArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectArrayOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, NullContainer.OK, null);
   }
/*
   protected RuntimeException ciRawObjectNullOrReturnCause(RuntimeException cause)  {
      return  ListifyComposer.ciRawObjectNullOrReturnCause(this, cause);
   }
   protected RuntimeException ciRawObjectNullBadIndexOrReturnCause(int index, RuntimeException cause)  {
      return  ListifyComposer.ciRawObjectNullBadIndexOrReturnCause(this, index, cause);
   }
 */
   protected void ciRawObjectNull()  {
      ListifyComposer.ciRawObjectNull(this);
   }
   protected void ciRawObjectNullOrBadIndex(int index)  {
      ListifyComposer.ciRawObjectNullOrBadIndex(this, index);
   }
   protected ValueCopier<E> getGVCIfCopyElements(CopyElements copy_elements)  {
      return  ListifyComposer.getGVCIfCopyElements(this, copy_elements);
   }
   public final E get(int index)  {
      try  {
         return  getElementRTXOkay(index);
      }  catch(RuntimeException rx)  {
         CrashIfIndex.badForLength(index, size(), "index", "size()");
         throw  rx;
      }
   }
   public final int size()  {
      try  {
         return  getSizeNPXOkay();
      }  catch(RuntimeException rx)  {
         ListifyComposer.ciRawObjectNull(this);
         throw  rx;
      }
   }
   protected abstract int getSizeNPXOkay();
   protected abstract E getElementRTXOkay(int index);
//originates in AbstractListify. Needed by AbstractListifyPrimitiveable...END
   protected E getElementCopyCINullAndHNVCrashOrDel(int index)  {
      return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index);
   }
   protected void ciActionCrash(int index)  {
      ListifyPrimitiveableComposer.ciActionCrashOrDel(this, index);
   }
/*stub functions for non-abstract compile...START
   public final E[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  null;
   }
   public final E get(int index)  {
      return  null;
   }
   public final int size()  {
      return  -1;
   }
   public final java.util.Iterator<E> iterator()  {
      return  null;
   }
   public final Object getPArrayCopyOrNull(NullContainer nnull)  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}

