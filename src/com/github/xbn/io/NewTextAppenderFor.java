/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.io;
   import  java.io.PrintWriter;
/**
   <P>Convenience functions for creating new {@code TextAppenders}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewTextAppenderFor  {
   private NewTextAppenderFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final TAAppendable<StringBuilder> stringBuilder(StringBuilder to_appendTo)  {
      return  (new TAAppendable<StringBuilder>(to_appendTo, "to_appendTo"));
   }
   public static final TAAppendable<StringBuilder> strBldrWithInitStringNullOk(Object str_toPad)  {
      return  (new TAAppendable<StringBuilder>(new StringBuilder((str_toPad == null) ? "" : str_toPad.toString())));
   }
   public static final TAAppendMutable<StringBuilder> mutableStrBldrWithInitStringNullOk(Object str_toPad)  {
      return  (new TAAppendMutable<StringBuilder>(new StringBuilder((str_toPad == null) ? "" : str_toPad.toString())));
   }
   public static final TAAppendMutable<StringBuilder> mutableStringBuilder(StringBuilder to_appendTo)  {
      return  (new TAAppendMutable<StringBuilder>(to_appendTo, "to_appendTo"));
   }
   public static final TextAppender file(String path, AppendOrOverwrite apnd_ovr)  {
      try  {
         PrintWriter writer = new NewPrintWriterToFile().overwrite(apnd_ovr.isOverwrite()).autoFlush().
            build(path);
         return  new TAAppendable<PrintWriter>(writer);
      }  catch(RuntimeException rx)  {
         throw  new IllegalArgumentException("Attempting to open a PrintWriter to \"debugging_destination\"", rx);
      }
   }
   public static final <A extends Appendable> TAAppendMutable<A> mutableAppendableNeedsToBeSet()  {
      return  (new TAAppendMutable<A>());
   }
}
