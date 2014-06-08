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
package  com.github.xbn.examples.io.non_xbn;
   import  java.util.Iterator;
   import  java.io.File;
   import  java.util.Arrays;
   import  org.apache.commons.lang3.StringUtils;
   import  java.io.IOException;
   import  org.apache.commons.io.FileUtils;

/**
   <P>Read in a text-file, and split each line on spaces, putting the result in a string-array.</P>

   <P>{@code java DelimitWordsInATextFile xbn\examples\io\non_xbn\DelimitWordsInATextFile_input.txt}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class DelimitWordsInATextFile  {
   public static final void main(String[] as_1RqdPathToInput)  {
      //Read command-line
         String sSrc = null;
         try  {
            sSrc = as_1RqdPathToInput[0];
         }  catch(IndexOutOfBoundsException ibx)  {
            System.out.println("Missing one-and-only required parameter: The full path to input file.");
            return;
         }

      //Open input file
         File fSrc = new File(sSrc);
         Iterator<String> lineItr = null;
         try  {
            lineItr = FileUtils.lineIterator(fSrc);
         }  catch(IOException iox)  {
            System.out.println("Cannot open \"" + sSrc + "\". " + iox);
            return;
         }

          int i = 0;
      while(lineItr.hasNext())  {
             i++;
             String as[] = lineItr.next().split(" ");
             System.out.println("Line " + i + ": " + Arrays.toString(as));
          }
   }
}
