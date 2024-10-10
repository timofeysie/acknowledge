package generics;

public class GenericAlgorithm 
{

    /*
	public static <T> int countGreaterThan(T[] anArray, T elem) 
	{
    	int count = 0;
    	for (T e : anArray)
        	//if (e > elem)  // compiler error, (>) applies only to primitive types
            //	++count;
    	return count;
	}*/

	// To fix the problem, use a type parameter bounded by the Comparable<T> interface:
	public interface Comparable<T> 
	{
    	public int compareTo(T o);
	}

    public interface Comparable2<I> 
    {
        public int compareTo(I o);
    }

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) 
	{
    	int count = 0;
    	for (T e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
    	return count;
	}

    public static <T extends Comparable<? super T>> int countGreaterThan2(T[] anArray, T elem) 
    {
        int count = 0;
        for (T e : anArray) 
        {
            if (e.compareTo(elem) > 0) 
            {
                ++count;
            }
        }
        return count;
    }

    public static <I extends Comparable2<I>> int countGreaterThan3(I [] anArray, I elem) 
    {
    int count = 0;
    for (I e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
        return count;
    }

    public static void main(String[] args) 
    {
        Integer [] anArray = {1, 2, 3, 4 , 5};
        Integer num = new Integer(5);
        int count = countGreaterThan(anArray, num);
        System.out.println(count);    
    }

}