package  com.github.xbn.experimental.xcontext;
   import  java.util.Objects;
   import  com.github.xbn.lang.ToStringDefensive;
   import  com.github.xbn.experimental.BadInterfaceBehaviorException;

/**
   <p>Implementation of {@code ExceptionContext}.</p>
 **/
public class XContext implements ExceptionContext  {
//state
   private Object oXInfo =   null;
//internal
//Constructors...START
   /**
      <p>Create a new {@code XContext}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #XContext(Object) this}(null)</code></p>
    **/
   public XContext()  {
      this(null);
   }
   /**
      <p>Create a new {@code XContext}.</p>

      <p>This sets<ol>
         <li>{@link #setExtraInfo(Object) setExtraInfo(o_xtraInfo)}</li>
      </ol></p>

      @see  #XContext() this()
      @see  #XContext(boolean, ExceptionContext) this(b,xc)
    **/
   public XContext(Object o_xtraInfo)  {
      //Never ever call interface functions, directly or indirectly, in a constructor.
      zsetExtraInfoXC(o_xtraInfo);
   }
   /**
      <p>Create a new {@code XContext} from an {@code ExceptionContext}.</p>

      <p>This sets<ol>
         <li>{@link #getExtraInfo() getExtraInfo}{@code ()} to {@code to_copy.getExtraInfo()} &nbsp; &nbsp; <i>(See  <code><i>[{@link com.github.xbn.experimental.xcontext.ExceptionContext ExceptionContext}]</i>.{@link com.github.xbn.experimental.xcontext.ExceptionContext#setExtraInfo(Object) setExtraInfo}(o)</code>)</i></li>
      </ol></p>

      @param  ignored  Used only distinguish this constructor signature from {@link #XContext(String) this(s)}, <i>which allows {@code null}</i>.
      @param  to_copy  May not be {@code null}.
      @see  #XContext(String, Object) XContext(s,o)
    **/
   public XContext(boolean ignored, ExceptionContext to_copy)  {
      try  {
         oXInfo = to_copy.getExtraInfo();
      }  catch(RuntimeException rx)  {
         if(to_copy == null)  {
            throw  new NullPointerException("to_copy");
         }
         throw  rx;
      }
   }
//Constructors...END
//Setters...START
   /**
      <p>Set the extra-information string, which elaborates on the error.</p>

      @param  o_xtraInfo  When non-{@code null}, this object's {@code toString()} is appended onto the error message. When non-{@code null}, {@code o_xtraInfo.toString()} <i>should</i> not be empty. <i>This object is untouched until {@code getExtraInfo()} is called.</i>
    **/
   public void setExtraInfo(Object o_xtraInfo)  {
      zsetExtraInfoXC(o_xtraInfo);
   }
   protected final void zsetExtraInfoXC(Object o_xtraInfo)  {
      oXInfo = o_xtraInfo;
   }
//Setters...END
//Getters...START
   /**
      @return  {@code ((oXInfo == null) ? "" : oXInfo.toString())} Where {@code o_xtraInfo} is as provided to {@link #setExtraInfo(Object) setExtraInfo(s)}, the {@link #XContext(String, Object) constructor}, or {@link #XContext(XContext) copy-constructor}.
    **/
   public String getExtraInfo()  {
      return  ((oXInfo == null) ? "" : oXInfo.toString());
   }
   public String toString()  {
      return  XContext.toString(this);
   }
//Getters...END
//Other...START
   /**
    * <p>Get a duplicate of this object.</p>
      @return  <code>(new {@link #XContext(boolean, XContext) XContext}(false, this)</code>
    **/
   public ExceptionContext getObjectCopy()  {
      return  (new XContext(false, this));
   }
   /**
      @return  {@code true} If {@code to_compareTo} is non-{@code null}, aYYY {@code XContext}, and {@link #areFieldsEqual(XContext) areFieldsEqual}{@code ((XContext)to_compareTo)} is {@code true}.
    **/
   @Override public boolean equals(Object to_compareTo)  {

      //See internal comments for com.github.xbn.lang.XbnObject.equals(o)

      if(to_compareTo == null)  {
         throw  new NullPointerException("to_compareTo");
      }
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof XContext))  {
         return  false;
      }

      XContext xo = (XContext)to_compareTo;

      return  areFieldsEqual(xo);
   }
   /**
      <p>Are all internal values in the provided {@code XContext} the same as in <i>{@code this}</i>?.</p>

      @param  xc_nx  May not be {@code null}.
      @return  {@code true} If {@link #getExtraInfo() getExtraInfo}{@code ()} is the same value ({@code null} is okay) or the same object.
    **/
   public boolean areFieldsEqual(XContext xc_nx)  {
      try  {
         return  Objects.equals(getExtraInfo(), xc_nx.getExtraInfo());
      }  catch(RuntimeException rx)  {
         if(xc_nx == null)  {
            throw  new NullPointerException("xc_nx");
         }
         throw rx;
      }
   }
//Other...END
//static functions...START
   public static final String toString(ExceptionContext x_c)  {
      StringBuilder sd = new StringBuilder();

      if(x_c.getExtraInfo() != null)  {
         sd.append("extra-info=[").append(x_c.getExtraInfo()).append("]");
      }

      return  sd.toString();
   }
//Wrappers for required interface functions...START
   /**
      <p>Interface-function wrapper for {@code ExceptionContext}.</p>

      @param  xc_forIW  May not be {@code null}.
      @return  {@code xc_theIInstance.getExtraInfo(xc_theIInstance)}
      @exception  NullPointerException  When {@code xc_theIInstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code xc_theIInstance} is non-{@code null} and the call to {@code getExtraInfo()} fails for any unexpected reason.
    **/
   public static final String getExtraInfo(ExceptionContext xc_theIInstance, ExceptionContext xc_forIW)  {
      try  {
         return  xc_theIInstance.getExtraInfo();
      }  catch(RuntimeException rx)  {
         ciNullXC(xc_theIInstance, xc_forIW);
         throw  new BadInterfaceBehaviorException("Attempting to call xc_theIInstance.getExtraInfo()" + ToStringDefensive.get(xc_forIW, "xc_forIW", -1), rx);
      }
   }
//Wrappers for required interface functions...END
   private static void ciNullXC(ExceptionContext xc_theIInstance, ExceptionContext xc_forIW)  {
      if(xc_theIInstance == null)  {
         throw  new NullPointerException("xc_theIInstance" + ToStringDefensive.get(xc_forIW, "xc_forIW", -1));
      }
   }
//Error messages...START
//Error messages...END
//static functions...END

}

