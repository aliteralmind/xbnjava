/*
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */
package  com.github.xbn.io;
   import  java.io.File;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.io.PrintWriter;
/**
   <P>Builder for creating a {@code PrintWriter} that writes text to a file. (This does not implement <CODE>xbn.neederneedable.Chainable</CODE>, because there are no self-returning functions that throw an exception.)</P>

{@.codelet com.github.xbn.examples.io.NewPrintWriterToFileXmpl%eliminateCommentBlocksAndPackageDecl()}

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewPrintWriterToFile  {
//state
   private boolean doOverwrite    = false;
   private boolean bAutoFlush = false;
   /**
      <P>Create a new instance with defaults.</P>

      <P>This calls<OL>
         <LI>{@link #overwrite() overwrite}{@code ()}</LI>
         <LI>{@link #manualFlush() manualFlush}{@code ()}</LI>
      </OL></P>
    **/
   public NewPrintWriterToFile()  {
      overwrite();
      manualFlush();
   }
   /**
      <P>Append to the file. Existing text is left untouched.</P>

      @return  {@link #overwrite(boolean) overwrite}{@code (false)}
    **/
   public NewPrintWriterToFile append()  {
      return  overwrite(false);
   }
   /**
      <P>Overwrite the file. Existing text is erased.</P>

      @return  {@link #overwrite(boolean) overwrite}{@code (false)}
    **/
   public NewPrintWriterToFile overwrite()  {
      return  overwrite(true);
   }
   /**
      <P>Declare if the file should be appended to or overwritten.</P>

      <P>This sets {@link #doAppend() doAppend}{@code ()} to {@code do_overwrite}.</P>

      @see  #append()
      @see  #overwrite()
    **/
   public NewPrintWriterToFile overwrite(boolean do_overwrite)  {
      doOverwrite = do_overwrite;
      return  this;
   }
   /**
      <P>Output is flushed automatically.</P>

      <P>This sets {@link #doAutoFlush() doAutoFlush}{@code ()} to {@code true}.</P>

      @see  #manualFlush()
      @see  java.io.PrintWriter#flush()
    **/
   public NewPrintWriterToFile autoFlush()  {
      bAutoFlush = true;
      return  this;
   }
   /**
      <P>Output must be flushed explicitly.</P>

      <P>This sets {@link #doAutoFlush() doAutoFlush}{@code ()} to {@code true}.</P>

      @see  #autoFlush()
    **/
   public NewPrintWriterToFile manualFlush()  {
      bAutoFlush = false;
      return  this;
   }
   /**
      <P>Is text appended to the file?.</P>

      @return  <CODE>(!{@link #doOverwrite() doOverwrite}())</CODE>
    **/
   public boolean doAppend()  {
      return  (!doOverwrite());
   }
   /**
      <P>If the file exists, is it overwritten?.</P>

      @return  {@code true} if {@link #overwrite() overwrite}{@code ()} was called more recently than {@link #append() append}{@code ()}.
    **/
   public boolean doOverwrite()  {
      return  doOverwrite;
   }
   /**
      <P>Is output automatically flushed?.</P>

      @return  <CODE>true</CODE> if {@link #autoFlush() autoFlush}{@code ()} was called more recently than {@link #manualFlush() manualFlush}{@code ()}
      @see  #isManualFlush()
    **/
   public boolean doAutoFlush()  {
      return  bAutoFlush;
   }
   /**
      <P>Must output be explicitly flushed?.</P>

      @return  <CODE>(!{@link #doAutoFlush() doAutoFlush}())</CODE>
    **/
   public boolean isManualFlush()  {
      return  (!doAutoFlush());
   }
   /**
      <P>Create new {@code PrintWriter} that writes to a file as configured.</P>

      @return  <CODE>{@link #build(File) build}(new {@link java.io.File#File(String) File}(path))</CODE>
    **/
   public PrintWriter build(String path)  {
      try  {
         return  build(new File(path));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(path, "path", null, rx);
      }
   }
   /**
      <P>Create new {@code PrintWriter} that writes to a file as configured.</P>

      @return  <CODE>NewPrintWriterToFile.{@link #build(File, boolean, boolean) build}(file, {@link #doAppend() doAppend}(), {@link #doAutoFlush() doAutoFlush}())</CODE>
      @see  #buildTA(String) buildTA(s)
      @see  #buildMuteableTA(String) buildMuteableTA(s)
    **/
   public PrintWriter build(File file)  {
      return  NewPrintWriterToFile.build(file, doAppend(), doAutoFlush());
   }
   /**
      <P>Create new {@code PrintWriter}, wrapped in a {@code TextAppender}, that writes to a file as configured.</P>

      @return  <CODE>(new {@link TAAppendable}&lt;{@link java.io.PrintWriter PrintWriter}&gt;({@link #build(String) build}(path)))</CODE>
    **/
   public TextAppender buildTA(String path)  {
      return  (new TAAppendable<PrintWriter>(build(path)));
   }
   /**
      <P>Create new {@code PrintWriter}, wrapped in a {@code TAAppendMutable}, that writes to a file as configured.</P>

      @return  <CODE>(new {@link TAAppendMutable}&lt;{@link java.io.PrintWriter PrintWriter}&gt;({@link #build(String) build}(path)))</CODE>
    **/
   public TAAppendMutable<PrintWriter> buildMuteableTA(String path)  {
      return  (new TAAppendMutable<PrintWriter>(build(path)));
   }
   public static final PrintWriter build(String path, boolean do_append, boolean do_autoFlush)  {
      return  build(new File(path), do_append, do_autoFlush);
   }
   /**
      <P><I>Deprecated: Use <CODE>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}</CODE> instead</I> -- Create a new {@code PrintWriter} that writes to a file with specific configuration.</P>

      @deprecated  Use <CODE>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}</CODE> instead</I>
      @return  <CODE>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}(file, do_append, do_autoFlush)</CODE>
    **/
   public static final PrintWriter build(File file, boolean do_append, boolean do_autoFlush)  {
      return  IOUtil.getPrintWriterToFile(file, do_append, do_autoFlush);
   }
}

