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
package  com.github.xbn.experimental.listify.primitiveable;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.copyval.SimpleNullHandler;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.experimental.listify.ListifyComposer;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
/**
   <p>For classes that need to implement {@code ListifyPrimitiveable}, that cannot extend {@code AbstractListifyPrimitiveable}</p>

 * @see  ListifyPrimitiveable
 * @see  AbstractListifyPrimitiveable
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ListifyPrimitiveableComposer<E> extends ListifyComposer<E>  {//implements ListifyPrimitiveable<E>  {
   private NullHandlerForPrimitives<E> hnvnb = null;
//constructors...START
   /**
      <p>Create a new {@code ListifyPrimitiveableComposer}.</p>

      YYY

      ...{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives SimpleNullHandlerForPrimitives.}{@link com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives#CRASH CRASH})}
    */
   @SuppressWarnings("unchecked")
   public ListifyPrimitiveableComposer(Object raw_obj, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> primitive_arrHelper, ValueCopier<E> get_valCopy)  {
      this(raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy, SimpleNullHandlerForPrimitives.CRASH);
   }
   public ListifyPrimitiveableComposer(Object raw_obj, AddRemovable add_rmvbl, PrimitiveArrayHelper<E> primitive_arrHelper, ValueCopier<E> get_valCopy, NullHandlerForPrimitives<E> null_handler)  {
      super(raw_obj, add_rmvbl, primitive_arrHelper, get_valCopy);
      if(null_handler == null)  {
         throw  new NullPointerException("null_handler");
      }
      hnvnb = null_handler;
   }
   /**
      <p>Create a new {@code ListifyPrimitiveableComposer} as a duplicate of another.</p>

      YYY

      <p>This<ol>
         <li>Calls {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(boolean, ListifyComposer) super}{@code (ignored, to_copy)}</li>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public ListifyPrimitiveableComposer(boolean ignored, ListifyPrimitiveableComposer<E> to_copy)  {
      super(ignored, to_copy);

      @SuppressWarnings("unchecked")
      NullHandlerForPrimitives<E> hnvnb2 = (NullHandlerForPrimitives<E>)ObjectOrCrashIfNull.
         <NullHandlerForPrimitives>getCopy(to_copy.getNullHandlerForPrimitives(), NullHandlerForPrimitives.class, "to_copy.getNullHandlerForPrimitives()");
      hnvnb = hnvnb2;
   }
   /**
      <p>Create a new {@code ListifyPrimitiveableComposer} from a {@code ListifyPrimitiveable}.</p>

      YYY

      <p>This<ol>
         <li>Calls {@link com.github.xbn.experimental.listify.ListifyComposer#ListifyComposer(Listify) super}{@code (to_copy)}</li>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public ListifyPrimitiveableComposer(ListifyPrimitiveable<E> to_copy)  {
      super(to_copy);
      hnvnb = (NullHandlerForPrimitives<E>)to_copy.getNullHandlerForPrimitives().getObjectCopy();
   }
//constructors...END
   public NullHandlerForPrimitives<E> getNullHandlerForPrimitives()  {
      return  hnvnb;
   }
   public PrimitiveArrayHelper<E> getArrayHelper()  {
      return  (PrimitiveArrayHelper<E>)super.getArrayHelper();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  super.appendToString(to_appendTo).append(", getNullHandlerForPrimitives()=[").append(getNullHandlerForPrimitives()).append("]");
   }
//static...START
   public static final <E> E getElementCopyCINullAndHNVCrashOrDel(ListifyPrimitiveable<E> listifier, int index)  {
      try  {
         return  SimpleNullHandler.getCopyCIOrigNullAndActionCrashOrDel(listifier.getNullHandlerForPrimitives(), listifier.get(index));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(listifier, "listifier", null, rx);
      }
   }
   /**
      <p>Get the message for when calling a {@code get[PrimitiveType](index)} (such as {@code getBool(i)}), and the if-{@code null} behavior is {@code CRASH} or {@code DELETE}.</p>
    */
   public static final <E> void ciActionCrashOrDel(ListifyPrimitiveable<E> listifier, int index)  {
      try  {
         SimpleNullHandler.ciActionCrashOrDel(listifier.getNullHandlerForPrimitives());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(listifier, "listifier", null, rx);
      }
   }
//static...END
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
   public final void clear()  {
   }
   public final boolean retainAll(Collection<?> coll)  {
      return  false;
   }
   public final boolean removeAll(Collection<?> coll)  {
      return  false;
   }
   public final boolean addAll(Collection<? extends E> coll)  {
      return  false;
   }
   public final boolean remove(Object obj)  {
      return  false;
   }
   public final boolean add(E to_add)  {
      return  false;
   }
 stub functions for implements compile...END*/
}
