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
   import  java.util.Iterator;
/**
   <p>Implementation of {@code ArrayHelper}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractArrayHelper<E> implements ArrayHelper<E>  {
   private final ArrayHelperComposer<E> ahc;
   public AbstractArrayHelper(Class<E[]> cls_dotClassStatic)  {
      ahc = new ArrayHelperComposer<E>(cls_dotClassStatic);
   }
   public Class<E[]> getStaticClass()  {
      return  ahc.getStaticClass();
   }
   public Iterator<E> getIterator(E[] array, String array_name)  {
      return  ahc.getIterator(array, array_name);
   }
   public Iterator<E> getIterator(Object obj_thatIsArray, String array_name)  {
      return  ahc.getIterator(obj_thatIsArray, array_name);
   }
   public final int getLength(E[] array, String array_name)  {
      return  ahc.getLength(array, array_name);
   }
   public final int getLength(Object obj_thatIsAnArray, String array_name)  {
      return  ahc.getLength(obj_thatIsAnArray, array_name);
   }
   public final Object[] getObjectArrayOrNull(E[] array, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ahc.getObjectArrayOrNull(array, null_ok, cntrName_forNullBad);
   }
   public final String[] getStringArrayOrNull(E[] array, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ahc.getStringArrayOrNull(array, null_ok, cntrName_forNullBad);
   }
   public final Object[] getObjectArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ahc.getObjectArrayOrNull(obj_thatIsAnArray, null_ok, cntrName_forNullBad);
   }
   public final String[] getStringArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad)  {
      return  ahc.getStringArrayOrNull(obj_thatIsAnArray, null_ok, cntrName_forNullBad);
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
