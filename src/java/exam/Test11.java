public class Test11
{
	public static void main(String[] args) 
	{
		Integer  arg = 20;
		switch(arg)
		{
			default:
				System.out.println("default"); // seems unreachable
			case 10:
				System.out.println("100");
			case 20:
				System.out.println("200");
		}
	}
}