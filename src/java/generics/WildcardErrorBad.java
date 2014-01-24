import java.util.List;

/**
* There is no helper method to work around the problem, 
* because the code is fundamentally wrong.
*
* While List<Integer> and List<Double> both fulfill the criteria 
* of List<? extends Number>, it is clearly incorrect to take an 
* item from a list of Integer values and attempt to place it into
* a list of Double values.
*
*/
public class WildcardErrorBad 
{

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) 
    {
      Number temp = l1.get(0);
      l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
                            // got a CAP#2 extends Number;
                            // same bound, but different types
      l2.set(0, temp);	    // expected a CAP#1 extends Number,
                            // got a Number
    }
}