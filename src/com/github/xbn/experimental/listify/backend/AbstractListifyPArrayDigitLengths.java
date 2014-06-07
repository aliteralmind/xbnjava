/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.experimental.listify.backend;
   import  java.util.Iterator;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyIntable;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
   import  com.github.xbn.util.copyval.SimpleNullHandler;
/**
   <P>For building listifiers whose raw object is a numeric primitive array, and whose virtual elements is the <I>length</I> of those numbers.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyPArrayDigitLengths<R> extends AbstractListifyIntable  {
   private PrimitiveArrayHelper<R> pahr = null;
//constructors...START
   @SuppressWarnings("unchecked")
   public AbstractListifyPArrayDigitLengths(Object obj_thatIsPrimArr, PrimitiveArrayHelper<R> array_helper)  {
      this(obj_thatIsPrimArr, array_helper, SimpleNullHandlerForPrimitives.CRASH);
   }
   public AbstractListifyPArrayDigitLengths(Object obj_thatIsPrimArr, PrimitiveArrayHelper<R> pah_forRawArrayType, NullHandlerForPrimitives<Integer> null_handler)  {
      super(obj_thatIsPrimArr, null_handler);
      if(pah_forRawArrayType == null)  {
         throw  new NullPointerException("pah_forRawArrayType");
      }
      pahr = pah_forRawArrayType;
   }
   public AbstractListifyPArrayDigitLengths(AbstractListifyPArrayDigitLengths<R> to_copy)  {
      super(to_copy);
   }
//constructors...END
   public PrimitiveArrayHelper<R> getPAHelperForRaw()  {
      return  pahr;
   }
   public final int getInt(int index)  {
      R e = getPAHelperForRaw().getWrapper(getRawObject(), index, "getRawObject()");
      Integer I = ((e == null) ? null : e.toString().length());
      return  SimpleNullHandler.getCopyCIOrigNullAndActionCrashOrDel(getNullHandlerForPrimitives(), I);
   }
   public final int getSizeNPXOkay()  {
      return  getPAHelperForRaw().getLength(getRawObject(), "getRawObject()");
   }
/*stub functions for non-abstract compile...START
   public final Iterator<Integer> iterator()  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}
