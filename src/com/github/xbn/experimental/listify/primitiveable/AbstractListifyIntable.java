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
package  com.github.xbn.experimental.listify.primitiveable;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyIntable;
   import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyPrimitiveable;
   import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
   <P>Abstract implementation of {@code ListifyIntable}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyIntable extends AbstractListifyPrimitiveable<Integer> implements ListifyIntable  {
//constructors...START
   @SuppressWarnings("unchecked")
   public AbstractListifyIntable(Object raw_obj)  {
      this(raw_obj, SimpleNullHandlerForPrimitives.CRASH);
   }
   public AbstractListifyIntable(Object raw_obj, NullHandlerForPrimitives<Integer> null_handler)  {
      super(raw_obj, AddRemovable.NO, NewPrimitiveArrayHelper.forInteger(), (new OneParamCnstrValueCopier<Integer>(Integer.class)), null_handler);
   }
//constructors...END
   public final int[] getPArrayCopyOrNull(NullContainer nnull)  {
      if(getRawObject() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getRawObject()");
         return  null;
      }
      int[] ai = new int[size()];
      int j = 0;
      for(int i : this)  {
         ai[j++] = i;
      }
      return  ai;
   }
   public final Integer[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      if(getRawObject() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getRawObject()");
         return  null;
      }
      Integer[] ao = new Integer[size()];
      int j = 0;
      for(Integer I : this)  {
         ao[j++] = I;
      }
      return  ao;
   }
   protected final Integer getElementRTXOkay(int index)  {
      return  getInt(index);
   }
/*stub functions for non-abstract compile...START
   public final java.util.Iterator<Integer> iterator()  {
      return  null;
   }
   public final int getInt(int index)  {
      return  -1;
   }
 stub functions for non-abstract compile...END*/
}
