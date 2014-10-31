package  com.github.xbn.test;
	import  org.junit.runner.JUnitCore;
	import  org.junit.runner.Result;
	import  org.junit.runner.notification.Failure;
/**
 * <P>Run all unit tests in the project.</P>
 *
 * <P>{@code java com.github.xbn.test.UnitTestRunner}</P>
 */
public class UnitTestRunner  {
    public static void main(String[] as_cmdLineArgs) {

		Class[] acALL = new Class[] {
/*
 */
			com.github.xbn.test.ExampleCodeOutputsContain_Unit.class,
			com.github.xbn.test.array.CrashIfArray_Unit.class,
			com.github.xbn.test.list.CrashIfCollection_Unit.class,
			com.github.xbn.test.list.CrashIfList_Unit.class,
			com.github.xbn.test.number.IntInRange_Unit.class,
			com.github.xbn.test.number.NumberUtil_Unit.class,
			com.github.xbn.test.text.padchop.VzblPadChop_Unit.class
/*
 */
		};

		Result r = JUnitCore.runClasses(                 //Comma-separated list of classes
			acALL
		);

		System.out.println("Test results:");
		System.out.println("  Successful:  " + (r.getRunCount() - r.getFailureCount()));
		System.out.println("  Failures:    " + r.getFailureCount());
		System.out.println("               ----");
		System.out.println("  Total:       " + r.getRunCount() + "\n");

		if(r.getFailureCount() > 0)  {
			System.out.println("Failure descriptions:");
			for(Failure f : r.getFailures())  {
				System.out.println("  " + f.toString());
			}
		}
    }
}

