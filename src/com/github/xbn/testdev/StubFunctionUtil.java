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
   import  java.util.Iterator;
   import  java.io.File;
   import  java.io.IOException;
   import  java.util.List;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
   import  org.apache.commons.io.FileUtils;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.StringWithNullDefault;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.regexutil.RegexGroupExtractor;
   import  com.github.xbn.util.JavaRegexes;
   import  com.github.xbn.util.JavaRegexUtil;
/**
   <p>Application that generates stub functions in an existing java file, containing a {@code /}{@code *stub...stub*}{@code /} block, which contains a series of function signature lines (through-and-including the open curly-brace: '&#123;').</p>

   <p>{@code java com.github.xbn.testdev.StubFunctionUtil}</p>

   <p>{@code <a href="http://stackoverflow.com/questions/2690118/java-easy-way-to-get-method-stub-out-of-class-files-within-a-jar-file-reflecti">http://stackoverflow.com/questions/2690118/java-easy-way-to-get-method-stub-out-of-class-files-within-a-jar-file-reflecti</a>}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class StubFunctionUtil  {
   private StubFunctionUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final String sSTUB_LINE_MARKER_PREFIX = "/*stub";
   private static final RegexGroupExtractor rexFUNC = JavaRegexUtil.newRXForFuncSigLineToRetTypNameAllParams();
   public static final void main(String[] as_1Rqd_pathToJavaFile)  {
 		String sPathJava = CompositionStubUtil.get1RqdParamPathToJavaFile(as_1Rqd_pathToJavaFile);
 		appendForSource(System.out, sPathJava);
System.out.println("FIX: Allow only one stub function.");
System.out.println("FIX: Allow interface sigs");
   }
   /**
      <p>YYY</p>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public static final Appendable appendForSource(Appendable to_appendTo, String sourceCode_path)  {
      try  {
         return  appendForSourceX(to_appendTo, (new File(sourceCode_path)));
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting appendForSourceX(to_appendTo, (new File(sourceCode_path))). sourceCode_path=\"" + sourceCode_path + "\", to_appendTo=[" + to_appendTo + "]", iox);
      }
   }
   /**
      <p>YYY</p>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public static final Appendable appendForSource(Appendable to_appendTo, File source_code)  {
      try  {
         return  appendForSourceX(to_appendTo, source_code);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting appendForSourceX(to_appendTo, source_code). source_code=\"" + source_code + "\", to_appendTo=[" + to_appendTo + "]", iox);
      }
   }
   public static final Appendable appendForSourceX(Appendable to_appendTo, String sourceCode_path) throws IOException  {
      return  appendForSourceX(to_appendTo, (new File(sourceCode_path)));
   }
   public static final Appendable appendForSourceX(Appendable to_appendTo, File source_code) throws IOException  {
 		CompositionStubUtil.appendJavaFilePathWithDotsNoDtJava(to_appendTo, source_code);
 		to_appendTo.append(LINE_SEP).append(LINE_SEP);
      Iterator<String> li = FileUtils.lineIterator(source_code); //Throws npx if null

      String sClassName = null;
      while(li.hasNext())  {
         String sLn = StringUtil.ltrim(li.next());
         if(sLn.startsWith(sSTUB_LINE_MARKER_PREFIX))  {
            appendStubsX(to_appendTo, li);
         }
      }
      return  to_appendTo;
   }
   private static final void appendStubsX(Appendable to_appendTo, Iterator<String> line_itr) throws IOException  {
      Pattern pFuncRettypNmAllParams = Pattern.compile(JavaRegexes.RTRN_TYPE_FNM_ALL_PARAMS);
      while(line_itr.hasNext())  {
         String sLn = line_itr.next().trim();
         Matcher mFuncRettypNmAllParams = pFuncRettypNmAllParams.matcher(sLn);
         if(mFuncRettypNmAllParams.find())  {
            appendStubForSigLnIfNotAlreadyX(to_appendTo, line_itr, pFuncRettypNmAllParams, mFuncRettypNmAllParams, sLn);
            return;
         }
      }
   }

   private static final Appendable appendStubForSigLnIfNotAlreadyX(Appendable to_appendTo, Iterator<String> line_itr, Pattern p_funcRettypNmAllParams, Matcher m_funcRettypNmAllParamsFOUND, String func_sigLine) throws IOException  {
      //Matcher contains a sig line. Is it already stubbed?
      String sLnAfterSig = line_itr.next().trim();
      Matcher m2 = p_funcRettypNmAllParams.matcher(sLnAfterSig);
      if(m2.find())  {
         //The next line is also a sig. Stub the first one.
         String sReturnType = rexFUNC.search(func_sigLine).next().get(0);
         appendStubFuncForSigLineX(to_appendTo, func_sigLine, sReturnType);
         return  appendStubForSigLnIfNotAlreadyX(to_appendTo, line_itr, p_funcRettypNmAllParams, m2, sLnAfterSig);
      }
      return  to_appendTo;
   }
   /**
      <p>YYY</p>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public static final String getStubFunctionForSigLine(String func_sigLine)  {
      try  {
         return  appendStubFuncForSigLineX((new StringBuilder()), func_sigLine).toString();
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting appendStubFuncForSigLineX((new StringBuilder()), func_sigLine), func_sigLine=\"" + func_sigLine + "\"", iox);
      }
   }
   public static final Appendable appendStubFuncForSigLineX(Appendable to_appendTo, String func_sigLine) throws IOException  {
      try  {
         rexFUNC.search(func_sigLine);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(func_sigLine, "func_sigLine", null, rx);
      }
      List<String> ls = null;
      try  {
         ls = rexFUNC.next();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting to parse signature line for return-type, function-name, and all-parameters: \"" + func_sigLine + "\"", rx);
      }
      String sReturnType = ls.get(0);

      return  appendStubFuncForSigLineX(to_appendTo, func_sigLine, sReturnType);
   }
   private static final Appendable appendStubFuncForSigLineX(Appendable to_appendTo, String func_sigLine, String return_type) throws IOException  {
      to_appendTo.append("\t").append(func_sigLine).append(LINE_SEP);
      if(!return_type.equals("void"))  {
         Object oDefault = JavaRegexUtil.getInitializedObjectForClassName(return_type);
         to_appendTo.append("\t\treturn  ").
            append(StringWithNullDefault.get(oDefault, "null")).append(LINE_SEP);
      }
      return  to_appendTo.append("\t}").append(LINE_SEP);
   }
}
/*stub functions for TESTING THIS CLASS...START
   public static final void writeStubFunction(String func_sigLine, String return_type)  {
   public static final String getInitializedObjectForClassName(String type)  {
   public static final boolean isPrimitiveType(Class<?> class)  {
   public static final void writeStubFunction(String func_sigLine, String return_type)  {
   }
 stub functions for TESTING THIS CLASS...END*/
