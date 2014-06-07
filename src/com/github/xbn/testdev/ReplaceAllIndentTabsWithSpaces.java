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
package  com.github.xbn.testdev;
   import  com.github.xbn.util.tuple.FourTuple;
   import  java.util.Objects;
   import  com.github.xbn.util.tuple.ThreeTuple;
   import  com.github.xbn.io.NewPrintWriterToFile;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.PlainTextFileUtil;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.number.NumberUtil;
   import  com.github.xbn.text.StringUtil;
   import  java.io.File;
   import  java.io.IOException;
   import  java.io.PrintWriter;
   import  java.text.DecimalFormat;
   import  java.util.Iterator;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Change tab-indentation in a file or directory of files, to spaces.</P>

{@.codelet com.github.xbn.examples.testdev.ReplaceAllIndentTabsWithSpacesXmpl:lineRange(1, false, "allFileTypesKeepFilter =", 1, false, "new ReplaceAllIndentTabsWithSpaces", "^      ")}

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <CODE><A HREF="http://xbnjava.aliteralmind.com">http://xbnjava.aliteralmind.com</A></CODE>, <CODE><A HREF="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</A></CODE>
 **/
public class ReplaceAllIndentTabsWithSpaces  {
   private final TextAppenter debug;
   private final String spaces;
   private final TabToSpaceDebugLevel dbgLevel;
   private static final DecimalFormat DEC_FMT = new DecimalFormat("#.###");
   /**
      <P>Create a new instance from space-count and optional debugging.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel) this}(space_count, debug_ifNonNull, {@link TabToSpaceDebugLevel}.{@link TabToSpaceDebugLevel#ALL_SUMMARY_ONLY ALL_SUMMARY_ONLY})</CODE></P>
    **/
   public ReplaceAllIndentTabsWithSpaces(int space_count, Appendable debug_ifNonNull)  {
      this(space_count, debug_ifNonNull, TabToSpaceDebugLevel.ALL_SUMMARY_ONLY);
   }
   /**
      <P>Create a new instance from space-count and optional debugging.</P>

      @param  space_count  The number of spaces to replace each tab with. If zero, indentation is eliminated. May not be less than zero. Get with {@link #getSpaces() getSpaces}{@code ()}
      @param  debug_ifNonNull  Get with {@link #getDebugAptr() getDebugAptr}{@code ()}.
      @param  debug_level  If {@code debug_ifNonNull} is non-{@code null}, this may not be {@code null}. Get with {@link #getDebugLevel() getDebugLevel}{@code ()}. If<UL>
         <LI>{@link TabToSpaceDebugLevel#OFF OFF}: Nothing is debugged.</LI>
         <LI>{@link TabToSpaceDebugLevel#ALL_SUMMARY_ONLY ALL_SUMMARY_ONLY}: A single summary after all files are processed.</LI>
         <LI>{@link TabToSpaceDebugLevel#FILE_SUMMARIES FILE_SUMMARIES}: In addition to the all-summary, a single dot is printed for every file.</LI>
         <LI>{@link TabToSpaceDebugLevel#FILE_DOTS FILE_DOTS}: In addition to the all-summary, a summary is printed for every file.</LI>
         <LI>{@link TabToSpaceDebugLevel#LINE_COUNTS LINE_COUNTS}: In addition to the above, this also outputs a single character for every line, representing the number of tabs replaced in it (when one or greater). This uses <CODE>{@link com.github.xbn.number.NumberUtil}.{@link com.github.xbn.number.NumberUtil#CHAR_LIST_FOR_NUMBERS_0_THROUGH_62 CHAR_LIST_FOR_NUMBERS_0_THROUGH_62}</CODE>.</LI>
      </UL>
      @exception  NegativeArraySizeException  If {@code space_count} is less than zero.
      @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable)
    **/
   public ReplaceAllIndentTabsWithSpaces(int space_count, Appendable debug_ifNonNull, TabToSpaceDebugLevel debug_level)  {
      spaces = StringUtil.getStringOfLengthAllCharsEqualTo(space_count, ' ', "space_count");
      debug = NewTextAppenterFor.appendableUnusableIfNull(debug_ifNonNull);
      if(debug_ifNonNull != null)  {
         Objects.requireNonNull(debug_level, "debug_level");
         dbgLevel = debug_level;
      }  else  {
         dbgLevel = null;
      }
   }
   /**
      <P>The string-of-spaces, which replaces a single tab.</P>

      @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel)
    **/
   public String getSpaces()  {
      return  spaces;
   }
   /**
      <P>The debugging appenter.</P>

      @see  #getDebugLevel()
      @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel)
    **/
   public TextAppenter getDebugAptr()  {
      return  debug;
   }
   public TabToSpaceDebugLevel getDebugLevel()  {
      return  dbgLevel;
   }
   /**
      <P>Replace all indentation tabs for all files in a directory, with runtime errors only--<I>this overwrites the files</I>.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #overwriteDirectoryX(Iterator) overwriteDirectoryX}(file_itr)</CODE></P>

      @exception  RTIOException  If a {@code java.io.IOException} is thrown for any reason.
    **/
   public FourTuple<Long,Long,Long,Integer> overwriteDirectory(Iterator<File> file_itr)  {
      try  {
         return  overwriteDirectoryX(file_itr);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <P>Replace all indentation tabs for all files in a directory--<I>this overwrites the files</I>.</P>

      <P>For each file, this<OL>
         <LI>{@linkplain com.github.xbn.io.PlainTextFileUtil#getText(File, String) Reads in} the text,</LI>
         <LI>Creates a {@linkplain com.github.xbn.text.StringUtil#getLineIterator(Object) line-iterator} to it,</LI>
         <LI>Opens a {@linkplain com.github.xbn.io.NewPrintWriterToFile print-writer} to the <I>original file</I> (with overwrite and auto-flush), and</LI>
         <LI>calls
         <BR> &nbsp; &nbsp; <CODE>{@link #appendForFileX(Iterator, Appendable) appendForFileX}(<I>[line-iterator]</I>, <I>[print-writer]</I>)</CODE></LI>
      </OL></P>

      @param  file_itr  May not be {@code null}.
      @return  A four-tuple containing, in order, the total number of lines in all files, the total lines containing at least one tab, the total tabs replaced, and the number of files processed.
      @exception  RTIOException  If an {@link java.io.IOException} is thrown for any reason.
      @see  #overwriteDirectory(Iterator)
      @see  org.apache.commons.io.FileUtils#iterateFiles(File, IOFileFilter, IOFileFilter) commons.io.FileUtils#iterateFiles
    **/
   public FourTuple<Long,Long,Long,Integer> overwriteDirectoryX(Iterator<File> file_itr) throws IOException  {
      int totalFiles = 0;
      long totalLines = 0;
      long tabLines = 0;
      long tabsReplaced = 0;

      File f = null;
      try  {
         while(file_itr.hasNext())  {
            f = file_itr.next();

            if(getDebugAptr().isUseable())  {
               if(getDebugLevel().isOnAndAtLeast(
                     TabToSpaceDebugLevel.FILE_DOTS))  {
                  getDebugAptr().appent(".");
               }  else  if(getDebugLevel().isOnAndAtLeast(
                     TabToSpaceDebugLevel.FILE_SUMMARIES))  {
                  getDebugAptr().appent(f.getAbsolutePath() + ": ");
               }

            }

            String s = PlainTextFileUtil.getText(f, f.getAbsolutePath());
            Iterator<String> lineItr = StringUtil.getLineIterator(s);

            PrintWriter fileTextWriter = new NewPrintWriterToFile().overwrite().
               manualFlush().build(f.getAbsolutePath());

            ThreeTuple<Long,Long,Long> stats = appendForFileX(lineItr, fileTextWriter);

            fileTextWriter.flush();
            fileTextWriter.close();

            totalFiles++;
            totalLines += stats.get1();
            tabLines += stats.get2();
            tabsReplaced += stats.get2();
         }
      }  catch(IOException iox)  {
         if(f == null)  {
            throw  iox;
         }
         throw  new RTIOException("File: " + f.getName(), iox);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(file_itr, "file_itr", null, rx);
      }

      if(getDebugAptr().isUseable()  &&  !getDebugLevel().isOff())  {
         getDebugAptr().appentln("ALL FILES: " + getSummaryFromStats(totalFiles, totalLines, tabLines, tabsReplaced));
      }
      return  new FourTuple<Long,Long,Long,Integer>(totalLines, tabLines, tabsReplaced, totalFiles);
   }
   /**
      <P>Replace all indentation tabs in a single file, with runtime errors only.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #appendForFileX(Iterator, Appendable) appendForFileX}(line_itr, output)</CODE></P>

      @exception  RTIOException  If an {@link java.io.IOException} is thrown for any reason.
    **/
   public ThreeTuple<Long,Long,Long> appendForFile(Iterator<String> line_itr, Appendable output)  {
      try  {
         return  appendForFileX(line_itr, output);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <P>Replace all indentation tabs in a single file.</P>

      @param  line_itr  May not be {@code null}.
      @param  to_appendTo  Where output should be written. May not be {@code null}.
      @return  A three-tuple containing, in order, the total number of lines in the file, the total lines containing at least one tab, and the total tabs replaced.
      @see  #appendForFile(Iterator, Appendable) appendForFile
      @see  #overwriteDirectoryX(Iterator)
    **/
   public ThreeTuple<Long,Long,Long> appendForFileX(Iterator<String> line_itr, Appendable to_appendTo) throws IOException  {
      long totalLines = 0;
      long tabLines = 0;
      long tabsReplaced = 0;
      try  {
         while(line_itr.hasNext())  {
            totalLines++;
            String line = line_itr.next();

            if(line.length() == 0)  {
               to_appendTo.append(line).append(LINE_SEP);
               continue;
            }

            int charIdx = 0;
            while(charIdx < line.length()  &&  line.charAt(charIdx) == '\t')  {
               charIdx++;
               to_appendTo.append(getSpaces());
//getDebugAptr().pauseIfUseable("[" + totalLines + "." + charIdx + "]: \"" + getSpaces() + "\"");
            }

            tabsReplaced += charIdx;
            tabLines++;

            if(charIdx > 0  &&  getDebugAptr().isUseable()  &&
                  getDebugLevel().isLineCounts())  {
               getDebugAptr().appent(NumberUtil.getCharForNumber0Through62(charIdx));
            }

            to_appendTo.append(line.substring(charIdx)).append(LINE_SEP);
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(line_itr, "line_itr", null);
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      if(getDebugAptr().isUseable()  &&
            getDebugLevel().isOnAndAtLeast(
               TabToSpaceDebugLevel.FILE_SUMMARIES))  {
         getDebugAptr().appentln();
         getDebugAptr().appent("  - " + getSummaryFromStats(-1, totalLines, tabLines, tabsReplaced));
      }

      return  new ThreeTuple<Long,Long,Long>(totalLines, tabLines, tabsReplaced);
   }
   public static final String getSummaryFromStats(FourTuple<Long,Long,Long,Integer> stats)  {
      try  {
         return  getSummaryFromStats(stats.get4(), stats.get1(), stats.get2(), stats.get3());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(stats, "stats", null, rx);
      }
   }
   public static final String getSummaryFromStats(ThreeTuple<Long,Long,Long> stats)  {
      try  {
         return  getSummaryFromStats(-1, stats.get1(), stats.get2(), stats.get3());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(stats, "stats", null, rx);
      }
   }
   public static final String getSummaryFromStats(int totalFiles_neg1IfIgnore, long total_lines, long tab_lines, long tabs_replaced)  {
      StringBuilder bldr = new StringBuilder();
      if(totalFiles_neg1IfIgnore != -1)  {
         bldr.append("total files=").append(totalFiles_neg1IfIgnore).append(", ");
      }

      bldr.append("total lines=").append(total_lines + ", ");

      if(totalFiles_neg1IfIgnore != -1)  {
         bldr.append("average lines-per-file=").append(DEC_FMT.format(
            total_lines / new Double(totalFiles_neg1IfIgnore))).append(", ");
      }

      bldr.append("with tabs=").append(tab_lines).
         append(", tabs replaced=").append(tabs_replaced).
         append(", average tabs-per-line=").append(DEC_FMT.format(
            tabs_replaced / new Double(total_lines)));

      return  bldr.toString();
   }
}
