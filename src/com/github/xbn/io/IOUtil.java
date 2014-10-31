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
	import  com.github.xbn.array.CrashIfIndex;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  com.github.xbn.lang.Null;
	import  com.github.xbn.text.CrashIfString;
	import  java.io.BufferedInputStream;
	import  java.io.BufferedWriter;
	import  java.io.Closeable;
	import  java.io.File;
	import  java.io.FileNotFoundException;
	import  java.io.FileWriter;
	import  java.io.Flushable;
	import  java.io.IOException;
	import  java.io.InputStream;
	import  java.io.PrintWriter;
	import  java.io.Writer;
	import  java.net.MalformedURLException;
	import  java.net.URL;
	import  java.util.Arrays;
	import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Obtain the text from a file or web-page, wrap an {@code java.lang.Appendable} into a {@code java.io.Writer}, and other I/O utilities.</P>

   @see  com.github.xbn.io.PlainTextFileUtil PlainTextFileUtil
   @see  com.github.xbn.util.PropertiesUtil#getPropertiesFromFile(String, String)
   @author  Copyright (C) 2014, Jeff Epstein, with asistance by Marc Baumbach for {@code newWriterForAppendable(apbl)}. Released under the LPGL 2.1. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IOUtil  {
	public static final Appendable APBL_SUPPRESS_ALL = new ApblSuppressAll();
	private IOUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
   /**
      <P>A {@code Flushable} whose {@code flush()} function does nothing. This is used by {@link #newWriterForAppendable(Appendable to_appendTo) newWriterForAppendable}{@code (apbl)} as a (Java 1.5) delta.</P>

      @see  #newWriterForAppendable(Appendable) newWriterForAppendable(apbl)
    **/
	public static final Flushable FLUSHABLE_DO_NOTHING = new Flushable()  {
   	public void flush()  {
      }
   };
   /**
      <P>A {@code Closeable} whose {@code close()} function does nothing. This is used by {@link #newWriterForAppendable(Appendable to_appendTo) newWriterForAppendable}{@code (apbl)} as a (Java 1.5) delta.</P>

      @see  #newWriterForAppendable(Appendable) newWriterForAppendable(apbl)
    **/
	public static final Closeable CLOSEABLE_DO_NOTHING = new Closeable()  {
   	public void close()  {
      }
   };
   /**
      <P>Creates a new {@code java.io.Writer} that wraps around a {@code java.lang.Appendable}. It properly {@link java.io.Writer#flush() flush}es and {@link java.io.Writer#close() close}s appendables that happened to also be {@link java.io.Flushable}s and/or {@link java.io.Closeable Closeable}s. This uses {@code instanceof} only in the constructor, and a (Java 1.5) delta in {@code flush()} and {@code close()}, which avoids having to use any logic or reflection after object construction.</P>

{@.codelet.and.out com.github.xbn.examples.io.WriterForAppendableXmpl%eliminateCommentBlocksAndPackageDecl()}

      <P>This function is also released as a <A HREF="https://gist.github.com/aliteralmind/8494917">gist</A>. It is an example of the <A HREF="http://en.wikipedia.org/wiki/Adapter_pattern#Object_Adapter_pattern">Object Adapter pattern</A>. Thanks to <A HREF="http://stackoverflow.com/users/1211906/marc-baumbach">Marc Baumbach</A> on <A HREF="http://stackoverflow.com">{@code stackoverflow}</A> for the assistance. See (viewed 1/18/2014)
      <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/21200421/how-to-wrap-a-java-lang-appendable-into-a-java-io-writer">http://stackoverflow.com/questions/21200421/how-to-wrap-a-java-lang-appendable-into-a-java-io-writer</A></CODE></P>

      @return  A new writer that uses an appendable to do its output.
      @see  #FLUSHABLE_DO_NOTHING
      @see  #CLOSEABLE_DO_NOTHING
    **/
	public static final Writer newWriterForAppendable(Appendable to_appendTo)  {
      return  (new WFA(to_appendTo));
   }
   /**
   	<P>Get the relative path to a file, chopping off its base directory.</P>

   	@param  path  May not be {@code null}, and <I>should</I> not be empty.
   	@param  allPossible_baseDirs  <I>Should</I> not be empty, and each element must be non-null (and <I>should</I> be non-empty).
   	@return  <CODE>path.{@link java.lang.String#substring(int) substring}(required_baseDir.length())</CODE>
   	@exception  IllegalArgumentStateException  If {@code path} does not start with {@code required_baseDir}.
    **/
   public static final String getRelativePathCrashIfBadBaseDir(String path, String path_varName, String baseDirs_varName, String... allPossible_baseDirs)  {
		for(int i = 0; i < allPossible_baseDirs.length; i++)  {
			String baseDir = allPossible_baseDirs[i];
			if(path.startsWith(allPossible_baseDirs[i]))  {
				try  {
					return  path.substring(baseDir.length());
				}  catch(RuntimeException rx)  {
					CrashIfIndex.edElementIsNull(baseDir, i, Null.BAD, baseDirs_varName, null);
					throw  rx;
				}
			}
		}
//		for(String baseDir : allPossible_baseDirs)  {
//		}
		throw  new IllegalArgumentStateException(path_varName + " (\"" + path + "\") does not start with any of the base directories: " + baseDirs_varName + "=" + Arrays.toString(allPossible_baseDirs));
	}
   /**
      <P>YYY</P>


      <P>See
      <BR> &nbsp; &nbsp; {@code <A HREF="http://stackoverflow.com/questions/21028924/is-there-a-way-to-test-if-a-printwriter-is-open-and-ready-for-output-without-wr">http://stackoverflow.com/questions/21028924/is-there-a-way-to-test-if-a-printwriter-is-open-and-ready-for-output-without-wr</A>}</P>

    **/
	public static final boolean closePrintWriterCheckError(PrintWriter to_close)  {
      try  {
         to_close.close();
         return  to_close.checkError();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_close, "to_close", "Attempting to_close.close()", rx);
      }
   }
	public static final void crashIfPrintWriterError(PrintWriter writer, String wrtr_name)  {
		try  {
			if(writer.checkError())  {
				throw  new IllegalArgumentException(wrtr_name + ".checkError() is true.");
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(writer, wrtr_name, null, rx);
		}
	}
   /**
      <P>Get the source-code from a web page.</P>

      @return  {@link #appendWebPageSourceX(Appendable, String, String) appendWebPageSourceX}{@code ((new StringBuilder()), url, htmlRqd_atEnd)}
    **/
	public static final String getWebPageSourceX(String url, String htmlRqd_atEnd) throws MalformedURLException, IOException  {
      return  appendWebPageSourceX((new StringBuilder()), url, htmlRqd_atEnd).toString();
   }
   /**
      <P>Get the source-code from a web page, with runtime-errors only.</P>

      @return  {@link #appendWebPageSource(Appendable, String, String) appendWebPageSource}{@code ((new StringBuilder()), url, htmlRqd_atEnd)}
    **/
	public static final String getWebPageSource(String url, String htmlRqd_atEnd)  {
      return  appendWebPageSource((new StringBuilder()), url, htmlRqd_atEnd).toString();
   }
   /**
      <P>Append the source-code from a web page, with runtime-errors only.</P>

      @return  {@link #appendWebPageSourceX(Appendable, String, String) appendWebPageSourceX}{@code (to_appendTo, url, htmlRqd_atEnd)}
      @exception  RuntimeException  Whose {@link java.lang.RuntimeException#getCause()}{@code ()} contains the original {@link java.io.IOException} or {@code java.net.MalformedURLException}.
    **/
	public static final Appendable appendWebPageSource(Appendable to_appendTo, String url, String htmlRqd_atEnd)  {
      try  {
         return  appendWebPageSourceX(to_appendTo, url, htmlRqd_atEnd);
      }  catch(IOException iox)  {
         throw  new RuntimeException(iox);
      }
   }
   /**
      <P>Append all source-code from a web page, and optionally verify the tail end of the retrieved source.</P>

      <P><I>I got this from {@code <A HREF="http://www.davidreilly.com/java/java_network_programming/">http://www.davidreilly.com/java/java_network_programming/</A>}, item 2.3.</I></P>

      @param  to_appendTo  May not be {@code null}.
      @param  url  May not be {@code null}, and must be a valid url.
      @param  htmlRqd_atEnd  If non-{@code null}, the web-page's source-code must end with this. May not be empty. If this is found, but then another character exists after it, the entire string is searched for again, starting from the beginning (meaning a potentially-overlapping required string cannot be detected).
      @see  #getWebPageSource(String, String)
      @see  #appendWebPageSource(Appendable, String, String)
    **/
	public static final Appendable appendWebPageSourceX(Appendable to_appendTo, String url, String htmlRqd_atEnd)  throws MalformedURLException, IOException  {
      CrashIfString.nullEmpty(url, "url", null);
      CrashIfString.empty(Null.OK, htmlRqd_atEnd, "htmlRqd_atEnd", null);

      // Create an URL instance
      URL url2 = new URL(url);

      // Get an input stream for reading
      InputStream is = url2.openStream();

      // Create a buffered input stream for efficency
      BufferedInputStream bis = new BufferedInputStream(is);

      int ixEndStr = 0;

      // Repeat until end of file
      boolean wasRqdAtEndFound = false;
      while(true)  {
         int iChar = bis.read();

         // Check for EOF
         if (iChar == -1)  {
            break;
         }

         if(wasRqdAtEndFound)  {
				//This is the character after the last character in the
				//rqd string, so it was found, but not at the end. Start
				//over.
				wasRqdAtEndFound = false;
			}

         char c = (char)iChar;

         try  {
            to_appendTo.append(c);
         }  catch(NullPointerException npx)  {
            throw  new NullPointerException("to_appendTo");
         }
         if(htmlRqd_atEnd != null)  {
            //There is an ending string;
            char[] ac = htmlRqd_atEnd.toCharArray();

            if(c == ac[ixEndStr])  {
               //The character just retrieved is equal to the
               //next character in the ending string.

               if(ixEndStr == (ac.length - 1))  {
                  //The entire string has been found. If this is not the
                  //last character in the webpage, that will be captured
                  //in the next loop.
                  wasRqdAtEndFound = true;
               }

               ixEndStr++;
            }  else  {
               ixEndStr = 0;
            }
         }
      }

      if(htmlRqd_atEnd != null  &&  !wasRqdAtEndFound)  {
         throw  new RTEndOfFileException("htmlRqd_atEnd " + (new String(htmlRqd_atEnd)) + " (is non-null, and was not found at the end of the web-page's source-code.");
      }
      return  to_appendTo;
   }
	public static final String getPathCrashIfNull(File f_f, String pathName)  {
      try  {
         return  f_f.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(f_f, pathName, null, rx);
      }
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
	public static final Appendable appendNewLines(int newLine_count, Appendable to_appendTo)  {
      try  {
         return  appendNewLinesX(newLine_count, to_appendTo);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
	public static final Appendable appendNewLinesX(int newLine_count, Appendable to_appendTo) throws IOException  {
      for(int i = 0; i < newLine_count; i++)  {
         to_appendTo.append(LINE_SEP);
      }
      return  to_appendTo;
   }
	/**
		<P>Create a new {@code PrintWriter} that writes to a file, with runtime errors only.</P>

		@param  file  Must be non-{@code null} and writeable.
		@param  do_append  If {@code true}, the file is appended to. Existing text is left untouched. If {@code false}, existing text is erased.
		@param  do_autoFlush  If {@code true} output is automatically {@link java.io.PrintWriter#flush() flush}ed. If {@code false}, output must be manually flushed.
		@return  <CODE>(new {@link java.io.PrintWriter PrintWriter}(new {@link java.io.BufferedWriter BufferedWriter}(new {@link java.io.FileWriter#FileWriter(File, boolean) FileWriter}(file, do_append)), do_autoFlush))</CODE>
		@exception  RTFileNotFoundException  If a {@link java.io.FileNotFoundException FileNotFoundException} is thrown
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
		@exception  SecurityException  If the file is not writable.
		@see  NewPrintWriterToFile
	 **/
	public static final PrintWriter getPrintWriterToFile(File file, boolean do_append, boolean do_autoFlush)  {
		try  {
			//Create the object to actually write to the file.
			return  (new PrintWriter(new BufferedWriter(new FileWriter(file, do_append)), do_autoFlush));

			//The PrintWriter was successfully created.

		}  catch(FileNotFoundException fnfx)  {
			throw  new RTFileNotFoundException(sIOXPRE + file.getAbsolutePath(), fnfx);
		}  catch(IOException iox)  {
			throw  new RTIOException(sIOXPRE + file.getAbsolutePath(), iox);
		}
	}
		private static String sIOXPRE = "newPrintWriterForFile: path must point to a writeABLE file (the directory must exist, but the file need not exist). file: ";
}
class WFA extends Writer  {
   private final Appendable apbl;
   private final Flushable  flbl;
   private final Closeable  clbl;
	public WFA(Appendable to_appendTo)  {
      if(to_appendTo == null)  {
         throw  new NullPointerException("to_appendTo");
      }
      apbl = to_appendTo;

      //Avoids instanceof at every call to flush() and close()
      flbl = (Flushable)((to_appendTo instanceof Flushable) ? to_appendTo
         :  IOUtil.FLUSHABLE_DO_NOTHING);
      clbl = (Closeable)((to_appendTo instanceof Closeable) ? to_appendTo
         :  IOUtil.CLOSEABLE_DO_NOTHING);
   }
   @Override
	public void write(char[] prim_array, int idx_start, int idx_endX) throws IOException {
      apbl.append(String.valueOf(prim_array), idx_start, idx_endX);
   }
   @Override
	public Writer append(char chr) throws IOException {
      apbl.append(chr);
      return  this;
   }
   @Override
	public Writer append(CharSequence text) throws IOException {
      apbl.append(text);
      return  this;
   }
   @Override
	public Writer append(CharSequence text, int idx_start, int idx_endX) throws IOException  {
      apbl.append(text, idx_start, idx_endX);
      return  this;
   }
   @Override
	public void flush() throws IOException {
      flbl.flush();
   }
   @Override
	public void close() throws IOException {
      flush();
      clbl.close();
   }
}
class ApblSuppressAll implements Appendable  {
	public ApblSuppressAll append(char ignored) throws IOException  {
		return  this;
	}
	public ApblSuppressAll append(CharSequence ignored) throws IOException  {
		return  this;
	}
	public ApblSuppressAll append(CharSequence ignored1, int ignored2, int ignored3) throws IOException  {
		return  this;
	}
	public String toString()  {
		return  this.getClass().getName();
	}
}
