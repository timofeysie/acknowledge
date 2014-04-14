import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

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

	private static void EpractizeQuestions()
	{
		// question 18
		int[] my_array[] = new int [10][10];
		if (my_array[0][0] == 0)
		{
			System.out.println("Inside IF");
		}

		// question 19
		//ArrayList<String> list = new ArrayList<String>();
		//list.add(new Integer(99));
		//System.out.println(list.get(0));
		//list.add(99);
		//int me = 99;
		//list.add(me);

		ArrayList list = new ArrayList();
		list.add(new Integer(99));
		//System.out.println(list.get(0));
		list.add(99);
		int me = 99;
		list.add(me);

		// question 20
		Integer arr[] = {2,1,0};
		//print(arr); required int[], found Integer[]

		// question 21
		List list2 = new ArrayList<String>();
		list2.add(new StringBuilder("123"));
		System.out.println("list2: "+list2);
	}
	
	public static void print(int...arr)
	{
		for (int i:arr)
		{
			System.out.println(i);
		}
	}

	public static void main(String[] args) 
	{
		decrementTest();
		nonWorking();
		System.out.println("~5 = "+(~5)+" + 1 = "+(~5+1));
		whatWorks();//?
		EpractizeQuestions();
	}

	private static void nonWorking()
	{
		/*
		int i[] = new int[2] {1,2};
		int j[4] = {1,2,3,4};
		*/
		Vector<String> set = new Vector<String>();
		//String[] arr = set.toArray();
		//String[] arr = (String [])set.toArray();
	}
}