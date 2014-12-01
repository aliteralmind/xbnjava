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
package  com.github.xbn.experimental.listify;
/**
   <p>Thrown when a modify operation (such as remove, add, or set) is made on a {@code Listify} whose raw object is unmodifiable.</p>

 * @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). <code><a href="http://xbnjava.aliteralmind.com">http://xbnjava.aliteralmind.com</a></code>, <a href="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</a>}
 **/
public class ListifiedNotAddRemovableException extends IllegalStateException  {
/**
    * 
    */
   private static final long serialVersionUID = -8886369161416866624L;
   //constructors...START
   public ListifiedNotAddRemovableException()  {
      super();
   }
   public ListifiedNotAddRemovableException(String message)  {
      super(message);
   }
   public ListifiedNotAddRemovableException(Throwable cause)  {
      super(cause);
   }
   public ListifiedNotAddRemovableException(String message, Throwable cause)  {
      super(message, cause);
   }
//constructors...END
}
