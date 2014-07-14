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
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.NullContainer;
   import  java.util.Collection;
   import  java.util.Iterator;
   import  java.util.List;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.helper.ArrayHelper;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.experimental.listify.ListifyComposer;
   import  com.github.xbn.util.copyval.ValueCopier;
/**
   <P>Base class for a listifier whose raw object is a non-primitive array of any <I>non wrapper type</I>  (not {@code java.lang.Integer}s, for instance), and whose virtual elements are of the same type.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NonPrimitiveEArrayBase<E> implements ListifyNonPrimitiveEArray<E>  {
   private ListifyEArrayComposer<E> leac = null;
//constructors...START
   /**
      <P>Create a new {@code NonPrimitiveEArrayBase}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/experimental/listify/ListifyComposer#ListifyComposer(E[], ValueCopier)">super</A>(objects, array_helper, get_valCopy)</CODE></P>
    **/
   public NonPrimitiveEArrayBase(E[] objects, ArrayHelper<E> array_helper, ValueCopier<E> get_valCopy)  {
      leac = new ListifyEArrayComposer<E>(objects, array_helper, get_valCopy);
   }
   /**
      <P>Create a new {@code NonPrimitiveEArrayBase} from a {@code ListifyNonPrimitiveEArray}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Listify) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   public NonPrimitiveEArrayBase(ListifyNonPrimitiveEArray<E> to_copy)  {
      leac = new ListifyEArrayComposer<E>(to_copy);
   }
//constructors...END
   public final Iterator<E> iterator()  {
      return  leac.iterator();
   }
   public ArrayHelper<E> getArrayHelper()  {
      return  (ArrayHelper<E>)leac.getArrayHelper();
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
   @SuppressWarnings("unchecked")
   public E[] getRawEArray()  {
      return  (E[])getRawObject();
   }
//originates in AbstractListify. Needed by AbstractListifyEArray...START
   public final E get(int index)  {
      try  {
         return  getRawEArray()[index];
      }  catch(RuntimeException rx)  {
         ListifyComposer.ciRawObjectNullOrBadIndex(this, index);
         throw  rx;
      }
   }
   public final E getCopy(int index)  {
      return  getValueCopier().getValueCopy(get(index), "get(" + index + ")", null);
   }
   public final String getString(int index)  {
      return  (String)get(index);
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
   public final List<String> getStringListOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getStringListOrNull(getEArrayCopyOrNull(nnull, copy_elements), nnull, null);
   }
   public final List<Object> getObjectListOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectListOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, nnull, null);
   }
   public final List<E> getEListCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getListOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, nnull, null);
   }
   public final String[] getStringArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getStringArrayOrNull(getEArrayCopyOrNull(nnull, copy_elements), nnull, null);
   }
   public final Object[] getObjectArrayOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtil.getObjectArrayOrNull(getEArrayCopyOrNull(nnull, copy_elements), null, nnull, null);
   }
//originates in AbstractListify. Needed by AbstractListifyEArray...END
   public final E getElementRTXOkay(int index)  {
      return  getRawEArray()[index];
   }
   public final int size()  {
      try  {
         return  getRawEArray().length;
      }  catch(RuntimeException rx)  {
         ListifyComposer.ciRawObjectNull(this);
         throw  rx;
      }
   }
   public final E[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      if(getRawEArray() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getRawObject()");
         return  null;
      }

      try  {
         if(copy_elements.isNo())  {
            return  getRawEArray();
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(copy_elements, "copy_elements", null, rx);
      }

      E[] ae = getArrayHelper().getInitialized(size());
      for(int i = 0; i < size(); i++)  {
         ae[i] = getCopy(i);
      }
      return  ae;
   }
   public NonPrimitiveEArrayBase<E> getObjectCopy()  {
      return  (new NonPrimitiveEArrayBase<E>(this));
   }
}
