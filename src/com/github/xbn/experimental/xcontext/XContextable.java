package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.experimental.xcontext.ExceptionContext;
/**
   <P>{@code XContextable}-s contain an {@code ExceptionContext}.</P>
 **/
public interface XContextable  {
   void setXContext(ExceptionContext x_c);
   /**
      <P>Get the exception context.</P>

      @return  May or may not be {@code null}.
    **/
   ExceptionContext getXContext();
}
