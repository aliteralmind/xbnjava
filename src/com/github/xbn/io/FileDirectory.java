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
package  com.github.xbn.io;
   import  com.github.xbn.util.EnumUtil;
/**
   <p>Must a {@code java.nio.file.Path} be a directory, a regular file, or can it be either?.</p>

   @see  PathMustBe#fileOrDirectory(FileDirectory)
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum FileDirectory  {
   /**
      <p>YYY.</p>

      @see  #DIRECTORY
      @see  #EITHER
      @see  #isRegularFile()
    **/
   REGULAR_FILE,
   /**
      <p>YYY.</p>

      @see  #REGULAR_FILE
      @see  #isDirectory()
    **/
   DIRECTORY,
   /**
      <p>YYY.</p>

      @see  #REGULAR_FILE
      @see  #isEither()
    **/
   EITHER;
   /**
      <p>Is this {@code FileDirectory} equal to {@code REGULAR_FILE}?.</p>

      @return  <code>this == {@link #REGULAR_FILE}</code>

      @see  #isDirectory()
      @see  #isEither()
    **/
   public final boolean isRegularFile()  {
      return  this == REGULAR_FILE;
   }
   /**
      <p>Is this {@code FileDirectory} equal to {@code DIRECTORY}?.</p>

      @return  <code>this == {@link #DIRECTORY}</code>
      @see  #isRegularFile()
    **/
   public final boolean isDirectory()  {
      return  this == DIRECTORY;
   }
   /**
      <p>Is this {@code FileDirectory} equal to {@code EITHER}?.</p>

      @return  <code>this == {@link #EITHER}</code>
      @see  #isRegularFile()
    **/
   public final boolean isEither()  {
      return  this == EITHER;
   }
   /**
      <p>If an <code>FileDirectory</code> is not a required value, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
      @see  #crashIfForbiddenValue(FileDirectory, String, Object) crashIfForbiddenValue(ert,s,o)
    **/
   public void crashIfNotRequiredValue(FileDirectory e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
   /**
      <p>If an <code>FileDirectory</code> is a forbidden value, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
      @see  #crashIfNotRequiredValue(FileDirectory, String, Object) crashIfNotRequiredValue(ert,s,o)
    **/
   public void crashIfForbiddenValue(FileDirectory e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
      EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
   }
};
