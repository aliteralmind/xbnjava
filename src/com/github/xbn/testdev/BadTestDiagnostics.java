package  com.github.xbn.testdev;
	import  static com.github.xbn.lang.XbnConstants.*;
	import  com.github.xbn.text.CrashIfString;

/**
	<P>For highly-structured testing functions that output cumulative debugging information on each problem.</P>
 **/
public class BadTestDiagnostics  {
	private Object oForTS = null;
	private String snTest = null;
	public BadTestDiagnostics(Object for_diagToStrOnly, String test_name)  {
		CrashIfString.nullEmpty(test_name, "test_name", null);
		oForTS = for_diagToStrOnly;
		snTest = test_name;
	}
	public final String getTestName()  {
		return  snTest;
	}
	public final Object getObjectForToString()  {
		return  oForTS;
	}
	public String getDiagnostics(String bad_diags)  {
		if(bad_diags == null  ||  bad_diags.length() == 0)  {
			return  null;
		}

		return  "TEST FAILED: getBadTestDiagnostics_" + getTestName() + ":" + LINE_SEP +
			bad_diags + ", getObjectForToString()=[" + getObjectForToString() + "]";
	}
	public String getDiagnosticsFromSubTests(String... ddd_subGBTD)  {
		String s = null;
		for(String s2 : ddd_subGBTD)  {
			if(s == null)  {
				if(s2 == null)  {
					continue;
				}  else  {
					s = s2;
				}
			}  else if(s2 == null)  {
				continue;
			}  else  {
				s += s2;
			}
		}

		return  getDiagnostics(s);
	}
}