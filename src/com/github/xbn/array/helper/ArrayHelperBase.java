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
   <p>Base class for {@code ArrayHelper} and {@code PrimitiveArrayHelper}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface ArrayHelperBase<E>  {
   Class<?> getStaticClass();
   int getLength(Object obj_thatIsAnArray, String array_name);
   Object[] getObjectArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad);
   String[] getStringArrayOrNull(Object obj_thatIsAnArray, NullContainer null_ok, String cntrName_forNullBad);
   /**
      <p>Get a new iterator to step through the array's elements.</p>
    */
   Iterator<E> getIterator(Object obj_thatIsAnArray, String array_name);
   /**
      <p>Get a new array of {@code E}, where each element is {@code null}. Use this in lieu of creating generic arrays, such as {@code new E[iLength]}, which is illegal.</p>

    * @see  #getEmpty()
    */
   E[] getInitialized(int length);
   /**
      <p>Get an empty array of {@code E}. This returned array is recommended to be {@code static final}.</p>

    * @see  #getInitialized(int) getInitialized(int)
    */
   E[] getEmpty();
}
