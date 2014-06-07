package  com.github.xbn.experimental.xcontext;
/**
   <P>{@code ObjectExceptionContext} for objects that are elements in an index-able container (such as an array or {@code java.util.Collection}).</P>
 **/
public interface ElementExceptionContext extends ObjectExceptionContext  {
   /**
      <P>Information on object that caused (may cause) the error.</P>

      @return   <CODE>(ExceptionContextElement)<I>[{@link com.github.xbn.experimental.xcontext.ObjectExceptionContext super}]</I>.{@link com.github.xbn.experimental.xcontext.ObjectExceptionContext#getXCObject() getXCObject}()</CODE>
    **/
   ExceptionContextElement getXCElement();
   /**
      <P>Shortcut for {@code getXCElement().getName()}.</P>
    **/
   String getContainerName();
   /**
      <P>Shortcut for {@code getXCElement().getIndex()}.</P>
    **/
   int getIndex();
   /**
      <P>Update the element's index.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #getXCElement() getXCElement}{@code ().}{@link com.github.xbn.experimental.xcontext.ExceptionContextElement#index(int) index}{@code ()}</P>
    **/
   void setIndex(int index);
}
