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
package  com.github.xbn.lang.reflect;
	import  java.util.Objects;
	import  com.github.xbn.text.CrashIfString;
	import  java.lang.reflect.Method;
/**
	<p>Builder for obtaining a method, with runtime errors only (the original exception is accessible with {@code getCause()})</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class GetMethodWithRtx  {
//state
	private Class<?>   clsWMthd     = null ;
	private Class<?>[] aClsPrmTyps  = null ;
	private String     sMthdNm      = null ;
	private boolean    bParamsSet = false;
	private final Declared declared;
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[]{};
//public
	public GetMethodWithRtx(Declared declared)  {
		resetGDMR();
		Objects.requireNonNull(declared, "declared");
		this.declared = declared;
	}
	public GetMethodWithRtx reset()  {
		resetGDMR();
		return  this;
	}
	protected final void resetGDMR()  {
		sMthdNm = null;
		clsWMthd = null;
		aClsPrmTyps = null;
		bParamsSet = false;
	}
	public GetMethodWithRtx containingClass(String fq_className)  {
		return  containingClass(ReflectRtxUtil.getClassForName(fq_className, "fq_className"));
	}
	public GetMethodWithRtx containingClass(Object object)  {
		return  containingClass(ReflectRtxUtil.getClass(object, null));
	}
	public GetMethodWithRtx containingClass(Class<?> cls)  {
		if(cls == null)  {
			throw  new NullPointerException("cls");
		}
		clsWMthd = cls;
		return  this;
	}
	public GetMethodWithRtx mainMethod()  {
		name("main");
		return  paramTypes(new Class<?>[]{String[].class});
	}
	public GetMethodWithRtx name(String method_name)  {
		CrashIfString.nullEmpty(method_name, "method_name", null);
		sMthdNm = method_name;
		return  this;
	}
	public GetMethodWithRtx noParams()  {
		return  paramTypes(EMPTY_CLASS_ARRAY);
	}
	public GetMethodWithRtx paramTypes(Class<?>[] class_paramTypes)  {
		if(bParamsSet)  {
			throw  new IllegalStateException("Param types already set.");
		}
		bParamsSet = true;
		aClsPrmTyps = class_paramTypes;
		return  this;
	}
	public Method get()  {
		return  getWithExtraInfo(null);
	}
	public Method getWithExtraInfo(Object xtra_errInfo)  {
		if(sMthdNm == null)  {
			throw  new IllegalStateException("Method name not declared. Must call name(s).");
		}
		if(!bParamsSet)  {
			throw  new IllegalStateException("Parameters not declared. Must call paramTypes(cls...).");
		}
		return  ReflectRtxUtil.getMethod(clsWMthd, sMthdNm, declared, xtra_errInfo, aClsPrmTyps);
	}
}