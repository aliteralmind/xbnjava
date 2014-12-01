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
package  com.github.xbn.util;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>Regular expressions related to Java code.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class JavaRegexes  {
   /**
      <p>Matches a Java identifier string (such as the name of a function, class, or package-element), using long character-class names--equal to {@code "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*"}. <i>This works, but is not recognized by RegexBuddy, which is a significant part of my workflow.</i></p>

      <p>From stackoverflow user <a href="http://stackoverflow.com/users/20938/alan-moore">AlanMoore</a>, in a comment under <a href="http://stackoverflow.com/questions/5205339/regular-expression-matching-fully-qualified-java-classes/5205467#5205467">this answer</a>.</p>

    * @see  #IDENTIFIER
    */
   public static final String IDENTIFIER_W_CHR_CLS = "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
   /**
      <p>Matches a Java identifier string (such as the name of a function, class, or package-element), using abbreviated character classes--equal to {@code "[\\p{L}_\\p{Sc}][\\p{L}\\p{N}_\\p{Sc}]*"}. <i>This is equivalent to {@link #IDENTIFIER_W_CHR_CLS} and works in RegexBuddy.</i></p>

      <p>From <a href="http://stackoverflow.com/questions/5205339/regular-expression-matching-fully-qualified-java-classes/5205467#5205467">this answer</a> on <code>stackoverflow</code>.</p>
    */
   public static final String IDENTIFIER = "[\\p{L}_\\p{Sc}][\\p{L}\\p{N}_\\p{Sc}]*";
   /**
      <p>A package name with no capturing groups.</p>

    * <p>Equal to</p>

<blockquote><pre>&quot;(?:&quot; + {@link #IDENTIFIER} + &quot;\\.)*&quot; + IDENTIFIER + &quot;&quot;</pre></blockquote>
    */
   public static final String PACKAGE_NAME = "(?:" + IDENTIFIER + "\\.)*" + IDENTIFIER + "";
   /**
      <p>A package name, with a capturing group for the classes simple name (the final identifier).</p>

    * <p>Equal to</p>

<blockquote><pre>&quot;(?:&quot; + {@link #IDENTIFIER} + &quot;\\.)*(&quot; + IDENTIFIER + &quot;)&quot;</pre></blockquote>
    */
   public static final String PACKAGE_CAPTURE_SIMPLE_NAME = "(?:" + IDENTIFIER + "\\.)*(" + IDENTIFIER + ")";
   /**
      <p>Captures an import statement on a single line, with a capturing group for the classes simple name--the import may or may not be static.</p>

    * <p>Equal to</p>

<blockquote><pre>&quot;[ \\t]*import[ \\t]+(?:static[ \\t]+)?(?:&quot; + {@link #PACKAGE_CAPTURE_SIMPLE_NAME} + &quot;(\\.\\*)&quot;</pre></blockquote>
    */
   public static final String IMPORT_LINE_CAPTURE_SIMPLE_NAME = "[ \\t]*import[ \\t]+(?:static[ \\t]+)?" + PACKAGE_CAPTURE_SIMPLE_NAME + "(?:\\.\\*)?[ \t]*;[ \t]*(?://.*)?$";

   /**
      <p>A package declaration that exist in a single line, and contains no comments.</p>

    * <p>Equal to</p>

<blockquote><pre>&quot;^[ \\t]*package[ \\t]+&quot; + {@link #PACKAGE_NAME} + &quot;[ \\t]*;[ \\t]*$&quot;</pre></blockquote>
    */
   public static final String PACKAGE_DECL_ONE_LINE_NO_CMTS = "^[ \\t]*package[ \\t]+" + PACKAGE_NAME + "[ \\t]*;[ \\t]*$";
   /**
      <p>A package name, ending with a dot ({@code '.'}).</p>
    */
   public static final String FQ_CLASS_NAME = PACKAGE_NAME + IDENTIFIER;
   public static final String CNSTR_NAME_ALL_PARAMS = "\\b([\\w.]+)\\b\\(([^\\)\\n\\r]*)\\)";
   public static final String PARAM_TYPE_NAME_DIV = "(?<=(^|, ))([\\w.]+)((?:<[^>]+>)?(?:\\[\\])?(?:\\.\\.\\.)?)\\s+(\\w+)(|$)";
   public static final String RTRN_TYPE_FNM_ALL_PARAMS = (new StringBuilder()).
      append("\\s+\\b"               ).
      append("([\\w.]+)"             ). //Return type
      append("\\b(?:<[^>]+>)?\\s+\\b").
      append("([\\w.]+)"             ). //Function name
      append("\\b\\("                ).
      append("([^\\)\\n\\r]*)"       ). //All parameters
      append("\\)"                   ).toString();

   /**
      <p>Matches a line containing a single-line comment, with <i>no other text (whitespace only) before the comment</i>--this  matches up-through-and-including the &quot;/<!--  -->/&quot;.</p>

    * <p>Equal to <b>{@code &quot;^(\\s*)/&quot; + &quot;/&quot;}</b></p>
    */
   public static final String LN_STRT_WS_2SLASHES = "^(\\s*)/" + "/";
   /**
      <p>Matches a line containing a single-line comment, with <i>no other text (whitespace only) before the comment</i>--this  matches the entire line.</p>

    * <p>Equal to {@link #LN_STRT_WS_2SLASHES LN_STRT_WS_2SLASHES}{@code + "(.*)$"}</p>
    */
   public static final String LN_STRT_WS_2SLASHES_DOT_STAR = LN_STRT_WS_2SLASHES + "(.*)$";
   /**
      <p>The open marker in a Java multi-line comment ({@code "/}{@code *"}) which optionally recognizes JavaDoc blocks ({@code "/}{@code **"}).</p>

    * @param  java_doc  If {@link IncludeJavaDoc#YES YES}, then JavaDoc blocks (those that start with two asterisks following the slash) are also matched. If {@link IncludeJavaDoc#NO NO}, then JavaDoc blocks are ignored. May not be {@code null}.
    * @return  If<ul>
         <li>{@code java_doc.YES}: {@code "(?:/"+"\\*)"}</li>
         <li>{@code java_doc.NO}: {@code "(?:/"+"\\*(?!\\*))"} (a <a href="http://www.regular-expressions.info/lookaround.html">negative lookahead</a> for the second asterisk)</li>
      </ul>
    */
   public static final String getMultiLineCommentOpenMarkerRegex(IncludeJavaDoc java_doc)  {
      String s = "(?:/"+"\\*";
      try  {
         if(java_doc.isNo())  {
            s += "(?!\\*)";
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(java_doc, "java_doc", null, rx);
      }
      return  s + ")";
   }
}
