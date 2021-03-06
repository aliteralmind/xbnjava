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
package  com.github.xbn.lang;
/**
   <p>Basic error message construction. It is encouraged that this class be <a href="http://docs.oracle.com/javase/8/docs/technotes/guides/language/static-import.html">statically imported</a> &quot;en masse&quot;:
   <br/> &nbsp; &nbsp; {@code import  static com.github.xbn.lang.CrashIfBase.*;}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CrashIfBase  {
   /**
      <p>A basic error message with optional extra context. When there is no extra context, there is no point in using this function.</p>

    * @see  #appendExtraInfoPostfix(StringBuilder, Object) appendExtraInfoPostfix(sd,o)
    */
//getXMsg(String, Object)
   public static final String getXMsg(String message, Object xtra_errInfo)  {
      StringBuilder sd = (new StringBuilder());

      if(message != null)  {
         sd.append(message);
      }

      return  appendExtraInfoPostfix(sd, xtra_errInfo).toString();
   }
   public static final StringBuilder appendExtraInfoPostfix(StringBuilder to_appendTo, Object xtra_errInfo)  {
      if(xtra_errInfo == null)  {
         return  to_appendTo;
      }

      to_appendTo.append(", ");

      boolean bNotXia = !(xtra_errInfo instanceof XInfoAccumulator);

      if(bNotXia)  {
         to_appendTo.append("extra-info=[");
      }

      ToStringDefensive.append(to_appendTo, xtra_errInfo, "xtra_errInfo", -1);

      if(bNotXia)  {
         to_appendTo.append("]");
      }

      return  to_appendTo;
   }
   public static final RuntimeException regetRtxCrashIfNull(RuntimeException cause, String cause_name)  {
      if(cause == null)  {
         throw  new NullPointerException(cause_name);
      }
      //Can't use. Would result in circular dependency.
      //Objects.requireNonNull(cause, cause_name);
      return  cause;
   }
}
