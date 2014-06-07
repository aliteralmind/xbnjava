/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.analyze.alter;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>Is it required that the elements in an {@code ExpirableAlterList} are expirable?.</P>

   @see  ExpirableAlterList
   @see  com.github.xbn.lang.Expirable#doesExpire()
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum ExpirableElements  {
   /**
      <P>Allow non-expirable elements.</P>

      @see  #REQUIRED
      @see  #isOptional()
    **/
   OPTIONAL,
   /**
      <P>Do not allow.</P>

      @see  #OPTIONAL
      @see  #isRequired()
    **/
   REQUIRED;
   /**
      <P>Is this {@code ExpirableElements} equal to {@code OPTIONAL}?.</P>

      @return  <CODE>this == {@link #OPTIONAL}</CODE>

      @see  #isRequired()
    **/
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <P>Is this {@code ExpirableElements} equal to {@code REQUIRED}?.</P>

      @return  <CODE>this == {@link #REQUIRED}</CODE>
      @see  #isOptional()
    **/
   public final boolean isRequired()  {
      return  this == REQUIRED;
   }
   /**
      <P>If an <CODE>ExpirableElements</CODE> is not a required value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfForbiddenValue(ExpirableElements, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
   /**
      <P>If an <CODE>ExpirableElements</CODE> is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, xtra_errInfo)</CODE></P>
      @see  #crashIfNotRequiredValue(ExpirableElements, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
   public void crashIfForbiddenValue(ExpirableElements rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
   }
};
