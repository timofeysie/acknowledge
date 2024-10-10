//package generics;

public class Util 
{
    // Generic static method
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) 
    {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }

    /**
    * Unbounded wildcard generic print method.
    */
    public static void printList(List<?> list) 
    {
    	for (Object elem: list)
        System.out.print(elem + " ");
    	System.out.println();
	}

	/**
	* Upper bounded wildcard method.
	* Sum of any type of numbers.
	*/
	public static double sumOfList(List<? extends Number> list) 
	{
    	double s = 0.0;
    	for (Number n : list)
        	s += n.doubleValue();
    	return s;
	}	


	/**
	* Lower bounded wildcard method.
	* A method that works on lists of Integer and the supertypes of Integer,
	* such as Integer, Number, and Object
	*/
	public static void addNumbers(List<? super Integer> list) 
	{
    	for (int i = 1; i <= 10; i++) 
    	{
        	list.add(i);
        }
    }

}

	public static void main(String[] args) 
	{
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);

		System.out.println("sum of Integers = " + sumOfList(li));
		//A list of Double values can use the same sumOfList method. 
		//The following code prints sum = 7.0:
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum of Doubles = " + sumOfList(ld));
	}

}