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
package  com.github.xbn.array.z;
   import  com.github.xbn.array.XbnIndexOutOfBoundsException;
   import  java.util.Collection;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring an {@link com.github.xbn.array.XbnIndexOutOfBoundsException XbnIndexOutOfBoundsException}.</P>

   <P><I>{@code XbnArray}{@code IndexOutOfBoundsException_Cfg} and {@code XbnString}{@code IndexOutOfBoundsException_Cfg} both derive from {@code Xbn}{@code IndexOutOfBoundsException_Cfg}. <B>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException_Cfg}</B></I></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnIndexOutOfBoundsException_Cfg extends XbnIbxBase_Cfg  {
   /**
      <P>Create a new instance.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link XbnIbxBase_Cfg#XbnIbxBase_Cfg() super}()</CODE></P>
    **/
   public XbnIndexOutOfBoundsException_Cfg()  {
      super();
   }
//Delete in XbnStr_ingIndexOutOfBoundsException...START
   /**
      <P>Set the absolute length from a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(0, array)</CODE>
    **/
   public <E> XbnIndexOutOfBoundsException_Cfg absArrayLength(E[] array)  {
      return  absMinAndArrayLength(0, array);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">absMinAndArrayLength</A>(0, array, null, array_name)</CODE>
    **/
   public <E> XbnIndexOutOfBoundsException_Cfg absArrayLength(E[] array, String array_name)  {
      return  absMinAndArrayLength(0, array, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">absMinAndArrayLength</A>(min_inclusive, array, null, null)</CODE>
    **/
   public <E> XbnIndexOutOfBoundsException_Cfg absMinAndArrayLength(int min_inclusive, E[] array)  {
      return  absMinAndArrayLength(min_inclusive, array, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="XbnIndexOutOfBoundsException_Cfg.html#setAbsMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">setAbsMinAndArrayLength</A>(min_inclusive, array, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absArrayLength(E[])">absArrayLength</A>(o[])</CODE>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absArrayLength(E[], java.lang.String)">absArrayLength</A>(o[],s)</CODE>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(i,o[])</CODE>
    **/
   public <E> XbnIndexOutOfBoundsException_Cfg absMinAndArrayLength(int min_inclusive, E[] array, String min_name, String array_name)  {
      setAbsMinAndArrayLength(min_inclusive, array, min_name, array_name);
      return  this;
   }
   /**
      <P>Set the absolute length from a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object) absMinAndPArrayLength}(0, obj_thatIsPrimArr)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absPArrayLength(Object obj_thatIsPrimArr)  {
      return  absMinAndPArrayLength(0, obj_thatIsPrimArr);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(0, obj_thatIsPrimArr, null, array_name)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absPArrayLength(Object obj_thatIsPrimArr, String array_name)  {
      return  absMinAndPArrayLength(0, obj_thatIsPrimArr, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(min_inclusive, obj_thatIsPrimArr, null, null)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndPArrayLength(int min_inclusive, Object obj_thatIsPrimArr)  {
      return  absMinAndPArrayLength(min_inclusive, obj_thatIsPrimArr, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link XbnIndexOutOfBoundsException_Cfg#setAbsMinAndPArrayLength(int, Object, String, String) setAbsMinAndPArrayLength}(min_inclusive, obj_thatIsPrimArr, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  #absPArrayLength(Object) absPArrayLength(o)
      @see  #absPArrayLength(Object, String) absPArrayLength(o,s)
      @see  #absMinAndPArrayLength(int, Object) absMinAndPArrayLength(i,o)
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndPArrayLength(int min_inclusive, Object obj_thatIsPrimArr, String min_name, String array_name)  {
      setAbsMinAndPArrayLength(min_inclusive, obj_thatIsPrimArr, min_name, array_name);
      return  this;
   }
//Delete in XbnStr_ingIndexOutOfBoundsException...END
//Delete in XbnArr_ayIndexOutOfBoundsException...START
   /**
      <P>Set the absolute length from a string.</P>

      @return  <CODE>{@link #absMinAndStringLength(int, Object) absMinAndStringLength}(0, str_toPad)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absStringLength(Object str_toPad)  {
      return  absMinAndStringLength(0, str_toPad);
   }
   /**
      <P>Set the absolute bounds from the length of a string.</P>

      @return  <CODE>{@link #absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(0, str_toPad, null, array_name)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absStringLength(Object str_toPad, String array_name)  {
      return  absMinAndStringLength(0, str_toPad, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a string.</P>

      @return  <CODE>{@link #absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(min_inclusive, str_toPad, null, null)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndStringLength(int min_inclusive, Object str_toPad)  {
      return  absMinAndStringLength(min_inclusive, str_toPad, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a string.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link XbnIndexOutOfBoundsException_Cfg#setAbsMinAndStringLength(int, Object, String, String) setAbsMinAndStringLength}(min_inclusive, str_toPad, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  #absStringLength(Object) absStringLength(O)
      @see  #absStringLength(Object, String) absStringLength(O,s)
      @see  #absMinAndStringLength(int, Object) absMinAndStringLength(i,O)
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndStringLength(int min_inclusive, Object str_toPad, String min_name, String array_name)  {
      setAbsMinAndStringLength(min_inclusive, str_toPad, min_name, array_name);
      return  this;
   }
//Delete in XbnArr_ayIndexOutOfBoundsException...END
//Delete in Xbn[Array,String]IndexOutOfBoundsException...START
   /**
      <P>Set the absolute length from a collection.</P>

      @return  <CODE>{@link #absMinAndCollectionSize(int, Collection) absMinAndCollectionSize}(0, coll)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absCollectionSize(Collection<?> coll)  {
      return  absMinAndCollectionSize(0, coll);
   }
   /**
      <P>Set the absolute bounds from the length of a collection.</P>

      @return  <CODE>{@link #absMinAndCollectionSize(int, Collection, String, String) absMinAndCollectionSize}(0, coll, null, array_name)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absCollectionSize(Collection<?> coll, String array_name)  {
      return  absMinAndCollectionSize(0, coll, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a collection.</P>

      @return  <CODE>{@link #absMinAndCollectionSize(int, Collection, String, String) absMinAndCollectionSize}(min_inclusive, coll, null, null)</CODE>
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndCollectionSize(int min_inclusive, Collection<?> coll)  {
      return  absMinAndCollectionSize(min_inclusive, coll, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a collection.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link XbnIndexOutOfBoundsException_Cfg#setAbsMinAndCollectionSize(int, Collection, String, String) setAbsMinAndCollectionSize}(min_inclusive, coll, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  #absCollectionSize(Collection) absCollectionSize(cll)
      @see  #absCollectionSize(Collection, String) absCollectionSize(cll,s)
      @see  #absMinAndCollectionSize(int, Collection) absMinAndCollectionSize(i,cll)
    **/
   public XbnIndexOutOfBoundsException_Cfg absMinAndCollectionSize(int min_inclusive, Collection<?> coll, String min_name, String array_name)  {
      setAbsMinAndCollectionSize(min_inclusive, coll, min_name, array_name);
      return  this;
   }
//Delete in Xbn[Array,String]IndexOutOfBoundsException...END
   /**
      <P>Set the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int) setAbsoluteBounds}(min_inclusive, max_exclusive)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive)  {
      setAbsoluteBounds(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <P>Set the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min_inclusive, max_exclusive, min_name, max_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setAbsoluteBounds(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <P>Set the absolute (exclusive) maximum.</P>

      @return  {@link #absBounds(int, int) absBounds(0, max_exclusive)}
    **/
   public XbnIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive)  {
      return  absBounds(0, max_exclusive);
   }
   /**
      <P>Set the absolute (exclusive) maximum.</P>

      @return  {@link #absBounds(int, int, String, String) absBounds(0, max_exclusive, null, max_name)}
    **/
   public XbnIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive, String max_name)  {
      return  absBounds(0, max_exclusive, null, max_name);
   }
   /**
      <P>Set the index that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setBadIndex(int) setBadIndex}(index)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg badIndex(int index)  {
      setBadIndex(index);
      return  this;
   }
   /**
      <P>Set the index that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setBadIndex(int, String) setBadIndex}(index, idx_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg badIndex(int index, String idx_name)  {
      setBadIndex(index, idx_name);
      return  this;
   }
   /**
      <P>Set the index-range that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setBadRange(int, int) setBadRange}(min_inclusive, max_exclusive)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive)  {
      setBadRange(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <P>Set the index-range that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#setBadRange(int, int, String, String) setBadRange}(min_inclusive, max_exclusive, min_name, max_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setBadRange(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <P>Create an {@code XbnIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithInfo(Object) buildWithInfo}{@code (null)}
    **/
   public XbnIndexOutOfBoundsException build()  {
      return  buildWithInfo(null);
   }
   /**
      <P>Create an {@code XbnIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (null, xtra_errInfo)}
    **/
   public XbnIndexOutOfBoundsException buildWithInfo(Object xtra_errInfo)  {
      return  buildWithCauseInfo(null, xtra_errInfo);
   }
   /**
      <P>Create an {@code XbnIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (cause, null)}
    **/
   public XbnIndexOutOfBoundsException buildWithCause(Throwable cause)  {
      return  buildWithCauseInfo(cause, null);
   }
   /**
      <P>Create an {@code XbnIndexOutOfBoundsException} as configured.</P>

      <P>This<OL>
         <LI>Calls  <CODE><!-- FAILS AS A @link --><A HREF="XbnIbxBase.html#setExtraErrInfoCause(java.lang.Object, java.lang.Throwable)">setExtraErrInfoCause</A>(xtra_errInfo, cause)*</CODE></LI>
         <LI><B><I>returns</I></B> a
         <BR> &nbsp; &nbsp; <CODE>(new {@link com.github.xbn.array.XbnIndexOutOfBoundsException#XbnIndexOutOfBoundsException(XIbxData) XbnIndexOutOfBoundsException}({@link XbnIbxBase_Cfg#xdata xdata}*))</CODE></LI>
      </OL></P>

      @see  #build()
      @see  #buildWithInfo(Object) buildWithInfo(o)
      @see  #buildWithCause(Throwable) buildWithCause(thr)
    **/
   public XbnIndexOutOfBoundsException buildWithCauseInfo(Throwable cause, Object xtra_errInfo)  {
      setExtraErrInfoCause(xtra_errInfo, cause);
      return  (new XbnIndexOutOfBoundsException(xdata));
   }
   public XbnIndexOutOfBoundsException_Cfg chainID(boolean do_setStatic, Object id)  {
      super.chainID(do_setStatic, id);
      return  this;
   }
}
