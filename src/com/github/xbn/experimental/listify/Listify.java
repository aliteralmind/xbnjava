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
package  com.github.xbn.experimental.listify;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.helper.ArrayHelperBase;
   import  java.util.List;
   import  java.util.Collection;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.lang.Copyable;
/**
   <P>For adapting something into a {@code java.util.List} of <I>anything</I>. The primary purpose of listifiers is reusable code: Any code written for a list, can also be used by a {@code Listify}, and therefore by <I>anything</I>. The secondary purpose is for transforming the raw objects to different objects and to different types.</P>
 **/
public interface Listify<E> extends Collection<E>, Copyable  {
   /**
      <P>The underlying, &quot;raw&quot; object. If it contains elements, they are called the &quot;raw&quot; elements.</P>

      @see  #get(int) get(i)
    **/
   Object getRawObject();
   /**
      <P>Can elements be added or removed from the raw object?.</P>

      @return  {@code true}  Elements may be removed or added.
 		@see  ListifyComposer#clear()
 		@see  ListifyComposer#retainAll(Collection) ListifyComposer#retainAll(cll)
 		@see  ListifyComposer#removeAll(Collection) ListifyComposer#removeAll(cll)
 		@see  ListifyComposer#addAll(Collection) ListifyComposer#addAll(cll)
 		@see  ListifyComposer#remove(Object) ListifyComposer#remove(o)
 		@see   <CODE><A HREF="ListifyComposer.html"><I>[ListifyComposer]</I></A>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ListifyComposer.html#add(E)">add</A>(E)</CODE>
 	 **/
   boolean isAddRemovable();
   /**
      <P>For creating initialized arrays of type {@code E}, and if {@code E} is a primitive wrapper-type, an initialized primitive array. This is required in order to create new arrays of a generic type (type {@code E}).</P>
    **/
   ArrayHelperBase<E> getArrayHelper();
   /**
      <P>For duplicating virtual elements, when possible.</P>
    **/
   ValueCopier<E> getValueCopier();
   /**
      <P>Get all virtual elements in a new array of {@code E}.</P>

      @param  nnull  If the <A HREF="#getRawObject()">raw object</A> is {@code null}, and this parameter is<UL>
         <LI>non-{@code null}: crash ({@code is_nullCntrOk} is the name of the function calling this one)</LI>
         <LI>{@code null}: <I><B>return</B></I> {@code null}</LI>
      </UL>.
      @param  do_copy  If {@code true}, then each element is also duplicated. If {@code false} the returned array refers to the original elements.
      @exception  IllegalStateException  If {@code do_copy} is {@code true} and <CODE>{@link #getValueCopier() getValueCopier}().{@link com.github.xbn.util.copyval.ValueCopier#isValueCopyable() isValueCopyable}()</CODE> is {@code false}.
      @see  com.github.xbn.array.IndexableUtil#crashIfContainerIsNullAndThatIsBad(boolean, boolean) CrashIfObject#crashIfContainerIsNullAndThatIsBad(s,s)
      @see  #getEListCopyOrNull(NullContainer, CopyElements) getEListCopyOrNull(nci,dce)
      @see  #getObjectArrayOrNull(NullContainer, CopyElements) getObjectArrayOrNull(nci,dce)
      @see  #getStringArrayOrNull(NullContainer, CopyElements) getStringArrayOrNull(nci,dce)
      @see  #getObjectListOrNull(NullContainer, CopyElements) getObjectListOrNull(nci,dce)
      @see  #getStringListOrNull(NullContainer, CopyElements) getStringListOrNull(nci,dce)
    **/
   E[] getEArrayCopyOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>Get all virtual elements in a new list of {@code E}.</P>

      @see  #getEArrayCopyOrNull(NullContainer, CopyElements) getEArrayCopyOrNull(nci,dce)
    **/
   List<E> getEListCopyOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>Get all virtual elements in a new array of objects.</P>

      @see  #getEArrayCopyOrNull(NullContainer, CopyElements) getEArrayCopyOrNull(nci,dce)
    **/
   Object[] getObjectArrayOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>Get all virtual elements in a new array of strings.</P>

      @see  #getEArrayCopyOrNull(NullContainer, CopyElements) getEArrayCopyOrNull(nci,dce)
    **/
   String[] getStringArrayOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>Get all virtual elements in a new array of objects.</P>

      @see  #getEArrayCopyOrNull(NullContainer, CopyElements) getEArrayCopyOrNull(nci,dce)
    **/
   List<Object> getObjectListOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>Get all virtual elements in a new array of strings.</P>

      @see  #getEArrayCopyOrNull(NullContainer, CopyElements) getEArrayCopyOrNull(nci,dce)
    **/
   List<String> getStringListOrNull(NullContainer nnull, CopyElements do_copy);
   /**
      <P>The number of virtual elements in this listifier.</P>

      @exception  NullPointerException  If {@code getRawObject()} is {@code null}.
    **/
   @Override
   int size();
   /**
      <P>Get a virtual element. By definition, virtual elements are of type {@code E}. They may or may not be the same type as those in {@link #getRawObject() getRawObject}{@code ()}--assuming that the raw object is even of a type that potentially contains elements.</P>

      @param  index  The index of the element to retrieve. Must be valid given {@link #size() size}{@code ()}.
      @exception  NullPointerException  If the underlying object is {@code null}.
      @see  #isNull(int) isNull(i)
    **/
   E get(int index);
   /**
      <P>Is an element {@code null}?.</P>

      @return  <CODE>({@link #get(int) get}(index) == null)</CODE>
    **/
   boolean isNull(int index);
   /**
      <P>Duplicate an element.</P>

      @param  index  The index of the element to duplicate. Must be valid given {@link #size() size}{@code ()}.
      @exception  IllegalStateException  If <CODE>{@link #getValueCopier() getValueCopier}().{@link com.github.xbn.util.copyval.ValueCopier#isValueCopyable() isValueCopyable}()</CODE> is {@code false}.
    **/
   E getCopy(int index);
   /**
      <P>Get an element as an object.</P>

      @return  <CODE>(Object){@link #get(int) get}(index)</CODE>
    **/
   Object getObject(int index);
   /**
      <P>Get an element as a string.</P>

      @return  If <CODE>{@link #isNull(int) isNull}(index)</CODE> is<UL>
         <LI>{@code true}: {@code null}</LI>
         <LI>{@code false}: {@link #get(int) get}{@code (index)}</LI>
      </UL>
    **/
   String getString(int index);
   /**
      <P>Does the collection contain an equivalent object?--this considers {@code null} as equal to {@code null}.</P>

      @return  {@code true} If<UL>
         <LI>{@code obj} is {@code null}, and there is at least one {@code null} element in this collection.</LI>
         <LI>{@code obj} is non-{@code null}, and there is an equivalent object in this collection, such that <CODE>obj.equals(<I>[element]</I>)</CODE> is true.</LI>
      </UL>
      @exception  NullPointerException  If ...

      @see  #containsAll_nullOk(Collection) containsAll_nullOk(cll)
    **/
   boolean contains_nullOk(Object obj);
   /**
      <P>Is every object in a collection in <I>{@code this}</I> collection?--this considers {@code null} as equal to {@code null}.</P>

      <P>For each element in {@code coll}, this calls <CODE>{@link #contains_nullOk(Object) contains_nullOk}(<I>[element]</I>)</CODE></P>

      @return  {@code true} If every call to {@code contains_nullOk(o)} is {@code true}.
      @exception  NullPointerException  ...
    **/
   boolean containsAll_nullOk(Collection<?> coll);
   /**
      <P>Get a duplicate of this {@code Listify} that is a complete (full-and-deep) copy, with the exception of the {@code getRawObject()}, which is a reference to the original. See {@link #getRawObject() getRawObject}{@code ()}.</P>

      @return  A duplicate of this {@code Listify} as specified above.
    **/
   Copyable getObjectCopy();
}
