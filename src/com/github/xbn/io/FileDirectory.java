/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names LICENSE_lgpl-3.0.txt and LICENSE_asl-2.0.txt. The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.io;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>Must a {@code java.nio.file.Path} be a directory, a regular file, or can it be either?.</P>

   @see  PathMustBe#fileOrDirectory(FileDirectory)
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <CODE><A HREF="http://xbnjava.aliteralmind.com">http://xbnjava.aliteralmind.com</A></CODE>, <CODE><A HREF="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</A></CODE>
 **/
public enum FileDirectory  {
   /**
      <P>YYY.</P>

      @see  #DIRECTORY
      @see  #EITHER
      @see  #isRegularFile()
    **/
   REGULAR_FILE,
   /**
      <P>YYY.</P>

      @see  #REGULAR_FILE
      @see  #isDirectory()
    **/
   DIRECTORY,
   /**
      <P>YYY.</P>

      @see  #REGULAR_FILE
      @see  #isEither()
    **/
   EITHER;
   /**
      <P>Is this {@code FileDirectory} equal to {@code REGULAR_FILE}?.</P>

      @return  <CODE>this == {@link #REGULAR_FILE}</CODE>

      @see  #isDirectory()
      @see  #isEither()
    **/
   public final boolean isRegularFile()  {
      return  this == REGULAR_FILE;
   }
   /**
      <P>Is this {@code FileDirectory} equal to {@code DIRECTORY}?.</P>

      @return  <CODE>this == {@link #DIRECTORY}</CODE>
      @see  #isRegularFile()
    **/
   public final boolean isDirectory()  {
      return  this == DIRECTORY;
   }
   /**
      <P>Is this {@code FileDirectory} equal to {@code EITHER}?.</P>

      @return  <CODE>this == {@link #EITHER}</CODE>
      @see  #isRegularFile()
    **/
   public final boolean isEither()  {
      return  this == EITHER;
   }
   /**
      <P>If an <CODE>FileDirectory</CODE> is not a required value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
      @see  #crashIfForbiddenValue(FileDirectory, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(FileDirectory e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
   /**
      <P>If an <CODE>FileDirectory</CODE> is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
      @see  #crashIfNotRequiredValue(FileDirectory, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
   public void crashIfForbiddenValue(FileDirectory e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
};
