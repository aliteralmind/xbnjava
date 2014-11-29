package  com.github.xbn.experimental.xcontext;

/**
	<p>{@code ExceptionContext} for errors caused by (that may be caused by) a specific object.</p>
 **/
public interface ObjectExceptionContext extends ExceptionContext  {
	/**
		<p>Information on the object that caused (may cause) the error.</p>

		@return  A non-{@code null} {@code ExceptionContextObject}.
	 **/
	ExceptionContextObject getXCObject();

	/**
		<p>Shortcut for {@code getXCObject().getName()}.</p>
	 **/
	String getObjectName();
	void setObjectName(String obj_name);
}
