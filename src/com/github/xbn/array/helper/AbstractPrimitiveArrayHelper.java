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
package  com.github.xbn.array.helper;
   import  com.github.xbn.array.NullContainer;
   import  java.util.Objects;
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.lang.reflect.ReflectRtxUtil;
   import  java.util.Iterator;
   import  org.apache.commons.collections4.iterators.ArrayIterator;
/**
   <p>Implementation of {@code PrimitiveArrayHelper}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractPrimitiveArrayHelper<E> implements PrimitiveArrayHelper<E>  {
   private  ArrayHelperBaseComposer<E> ahbc = null;
   public AbstractPrimitiveArrayHelper(Class<?> clto_appendTootClassStatic)  {
      ahbc = new ArrayHelperBaseComposer<E>(clto_appendTootClassStatic);
   }
   public Iterator<E> getIterator(Object obj_thatIsPrimArr, String array_name)  {
      return  (new ArrayIterator<E>(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)));
   }
   protected final void ciObjNullUnexpectedTypeOrBadIndex(Object obj_supposedToBeArr, int index, String array_name)  {
      Objects.requireNonNull(obj_supposedToBeArr, array_name);
      ReflectRtxUtil.crashIfNotAssignableFrom(obj_supposedToBeArr.getClass(), getStaticClass());
      int iLen = getLength(obj_supposedToBeArr, array_name);
      CrashIfIndex.badForLength(index, iLen, "index", "getLength(obj_thatIsPrimArr, ...)");
   }
/*
   protected final RuntimeException ciObjNullUnexpectedTypeBadIdxOrReturnCause(Object obj_supposedToBeArr, String array_name, int index, RuntimeException cause)  {
      ciObjNullUnexpectedTypeOrBadIndex(obj_supposedToBeArr, index, array_name);
      return  regetRtxCrashIfNull(cause, "cause");
   }
   protected final RuntimeException ciObjNullOrUnexpectedTypeOrReturnCause(Object obj_supposedToBeArr, String array_objName, RuntimeException cause)  {
      ahbc.ciObjNullOrUnexpectedType_4prot(obj_supposedToBeArr, array_objName);
      throw  rx;
   }
 */
   public Class<?> getStaticClass()  {
      return  ahbc.getStaticClass();
   }
   protected final void ciObjNullOrUnexpectedType(Object obj_supposedToBeArr, String array_objName)  {
      ahbc.ciObjNullOrUnexpectedType_4prot(obj_supposedToBeArr, array_objName);
   }
/*stub functions for non-abstract compile...START
   public final Object getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  null;
   }
 	public final E[] getInitialized(int length)  {
      return  null;
   }
 	public final E[] getEmpty()  {
      return  null;
   }
   public final Object getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  null;
   }
   public final int getLength(Object obj_thatIsPrimArr, String array_name)  {
      return  -1;
   }
   public final E getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      return  null;
   }
   public final E[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  null;
   }
   public final Object getInitializedPrimitive(int length)  {
      return  null;
   }
   public final Object getEmptyPrimitive()  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}
