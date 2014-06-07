package  com.github.xbn.experimental.xcontext;

/**
   <P>{@code ExceptionContext} for errors caused by (that may be caused by) a specific object.</P>
 **/
public interface ObjectExceptionContext extends ExceptionContext  {
   /**
      <P>Information on the object that caused (may cause) the error.</P>

      @return  A non-{@code null} {@code ExceptionContextObject}.
    **/
   ExceptionContextObject getXCObject();

   /**
      <P>Shortcut for {@code getXCObject().getName()}.</P>
    **/
   String getObjectName();
   void setObjectName(String obj_name);
}
