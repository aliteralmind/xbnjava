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
package  com.github.xbn.examples.analyze.validate;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.analyze.validate.FilterValidCounts;
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.number.NewLengthInRangeValidatorFor;
   import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
/**
   <P>Uses {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.ValidResultFilter ValidResultFilter} to print all words in a sentence that contain four or more characters, but filters those results so only the third-through-seventh are presented.</P>

   <P>{@code java com.github.xbn.examples.analyze.validate.ValidResultFilterXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValidResultFilterXmpl  {
   public static final void main(String[] ignored)  {
      String sSentence = "Hi Ho! Kermit The Frog here, with a Sesame Street News Flash. I am here with Pinnochio, reporting to you live from inside the belly of the whale.";

      System.out.println("Sentence: " + sSentence);

      //Words with 4-or-more chars
      LengthInRangeValidator unfilteredVltdr = NewLengthInRangeValidatorFor.min(
         Null.BAD, null, 4, null,
         null,    //Unfiltered
         null);   //Debug (on:System.out, off=null)

      printWordsW4OrMoreChars(unfilteredVltdr, sSentence);

      FilterValidCounts filterKeep3to7 = NewValidResultFilterFor.inUnchangedOutFalse(3, 7, null, null,
         null);   //Debug

      LengthInRangeValidator filteredVldtr = NewLengthInRangeValidatorFor.min(
         Null.BAD, null, 4, null, filterKeep3to7,
         null);   //Debug

      printWordsW4OrMoreChars(filteredVldtr, sSentence);
   }
   private static final void printWordsW4OrMoreChars(LengthInRangeValidator range_vldtr, String sentence)  {
      System.out.println("Print all words with 4+ characters.");
      System.out.println("Filter: " + range_vldtr.getFilter());

      String[] asWords = sentence.split(" ");

      for(int i = 0; i < asWords.length; i++)  {
         String sWord = asWords[i];
//System.out.println("\n\n\n" + i + " (sWord=\"" + sWord + "\".length()=" + sWord.length() + ")");
         range_vldtr.resetState();
         if(range_vldtr.isValid(sWord.length()))  {
            System.out.println("Word " + (i + 1) + " (" + sWord.length() + "): " + sWord);
         }
      }
      System.out.println();
   }
}
