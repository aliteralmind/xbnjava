package  com.github.xbn.test;
   import  com.github.xbn.testdev.DisplayOutputToConsole;
   import  com.github.xbn.testdev.VerifyApplicationOutput;
   import  org.junit.Test;
/**
   <P>{@code java com.github.xbn.test.ExampleCodeOutputsContain_Unit}</P>
 **/
public class ExampleCodeOutputsContain_Unit  {
   private static final String JAVA_SOURCE_INPUT_FILE =
      "examples\\com\\github\\xbn\\examples\\linefilter\\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt";
   private static final String[] JAVA_SOURCE_INPUT_FILE_PARAMS = new String[] {
      JAVA_SOURCE_INPUT_FILE};

   public static final void main(String[] ignored)  {
      ExampleCodeOutputsContain_Unit test = new ExampleCodeOutputsContain_Unit();

   	test.analyze_alter_ValueAltererXmpl();
   	test.analyze_validate_FirstCheckIsAlwaysValidThenExpireXmpl();
   	test.analyze_validate_ValidResultFilterXmpl();
   	test.analyze_validate_ValueValidatorXmpl();
   	test.array_BinarySearcherXmpl();
   	test.array_XbnIndexOutOfBoundsExceptionXmpl();
   	test.io_UnusableAppenterExample();
   	test.io_WriterForAppendableXmpl();
   	test.lang_builder_blind_BlindBuilderXmpl();
   	test.lang_builder_bloch_BlochBuilderXmpl();
   	test.lang_builder_finalv_UCBlindBuilderTest();
   	test.lang_reflect_InvokeMainWithRtxXmpl();
   	test.lang_reflect_InvokePrivateStaticMethodWithRtxXmpl();
   	test.linefilter_EliminateAllCommentBlocksAndPackageLine();
   	test.linefilter_GetAllClassSimpleNamesFromImports();
   	test.linefilter_IterateActiveLines();
   	test.linefilter_IterateKeptLines();
   	test.linefilter_IterateKeptLinesManualBlock();
   	test.linefilter_ModifyBlockLines();
   	test.linefilter_MoreComplicatedModifyExample();
   	test.linefilter_PrintAllJavaDocBlockStartAndEndLineNums();
   	test.linefilter_PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging();
   	test.linefilter_PrintJavaDocBlockSubLinesBolded();
   	test.neederneedable_NeedableNeederXmpl();
   	test.regexutil_RegexGroupExtractorXmpl();
   	test.regexutil_RegexReplacerDirectXmpl();
   	test.regexutil_RegexReplacerIndirectXmpl1of2();
   	test.regexutil_RegexReplacerIndirectXmpl2of2();
   	test.regexutil_RegexReplacerLiteralXmpl();
   	test.regexutil_RegexReplacerSpcfcTermsXmpl();
   	test.regexutil_RegexReplacerValidTermXmpl();
   	test.regexutil_RegexReplacerXmplsFromRewriter();
   	test.regexutil_RegexTokenizerXmpl();
   	test.testdev_TimeIteratorVsIndexIntegerList();
   	test.text_padchop_CharsBeforeChopXmpl();
   	test.text_padchop_ChopStringXmpl();
   	test.text_padchop_PadStringXmpl();
   	test.text_padchop_VzblPadChopXmpl();
   	test.util_JavaUtilInitializedValuesXmpl();
   	test.util_tuple_PotentialStringConcatWithThreeObjs();
   	test.util_tuple_PotentialStringConcatWithThreeObjs();
   	test.util_tuple_PotentialStringConcatWithThreeObjs();
//   	test.number_FractionXmpl();
//   	test.testdev_UnitTestAppOutputContainsXmpl();
   }
   @Test
   public void array_XbnIndexOutOfBoundsExceptionXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.array.XbnIndexOutOfBoundsExceptionXmpl.class,
         "xbn.array.XbnIndexOutOfBoundsException: [absolute-min]=0, sName.toString().length()=14, index=-2",
         "xbn.array.XbnIndexOutOfBoundsException: [absolute-min]=1, [the-primitive-array].length=4, extra-info=[Try better indexes next time, please.], getMinBound()=-1, getMaxBound()=2");
   }
   @Test
   public void neederneedable_NeedableNeederXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.neederneedable.NeedableNeederXmpl.class,
         "name=President Obama",
         "favorite number=55",
         "favorite number=56");
   }
   @Test
   public void io_UnusableAppenterExample()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.io.UnusableAppenterExample.class, "I'm worthy!");
   }
   @Test
   public void io_WriterForAppendableXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.io.WriterForAppendableXmpl.class, "hello");
   }
   @Test
   public void lang_builder_bloch_BlochBuilderXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.lang.builder.bloch.BlochBuilderXmpl.class,
         "name=Kermit, age=50, sFavColor=green");
   }
   @Test
   public void lang_builder_blind_BlindBuilderXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.lang.builder.blind.BlindBuilderXmpl.class,
         "name=Kermit", "age=50", "sFavColor=green");
   }
   @Test
   public void linefilter_ModifyBlockLines()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.ModifyBlockLines.class,
         "<B>mid1</B>", "<B>mid2</B>");
   }
   @Test
   public void linefilter_MoreComplicatedModifyExample()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.MoreComplicatedModifyExample.class,
         "midONE", "midTWO");
   }
   @Test
   public void linefilter_PrintAllJavaDocBlockStartAndEndLineNums()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNums.class,
         JAVA_SOURCE_INPUT_FILE_PARAMS,
         "9", "11", "13", "24", "28", "30");
   }
   @Test
   public void linefilter_PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging.class,
         JAVA_SOURCE_INPUT_FILE_PARAMS,
         "9", "11", "13", "24", "28", "30");
   }
   @Test
   public void linefilter_PrintJavaDocBlockSubLinesBolded()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:", "//sub-mode...START", "//sub-mode...END"},
         com.github.xbn.examples.linefilter.PrintJavaDocBlockSubLinesBolded.class,
         JAVA_SOURCE_INPUT_FILE_PARAMS,
         "<P>Another JavaDoc block</P>", "<B><P>info</P></B>", "<B></B>",
         "<B><P>info</P></B>", "<B></B>", "<B><P>info</P></B>", "<P>info</P>",
         "StayClassy()", "<P>Does stuff.</P>");
   }
   @Test
   public void linefilter_EliminateAllCommentBlocksAndPackageLine()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:", "package", "sub-mode", "<P>", "*"},
         com.github.xbn.examples.linefilter.EliminateAllCommentBlocksAndPackageLine.class,
         JAVA_SOURCE_INPUT_FILE_PARAMS,
         "class StayClassy", "StayClassy()", "doStuff()");
   }
   @Test
   public void linefilter_GetAllClassSimpleNamesFromImports()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.GetAllClassSimpleNamesFromImports.class,
         "List", "StringUtils", "Object", "XbnConstants");
   }
   @Test
   public void linefilter_IterateActiveLines()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.IterateActiveLines.class,
         "mid1", "mid2");
   }
   @Test
   public void linefilter_IterateKeptLines()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.IterateKeptLines.class,
         "mid1", "mid2");
   }
   @Test
   public void linefilter_IterateKeptLinesManualBlock()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.IterateKeptLinesManualBlock.class,
         "mid1", "mid2");
   }
   @Test
   public void analyze_alter_ValueAltererXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.analyze.alter.ValueAltererXmpl.class,
         "HELLO THERE.", "GOODBYE.");
   }
   @Test
   public void analyze_validate_ValidResultFilterXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.analyze.validate.ValidResultFilterXmpl.class,
         "range=[3,7]", "FilterCountType.VALID",
         "pre=PROCEED,post=FALSE", "in=[PROCEED,UNCHANGED]",
         "after=[RETURN_FALSE,FALSE]", "expirable but not-expired",
         "6 (5): here,",
         "7 (4): with",
         "9 (6): Sesame",
         "10 (6): Street",
         "11 (4): News");
   }
   @Test
   public void analyze_validate_ValueValidatorXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.analyze.validate.ValueValidatorXmpl.class,
         "Rules", "null bad",
         "null...", "Valid?", "No", "source=RULES", "java.lang.IllegalArgumentException",
         "3...", "Valid?", "Yes", "source=RULES", "valid",
         "10...", "Valid?", "Yes", "source=RULES", "valid",
         "Rules", "only null acceptable",
         "null...", "Valid?", "Yes", "source=RULES", "valid",
         "3...", "Valid?", "No", "source=RULES", "java.lang.IllegalArgumentException",
         "10...", "Valid?", "No", "source=RULES", "java.lang.IllegalArgumentException",
         "Rules", "null bad", "only legal value is 3",
         "null...", "Valid?", "No", "source=RULES", "java.lang.IllegalArgumentException",
         "3...", "Valid?", "Yes", "source=RULES", "valid",
         "10...", "Valid?", "No", "source=RULES", "java.lang.IllegalArgumentException");
   }
   @Test
   public void number_FractionXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.number.FractionXmpl.class,
         "Parse string 5/10: Reduced to 1/2",
         "Parse numerator 5, denominator 10: 1/2");
   }
   @Test
   public void array_BinarySearcherXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.array.BinarySearcherXmpl.class,
         "Searching for \"abc\"", "Found at index 0",
         "abcd", "INSERTED at index 1.",
         "ghi", "Found at index 2",
         "kl", "INSERTED at index 4.");
   }
   @Test
   public void analyze_validate_FirstCheckIsAlwaysValidThenExpireXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.analyze.validate.FirstCheckIsAlwaysValidThenExpireXmpl.class,
         "1 true", "2 false", "3 false", "8 false", "9 false", "10 false");
   }
   @Test
   public void lang_builder_finalv_UCBlindBuilderTest()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.lang.builder.finalv.UCBlindBuilderTest.class,
         "getName()=Kermit, getAge()=50, getFavoriteColor()=green");
   }
   @Test
   public void testdev_TimeIteratorVsIndexIntegerList()  {
      System.out.println("Testing com.github.xbn.examples.testdev.TimeIteratorVsIndexIntegerList...");
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.testdev.TimeIteratorVsIndexIntegerList.class,
         new String[]{"1000000"},
         "Test \"index\" took ", " nanoseconds",
         "Test \"iterator\" took ", " nanoseconds",
         "FASTER: Test", ", by ", " nanoseconds (", "%)");
   }
   @Test(expected=AssertionError.class)
   public void testdev_UnitTestAppOutputContainsXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.testdev.UnitTestAppOutputContainsXmpl.class,
         "Hello world", "Failure test");
   }
   @Test
   public void regexutil_RegexGroupExtractorXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexGroupExtractorXmpl.class,
         "public  |  SetGetInt  |  int i_i, boolean b_anotherParam", "void  |  set  |  int i_i", "int  |  get  |");
   }
   @Test
   public void regexutil_RegexReplacerDirectXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerDirectXmpl.class,
         "[one] two three four five");	}
   @Test
   public void regexutil_RegexReplacerIndirectXmpl1of2()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl1of2.class,
         "one [TWO] [THREE] four five");
   }
   @Test
   public void regexutil_RegexReplacerIndirectXmpl2of2()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl2of2.class,
         "xyz=VALUE_FOR_XYZ. abc=VALUE_FOR_ABC...");
   }
   @Test
   public void regexutil_RegexReplacerLiteralXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerLiteralXmpl.class,
         "one, two, three, four, five", "one, two three four five", "aaa AAA AAA aaa aaa");
   }
   @Test
   public void regexutil_RegexReplacerSpcfcTermsXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerSpcfcTermsXmpl.class,
         "[one] [two] [three] [four] [five]",
         "one [two] [three] four five",
         "[one] two three four five",
         "one two [three] four five",
         "[one two three four five]",
         "hello", "hello hello");

   }
   @Test
   public void regexutil_RegexReplacerValidTermXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerValidTermXmpl.class,
         "one [two] [three] four five");
   }
   @Test
   public void regexutil_RegexReplacerXmplsFromRewriter()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexReplacerXmplsFromRewriter.class,
         "a 43.18 cm display", "AB12 cd EFG34", "$50");
   }
   @Test
   public void regexutil_RegexTokenizerXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.regexutil.RegexTokenizerXmpl.class,
         "1,2", "3,4", "5,6", "(", "),(", "),(", ")");
   }
   @Test
   public void text_padchop_CharsBeforeChopXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.text.padchop.CharsBeforeChopXmpl.class,
         "Hi Ho...e Frog here!", "Hi Ho! Ke...og here!", "Hi Ho! Kermit The...");
   }
   @Test
   public void text_padchop_ChopStringXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.text.padchop.ChopStringXmpl.class,
         "Hi Ho! Kermit The...", "Hi Ho! Kermit The Fr...", "Hi Ho! Kermit The~~~");
   }
   @Test
   public void text_padchop_PadStringXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.text.padchop.PadStringXmpl.class,
         "[Hi Ho               ]", "[Hi Ho! Kermit The   ]",
         "[Hi Ho! Kermit The Frog here.]");
   }
   @Test
   public void text_padchop_VzblPadChopXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.text.padchop.VzblPadChopXmpl.class,
         "[               Hi Ho! Kermi...]", "[he Frog here.  ]");
   }
   @Test
   public void lang_reflect_InvokeMainWithRtxXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.lang.reflect.InvokeMainWithRtxXmpl.class,
         "Hello from main!");
   }
   @Test
   public void lang_reflect_InvokePrivateStaticMethodWithRtxXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.lang.reflect.InvokePrivateStaticMethodWithRtxXmpl.class,
         "HEY!");
   }
   @Test
   public void util_JavaUtilInitializedValuesXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.JavaUtilInitializedValuesXmpl.class,
         "boolean", "\"false\"", "char",                               //"\" \"",   //<--Why isn't this found?
         "byte", "\"0\"", "short", "\"0\"",
         "int", "\"0\"", "long", "\"0\"",
         "float", "\"0.0\"", "double", "\"0.0\"",
         "java.lang.AnythingAndEverythingElse", "\"null\"");
   }
   @Test(expected=IllegalStateException.class)
   public void util_tuple_PotentialStringConcatWithThreeObjs()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.tuple.PotentialStringConcatWithThreeObjs.class,
         "");
   }
}
