package seven.one.polymorphism;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class PolyTest extends TestCase 
{

    /* Class name*/
    static Logger log = Logger.getLogger(PolyTest.class);


	public void testSequence()
    {
        A a_b = new B();log.info("A a = new B() output: "+a_b.toString());
        log.info("B b = new A() compile error- incompatible types: required: A found: B ");
        String expected = "value2";
        String actual = "value";
        assertEquals(expected,actual);
    }

}