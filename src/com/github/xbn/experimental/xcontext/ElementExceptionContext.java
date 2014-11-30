package  com.github.xbn.experimental.xcontext;
/**
   <p>{@code ObjectExceptionContext} for objects that are elements in an index-able container (such as an array or {@code java.util.Collection}).</p>
 **/
public interface ElementExceptionContext extends ObjectExceptionContext  {
   /**
      <p>Information on object that caused (may cause) the error.</p>

      @return   <code>(ExceptionContextElement)<i>[{@link com.github.xbn.experimental.xcontext.ObjectExceptionContext super}]</i>.{@link com.github.xbn.experimental.xcontext.ObjectExceptionContext#getXCObject() getXCObject}()</code>
    **/
   ExceptionContextElement getXCElement();
   /**
      <p>Shortcut for {@code getXCElement().getName()}.</p>
    **/
   String getContainerName();
   /**
      <p>Shortcut for {@code getXCElement().getIndex()}.</p>
    **/
   int getIndex();
   /**
      <p>Update the element's index.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #getXCElement() getXCElement}{@code ().}{@link com.github.xbn.experimental.xcontext.ExceptionContextElement#index(int) index}{@code ()}</p>
    **/
   void setIndex(int index);
}
