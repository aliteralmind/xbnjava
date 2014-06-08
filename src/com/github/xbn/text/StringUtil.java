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
package  com.github.xbn.text;
   import  com.github.xbn.array.Duplicates;
   import  com.github.xbn.regexutil.IgnoreCase;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.io.BufferedReader;
   import  java.io.ByteArrayInputStream;
   import  java.io.IOException;
   import  java.io.InputStreamReader;
   import  java.util.Iterator;
   import  java.util.NoSuchElementException;
   import  org.apache.commons.io.LineIterator;
/**
   <P>Duplicate a str_obj, append a str_obj if a condition is met, get a &quot;visible index mask&quot;, and other str_obj-related utilities.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class StringUtil extends StringUtilBase  {
   private StringUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>An iterator for the characters in a str_obj.</P>
    **/
   public static final Iterator<Character> getCharIterator(Object str_toPad)  {
      return  (new CharIteratorForQ(str_toPad));
   }
   /**
      <P>Get one str_obj if a condition is met, another if it's not.</P>

      @return  <CODE>{@link #appendIfTrueFalse(Appendable, Object, boolean, Object) appendIfTrueFalse}((new StringBuilder()), true_oString, condition, oString_ifFalse).toString()</CODE>
    **/
   public static final String getIfTrueFalse(Object true_oString, boolean condition, Object oString_ifFalse)  {
      return  appendIfTrueFalse((new StringBuilder()), true_oString, condition, oString_ifFalse).toString();
   }
   /**
      <P><I>[main]</I> -- Get one str_obj if a condition is met, another if it's not.</P>

      @param  to_appendTo  May not be {@code null}.
      @param  true_oString  Returned if {@code condition} is {@code true}.
      @param  oString_ifFalse  Returned if {@code condition} is {@code false}.
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
      @see  #getIfTrueFalse(Object, boolean, Object) getIfTrueFalse(O,b,O)
    **/
   public static final Appendable appendIfTrueFalse(Appendable to_appendTo, Object true_oString, boolean condition, Object oString_ifFalse)  {
      try  {
         if(condition)  {
            if(true_oString != null)  {
               to_appendTo.append(true_oString.toString());
            }
         }  else if(oString_ifFalse != null)  {
            to_appendTo.append(oString_ifFalse.toString());
         }
      }  catch(IOException iox)  {
         throw  new RTIOException("appendIfTrueFalse", iox);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
   /**
      <P>Get one str_obj (with a prefix and postfix) if a condition is met, or another if it's not.</P>

      @return  <CODE>{@link #appendPreTruePostOrFalse(Appendable, String, Object, String, boolean, Object) appendPreTruePostOrFalse}((new StringBuilder()), prefix_ifTrue, true_oString, postfix_ifTrue, condition, oString_ifFalse).toString()</CODE>
    **/
   public static final String getPreTruePostOrFalse(String prefix_ifTrue, Object true_oString, String postfix_ifTrue, boolean condition, Object oString_ifFalse)  {
      return  appendPreTruePostOrFalse((new StringBuilder()), prefix_ifTrue, true_oString, postfix_ifTrue, condition, oString_ifFalse).toString();
   }
   /**
      <P><I>[main]</I> -- Append one str_obj (with a prefix and postfix) if a condition is met, or another if it's not.</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public static final Appendable appendPreTruePostOrFalse(Appendable to_appendTo, String prefix_ifTrue, Object true_oString, String postfix_ifTrue, boolean condition, Object oString_ifFalse)  {
      try  {
         if(condition)  {
            if(prefix_ifTrue != null)  {
               to_appendTo.append(prefix_ifTrue);
            }
            if(true_oString != null)  {
               to_appendTo.append(true_oString.toString());
            }
            if(postfix_ifTrue != null)  {
               to_appendTo.append(postfix_ifTrue);
            }
         }  else if(oString_ifFalse != null)  {
            to_appendTo.append(oString_ifFalse.toString());
         }
      }  catch(IOException iox)  {
         throw  new RTIOException("appendPreTruePostOrFalse", iox);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
   /**
      <P>Eliminate whitespace from the left side of a str_obj.</P>

      <P>The idea for this and {@code rtrim(str_toPad)} is from
      <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/15567010/what-is-a-good-alternative-of-ltrim-and-rtrim-in-java">http://stackoverflow.com/questions/15567010/what-is-a-good-alternative-of-ltrim-and-rtrim-in-java</A></CODE>
      <BR>and
      <BR> &nbsp; &nbsp; <CODE><A HREF="http://www.fromdev.com/2009/07/playing-with-java-str_obj-trim-basics.html">http://www.fromdev.com/2009/07/playing-with-java-str_obj-trim-basics.html</A></CODE>
      <BR>(viewed 11/18/2013)</P>

      @param  str_toPad  May not be {@code null}.
      @see  #rtrim(Object) rtrim(o)
    **/
   public static String ltrim(Object str_toPad) {
      String s = null;
      try  {
         s = str_toPad.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(str_toPad, "str_toPad", null, rx);
      }
      int i = 0;
      while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
         i++;
      }
      return s.substring(i);
   }
   /**
      <P>Eliminate whitespace from the right side of a str_obj.</P>

      @param  str_toPad  May not be {@code null}.
      @see  #ltrim(Object) ltrim(o)
    **/
   public static String rtrim(Object str_toPad) {
      String s = null;
      try  {
         s = str_toPad.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(str_toPad, "str_toPad", null, rx);
      }
      int i = s.length()-1;
      while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
         i--;
      }
      return s.substring(0, (i + 1));
   }
   /**
      <P>Creates a string where every element is the same character.</P>

      @param  length  The length of the returned string.
      @param  char_toDup  The character to duplicate.
      @param  length_varName  Descriptive name of {@code length}. <I>Should</I> not be {@code null} or empty.
      @return  <CODE>new String(new char[length]).java.lang.String#replace(CharSequence, CharSequence)(&quot;\0&quot;, (new Character(char_toDup)).toString())</CODE>
      @see  <CODE><A HREF="http://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java/4903603#4903603">http://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java/4903603#4903603</A></CODE>
      @exception  NegativeArraySizeException  If {@code length} is less than zero.
    **/
   public static final String getStringOfLengthAllCharsEqualTo(int length, char char_toDup, String length_varName)  {
      try  {
         return  new String(new char[length]).replace("\0", (new Character(char_toDup)).toString());
      }  catch(NegativeArraySizeException nasx)  {
         throw  new NegativeArraySizeException(length_varName + "=" + length);
      }
   }
   /**
      <P>For visibly indicating the index or index-range of a str_obj on the immediately-above line.</P>

{@.codelet.and.out com.github.xbn.examples.text.VisibleIndexMaskXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

      @param  str_toPadForLen  The str_obj to mask.
      @param  idx_start  The mask-start index. <I>Should</I> be between 0 and
      <BR> &nbsp; &nbsp; {@code (str_toPadForLen.toString().length() - 1)}
      @param  idx_endX  The mask-end index. <I>Should</I> be between {@code (idx_start + 1)} and
      <BR> &nbsp; &nbsp; {@code str_toPadForLen.toString().length()}.
    **/
   public static final String getVisibleIndexMask(Object str_toPadForLen, int idx_start, int idx_endX)  {
      StringBuilder sd = new StringBuilder(getDuped(" ", idx_start));
      if(idx_start == idx_endX)  {
         sd.append("^");
      }  else  {
         sd.append("|").
            append(getDuped("-", (idx_endX - idx_start - 1))).
            append("|");
      }
      try  {
         sd.append(getDuped(" ", (str_toPadForLen.toString().length() - idx_endX)));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(str_toPadForLen, "str_toPadForLen", null, rx);
      }

      return  sd.toString();
   }
   /**
      <P>Get a str_obj, duplicated.</P>

      @param  str_toDup  The str_obj to duplicate. May not be {@code null} or empty.
      @param  dup_count  The number of times to duplicate {@code str_toDup}. May not be less than zero. If zero, an empty str_obj is returned.
      @return  <CODE>{@link #appendDuped(Appendable, Object, int) appendDuped}((new StringBuilder()), str_toDup, dup_count).toString()</CODE>
    **/
   public static final String getDuped(Object str_toDup, int dup_count)  {
      return  appendDuped((new StringBuilder()), str_toDup, dup_count).toString();
   }
   /**
      <P><I>[main]</I> -- Append a str_obj, duplicated.</P>

      @param  to_appendTo  May not be {@code null}.
      @param  str_toDup  Descriptive name of {@code to_appendTo}. <I>Should</I> not be {@code null} or empty.
      @param  dup_count  <I>Should</I> be greater than zero.
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown.
      @see  #getDuped(Object, int) getDuped(O,i)
    **/
   public static final Appendable appendDuped(Appendable to_appendTo, Object str_toDup, int dup_count)  {
      try  {
         CrashIfString.nullEmpty(str_toDup, "str_toDup", null);
         String s = str_toDup.toString();
         for(int i = 0; i < dup_count; i++)  {
            to_appendTo.append(s);
         }
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
   public static final Iterator<String> getLineIterator(Object string_obj)  {
      BufferedReader br = null;
      try  {
         br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(string_obj.toString().getBytes())));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(string_obj, "string_obj", null, rx);
      }
      return  new LineIterator(br);
   }
/*
   public static final boolean isEqualToExactlyOneElement(String to_test, String[] all_possibleValues, IgnoreCase ignore_case)  {
      try  {
         to_test = ignore_case.toUpperCaseIfYes(to_test, "to_test");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(ignore_case, "ignore_case", null, rx);
      }
      int i = 0;
      try  {
         for(; i < all_possibleValues.length; i++)  {
            if(ignore_case.toUpperCaseIfYes(all_possibleValues[i], null).equals(to_test))  {
               return  true;
            }
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(all_possibleValues, "all_possibleValues", null);
         throw  CrashIfObject.nullOrReturnCause(all_possibleValues[i], "all_possibleValues[" + i + "]", null, rx);
      }
      return  false;
   }
 */
}
class CharIteratorForQ implements Iterator<Character>  {
   private CharSequence q = null;
   private int ix = -1;
//constructors...START
   public CharIteratorForQ(Object str_toPad)  {
      this((String)str_toPad);
   }
   public CharIteratorForQ(CharSequence cs)  {
      if(cs == null)  {
         throw  new NullPointerException("cs");
      }
      q = cs;
      ix = 0;
   }
//constructors...END
   public boolean hasNext()  {
      return  (ix < q.length());
   }
   public Character next() {
      if (!hasNext())  {
          throw  new NoSuchElementException("The length of the str_obj is " + q.length() + ". The str_obj: \"" + q + "\"");
      }
      return  q.charAt(ix++);
   }
   /**
      <P><I>Do not use.</I></P>

      @exception  UnsupportedOperationException
    **/
   public void remove() {
      throw  new UnsupportedOperationException("remove()");
   }
}
