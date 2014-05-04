public class Outer {
	public int a = 1;
	private int b = 2;
	public void method(final int c)
	{
		int d = 4;
		final int e = 5;
		class Inner
		{
			public void iMethod(int f)
			{
				System.out.println("which variables may be referenced here?");
				System.out.println("a "+a);
				System.out.println("b "+b);
				System.out.println("c "+c);
				System.out.println("d cannot be referenced.");
				System.out.println("e "+e);
				System.out.println("f "+f);
			}
		}
		Inner out_in = new Inner();
		out_in.iMethod(6);
	}
	public static void main(String[] args) 
	{
		Outer out = new Outer();
		out.method(3);
	}
}