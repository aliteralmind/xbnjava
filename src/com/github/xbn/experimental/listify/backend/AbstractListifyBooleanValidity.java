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
package  com.github.xbn.experimental.listify.backend;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyBoolable;
/**
   <P>For building listifiers whose virtual elements express the <I>validity</I> of its raw elements.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyBooleanValidity<R> extends AbstractListifyBoolable  {
   private ValueValidator<R> vvre = null;
//constructors...START
   /**
      <P>Create a new {@code ListifyBooleanValidity}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.AbstractListifyBoolable#AbstractListifyBoolable(Object) super}{@code (raw_obj)}</P>
    **/
   public AbstractListifyBooleanValidity(Object raw_obj, ValueValidator<R> raw_elementVldtr)  {
      super(raw_obj);
      setVVRE(raw_elementVldtr);
   }
   /**
      <P>Create a new {@code ListifyBooleanValidity}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.AbstractListifyBoolable#AbstractListifyBoolable(Object, NullHandlerForPrimitives) super}{@code (raw_obj, null_handler)}</P>
    **/
   public AbstractListifyBooleanValidity(Object raw_obj, ValueValidator<R> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(raw_obj, null_handler);
      setVVRE(raw_elementVldtr);
   }
      private void setVVRE(ValueValidator<R> raw_elementVldtr)  {
         if(raw_elementVldtr == null)  {
            throw  new NullPointerException("raw_elementVldtr");
         }
         vvre = raw_elementVldtr;
      }
   /**
      <P>Create a new {@code AbstractListifyBooleanValidity} as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.experimental.listify.primitiveable.AbstractListifyBoolable#AbstractListifyBoolable(AbstractListifyBoolable) super}{@code (to_copy)}</LI>
         <LI>YYY</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   @SuppressWarnings("unchecked")
   public AbstractListifyBooleanValidity(AbstractListifyBooleanValidity<R> to_copy)  {
      super(to_copy);

         @SuppressWarnings("unchecked")
         ValueValidator<R> cpbl2 = (ValueValidator<R>)ObjectOrCrashIfNull.
            <ValueValidator>getCopy(to_copy.getVVRawElement(), ValueValidator.class, "to_copy.getVVRawElement()");
      ValueValidator<R> vvre = cpbl2;
   }
//constructors...END
   public ValueValidator<R> getVVRawElement()  {
      return  vvre;
   }
   public final boolean getBool(int index)  {
      try  {
         return  getVVRawElement().isValid(getRawElementRTXOkay(index));
      }  catch(RuntimeException rx)  {
         ciRawObjectNullOrBadIndex(index);
         throw  new RuntimeException("Attempting getVVRawElement().isValid(getRawElement(index))", rx);
      }
   }
   protected abstract R getRawElementRTXOkay(int index);
/*stub functions for non-abstract compile...START
   public final int size()  {
      return  -1;
   }
   public final java.util.Iterator<Boolean> iterator()  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}
