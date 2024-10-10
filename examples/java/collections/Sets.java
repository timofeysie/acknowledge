import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class Sets {
    public static void main(String[] args) {
        Set<String> hash = new HashSet<String>();
        Set<String> tree = new TreeSet<String>();
        Set<String> link = new LinkedHashSet<String>();
        for (String a : args)
        {
            hash.add(a);
            tree.add(a);
            link.add(a);
            System.out.println(a);
        }
        System.out.println("HashSet       " +hash);
        System.out.println("TreeSet       " +tree);
        System.out.println("LinkedHashSet " +link);
    }
}