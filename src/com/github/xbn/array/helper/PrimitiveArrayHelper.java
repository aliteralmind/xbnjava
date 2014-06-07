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
/**
   <P>Creates initialized primitive arrays and non-primitive arrays of its wrapper-type, and provides basic access and conversion for objects-that-are-actually-primitive-arrays.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface PrimitiveArrayHelper<E> extends ArrayHelperBase<E>  {
   /**
      <P>YYY</P>
    **/
   Object getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad);
   Object getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad);
   /**
      @param  obj_thatIsPrimArr  May not be {@code null}, and must be a primitive array whose wrapper-type is {@code E}.
      @param  array_name  Descriptive name of {@code obj_thatIsPrimArr}. <I>Should</I> not be {@code null} or empty.
      @return  <CODE>{@link #getPrimitiveArray(Object, NullContainer, String) getPrimitiveArray}(obj_thatIsPrimArr, {@link com.github.xbn.array.NullContainer NullContainer}.{@link com.github.xbn.array.NullContainer#BAD BAD}, array_name).length</CODE>
    **/
   int getLength(Object obj_thatIsPrimArr, String array_name);
   /**
      @param  obj_thatIsPrimArr  May not be {@code null}, and must be a primitive array whose wrapper-type is {@code E}.
      @param  array_name  Descriptive name of {@code obj_thatIsPrimArr}. <I>Should</I> not be {@code null} or empty.
    **/
   E getWrapper(Object obj_thatIsPrimArr, int index, String array_name);
   E[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad);
   Object getInitializedPrimitive(int length);
   Object getEmptyPrimitive();
}
