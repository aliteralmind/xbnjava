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
   <p>Listifier whose virtual elements are longs.</p>

   <p><i>All {@code Listify[Type]} are derived from {@link com.github.xbn.experimental.listify.primitiveable.ListifyBoolable ListifyBoolable}. <b>Only edit {@code ListifyBoolable}.</b></i></p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface ListifyLongable extends ListifyPrimitiveable<Long>  {
   /**
      <p>Get an element as a {@code long} primitive--{@code null} elements are handled.</p>

    * @return  If  <code><i>[{@link com.github.xbn.experimental.listify.Listify Listify}]</i>.{@link com.github.xbn.experimental.listify.Listify#get(int) get}(index)</code> is<ul>
         <li>non-{@code null}: {@code get(index)}</li>
         <li>{@code null} and {@code <i>[{@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable super}]</i>.{@link com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveable#getNullHandlerForPrimitives() getNullHandlerForPrimitives}().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#doUseNonNull() doUseNonNull}()} is {@code true}:  <code><i>[super]</i>.getNullHandlerForPrimitives().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#getNonNull() getNonNull}()</code></li>
         </ul></li>
      </ul>
    * @exception  IllegalStateException  If {@code <i>[Listify]</i>.get(index)} is {@code null} and  <code><i>[super]</i>.getNullHandlerForPrimitives().{@link com.github.xbn.util.copyval.NullHandlerForPrimitives#getAction() getAction}().{@link com.github.xbn.util.copyval.ActionForNull#doCrash() doCrash}()</code> or <code>getNullHandlerForPrimitives().getAction().{@link com.github.xbn.util.copyval.ActionForNull#doDelete() doDelete}()</code> is {@code true}.
    */
   long getPLong(int index);
   long[] getPArrayCopyOrNull(NullContainer nnull);
}
