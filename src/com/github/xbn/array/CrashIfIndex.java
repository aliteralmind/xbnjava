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
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.lang.IllegalArgumentStateException;
/**
   <p>Error checking related to indexes and indexed elements.</p>

   @see  com.github.xbn.lang.CrashIfObject
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CrashIfIndex  {
   /**
      <p>If an index is invalid given its container's length, crash. Otherwise do nothing.</p>

      @exception  IndexOutOfBoundsException  If {@code index} is invalid.
    **/
   public static final void badForLength(int index, int length, String idx_name, String length_name)  {
      if(index < 0  ||  index >= length)  {
         throw  new IndexOutOfBoundsException("index (" + index + ") is invalid, given length is " + length + ".");
         //Can't use this, in order to have as few classes in sub-projects as possible
         //throw  new XbnIndexOutOfBoundsException_Cfg().
         //	badIndex(index, "index").absMaxX(length, "length").build();
      }
   }
   /**
      <p>If a min-max index range is invalid, given its container's length, crash. Otherwise do nothing.</p>

      @param  idx_start  The range minimum to test.
      @param  idx_endExcl  The range maximum to test.
      @param  VALID_length  The length to compare the range agaist. This <i>really really should</i> be zero or greater.
      @param  idxStart_name  Descriptive name of {@code idx_start}. <i>Should</i> not be {@code null} or empty
      @param  idxEnd_name  Descriptive name of {@code idx_endExcl}.
      @param  cntr_name  Descriptive name of {@code VALID_length}.
      @exception  IllegalArgumentStateException  If the minimum is less than zero or greater-than-or-equal-to the maximum, or if the maximum is greater than the length.
    **/
   public static final void rangeBadForLength(int idx_start, int idx_endExcl, int VALID_length, String idxStart_name, String idxEnd_name, String cntr_name)  {
      if(idx_start < 0  ||  idx_start >= idx_endExcl  ||  idx_endExcl > VALID_length)  {
         throw  new IllegalArgumentStateException(idxStart_name + " (" + idx_start + ") and " + idxEnd_name + " (" + idx_endExcl + ") are an invalid index range, given the length of " + cntr_name + " is (" + VALID_length + ").");
      }
   }
   /**
      <p>If an indexed element is {@code null}, crash. Otherwise, do nothing.</p>

      @param  element  The element to test.
      @param  index  Its index, for the potential error message only. <i>Should</i> be a valid index.
      @param  nullness  If {@link com.github.xbn.lang.Null#BAD BAD}, the element may not be {@code null}. If {@link com.github.xbn.lang.Null#OK OK}, this function does nothing. This parameter may not be {@code null}.
      @param  container_name  Descriptive name of the element's container.
      @param  index_varName  Descriptive name of the index. <i>Should</i> not be empty.
    **/
   public static final void edElementIsNull(Object element, int index, Null nullness, String container_name, String index_varName)  {
      if(nullness.isBad()  &&  element == null)  {
         throw  new NullPointerException("Element " + index +
            ((index_varName == null) ? "" : " (" + index_varName + ")") +
         "in " + container_name + "is null.");
      }
   }
   private CrashIfIndex()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
