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
package  com.github.xbn.array.helper;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.array.ArrayUtil;
   import  java.util.Iterator;
/**
   <P>For classes that need to implement {@code ArrayHelper}, that cannot extend {@code AbstractArrayHelper}.</P>

   @see  AbstractArrayHelper
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ArrayHelperComposer<E> extends ArrayHelperBaseComposer<E>  {//implements ArrayHelper<E>  {
//constructors...START
   public ArrayHelperComposer(Class<E[]> cls_dotClassStatic)  {
      super(cls_dotClassStatic);
   }
//constructors...END
   public Class<E[]> getStaticClass()  {

      //The super-class is <?>, to conform to both primitive and
      //non-primitive types. This classes constructor is <E[]>.
      @SuppressWarnings("unchecked")
      Class<E[]> clse = (Class<E[]>)super.getStaticClass();

      return  clse;
   }
   public Iterator<E> getIterator(E[] array, String array_name)  {
      return  super.getIterator(array, array_name);
   }
   public final int getLength(E[] array, String array_name)  {
      try  {
         return  array.length;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(array, array_name, null, rx);
      }
   }
   @SuppressWarnings("unchecked")
   public final int getLength(Object obj_thatIsAnArray, String array_name)  {
      try  {
         return  getLength((E[])obj_thatIsAnArray, array_name);
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("Attempting getLength((E[])obj_thatIsAnArray, null_ok, cntrName_forNullBad): " + ccx);
      }
   }
   public final Object[] getObjectArrayOrNull(E[] array, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ArrayUtil.getObjectArrayOrNull(array,  null, null_ok, cntrName_forNullBad);
   }
   public final String[] getStringArrayOrNull(E[] array, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ArrayUtil.getStringArrayOrNull(array, null_ok, cntrName_forNullBad);
   }
   @SuppressWarnings("unchecked")
   public final Object[] getObjectArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad)  {
      try  {
         return  getObjectArrayOrNull((E[])obj_thatIsAnArray, null_ok, cntrName_forNullBad);
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("Attempting getObjectArrayOrNull((E[])obj_thatIsAnArray, null_ok, cntrName_forNullBad): " + ccx);
      }
   }
   @SuppressWarnings("unchecked")
   public final String[] getStringArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad)  {
      try  {
         return  getStringArrayOrNull((E[])obj_thatIsAnArray, null_ok, cntrName_forNullBad);
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("Attempting getStringArrayOrNull((E[])obj_thatIsAnArray, null_ok, cntrName_forNullBad): " + ccx);
      }
   }
/*stub functions for implements compile...START
 	public final E[] getInitialized(int length)  {
      return  null;
   }
 	public final E[] getEmpty()  {
      return  null;
   }
 stub functions for implements compile...END*/
}
