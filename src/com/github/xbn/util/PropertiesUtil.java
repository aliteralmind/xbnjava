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
	import  com.github.xbn.io.RTIOException;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.Empty;
	import  com.github.xbn.regexutil.IgnoreCase;
	import  com.github.xbn.text.CharUtil;
	import  java.io.FileInputStream;
	import  java.io.IOException;
   import  java.util.Properties;
/**
   <P>Load {@code java.util.}{@link java.util.Properties Properties} from a file.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class PropertiesUtil  {
	/**
		<P>Load properties from a file path.</P>

		@param  path  Must be non-{@code null}, and refer to a valid properties file.
		@param  path_name  Descriptive name of {@code path}. <I>Should</I> not be {@code null} or empty.
		@exception  RTIOException  If a {@code java.io.IOException} is thrown for any reason.
	 **/
	public static final Properties getPropertiesFromFile(String path, String path_name)  {
		Properties props = new Properties();
		try  {
			props.load(new FileInputStream(path));
		} catch (IOException iox) {
			throw  new RTIOException("Attempting to load properties from " + path_name + ": " + path, iox);
		}
		return  props;
	}
	public static final boolean getWithEmptyDefault(Properties props, String prop_name, String true_value, String false_value, Empty empty_is, boolean if_emptyStr)  {
		try  {
			return  new GetBooleanFromString().trueFalse(true_value, false_value).
				nullEmptyDefaults_ifNullThenBad(null,
					(empty_is.isOk() ? if_emptyStr : null)).
				get(props.getProperty(prop_name, ""));
		}  catch(IllegalArgumentException iax)  {
			throw  new IllegalArgumentException("prop_name=\"" + prop_name + "\"", iax);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(empty_is, "empty_is", null, rx);
		}
	}

	public static final char getWithEmptyDefault(Properties props, String prop_name, Empty empty_is, char if_emptyStr)  {
		String s = null;
		try  {
			s = props.getProperty(prop_name, "");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(props, "props", null, rx);
		}
		if(s.length() == 0)  {
			try  {
				if(empty_is.isOk())  {
					return  if_emptyStr;
				}
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(empty_is, "empty_is", null, rx);
			}
			throw  new IllegalArgumentException("Property named " + prop_name + " is required but not provided (props.getProperty(\"" + prop_name + "\", \"\") is \"\", and if_emptyStr is null)");
		}
		return  CharUtil.getFromOneCharString(s, prop_name);
	}
	public static final int getWithEmptyDefault(Properties props, String prop_name, Empty empty_is, int if_emptyStr)  {
		String s = null;
		try  {
			s = props.getProperty(prop_name, "");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(props, "props", null, rx);
		}
		if(s.length() == 0)  {
			try  {
				if(empty_is.isOk())  {
					return  if_emptyStr;
				}
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(empty_is, "empty_is", null, rx);
			}
			throw  new IllegalArgumentException("Property named " + prop_name + " is required but not provided (props.getProperty(\"" + prop_name + "\", \"\") is \"\", and if_emptyStr is null)");
		}
		try  {
			return  Integer.parseInt(s);
		}  catch(NumberFormatException nfx)  {
			throw  new NumberFormatException("Attempting Integer.parseInt(props.getProperty(prop_name, \"\")). " + nfx);
		}
	}
	public static final <T extends Enum<T>> T getWithEmptyDefault(Properties props, String prop_name, Empty empty_is, T if_emptyStr, IgnoreCase ignore_case)  {
		String prop = null;
		try  {
			prop = props.getProperty(prop_name, "");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(props, "props", null, rx);
		}
		if(prop.length() == 0)  {
			try  {
				if(empty_is.isOk())  {
					return  if_emptyStr;
				}
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(empty_is, "empty_is", null, rx);
			}
			throw  new IllegalArgumentException("Property named " + prop_name + " is required but not provided (props.getProperty(\"" + prop_name + "\", \"\") is \"\", and if_emptyStr is null)");
		}
		try  {
			return  EnumUtil.<T>toValueWithNullDefault(prop, prop_name, ignore_case, DefaultValueFor.EMPTY_ONLY, if_emptyStr);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(if_emptyStr, "if_emptyStr", null, rx);
		}
	}
}