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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.copyval.NullHandler;
/**
   <p>Abstract implementation of {@code ValueCopier}. For classes needing to implement {@code ValueCopier}, that cannot extend {@code AbstractValueCopier}, see {@link com.github.xbn.util.copyval.ValueCopierComposer ValueCopierComposer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractValueCopier<O> implements ValueCopier<O>  {
   private ValueCopierComposer<O> gvcc = null;
   /**
      <p>Create a new {@code AbstractValueCopier}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link com.github.xbn.util.copyval.ValueCopierComposer#ValueCopierComposer(boolean) super}{@code (is_copyable)}</p>
    */
   public AbstractValueCopier(boolean is_copyable)  {
      gvcc = new ValueCopierComposer<O>(is_copyable);
   }
   /**
      <p>Create a new {@code AbstractValueCopier} as a duplicate of another.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link com.github.xbn.util.copyval.ValueCopierComposer#ValueCopierComposer(ValueCopier) super}{@code (to_copy)}</p>

    * @param  to_copy  May not be {@code null}.
    */
   public AbstractValueCopier(ValueCopier<O> to_copy)  {
      gvcc = new ValueCopierComposer<O>(to_copy);
   }
 	@SuppressWarnings("unchecked")
 	public O getValueCopy(O original, String orig_name)  {
 		//0.1.5.1: Explicit cast to O required for 1.8 compatibility.
      return  (O)getValueCopy(original, orig_name, NewNullHandlerFor.useNull());
   }

 	public O getValueCopy(O original, String orig_name, NullHandler<O> null_handler)  {
      if(original == null)  {
         try  {
            if(null_handler.getAction().doDelete())  {
               throw  new IllegalStateException(orig_name + " is null and null_handler.getAction().doDelete() is true.");
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(null_handler, "null_handler", null, rx);
         }
         if(null_handler.getAction().doCrash())  {
            throw  new NullPointerException("original (null_handler.getAction().doCrash() is true)");
         }
         if(null_handler.getAction().doUseNonNull())  {
            original = null_handler.getNonNull();

         }  //else: doUseNull()
      }

      return  getCopyOfNonNullOrig(original, orig_name);
   }
   protected abstract O getCopyOfNonNullOrig(O original, String orig_name);
   public boolean isValueCopyable()  {
      return  gvcc.isValueCopyable();
   }
   public String toString()  {
      return  gvcc.toString();
   }
/*stub functions for non-abstract compile...START
 	public final O getValueCopy(O original, NullHandler<O> null_handler)  {
      return  null;
   }
 stub functions for non-abstract compile...END*/
}

