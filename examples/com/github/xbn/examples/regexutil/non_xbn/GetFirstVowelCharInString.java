/*license*\
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
\*license*/

package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <p>Function that returns the first vowel found in a string, via a reusable (pattern and) matcher. Used as an answer for this question on {@code stackoverflow}:
   <br/> &nbsp; &nbsp; <code><a href="http://stackoverflow.com/questions/22765326/regular-expression-for-obtaining-a-vowel-occurrence-in-java">http://stackoverflow.com/questions/22765326/regular-expression-for-obtaining-a-vowel-occurrence-in-java</a></code></p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.GetFirstVowelCharInString}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class GetFirstVowelCharInString  {

   //"": Unused to-search string so the matcher can be reset (and reused).
   private static final Matcher MTCHR_VOWEL = Pattern.compile("\\b\\w[^aeiou]*([aeiou])",
      Pattern.CASE_INSENSITIVE).matcher("");

      //Alternate and more elegant regex, thanks
      //to @GarisMSuero: "[\\w]([aeiou])"

   public static final void main(String[] ignored)  {
      System.out.println(primevaVocal("Speller"));
      System.out.println(primevaVocal("Estinshtien"));
      System.out.println(primevaVocal("Xyz"));
   }
   public static final Character primevaVocal(String to_search)  {
      return  (!MTCHR_VOWEL.reset(to_search).find()  ? '!'
         :  MTCHR_VOWEL.group(1).charAt(0));
   }
}
