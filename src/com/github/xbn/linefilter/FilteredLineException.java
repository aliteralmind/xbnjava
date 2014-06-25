/*license*\
   Codelet: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.linefilter;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Indicates a problem with a line being filtered.</P>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://codelet.aliteralmind.com">{@code http://codelet.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/codelet">{@code https://github.com/aliteralmind/codelet}</A>

 **/
public class FilteredLineException extends IllegalArgumentException  {
   private final RawLine<?> lineObj;
   public FilteredLineException(RawLine<?> line_obj, String message)  {
      super(FilteredLineException.getErrorMessage(line_obj, message));
      lineObj = line_obj;
   }
   public FilteredLineException(RawLine<?> line_obj)  {
      super((line_obj == null) ? null : line_obj.toString());
      lineObj = line_obj;
   }
   public FilteredLineException(RawLine<?> line_obj, String message, Throwable cause)  {
      super(FilteredLineException.getErrorMessage(line_obj, message), cause);
      lineObj = line_obj;
   }
   public FilteredLineException(RawLine<?> line_obj, Throwable cause)  {
      super((line_obj == null) ? null : line_obj.toString(), cause);
      lineObj = line_obj;
   }
   public RawLine<?> getLineObject()  {
      return  lineObj;
   }
   public static final String getErrorMessage(RawLine<?> line_obj, String message)  {
      try  {
         return  ((line_obj != null) ? line_obj + ", " : "") + message;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line_obj, "line_obj", null, rx);
      }
   }
}
