public class TestExceptions
{
	public static void main(String[] a)
	{
		try
		{
			method();
		} catch (Exception e) {}
	}

	static void method()
	{
		try
		{
			throw new NullPointerException();
		} catch (ArithmeticException e)
		{
			System.out.println("b");
		}
		finally 
		{ 
			System.out.println("c");
		}
		System.out.println("d");
	}
}