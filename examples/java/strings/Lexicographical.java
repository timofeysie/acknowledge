import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Collections;

public class Lexicographical
{
	
	public static void main(String[] args) 
	{
		String [] order = createArray();
		Map <Integer,String> map = createMap(order);
		Map<Integer, String> sorted_map = new TreeMap<Integer, String>(map);
		final Enumeration<Integer> e = Collections.enumeration(sorted_map.keySet());
		while(e.hasMoreElements()) 
		{
    		System.out.println(map.get(e.nextElement()));
 		}
 		// reverse order
 		
		/*
 		// reverse order
 		ArrayList li = sorted_map.
		Iterator<Integer> e = Collections.iterator(sorted_map.keySet());
		while(e.hasPrevious()) 
		{
    		System.out.println(map.get(e.previous()));
 		}
 		*/
	}

	private static Map <Integer,String> createMap(String [] order)
	{
		String z = "z";
		Map <Integer,String>map = new HashMap<>();
		for (int i = 0; i < order.length; i++)
			map.put(z.compareTo(order[i]), order[i]);
		return map;
	}

	private static String [] createArray()
	{
		String [] arr = new String[10];
		arr[0] = "cat";
		arr[1] = "bear";
		arr[2] = "ant";
		arr[3] = "dog";
		arr[4] = "emu";
		arr[5] = "girl";
		arr[6] = "iguana";
		arr[7] = "fox";
		arr[8] = "horse";
		arr[9] = "jaguar";
		return arr;
	}

}