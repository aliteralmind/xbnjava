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
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyBoolable;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
/**
   <p>Listifier whose raw object is a primitive boolean array, and whose virtual elements are {@code java.lang.Boolean}-s.</p>

<!--
---nwrq input---
Boolean Boolable Bool boolean
Double Doubleable PDouble double
Float Floatable PFloat float
Long Longable PLong long
Integer Intable Int int
Short Shortable PShort short
Byte Byteable PByte byte
Character Charable Char char

   /&#42;&#42;
      <p>Create a new {@code ListifyBoolable}</p>

      &#64;return  {@code (new }{@link com.github.xbn.experimental.listify.arrayofsame.ListifyBoolEArray#ListifyBoolEArray(boolean[]) ListifyBoolEArray}{@code (prim_array))}
    &#42;&#42;/
   public static final ListifyBoolable forBoolean(boolean[] prim_array)  {
      return  (new ListifyBoolEArray(prim_array));
   }

Use this header (Change Booxl to Bool when done--BUT NOT IN THIS HTML COMMENT!)
/ **
   <p><i>All {@code Listify<i>[Type]</i>Array} classes are derived from {@link ListifyBooxlEArray}. <b>Do not edit any class except {@code ListifyBooxlEArray}.</b></i></p>
 ** /
 -->

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ListifyBoolEArray extends AbstractListifyPrimitiveEArray<Boolean> implements ListifyBoolable  {
//constructors...START
   /**
      <p>Create a new {@code ListifyBoolEArray}.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPrimitiveEArray#AbstractListifyPrimitiveEArray(Object, ValueCopier) super}(obj_thatIsPrimArr, (new {@link com.github.xbn.array.helper.BooleanArrayHelper#BooleanArrayHelper() BooleanArrayHelper}()), (new {@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#OneParamCnstrValueCopier(Class) OneParamCnstrValueCopier}&lt;Boolean&gt;(Boolean.class)))</code></p>

    * @see  #ListifyBoolEArray(boolean[]) ListifyBoolEArray(pah)
    */
   public ListifyBoolEArray(boolean[] obj_thatIsPrimArr)  {
      super(obj_thatIsPrimArr, NewPrimitiveArrayHelper.forBoolean(), (new OneParamCnstrValueCopier<Boolean>(Boolean.class)));
   }
   /**
      <p>Create a new {@code ListifyBoolEArray} as a duplicate of another.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPrimitiveEArray#AbstractListifyPrimitiveEArray(AbstractListifyPrimitiveEArray) super}{@code (to_copy)}</p>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
    * @see  #ListifyBoolEArray(boolean[]) this(boolean[])
    */
   public ListifyBoolEArray(ListifyBoolEArray to_copy)  {
      super(to_copy);
   }
//constructors...END
   /**
    * @return   <code>(boolean[])<i>[{@link com.github.xbn.experimental.listify.ListifyEArrayComposer ListifyEArrayComposer}]</i>.{@link com.github.xbn.experimental.listify.ListifyEArrayComposer#getRawObject() getRawObject}()</code>
    */
   public final boolean[] getRawPArray()  {
      return  (boolean[])getRawObject();
   }
   public final boolean[] getPArrayCopyOrNull(NullContainer nnull)  {
      return  (boolean[])super.getPArrayCopyOrNull(nnull);
   }
   /**
    * @return  {@link #getRawPArray() getRawPArray}{@code ()[index]}
    */
   public final boolean getBool(int index)  {
      try  {
         return  getRawPArray()[index];
      }  catch(RuntimeException rx)  {
         ciArrayNullOrBadIndex(index);
         throw  rx;
      }
   }
   /**
    * @return  <code>(new {@link #ListifyBoolEArray(ListifyBoolEArray) ListifyBoolEArray}(this))</code>
    */
   public ListifyBoolEArray getObjectCopy()  {
      return  (new ListifyBoolEArray(this));
   }
}
