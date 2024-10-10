public class CountGenericObjects
{
   // generic method printArray                         
   public static < E > void printArray( E[] inputArray )
   {
      // Display array elements              
         for ( E element : inputArray )      
            System.out.printf( "%s ", element );
         System.out.println();
    }

    public static <E> int countElements(E[] inputArray, E elem)
   {         
        int count = 0;
        for (E element : inputArray)      
            if (element.equals(elem))
                ++count;
        return count;
    }

    public static <E> void exchangeElements(E[]array, E elem1, E elem2)
    {
        int index = 0;
        int position_1 = 0;
        int position_2 = 0;
        for (E element : array)
        {      
            if (element.equals(elem1))
                position_1 = index;
            else if (element.equals(elem2))
                position_2 = index;
        }
        array[position_1] = elem2; // ArrayStoreException
        array[position_2] = elem1;
    }

    public static void main( String args[] )
    {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = {1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,3,4,5,6,7,8,9,0};
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "Array integerArray contains:" );
        printArray( intArray  ); // pass an Integer array

        System.out.println( "\nArray doubleArray contains:" );
        printArray( doubleArray ); // pass a Double array

        System.out.println( "\nAfter switch:" );
        exchangeElements(doubleArray, 1.1, 4.4);
        printArray( doubleArray ); // pass a Double array

        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // pass a Character array
        int count = 5;
        if (args.length > 0)
            count = Integer.valueOf(args[0]);
        int counted = countElements(intArray, count);
        String ending = ".";
        if (counted>1)
            ending = "s."; 
        System.out.println( "Array integerArray contains "+countElements(intArray, count)+" "+count+ending);
    
        System.out.println("\nAfter switch:");
        exchangeElements(charArray, "H", "O");
        printArray(charArray); // pass a Double array
    } 
}