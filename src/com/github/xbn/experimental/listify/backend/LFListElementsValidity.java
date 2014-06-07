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
   import  java.util.List;
   import  com.github.xbn.list.ListUtil;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
   <P>Listifier whose virtual elements are booleans expressing the <I>validity</I> of its raw elements.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LFListElementsValidity<R> extends AbstractListifyBooleanValidity<R>  {
//constructors...START
   public LFListElementsValidity(List<R> list, ValueValidator<R> raw_elementVldtr)  {
      super(list, raw_elementVldtr);
   }
   public LFListElementsValidity(List<R> list, ValueValidator<R> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(list, raw_elementVldtr, null_handler);
   }
   public LFListElementsValidity(LFListElementsValidity<R> to_copy)  {
      super(to_copy);
   }
//constructors...END
   @SuppressWarnings("unchecked")
   public final List<R> getRawList()  {
      return  (List<R>)getRawObject();
   }
   public final Iterator<Boolean> iterator()  {
      return  ListUtil.newIteratorForIsElementValid(getRawList(), getVVRawElement());
   }
   protected final R getRawElementRTXOkay(int index)  {
      return  getRawList().get(index);
   }
   protected final int getSizeNPXOkay()  {
      return  getRawList().size();
   }
   public LFListElementsValidity<R> getObjectCopy()  {
      return  (new LFListElementsValidity<R>(this));
   }
}
