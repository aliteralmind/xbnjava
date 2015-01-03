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
package  com.github.xbn.lang;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
   <p>If an object is {@code null}, crash. Otherwise, do nothing.</p>

 * @see  com.github.xbn.array.CrashIfArray
 * @see  com.github.xbn.list.CrashIfCollection
 * @see  com.github.xbn.list.CrashIfList
 * @see  com.github.xbn.text.CrashIfString
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CrashIfObject  {
//nnull*...START
   /**
      <p>If an object is {@code null}, crash--otherwise, <i>return</i> the causing error.</p>

    * @param  obj_toTest  The object expected to be {@code null}.
    * @param  cause  The causing error. May not be {@code null}.
    */
   public static final RuntimeException nullOrReturnCause(Object obj_toTest, String obj_name, Object xtra_errInfo, RuntimeException cause)  {
      if(cause == null)  {
         throw  new NullPointerException("cause");
      }
      nnull(obj_toTest, obj_name, xtra_errInfo);
      return  regetRtxCrashIfNull(cause, "cause");
   }
   /**
      <p>If an object is {@code null}, crash. Otherwise, do nothing.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link #nnull(Null, Object, String, Object) nnull}({@link Null}.{@link Null#BAD BAD}, obj_toTest, obj_name, xtra_errInfo)</code></p>
    */
   public static final void nnull(Object obj_toTest, String obj_name, Object xtra_errInfo)  {
      nnull(Null.BAD, obj_toTest, obj_name, xtra_errInfo);
   }
   /**
      <p>If an object is optionally-{@code null}, crash. Otherwise, do nothing.</p>

    * @param  obj_toTest  The object to test.
    * @exception  NullPointerException  If {@code obj_toTest} is {@code null} and {@code nnull} is {@link Null#BAD BAD}

    * @see  #nnull(Object, String, Object) nnull
    */
   public static final void nnull(Null nnull, Object obj_toTest, String obj_name, Object xtra_errInfo)  {
      if(obj_toTest == null  &&  !nnull.isOk())  {
         throw  new NullPointerException(getXMsg(obj_name, xtra_errInfo));
      }
   }
   private CrashIfObject()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
//nnull*...END
}
