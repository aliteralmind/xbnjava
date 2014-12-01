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
package  com.github.xbn.linefilter.entity.raw;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.linefilter.entity.KeepStartLine;
   import  com.github.xbn.linefilter.entity.KeepMidLines;
   import  com.github.xbn.linefilter.entity.KeepEndLine;
   import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_Cfg;
   import  com.github.xbn.linefilter.entity.raw.z.RawBlockEntity_CfgForNeeder;
/**
   <p>Convenience functions for creating {@code RawBlockEntity}s.</p>

 * @see  com.github.xbn.linefilter.entity.NewBlockEntityFor
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewRawBlockEntityFor  {
   public static final <L> RawBlockEntity_CfgForNeeder<L,?,?> returnKeptUnchanged_Cfg(String name_rootIfNull, KeepMatched keep_all)  {
      return  returnKeptUnchanged_Cfg(name_rootIfNull,
            KeepStartLine.getForKeepMatched(keep_all, "keep_all"),
            KeepMidLines.getForKeepMatched(keep_all, null),
            KeepEndLine.getForKeepMatched(keep_all, null));
   }
   public static final <L> RawBlockEntity_CfgForNeeder<L,?,?> returnKeptUnchanged_Cfg(String name_rootIfNull, KeepStartLine start, KeepMidLines mids, KeepEndLine end)  {
      return  new RawBlockEntity_Cfg<L>(
         (name_rootIfNull != null) ? "root" : name_rootIfNull).
         keepStartMidEnd(
            ObjectOrCrashIfNull.get(start, "start").isYes(),
            ObjectOrCrashIfNull.get(mids, "mids").isYes(),
            ObjectOrCrashIfNull.get(end, "end").isYes());
   }
   public static final <L> RawBlockEntity<L> keepAllUnchanged(String name_rootIfNull)  {
      return  NewRawBlockEntityFor.<L>returnKeptUnchanged_Cfg(
         name_rootIfNull, KeepStartLine.YES, KeepMidLines.YES, KeepEndLine.YES).
         build();
   }
/*
   public static final <L> RawBlockEntity<L> keepAllUnchanged(String name_rootIfNull, KeepStartLine start, KeepMidLines mids, KeepEndLine end)  {
   }
 */

   private NewRawBlockEntityFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
