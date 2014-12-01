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
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.NullContainer;
   import  java.util.Collection;
   import  java.util.Iterator;
   import  java.util.List;
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.helper.ArrayHelperBase;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.experimental.listify.ListifyComposer;
   import  com.github.xbn.util.copyval.ValueCopier;
/**
   <p>For building listifiers whose raw objects are arrays (primitive or non-primitive), and whose virtual elements are of the same type. For primitive arrays, the virtual type is their primitive wrapper (such as {@code int[]} and {@code java.lang.Integer[]}).</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractListifyEArray<E> implements ListifyEArray<E>  {
   private ListifyEArrayComposer<E> leac = null;
   /**
      <p>Create a new {@code AbstractListifyEArray}.</p>

      YYY

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.arrayofsame.ListifyEArrayComposer#ListifyEArrayComposer(Object, ArrayHelperBase, ValueCopier) super}{@code (obj_thatIsArray, array_helper, get_valCopy)}</p>
    */
   public AbstractListifyEArray(Object obj_thatIsArray, ArrayHelperBase<E> array_helper, ValueCopier<E> get_valCopy)  {
      leac = new ListifyEArrayComposer<E>(obj_thatIsArray, array_helper, get_valCopy);
   }
   /**
      <p>Create a new {@code AbstractListifyEArray} as a duplicate of another.</p>

      YYY

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.arrayofsame.ListifyEArrayComposer#ListifyEArrayComposer(com.github.xbn.list.listify.arrayofsame.ListifyEArrayBase) super}{@code (to_copy)}</p>

    * @param  to_copy  May not be {@code null}.
    */
   public AbstractListifyEArray(ListifyEArray<E> to_copy)  {
      leac = new ListifyEArrayComposer<E>(to_copy);
   }
   public final Iterator<E> iterator()  {
      return  leac.iterator();
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
//originates in AbstractListify. Needed by AbstractListifyEArray...START
   public final E getCopy(int index)  {
      return  getValueCopier().getValueCopy(get(index), "get(" + index + ")");
   }
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
      return  getEListCopyOrNull(NullContainer.BAD, CopyElements.NO).toArray(array_ofT);
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
   public final List<String> getStringListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getStringListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null_ok, null);
   }
   public final List<Object> getObjectListOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null, null_ok, null);
   }
   public final List<E> getEListCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getListOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null, null_ok, null);
   }
   public final String[] getStringArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  ArrayUtil.getStringArrayOrNull(getEArrayCopyOrNull(null_ok, copy_elements), null_ok, null);
   }
   public final Object[] getObjectArrayOrNull(NullContainer null_ok, CopyElements copy_elements)  {
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
//originates in AbstractListify. Needed by AbstractListifyEArray...END
/*stub functions for non-abstract compile...START
   public final E[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  null;
   }
   protected final E getElementRTXOkay(int index)  {
      return  null;
   }
   protected final int getSizeNPXOkay()  {
      return  -1;
   }
 stub functions for non-abstract compile...END*/
}
