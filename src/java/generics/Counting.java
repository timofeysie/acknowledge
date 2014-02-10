public class Counting <E>
{

	//private T t;

	/*
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) 
	{
    	int count = 0;
    	for (T e : anArray)
        	if (e.compareTo(elem) > 0)
            	++count;
    	return count;
	}
	*/

	/*
	public static <T extends Comparable<T>> int countEqualTo(T[] anArray, T elem) 
	{
    	int count = 0;
    	for (T e : anArray)
        	if (e.equals(elem))
            	++count;
    	return count;
	}
	*/

	public static <E> int countElements(E[] inputArray, E elem)
    {         
        int count = 0;
        for (E element : inputArray)      
            if (element.equals(elem))
                ++count;
        return count;
    }

	public static void main(String[] args) 
	{
		//Counting<Integer> count = new Counting<>();
		Integer search = Integer.valueOf(args[0]);
		Integer [] numbers = {1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1};
		int number_in_numbers = countElements(numbers, search);
		System.out.println("Numbers equal to "+search+": "+number_in_numbers);
		//int greater_than = count.countGreaterThan(numbers, search);
		//System.out.println("Numbers greater that "+search+": "+greater_that);
	}

}