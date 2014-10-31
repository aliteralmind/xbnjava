package  com.github.xbn.testdev;
	import  java.util.Iterator;
	import  java.util.Arrays;
	import  java.io.File;
	import  java.util.Objects;
	import  java.io.IOException;
	import  com.github.xbn.io.RTIOException;
	import  java.util.List;
	import  org.apache.commons.io.FileUtils;
	import  com.github.xbn.lang.CrashIfObject;
	import  static com.github.xbn.lang.XbnConstants.*;
	import  com.github.xbn.regexutil.RegexGroupExtractor;
	import  com.github.xbn.regexutil.RegexReplacer;
	import  com.github.xbn.util.JavaRegexUtil;

/**
	<P>Application that creates in composition stub functions (as in <A HREF="https://www.google.com/search?q=composition+versus+inheritance+java">composition versus inheritance</A>) for all {@code @CompositionContructor}s and {@code @CompositionFunction}s annotAted methods (as most commonly found in {@code "*Composer"} classes).</P>

	<P>{@code java com.github.xbn.testdev.CompositionStubUtil R:\jeffy\programming\sandbox\xbnjava\xbn\lang\chain\ChainableComposer.java}</P>

	<H3>Instructions for running this application as a tool in TextPad, on the current java file</H3>

<PRE>Command: cmd.exe
Parameters: java xbn.testdev.CompositionStubUtil $File
Initial directory: $FileDir</PRE>

 **/
public class CompositionStubUtil {
	private CompositionStubUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	private static final RegexGroupExtractor rexCNSTR = JavaRegexUtil.newRXForCnstrSigLineToNameAllParams();
	private static final RegexGroupExtractor rexFUNC = JavaRegexUtil.newRXForFuncSigLineToRetTypNameAllParams();
	private static final RegexReplacer rrPARAM_TYPE_NM_TO_NM = JavaRegexUtil.newRRForAllParamTypeNamesToNames();
	private static final RegexReplacer rrPARAM_Y_NM_TO_Y = JavaRegexUtil.newRRForAllParamTypeNamesTo4FQTypes();
	private static final String UNDR_GEN_UNDR = "_GENERICS_";

	/**
		<P>YYY</P>

		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public static final void main(String[] as_1Rqd_pathToJavaFile)  {
/*
		String sCnstrNmInGrp = "\\b([\\w.]+)\\b";
		String sOpenPrnThrPreParamNm1 = "\\((?:(?:[\\w.]+)\\b(?:|(?:<[?\\w\\[\\] ,.&]+>)|(?:<[^<]*<[?\\w\\[\\] ,.&]+>[^>]*>)|(?:<[^<]*<[^<]*<[?\\w\\[\\] ,.&]+>[^>]*>[^>]*>))((?:\\[\\]){0,})(\\.\\.\\.)?\\s+";
		String sParamNmInGrp = "(\\w+)";
		String sPostParam1ThrPreParamNm2 = "\\b(?![>\\[])\\s*(?:,\\s+\\b(?:[\\w.]+)\\b(?:|(?:<[?\\w\\[\\] ,.&]+>)|(?:<[^<]*<[?\\w\\[\\] ,.&]+>[^>]*>)|(?:<[^<]*<[^<]*<[?\\w\\[\\] ,.&]+>[^>]*>[^>]*>))((?:\\[\\]){0,})(\\.\\.\\.)?\\s+";
		String sPostParam2 = "\\b(?![>\\[])\\s*){0,})?\\s*\\)";

		String sRECnstr3Grps = "(" + sCnstrNmInGrp + sOpenPrnThrPreParamNm1 + sParamNmInGrp + sPostParam1ThrPreParamNm2 + sParamNmInGrp + sPostParam2 + ")";
 */
 		String sPathJava = get1RqdParamPathToJavaFile(as_1Rqd_pathToJavaFile);
 		try  {
			appendForSourceX(System.out, sPathJava);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting get1RqdParamPathToJavaFile(as_1Rqd_pathToJavaFile): as_1Rqd_pathToJavaFile=" + Arrays.toString(as_1Rqd_pathToJavaFile), iox);
		}
	}
	/**
		<P>YYY</P>

		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public static final void appendForSource(Appendable to_appendTo, String sourceCode_path)  {
		try  {
			appendForSourceX(to_appendTo, (new File(sourceCode_path)));
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting appendForSourceX(to_appendTo, (new File(sourceCode_path))): sourceCode_path=\"" + sourceCode_path + "\". to_appendTo=[" + to_appendTo + "]", iox);
		}
	}
	/**
		<P>YYY</P>

		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public static final void appendForSource(Appendable to_appendTo, File source_code)  {
		try  {
			appendForSourceX(to_appendTo, source_code);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting appendForSourceX(to_appendTo, source_code): source_code=\"" + source_code + "\". to_appendTo=[" + to_appendTo + "]", iox);
		}
	}
	public static final void appendForSourceX(Appendable to_appendTo, String sourceCode_path) throws IOException  {
		appendForSourceX(to_appendTo, (new File(sourceCode_path)));
	}
	public static final void appendForSourceX(Appendable to_appendTo, File source_code) throws IOException  {
 		appendJavaFilePathWithDotsNoDtJava(to_appendTo, source_code);

		Iterator<String> lineItr = FileUtils.lineIterator(source_code); //Throws npx if null

		String sClassName = null;
		boolean bFuncsStarted = false;
		while(lineItr.hasNext())  {
			String sLn = lineItr.next().trim();
			if(sLn.equals("@CompositionConstructor"))  {
				String sCnstrSig = lineItr.next();  //CI !hasNext()
//				System.out.println("Constructor: " + sCnstrSig);
//				System.out.println("\t" + rexCNSTR.search(sCnstrSig).nextAsJoined("  //  "));
				List<String> ls = rexCNSTR.search(sCnstrSig).next();
				if(sClassName == null)  {
					StringBuilder sd = new StringBuilder();
					sClassName = appendCompositionCnstrCallGetClsNm(sd, ls);
					to_appendTo.append("\tprivate final ").append(sClassName).append(UNDR_GEN_UNDR).
						append(" ").append(sXMK).append(";").append(LINE_SEP);
					to_appendTo.append(sd.toString());
				}  else  {
					appendCompositionCnstrCallGetClsNm(to_appendTo, ls);
				}
			}  else if(sLn.equals("@CompositionFunction"))  {
				if(!bFuncsStarted)  {
					to_appendTo.append("\t//Composition implementation: " + sClassName + "...START").append(LINE_SEP);
					bFuncsStarted = true;
				}
				String sFuncSig = getSigLinePastOtherAnnotations(sLn, lineItr);
//				System.out.println("Function: " + sFuncSig);
//				System.out.println("\t" + rexCNSTR.search(sFuncSig).nextAsJoined("  //  "));
				List<String> ls = rexFUNC.search(sFuncSig).next();
				appendCompositionStubFunction(to_appendTo, ls, sClassName);
			}
		}
		to_appendTo.append("\t//Composition implementation: " + sClassName + "...END").append(LINE_SEP);
	}
		private static final String getSigLinePastOtherAnnotations(String selfCmprurrentLine, Iterator<String> line_itr)  {
			while(selfCmprurrentLine.trim().startsWith("@"))  {  //The 1st call to trim is redundant
				//This passes through other annotation-only lines
				//that are between @Composition* and the signature
				selfCmprurrentLine = line_itr.next();  //CI !hasNext()
			}
			return  selfCmprurrentLine;
		}
	public static final String appendCompositionCnstrCallGetClsNm(Appendable to_appendTo, List<String> ls_fromrex) throws IOException  {
		String sCnstrName = ls_fromrex.get(0);
		String sAllParams = ls_fromrex.get(1);
		to_appendTo.append("\t\t").append(sXMK).append(" = new ").append(sCnstrName).append(UNDR_GEN_UNDR).
			append("(").
				append(rrPARAM_TYPE_NM_TO_NM.getReplaced(sAllParams)).
			append(");").append(LINE_SEP);
		return  sCnstrName;
	}

	public static final String sU4PROT = "_4prot";
	public static final void appendCompositionStubFunction(Appendable to_appendTo, List<String> ls_fromrex, String selfCmprlassName) throws IOException  {
		String sReturnType = ls_fromrex.get(0);
		String sFuncName = ls_fromrex.get(1);
		String sAllParams = ls_fromrex.get(2);

		boolean b4Prot = sFuncName.endsWith(sU4PROT);
		boolean bVoid = sReturnType.equals("void");
		String sAllParamNames = rrPARAM_TYPE_NM_TO_NM.getReplaced(sAllParams);

		to_appendTo.append("\t\t/").append("**").append(LINE_SEP);
		if(bVoid)  {
			to_appendTo.append("\t\t\t<P>FUNC_JD_INTRO</P>").append(LINE_SEP);
		}
		to_appendTo.append("\t\t\t");

		if(bVoid)  {
			to_appendTo.append("<P>Equal to").append(LINE_SEP);
			to_appendTo.append("\t\t\t<BR> &nbsp; &nbsp;");
		}  else  {
			to_appendTo.append("@return  ");
		}

//		rrPARAM_Y_NM_TO_Y.setDebug(System.out, true);
		to_appendTo.append("{@code <A HREF=\"" + sYMK + "/").
			append(selfCmprlassName).append(".html\"><I>[").append(selfCmprlassName).
			append("]</I></A>.<A HREF=\"" + sYMK + "/").append(selfCmprlassName).
			append(".html#").append(sFuncName).append("(").
			append(rrPARAM_Y_NM_TO_Y.getReplaced(sAllParams)).
			append(")\">").append(sFuncName).append("</A>(" + sAllParamNames + ")}");

		if(bVoid)  {
			to_appendTo.append("</P>");
		}

		to_appendTo.append(LINE_SEP);

		to_appendTo.append("\t\t **").append("/").append(LINE_SEP);
		to_appendTo.append("\t\t");

		if(b4Prot)  {
			to_appendTo.append("protected");
		}  else  {
			to_appendTo.append("public");
		}

		to_appendTo.append(" ").append(sReturnType).append(" ");
		if(b4Prot)  {
			to_appendTo.append(sFuncName.substring(0, (sFuncName.length() - sU4PROT.length())));
		}  else  {
			to_appendTo.append(sFuncName);
		}
		to_appendTo.append("(").append(sAllParams).append(")").append("  {").append(LINE_SEP);
		to_appendTo.append("\t\t\t");

		if(!bVoid)  {
			to_appendTo.append("return  ");
		}

		to_appendTo.append(sXMK).append(".").append(sFuncName);
		to_appendTo.append("(").
			append(sAllParamNames).
			append(");").append(LINE_SEP);
		to_appendTo.append("\t\t}").append(LINE_SEP);


	}

	public static final String get1RqdParamPathToJavaFile(String[] as_1Rqd_pathToJavaFile)  {
		try  {
			return  as_1Rqd_pathToJavaFile[0];
		}  catch(RuntimeException rx)  {
			if(as_1Rqd_pathToJavaFile.length == 0)  {
				throw  new RuntimeException("Exactly one required parameter: The full path to the *Composer.java source file.", rx);
			}
			throw  rx;
		}
	}
	public static final Appendable appendJavaFilePathWithDotsNoDtJava(Appendable to_appendTo, File source_code) throws IOException  {
		try  {
			return  appendJavaFilePathWithDotsNoDtJava(to_appendTo, source_code.getPath());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(source_code, "source_code", null, rx);
		}
	}
	public static final Appendable appendJavaFilePathWithDotsNoDtJava(Appendable to_appendTo, String srcCode_path) throws IOException  {
		try  {
			return  to_appendTo.append(JavaRegexUtil.getJavaFilePathElimDtJvDtClsRplcFSToDot(srcCode_path)).append(LINE_SEP);
		}  catch(RuntimeException rx)  {
			Objects.requireNonNull(srcCode_path, "srcCode_path");
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}
	}
}
