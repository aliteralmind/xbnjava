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
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.experimental.listify.ListifyComposer;
   import  com.github.xbn.experimental.listify.Listify;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  java.util.Iterator;
   import  com.github.xbn.array.helper.ArrayHelperBase;
/**
   <p>For classes that need to implement {@code ListifyEArray}, that cannot extend {@code AbstractListifyEArray}.</p>

   @see  ListifyEArray
   @see  AbstractListifyEArray
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ListifyEArrayComposer<E> extends ListifyComposer<E>  {//implements Listify<E>  {
   /**
      <p>Create a new {@code ListifyEArrayComposer}.</p>

      @param  obj_thatIsArray  The primitive or non-primitive array.
    **/
   public ListifyEArrayComposer(Object obj_thatIsArray, ArrayHelperBase<E> array_helper, ValueCopier<E> get_valCopy)  {
      super(obj_thatIsArray, AddRemovable.NO, array_helper, get_valCopy);
   }
   /**
      <p>Create a new {@code ListifyEArrayComposer} as a duplicate of another.</p>

      <p>This calls<ol>
         <li>{@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(com.github.xbn.experimental.listify.ListifyComposer) super}{@code (to_copy)}</li>
         <li>{@code (to_copy.getRawObject())}</li>
      </ol></p>

      @param  to_copy  May not be {@code null}.
    **/
   public ListifyEArrayComposer(boolean ignored, ListifyEArrayComposer<E> to_copy)  {
      super(ignored, to_copy);
   }
   /**
      <p>Create a new {@code ListifyEArrayComposer} XXX.</p>

      <p>This calls<ol>
         <li>{@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(com.github.xbn.experimental.listify.Listify) super}{@code (to_copy)}</li>
         <li>{@code (to_copy.getRawObject())}</li>
      </ol></p>

      @param  to_copy  May not be {@code null}.
    **/
   public ListifyEArrayComposer(Listify<E> to_copy)  {
      super(to_copy);
   }
   public final Iterator<E> iterator()  {
      return  getArrayHelper().getIterator(getRawObject(), "getRawObject()");
   }
/*stub functions for non-abstract compile...START
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
   public final boolean isNull(int index)  {
      return  false;
   }
   public final E get(int index)  {
      return  null;
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
 stub functions for non-abstract compile...END*/
}
