package seven.one.collections;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class ListsTest extends TestCase 
{

    /* Class name*/
    static Logger log = Logger.getLogger(ListsTest.class);


	public void testSequence()
    {
        log.info("");
        log.info(this.getClass().getSimpleName());
        Set<String> hash = new HashSet<String>();
        Set<String> tree = new TreeSet<String>();
        Set<String> link = new LinkedHashSet<String>();
        List<String> arl = new ArrayList<String>();
        String [] args = {"9","8","7","6","5","4","3","2","1","0","10"};
        for (String a : args)
        {
            hash.add(a);
            tree.add(a);
            link.add(a);
            arl.add(a);
        }
        log.info("HashSet         " +hash+" unordered");
        log.info("TreeSet         " +tree+" ordered");
        log.info("LinkedHashSet   " +link+" insertion order");

        List<String> list = Arrays.asList(args);
        log.info("Arrays          " +link+" sequence");

        List<String> list2 = Arrays.asList(args);
        Collections.shuffle(list2);

        log.info("Random list     "+list);
        log.info("ArrayList       "+arl+" insertion order?");

        Lists list_instance = new Lists();
        list_instance.swap(arl, 0, 10);
        log.info("swap(list,0,10) "+arl);
        list_instance.replace(arl, "0", "z");
        log.info("replace(l,0,z)  "+arl);
        list_instance.dealHand(arl, 1);
        log.info("dealHand(l,1)   "+arl);
        String expected = "value2";
        String actual = "value";
        assertEquals(expected,actual);
    }

}