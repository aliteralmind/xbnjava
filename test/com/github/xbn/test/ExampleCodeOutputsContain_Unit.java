package  com.github.xbn.test;
   import  com.github.xbn.testdev.DisplayOutputToConsole;
   import  com.github.xbn.testdev.VerifyApplicationOutput;
   import  org.junit.Test;
/**
   <p>{@code java com.github.xbn.test.ExampleCodeOutputsContain_Unit}</p>
 **/
public class ExampleCodeOutputsContain_Unit  {
   private static final String EXAMPLE_CODE_ROOT_DIR =
      "examples\\com\\github\\xbn\\examples\\";

   public static final void main(String[] ignored)  {
      ExampleCodeOutputsContain_Unit unit = new ExampleCodeOutputsContain_Unit();

      unit.linefilter_ExtractReferenceTypeBlocks();
      unit.linefilter_ExtractReferenceTypeBlocksWithChildRoot();
      unit.linefilter_ExtractReferenceTypeBlocksWithChildStealth();
   	unit.analyze_alter_ValueAltererXmpl();
   	unit.analyze_validate_FirstCheckIsAlwaysValidThenExpireXmpl();
   	unit.analyze_validate_ValidResultFilterXmpl();
   	unit.analyze_validate_ValueValidatorXmpl();
   	unit.array_BinarySearcherXmpl();
   	unit.array_XbnIndexOutOfBoundsExceptionXmpl();
   	unit.io_TextAppenterObjectDebugging();
   	unit.io_TextAppenterWithLevelsAppExample_off();
   	unit.io_UnusableAppenterExample();
   	unit.io_WriterForAppendableXmpl();
   	unit.lang_builder_blind_BlindBuilderXmpl();
   	unit.lang_builder_bloch_BlochBuilderXmpl();
   	unit.lang_builder_finalv_UCBlindBuilderTest();
   	unit.lang_reflect_InvokeMainWithRtxXmpl();
   	unit.lang_reflect_InvokePrivateStaticMethodWithRtxXmpl();
   	unit.linefilter_EliminateAllCommentBlocksAndPackageLine();
   	unit.linefilter_ExtractAllJavaDocBlockTextRaw();
   	unit.linefilter_ExtractAllJavaDocBlockTextStripLineAsterisks();
   	unit.linefilter_GetAllClassSimpleNamesFromImports();
   	unit.linefilter_IterateActiveLines();
   	unit.linefilter_IterateKeptLines();
   	unit.linefilter_IterateKeptLinesManualBlock();
   	unit.linefilter_ModifyBlockLines();
   	unit.linefilter_MoreComplicatedModifyExample();
   	unit.linefilter_PrintAllJavaDocBlockStartAndEndLineNums();
   	unit.linefilter_PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging();
   	unit.linefilter_PrintJavaDocBlockSubLinesBolded();
   	unit.linefilter_StringReplacerXmpl();
   	unit.linefilter_StringValidatorReplacerXmpl();
   	unit.linefilter_alter_ExpirableAlterListXmpl();
   	unit.neederneedable_NeedableNeederXmpl();
   	unit.regexutil_RegexGroupExtractorXmpl();
   	unit.regexutil_RegexReplacerDirectXmpl();
   	unit.regexutil_RegexReplacerIndirectXmpl1of2();
   	unit.regexutil_RegexReplacerIndirectXmpl2of2();
   	unit.regexutil_RegexReplacerLiteralXmpl();
   	unit.regexutil_RegexReplacerSpcfcTermsXmpl();
   	unit.regexutil_RegexReplacerValidTermXmpl();
   	unit.regexutil_RegexReplacerXmplsFromRewriter();
   	unit.regexutil_RegexTokenizerXmpl();
   	unit.testdev_TimeIteratorVsIndexIntegerList();
   	unit.text_padchop_CharsBeforeChopXmpl();
   	unit.text_padchop_ChopStringXmpl();
   	unit.text_padchop_PadStringXmpl();
   	unit.text_padchop_VzblPadChopXmpl();
   	unit.util_JavaUtilInitializedValuesXmpl();
   	unit.util_tuple_PotentialStringConcatWithThreeObjs();
      unit.util_matrix_GetRowItemIdxRangeForNeighborCountXmpl();
      unit.util_matrix_BoundedMatrixXmpl();
      unit.util_matrix_DistanceDirectionXmpl();
//   	unit.io_TextAppenterWithLevelsAppExample_minimal();
//   	unit.io_TextAppenterWithLevelsAppExample_verbose();
//   	unit.number_FractionXmpl();
//   	unit.testdev_UnitTestAppOutputContainsXmpl();
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
   public void io_TextAppenterObjectDebugging()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.io.TextAppenterObjectDebugging.class, "complicated");
   }
   @Test
   public void io_TextAppenterWithLevelsAppExample_off()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"information"},
         com.github.xbn.examples.io.TextAppenterWithLevelsAppExample.class,
         new String[] {"debugoff"});
   }
/*
   @Test
   public void io_TextAppenterWithLevelsAppExample_minimal()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"Very"},
         com.github.xbn.examples.io.TextAppenterWithLevelsAppExample.class,
         new String[] {"debugminimal"},
         "information");
   }
   @Test
   public void io_TextAppenterWithLevelsAppExample_verbose()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.io.TextAppenterWithLevelsAppExample.class,
         new String[] {"debugverbose"},
         "information", "Very");
   }
   @Test
   public void number_FractionXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.number.FractionXmpl.class,
         "Parse string 5/10: Reduced to 1/2",
         "Parse numerator 5, denominator 10: 1/2");
   }
   @Test(expected=AssertionError.class)
   public void testdev_UnitTestAppOutputContainsXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.testdev.UnitTestAppOutputContainsXmpl.class,
         "Hello world", "Failure test");
   }
 */

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
         "<b>mid1</b>", "<b>mid2</b>");
   }
   @Test
   public void linefilter_MoreComplicatedModifyExample()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.MoreComplicatedModifyExample.class,
         "midONE", "midTWO");
   }
      private static final String JAVA_CLASS_INPUT_PREFIX =
         EXAMPLE_CODE_ROOT_DIR + "linefilter\\JavaClassWithOneCommentAndTwoJavaDocBlocks";
      private static final String[] JAVA_CLASS_INPUT_FILE = new String[] {
         JAVA_CLASS_INPUT_PREFIX + "_input.txt"};
   @Test
   public void linefilter_PrintAllJavaDocBlockStartAndEndLineNums()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNums.class,
         JAVA_CLASS_INPUT_FILE,
         "9", "11", "13", "15", "19", "25");
   }
   @Test
   public void linefilter_PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging.class,
         JAVA_CLASS_INPUT_FILE,
         "9", "11", "13", "15", "19", "25");
   }
   @Test
   public void linefilter_PrintJavaDocBlockSubLinesBolded()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.PrintJavaDocBlockSubLinesBolded.class,
         new String[] {JAVA_CLASS_INPUT_PREFIX + "WithSub_input.txt"},
         "//sub-mode...START", "//sub-mode...END",
         "<p>Another JavaDoc block</p>", "<b><p>info</p></b>", "<b></b>",
         "<b><p>info</p></b>", "<b></b>", "<b><p>info</p></b>", "<p>info</p>",
         "StayClassy()", "<p>Does stuff.</p>");
   }
   @Test
   public void linefilter_EliminateAllCommentBlocksAndPackageLine()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:", "package", "sub-mode", "<p>", "*"+"/"},
         com.github.xbn.examples.linefilter.EliminateAllCommentBlocksAndPackageLine.class,
         JAVA_CLASS_INPUT_FILE,
         "class StayClassy", "StayClassy()", "doStuff()");
   }
   @Test
   public void linefilter_ExtractAllJavaDocBlockTextStripLineAsterisks()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.ExtractAllJavaDocBlockTextStripLineAsterisks.class,
         JAVA_CLASS_INPUT_FILE,
         "<p>The main", "<p>Constructor", "<p>Function", "<p>This function", "<p>Lots and");
   }
   @Test
   public void linefilter_ExtractAllJavaDocBlockTextRaw()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO,
         new String[] {"path:"},
         com.github.xbn.examples.linefilter.ExtractAllJavaDocBlockTextRaw.class,
         JAVA_CLASS_INPUT_FILE,
         "<p>The main", "<p>Constructor", "* <p>Function", "* <p>This function", "* <p>Lots and");
   }
      private static final String[] REF_BLOCK_INPUT_FILE = new String[] {
         EXAMPLE_CODE_ROOT_DIR + "linefilter\\reference_type_through_attachment_blocks_input.txt"};
   @Test
   public void linefilter_ExtractReferenceTypeBlocksWithChildRoot()  {
      linefilter_ExtractReferenceTypeBlocks_STAR(DisplayOutputToConsole.NO, com.github.xbn.examples.linefilter.ExtractReferenceTypeBlocksWithChildRoot.class);
   }
   @Test
   public void linefilter_ExtractReferenceTypeBlocksWithChildStealth()  {
      linefilter_ExtractReferenceTypeBlocks_STAR(DisplayOutputToConsole.NO, com.github.xbn.examples.linefilter.ExtractReferenceTypeBlocksWithChildRoot.class);
   }
   @Test
   public void linefilter_ExtractReferenceTypeBlocks()  {
      linefilter_ExtractReferenceTypeBlocks_STAR(DisplayOutputToConsole.NO, com.github.xbn.examples.linefilter.ExtractReferenceTypeBlocksWithChildRoot.class);
   }
      private void linefilter_ExtractReferenceTypeBlocks_STAR(DisplayOutputToConsole display_out, Class<?> example_class)  {
         VerifyApplicationOutput.assertWithParameters(display_out, null,
            example_class,
            REF_BLOCK_INPUT_FILE,
            "--BLOCK FOUND:", "Type:  Journal", "-pdf://0633242026/Acou",
            "--BLOCK FOUND:", "Type:  Thesis", "-pdf://2172014641/Dayl",
            "--BLOCK FOUND:", "Type:  Something", "-pdf://48327407/xyz.pdf");
      }
   @Test
   public void linefilter_GetAllClassSimpleNamesFromImports()  {
      VerifyApplicationOutput.assertWithParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.GetAllClassSimpleNamesFromImports.class,
         JAVA_CLASS_INPUT_FILE,
         "Object", "List", "StringUtils", "XbnConstants");
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
   public void linefilter_StringValidatorReplacerXmpl()  {
      String sT = "Kermit T. Frog";
      String sThe = "Kermit The Frog";
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, new String[]{"()="},
         com.github.xbn.examples.linefilter.StringValidatorReplacerXmpl.class,
         sT, sThe, sThe, sThe, sT, sT, sT, sT, sT, sT);
   }
   @Test
   public void linefilter_StringReplacerXmpl()  {
      String sT = "Kermit T. Frog";
      String sThe = "Kermit The Frog";
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, new String[]{"()="},
         com.github.xbn.examples.linefilter.StringReplacerXmpl.class,
         sT, sThe, sThe, sThe, sT, sT, sT, sT, sT, sT);
   }
   @Test
   public void linefilter_alter_ExpirableAlterListXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.linefilter.alter.ExpirableTextLineAlterListXmpl.class,
         "1st and 2nd \"Apple\"", "2nd-through-4th \"T.\"", "2nd \"Green\"",
         "1 Johnny Pearseed  (Alters=3)", "3 Kermit The Frog  (Alters=3)",
         "6 Kermit The Frog  (Alters=2)", "9 Johnny Appleseed  (Alters=0, expired)",
         "13 The Green Giant  (Alters=0, expired)");
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
   @Test
   public void util_tuple_PotentialStringConcatWithThreeObjs()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.tuple.PotentialStringConcatWithThreeObjs.class,
         "A good", "B bad");
   }
   @Test
   public void util_matrix_GetRowItemIdxRangeForNeighborCountXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.matrix.GetRowItemIdxRangeForNeighborCountXmpl.class,
         "[0,20)", "null", "[0,20)", "[0,17)");
   }
   @Test
   public void util_matrix_BoundedMatrixXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.matrix.BoundedMatrixXmpl.class,
         "3", "5",
         "6", "8",
         "7", "8",
         "up", "7", "down", "12", "down-left", "8");
   }
   @Test
   public void util_matrix_DistanceDirectionXmpl()  {
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null,
         com.github.xbn.examples.util.matrix.DistanceDirectionXmpl.class,
         "DOWN_RIGHT", "5", "5",
         "UP_LEFT", "-5", "-5",
         "null", "4", "2");
   }
}
