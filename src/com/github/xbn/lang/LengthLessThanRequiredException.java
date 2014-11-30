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
   <p>Indicates a container's length is invalid.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class LengthLessThanRequiredException extends IllegalArgumentException  {
   /**
    * 
    */
   private static final long serialVersionUID = -5699083111531196868L;
   private final String cntrName  ;
   private final int    actualLen ;
   private final int    rqdMin    ;
   private final String rqdMinName;
   public LengthLessThanRequiredException(String container_name, int actual_length, int rqd_min, String min_name, String message)  {
      this(container_name, actual_length, rqd_min, min_name, message, null);
   }
      private static final String getMsg(String container_name, int actual_length, int rqd_min, String min_name, String message)  {
         return  ((rqd_min == 1)
            ?  container_name + " has no elements"
            :  "Length of " + container_name + " (" + actual_length + "), is less than " +
            ((min_name == null) ? rqd_min : min_name + " (" + rqd_min + ")." +
            ((message != null) ? " message=\"" + message + "\"" : "")));
      }
   public LengthLessThanRequiredException(String container_name, int actual_length, int rqd_min, String min_name, String message, Throwable cause)  {
      super(LengthLessThanRequiredException.getMsg(container_name, actual_length, rqd_min, min_name, message), cause);
      cntrName   = container_name;
      actualLen  = actual_length;
      rqdMin     = rqd_min;
      rqdMinName = min_name;
   }
   public String getContainerName()  {
      return  cntrName;
   }
   public int getActualLength()  {
      return  actualLen;
   }
   public int getRequiredMin()  {
      return  rqdMin;
   }
   public String getRequiredMinName()  {
      return  rqdMinName;
   }
}
