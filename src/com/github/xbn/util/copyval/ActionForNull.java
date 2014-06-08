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
package  com.github.xbn.util.copyval;
/**
   <P>The action taken when attempting to duplicate a value that is {@code null}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum ActionForNull {
   /**
      <P>The duplicate should also be {@code null}.</P>

      @see  #USE_NON_NULL
      @see  #DELETE
      @see  #CRASH
      @see  #doUseNull()
    **/
   USE_NULL,
   /**
      <P>The duplicate should be set to a pre-configured non-{@code null} value.</P>

      @see  #USE_NULL
      @see  #doUseNonNull()
      @see  NullHandler#getNonNull()
    **/
   USE_NON_NULL,
   /**
      <P>The duplicate should not be created.</P>

      @see  #USE_NULL
      @see  #doDelete()
    **/
   DELETE,
   /**
      <P>Throw an exception.</P>

      @see  #USE_NULL
      @see  #doCrash()
    **/
   CRASH;
   /**
      <P>Is this {@code eCllLstAryOthr} equal to {@code USE_NULL}?.</P>

      @return  <CODE>this == {@link #USE_NULL}</CODE>

      @see  #doUseNonNull()
      @see  #doDelete()
      @see  #doCrash()
    **/
   public final boolean doUseNull()  {
      return  this == USE_NULL;
   }
   /**
      <P>Is this {@code eCllLstAryOthr} equal to {@code USE_NON_NULL}?.</P>

      @return  <CODE>this == {@link #USE_NON_NULL}</CODE>
      @see  #doUseNull()
    **/
   public final boolean doUseNonNull()  {
      return  this == USE_NON_NULL;
   }
   /**
      <P>Is this {@code eCllLstAryOthr} equal to {@code DELETE}?.</P>

      @return  <CODE>this == {@link #DELETE}</CODE>
      @see  #doUseNull()
      @see  #isNparray()
    **/
   public final boolean doDelete()  {
      return  this == DELETE;
   }
   /**
      <P>Is this {@code eCllLstAryOthr} equal to {@code CRASH}?.</P>

      @return  <CODE>this == {@link #CRASH}</CODE>
      @see  #doUseNull()
      @see  #isParray()
    **/
   public final boolean doCrash()  {
      return  this == CRASH;
   }
};
