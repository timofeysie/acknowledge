import java.util.Set;
import java.util.HashSet;

public class FindDups2 {
    public static void main(String[] args) {
        Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();
        for (String a : args)
        {
            boolean dup = false;
            boolean unique = uniques.add(a);
            if (!unique)
            {
                dup = dups.add(a);
            }
            System.out.println(unique+" "+dup+" "+a);
        }
        uniques.removeAll(dups); // Destructive set-difference
        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}