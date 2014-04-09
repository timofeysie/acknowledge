import java.util.Vector;

public class Arraying
{

	private static void decrementTest()
	{
		int []a = {1,2,3,4,5,6};
		int i = a.length -1;
		while(i>=0)
		{
			System.out.println(a[i]);i--;
		}
	}

	private static void whatWorks()
	{
		// Given the following declaration of an array, 
		// which statement will display each element of the array?
		int arr[] = {1,2,3,4,5};
		System.out.println("a: error: .'class' expected"); 
		//for(int n : arr[]) { System.out.println(n); }
		System.out.print("b: ");  
		for(int n : arr) { System.out.print(n); }
		System.out.println();
		System.out.print("c: array index out of bounds");  
		//for(int n=1; n < 6; n++) { System.out.print(arr[n]);}
		System.out.println();
		System.out.print("d: array index out of bounds");  
		//for(int n=0; n <= 5; n++) { System.out.print(arr[n]);}
		System.out.println();
		System.out.print("e: ");  
		for(int n=0; n < arr.length; n++) { System.out.print(arr[n]);}
	}
	
	public static void main(String[] args) 
	{
		decrementTest();
		nonWorking();
		System.out.println("~5 = "+(~5)+" + 1 = "+(~5+1));
		whatWorks();//?
	}

	private static void nonWorking()
	{
		/*
		int i[] = new int[2] {1,2};
		int j[4] = {1,2,3,4};
		*/
		Vector<String> set = new Vector<String>();
		//String[] arr = set.toArray();
		String[] arr = (String [])set.toArray();
	}
}