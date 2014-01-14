import groovy.util.GroovyTestCase

class BasicTest extends GroovyTestCase 
{
    void testSomething() 
    {
        assert 1 == 1
        assert 2 + 2 == 4 : "We're in trouble, arithmetic is broken"
    }

    public static void main(args) 
	{
		//TestRunner.run(AllTests.suite())
	}
}
