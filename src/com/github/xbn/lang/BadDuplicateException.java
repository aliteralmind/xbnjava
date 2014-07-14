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
   <P>Indicates a container's length is invalid.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class BadDuplicateException extends IllegalArgumentException  {
   /**
    * 
    */
   private static final long serialVersionUID = 1410377225966758555L;
   private final String obj1Name;
   private final String obj2Name;
   private final Object value   ;
   public BadDuplicateException(String message)  {
      super(message);
      obj1Name   = null;
      obj2Name   = null;
      this.value = null;
   }
   public BadDuplicateException(String object1_name, String object2_name, Object value)  {
      this(object1_name, object2_name, value, null);
   }
      private static final String getMsg(String object1_name, String object2_name, Object value)  {
         return  object1_name + " and " + object2_name + " both equal [" + value + "]";
      }
   public BadDuplicateException(String object1_name, String object2_name, Object value, Throwable cause)  {
      super(BadDuplicateException.getMsg(object1_name, object2_name, value), cause);
      obj1Name   = object1_name;
      obj2Name   = object2_name;
      this.value = value;
   }
   public String getObject1Name()  {
      return  obj1Name;
   }
   public String getObject2Name()  {
      return  obj2Name;
   }
   public Object getValue()  {
      return  value;
   }
}
