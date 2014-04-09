class A
{
	int i = 1;
	public void method(){System.out.println("A.method "+i);}
	A(){System.out.println("A.<init>");}
}
public class B extends A
{
	int i = 2;
	public static void main(String argv[])
	{
		System.out.println("B.main");
		A ab = new B();
		System.out.println("ab.i "+ab.i);
		//System.out.println("this.i "+ab.this.i);
		ab.method();
	}
	public void method()
	{
		System.out.println("B.method() "+i);
	}
	B()
	{
		System.out.println("B.<init>");
	}
}