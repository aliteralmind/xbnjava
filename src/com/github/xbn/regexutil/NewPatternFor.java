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
package  com.github.xbn.regexutil;
   import  com.github.xbn.text.CrashIfString;
   import  java.util.regex.PatternSyntaxException;
   import  java.util.regex.Pattern;
/**
   <p>Convenience functions for creating {@code java.util.regex.Pattern}-s from strings. {@code java.util.regex.}{@link java.util.regex.Pattern Pattern} allows the regex-strings to be empty. This class requires non-empty.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewPatternFor  {
   /**
      <p>A pattern that cannot be matched--Equal to {@code "(?!a)a"} (a position that is not followed by an {@code 'a'}, that is followed by an {@code 'c'}).</p>

    * @see <code><a href="http://stackoverflow.com/questions/1723182/a-regex-that-will-never-be-matched-by-anything">http://stackoverflow.com/questions/1723182/a-regex-that-will-never-be-matched-by-anything</a></code>
    */
   public static final Pattern IMPOSSIBLE_TO_MATCH = Pattern.compile("(?!a)a");

   private NewPatternFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>Create a new {@code Pattern} from a literal string.</p>

    * @return  <code>{@link #literal(String, String) literal}(text, &quot;literal&quot;, &quot;text&quot;)</code>
    */
   public static final Pattern literal(String text)  {
      return  literal(text, "text");
   }
   /**
      <p>Create a new {@code Pattern} from a literal string.</p>

    * @param  text  May not be {@code null} or empty. <i>{@code Pattern.compile(s)} does allow the empty-string pattern. This class forbids it.</i>
    * @param  text_name  Descriptive name for {@code text}. <i>Should</i> not be {@code null} or empty.
    * @return  {@code Pattern.compile(text, Pattern.LITERAL)}
    */
   public static final Pattern literal(String text, String text_name)  {
      CrashIfString.nullEmpty(text, text_name, null);
      try  {
         return  Pattern.compile(text, Pattern.LITERAL);
      }  catch(PatternSyntaxException psx)  {
         throw  new PatternSyntaxException("Attempting Pattern.compile(" + text_name + ", Pattern.LITERAL). -- " + text_name + "=\"" + text + "\".  //  Original description: " + psx.getDescription(), psx.getPattern(), psx.getIndex());
      }
   }
   public static final Pattern regexIfTrueLiteralIfFalse(boolean is_regex, String find_what, String findWhat_varName)  {
      CrashIfString.nullEmpty(find_what, findWhat_varName, null);
      return  (is_regex
         ?  Pattern.compile(find_what)
         :  literal(find_what));
   }
   /**
      <p>Create a new {@code Pattern} from a(n escaped) regular-expression string.</p>

    * @param  regex  May not be {@code null} or empty, and must be valid for {@code Pattern.compile(s,i)}.
    * @param  rgx_name  Descriptive name for {@code regex}. <i>Should</i> not be {@code null} or empty.
    * @return  {@code Pattern.compile(regex)}
    * @see  #regex(String, int, String) regex(s,i,s)
    * @see  #literal(String) literal(s)
    * @see  #literal(String, String) literal(s,s)
    */
   public static final Pattern regex(String regex, String rgx_name)  {
      CrashIfString.nullEmpty(regex, rgx_name, null);
      try  {
         return  Pattern.compile(regex);
      }  catch(PatternSyntaxException psx)  {
         throw  new PatternSyntaxException("Attempting Pattern.compile(" + rgx_name + "). -- " + rgx_name + "=\"" + regex + "\".  //  Original description: " + psx.getDescription(), psx.getPattern(), psx.getIndex());
      }
   }
   /**
      <p>Create a new {@code Pattern} from a(n escaped) regular-expression string and bit flags.</p>

    * @param  regex  May not be {@code null} or empty, and must be valid for {@code Pattern.compile(s,i)}.
    * @param  bit_flags  Must be valid for {@code Pattern.compile(s,i)}.
    * @param  rgx_name  Descriptive name for {@code regex}. <i>Should</i> not be {@code null} or empty.
    * @return  {@code Pattern.compile(regex)}
    * @see  #regex(String, String) regex(s,s)
    */
   public static final Pattern regex(String regex, int bit_flags, String rgx_name)  {
      CrashIfString.nullEmpty(regex, rgx_name, null);
      try  {
         return  Pattern.compile(regex, bit_flags);
      }  catch(PatternSyntaxException psx)  {
         throw  new PatternSyntaxException("Attempting Pattern.compile(" + rgx_name + ", bit_flags). -- " + rgx_name + "=\"" + regex + "\", bit_flags=" + bit_flags + ".  //  Original description: " + psx.getDescription(), psx.getPattern(), psx.getIndex());
      }
   }
}
