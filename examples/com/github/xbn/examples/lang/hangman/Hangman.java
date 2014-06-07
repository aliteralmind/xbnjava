<P>User <A HREF="http://stackoverflow.com/users/256196/bohemian">Bohemian</A> on stackoverflow responded to the Hangman code in my <A HREF="http://aliteralmind.wordpress.com/2014/03/08/hangman/">previous post</A> with this comment:</P>

<P><I>Just FYI, you can do the whole thing in a just a few lines of code, and the main logic in two lines.</I></P>

<P>He wasn't joking. Here's <A HREF="http://stackoverflow.com/a/22269413/2736496">his take</A>:</P>

[code language="java"]import  java.util.Random;
import  java.util.Scanner;
/**
   <P>{@code java HangmanByBohemian}</P>
 **/
public class HangmanByBohemian  {
   static int MAX_MISSES = 5;
   static String[] WORDS = { "Q U I C K", "B R O W N", "J U M P S" }; // etc

   public static void main(String[] args) throws Exception {
       String word = WORDS[new Random().nextInt(WORDS.length)], guesses = " ";
       int misses = 0;
       for (Scanner in = new Scanner(System.in); !word.matches("[" + guesses + "]+") & (misses += word.contains(guesses.substring(0, 1)) ? 0 : 1) <= MAX_MISSES; guesses = in.nextLine().toUpperCase().charAt(0) + guesses)
           System.out.println(word.replaceAll("[^" + guesses + "]", "_"));
       System.out.println(word + (misses > MAX_MISSES ? " not" : "") + " solved with " + misses + " incorrect guesses");
   }
}[/code]

<P>That's 112 lines shorter. <I><B>(Post continues below output.)</B></I></P>

<H3>Success output <I>(condensed a bit)</I></H3>

<CODE>[C:\java_code\]java HangmanByBohemian
_ _ _ _ _ &nbsp; a
_ _ _ _ _ &nbsp; b
_ _ _ _ _ &nbsp; c
_ _ _ C _ &nbsp; d
_ _ _ C _ &nbsp; k
_ _ _ C K &nbsp; q
Q _ _ C K &nbsp; a
Q _ _ C K &nbsp; u
Q U _ C K &nbsp; i
Q U I C K solved with 4 incorrect guesses</CODE>

<H3>Failure output</H3>

<CODE>[C:\java_code\]java HangmanByBohemian
_ _ _ _ _ &nbsp; a
_ _ _ _ _ &nbsp; b
B _ _ _ _ &nbsp; c
B _ _ _ _ &nbsp; d
B _ _ _ _ &nbsp; e
B _ _ _ _ &nbsp; r
B R _ _ _ &nbsp; n
B R _ _ N &nbsp; x
B R _ _ N &nbsp; y
B R O W N not solved with 6 incorrect guesses</CODE>

<P>I've taken this dense-and-great answer, and made it my own. It's not better, I did this only for the sake of learning it. While this doesn't fulfill the specifications as <A HREF="http://stackoverflow.com/q/22263843/2736496">originally asked</A>, the specifications are very different than normal hangman (you have to explicitly specify indexes at which the guessed-letter applies to). This application is much closer to normal Hangman rules.</P>

<P>The major differences, as compared to Bohemian's, are:<UL>
   <LI>It's a <CODE>do-while</CODE>, instead of a <CODE>for</CODE> loop.</LI>
   <LI>It only keeps unique characters, and compares against a separate <CODE>currCharGuessAsStr</CODE>, instead of the first character in <CODE>allGuessCharsStr</CODE>.</LI>
   <LI>The array of secret words does not include spaces between each letter. Instead the <CODE>getMasked(s,s)</CODE> function adds spaces each time.</LI>
   <LI>It notifies the user of bad input (no characters) instead of crashing, and requires input to be a single letter.</LI>
   <LI>It displays state at each step.</LI>
</UL></P>

<H3>Pre loop</H3>

[code language="java"]public class Hangman  {
   static int MAX_BAD_GUESSES = 10;
   static String[] WORDS = { "QUICK", "BROWN", "JUMPS" }; // etc

   public static void main(String[] args) throws Exception {
      String word = WORDS[new Random().nextInt(WORDS.length)];
      Scanner in = new Scanner(System.in);
      int badGuessCount = 0;
      String guessInput = null;

      //This is keyed by a one-character STRING instead of an
      //actual character. This is to avoid translating it back
      //and forth between string and char.
      Map<String,Object> unqGuessedCharsAsStrMap = new TreeMap<String,Object>();

      //Must be initialized to the empty string. Initializing to null
      //Will result in the literal string "null" being added to it.
      String allGuessCharsStr = "";
      String currCharGuessAsStr = " ";[/code]

<H3>The loop</H3>

[code language="java"]      do  {

         System.out.print(getMasked(word, allGuessCharsStr) + " Guess a character [Bad guesses: " + badGuessCount + " of " + MAX_BAD_GUESSES + "]: ");

         guessInput = in.nextLine();

         if(guessInput != null)  {  //null on first iteration only
            if(!guessInput.matches("^[a-zA-Z]$"))  {
               System.out.println("Bad input. Must a single letter.");
               badGuessCount++;

            }  else  {
               //Definitely valid input, and exactly one character
               currCharGuessAsStr = guessInput.toUpperCase();

               if(unqGuessedCharsAsStrMap.containsKey(currCharGuessAsStr))  {
                  //Trim to eliminate initialization space
                  System.out.println("Already guessed that letter. All guesses: " + allGuessCharsStr.trim());

               }  else  {
                  unqGuessedCharsAsStrMap.put(currCharGuessAsStr, null);

                  //Prepend just-guessed character and sort it.
                  allGuessCharsStr += currCharGuessAsStr;
                  char[] allGuessedChars = allGuessCharsStr.toCharArray();
                  Arrays.sort(allGuessedChars);
                  allGuessCharsStr = new String(allGuessedChars);
               }

               if(!word.contains(currCharGuessAsStr))  {
                  badGuessCount++;
               }
            }
         }

      }  while(!word.matches("[" + allGuessCharsStr + "]+")  &&
                  badGuessCount <= MAX_BAD_GUESSES);[/code]

<H3>Post-loop, and <CODE>getMasked(s,s)</CODE> function</H3>


[code language="java"]      System.out.println(getMasked(word, allGuessCharsStr));

      System.out.println(word + (badGuessCount > MAX_BAD_GUESSES ? " not" : "") + " solved with " + badGuessCount + " incorrect guesses (max allowed=" + MAX_BAD_GUESSES + ").");
   }
   /**
      @param  all_guessesStrESIfNone  May not be null. If empty, no guesses have been made yet.
      @exception  PatternSyntaxException  If all_guessCharsStr is empty.
    **/
   private static final String getMasked(String secret_word, String all_guessesStrESIfNone)  {
      try  {
         if(all_guessesStrESIfNone.length() == 0)  {
            all_guessesStrESIfNone = " ";   //Any non-letter will suffice
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("all_guessesStrESIfNone");
      }

      //Mask all not-yet-guessed characters with an underscore.
      secret_word = secret_word.replaceAll("[^" + all_guessesStrESIfNone + "]", "_");

      //Insert a space between every character (trim eliminates the final).
      return  secret_word.replaceAll("(.)", "$1 ").trim();
   }
}[/code]

<H3>Solved output</H3>

<CODE>[R:\jeffy\programming\sandbox\xbnjava]java Hangman
_ _ _ _ _ Guess a character [Bad guesses: 0 of 10]: a
_ _ _ _ _ Guess a character [Bad guesses: 1 of 10]: b
_ _ _ _ _ Guess a character [Bad guesses: 2 of 10]: c
_ _ _ _ _ Guess a character [Bad guesses: 3 of 10]: d
_ _ _ _ _ Guess a character [Bad guesses: 4 of 10]: e
_ _ _ _ _ Guess a character [Bad guesses: 5 of 10]: f
_ _ _ _ _ Guess a character [Bad guesses: 6 of 10]: j
J _ _ _ _ Guess a character [Bad guesses: 6 of 10]: q
J _ _ _ _ Guess a character [Bad guesses: 7 of 10]: m
J _ M _ _ Guess a character [Bad guesses: 7 of 10]: p
J _ M P _ Guess a character [Bad guesses: 7 of 10]: u
J U M P _ Guess a character [Bad guesses: 7 of 10]: s
J U M P S
JUMPS solved with 7 incorrect guesses (max allowed=10).</CODE>

<H3>Unsolved output</H3>

<CODE>[R:\jeffy\programming\sandbox\xbnjava]java Hangman
_ _ _ _ _ Guess a character [Bad guesses: 0 of 10]: a
_ _ _ _ _ Guess a character [Bad guesses: 1 of 10]: b
_ _ _ _ _ Guess a character [Bad guesses: 2 of 10]: c
_ _ _ C _ Guess a character [Bad guesses: 2 of 10]: d
_ _ _ C _ Guess a character [Bad guesses: 3 of 10]: e
_ _ _ C _ Guess a character [Bad guesses: 4 of 10]: f
_ _ _ C _ Guess a character [Bad guesses: 5 of 10]: j
_ _ _ C _ Guess a character [Bad guesses: 6 of 10]: e
Already guessed that letter. All guesses: ABCDEFJ
_ _ _ C _ Guess a character [Bad guesses: 7 of 10]:
Bad input. Must a single letter.
_ _ _ C _ Guess a character [Bad guesses: 8 of 10]: tt
Bad input. Must a single letter.
_ _ _ C _ Guess a character [Bad guesses: 9 of 10]: q
Q _ _ C _ Guess a character [Bad guesses: 9 of 10]: k
Q _ _ C K Guess a character [Bad guesses: 9 of 10]: l
Q _ _ C K Guess a character [Bad guesses: 10 of 10]: z
Q _ _ C K
QUICK not solved with 11 incorrect guesses (max allowed=10).</CODE>

<H3>Full code</H3>

[code language="java"]   import  java.util.Arrays;
   import  java.util.Map;
   import  java.util.TreeMap;
   import  java.util.Random;
   import  java.util.Scanner;
/**
   <P>{@code java Hangman}</P>
 **/
public class Hangman  {
   static int MAX_BAD_GUESSES = 10;
   static String[] WORDS = { "QUICK", "BROWN", "JUMPS" }; // etc

   public static void main(String[] args) throws Exception {
      String word = WORDS[new Random().nextInt(WORDS.length)];
      Scanner in = new Scanner(System.in);
      int badGuessCount = 0;
      String guessInput = null;

      //This is keyed by a one-character STRING instead of an
      //actual character. This is to avoid translating it back
      //and forth between string and char.
      Map<String,Object> unqGuessedCharsAsStrMap = new TreeMap<String,Object>();

      //Must be initialized to the empty string. Initializing to null
      //Will result in the literal string "null" (those four characters,
      //sorted among all the guessed characters) being added to it.
      String allGuessCharsStr = "";
      String currCharGuessAsStr = " ";

      do  {

         System.out.print(getMasked(word, allGuessCharsStr) + " Guess a character [Bad guesses: " + badGuessCount + " of " + MAX_BAD_GUESSES + "]: ");

         guessInput = in.nextLine();

         if(guessInput != null)  {  //null on first iteration only
            if(!guessInput.matches("^[a-zA-Z]$"))  {
               System.out.println("Bad input. Must a single letter.");
               badGuessCount++;

            }  else  {
               //Definitely valid input, and exactly one character
               currCharGuessAsStr = guessInput.toUpperCase();

               if(unqGuessedCharsAsStrMap.containsKey(currCharGuessAsStr))  {
                  //Trim to eliminate initialization space
                  System.out.println("Already guessed that letter. All guesses: " + allGuessCharsStr.trim());

               }  else  {
                  unqGuessedCharsAsStrMap.put(currCharGuessAsStr, null);

                  //Prepend just-guessed character and sort it.
                  allGuessCharsStr += currCharGuessAsStr;
                  char[] allGuessedChars = allGuessCharsStr.toCharArray();
                  Arrays.sort(allGuessedChars);
                  allGuessCharsStr = new String(allGuessedChars);
               }

               if(!word.contains(currCharGuessAsStr))  {
                  badGuessCount++;
               }
            }
         }

      }  while(!word.matches("[" + allGuessCharsStr + "]+")  &&
                  badGuessCount <= MAX_BAD_GUESSES);

      System.out.println(getMasked(word, allGuessCharsStr));

      System.out.println(word + (badGuessCount > MAX_BAD_GUESSES ? " not" : "") + " solved with " + badGuessCount + " incorrect guesses (max allowed=" + MAX_BAD_GUESSES + ").");
   }

   /**
      @param  all_guessesStrESIfNone  May not be null. If empty, no guesses have been made yet.
      @exception  PatternSyntaxException  If all_guessCharsStr is empty.
    **/
   private static final String getMasked(String secret_word, String all_guessesStrESIfNone)  {
      try  {
         if(all_guessesStrESIfNone.length() == 0)  {
            all_guessesStrESIfNone = " ";   //Any non-letter will suffice
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("all_guessesStrESIfNone");
      }

      //Mask all not-yet-guessed characters with an underscore.
      secret_word = secret_word.replaceAll("[^" + all_guessesStrESIfNone + "]", "_");

      //Insert a space between every character (trim eliminates the final).
      return  secret_word.replaceAll("(.)", "$1 ").trim();
   }
}[/code]

