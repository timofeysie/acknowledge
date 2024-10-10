class Modulus
{
	
	public static void main(String[] args) 
	{
		int x = -13;
		int y = 64;
		if (args.length == 2)
		{
			x = Integer.valueOf(args[0]);
			y = Integer.valueOf(args[1]);
		}
		int i = x % y;
		System.out.println(x+" % "+y+" = "+i);
		// If you want to get a negative number for 
		// negative inputs then you can use this:
		int n = -10;
		int r = x % n;
		if (r > 0 && x < 0)
		{
    		r -= n;
		}
		// Likewise if you were using a language 
		//that returns a negative number on a negative
		// input and you would prefer positive:
		r = x % n;
		if (r < 0)
		{
    		r += n;
		}
	}

}