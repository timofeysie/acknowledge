import java.util.*;

public final class PrimeAlgorithm 
{

    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) 
    {

        for (; begin < end; ++begin)
            if (p.test(list.get(begin)))
                return begin;
        return -1;
    }

    // x > 0 and y > 0
    public static int greatestCommonDivisor(int x, int y) 
    {
        for (int r; (r = x % y) != 0; x = y, y = r) { }
            return y;
    }
}