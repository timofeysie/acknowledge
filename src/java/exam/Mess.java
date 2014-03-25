class Mess
{
	public static void main(String[] args) 
	{
		String ex = "example";
		System.out.println(ex+" length "+ex.length());
		for (int i =0;i<ex.length();i++)
		{
			System.out.println(i+" "+ex.charAt(i));
		}
		int j =2;
		switch (j)
		{
			case 1:System.out.println("1");
			case 2:System.out.println("2");
			case 3:System.out.println("3");
			case 4:System.out.println("4");
				break;
			case 5:System.out.println("5");
		}

		System.out.println("Bitwise exclusive OR ^");
		int a = 1;
		int b = 2;
		if(args.length == 2)
		{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		for (int i = 0; i <=b; i++)
		{
			int test = a | i;
			//System.out.println(a+" ^ "+i+" = "+test);
			System.out.println(Integer.toBinaryString(a)+"	"+a);
			System.out.println(Integer.toBinaryString(i)+"	"+i);
			System.out.println(Integer.toBinaryString(test)+"	"+test);
			System.out.println("");

		}
		//for (int c = Integer.parseInt("00000",2);c<=Integer.parseInt("10000",2);c++)
		//	System.out.println(Integer.toBinaryString(c)+" "+c);

	}
}