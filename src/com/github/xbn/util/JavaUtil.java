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
package  com.github.xbn.util;
	import  com.github.xbn.lang.CrashIfObject;
	import  static com.github.xbn.lang.XbnConstants.*;
	import  java.util.regex.Pattern;
/**
	<p>Get the non-fully-qualified class name of an object, and transform a Java source-code path to its fully qualified class-name.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class JavaUtil  {
	protected JavaUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<p>The default value for a boolean is {@code false}.</p>

		<p>Viewed 1/21/2014
		<br/><code><a href="http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html</a></code>:</p>

		<p><b>Default Values:</b> </p>

		<p>It's not always necessary to assign a value when a field is declared. Fields that are declared but not initialized will be set to a reasonable default by the compiler. Generally speaking, this default will be zero or null, depending on the data type. Relying on such default values, however, is generally considered bad programming style. The following chart summarizes the default values for the above data types.</p>

<pre>{@literal
Data Type	Default Value (for fields)
--------------------------------------
byte                       0
short                      0
int                        0
long                       0L
float                      0.0f
double                     0.0d
char                       '\u0000'
String (or any object)     null
boolean                    false}</pre>

{@.codelet.and.out com.github.xbn.examples.util.JavaUtilInitializedValuesXmpl%eliminateCommentBlocksAndPackageDecl()}

		@see  #getInitializedObjectForClassName(String) getInitializedObjectForClassName(s)
		@see  #DEFAULT_CHAR
		@see  #DEFAULT_BYTE
		@see  #DEFAULT_SHORT
		@see  #DEFAULT_INT
		@see  #DEFAULT_LONG
		@see  #DEFAULT_FLOAT
		@see  #DEFAULT_DOUBLE
	 **/
	public static final boolean DEFAULT_BOOLEAN = false;
	/**
		<p>The default value for a char {@code '\u0000'}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final char DEFAULT_CHAR = '\u0000';
	/**
		<p>The default value for a byte is {@code 0}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final byte DEFAULT_BYTE = 0;
	/**
		<p>The default value for a short is {@code 0}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final short DEFAULT_SHORT = 0;
	/**
		<p>The default value for a int is {@code 0}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final int DEFAULT_INT = 0;
	/**
		<p>The default value for a long is {@code 0L}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final long DEFAULT_LONG = 0L;
	/**
		<p>The default value for a float {@code 0.0f}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final float DEFAULT_FLOAT = 0.0f;
	/**
		<p>The default value for a double {@code 0.0d}.</p>

		@see  #DEFAULT_BOOLEAN
	 **/
	public static final double DEFAULT_DOUBLE = 0.0d;
	public static final String sDTJAVA = ".java";
	public static final String sDTCLASS = ".class";

	public static final String getRelativePathForFQClassName(String name)  {
		try  {
			return  name.replace(".", FILE_SEP) + ".java";
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(name, "name", null, rx);
		}
	}
	public static final String getJavaFilePathElimDtJvDtClsRplcFSToDot(String path_toJavaSource)  {
		try  {
			if(path_toJavaSource.endsWith(sDTJAVA))  {
				return  path_toJavaSource.replaceAll(Pattern.quote(FILE_SEP), ".").substring(0, path_toJavaSource.length() - sDTJAVA.length());
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(path_toJavaSource, "path_toJavaSource", null, rx);
		}
		if(path_toJavaSource.endsWith(sDTCLASS))  {
			return  path_toJavaSource.replaceAll(Pattern.quote(FILE_SEP), ".").substring(0, path_toJavaSource.length() - sDTCLASS.length());
		}
		return  path_toJavaSource.replaceAll(Pattern.quote(FILE_SEP), ".");
	}
	/**
		<p>Get an object's non-fully-qualified class-name.</p>

		@param  object  May not be {@code null}.
		@return  For example, if {@code object} is of type {@code java.lang.Integer}, this returns {@code Integer}.
	 **/
	public static final String getNonFQClassName(Object object)  {
		String sfqcn = null;
		try  {
			sfqcn = object.getClass().getName();
		}  catch(RuntimeException rx)  {
			if(object == null)  {
				throw  new NullPointerException("object");
			}
			throw  rx;
		}

		int ixLastDot = sfqcn.lastIndexOf(".");
		return  ((ixLastDot == -1) ? sfqcn
			: sfqcn.substring((ixLastDot + 1), sfqcn.length()));
	}
	/**
		<p>Get an object containing an initialized value for the static class-type.</p>

		@param  cls_static  May not be {@code null}.
		@return  <code>{@link #getInitializedObjectForClassName(String) getInitializedObjectForClassName}(cls_static.getName())</code>
	 **/
	public static final Object getInitializedObjectForClass(Class cls_static)  {
		try  {
				return  getInitializedObjectForClassName(cls_static.getName());
			}  catch(RuntimeException rx)  {
				throw  new NullPointerException("cls_static");
			}
	}
	/**
		<p>Get an object containing an initialized value for the type whose name is in a string.</p>

		<p>Idea from (viewed 1/2/2014)
		<br/> &nbsp; &nbsp; <code><a href="http://stackoverflow.com/a/2892067/2736496">http://stackoverflow.com/a/2892067/2736496</a></code></p>

		@param  type_name  May not be {@code null}.
		@return  If {@code type_name} is equal to<ul>
			<li>{@code "boolean"}: {@link #DEFAULT_BOOLEAN}</li>
			<li>{@code "char"}: {@link #DEFAULT_CHAR}</li>
			<li>{@code "byte"}: {@link #DEFAULT_BYTE}</li>
			<li>{@code "short"}: {@link #DEFAULT_SHORT}</li>
			<li>{@code "int"}: {@link #DEFAULT_INT}</li>
			<li>{@code "long"}: {@link #DEFAULT_LONG}</li>
			<li>{@code "float"}: {@link #DEFAULT_FLOAT}</li>
			<li>{@code "double"}: {@link #DEFAULT_DOUBLE}</li>
			<li><i>anything else</i>: {@code null}</li>
		</ul>
		@see  #getInitializedObjectForClass(Class) getInitializedObjectForClass(cls)
		@see  <a href="https://gist.github.com/aliteralmind/8544406">This function as a Gist</a>
		@see  <a href="http://stackoverflow.com/a/21265154/2736496">This function in answer to the above stackoverflow question</a>
	 **/
	public static final Object getInitializedObjectForClassName(String type_name)  {
		try  {
			if(type_name.equals("boolean"))  {
				return  DEFAULT_BOOLEAN;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(type_name, "type_name", null, rx);
		}
		if(type_name.equals("char"))  {
			return  DEFAULT_CHAR;
		}
		if(type_name.equals("byte"))  {
			return  DEFAULT_BYTE;
		}
		if(type_name.equals("short"))  {
			return  DEFAULT_SHORT;
		}
		if(type_name.equals("int"))  {
			return  DEFAULT_INT;
		}
		if(type_name.equals("long"))  {
			return  DEFAULT_LONG;
		}
		if(type_name.equals("float"))  {
			return  DEFAULT_FLOAT;
		}
		if(type_name.equals("double"))  {
			return  DEFAULT_DOUBLE;
		}

		//Non-primitive type
		return  null;
	}
	public static final String getPathForJavaClass(String base_dir, String fq_className, String dotPostfix_nullIfNone)  {
		return  base_dir + fq_className.replace(".", FILE_SEP) +
			((dotPostfix_nullIfNone == null) ? "" : dotPostfix_nullIfNone);
	}
	public static final String getPathForJavaClass(String base_dir, Class<?> cls, String dotPostfix_nullIfNone)  {
		return  base_dir + cls.getName().replace(".", FILE_SEP) +
			((dotPostfix_nullIfNone == null) ? "" : dotPostfix_nullIfNone);
	}
}
