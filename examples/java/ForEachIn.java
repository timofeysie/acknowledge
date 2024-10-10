import java.util.Vector;
import java.util.Arrays;

public class ForEachIn
{
	
	public static void main(String[] args) 
	{
		Vector <String> vector = new Vector<String>();
		vector.add("one");
		vector.add("two");
		vector.add("three");
		vector.add("four");
		vector.add("five");

		for (Object num : vector)
		{
			//String num = vector.get(i);
			System.out.println(num);
		}
		//Arrays.deepToString(vector.get(i));
	}

}