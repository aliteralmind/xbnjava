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
package  com.github.xbn.array.z;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.array.XIbxBadIdx;
   import  com.github.xbn.array.XIbxBadRange;
   import  com.github.xbn.array.XIbxData;
   import  com.github.xbn.array.XbnIbxBase;
   import  com.github.xbn.neederneedable.SimpleChainable;
   import  java.util.Collection;
/**
   <P>Base class for configuring {@code Xbn*IndexOutOfBoundsException}-s.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnIbxBase_Cfg extends SimpleChainable  {
   public Throwable tCause    = null;
   public Object    oXtraInfo = null;
   public XIbxData  xdata     = null;
   public XbnIbxBase_Cfg()  {
      tCause    = null;
      oXtraInfo = null;
      xdata     = null;
   }
   public void setAbsMinAndStringLength(int min_inclusive, Object cntr_forLen)  {
      getDataCrashIfNull().setAbsMinAndStringLength(min_inclusive, cntr_forLen);
   }
   public void setAbsMinAndStringLength(int min_inclusive, Object cntr_forLen, String min_name, String cntr_name)  {
      getDataCrashIfNull().setAbsMinAndStringLength(min_inclusive, cntr_forLen, min_name, cntr_name);
   }
   public void setAbsMinAndCollectionSize(int min_inclusive, Collection<?> cll_forSize)  {
      getDataCrashIfNull().setAbsMinAndCollectionSize(min_inclusive, cll_forSize);
   }
   public void setAbsMinAndCollectionSize(int min_inclusive, Collection<?> cll_forSize, String min_name, String cntr_name)  {
      getDataCrashIfNull().setAbsMinAndCollectionSize(min_inclusive, cll_forSize, min_name, cntr_name);
   }
   public <E> void setAbsMinAndArrayLength(int min_inclusive, E[] array)  {
      getDataCrashIfNull().setAbsMinAndArrayLength(min_inclusive, array);
   }
   public <E> void setAbsMinAndArrayLength(int min_inclusive, E[] array, String min_name, String cntr_name)  {
      getDataCrashIfNull().setAbsMinAndArrayLength(min_inclusive, array, min_name, cntr_name);
   }
   /**
      <P>Set the bounds that the bad-index should conform to, based on the length of a(n object that is known to be a) primitive array.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #setAbsMinAndPArrayLength(int, Object, String, String) setAbsMinAndPArrayLength}(min_inclusive, objThatIs_primArrayForLen, null, &quot;[the-primitive-array]&quot;)</CODE></P>
    **/
   public void setAbsMinAndPArrayLength(int min_inclusive, Object objThatIs_primArrayForLen)  {
      setAbsMinAndPArrayLength(min_inclusive, objThatIs_primArrayForLen, null, "[the-primitive-array]");
   }
   /**
      <P>Set the bounds that the bad-index should conform to, based on the length of a(n object that is known to be a) primitive array.</P>


      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min_inclusive,
      <BR> &nbsp; &nbsp; {@link #getLengthFromUnknownAsObject(Object, String, Object) getLengthFromUnknownAsObject}(objThatIs_primArrayForLen,
      <BR> &nbsp; &nbsp;  &nbsp; &nbsp; {@code "setAbsMinAndPArrayLength", cntr_name), min_name, cntr_name + ".length"})</CODE></P>

      @param  objThatIs_primArrayForLen  May not be {@code null}.
      @see  #setAbsMinAndPArrayLength(int, Object, String, String) setAbsMinAndPArrayLength(i,o,s,s)
    **/
   public void setAbsMinAndPArrayLength(int min_inclusive, Object objThatIs_primArrayForLen, String min_name, String cntr_name)  {
      setAbsoluteBounds(min_inclusive,
         getLengthFromUnknownAsObject(objThatIs_primArrayForLen, cntr_name, null),
         min_name, cntr_name + ".length");
   }
   public void setAbsoluteBounds(int min_inclusive, int max_exclusive)  {
      getDataCrashIfNull().setAbsoluteBounds(min_inclusive, max_exclusive);
   }
   public void setAbsoluteBounds(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      getDataCrashIfNull().setAbsoluteBounds(min_inclusive, max_exclusive, min_name, max_name);
   }
   public void setExtraErrInfoCause(Object xtra_errInfo, Throwable cause)  {
      getDataCrashIfNull().setExtraErrInfoCause(xtra_errInfo, cause);
   }
   public void setBadIndex(int index)  {
      xdata = new XIbxBadIdx(index);
   }
   public void setBadIndex(int index, String idx_name)  {
      xdata = new XIbxBadIdx(index, idx_name);
   }
   public void setBadRange(int min_inclusive, int max_exclusive)  {
      xdata = new XIbxBadRange(min_inclusive, max_exclusive);
   }
   public void setBadRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      xdata = new XIbxBadRange(min_inclusive, max_exclusive, min_name, max_name);
   }
   public XIbxData getDataCrashIfNull()  {
      return  XbnIbxBase.getXDataCINull(xdata);
   }

   /**
      <P><I>Primitive array utility function:</I> Get the length of a primitive array <I>as held in an object</I>. This is not in {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil ObjThatIsPrimitiveArrayUtil} because this class must be compiled before it.</P>

      @see  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object, String, Object) ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(o,s,o)
    **/
   public static final int getLengthFromUnknownAsObject(Object objThatIs_primArray, String obj_name, Object xtra_errInfo)  {
      Class<?> cls = null;
      try  {
         cls = objThatIs_primArray.getClass();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(objThatIs_primArray, obj_name, xtra_errInfo, rx);
      }
/*
---nwrqm input---
boolean Bool
double Double
float Float
long Long
int Int
short Short
byte Byte
char Char
 */
      if(cls.isAssignableFrom(boolean[].class)){
         return  ((boolean[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(char[].class)){
         return  ((char[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(byte[].class)){
         return  ((byte[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(short[].class)){
         return  ((short[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(int[].class)){
         return  ((int[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(long[].class)){
         return  ((long[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(float[].class)){
         return  ((float[])objThatIs_primArray).length;
      }
      if(cls.isAssignableFrom(double[].class)){
         return  ((double[])objThatIs_primArray).length;
      }

      throw  new IllegalArgumentException("objThatIs_primArray is not a primitive array. objThatIs_primArray.getClass().getName()=" + objThatIs_primArray.getClass().getName());
   }
}
