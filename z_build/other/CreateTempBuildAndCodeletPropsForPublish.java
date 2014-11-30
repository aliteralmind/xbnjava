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
package  xbnjavabuild;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.analyze.alter.ExpirableElements;
   import  com.github.xbn.analyze.alter.MultiAlterType;
   import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.io.DebugLevel;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.linefilter.alter.ExpirableTextLineAlterList;
   import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
   import  com.github.xbn.linefilter.alter.TextLineAlterer;
   import  com.github.xbn.regexutil.IgnoreCase;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  com.github.xbn.testdev.DuplicateTextFileWithAlterations;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  com.github.xbn.testdev.Overwrite;
   import  java.io.PrintWriter;
   import  java.util.ArrayList;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.regex.Pattern;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>{@code java xbnjavabuild.CreateTempBuildAndCodeletPropsForPublish C:\java_code\project_sandbox_dir\ ${codelet.config.dir}\ xbnjava debugminimal}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CreateTempBuildAndCodeletPropsForPublish  {
   public static final void main(String[] parameters)  {

      DebugLevel dbgLvl = GetFromCommandLineAtIndex.
         enumValue(parameters, 3, DebugLevel.OFF, IgnoreCase.YES, null,
            "debugoff", "debugminimal", "debugverbose", null, null, null);

      TextAppenter dbgAptrMin = (dbgLvl.isOff()
         ?  TextAppenter.SUPPRESS
         :  TextAppenter.CONSOLE);
      TextAppenter dbgAptrVerbose = (dbgLvl.isOnAndAtLeast(2)
         ?  TextAppenter.CONSOLE
         :  TextAppenter.SUPPRESS);

      dbgAptrMin.appentln("xbnjavabuild.CreateTempBuildAndCodeletPropsForPublish");
      String mustEndWithFS = " (must end with \"" + FILE_SEP + "\")";
      String codeletSandboxDir = GetFromCommandLineAtIndex.text(parameters, 0,
         "Codelet base directory" + mustEndWithFS, dbgAptrMin.getAppendable());
      String codeletPropsSubDir = GetFromCommandLineAtIndex.text(parameters, 1,
         "codelet.properties sub-dir" + mustEndWithFS, dbgAptrMin.getAppendable());

      boolean isSubProject = GetFromCommandLineAtIndex.
         bool(parameters, 2, "subproject", "xbnjava",
         dbgAptrMin.getAppendable());
      dbgAptrMin.appentln(parameters[3] + " --> DebugLevel."+ dbgLvl);

      List<TextLineAlterer> alterList = new ArrayList<TextLineAlterer>(2);
      TextLineAlterer alterer = newRplcForDefaultPostEqualsValue("base.dir",
         "__INSTALLATION_DIRECTORY_HERE__", dbgAptrVerbose);
      alterList.add(alterer);

      if(isSubProject)  {
         alterer = NewTextLineAltererFor.
            replacement(AlterationRequired.YES,
               Pattern.compile(
                  "^([ \\t]+)(\\Qdo.auto.copy.\\E(xbn|codelet)\\.jar(?:s?)\\Q=VALUE_DOESNT_MATTER_JUST_THAT_THE_VARIABLE_EXISTS\\E)$"),
               "$1#$2", ReplacedInEachInput.FIRST, dbgAptrVerbose.getAppendable(),
               NewValidResultFilterFor.exactlyOne(dbgAptrVerbose.getAppendable()));
         alterList.add(alterer);
      }

      alterer = NewTextLineAltererFor.
         replacement(AlterationRequired.NO,
            Pattern.compile(
               "^([ \\t]+)#(\\Qcompile.as.a.whole=VALUE_DOESNT_MATTER_JUST_THAT_THE_VARIABLE_EXISTS\\E)$"),
            "$1$2", ReplacedInEachInput.FIRST, dbgAptrVerbose.getAppendable(),
            NewValidResultFilterFor.exactlyOne(dbgAptrVerbose.getAppendable()));
      alterList.add(alterer);

      ExpirableTextLineAlterList allAlterer = new ExpirableTextLineAlterList(
         alterList.toArray(new TextLineAlterer[alterList.size()]),
         ExpirableElements.REQUIRED, MultiAlterType.SHORT_CIRCUIT,
         dbgAptrMin.getAppendable());

      String input = codeletSandboxDir + "build.properties";
      String output = codeletSandboxDir + "placeholder__build.properties";
      DuplicateTextFileWithAlterations.go(input, output, Overwrite.BAD, allAlterer, dbgAptrMin.getAppendable());
      allAlterer.crashIfIncomplete("[build.properties --> placeholder__build.properties]");

      //--------------------------------

      TextLineAlterer[] alterers = {
         newRplcForDefaultPostEqualsValue("base_dir_base_dir",
            "__DIRECTORY_HERE__", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("list_type__black_white_off",
            "off", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("list_case__ignore_require_system",
            "require", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("comma_delimited_override_list",
            "", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("global_debugging__off_12345",
            "off", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("debug_to__console_path",
            "console", dbgAptrVerbose),
         newRplcForDefaultPostEqualsValue("pkglist_offline_name_postfix",
            ".txt", dbgAptrVerbose)};

      allAlterer = new ExpirableTextLineAlterList(
         alterers, ExpirableElements.REQUIRED, MultiAlterType.SHORT_CIRCUIT,
         dbgAptrMin.getAppendable());

      input = codeletSandboxDir + codeletPropsSubDir + "codelet.properties";
      output = codeletSandboxDir + codeletPropsSubDir + "placeholder__codelet.properties";
      DuplicateTextFileWithAlterations.go(input, output, Overwrite.BAD, allAlterer, dbgAptrMin.getAppendable());

      allAlterer.crashIfIncomplete("[codelet.properties --> placeholder__codelet.properties]");
   }
   private static final TextLineAlterer newRplcForDefaultPostEqualsValue(String var_name, String default_value, TextAppenter debug_aptr)  {
      return  NewTextLineAltererFor.
         replacement(AlterationRequired.YES,
            Pattern.compile("^([ \\t]+" + var_name + ")=.*$"),
            "$1=" + default_value, ReplacedInEachInput.FIRST,
               debug_aptr.getAppendable(),
            NewValidResultFilterFor.exactlyOne(debug_aptr.getAppendable()));
   }
}

