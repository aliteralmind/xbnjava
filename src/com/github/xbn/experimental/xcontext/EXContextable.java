package  com.github.xbn.experimental.xcontext;
	import  com.github.xbn.experimental.xcontext.ElementExceptionContext;
/**
	<p>{@code OXContextable}-s contain an {@code ElementExceptionContext}.</p>
 **/
public interface EXContextable extends OXContextable  {
	void setEXContext(ElementExceptionContext o_xc);
	/**
		<p>Get the exception context.</p>

		@return  May or may not be {@code null}.
	 **/
	ElementExceptionContext getEXContext();
}
