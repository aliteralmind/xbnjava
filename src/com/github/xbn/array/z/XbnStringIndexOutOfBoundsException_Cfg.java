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
   import  com.github.xbn.array.XbnStringIndexOutOfBoundsException;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#direct">directly</a> configuring an {@link com.github.xbn.array.XbnStringIndexOutOfBoundsException XbnStringIndexOutOfBoundsException}.</p>

   <p><i>{@code XbnArray}{@code IndexOutOfBoundsException_Cfg} and {@code XbnString}{@code IndexOutOfBoundsException_Cfg} both derive from {@code Xbn}{@code IndexOutOfBoundsException_Cfg}. <b>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException_Cfg}</b></i></p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class XbnStringIndexOutOfBoundsException_Cfg extends XbnIbxBase_Cfg  {
   /**
      <p>Create a new instance.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link XbnIbxBase_Cfg#XbnIbxBase_Cfg() super}()</code></p>
    */
   public XbnStringIndexOutOfBoundsException_Cfg()  {
      super();
   }
//Delete in XbnArr_ayIndexOutOfBoundsException...START
   /**
      <p>Set the absolute length from a string.</p>

    * @return  <code>{@link #absMinAndStringLength(int, Object) absMinAndStringLength}(0, str_toPad)</code>
    */
   public XbnStringIndexOutOfBoundsException_Cfg absStringLength(Object str_toPad)  {
      return  absMinAndStringLength(0, str_toPad);
   }
   /**
      <p>Set the absolute bounds from the length of a string.</p>

    * @return  <code>{@link #absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(0, str_toPad, null, array_name)</code>
    */
   public XbnStringIndexOutOfBoundsException_Cfg absStringLength(Object str_toPad, String array_name)  {
      return  absMinAndStringLength(0, str_toPad, null, array_name);
   }
   /**
      <p>Set the absolute bounds from the length of a string.</p>

    * @return  <code>{@link #absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(min_inclusive, str_toPad, null, null)</code>
    */
   public XbnStringIndexOutOfBoundsException_Cfg absMinAndStringLength(int min_inclusive, Object str_toPad)  {
      return  absMinAndStringLength(min_inclusive, str_toPad, null, null);
   }
   /**
      <p>Set the absolute bounds from the length of a string.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link XbnStringIndexOutOfBoundsException_Cfg#setAbsMinAndStringLength(int, Object, String, String) setAbsMinAndStringLength}(min_inclusive, str_toPad, min_name, array_name)*</code></p>

    * @return  <i>{@code this}</i>
    * @see  #absStringLength(Object) absStringLength(O)
    * @see  #absStringLength(Object, String) absStringLength(O,s)
    * @see  #absMinAndStringLength(int, Object) absMinAndStringLength(i,O)
    */
   public XbnStringIndexOutOfBoundsException_Cfg absMinAndStringLength(int min_inclusive, Object str_toPad, String min_name, String array_name)  {
      setAbsMinAndStringLength(min_inclusive, str_toPad, min_name, array_name);
      return  this;
   }
//Delete in XbnArr_ayIndexOutOfBoundsException...END
   /**
      <p>Set the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int) setAbsoluteBounds}(min_inclusive, max_exclusive)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive)  {
      setAbsoluteBounds(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <p>Set the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min_inclusive, max_exclusive, min_name, max_name)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg absBounds(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setAbsoluteBounds(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <p>Set the absolute (exclusive) maximum.</p>

    * @return  {@link #absBounds(int, int) absBounds(0, max_exclusive)}
    */
   public XbnStringIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive)  {
      return  absBounds(0, max_exclusive);
   }
   /**
      <p>Set the absolute (exclusive) maximum.</p>

    * @return  {@link #absBounds(int, int, String, String) absBounds(0, max_exclusive, null, max_name)}
    */
   public XbnStringIndexOutOfBoundsException_Cfg absMaxX(int max_exclusive, String max_name)  {
      return  absBounds(0, max_exclusive, null, max_name);
   }
   /**
      <p>Set the index that violates the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setBadIndex(int) setBadIndex}(index)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg badIndex(int index)  {
      setBadIndex(index);
      return  this;
   }
   /**
      <p>Set the index that violates the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setBadIndex(int, String) setBadIndex}(index, idx_name)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg badIndex(int index, String idx_name)  {
      setBadIndex(index, idx_name);
      return  this;
   }
   /**
      <p>Set the index-range that violates the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setBadRange(int, int) setBadRange}(min_inclusive, max_exclusive)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive)  {
      setBadRange(min_inclusive, max_exclusive);
      return  this;
   }
   /**
      <p>Set the index-range that violates the absolute bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp;  <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#setBadRange(int, int, String, String) setBadRange}(min_inclusive, max_exclusive, min_name, max_name)*</code></p>

    * @return  <i>{@code this}</i>
    */
   public XbnStringIndexOutOfBoundsException_Cfg badRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      setBadRange(min_inclusive, max_exclusive, min_name, max_name);
      return  this;
   }
   /**
      <p>Create an {@code XbnStringIndexOutOfBoundsException} as configured.</p>

    * @return  {@link #buildWithInfo(Object) buildWithInfo}{@code (null)}
    */
   public XbnStringIndexOutOfBoundsException build()  {
      return  buildWithInfo(null);
   }
   /**
      <p>Create an {@code XbnStringIndexOutOfBoundsException} as configured.</p>

    * @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (null, xtra_errInfo)}
    */
   public XbnStringIndexOutOfBoundsException buildWithInfo(Object xtra_errInfo)  {
      return  buildWithCauseInfo(null, xtra_errInfo);
   }
   /**
      <p>Create an {@code XbnStringIndexOutOfBoundsException} as configured.</p>

    * @return  {@link #buildWithCauseInfo(Throwable, Object) buildWithCauseInfo}{@code (cause, null)}
    */
   public XbnStringIndexOutOfBoundsException buildWithCause(Throwable cause)  {
      return  buildWithCauseInfo(cause, null);
   }
   /**
      <p>Create an {@code XbnStringIndexOutOfBoundsException} as configured.</p>

      <p>This<ol>
         <li>Calls  <code><!-- FAILS AS A @link --><a href="../XbnIbxBase.html#setExtraErrInfoCause(java.lang.Object, java.lang.Throwable)">setExtraErrInfoCause</a>(xtra_errInfo, cause)*</code></li>
         <li><b><i>returns</i></b> a
         <br/> &nbsp; &nbsp; <code>(new {@link com.github.xbn.array.XbnStringIndexOutOfBoundsException#XbnStringIndexOutOfBoundsException(XIbxData) XbnStringIndexOutOfBoundsException}({@link XbnIbxBase_Cfg#xdata xdata}*))</code></li>
      </ol></p>

    * @see  #build()
    * @see  #buildWithInfo(Object) buildWithInfo(o)
    * @see  #buildWithCause(Throwable) buildWithCause(thr)
    */
   public XbnStringIndexOutOfBoundsException buildWithCauseInfo(Throwable cause, Object xtra_errInfo)  {
      setExtraErrInfoCause(xtra_errInfo, cause);
      return  (new XbnStringIndexOutOfBoundsException(xdata));
   }
   public XbnStringIndexOutOfBoundsException_Cfg chainID(boolean do_setStatic, Object id)  {
      super.chainID(do_setStatic, id);
      return  this;
   }
}
