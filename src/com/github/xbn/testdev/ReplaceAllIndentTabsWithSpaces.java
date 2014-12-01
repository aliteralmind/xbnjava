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
package  com.github.xbn.testdev;
   import  com.github.xbn.io.NewPrintWriterToFile;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.PlainTextFileUtil;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.number.NumberUtil;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.util.tuple.FourTuple;
   import  com.github.xbn.util.tuple.ThreeTuple;
   import  java.io.File;
   import  java.io.IOException;
   import  java.io.PrintWriter;
   import  java.text.DecimalFormat;
   import  java.util.Iterator;
   import  java.util.Objects;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Change tab-indentation in a file or directory of files, to spaces.</p>

{@.codelet com.github.xbn.examples.testdev.ReplaceAllIndentTabsWithSpacesXmpl%lineRange(1, false, "allFileTypesKeepFilter =", 1, false, "new ReplaceAllIndentTabsWithSpaces", "^      ")}

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReplaceAllIndentTabsWithSpaces  {
   private final TextAppenter debug;
   private final String spaces;
   private final TabToSpaceDebugLevel dbgLevel;
   private static final DecimalFormat DEC_FMT = new DecimalFormat("#.###");
   /**
      <p>Create a new instance from space-count and optional debugging.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel) this}(space_count, debug_ifNonNull, {@link TabToSpaceDebugLevel}.{@link TabToSpaceDebugLevel#ALL_SUMMARY_ONLY ALL_SUMMARY_ONLY})</code></p>
    */
   public ReplaceAllIndentTabsWithSpaces(int space_count, Appendable debug_ifNonNull)  {
      this(space_count, debug_ifNonNull, TabToSpaceDebugLevel.ALL_SUMMARY_ONLY);
   }
   /**
      <p>Create a new instance from space-count and optional debugging.</p>

    * @param  space_count  The number of spaces to replace each tab with. If zero, indentation is eliminated. May not be less than zero. Get with {@link #getSpaces() getSpaces}{@code ()}
    * @param  debug_ifNonNull  Get with {@link #getDebugAptr() getDebugAptr}{@code ()}.
    * @param  debug_level  If {@code debug_ifNonNull} is non-{@code null}, this may not be {@code null}. Get with {@link #getDebugLevel() getDebugLevel}{@code ()}. If<ul>
         <li>{@link TabToSpaceDebugLevel#OFF OFF}: Nothing is debugged.</li>
         <li>{@link TabToSpaceDebugLevel#ALL_SUMMARY_ONLY ALL_SUMMARY_ONLY}: A single summary after all files are processed.</li>
         <li>{@link TabToSpaceDebugLevel#FILE_SUMMARIES FILE_SUMMARIES}: In addition to the all-summary, a single dot is printed for every file.</li>
         <li>{@link TabToSpaceDebugLevel#FILE_DOTS FILE_DOTS}: In addition to the all-summary, a summary is printed for every file.</li>
         <li>{@link TabToSpaceDebugLevel#LINE_COUNTS LINE_COUNTS}: In addition to the above, this also outputs a single character for every line, representing the number of tabs replaced in it (when one or greater). This uses <code>{@link com.github.xbn.number.NumberUtil}.{@link com.github.xbn.number.NumberUtil#CHAR_LIST_FOR_NUMBERS_0_THROUGH_62 CHAR_LIST_FOR_NUMBERS_0_THROUGH_62}</code>.</li>
      </ul>
    * @exception  NegativeArraySizeException  If {@code space_count} is less than zero.
    * @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable)
    */
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
      <p>The string-of-spaces, which replaces a single tab.</p>

    * @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel)
    */
   public String getSpaces()  {
      return  spaces;
   }
   /**
      <p>The debugging appenter.</p>

    * @see  #getDebugLevel()
    * @see  #ReplaceAllIndentTabsWithSpaces(int, Appendable, TabToSpaceDebugLevel)
    */
   public TextAppenter getDebugAptr()  {
      return  debug;
   }
   public TabToSpaceDebugLevel getDebugLevel()  {
      return  dbgLevel;
   }
   /**
      <p>Replace all indentation tabs for all files in a directory, with runtime errors only--<i>this overwrites the files</i>.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #overwriteDirectoryX(Iterator) overwriteDirectoryX}(file_itr)</code></p>

    * @exception  RTIOException  If a {@code java.io.IOException} is thrown for any reason.
    */
   public FourTuple<Long,Long,Long,Integer> overwriteDirectory(Iterator<File> file_itr)  {
      try  {
         return  overwriteDirectoryX(file_itr);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>Replace all indentation tabs for all files in a directory--<i>this overwrites the files</i>.</p>

      <p>For each file, this<ol>
         <li>{@linkplain com.github.xbn.io.PlainTextFileUtil#getText(File, String) Reads in} the text,</li>
         <li>Creates a {@linkplain com.github.xbn.text.StringUtil#getLineIterator(Object) line-iterator} to it,</li>
         <li>Opens a {@linkplain com.github.xbn.io.NewPrintWriterToFile print-writer} to the <i>original file</i> (with overwrite and auto-flush), and</li>
         <li>calls
         <br/> &nbsp; &nbsp; <code>{@link #appendForFileX(Iterator, Appendable) appendForFileX}(<i>[line-iterator]</i>, <i>[print-writer]</i>)</code></li>
      </ol></p>

    * @param  file_itr  May not be {@code null}.
    * @return  A four-tuple containing, in order, the total number of lines in all files, the total lines containing at least one tab, the total tabs replaced, and the number of files processed.
    * @exception  RTIOException  If an {@link java.io.IOException} is thrown for any reason.
    * @see  #overwriteDirectory(Iterator)
    * @see  org.apache.commons.io.FileUtils#iterateFiles(File, IOFileFilter, IOFileFilter) commons.io.FileUtils#iterateFiles
    */
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
      <p>Replace all indentation tabs in a single file, with runtime errors only.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #appendForFileX(Iterator, Appendable) appendForFileX}(line_itr, output)</code></p>

    * @exception  RTIOException  If an {@link java.io.IOException} is thrown for any reason.
    */
   public ThreeTuple<Long,Long,Long> appendForFile(Iterator<String> line_itr, Appendable output)  {
      try  {
         return  appendForFileX(line_itr, output);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>Replace all indentation tabs in a single file.</p>

    * @param  line_itr  May not be {@code null}.
    * @param  to_appendTo  Where output should be written. May not be {@code null}.
    * @return  A three-tuple containing, in order, the total number of lines in the file, the total lines containing at least one tab, and the total tabs replaced.
    * @see  #appendForFile(Iterator, Appendable) appendForFile
    * @see  #overwriteDirectoryX(Iterator)
    */
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
