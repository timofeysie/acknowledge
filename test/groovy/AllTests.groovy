import groovy.util.GroovyTestSuite
import junit.framework.Test
import junit.textui.TestRunner
import org.codehaus.groovy.runtime.ScriptTestAdapter

class AllTests 
{
    static Test suite() 
    {
        def allTests = new GroovyTestSuite()
        allTests.addTest(new
ScriptTestAdapter(allTests.compile("BasicTest.groovy"), [] as String[]))
        allTests.addTest(new
ScriptTestAdapter(allTests.compile("BasicTestScript.groovy"), [] as String[]))
		allTests.addTest(new
ScriptTestAdapter(allTests.compile("ArithmeticTest.groovy"), [] as String[]))
        allTests.addTest(new
ScriptTestAdapter(allTests.compile("LanguageTest.groovy"), [] as String[]))
        allTests.addTest(new
ScriptTestAdapter(allTests.compile("MultiplierTest.groovy"), [] as String[]))
        allTests.addTest(new
ScriptTestAdapter(allTests.compile("LanguageTheoryTest.groovy"), [] as String[]))

        return allTests
    }

	public static void main(args) 
	{
		TestRunner.run(AllTests.suite())
	}

}
