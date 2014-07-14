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
   import  com.github.xbn.array.XbnArrayIndexOutOfBoundsException;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring an {@link com.github.xbn.array.XbnArrayIndexOutOfBoundsException XbnArrayIndexOutOfBoundsException}.</P>

   <P><I>{@code XbnArray}{@code IndexOutOfBoundsException_Cfg} and {@code XbnString}{@code IndexOutOfBoundsException_Cfg} both derive from {@code Xbn}{@code IndexOutOfBoundsException_Cfg}. <B>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException_Cfg}</B></I></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnArrayIndexOutOfBoundsException_Cfg extends XbnIbxBase_Cfg  {
   /**
      <P>Create a new instance.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link XbnIbxBase_Cfg#XbnIbxBase_Cfg() super}()</CODE></P>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg()  {
      super();
   }
//Delete in XbnStr_ingIndexOutOfBoundsException...START
   /**
      <P>Set the absolute length from a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(0, array)</CODE>
    **/
   public <E> XbnArrayIndexOutOfBoundsException_Cfg absArrayLength(E[] array)  {
      return  absMinAndArrayLength(0, array);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">absMinAndArrayLength</A>(0, array, null, array_name)</CODE>
    **/
   public <E> XbnArrayIndexOutOfBoundsException_Cfg absArrayLength(E[] array, String array_name)  {
      return  absMinAndArrayLength(0, array, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      @return  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">absMinAndArrayLength</A>(min_inclusive, array, null, null)</CODE>
    **/
   public <E> XbnArrayIndexOutOfBoundsException_Cfg absMinAndArrayLength(int min_inclusive, E[] array)  {
      return  absMinAndArrayLength(min_inclusive, array, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a non-primitive array.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="XbnArrayIndexOutOfBoundsException_Cfg.html#setAbsMinAndArrayLength(int, E[], java.lang.String, java.lang.String)">setAbsMinAndArrayLength</A>(min_inclusive, array, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absArrayLength(E[])">absArrayLength</A>(o[])</CODE>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absArrayLength(E[], java.lang.String)">absArrayLength</A>(o[],s)</CODE>
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN JAVADOC --><A HREF="#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(i,o[])</CODE>
    **/
   public <E> XbnArrayIndexOutOfBoundsException_Cfg absMinAndArrayLength(int min_inclusive, E[] array, String min_name, String array_name)  {
      setAbsMinAndArrayLength(min_inclusive, array, min_name, array_name);
      return  this;
   }
   /**
      <P>Set the absolute length from a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object) absMinAndPArrayLength}(0, obj_thatIsPrimArr)</CODE>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absPArrayLength(Object obj_thatIsPrimArr)  {
      return  absMinAndPArrayLength(0, obj_thatIsPrimArr);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(0, obj_thatIsPrimArr, null, array_name)</CODE>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absPArrayLength(Object obj_thatIsPrimArr, String array_name)  {
      return  absMinAndPArrayLength(0, obj_thatIsPrimArr, null, array_name);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      @return  <CODE>{@link #absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(min_inclusive, obj_thatIsPrimArr, null, null)</CODE>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absMinAndPArrayLength(int min_inclusive, Object obj_thatIsPrimArr)  {
      return  absMinAndPArrayLength(min_inclusive, obj_thatIsPrimArr, null, null);
   }
   /**
      <P>Set the absolute bounds from the length of a(n object known to be a) primitive array.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link XbnArrayIndexOutOfBoundsException_Cfg#setAbsMinAndPArrayLength(int, Object, String, String) setAbsMinAndPArrayLength}(min_inclusive, obj_thatIsPrimArr, min_name, array_name)*</CODE></P>

      @return  <I>{@code this}</I>
      @see  #absPArrayLength(Object) absPArrayLength(o)
      @see  #absPArrayLength(Object, String) absPArrayLength(o,s)
      @see  #absMinAndPArrayLength(int, Object) absMinAndPArrayLength(i,o)
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absMinAndPArrayLength(int min_inclusive, Object obj_thatIsPrimArr, String min_name, String array_name)  {
      setAbsMinAndPArrayLength(min_inclusive, obj_thatIsPrimArr, min_name, array_name);
      return  this;
   }
//Delete in XbnStr_ingIndexOutOfBoundsException...END
   /**
      <P>Set the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int) setAbsoluteBounds}(min_inclusive, max_exclusive)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive)  {
      setAbsoluteBounds(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <P>Set the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min_inclusive, max_exclusive, min_name, max_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setAbsoluteBounds(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <P>Set the absolute (exclusive) maximum.</P>

      @return  {@link #absBounds(int, int) absBounds(0, max_exclusive)}
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive)  {
      return  absBounds(0, max_exclusive);
   }
   /**
      <P>Set the absolute (exclusive) maximum.</P>

      @return  {@link #absBounds(int, int, String, String) absBounds(0, max_exclusive, null, max_name)}
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive, String max_name)  {
      return  absBounds(0, max_exclusive, null, max_name);
   }
   /**
      <P>Set the index that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setBadIndex(int) setBadIndex}(index)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg badIndex(int index)  {
      setBadIndex(index);
      return  this;
   }
   /**
      <P>Set the index that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setBadIndex(int, String) setBadIndex}(index, idx_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg badIndex(int index, String idx_name)  {
      setBadIndex(index, idx_name);
      return  this;
   }
   /**
      <P>Set the index-range that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setBadRange(int, int) setBadRange}(min_inclusive, max_exclusive)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive)  {
      setBadRange(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <P>Set the index-range that violates the absolute bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#setBadRange(int, int, String, String) setBadRange}(min_inclusive, max_exclusive, min_name, max_name)*</CODE></P>

      @return  <I>{@code this}</I>
    **/
   public XbnArrayIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setBadRange(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <P>Create an {@code XbnArrayIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithInfo(Object) buildWithInfo}{@code (null)}
    **/
   public XbnArrayIndexOutOfBoundsException build()  {
      return  buildWithInfo(null);
   }
   /**
      <P>Create an {@code XbnArrayIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (null, xtra_errInfo)}
    **/
   public XbnArrayIndexOutOfBoundsException buildWithInfo(Object xtra_errInfo)  {
      return  buildWithCauseInfo(null, xtra_errInfo);
   }
   /**
      <P>Create an {@code XbnArrayIndexOutOfBoundsException} as configured.</P>

      @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (cause, null)}
    **/
   public XbnArrayIndexOutOfBoundsException buildWithCause(Throwable cause)  {
      return  buildWithCauseInfo(cause, null);
   }
   /**
      <P>Create an {@code XbnArrayIndexOutOfBoundsException} as configured.</P>

      <P>This<OL>
         <LI>Calls  <CODE><!-- FAILS AS A @link --><A HREF="XbnIbxBase.html#setExtraErrInfoCause(java.lang.Object, java.lang.Throwable)">setExtraErrInfoCause</A>(xtra_errInfo, cause)*</CODE></LI>
         <LI><B><I>returns</I></B> a
         <BR> &nbsp; &nbsp; <CODE>(new {@link com.github.xbn.array.XbnArrayIndexOutOfBoundsException#XbnArrayIndexOutOfBoundsException(XIbxData) XbnArrayIndexOutOfBoundsException}({@link XbnIbxBase_Cfg#xdata xdata}*))</CODE></LI>
      </OL></P>

      @see  #build()
      @see  #buildWithInfo(Object) buildWithInfo(o)
      @see  #buildWithCause(Throwable) buildWithCause(thr)
    **/
   public XbnArrayIndexOutOfBoundsException buildWithCauseInfo(Throwable cause, Object xtra_errInfo)  {
      setExtraErrInfoCause(xtra_errInfo, cause);
      return  (new XbnArrayIndexOutOfBoundsException(xdata));
   }
   public XbnArrayIndexOutOfBoundsException_Cfg chainID(boolean do_setStatic, Object id)  {
      super.chainID(do_setStatic, id);
      return  this;
   }
}
