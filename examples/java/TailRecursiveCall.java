public class TailRecursiveCall 
{
 
 	public int countA(String input) 
 	{
  		// exit condition – recursive calls must have an exit condition
  		if (input == null || input.length() == 0) 
  		{
   			return 0;
  		}
	  	return countA(input, 0) ;
 	}
  
 	public int countA(String input, int count) 
	{
		if (input.length() == 0) 
		{
	   		return count;
		}   
  		// check first character of the input
  		if (input.substring(0, 1).equals("A")) 
		{
   			count = count + 1;
  		}
   		// recursive call is the last call as the count is cumulative
  		return countA(input.substring(1), count);
 	}
 
 	public static void main(String[] args) 
	{
		System.out.println(new TailRecursiveCall().countA("AAA rating"));
	}

}
