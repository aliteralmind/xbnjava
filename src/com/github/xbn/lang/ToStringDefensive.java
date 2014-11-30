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
   import  com.github.xbn.io.RTIOException;
   import  java.io.IOException;
/**
   <p>Gets the {@code toString()} of an object, handling the possibility that it throws an exception.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ToStringDefensive  {
   /**
      <p>Get an object's {@code toString()}, anticipating the possibility of it throwing an exception.</p>

      @return  {@link #append(Appendable, Object, String, int) append}{@code ((new StringBuilder()), obj_forToStr, objOrCntr_name, idx_ofObjInCntr)}
    **/
   public static final String get(Object obj_forToStr, String objOrCntr_name, int idx_ofObjInCntr)  {
      return  append((new StringBuilder()), obj_forToStr, objOrCntr_name, idx_ofObjInCntr).toString();
   }
   /**
      <p>Append an object's {@code toString()}, anticipating the possibility of it throwing an exception.</p>

      @param  obj_forToStr  The object whose {@code toString()} is needed. May not be {@code null}.
      @param  objOrCntr_name  Descriptive name of {@code obj_forToStr}. <i>Should</i> not be {@code null} or empty.
      @return  If {@code obj_forToStr.toString()}<ul>
         <li>Returns normally: {@code obj_forToStr.toString()}</li>
         <li>Fails for any reason: A diagnostic string stating {@code objOrCntr_name + &quot;.toString()&quot;} failed, with the exception's toString() appended.</li>
      </ul>
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public static final Appendable append(Appendable to_appendTo, Object obj_forToStr, String objOrCntr_name, int idx_ofObjInCntr)  {
      String sTs = null;
      try  {
         try  {
            sTs = obj_forToStr.toString();
         }  catch(RuntimeException rx)  {
            if(obj_forToStr == null)  {
               throw  new NullPointerException("obj_forToStr");
            }
            to_appendTo.append("<Error attempting ");
            if(idx_ofObjInCntr >= 0)  {
               to_appendTo.append("[element ").
                  append((new Integer(idx_ofObjInCntr)).toString()).
                  append(" in ").append(objOrCntr_name).append("].toString(): ");
            }  else  {
               to_appendTo.append(objOrCntr_name).append(".toString(): ");
            }
            to_appendTo.append(rx.toString()).append(">");
         }
         return  to_appendTo.append(sTs);
      }  catch(IOException iox)  {
         throw  new RTIOException("append", iox);
      }
   }
}
