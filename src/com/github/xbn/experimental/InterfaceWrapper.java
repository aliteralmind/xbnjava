package  com.github.xbn.experimental;
   import  com.github.xbn.lang.Null;
   import  java.util.Objects;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.experimental.BadInterfaceBehaviorException;
   import  com.github.xbn.experimental.xcontext.EXContextable;
   import  com.github.xbn.experimental.xcontext.ElementExceptionContext;
   import  com.github.xbn.experimental.xcontext.ExceptionContext;
   import  com.github.xbn.experimental.xcontext.ObjectExceptionContext;
   import  com.github.xbn.experimental.xcontext.XContextable;

/**
   <P>For wrapping all interface function-calls in a try-block, to protect against untrustworthy implementations and diagnose other interface-related issues. All {@code InterfaceWrapper}-s must implement the interface itself (the interface being wrapped), so it can be arbitrarily used as a replacement for an actual instance.</P>
 **/
public abstract class InterfaceWrapper implements XContextable, Copyable  {
   private ExceptionContext xc = null;
   private Object oii = null;
   /**
      <P>Create a new {@code InterfaceWrapper}.</P>

      <P>This calls<OL>
         <LI>{@link #setXContext(ExceptionContext) setXContext}{@code (x_c)}</LI>
         <LI>{@link #setGetIInstance(Object, String) setGetIInstance}{@code (o_iinstance, null)}</LI>
      </OL></P>
    **/
   public InterfaceWrapper(Object o_iinstance, ExceptionContext x_c)  {
      setXContext(x_c);
      setGetIInstance(o_iinstance, null);
   }
   /**
      <P>Create a new {@code InterfaceWrapper} as a duplicate of another.</P>

      <P>This calls<OL>
         <LI><CODE>{@link #setGetIInstance(Object, String) setGetIInstance}(to_copy.{@link #getIInstance() getIInstance}(), null)</CODE></LI>
         <LI><CODE>{@link #setXContext(ExceptionContext) setXContext}((ExceptionContext)to_copy.{@link #getXContext() getXContext}().{@link com.github.xbn.experimental.xcontext.ExceptionContext#getObjectCopy() getObjectCopy}())</CODE></LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
    **/
   public InterfaceWrapper(InterfaceWrapper to_copy)  {
      try  {
         setGetIInstance(to_copy.getIInstance(), null);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      setXContext(ObjectOrCrashIfNull.<ExceptionContext>getCopy(getXContext(), ExceptionContext.class, "getXContext()"));
   }
   /**
      <P>Set the interface instance, then immediately return it. To set the instance to {@code null}, use {@link #removeIInstance() removeIInstance}{@code ()}. Attempting to use this function results in an ambiguous reference compile error.</P>

      @param  o_iinstance  Get with {@link #getIInstance() getIInstance}{@code ()}. At initialization of this {@code InterfaceWrapper}, this may be {@code null} (before any functions are called against it). Otherwise, it should never be {@code null}.
      @return  {@code o_iinstance} <I>This makes it easier to maintain a redundant reference to the object, via
      <BR> &nbsp; &nbsp; {@code o = iw.setGetIInstance(...);}
      <BR>This extra reference minimizes the need for calling this function, when the instance simply needs to be passed or tested for {@code null}.</I>

      @see  #setXContext(ExceptionContext) setXContext(xc)
      @see  #setIInstanceSubIWs(Object, String, InterfaceWrapper...) setIInstanceSubIWs(s,o,iw...)
    **/
   public Object setGetIInstance(Object o_iinstance, String nonNull_objName)  {
      if(nonNull_objName != null)  {
         try  {
            getOXContext().setObjectName(nonNull_objName);
         }  catch(ClassCastException ccx)  {
            throw  new ClassCastException("nonNull_objName (\"" + nonNull_objName + "\") is non-null, but getXContext() is not an ObjectExceptionContext. getXContext()=[" + getXContext() + "]");
         }
      }

      oii = o_iinstance;
      return  o_iinstance;
   }
   /**
      <P>Set the interface-instance to {@code null}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #setGetIInstance(Object, String) setGetIInstance(null, null)}</P>
    **/
   public void removeIInstance()  {
      setGetIInstance(null, null);
   }
   /**
      <P>Set the interface instance into multiple {@code InterfaceWrapper}-s. This is useful when an {@code InterfaceWrapper} has multiple sub-{@code InterfaceWrapper}-s.</P>

      <P>For each, this calls
      <BR> &nbsp; &nbsp; {@link #setGetIInstance(Object, String) setGetIInstance(o_iinstance, nonNull_objName)}</P>
    **/
   public void setIInstanceSubIWs(Object o_iinstance, String nonNull_objName, InterfaceWrapper... ddd_iw)  {
      if(ddd_iw.length == 0)  {
         throw  new IllegalArgumentException("ddd_iw.length is zero.");
      }
      for(InterfaceWrapper iw : ddd_iw)  {
         iw.setGetIInstance(o_iinstance, nonNull_objName);
      }
   }
   /**
      <P>Set the context for potential errors.</P>

      @param  x_c  May not be {@code null}. Get with {@link #getXContext() getXContext}{@code ()}.
      @see  #setGetIInstance(Object, String) setGetIInstance(o,s)
    **/
   public void setXContext(ExceptionContext x_c)  {
      if(x_c == null)  {
         throw  new NullPointerException("x_c");
      }
      xc = x_c;
   }
   /**
      <P>Shortcut for {@code getXContext().setExtraInfo(o)}.</P>

    **/
   public void setExtraInfo(Object o_iinstance, XContextable... ddd_xcblOthers)  {
      ExceptionContext xc = getXContext();
      xc.setExtraInfo(o_iinstance);
      for(XContextable xcl : ddd_xcblOthers)  {
         xc.setExtraInfo(o_iinstance);
      }
   }
   /**
      <P>Reset the context's index to zero.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #setIndex(int, EXContextable...) setIndex}{@code (0)}</P>
    **/
   public void setIndexTo0(EXContextable... ddd_xcblOthers)  {
      setIndex(0);
   }
   /**
      <P>Shortcut for {@code getXContext().setIndex(i)}.</P>

      @see  #setIndexTo0(EXContextable...) setIndexTo0}(exc...)
    **/
   public void setIndex(int index, EXContextable... ddd_xcblOthers)  {
      ElementExceptionContext exc = getEXContext();
      exc.setIndex(index);
      for(EXContextable excl : ddd_xcblOthers)  {
         excl.getEXContext().setIndex(index);
      }
   }
   /**
      <P>Get the interface instance.</P>

      @return  {@code o_iinstance}, as provided to {@link #setGetIInstance(Object, String) setGetIInstance(o,s)}
    **/
   public Object getIInstance()  {
      return  oii;
   }
   /**
      <P>Get the exception context.</P>

      @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
    **/
   public ExceptionContext getXContext()  {
      return  xc;
   }
   /**
      <P>Get the object exception context.</P>

      @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
      @exception  ClassCastException  If {@link #getXContext() getXContext}{@code ()} is not an {@code ObjectExceptionContext}
    **/
   public ObjectExceptionContext getOXContext()  {
      try  {
         return  (ObjectExceptionContext)getXContext();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getXContext() is not an ObjectExceptionContext. getXContext().getClass()=" + getXContext().getClass());
      }
   }
   /**
      <P>Get the object exception context.</P>

      @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
      @exception  ClassCastException  If {@link #getXContext() getXContext}{@code ()} is not an {@code ElementExceptionContext}
    **/
   public ElementExceptionContext getEXContext()  {
      try  {
         return  (ElementExceptionContext)getXContext();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getXContext() is not an ElementExceptionContext. getXContext().getClass()=" + getXContext().getClass());
      }
   }
   public String toString()  {
      return  super.toString() + ": getIInstance()=[" + getIInstance() + "], getXContext()=[" + getXContext() + "]";
   }
   /**
      @return  {@code true} If {@code o_iinstance} is non-{@code null}, aYYY {@code InterfaceWrapper}, and {@link #areFieldsEqual(InterfaceWrapper) areFieldsEqual}{@code ((InterfaceWrapper)to_compareTo)} is {@code true}.
    **/
   @Override public boolean equals(Object to_compareTo)  {

      //See internal comments for com.github.xbn.lang.SimpleXbnObject.equals(o)

      if(to_compareTo == null)  {
         throw  new NullPointerException("to_compareTo");
      }
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof InterfaceWrapper))  {
         return  false;
      }

      InterfaceWrapper xo = (InterfaceWrapper)to_compareTo;

      return  areFieldsEqual(xo);
   }
   /**
      <P>Are all internal values in the provided {@code InterfaceWrapper} the same as in <I>{@code this}</I>?. <I>This ignores the interface-instances (they may be different or {@code null}).</I></P>

      @return  {@link #getXContext() getXContext}{@code ().equals(wrapper.getXContext())}
    **/
   public boolean areFieldsEqual(InterfaceWrapper wrapper)  {
      return  getXContext().equals(wrapper.getXContext());
   }
//Non static wrappers for required interface functions...START
   /**
      <P>Wrapper for {@code <I>[Object]</I>.getClass()}.</P>

      YYY

      @return  {@code InterfaceWrapper.{@link #iiGetClass(Object, ExceptionContext) iiGetClass}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    **/
   public final Class iiGetClass()  {
      return  InterfaceWrapper.iiGetClass(getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.hashCode()}.</P>

      YYY

      @return  {@code InterfaceWrapper.{@link #iiHashCode(Object, ExceptionContext) iiHashCode}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    **/
   public final int iiHashCode()  {
      return  InterfaceWrapper.iiHashCode(getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.equals(o)}.</P>

      YYY

      @return  {@code InterfaceWrapper.{@link #iiEquals(Object, Object, ExceptionContext) iiEquals}(to_compareTo, {@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    **/
   public final boolean iiEquals(Object to_compareTo)  {
      return  InterfaceWrapper.iiEquals(to_compareTo, getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.toString()}.</P>

      YYY

      @return  {@code InterfaceWrapper.{@link #iiToString(Object, ExceptionContext) iiToString}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    **/
   public final String iiToString()  {
      return  InterfaceWrapper.iiToString(getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.notify()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiNotify(Object, ExceptionContext) iiNotify}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</P>
    **/
   public final void iiNotify()  {
      InterfaceWrapper.iiNotify(getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.notifyAll()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiNotifyAll(Object, ExceptionContext) iiNotifyAll}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</P>
    **/
   public final void iiNotifyAll()  {
      InterfaceWrapper.iiNotifyAll(getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait(l)}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(long, Object, ExceptionContext) iiWait}(timeout_mills, {@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</P>
    **/
   public final void iiWait(long timeout_mills)  throws InterruptedException  {
      InterfaceWrapper.iiWait(timeout_mills, getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait(l,i)}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(long, int, Object, ExceptionContext) iiWait}(timeout_mills, nanos, {@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</P>
    **/
   public final void iiWait(long timeout_mills, int nanos)  throws InterruptedException  {
      InterfaceWrapper.iiWait(timeout_mills, nanos, getIInstance(), getXContext());
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(Object, ExceptionContext) iiWait}({@link #getIInstance() getIInstance}(), <I>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</I>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</P>
    **/
   public final void iiWait()  throws InterruptedException  {
      InterfaceWrapper.iiWait(getIInstance(), getXContext());
   }
//Non static wrappers for required interface functions...END
//Static wrappers for required interface functions...START

   /**
      <P>Wrapper for {@code <I>[Object]</I>.getClass()}.</P>

      YYY

      @return  <CODE>o_iinstance.{@link Object#getClass() getClass}()</CODE>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code getClass()} fails for any unexpected reason.
    **/
   public static final Class iiGetClass(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.getClass();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException("Error context: " + x_c, rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.hashCode()}.</P>

      YYY

      @return  <CODE>o_iinstance.{@link Object#hashCode() hashCode}()</CODE>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code hashCode()} fails for any unexpected reason.
    **/
   public static final int iiHashCode(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.hashCode();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.equals(o)}.</P>

      YYY

      @return  <CODE>o_iinstance.{@link Object#equals(Object) equals}(to_compareTo)</CODE>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code equals()} fails for any unexpected reason.
    **/
   public static final boolean iiEquals(Object to_compareTo, Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.equals(to_compareTo);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.iiToString()}.</P>

      YYY

      @return  <CODE>o_iinstance.{@link Object#toString() toString}()</CODE>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code toString()} fails for any unexpected reason.
    **/
   public static final String iiToString(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.toString();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.notify()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>o_iinstance.{@link Object#notify() notify}()</CODE></P>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code notify()} fails for any unexpected reason.
    **/
   public static final void iiNotify(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         o_iinstance.notify();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.notifyAll()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>o_iinstance.{@link Object#notifyAll() notifyAll}()</CODE></P>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code notifyAll()} fails for any unexpected reason.
    **/
   public static final void iiNotifyAll(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         o_iinstance.notifyAll();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait(l)}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>o_iinstance.{@link Object#wait(long) wait}(timeout_mills)</CODE></P>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    **/
   public static final void iiWait(long timeout_mills, Object o_iinstance, ExceptionContext x_c)  throws InterruptedException  {
      try  {
         o_iinstance.wait(timeout_mills);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait(l,i)}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>o_iinstance.{@link Object#wait(long, int) wait}(timeout_mills, nanos)</CODE></P>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    **/
   public static final void iiWait(long timeout_mills, int nanos, Object o_iinstance, ExceptionContext x_c)  throws InterruptedException  {
      try  {
         o_iinstance.wait(timeout_mills, nanos);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <P>Wrapper for {@code <I>[Object]</I>.wait()}.</P>

      YYY

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>o_iinstance.{@link Object#wait() wait}()</CODE></P>
      @param  o_iinstance  May not be {@code null}.
      @param  x_c  May not be {@code null}.
      @exception  NullPointerException  When {@code o_iinstance} is {@code null}
      @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    **/
   public static final void iiWait(Object o_iinstance, ExceptionContext x_c)  throws InterruptedException  {
      try  {
         o_iinstance.wait();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
//Static wrappers for required interface functions...END
}
