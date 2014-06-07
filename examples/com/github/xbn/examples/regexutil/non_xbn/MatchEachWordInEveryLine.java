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
   import  java.util.Iterator;
   import  java.io.File;
   import  java.io.IOException;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
   import  org.apache.commons.io.FileUtils;
/**
   <P>Reusing a single matcher object, read in a text file, and match every word in every line.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.MatchEachWordInEveryLine xbn\examples\text\regex\text_to_word_iterate.txt}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class MatchEachWordInEveryLine  {
   public static final void main(String[] as_1RqdTxtFilePath)  {
      Iterator<String> lineItr = null;
      try  {
         lineItr = FileUtils.lineIterator(new File(as_1RqdTxtFilePath[0])); //Throws npx if null
      }  catch(IOException iox)  {
         throw  new RuntimeException("Attempting to open \"" + as_1RqdTxtFilePath[0] + "\"", iox);
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("One required parameter: The path to the text file.", rx);
      }

      //Dummy search string (""), so it can be reused (reset)
      Matcher mWord = Pattern.compile("\\b\\w+\\b").matcher("");
      while(lineItr.hasNext())  {
         String sLine = lineItr.next();
         mWord.reset(sLine);
         while(mWord.find())  {
            System.out.println(mWord.group());
         }
      }

   }
}
