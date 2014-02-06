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

        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // pass a Character array
        int count = Integer.valueOf(args[0]);
        int counted = countElements(intArray, count);
        String ending = ".";
        if (counted>1)
            ending = "s."; 
        System.out.println( "Array integerArray contains "+countElements(intArray, count)+" "+count+ending);
    } 
}