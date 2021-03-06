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
package  com.github.xbn.testdev;
   import com.github.xbn.io.NewTextAppenterFor;
   import com.github.xbn.io.PlainTextFileUtil;
   import com.github.xbn.io.TextAppenter;
   import com.github.xbn.lang.CrashIfObject;
   import com.github.xbn.number.IntInRange;
   import com.github.xbn.number.NewIntInRangeFor;
   import com.github.xbn.regexutil.IgnoreCase;
   import com.github.xbn.util.EnumUtil;
   import com.github.xbn.util.GetBooleanFromString;
   import com.google.common.base.Joiner;
   import java.util.Arrays;
   import java.util.Iterator;
   import static com.github.xbn.lang.XbnConstants.LINE_SEP;
/**
   <p>Get an object at a specific index, from command line parameters.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class GetFromCommandLineAtIndex  {
   public static final TextAppenter debugConsoleAptrFromBoolean(String[] cmd_lineParams, int index, String true_value, String false_value, Appendable debugBoolean_ifNonNull)  {
      boolean b = bool(cmd_lineParams, index, true_value, false_value, debugBoolean_ifNonNull);
      return  (b ? TextAppenter.CONSOLE : TextAppenter.SUPPRESS);
   }
   /**
      <p>Get a line-iterator to a specific file, from a path provided on the command-line, at a specific index.</p>

    * @return  <code>{@link com.github.xbn.io.PlainTextFileUtil PlainTextFileUtil}.{@link com.github.xbn.io.PlainTextFileUtil#getLineIterator(String, String) getLineIterator}(
         <br/> &nbsp; &nbsp; text(cmd_lineParams, index, &quot;path&quot;), ...)</code>
    * @see  #fileTextAppended(StringBuilder, String[], int, Appendable)
    */
   public static final Iterator<String> fileLineIterator(String[] cmd_lineParams, int index, Appendable debugPath_ifNonNull)  {
      Iterator<String> itr = PlainTextFileUtil.getLineIterator(
         text(cmd_lineParams, index, "path", debugPath_ifNonNull), "cmd_lineParams[index]");

/*
      TextAppenter aptr = NewTextAppenterFor.appendableUnusableIfNull(debugPath_ifNonNull);
      if(aptr.isUseable())  {
         aptr.appentln(" -" + index + "- Line iterator retrieved: " + cmd_lineParams[index]);
      }
 */

      return  itr;
   }
   /**
      <p>Append all file text, from a path provided on the command-line, at a specific index.</p>

      <p>This<ol>
         <li>Calls {@link #fileLineIterator(String[], int, Appendable) fileLineIterator}{@code (cmd_lineParams, index, debugPath_ifNonNull)}</li>
         <li>Appends each line, plus a {@linkplain com.github.xbn.lang.XbnConstants#LINE_SEP line-separator} onto {@code to_appendTo}.</li>
      </ol></p>

    * @return  {@code to_appendTo}, with all lines from the file appended to it.
    * @see  #fileText(String[], int, Appendable)
    */
   public static final StringBuilder fileTextAppended(StringBuilder to_appendTo, String[] cmd_lineParams, int index, Appendable debugPath_ifNonNull)  {
      Iterator<String> lineItr = fileLineIterator(cmd_lineParams, index, debugPath_ifNonNull);
      while(lineItr.hasNext())  {
         to_appendTo.append(lineItr.next()).append(LINE_SEP);
      }
      return  to_appendTo;
   }
   /**
      <p>Get all file text in a string, from a path provided on the command-line, at a specific index.</p>

    * @return  <code>{@link #fileTextAppended(StringBuilder, String[], int, Appendable) fileTextAppended}((new StringBuilder()), cmd_lineParams, index, debugPath_ifNonNull).toString()</code>
    */
   public static final String fileText(String[] cmd_lineParams, int index, Appendable debugPath_ifNonNull)  {
      return  fileTextAppended((new StringBuilder()), cmd_lineParams, index, debugPath_ifNonNull).toString();
   }
   /**
      <p>Get a string from the command-line, at a specific index.</p>

    * @param  cmd_lineParams  The command-line parameters. May not be {@code null}, and must be a length of at least {@code (index + 1)}.
    * @param  index  The index in {@code cmd_lineParams} at which the path is expected.
    * @return  <code>cmd_lineParams[index]</code>
    * @exception  ArrayIndexOutOfBoundsException  If {@code cmd_lineParams[index]} does not exist.
    */
   public static final String text(String[] cmd_lineParams, int index, String description, Appendable debug_ifNonNull)  {
      String s = null;
      try  {
         s = cmd_lineParams[index];
      }  catch(ArrayIndexOutOfBoundsException ibx)  {
         throw  new ArrayIndexOutOfBoundsException("Missing required text (description: \"" + description + "\") in command line parameter, at index " + index + ". All parameters=" + Arrays.toString(cmd_lineParams));
      }

      TextAppenter aptr = NewTextAppenterFor.appendableUnusableIfNull(debug_ifNonNull);
      if(aptr.isUseable())  {
         aptr.appentln(" -" + index + "- " + description + ": " + s);
      }

      return  s;
   }
   /**
      <p>Get an integer from the command-line, at a specific index, and validate its numeric range.</p>

    * @return  <code>{@link #number(String[], int, IntInRange, String, Appendable) number}(cmd_lineParams, index, {@link com.github.xbn.number.NewIntInRangeFor NewIntInRangeFor}.{@link com.github.xbn.number.NewIntInRangeFor#UNRESTRICTED UNRESTRICTED}, description, debug_ifNonNull)</code>
    */
   public static final int number(String[] cmd_lineParams, int index, String description, Appendable debug_ifNonNull)  {
      return  number(cmd_lineParams, index, NewIntInRangeFor.UNRESTRICTED, description, debug_ifNonNull);
   }
   /**
      <p>Get an integer from the command-line, at a specific index, and validate its numeric range.</p>

    * @param  cmd_lineParams  The command-line parameters. May not be {@code null}, and must be a length of at least {@code (index + 1)}.
    * @param  index  The index in {@code cmd_lineParams} at which the path is expected.
    * @param  range  May not be {@code null}.
    * @return  <code>{@link java.lang.Integer Integer}.{@link java.lang.Integer#parseInt(String) parseInt}(cmd_lineParams[index])</code>
    * @exception  ArrayIndexOutOfBoundsException  If {@code cmd_lineParams[index]} does not exist
    * @exception  NumberFormatException  If the parameter is not an integer.
    * @exception  IllegalArgumentException  If the parameter is an integer, but out of range.
    * @see  #number(String[], int, String, Appendable)
    */
   public static final int number(String[] cmd_lineParams, int index, IntInRange range, String description, Appendable debug_ifNonNull)  {
      int num = -1;
      try  {
         num = Integer.parseInt(cmd_lineParams[index]);
      }  catch(ArrayIndexOutOfBoundsException ibx)  {
         throw  new ArrayIndexOutOfBoundsException("Missing required variable (description: \"" + description + "\") in command line parameter index " + index + ". All parameters=" + Arrays.toString(cmd_lineParams));
      }  catch(NumberFormatException nfx)  {
         throw  new NumberFormatException("cmd_lineParams[index] (\"" + cmd_lineParams[index] + "\") is not an integer. index=" + index + ")");
      }

      try  {
         range.crashIfBadIntElement(num, "cmd_lineParams", index);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }

      TextAppenter aptr = NewTextAppenterFor.appendableUnusableIfNull(debug_ifNonNull);
      if(aptr.isUseable())  {
         aptr.appentln(" -" + index + "- " + description + ": " + num);
      }

      return  num;
   }
   public static final boolean bool(String[] cmd_lineParams, int index, String true_value, String false_value, Appendable debug_ifNonNull)  {
      String description = "[true_value=" + true_value + ", false_value=" + false_value + "]";
      String s = text(cmd_lineParams, index, description, debug_ifNonNull);
      return  new GetBooleanFromString().trueFalse(true_value, false_value).get(s);
   }
   /**
      <p>Get an enum value from a string, with arbitrary string-values assigned to each enum-value.</p>

{@.codelet.and.out com.github.xbn.examples.util.GetFromExplicitStringValuesExample%eliminateCommentBlocksAndPackageDecl()}
    */
   public static final <T extends Enum<T>> T enumValue(String[] cmd_lineParams, int index, T enumInstance_anyNonNullValue, IgnoreCase ignore_case, Appendable debug_ifNonNull, String... one_perEnumValueInOrder)  {
      String description = "[" + enumInstance_anyNonNullValue.getClass().getName() + ":" +
         Joiner.on(", ").skipNulls().join(one_perEnumValueInOrder) + "]";
      String s = text(cmd_lineParams, index, description, debug_ifNonNull);
      return  EnumUtil.getFromExplicitStringValues(enumInstance_anyNonNullValue, s, description, ignore_case, one_perEnumValueInOrder);
   }
   private GetFromCommandLineAtIndex()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
