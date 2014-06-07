/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.lang;
   import  com.github.xbn.text.CrashIfString;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
/**
   <P>For classes that need to implement {@code ExtraErrInfoable}, that cannot extend concrete or abstract implementations.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ExtraErrInfoableComposer  {
   private Object oXtrNfo = null;
   @CompositionConstructor
   public ExtraErrInfoableComposer()  {
   }
   public ExtraErrInfoableComposer(boolean ignored, ExtraErrInfoableComposer to_copy)  {
      oXtrNfo = to_copy.getExtraErrInfo();
   }
   @CompositionConstructor
   public ExtraErrInfoableComposer(ExtraErrInfoable cfxi_toCopy)  {
      try  {
         oXtrNfo = cfxi_toCopy.getExtraErrInfo();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(cfxi_toCopy, "cfxi_toCopy", null, rx);
      }
   }
   @CompositionFunction
   public Object getExtraErrInfo()  {
      return  oXtrNfo;
   }
   @CompositionFunction
   public ExtraErrInfoableComposer extraErrInfo(Object xtra_errInfo)  {
      setExtraErrInfo(xtra_errInfo);
      return this;
   }
   public void setExtraErrInfo(Object xtra_errInfo)  {
      oXtrNfo = xtra_errInfo;
   }
}
