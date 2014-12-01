package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.experimental.xcontext.ExceptionContext;
/**
   <p>{@code XContextable}-s contain an {@code ExceptionContext}.</p>
 **/
public interface XContextable  {
   void setXContext(ExceptionContext x_c);
   /**
      <p>Get the exception context.</p>

    * @return  May or may not be {@code null}.
    */
   ExceptionContext getXContext();
}
