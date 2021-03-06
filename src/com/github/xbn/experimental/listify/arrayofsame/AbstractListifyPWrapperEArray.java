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
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.NullContainer;
   import  java.util.Arrays;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
/**
   <p>For building listifiers whose raw object is a primitive array, and whose virtual elemens are their wrapper-types. Such as a raw object that is an {@code int[]}, and whose virtual elements are {@code java.lang.Integer}-s.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractListifyPWrapperEArray<E> extends AbstractListifyEArray<E> implements ListifyPWrapperEArray<E>  {
   private ListifyPrimitiveableComposer<E> lpb = null;
//constructors...START
   /**
      <p>Create a new {@code AbstractListifyPWrapperEArray}.</p>
    */
   @SuppressWarnings("unchecked")
   public AbstractListifyPWrapperEArray(E[] objects, PrimitiveArrayHelper<E> pa_helper, Class<E> cls_element)  {
      this(objects, pa_helper, cls_element, SimpleNullHandlerForPrimitives.CRASH);
   }
   /**
      <p>Create a new {@code AbstractListifyPWrapperEArray}.</p>
    */
   public AbstractListifyPWrapperEArray(E[] objects, PrimitiveArrayHelper<E> pa_helper, Class<E> cls_element, NullHandlerForPrimitives<E> hnr_nb)  {
      super(objects, pa_helper, (new OneParamCnstrValueCopier<E>(cls_element)));
      lpb = new ListifyPrimitiveableComposer<E>(objects, AddRemovable.NO, pa_helper, getValueCopier(), hnr_nb);
   }
   /**
      <p>Create a new {@code AbstractListifyPWrapperEArray} as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyEArray#AbstractListifyEArray(ListifyEArray) super}{@code (to_copy)}</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see   <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#AbstractListifyPWrapperEArray(E[], xbn.array.PrimitiveArrayHelper, java.lang.Class)">this</a>(E[],pah,cls,copyval)</code>
    * @see   <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#AbstractListifyPWrapperEArray(E[], xbn.array.PrimitiveArrayHelper, java.lang.Class, xbn.util.copyval.NullHandlerForPrimitives)">this</a>(E[],pah,cls,hnvnb)</code>
    */
   public AbstractListifyPWrapperEArray(ListifyPWrapperEArray<E> to_copy)  {
      super(to_copy);
      lpb = new ListifyPrimitiveableComposer<E>(to_copy);
   }
//constructors...END
   @SuppressWarnings("unchecked")
   public E[] getRawEArray()  {
      return  (E[])lpb.getRawObject();
   }
   public Object getRawObject()  {
      return  lpb.getRawObject();
   }
   public final PrimitiveArrayHelper<E> getArrayHelper()  {
      return  (PrimitiveArrayHelper<E>)lpb.getArrayHelper();
   }
   /**
    * @see  #AbstractListifyPWrapperEArray(E[], PrimitiveArrayHelper, ValueCopier, NullHandlerForPrimitives) this(E[],pah,copyval,hnvnb)
    */
   public final NullHandlerForPrimitives<E> getNullHandlerForPrimitives()  {
      return  lpb.getNullHandlerForPrimitives();
   }
   public boolean isAddRemovable()  {
      return  lpb.isAddRemovable();
   }
   public ValueCopier<E> getValueCopier()  {
      return  lpb.getValueCopier();
   }
   protected final int getSizeNPXOkay()  {
      return  getRawEArray().length;
   }
   public final E getElementRTXOkay(int index)  {
      return  getRawEArray()[index];
   }
   public String toString()  {
      return  super.toString() + ", " + lpb.toString();
   }
   public final E[] getEArrayCopyOrNull(NullContainer null_ok, CopyElements copy_elements)  {
      return  Arrays.copyOf(getRawEArray(), size());
   }
//static...START
   public static final <E> E getElementCopyCINullAndHNVCrashOrDel(ListifyPrimitiveable<E> lf_pbl, int index)  {
      return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(lf_pbl, index);
   }
   public static final <E> void ciActionCrashOrDel(ListifyPrimitiveable<E> lf_pbl, int index)  {
      ListifyPrimitiveableComposer.ciActionCrashOrDel(lf_pbl, index);
   }
//static...END
/*stub functions for non-abstract compile...START
   public AbstractListifyPrimitiveEArray<E> getObjectCopy()  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}

