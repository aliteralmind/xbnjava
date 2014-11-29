package  com.github.xbn.experimental.xcontext;
	import  com.github.xbn.experimental.xcontext.ObjectExceptionContext;
/**
	<p>{@code OXContextable}-s contain an {@code ObjectExceptionContext}.</p>
 **/
public interface OXContextable extends XContextable  {
	void setOXContext(ObjectExceptionContext o_xc);
	/**
		<p>Get the exception context.</p>

		@return  May or may not be {@code null}.
	 **/
	ObjectExceptionContext getOXContext();
}
