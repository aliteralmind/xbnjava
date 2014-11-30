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
package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.Iterator;
   import  java.util.ArrayList;
   import  java.io.File;
   import  java.io.IOException;
   import  org.apache.commons.io.FileUtils;
/**
   <p>Read in a file, accepting all lines between two markers, ignoring the first line.</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.BetweenLineMarkersButSkipFirstXmpl xbnjava\xbn\examples\text\regex\BetweenLineMarkersButSkipFirstXmpl_data.txt}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
**/
public class BetweenLineMarkersButSkipFirstXmpl  {
   public static final void main(String[] as_1RqdTxtFilePath)  {
      Iterator<String> lineItr = null;
      try  {
         lineItr = FileUtils.lineIterator(new File(as_1RqdTxtFilePath[0])); //Throws npx if null
      }  catch(IOException iox)  {
         throw  new RuntimeException("Attempting to open \"" + as_1RqdTxtFilePath[0] + "\"", iox);
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("One required parameter: The path to the text file.", rx);
      }

      String LINE_SEP = System.getProperty("line.separator", "\n");

      ArrayList<String> alsItems = new ArrayList<String>();
      boolean bStartMark = false;
      boolean bLine1Skipped = false;
      StringBuilder sdCurrentItem = new StringBuilder();
      while(lineItr.hasNext())  {
         String sLine = lineItr.next().trim();
         if(!bStartMark)  {
            if(sLine.startsWith(".START_SEQUENCE"))  {
               bStartMark = true;
               continue;
            }
            throw  new IllegalStateException("Start mark not found.");
         }  if(!bLine1Skipped)  {
            bLine1Skipped = true;
            continue;
         }  else if(!sLine.equals(".END_SEQUENCE"))  {
            sdCurrentItem.append(sLine).append(LINE_SEP);
         }  else  {
            alsItems.add(sdCurrentItem.toString());
            sdCurrentItem.setLength(0);
            bStartMark = false;
            bLine1Skipped = false;
            continue;
         }
      }

      for(String s : alsItems)  {
         System.out.println("----------");
         System.out.print(s);
      }
   }
}
