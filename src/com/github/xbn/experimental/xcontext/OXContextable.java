package  com.github.xbn.experimental.xcontext;
	import  com.github.xbn.experimental.xcontext.ObjectExceptionContext;
/**
	<P>{@code OXContextable}-s contain an {@code ObjectExceptionContext}.</P>
 **/
public interface OXContextable extends XContextable  {
	void setOXContext(ObjectExceptionContext o_xc);
	/**
		<P>Get the exception context.</P>

		@return  May or may not be {@code null}.
	 **/
	ObjectExceptionContext getOXContext();
}
