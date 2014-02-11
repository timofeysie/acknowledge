import java.util.*;

class OddPredicate implements UnaryPredicate<Integer> 
{
    public boolean test(Integer i) { return i % 2 != 0; }
}

public class OddPredicateTest 
{
    public static void main(String[] args) 
    {
        Collection<Integer> ci = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        int count = Algorithm.countIf(ci, new OddPredicate());
        System.out.println("Number of odd integers = " + count);
    }
}