package  com.github.xbn.experimental.xcontext;
	import  com.github.xbn.text.CrashIfString;
/**
	<P>Implementation of {@code ExceptionContextObject}.</P>
 **/
public class XCObject implements ExceptionContextObject  {
	//state
		private String sONm = null;
//Constructors...START
	/**
		<P>Create a new {@code XCObject}.</P>

		<P>This calls<OL>
			<LI>{@link #setName(String) setName(obj_name)}</LI>
		</OL></P>

		@see  #XCObject(ExceptionContextObject) this(xco)
	 **/
	public XCObject(String obj_name)  {
		setName(obj_name);
	}
	/**
		<P>Create a new {@code XCObject} as a duplicate of an {@code ExceptionContextObject}.</P>

		<P>This<OL>
			<LI><CODE>{@link #setName(String) setName}(to_copy.{@link #getName() getName}())</CODE></LI>
		</OL></P>
		@see  #getObjectCopy()
		@see  #XCObject(ExceptionContext, String) this(xc,s)
	 **/
	public XCObject(ExceptionContextObject to_copy)  {
		setName(to_copy.getName());
	}
//Constructors...END
//Setters...START
	/**
		<P>Set the just-called function in which the error happened (may happen).</P>

		@param  obj_name  May not be {@code null} or empty. Get with {@link #getName() getName}{@code ()}.
	 **/
	public void setName(String obj_name)  {
		CrashIfString.nullEmpty(obj_name, "obj_name", null);
		sONm = obj_name;
	}
//Setters...END
//Getters...START
	/**
		@return  {@code obj_name}, as provided to {@link #setName(String) setName(s)}, the {@link #XCObject(ExceptionContext, String) constructor}, or the {@link #XCObject(ExceptionContextObject) copy-constructor}.
	 **/
	public String getName()  {
		return  sONm;
	}
//Getters...END
//Other...START
	/**
		<P>Duplicate this {@code XCObject}</P>

		@return  <CODE>(new {@link #XCObject(ExceptionContextObject) XCObject}(this)</CODE>
	 **/
	public XCObject getObjectCopy()  {
		return  (new XCObject(this));
	}
	public String toString()  {
		return  "object=\"" + getName() + "\"";
	}
	/**
		@return  {@code true} If {@code to_compareTo} is non-{@code null}, aYYY {@code XCObject}, and {@link #areFieldsEqual(XCObject) areFieldsEqual}{@code ((XCObject)to_compareTo)} is {@code true}.
	 **/
	@Override public boolean equals(Object to_compareTo)  {
		if(to_compareTo == null)  {
			throw  new NullPointerException("to_compareTo");
		}
		if(this == to_compareTo)  {
			return  true;
		}
		if(!(to_compareTo instanceof XCObject))  {
			return  false;
		}

		XCObject xco = (XCObject)to_compareTo;

		return  areFieldsEqual(xco);
	}
	/**
		<P>Are all internal values in the provided {@code XCObject} the same as in <I>{@code this}</I>?.</P>

		@param  xc_o  May not be {@code null}.
		@return  {@link #getName() getName}{@code ().equals(xc_o.getName())}
	 **/
	public boolean areFieldsEqual(XCObject xc_o)  {
		return  getName().equals(xc_o.getName());
	}
//Other...END
}
