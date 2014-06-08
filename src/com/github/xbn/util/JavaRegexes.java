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
/**
   <P>Regular expressions related to Java code.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class JavaRegexes  {
   /**
      <P>Matches a Java identifier string (such as the name of a function, class, or package-element), using long character-class names--equal to {@code "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*"}. <I>This works, but is not recognized by RegexBuddy, which is a significant part of my workflow.</I></P>

      <P>From stackoverflow user <A HREF="http://stackoverflow.com/users/20938/alan-moore">AlanMoore</A>, in a comment under <A HREF="http://stackoverflow.com/questions/5205339/regular-expression-matching-fully-qualified-java-classes/5205467#5205467">this answer</A>.</P>

      @see  #IDENTIFIER
    **/
   public static final String IDENTIFIER_W_CHR_CLS = "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
   /**
      <P>Matches a Java identifier string (such as the name of a function, class, or package-element), using abbreviated character classes--equal to {@code "[\\p{L}_\\p{Sc}][\\p{L}\\p{N}_\\p{Sc}]*"}. <I>This is equivalent to {@link #IDENTIFIER_W_CHR_CLS} and works in RegexBuddy.</I></P>

      <P>From <A HREF="http://stackoverflow.com/questions/5205339/regular-expression-matching-fully-qualified-java-classes/5205467#5205467">this answer</A> on <CODE>stackoverflow</CODE>.</P>
    **/
   public static final String IDENTIFIER = "[\\p{L}_\\p{Sc}][\\p{L}\\p{N}_\\p{Sc}]*";
   /**
      <P>A package name.</P>

      <P>Equal to</P>

<BLOCKQUOTE><PRE>&quot;(?:&quot; + {@link #IDENTIFIER} + &quot;)(?:\\.&quot; + IDENTIFIER + &quot;)*&quot;</PRE></BLOCKQUOTE>
    **/
   public static final String PACKAGE_NAME = "(?:" + IDENTIFIER + ")(?:\\." + IDENTIFIER + ")*";
   /**
      <P>A package declaration that exist in a single line, and contains no comments.</P>

      <P>Equal to</P>

<BLOCKQUOTE><PRE>&quot;^[ \\t]*package[ \\t]+&quot; + {@link #PACKAGE_NAME} + &quot;[ \\t]*;[ \\t]*$&quot;</PRE></BLOCKQUOTE>
    **/
   public static final String PACKAGE_DECL_ONE_LINE_NO_CMTS = "^[ \\t]*package[ \\t]+" + PACKAGE_NAME + "[ \\t]*;[ \\t]*$";
   /**
      <P>A package name, ending with a dot ({@code '.'}).</P>
    **/
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
      <P>Matches a line containing a single-line comment, with <I>no other text (whitespace only) before the comment</I>--this  matches up-through-and-including the &quot;/<!--  -->/&quot;.</P>

      <P>Equal to <B>{@code &quot;^(\\s*)/&quot; + &quot;/&quot;}</B></P>
    **/
   public static final String LN_STRT_WS_2SLASHES = "^(\\s*)/" + "/";
   /**
      <P>Matches a line containing a single-line comment, with <I>no other text (whitespace only) before the comment</I>--this  matches the entire line.</P>

      <P>Equal to {@link #LN_STRT_WS_2SLASHES LN_STRT_WS_2SLASHES}{@code + "(.*)$"}</P>
    **/
   public static final String LN_STRT_WS_2SLASHES_DOT_STAR = LN_STRT_WS_2SLASHES + "(.*)$";
}
