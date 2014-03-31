package seven.one.mathical;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class FormatTest extends TestCase 
{

    static Logger log = Logger.getLogger(FormatTest.class);

	public void testBitmask()
    {
    	log.info("");
    	log.info("###"+this.getClass().getSimpleName()+"###");
		Format format = new Format();
		format.entryPoint();
	}

}