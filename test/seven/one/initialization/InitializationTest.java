package seven.one.initialization;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class InitializationTest extends TestCase 
{

    /* Class name*/
    static Logger log = Logger.getLogger(InitializationTest.class);


	public void testSequence()
    {
        log.info("");
        log.info(this.getClass().getSimpleName());
        log.info("1st Object -------");
        new Sequence().go(); 
        log.info("2nd Object -------");
        Sequence s = new Sequence();
        s.go();
        String expected = "value";
        String actual = "value";
        assertEquals(expected,actual);
    }

}