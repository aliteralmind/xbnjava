package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.experimental.xcontext.ElementExceptionContext;
/**
   <P>{@code OXContextable}-s contain an {@code ElementExceptionContext}.</P>
 **/
public interface EXContextable extends OXContextable  {
   void setEXContext(ElementExceptionContext o_xc);
   /**
      <P>Get the exception context.</P>

      @return  May or may not be {@code null}.
    **/
   ElementExceptionContext getEXContext();
}
