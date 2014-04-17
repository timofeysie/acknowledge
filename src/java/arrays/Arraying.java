import java.util.List;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;

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

	public static void equalsTest()
	{
		// initializing three integer arrays
    	int[] arr1 = new int[] { 10, 12, 5, 6 };
    	int[] arr2 = new int[] { 10, 12, 5, 6 };
    	int[] arr3 = new int[] { 10, 5, 6, 12 };
    
    	// comparing arr1 and arr2
    	boolean retval=Arrays.equals(arr1, arr2);
    	System.out.println("arr1 and arr2 equal: " + retval);

    	// deepEquals method
    	int ROWS = 2;  
		int COLS = 3;  
		int grades[][] = new int[ROWS][COLS];  
		grades = new int[ROWS][]; // same as  
		grades[0] = new int[COLS]; // this  
		grades[1] = new int[COLS]; // and this  
		grades[0][0] = 0;  
		grades[0][1] = 1;  
		grades[0][2] = 2;  
		grades[1][0] = 3;  
		grades[1][1] = 4;  
		grades[1][2] = 5;  
		int grades2[][];  
	   
		grades2 = new int[ROWS][];   
		grades2[0] = new int[COLS];  
		grades2[1] = new int[COLS];  
		grades2[0][0] = 0;  
		grades2[0][1] = 1;  
		grades2[0][2] = 2;  
		grades2[1][0] = 3;  
		grades2[1][1] = 4;  
		grades2[1][2] = 5;  
		System.out.println(grades == grades2); // false  
		System.out.println(grades.equals(grades2)); // false  
		System.out.println(Arrays.equals(grades, grades2)); // false   
		System.out.println(Arrays.deepEquals(grades, grades2)); // true  		
	}

	public static void main(String[] args) 
	{
		decrementTest();
		nonWorking();
		System.out.println("~5 = "+(~5)+" + 1 = "+(~5+1));
		whatWorks();//?
		EpractizeQuestions();
		equalsTest();
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