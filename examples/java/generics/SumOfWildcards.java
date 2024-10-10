import java.util.List;
import java.util.ArrayList;

public class SumOfWildcards
{
	
	public static double sum(List<? extends Number> list)
	{
		double s = 0.0;
		for (Number n : list)
		{
			s += n.doubleValue();
			System.out.print(s+" ");
		}
		return s;
	}

	public static void main(String[] args) 	
	{
		int max = 10;
		if (args.length > 0)
			max = Integer.valueOf(args[0]);
		ArrayList <Integer>list = new ArrayList<>();
		for (int i = 0; i <= max; i++)
		{
			list.add(i);
		}	
		double sum = sum(list);
		System.out.println("");
		System.out.println("The sum of 1 to "+max+" is "+sum);
	}
}