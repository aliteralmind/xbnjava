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
/**
   <p>Implementation of {@code GetValueForNull}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SimpleNullHandler<O> implements NullHandler<O>  {
//state
   private ActionForNull ea = null;
   private O oNNull = null;
//public
   @SuppressWarnings("unchecked")
   public static final NullHandler USE_NULL = new SimpleNullHandler(ActionForNull.USE_NULL, null);
//constructors...START
   public SimpleNullHandler(O non_nullReplacement)  {
      this(ActionForNull.USE_NON_NULL, non_nullReplacement);
   }
   /**
      <p>Create a new {@code SimpleNullHandler}.</p>

      <p>This calls<ol>
      </ol></p>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#SimpleNullHandler(O)">this</a>(O)</code>
    */
   public SimpleNullHandler(ActionForNull action, O non_nullReplacement)  {
      if(action == null)  {
         throw  new NullPointerException("action");
      }
      if(action == ActionForNull.USE_NON_NULL)  {
         if(non_nullReplacement == null)  {
            throw  new IllegalArgumentException("non_nullReplacement is null, but action ActionForNull.USE_NON_NULL.");
         }
      }  else if(non_nullReplacement != null)  {
         throw  new IllegalArgumentException("non_nullReplacement is non-null, but action (" + action + ") is not ActionForNull.USE_NON_NULL.");
      }
      ea = action;
      oNNull = non_nullReplacement;
   }
   /**
      <p>Create a new {@code SimpleNullHandler} as a duplicate of another.</p>

      <p>This<ol>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
    */
   public SimpleNullHandler(SimpleNullHandler<O> to_copy)  {
      ea = to_copy.getAction();
      oNNull = to_copy.getNonNull();
   }
//constructors...END
//main functionality...START
   /**
    * @see  # <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#setAction(ActionForNull, O)">setAction</a>(ehnva,O)</code>
    */
   public ActionForNull getAction()  {
      return  ea;
   }
   /**
    * @return  <code>({@link #getAction() getAction}() ==  {@link com.github.xbn.util.copyval.ActionForNull ActionForNull}.USE_NULL)</code>.
    */
   public boolean doUseNull()  {
      return  (getAction() ==  ActionForNull.USE_NULL);
   }
   /**
    * @return  <code>({@link #getAction() getAction}() ==  {@link com.github.xbn.util.copyval.ActionForNull ActionForNull}.CRASH)</code>.
    */
   public boolean doCrash()  {
      return  (getAction() ==  ActionForNull.CRASH);
   }
   /**
    * @return  <code>({@link #getAction() getAction}() ==  {@link com.github.xbn.util.copyval.ActionForNull ActionForNull}.DELETE)</code>.
    */
   public boolean doDelete()  {
      return  (getAction() ==  ActionForNull.DELETE);
   }
   /**
    * @return  <code>({@link #getAction() getAction}() ==  {@link com.github.xbn.util.copyval.ActionForNull ActionForNull}.USE_NON_NULL)</code>.
    */
   public boolean doUseNonNull()  {
      return  (getAction() ==  ActionForNull.USE_NON_NULL);
   }
   /**
    * @exception  IllegalStateException  If {@link #doUseNonNull() doUseNonNull}{@code ()} is {@code false}.
    * @see   <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#setAction(boolean, O)">#setAction</a>(b,O)</code>
    */
   public O getNonNull()  {
      if(!doUseNonNull())  {
         throw  new IllegalStateException("doUseNonNull() is false.");
      }
      return  oNNull;
   }
//main functionality...END
//other...START
   /**
      <p>Duplicate this {@code SimpleNullHandler}.</p>

    * @return  <code>(new {@link #SimpleNullHandler(SimpleNullHandler) SimpleNullHandler}&lt;O&gt;(this))</code>
    */
   public NullHandler<O> getObjectCopy()  {
      return  (new SimpleNullHandler<O>(this));
   }
   public String toString()  {
      return  super.toString() + ", getAction()=" + getAction() +
         (!doUseNonNull() ? "" : ", getNonNull()=[" + getNonNull() + "]");
   }
//other...END
//static...START
   public static final <O> O getCopyCIOrigNullAndActionCrashOrDel(NullHandler<O> null_handler, O original)  {
      return  getCopyCIOrigNullAndActionCrash(null_handler, true, original);
   }
   public static final <O> void ciActionCrashOrDel(NullHandler<O> null_handler)  {
      ciActionCrash(null_handler, true);
   }

   public static final <O> O getCopyCIOrigNullAndActionCrash(NullHandler<O> null_handler, boolean do_crashIfActionIsDel, O original)  {
      if(original != null)  {
         return  original;
      }
      ciActionCrash(null_handler, do_crashIfActionIsDel);
      return  null_handler.getNonNull();
   }
   /**
      <p>Get the message for when calling a {@code get[PrimitiveType](index)} (such as {@code getBool(i)}), and the if-{@code null} behavior is {@code CRASH} or {@code DELETE}.</p>
    */
   public static final <O> void ciActionCrash(NullHandler<O> null_handler, boolean do_crashIfActionIsDel)  {
      try  {
         if(null_handler.getAction().doCrash()  ||  (do_crashIfActionIsDel  &&  null_handler.getAction().doDelete()))  {
            throw  new IllegalStateException("The original value is null (getNullHandlerForPrimitives().getAction().doCrash() is " + null_handler.getAction().doCrash() + ", getNullHandlerForPrimitives().getAction().doDelete() is " + null_handler.getAction().doDelete() + ", do_crashIfActionIsDel=" + do_crashIfActionIsDel + ")");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(null_handler, "null_handler", null, rx);
      }
   }
   /**
   public static final <O> O getCopyCIOrigNullAndActionCrash(NullHandler<O> null_handler, O original)  {
      if(original != null)  {
         return  original;
      }
      ciActionCrash(null_handler);
      return  null_handler.getNonNull();
   }
      <p>Get the message for when calling a {@code get[PrimitiveType](index)} (such as {@code getBool(i)}), and the if-{@code null} behavior is {@code CRASH} or {@code DELETE}.</p>
   public static final <O> void ciActionCrash(NullHandler<O> null_handler)  {
      try  {
         if(null_handler.doCrash())  {
            throw  new IllegalStateException("The original value is null (getNullHandlerForPrimitives().doCrash() is " + null_handler.doCrash() + ")");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(null_handler, "null_handler", null, rx);
      }
   }
    */
//static...END
}
