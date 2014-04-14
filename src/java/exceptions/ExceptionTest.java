class ExceptionTest
{
	public static void main(String[] args) {
		try
		{
			String arg = args[0];
			System.out.println("arg 0 "+arg);
		} catch (Exception ne1) 
		{
			try
			{
				String arg2 = args[1];
				System.out.println("arg 2 "+arg2);
			} catch (Exception ne)
			{
				System.out.println("Finally block 1");
			}

		} finally 
		{
			System.out.println("Finally block 2");
		}
	}
}