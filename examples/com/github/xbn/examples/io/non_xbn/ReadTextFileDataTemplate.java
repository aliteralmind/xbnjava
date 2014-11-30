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
   import java.io.File;
   import java.io.IOException;
   import java.util.Scanner;
/**
   <p>Fill in an array from the data in a text file, via {@code java.util.}{@link java.util.Scanner Scanner}.</p>

   <p>{@code java com.github.xbn.examples.io.non_xbn.ReadTextFileDataTemplate xbn\examples\io\non_xbn\Project1Input_baseball.txt}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
 public class ReadTextFileDataTemplate  {
    /**
    * @param args the command line arguments
    * @throws java.io.IOException
    */
   public static void main(String[] args) throws IOException {
       try  {
          fillArray(args[0]);
       }  catch(RuntimeException rx)  {
          if(args.length == 0)  {
             throw  new IllegalArgumentException("Missing one required parameter: Path to input file");
          }
       }  catch(IOException iox)  {
          throw  new RuntimeException(iox);
       }
   }

   public static void fillArray(String inputFile) throws IOException {
       Scanner teamList = new Scanner(new File(inputFile));
       String[] teamName = new String[35];
       int[] teamRank = new int[35];
       double[] teamWinPercentage = new double[35];
       int i = 0;
       while (teamList.hasNext()) {
           teamRank[i] = teamList.nextInt();
           teamName[i] = teamList.next();
           teamWinPercentage[i] = teamList.nextDouble();
           i++;
       }
   }

}
