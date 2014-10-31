/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.experimental.xcontext;
	import  java.util.Objects;
/**
	<P>Implementation of {@code ObjectExceptionContext}.</P>
 **/
public class OXContext extends XContext implements ObjectExceptionContext  {
	//state
		private ExceptionContextObject xco = null;
	/**
		<P>Create a new {@code OXContext}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link #OXContext(String, String, Object) this(obj_name, null)}</P>
	 **/
	public OXContext(String obj_name)  {
		this(obj_name, null);
	}
	/**
		<P>Create a new {@code OXContext}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #OXContext(String, ExceptionContextObject, Object) this}((new {@link com.github.xbn.experimental.xcontext.XCObject#XCObject(String) XCObject}(obj_name)), o_xtraInfo)</CODE></P>
	 **/
	public OXContext(String obj_name, Object o_xtraInfo)  {
		this((new XCObject(obj_name)), o_xtraInfo);
	}
	/**
		<P>Create a new {@code OXContext}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link #OXContext(String, String, Object) this(xc_o, null)}</P>
	 **/
	public OXContext(boolean ignored, ExceptionContextObject xc_o)  {
		this(xc_o, null);
	}
	/**
		<P>Create a new {@code OXContext}.</P>

		<P>This calls<OL>
			<LI>{@link com.github.xbn.experimental.xcontext.XContext#XContext() super}{@code (xc_forIW)}</LI>
			<LI>{@link #setXCObject(ExceptionContextObject) setXCObject}{@code (xc_o)}</LI>
		</OL></P>}

		@see  #OXContext(String) this(s)
		@see  #OXContext(String, String) this(s)
		@see  #OXContext(String, String, Object) this(s,s,o)
		@see  #OXContext(boolean, String, ExceptionContextObject) this(b,s,xco)
		@see  #OXContext(OXContext) this(oxc)
		@see  #OXContext(ObjectExceptionContext) this(oxc)
	 **/
	public OXContext(ExceptionContextObject xc_o, Object o_xtraInfo)  {
		super(o_xtraInfo);
		setXCObject(xc_o);
	}
	/**
		<P>Create a new {@code OXContext} as a duplicate of another.</P>

		<P>This calls<OL>
			<LI>Calls <CODE>{@link com.github.xbn.experimental.xcontext.XContext#XContext(boolean, ExceptionContext) super}(false, to_copy)</CODE></LI>
			<LI><CODE>{@link #setXCObject(ExceptionContextObject) setXCObject}(to_copy.{@link #getXCObject() getXCObject}())</CODE></LI>
		</OL></P>
		@see  #OXContext(String, ExceptionContextObject, Object) this(s,xco,o)
	 **/
	public OXContext(OXContext to_copy)  {
		super(false, to_copy);
		setXCObject(to_copy.getXCObject());
	}
	/**
		<P>Create a new {@code OXContext} as a duplicate of another.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.experimental.xcontext.XContext#XContext(boolean, ExceptionContext) super}(false, to_copy)</CODE></LI>
			<LI><CODE>{@link #setXCObject(ExceptionContextObject) setXCObject}(to_copy.{@link #getXCObject() getXCObject}())</CODE></LI>
		</OL></P>
		@see  #OXContext(String, String, String, String, String) this(s,s,s,s,s)
	 **/
	public OXContext(ObjectExceptionContext to_copy)  {
		super(false, to_copy);
		setXCObject(to_copy.getXCObject());
	}
	/**
		<P>Set the error-causing object's name.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setXCObject(ExceptionContextObject) setXCObject}(new {@link com.github.xbn.experimental.xcontext.XCObject#XCObject(String) XCObject}(obj_name))</CODE></P>
	 **/
	public void setObjectName(String obj_name)  {
		setXCObject(new XCObject(obj_name));
	}
	/**
		<P>Set the error-causing object's metadata.</P>

		@param  xc_o  May not be {@code null}. Get with {@link #getXCObject() getXCObject}{@code ()}

		@see  #setObjectName(String) setObjectName(s)
	 **/
	public void setXCObject(ExceptionContextObject xc_o)  {
		Objects.requireNonNull(xc_o, "xc_o");
		xco = xc_o;
	}
//Getters...START
	/**
		@return  {@code xc_o}, as provided to {@link #setXCObject(ExceptionContextObject) setXCObject(s)}, or the {@link #OXContext(OXContext) copy-constructor}.
	 **/
	public ExceptionContextObject getXCObject()  {
		return  xco;
	}
	public String getObjectName()  {
		return  getXCObject().getName();
	}
//Getters...END
	/**
		@return  <CODE>(new {@link #OXContext(OXContext) OXContext}(this)</CODE>
	 **/
	public ExceptionContext getObjectCopy()  {
		return  (new OXContext(this));
	}
	/**
		@return  <CODE>{@link com.github.xbn.experimental.xcontext.XContext super}.{@link com.github.xbn.experimental.xcontext.XContext#toString() toString}() + &quot;, [&quot; + getXCObject() + &quot;]&quot;</CODE>
	 **/
	public String toString()  {
		return  super.toString() + ", [" + getXCObject() + "]";
	}
	/**
		@return  {@code true} If {@code to_compareTo} is non-{@code null}, aYYY {@code OXContext}, and {@link #areFieldsEqual(OXContext) areFieldsEqual}{@code ((OXContext)to_compareTo)} is {@code true}.
	 **/
	@Override public boolean equals(Object to_compareTo)  {
		if(to_compareTo == null)  {
			throw  new NullPointerException("to_compareTo");
		}
		if(this == to_compareTo)  {
			return  true;
		}
		if(!(to_compareTo instanceof OXContext))  {
			return  false;
		}

		OXContext oxc = (OXContext)to_compareTo;

		return  areFieldsEqual(oxc);
	}
	/**
		<P>Are all internal values in the provided {@code OXContext} the same as in <I>{@code this}</I>?.</P>

		@return  <CODE>({@link com.github.xbn.experimental.xcontext.XContext super}.{@link com.github.xbn.experimental.xcontext.XContext#areFieldsEqual(XContext) areFieldsEqual}(SUPER_CLASS_ABBREVIATION) &nbsp;&amp;&amp; &nbsp; {@link #getXCObject() getXCObject}().equals(o_xc.getXCObject()))</CODE>
	 **/
	public boolean areFieldsEqual(OXContext o_xc)  {
		return  (super.areFieldsEqual(o_xc)  &&  getXCObject().equals(o_xc.getXCObject()));
	}
}
