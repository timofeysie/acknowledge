import java.util.*;

public final class MaximalAlgorithm
{
    public static <T extends Object & Comparable<?>>
        T max(List<? extends T> list, int begin, int end) 
    {
        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }

    public static void main(String[] args) 
    {
    	//Integer[] array = {0,1,2,3,4,5,6,7,8,9,10};
    	//List<Integer> ci = new ArrayList(array);
        List<MaxComparable> list = Arrays.asList(
            new MaxComparable(1),
            new MaxComparable(2),
            new MaxComparable(3),
            new MaxComparable(4),
            new MaxComparable(5));
    	Integer ret = max(list, 0, 4);  

    	// Error with current method. Child does not implement Comparable<Child>
        // int count = max(ci, 0, 10);
        System.out.println("Max "+ret);	
    }
}