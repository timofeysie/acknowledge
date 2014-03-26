package seven.one.initialization;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class InitializationTest extends TestCase 
{

    /* Class name*/
    static Logger log = Logger.getLogger(InitializationTest.class);


	public void testSequence()
    {
        Sequence s = new Sequence();
        String expected = "value";
        String actual = "x";
        assertEquals(expected,actual);
    }

}