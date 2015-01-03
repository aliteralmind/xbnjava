package  com.github.xbn.experimental;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.experimental.BadInterfaceBehaviorException;
   import  com.github.xbn.experimental.xcontext.EXContextable;
   import  com.github.xbn.experimental.xcontext.ElementExceptionContext;
   import  com.github.xbn.experimental.xcontext.ExceptionContext;
   import  com.github.xbn.experimental.xcontext.ObjectExceptionContext;
   import  com.github.xbn.experimental.xcontext.XContextable;

/**
   <p>For wrapping all interface function-calls in a try-block, to protect against untrustworthy implementations and diagnose other interface-related issues. All {@code InterfaceWrapper}-s must implement the interface itself (the interface being wrapped), so it can be arbitrarily used as a replacement for an actual instance.</p>
 **/
public abstract class InterfaceWrapper implements XContextable, Copyable  {
   private ExceptionContext xc = null;
   private Object oii = null;
   /**
      <p>Create a new {@code InterfaceWrapper}.</p>

      <p>This calls<ol>
         <li>{@link #setXContext(ExceptionContext) setXContext}{@code (x_c)}</li>
         <li>{@link #setGetIInstance(Object, String) setGetIInstance}{@code (o_iinstance, null)}</li>
      </ol>
    */
   public InterfaceWrapper(Object o_iinstance, ExceptionContext x_c)  {
      setXContext(x_c);
      setGetIInstance(o_iinstance, null);
   }
   /**
      <p>Create a new {@code InterfaceWrapper} as a duplicate of another.</p>

      <p>This calls<ol>
         <li><code>{@link #setGetIInstance(Object, String) setGetIInstance}(to_copy.{@link #getIInstance() getIInstance}(), null)</code></li>
         <li><code>{@link #setXContext(ExceptionContext) setXContext}((ExceptionContext)to_copy.{@link #getXContext() getXContext}().{@link com.github.xbn.experimental.xcontext.ExceptionContext#getObjectCopy() getObjectCopy}())</code></li>
      </ol>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
    */
   public InterfaceWrapper(InterfaceWrapper to_copy)  {
      try  {
         setGetIInstance(to_copy.getIInstance(), null);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      setXContext(ObjectOrCrashIfNull.<ExceptionContext>getCopy(getXContext(), ExceptionContext.class, "getXContext()"));
   }
   /**
      <p>Set the interface instance, then immediately return it. To set the instance to {@code null}, use {@link #removeIInstance() removeIInstance}{@code ()}. Attempting to use this function results in an ambiguous reference compile error.</p>

    * @param  o_iinstance  Get with {@link #getIInstance() getIInstance}{@code ()}. At initialization of this {@code InterfaceWrapper}, this may be {@code null} (before any functions are called against it). Otherwise, it should never be {@code null}.
    * @return  {@code o_iinstance} <i>This makes it easier to maintain a redundant reference to the object, via
      <br> &nbsp; &nbsp; {@code o = iw.setGetIInstance(...);}
      <br>This extra reference minimizes the need for calling this function, when the instance simply needs to be passed or tested for {@code null}.</i>

    * @see  #setXContext(ExceptionContext) setXContext(xc)
    * @see  #setIInstanceSubIWs(Object, String, InterfaceWrapper...) setIInstanceSubIWs(s,o,iw...)
    */
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
      <p>Set the interface-instance to {@code null}.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link #setGetIInstance(Object, String) setGetIInstance(null, null)}</p>
    */
   public void removeIInstance()  {
      setGetIInstance(null, null);
   }
   /**
      <p>Set the interface instance into multiple {@code InterfaceWrapper}-s. This is useful when an {@code InterfaceWrapper} has multiple sub-{@code InterfaceWrapper}-s.</p>

      <p>For each, this calls
      <br> &nbsp; &nbsp; {@link #setGetIInstance(Object, String) setGetIInstance(o_iinstance, nonNull_objName)}</p>
    */
   public void setIInstanceSubIWs(Object o_iinstance, String nonNull_objName, InterfaceWrapper... ddd_iw)  {
      if(ddd_iw.length == 0)  {
         throw  new IllegalArgumentException("ddd_iw.length is zero.");
      }
      for(InterfaceWrapper iw : ddd_iw)  {
         iw.setGetIInstance(o_iinstance, nonNull_objName);
      }
   }
   /**
      <p>Set the context for potential errors.</p>

    * @param  x_c  May not be {@code null}. Get with {@link #getXContext() getXContext}{@code ()}.
    * @see  #setGetIInstance(Object, String) setGetIInstance(o,s)
    */
   public void setXContext(ExceptionContext x_c)  {
      if(x_c == null)  {
         throw  new NullPointerException("x_c");
      }
      xc = x_c;
   }
   /**
      <p>Shortcut for {@code getXContext().setExtraInfo(o)}.</p>

    */
   public void setExtraInfo(Object o_iinstance, XContextable... ddd_xcblOthers)  {
      ExceptionContext xc = getXContext();
      xc.setExtraInfo(o_iinstance);
      for(XContextable xcl : ddd_xcblOthers)  {
         xcl.getXContext().setExtraInfo(o_iinstance);
      }
   }
   /**
      <p>Reset the context's index to zero.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link #setIndex(int, EXContextable...) setIndex}{@code (0)}</p>
    */
   public void setIndexTo0(EXContextable... ddd_xcblOthers)  {
      setIndex(0);
   }
   /**
      <p>Shortcut for {@code getXContext().setIndex(i)}.</p>

    * @see  #setIndexTo0(EXContextable...) setIndexTo0}(exc...)
    */
   public void setIndex(int index, EXContextable... ddd_xcblOthers)  {
      ElementExceptionContext exc = getEXContext();
      exc.setIndex(index);
      for(EXContextable excl : ddd_xcblOthers)  {
         excl.getEXContext().setIndex(index);
      }
   }
   /**
      <p>Get the interface instance.</p>

    * @return  {@code o_iinstance}, as provided to {@link #setGetIInstance(Object, String) setGetIInstance(o,s)}
    */
   public Object getIInstance()  {
      return  oii;
   }
   /**
      <p>Get the exception context.</p>

    * @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
    */
   public ExceptionContext getXContext()  {
      return  xc;
   }
   /**
      <p>Get the object exception context.</p>

    * @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
    * @exception  ClassCastException  If {@link #getXContext() getXContext}{@code ()} is not an {@code ObjectExceptionContext}
    */
   public ObjectExceptionContext getOXContext()  {
      try  {
         return  (ObjectExceptionContext)getXContext();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getXContext() is not an ObjectExceptionContext. getXContext().getClass()=" + getXContext().getClass());
      }
   }
   /**
      <p>Get the object exception context.</p>

    * @return  {@code x_c}, as provided to {@link #setXContext(ExceptionContext) setXContext(xc)}.
    * @exception  ClassCastException  If {@link #getXContext() getXContext}{@code ()} is not an {@code ElementExceptionContext}
    */
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
    * @return  {@code true} If {@code o_iinstance} is non-{@code null}, aYYY {@code InterfaceWrapper}, and {@link #areFieldsEqual(InterfaceWrapper) areFieldsEqual}{@code ((InterfaceWrapper)to_compareTo)} is {@code true}.
    */
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
      <p>Are all internal values in the provided {@code InterfaceWrapper} the same as in <i>{@code this}</i>?. <i>This ignores the interface-instances (they may be different or {@code null}).</i></p>

    * @return  {@link #getXContext() getXContext}{@code ().equals(wrapper.getXContext())}
    */
   public boolean areFieldsEqual(InterfaceWrapper wrapper)  {
      return  getXContext().equals(wrapper.getXContext());
   }
//Non static wrappers for required interface functions...START
   /**
      <p>Wrapper for {@code <i>[Object]</i>.getClass()}.</p>

      YYY

    * @return  {@code InterfaceWrapper.{@link #iiGetClass(Object, ExceptionContext) iiGetClass}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    */
   public final Class iiGetClass()  {
      return  InterfaceWrapper.iiGetClass(getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.hashCode()}.</p>

      YYY

    * @return  {@code InterfaceWrapper.{@link #iiHashCode(Object, ExceptionContext) iiHashCode}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    */
   public final int iiHashCode()  {
      return  InterfaceWrapper.iiHashCode(getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.equals(o)}.</p>

      YYY

    * @return  {@code InterfaceWrapper.{@link #iiEquals(Object, Object, ExceptionContext) iiEquals}(to_compareTo, {@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    */
   public final boolean iiEquals(Object to_compareTo)  {
      return  InterfaceWrapper.iiEquals(to_compareTo, getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.toString()}.</p>

      YYY

    * @return  {@code InterfaceWrapper.{@link #iiToString(Object, ExceptionContext) iiToString}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}
    */
   public final String iiToString()  {
      return  InterfaceWrapper.iiToString(getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.notify()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiNotify(Object, ExceptionContext) iiNotify}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</p>
    */
   public final void iiNotify()  {
      InterfaceWrapper.iiNotify(getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.notifyAll()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiNotifyAll(Object, ExceptionContext) iiNotifyAll}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</p>
    */
   public final void iiNotifyAll()  {
      InterfaceWrapper.iiNotifyAll(getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait(l)}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(long, Object, ExceptionContext) iiWait}(timeout_mills, {@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</p>
    */
   public final void iiWait(long timeout_mills)  throws InterruptedException  {
      InterfaceWrapper.iiWait(timeout_mills, getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait(l,i)}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(long, int, Object, ExceptionContext) iiWait}(timeout_mills, nanos, {@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</p>
    */
   public final void iiWait(long timeout_mills, int nanos)  throws InterruptedException  {
      InterfaceWrapper.iiWait(timeout_mills, nanos, getIInstance(), getXContext());
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code InterfaceWrapper.{@link #iiWait(Object, ExceptionContext) iiWait}({@link #getIInstance() getIInstance}(), <i>[{@link com.github.xbn.testdev.InterfaceWrapper super}]</i>.{@link com.github.xbn.testdev.InterfaceWrapper#getXContext() getXContext}())}</p>
    */
   public final void iiWait()  throws InterruptedException  {
      InterfaceWrapper.iiWait(getIInstance(), getXContext());
   }
//Non static wrappers for required interface functions...END
//Static wrappers for required interface functions...START

   /**
      <p>Wrapper for {@code <i>[Object]</i>.getClass()}.</p>

      YYY

    * @return  <code>o_iinstance.{@link Object#getClass() getClass}()</code>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code getClass()} fails for any unexpected reason.
    */
   public static final Class iiGetClass(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.getClass();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException("Error context: " + x_c, rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.hashCode()}.</p>

      YYY

    * @return  <code>o_iinstance.{@link Object#hashCode() hashCode}()</code>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code hashCode()} fails for any unexpected reason.
    */
   public static final int iiHashCode(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.hashCode();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.equals(o)}.</p>

      YYY

    * @return  <code>o_iinstance.{@link Object#equals(Object) equals}(to_compareTo)</code>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code equals()} fails for any unexpected reason.
    */
   public static final boolean iiEquals(Object to_compareTo, Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.equals(to_compareTo);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.iiToString()}.</p>

      YYY

    * @return  <code>o_iinstance.{@link Object#toString() toString}()</code>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code toString()} fails for any unexpected reason.
    */
   public static final String iiToString(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         return  o_iinstance.toString();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.notify()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>o_iinstance.{@link Object#notify() notify}()</code></p>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code notify()} fails for any unexpected reason.
    */
   public static final void iiNotify(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         o_iinstance.notify();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.notifyAll()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>o_iinstance.{@link Object#notifyAll() notifyAll}()</code></p>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code notifyAll()} fails for any unexpected reason.
    */
   public static final void iiNotifyAll(Object o_iinstance, ExceptionContext x_c)  {
      try  {
         o_iinstance.notifyAll();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait(l)}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>o_iinstance.{@link Object#wait(long) wait}(timeout_mills)</code></p>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    */
   public static final void iiWait(long timeout_mills, Object o_iinstance, ExceptionContext x_c)  throws InterruptedException  {
      try  {
         o_iinstance.wait(timeout_mills);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait(l,i)}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>o_iinstance.{@link Object#wait(long, int) wait}(timeout_mills, nanos)</code></p>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    */
   public static final void iiWait(long timeout_mills, int nanos, Object o_iinstance, ExceptionContext x_c)  throws InterruptedException  {
      try  {
         o_iinstance.wait(timeout_mills, nanos);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(o_iinstance, "o_iinstance", x_c);
         throw  new BadInterfaceBehaviorException(x_c.toString(), rx);
      }
   }
   /**
      <p>Wrapper for {@code <i>[Object]</i>.wait()}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>o_iinstance.{@link Object#wait() wait}()</code></p>
    * @param  o_iinstance  May not be {@code null}.
    * @param  x_c  May not be {@code null}.
    * @exception  NullPointerException  When {@code o_iinstance} is {@code null}
    * @exception  BadInterfaceBehaviorException  When {@code o_iinstance} is non-{@code null} and the call to {@code wait()} fails for any unexpected reason.
    */
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
