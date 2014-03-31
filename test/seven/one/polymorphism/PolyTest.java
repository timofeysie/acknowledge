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


	public void testPolymorphism()
    {
        log.info("");
        log.info(this.getClass().getSimpleName());
        A a_b = new B();log.info("A a = new B() output: "+a_b.toString()+" var "+a_b.var+" str "+a_b.str);
        //log.info("a_b.toString2(): "+a_b.toString2());
        log.info("B b = new A() error- incompatible types: required: A found: B ");
        B b_c = new C();log.info("B b = new C() output: "+b_c.toString()+" var "+b_c.var+" str "+b_c.str);
        //log.info("b_c.toString2(): "+b_c.toString2());
        String expected = "value2";
        String actual = "value";
        assertEquals(expected,actual);
    }

    public void testByValue()
    {
        
    }

}