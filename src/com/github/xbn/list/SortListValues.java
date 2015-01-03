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
package  com.github.xbn.list;
   import  com.github.xbn.util.EnumUtil;
/**
   <p>Should the map's list values be sorted?.</p>

 * @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <code><a href="http://xbnjava.aliteralmind.com">http://xbnjava.aliteralmind.com</a></code>, <code><a href="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</a></code>
 **/
public enum SortListValues  {
   /**
      <p>YYY.</p>

    * @see  #DUPLICATE
    * @see  #UNSORTED
    * @see  #doSortOriginal()
    */
   ORIGINAL,
   /**
      <p>YYY.</p>

    * @see  #ORIGINAL
    * @see  #doSortDuplicate()
    */
   DUPLICATE,
   /**
      <p>YYY.</p>

    * @see  #ORIGINAL
    * @see  #doNotSort()
    */
   UNSORTED;
   /**
      <p>Is this {@code SortListValues} equal to {@code ORIGINAL}?.</p>

    * @return  <code>this == {@link #ORIGINAL}</code>

    * @see  #doSortDuplicate()
    * @see  #doNotSort()
    */
   public final boolean doSortOriginal()  {
      return  this == ORIGINAL;
   }
   /**
      <p>Is this {@code SortListValues} equal to {@code DUPLICATE}?.</p>

    * @return  <code>this == {@link #DUPLICATE}</code>
    * @see  #doSortOriginal()
    */
   public final boolean doSortDuplicate()  {
      return  this == DUPLICATE;
   }
   /**
      <p>Is this {@code SortListValues} equal to {@code UNSORTED}?.</p>

    * @return  <code>this == {@link #UNSORTED}</code>
    * @see  #doSortOriginal()
    */
   public final boolean doNotSort()  {
      return  this == UNSORTED;
   }
   /**
      <p>If an <code>SortListValues</code> is not a required value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
    * @see  #crashIfForbiddenValue(SortListValues, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(SortListValues e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
   /**
      <p>If an <code>SortListValues</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
    * @see  #crashIfNotRequiredValue(SortListValues, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(SortListValues e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
};
