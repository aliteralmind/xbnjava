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
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.array.helper.ObjectArrayHelper;
   import  com.github.xbn.array.helper.StringArrayHelper;
   import  com.github.xbn.array.helper.StringBuilderArrayHelper;
   import  com.github.xbn.util.copyval.ValueNotCopyable;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
/**
   <p>Convenience functions for creating listifiers whose raw object is a non-primitive array, and whose virtual elements are of the same type.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewListifyNonPEArray  {
   private NewListifyNonPEArray()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>Create a new {@code NonPrimitiveEArrayBase} for an array of objects.</p>

    * @return  <code>(new <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#NonPrimitiveEArrayBase(E[], ArrayHelper, ValueCopier)">this</a>&lt;Object&gt;(array, false, (new ObjectArrayHelper()), ({@link com.github.xbn.util.copyval.ValueCopier ValueCopier}&lt;Object&gt;){@link com.github.xbn.util.copyval.ValueNotCopyable ValueNotCopyable}.INSTANCE))</code>

    * @see  #forString(String[]) forString(s[])
    * @see  #stringBuilder(StringBuilder[]) stringBuilder(sd[])
    * @see  #forObject(Object[]) forObject(o[])
    */
   @SuppressWarnings("unchecked")
   public static final NonPrimitiveEArrayBase<Object> forObject(Object[] array)  {
      return  (new NonPrimitiveEArrayBase<Object>(array, (new ObjectArrayHelper()), (ValueCopier<Object>)ValueNotCopyable.INSTANCE));
   }
   /**
      <p>Create a new {@code NonPrimitiveEArrayBase} for an array of strings.</p>

    * @return  <code>(new <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#NonPrimitiveEArrayBase(E[], ArrayHelper, ValueCopier)">this</a>&lt;String&gt;(array, (new {@link com.github.xbn.array.helper.StringArrayHelper#StringArrayHelper() StringArrayHelper}()), OneParamCnstrValueCopier.STRING))</code>
    * @see  #forObject(Object[]) forObject(o[])
    */
   public static final NonPrimitiveEArrayBase<String> forString(String[] array)  {
      return  (new NonPrimitiveEArrayBase<String>(array, (new StringArrayHelper()), OneParamCnstrValueCopier.STRING));
   }
   /**
      <p>Create a new {@code NonPrimitiveEArrayBase} for an array of string-builders.</p>

    * @return  <code>(new <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#NonPrimitiveEArrayBase(E[], ArrayHelper, ValueCopier)">this</a>&lt;StringBuilder&gt;(array, (new {@link com.github.xbn.array.helper.StringBuilderArrayHelper#StringBuilderArrayHelper() StringBuilderArrayHelper}()), OneParamCnstrValueCopier.STRING_BUILDER))</code>
    * @see  #forObject(Object[]) forObject(o[])
    */
   public static final NonPrimitiveEArrayBase<StringBuilder> stringBuilder(StringBuilder[] array)  {
      return  (new NonPrimitiveEArrayBase<StringBuilder>(array, (new StringBuilderArrayHelper()), OneParamCnstrValueCopier.STRING_BUILDER));
   }
}
