import java.util.*;

public final class MaximalAlgorithm
{
    public static <T extends Object & Comparable<? super T>>
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
    	List<Integer> ci = {0,1,2,3,4,5,6,7,8,9,10};
        int count = max(ci, 0, 10);
        System.out.println("max "+count);	
    }
}