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
package  com.github.xbn.text;
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Null;
   import  java.util.Objects;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
   <P>Crash if a string is {@code null} or empty.</P>

   @see  com.github.xbn.lang.CrashIfObject
   @see  <CODE><A HREF="{@docRoot}/com/github/xbn/array/CrashIfArray.html#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, com.github.xbn.array.Duplicates)">CrashIfArray#bad</A></CODE>
   @see  com.github.xbn.list.CrashIfCollection#bad(Collection, String, NullContainer, int, String, NullElement, int, String) CrashIfCollection#bad
   @see  com.github.xbn.list.CrashIfList#bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) CrashIfList#ofStringsBad
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CrashIfString  {
   /**
      <P>If a string is {@code null} or has no characters, crash. Otherwise, do nothing.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #empty(Null, Object, String, Object) empty}({@link com.github.xbn.lang.Null Null}.{@link com.github.xbn.lang.Null#BAD BAD}, string, str_name)</CODE></P>
    **/
   public static final void nullEmpty(Object string, String str_name, Object xtra_errInfo)  {
      empty(Null.BAD, string, str_name, xtra_errInfo);
   }
   /**
      <P>If a string is has no characters, crash. Otherwise, do nothing.</P>

      @exception  NullPointerException  If {@code null}.
      @exception  IllegalArgumentException  If empty.
    **/
   public static final void empty(Null nnull, Object string, String str_name, Object xtra_errInfo)  {
      CrashIfObject.nnull(nnull, string, str_name, xtra_errInfo);
      if(string != null  &&  string.toString().length() == 0)  {
         throw  new IllegalArgumentException(getXMsg(str_name + " is non-null, but has no characters.", xtra_errInfo));
      }
   }
   /**
      <P>If a string-element has no characters, crash. Otherwise, do nothing.</P>

      <P>This first calls
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.array.CrashIfIndex}.{@link com.github.xbn.array.CrashIfIndex#edElementIsNull(Object, int, Null, String, String) edElementIsNull}(string, index, nnull, container_name, index_varName)</CODE></P>

      @exception  IllegalArgumentException  If the string element has no characters.
      @see  <CODE><A HREF="{@docRoot}/com/github/xbn/array/CrashIfArray.html">CrashIfArray</A>.<A HREF="{@docRoot}/com/github/xbn/array/CrashIfArray.html#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, com.github.xbn.array.Duplicates)">bad</A></CODE>
      @see  com.github.xbn.list.CrashIfCollection#ofStringsBad(Collection, String, NullContainer, int, String, NullElement, int, String, Duplicates)
      @see  com.github.xbn.list.CrashIfList#ofStringsBad(List, String, NullContainer, int, String, NullElement, Duplicates)
    **/
   public static final void elementEmpty(Null nnull, Object string, int index, String container_name, String index_varName)  {
      CrashIfIndex.edElementIsNull(string, index, nnull, container_name, index_varName);
      if(string.toString().length() == 0)  {
         throw  new IllegalArgumentException("Element " + index + " " +
            ((index_varName == null) ? "" : "(" + index_varName + ") ") +
         "in " + container_name + " has no characters.");
      }
   }
}
