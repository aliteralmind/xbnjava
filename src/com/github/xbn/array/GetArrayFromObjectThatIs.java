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
package  com.github.xbn.array;
   import  java.util.Arrays;
   import  java.util.List;
   import  java.util.Collections;
/**
   <P>Casts an object that happens to be an array, of either primitives or non-primitives, to the array itself.</P>

   <P>POSTS TO ANSWER WITH THIS CLASS:<UL>
      <LI>{@code <a href="http://www.codeguru.com/forum/showthread.php?t=349438">http://www.codeguru.com/forum/showthread.php?t=349438</a>}</LI>
      <LI>{@code <a href="http://www.velocityreviews.com/forums/t147493-java-5-0-enum-why-not-valueof-int-ordinal.html">http://www.velocityreviews.com/forums/t147493-java-5-0-enum-why-not-valueof-int-ordinal.html</a>}</LI>
   </UL></P>

   @see  com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class GetArrayFromObjectThatIs  {
   /**
      <P>Represents the type of element in the array.</P>
    **/
   public static enum LMNT_TYPE_IS {BOOLEAN, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, OBJECT, ARRAY};
   /**
      <P>The second character in an array's {@code getClass().getName()}. The first character is always a square bracket ({@code '<B>[</B>'}).</P>

      <P>Equal to {@code {'Z', 'B', 'S', 'I', 'J', 'F', 'D', 'C', 'L', '['}}</P>
    **/
   private static final Character[] LMNT_TYPE_CHAR_TWO = {'Z', 'B', 'S', 'I', 'J', 'F', 'D', 'C', 'L', '['};
   public static final List<Character> LMNT_TYPE_CHAR_TWO_LIST = Collections.unmodifiableList(Arrays.asList(LMNT_TYPE_CHAR_TWO));

   private LMNT_TYPE_IS eLType = null;
      private Object oa = null;

   /**
      <P>Create a new {@code GetArrayFromObjectThatIs}.</P>

      <P>Equal to {@link #GetArrayFromObjectThatIs(Object, boolean) this(array_object, true)}</P>
    **/
   public GetArrayFromObjectThatIs(Object array_object)  {
      this(array_object, true);
   }
   /**
      <P>Create a new {@code GetArrayFromObjectThatIs}.</P>

      @param  array_object  The object expected to be an array. When null or not an array, {@link #getObject() getObject}{@code ()} returns null, and {@link #isArray() isArray}{@code ()} returns false. When {@code do_crashIfObjNNullAndNotArray} is true, this <I>must</I> be an array (when non-null).
      @exception  ClassCastException  When {@code do_crashIfObjNNullAndNotArray} is true and {@code array_object} is non-null but not an array.
    **/
   public GetArrayFromObjectThatIs(Object array_object, boolean do_crashIfObjNNullAndNotArray)  {
      if(array_object == null)  {
         eLType = null;
         oa = null;
         return;
      }

      String snClass = null;
      try  {
         snClass = array_object.getClass().getName();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("array_object");
      }

      assert  snClass.length() >= 1;

      if(snClass.length() > 1  &&  snClass.charAt(0) == '[')  {

         char c2 = snClass.charAt(1);

         for(int i = 0; i < LMNT_TYPE_CHAR_TWO.length; i++)  {
            if(c2 == LMNT_TYPE_CHAR_TWO[i])  {
               eLType = LMNT_TYPE_IS.values()[i];
               break;
            }
         }
      }

      if(eLType == null)  {
         if(do_crashIfObjNNullAndNotArray)  {
            throw  new ClassCastException("array_object is a " + snClass + ". -- do_crashIfObjNNullAndNotArray is true.");
         }
      }

      oa = array_object;

      assert  ((getObject() == null) == (getELType() == null));
   }
   /**
      <P>Get the array as an {@code Object}.</P>


      @return  When the {@code array_object} {@link #GetArrayFromObjectThatIs(Object, boolean) constructor} parameter was both non-null and an array: <B>{@code array_object}</B>, exactly as provided.
      <BR>When either null or not an array: {@code <B>null</B>}
      @see  #isArray()
      @see  #getELType()
      @see  #isEmpty()
      @see  #getLength()
      @see  #getAOByte()
      @see  #getAOShort()
      @see  #getAOInt()
      @see  #getAOLong()
      @see  #getAOFloat()
      @see  #getAODouble()
      @see  #getAOBoolean()
      @see  #getAOChar()
      @see  #getAOObject()
      @see  #getAOArray()
    **/
   public final Object getObject()  {
      return  oa;
   }
   /**
      <P>Is the object an array?.</P>

      @return  <CODE>({@link #getObject() getObject}() != null)</CODE>
    **/
   public final boolean isArray()  {
      return  (getObject() != null);
   }
   /**
      <P>Get the type of array.</P>

      @return  When the {@code array_object} {@link #GetArrayFromObjectThatIs(Object, boolean) constructor} parameter was both non-null and an array: One of the values of {@code LMNT_TYPE_IS}.
      <BR>When either null or not an array: {@code <B>null</B>}
      @see  #getObject()
    **/
   public final LMNT_TYPE_IS getELType()  {
      return  eLType;
   }
   /**
      <P>Get the type of array.</P>

      @return  <CODE>({@link #getLength() getLength}{@code ()} == 0)</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
    **/
   public final boolean isEmpty()  {
      try  {
         return  (getLength() == 0);
      }  catch(NullPointerException npx)  {
         assert  (!isArray());
         throw   new NullPointerException("isArray() is false. -- " + npx);
      }
   }
   /**
      <P>Get the array's length.</P>

      @return  If {@link #getELType() getELType}{@code ()} is<UL>
         <LI>{@code BOOLEAN}: {@link #getAOBoolean() getAOBoolean}{@code ().length}</LI>
         <LI>{@code SHORT}: {@link #getAOShort() getAOShort}{@code ().length}</LI>
         <LI>{@code INT}: {@link #getAOInt() getAOInt}{@code ().length}</LI>
         <LI>{@code LONG}: {@link #getAOLong() getAOLong}{@code ().length}</LI>
         <LI>{@code FLOAT}: {@link #getAOFloat() getAOFloat}{@code ().length}</LI>
         <LI>{@code DOUBLE}: {@link #getAODouble() getAODouble}{@code ().length}</LI>
         <LI>{@code CHAR}: {@link #getAOChar() getAOChar}{@code ().length}</LI>
         <LI>{@code OBJECT}: {@link #getAOObject() getAOObject}{@code ().length}</LI>
         <LI>{@code ARRAY}: {@link #getAOArray() getAOArray}{@code ().length}</LI>
      </UL>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
    **/
   public final int getLength()  {
      try  {
         switch(getELType())  {
            case BOOLEAN: return  getAOBoolean().length;
            case BYTE:   return   getAOByte().length;
            case SHORT:   return  getAOShort().length;
            case INT:     return  getAOInt().length;
            case LONG:    return  getAOLong().length;
            case FLOAT:   return  getAOFloat().length;
            case DOUBLE:  return  getAODouble().length;
            case CHAR:    return  getAOChar().length;
            case OBJECT:  return  getAOObject().length;
            case ARRAY:   return  getAOArray().length;
         }
      }  catch(NullPointerException npx)  {
         assert  !isArray();
         throw   new NullPointerException("isArray() is false.");
      }

      throw   new NullPointerException("HUH?! -- " + toString());
   }
   public String toString()  {
      String s = "isArray()=" + getObject();
      if(isArray())  {
         s += ", getObject()=[" + getObject() + "], getELType()=" + getELType() + ", isEmpty()=" + isEmpty() +  ", getLength()=" + getLength();
      }
      return  s;
   }
   /**
      <P>Get the {@code boolean} array.</P>

      @return   <CODE>(boolean[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#BOOLEAN}</CODE>
    **/
   public final boolean[] getAOBoolean()  {
      cinArray("Boolean");
      try  {
         return  (boolean[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Boolean"));
      }
   }
   /**
      <P>Get the {@code byte} array.</P>

      @return   <CODE>(byte[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#BYTE}</CODE>
    **/
   public final byte[] getAOByte()  {
      cinArray("Byte");
      try  {
         return  (byte[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Byte"));
      }
   }
   /**
      <P>Get the {@code byte} array.</P>

      @return   <CODE>(byte[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#SHORT}</CODE>
    **/
   public final short[] getAOShort()  {
      cinArray("Short");
      try  {
         return  (short[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Short"));
      }
   }
   /**
      <P>Get the {@code int} array.</P>

      @return   <CODE>(int[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#INT}</CODE>
    **/
   public final int[] getAOInt()  {
      cinArray("Int");
      try  {
         return  (int[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Int"));
      }
   }
   /**
      <P>Get the {@code long} array.</P>

      @return   <CODE>(long[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#LONG}</CODE>
    **/
   public final long[] getAOLong()  {
      cinArray("Long");
      try  {
         return  (long[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Long"));
      }
   }
   /**
      <P>Get the {@code float} array.</P>

      @return   <CODE>(float[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#FLOAT}</CODE>
    **/
   public final float[] getAOFloat()  {
      cinArray("Float");
      try  {
         return  (float[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Float"));
      }
   }
   /**
      <P>Get the {@code double} array.</P>

      @return   <CODE>(double[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#DOUBLE}</CODE>
    **/
   public final double[] getAODouble()  {
      cinArray("Double");
      try  {
         return  (double[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Double"));
      }
   }
   /**
      <P>Get the {@code char} array.</P>

      @return   <CODE>(char[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#CHAR}</CODE>
    **/
   public final char[] getAOChar()  {
      cinArray("Char");
      try  {
         return  (char[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Char"));
      }
   }
   /**
      <P>Get the {@code java.lang.Object} array.</P>

      <P>Note that this {@code getAO} function is unique, as it is the only one which that can be called for multiple types. Specifically, when {@link #getELType() getELType}{@code ()} is <I>either</I> <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#OBJECT}} or {@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#ARRAY}</CODE></P>

      <P>Note also, that while
      <BR> &nbsp; &nbsp; {@code (new Object[] {"Hello", null, (new int[] {1, 2, 3})})}
      <BR>has an element type of {@code LMNT_TYPE_IS.ARRAY}
      <BR> &nbsp; &nbsp; {@code (new Object[][] {(new String[]{"Hello"}), null, (new int[] {1, 2, 3})})}
      <BR>has an element type of {@code LMNT_TYPE_IS.OBJECT}</P>

      @return   <CODE>(Object[]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@code getELType()} is not {@code LMNT_TYPE_IS.OBJECT}
    **/
   public final Object[] getAOObject()  {
      cinArray("Object");
      try  {
         return  (Object[])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Object"));
      }
   }
   /**
      <P>Get the <I>array</I> array (the double-array).</P>

      @return   <CODE>(Object[][]){@link #getObject() getObject}()</CODE>
      @exception  NullPointerException  If {@link #isArray() isArray}{@code ()} is false.
      @exception  ClassCastException  If {@link #getELType() getELType}{@code ()} is not <CODE>{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS LMNT_TYPE_IS.}{@link GetArrayFromObjectThatIs.LMNT_TYPE_IS#ARRAY}</CODE>
      @see  #getAOObject() "for a special note on double-arrays"
    **/
   public final Object[] getAOArray()  {
      cinArray("Array");
      try  {
         return  (Object[][])getObject();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException(getCCXMsg("Array"));
      }
   }
   private void cinArray(String func_type)  {
      if(!isArray())  {
         throw  new NullPointerException("getAO" + func_type + ": isArray() is false.");
      }
   }
   private String getCCXMsg(String func_type)  {
      return  "getAO" + func_type + ": getELType() is " + getELType() + ".";
   }
   private static final String LINE_SEP = System.getProperty("line.separator", "\n");
   /**
      <P>Testing function.</P>

      @param  test_name  Descriptive name for this test.
      @param  array_object  The object to test. Passed directly to the {@link #GetArrayFromObjectThatIs(Object, boolean) constructor}.
      @param  do_crashIfObjNNullAndNotArray  The other constructor parameter.
      @param  iselfCmprcxXpctdInCnstr  Is a {@code ClassCastException} expected from the constructor?
      @param  expectedType_nullIfNotArray  If null, then {@code array_object} is either null or not an array. Otherwise, this is its element-type.
      @param  xpctd_len  The expected length of the array, if it is one.
      @return  <B>{@code null}</B> When actual values are as expected.
      <BR>A descriptive string when actual is unexpected.
    **/
   public static final String getMsgIfUnexpected(String test_name, Object array_object, boolean do_crashIfObjNNullAndNotArray, boolean iselfCmprcxXpctdInCnstr, LMNT_TYPE_IS expectedType_nullIfNotArray, int xpctd_len)  {
      String s = "";
      GetArrayFromObjectThatIs cota = null;
      try  {
         cota = new GetArrayFromObjectThatIs(array_object, do_crashIfObjNNullAndNotArray);
         if(iselfCmprcxXpctdInCnstr)  {
            s += "   - iselfCmprcxXpctdInCnstr=true, but no CCX was thrown by the constructor." + LINE_SEP;
         }
      }  catch(ClassCastException ccx)  {
         if(!iselfCmprcxXpctdInCnstr)  {
            s += "   - iselfCmprcxXpctdInCnstr=false, but: " + ccx + LINE_SEP;
         }
      }

      if(s.length() > 0)  {
         return  getFailPre(test_name, array_object, expectedType_nullIfNotArray) + s;
      }

      if(cota == null)  {
         return  null;
      }

      if(expectedType_nullIfNotArray == null)  {
         if(cota.isArray())  {
            s += "   - expectedType_nullIfNotArray=null, but isArray()=true" + LINE_SEP;
         }
      }  else if(expectedType_nullIfNotArray != cota.getELType())  {
         s += "   - expectedType_nullIfNotArray=" + expectedType_nullIfNotArray + ", but getELType()=" + cota.getELType() + "" + LINE_SEP;
      }

      if(cota.isArray())  {
         if((xpctd_len == 0)  &&  !cota.isEmpty())  {
            s += "   - xpctd_len=0, but isEmpty()=false" + LINE_SEP;
         }

         if(xpctd_len != cota.getLength())  {
            s += "   - xpctd_len=" + xpctd_len + ", but getLength()=" + cota.getLength() + LINE_SEP;
         }
      }

      if(s.length() > 0)  {
         return  getFailPre(test_name, array_object, expectedType_nullIfNotArray) + s;
      }

      return  null;
   }
   private static String getFailPre(String test_name, Object array_object, LMNT_TYPE_IS expectedType_nullIfNotArray)  {
      return  "TEST \"" + test_name + "\" FAILED [array_object=\"" + array_object + "\"]:" + LINE_SEP;
   }
}
