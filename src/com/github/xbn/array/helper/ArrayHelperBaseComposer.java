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
   import  java.util.Objects;
   import  com.github.xbn.lang.reflect.ReflectRtxUtil;
   import  java.util.Iterator;
   import  org.apache.commons.collections4.iterators.ObjectArrayIterator;
/**
   <p>For classes that need to implement {@code ArrayHelperBase}, that cannot extend an abstract or concrete implementation.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ArrayHelperBaseComposer<E>  {//implements ArrayHelperBase<E>  {
   private Class<?> clsStatic = null;
   public ArrayHelperBaseComposer(Class<?> clto_appendTootClassStatic)  {
      if(clto_appendTootClassStatic == null)  {
         throw  new NullPointerException("clto_appendTootClassStatic");
      }
      clsStatic = clto_appendTootClassStatic;
   }
//constructors...END
   /**
      <p>GetYYY</p>

      YYY

    * @see  #ArrayHelperBaseComposer(Class)
    */
   public Class<?> getStaticClass()  {
      return  clsStatic;
   }
   @SuppressWarnings("unchecked")
   public Iterator<E> getIterator(Object obj_thatIsArray, String array_name)  {
      try  {
         return  (Iterator<E>)(new ObjectArrayIterator(obj_thatIsArray));
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsArray is not an E[]: obj_thatIsArray.getClass().getName()=\"" + obj_thatIsArray.getClass().getName() + "\".  //  Original exception: " + ccx);
      }
   }
   public final void ciObjNullOrUnexpectedType_4prot(Object obj_supposedToBeArr, String array_objName)  {
      Objects.requireNonNull(obj_supposedToBeArr, array_objName);
      ReflectRtxUtil.crashIfNotAssignableFrom(obj_supposedToBeArr.getClass(), getStaticClass());
   }
/*
   public final RuntimeException ciObjNullOrUnexpectedTypeOrReturnCause_4prot(Object obj_supposedToBeArr, String array_objName, RuntimeException cause)  {
      ciObjNullOrUnexpectedType_4prot(obj_supposedToBeArr, array_objName);
      return  cause;
   }
 */
/*stub functions for implements compile...START
 	public final E[] getInitialized(int length)  {
      return  null;
   }
 	public final E[] getEmpty()  {
      return  null;
   }
 stub functions for implements compile...END*/
}
