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
package  com.github.xbn.examples.analyze.alter;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
/**
   <P>Simple custom <CODE>xbn.analyze.alter.{@link com.github.xbn.analyze.alter.ValueAlterer ValueAlterer}&lt;String&gt;</CODE> that converts the string to uppercase.</P>

   <P>{@code java com.github.xbn.examples.analyze.alter.ValueAltererXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValueAltererXmpl  {
   public static final void main(String[] ignored)  {
      AVUpperCase avuc = new AVUpperCase();
      System.out.println(avuc.getAltered(null, "Hello there."));
      System.out.println(avuc.getAltered(null, "Goodbye."));
   }
}
class AVUpperCase extends AbstractValueAlterer<String,String>  {
   public AVUpperCase()  {
      super();
   }
   public AVUpperCase(AVUpperCase to_copy)  {
      super(to_copy);
   }
   public final String getAlteredPostResetCheck(String ignored, String to_alter)  {
      declareAlteredNotDeleted();
      try  {
         return  to_alter.toUpperCase();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_alter");
      }
   }
   public AVUpperCase getObjectCopy()  {
      return  (new AVUpperCase(this));
   }
}
