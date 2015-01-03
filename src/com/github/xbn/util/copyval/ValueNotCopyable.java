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
   <p>For types that cannot be duplicated (throws a {@code com.github.xbn.glist.NotCopyableException}).</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ValueNotCopyable<O> extends AbstractValueCopier<O>  {
   public static final ValueNotCopyable INSTANCE = new ValueNotCopyable();
//constructors...	START
   /**
      <p>Create a new {@code ValueNotCopyable}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link com.github.xbn.util.copyval.AbstractValueCopier#AbstractValueCopier(boolean) super}{@code (false)}</p>
    */
   private ValueNotCopyable()  {
      super(false);
   }
//constructors...END
 	public O getValueCopy(O ignored1, String ignored2)  {
      throw  new NotCopyableException();
   }
 	public O getValueCopy(O ignored1, String ignored2, NullHandler<O> ignored3)  {
      throw  new NotCopyableException();
   }
   /**
      <p><i>Do not use.</i></p>

    * @exception  UnsupportedOperationException
    */
   protected O getCopyOfNonNullOrig(O ignored1, String ignored2)  {
      throw  new UnsupportedOperationException("Should never be reached!");
   }
   /**
    * <p>Get a reference to <i>this</i> object.</p>
    */
   public ValueCopier<O> getObjectCopy()  {
      return  this;
   }
}

