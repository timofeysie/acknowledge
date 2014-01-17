import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;
import generics.*;

public class Unboxing 
{

    public static void main(String[] args) 
    {

        // First, Auto-Boxing
        List<Integer> auto_boxing_li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            auto_boxing_li.add(i);
        System.out.println("Auto-Boxing, int to Integer: "+auto_boxing_li.get(1));

        // equivalent to:
        List<Integer> manual_boxing_li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            manual_boxing_li.add(Integer.valueOf(i));
        System.out.println("Manual-Boxing "+manual_boxing_li.get(1));
        
        // Now the Unboxing
        Integer i = new Integer(-8);
        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // (pi) is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double phi = ld.get(0);
        System.out.println("pi is autoboxed through method invocation: " + phi);

        System.out.println("");
        System.out.println("And now for something completely different,");
        System.out.println("Using the static import language feature, you don't have to write Math in front of every math function:");
        int angle = 90;
        System.out.println(cos(angle));


        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        // Due to autoboxing, is it valid to pass a String and an int to the class.
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");

        //  Due to The Diamond these statements can be shortened:
        OrderedPair<String, Integer> p11 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String>  p22 = new OrderedPair<>("hello", "world");

        // You can also substitute a type parameter (i.e., K or V) with a parameterized type (i.e., List<String>). 
        // For example, using the OrderedPair<K, V> example:
        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));


    }

    public static int absoluteValue(int i) 
    {
        return (i < 0) ? -i : i;
    }

}