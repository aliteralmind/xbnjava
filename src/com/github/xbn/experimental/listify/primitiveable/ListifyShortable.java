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
package  com.github.xbn.experimental.listify.primitiveable;
   import  com.github.xbn.array.NullContainer;
/**
   <P>Listifier whose virtual elements are shorts. Bermuda.</P>

   <P><I>All {@code Listify[Type]} are derived from {@link com.github.xbn.experimental.listify.primitiveable.ListifyBoolable ListifyBoolable}. <B>Only edit {@code ListifyBoolable}.</B></I></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface ListifyShortable extends ListifyPrimitiveable<Short>  {
   /**
      <P>Get an element as a {@code short} primitive--{@code null} elements are handled.</P>

      @return  If  <CODE><I>[{@link com.github.xbn.experimental.listify.Listify Listify}]</I>.{@link com.github.xbn.experimental.listify.Listify#get(int) get}(index)</CODE> is<UL>
         <LI>non-{@code null}: {@code get(index)}</LI>
         <LI>{@code null} and {@code <I>[{@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable super}]</I>.{@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable#getNullHandlerForPrimitives() getNullHandlerForPrimitives}().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#doUseNonNull() doUseNonNull}()} is {@code true}:  <CODE><I>[super]</I>.getNullHandlerForPrimitives().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#getNonNull() getNonNull}()</CODE></LI>
         </UL></LI>
      </UL>
      @exception  IllegalStateException  If {@code <I>[Listify]</I>.get(index)} is {@code null} and  <CODE><I>[super]</I>.getNullHandlerForPrimitives().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#getAction() getAction}().{@link com.github.xbn.util.copyval.ActionForNull#doCrash() doCrash}()</CODE> or <CODE>getNullHandlerForPrimitives().getAction().{@link com.github.xbn.util.copyval.ActionForNull#doDelete() doDelete}()</CODE> is {@code true}.
    **/
   short getPShort(int index);
   short[] getPArrayCopyOrNull(NullContainer nnull);
}
