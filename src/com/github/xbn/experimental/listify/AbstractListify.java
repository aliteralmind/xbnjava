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
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.helper.ArrayHelperBase;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  java.util.List;
   import  java.util.Collection;
   import  com.github.xbn.list.CollectionUtil;
/**
   <P>Abstract implementation of {@code Listify}. For classes that need to implement {@code Listify} but cannot extend this class, see {@link ListifyComposer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListify<E> implements Listify<E>  {
   private ListifyComposer<E> lc = null;
//constructors...START
   /**
      <P>Create a new {@code AbstractListify}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Object, AddRemovable, ArrayHelperBase, ValueCopier) super}{@code (raw_obj, add_rmvbl, array_helper, get_valCopy)}</P>
    **/
   public AbstractListify(Object raw_obj, AddRemovable add_rmvbl, ArrayHelperBase<E> array_helper, ValueCopier<E> get_valCopy)  {
      lc = new ListifyComposer<E>(raw_obj, add_rmvbl, array_helper, get_valCopy);
   }
   /**
      <P>Create a new {@code AbstractListify} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Listify) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   public AbstractListify(Listify<E> to_copy)  {
      lc = new ListifyComposer<E>(to_copy);
   }
//constructors...END
//originates in AbstractListify. Needed by AbstractListifyEArray...START
   public E getCopy(int index)  {
      return  getValueCopier().getValueCopy(get(index), "get(" + index + ")", null);
   }
//originates in AbstractListify. Needed by AbstractListifyPrimitiveable...START
   public final String getString(int index)  {
      E e = get(index);
      return  ((e == null) ? null : e.toString());
   }
   public Object getObject(int index)  {
      return  (Object)get(index);
   }
   public boolean isEmpty()  {
      return  (size() == 0);
   }
   public boolean isNull(int index)  {
      return  (get(index) == null);
   }
   public Object[] toArray()  {
      return  getObjectArrayOrNull(NullContainer.BAD, CopyElements.NO);
   }
   public <T> T[] toArray(T[] array_ofT)  {
      return  getEListCopyOrNull(NullContainer.OK, CopyElements.NO).toArray(array_ofT);
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
   public List<String> getStringListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getStringListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null_ok, null);
   }
   public List<Object> getObjectListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null, null_ok, null);
   }
   public List<E> getEListCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null, null_ok, null);
   }
   public String[] getStringArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getStringArrayOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null_ok, null);
   }
   public Object[] getObjectArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectArrayOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null, null_ok, null);
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
//originates in AbstractListify. Needed by AbstractListifyEArray...END
   public ArrayHelperBase<E> getArrayHelper()  {
      return  lc.getArrayHelper();
   }
   public final boolean isAddRemovable()  {
      return  lc.isAddRemovable();
   }
   public ValueCopier<E> getValueCopier()  {
      return  lc.getValueCopier();
   }
   public Object getRawObject()  {
      return  lc.getRawObject();
   }
   public String toString()  {
      return  lc.toString();
   }
   public void clear()  {
      lc.clear();
   }
   public boolean retainAll(Collection<?> coll)  {
      return  lc.retainAll(coll);
   }
   public boolean removeAll(Collection<?> coll)  {
      return  lc.removeAll(coll);
   }
   public boolean addAll(Collection<? extends E> coll)  {
      return  lc.addAll(coll);
   }
   public boolean remove(Object obj)  {
      return  lc.remove(obj);
   }
   public boolean add(E to_add)  {
      return  lc.add(to_add);
   }
/*stub functions for implements compile...START
   public final E get(int index)  {
      return  null;
   }
   public final int size()  {
      return  -1;
   }
   public final E[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  null;
   }
   public final java.util.Iterator<E> iterator()  {
      return  null;
   }
 stub functions for implements compile...END*/
}
