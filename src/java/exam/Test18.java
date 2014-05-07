public class Test18
{
	public static void main(String[] args)
	{
		testOne(args);
		testTwo(args);
	}

	private static void testOne(String[] args)
	{
		if (args[0].equals("open"))
			if (args[1].equals("someone"))
				System.out.println("Hello!");
		else System.out.println("Go away "+ args[1]);
	}
	private static void testTwo(String[] args)
	{
		if (args[0].equals("open"))
		{
			if (args[1].equals("someone"))
			{
				System.out.println("Hello!");
			}
		} else
		{
			System.out.println("Go away "+ args[1]);
		}
	}
	private static void testThree(String[] args)
	{
		if (args[0].equals("open"))
		{
			if (args[1].equals("someone"))
			{
				System.out.println("Hello!");
			} else
			{
				System.out.println("Go away "+ args[1]);
			}
		}
	}
}  