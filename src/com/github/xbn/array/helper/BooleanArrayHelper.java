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
package  com.github.xbn.array.helper;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.number.CrashIfIntIs;
   import  com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs;
   import  com.github.xbn.array.primitive.ObjectArrayFromPrimitive;
   import  com.github.xbn.array.primitive.StringArrayFromPrimitive;
   import  com.github.xbn.array.primitive.WrapperArrayFromPrimitive;
   import  org.apache.commons.lang3.ArrayUtils;
/**
   <p>{@code PrimitiveArrayHelper} for booleans. {@code PrimitiveArrayHelper}-s for all other types are internal to {@link com.github.xbn.array.helper.NewPrimitiveArrayHelper NewPrimitiveArrayHelper}, and are all derived from this class.</p>
<!--
---nwrq input---
Boolean boolean BOOLEAN_O BOOLEAN Bool
Double double DOUBLE_O DOUBLE PDouble
Float float FLOAT_O FLOAT PFloat
Long long LONG_O LONG PLong
Integer int INTEGER_O INT Int
Short short SHORT_O SHORT PShort
Byte byte BYTE_O BYTE PByte
Character char CHARACTER_O CHAR Char

/&#42;&#42;
   <p>This class is derived from BooxleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooxleanArrayHelper ONLY!</p>
 &#42;&#42;/
 -->

 	@since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class BooleanArrayHelper extends AbstractPrimitiveArrayHelper<Boolean>  {
   public BooleanArrayHelper()  {
      super(boolean[].class);
   }
   /**
    * @return  {@link com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs PrimitiveArrayFromObjThatIs.}{@link com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs#forBoolean(Object, NullContainer, String) forBoolean}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad)}
    */
   public boolean[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forBoolean(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   /**
    * @return  <code>(new Boolean({@link #getPrimitiveArray(Object, NullContainer, String) getPrimitiveArray}(obj_thatIsPrimArr, NullContainer.{@link com.github.xbn.array.NullContainer#BAD BAD}, array_name)[index]))</code>
    */
   public Boolean getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Boolean(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   /**
    * @return  <code>{@link com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs PrimitiveArrayFromObjThatIs.}{@link com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs#copyForBoolean(Object, NullContainer, String) copyForBoolean}(obj_thatIsPrimArr, nnull, cntrName_forNullBad)</code>
    */
   public boolean[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForBoolean(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   /**
    * @return  <code>{@link com.github.xbn.array.primitive.WrapperArrayFromPrimitive WrapperArrayFromPrimitive}.{@link com.github.xbn.array.primitive.WrapperArrayFromPrimitive#get(boolean[], NullContainer, String) get}({@link #getPrimitiveArray(Object, NullContainer, String) getPrimitiveArray}(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad)</code>
    */
   public Boolean[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   /**
    * @return  If {@code length} is<ul>
         <li>zero: {@link #getEmpty() getEmpty}{@code ()}</li>
         <li>non-zero: {@code (new Boolean[length])}</li>
      </ul>
    */
   public Boolean[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Boolean[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   /**
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils ArrayUtils.}{@link org.apache.commons.lang3.ArrayUtils#EMPTY_BOOLEAN_OBJECT_ARRAY EMPTY_BOOLEAN_OBJECT_ARRAY}</code>
    */
   public Boolean[] getEmpty()  {
      return  ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
   }
   /**
    * @return  If {@code length} is<ul>
         <li>zero: {@link #getEmptyPrimitive() getEmptyPrimitive}{@code ()}</li>
         <li>non-zero: {@code (new boolean[length])}</li>
      </ul>
    */
   public boolean[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new boolean[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   /**
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils ArrayUtils.}{@link org.apache.commons.lang3.ArrayUtils#EMPTY_BOOLEAN_ARRAY EMPTY_BOOLEAN_ARRAY}</code>
    */
   public boolean[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_BOOLEAN_ARRAY;
   }
}
