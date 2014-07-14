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
/**
   <P>Indicates a problem with a line being filtered.</P>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://codelet.aliteralmind.com">{@code http://codelet.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/codelet">{@code https://github.com/aliteralmind/codelet}</A>

 **/
public class FilteredLineException extends IllegalArgumentException  {
   /**
    * 
    */
   private static final long serialVersionUID = -466381548710281347L;
   private final int lineNum;
   private final Object line;
   public FilteredLineException(int line_num, Object line, String message)  {
      super(FilteredLineException.getErrorMessage(line_num, line, message));
      lineNum = line_num;
      this.line = line;
   }
   public FilteredLineException(int line_num, Object line)  {
      super((line == null) ? null : line.toString());
      lineNum = line_num;
      this.line = line;
   }
   public FilteredLineException(int line_num, Object line, String message, Throwable cause)  {
      super(FilteredLineException.getErrorMessage(line_num, line, message), cause);
      lineNum = line_num;
      this.line = line;
   }
   public FilteredLineException(int line_num, Object line, Throwable cause)  {
      super((line == null) ? null : line.toString(), cause);
      lineNum = line_num;
      this.line = line;
   }
   public int getLineNumber()  {
      return  lineNum;
   }
   public Object getLineObject()  {
      return  line;
   }
   public static final String getErrorMessage(int line_num, Object line, String message)  {
      return  "[line " + line_num + "] " + ((line != null) ? line + ", " : "") + message;
   }
}
