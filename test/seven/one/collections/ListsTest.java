package seven.one.collections;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.concurrent.CopyOnWriteArrayList;

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

        List<String> array = new ArrayList<>();
        List<String> linke = new LinkedList<>();
        List<String> vecto = new Vector<>();
        List<String> copyo = new CopyOnWriteArrayList<>();

        for (String a : args)
        {
            array.add(a);
            linke.add(a);
            vecto.add(a);
            copyo.add(a);
        }

        log.info("ArrayList       " +array+" insertion order");
        log.info("LinkedList      " +linke+" \"");
        log.info("Vector          " +vecto+" \"");
        log.info("CopyOnWriteArrayList "+copyo+" ?");

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

        log.info("Maps");
        Map <String,String> hash_map = new HashMap<>();
        Map <String,String> tree_map = new TreeMap<>();
        Map <String,String> link_map = new LinkedHashMap<>();
        String [] args2 = {"J","I","H","G","F","E","D","C","B","A","K"};
        for (String a : args)
        {
            hash_map.put(a,args2[Integer.parseInt(a)]);
            tree_map.put(a,args2[Integer.parseInt(a)]);
            link_map.put(a,args2[Integer.parseInt(a)]);
        }
        log.info("Enhanced For Loop: HashMap");
        for(Map.Entry<String, String> entry : hash_map.entrySet())
        {
            log.info(entry.getKey() + ": "+entry.getValue());
        }

        log.info("Enhanced For Loop: TreeMap");
        for(Map.Entry<String, String> entry : tree_map.entrySet())
        {
            log.info(entry.getKey() + ": "+entry.getValue());
        }

        log.info("Iterators");
        Iterator it1 = hash_map.entrySet().iterator();
        Iterator it2 = tree_map.entrySet().iterator();
        Iterator it3 = link_map.entrySet().iterator();
        log.info("HashMap       TreeMap     LinkedHashMap");
        while (it1.hasNext()) 
        {
            Map.Entry pairs1 = (Map.Entry)it1.next();
            Map.Entry pairs2 = (Map.Entry)it2.next();
            Map.Entry pairs3 = (Map.Entry)it3.next();
            log.info(pairs1.getKey() + " = " + pairs1.getValue()+"          "
                +pairs2.getKey() + " = " + pairs2.getValue()+"      "
                +pairs3.getKey() + " = " + pairs3.getValue());
        }

        assertEquals(expected,actual);
    }

}