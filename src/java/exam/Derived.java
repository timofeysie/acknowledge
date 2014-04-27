class Base
{
	int i = 1;
	String j = "base";
	public void amethod()
	{
		System.out.println("Base.amethod "+i+" "+j);
	}
	Base()
	{
		System.out.println("Base init");
		amethod();
	}
}
public class Derived extends Base
{
	int i = 2;
	String j = "derivitive";
	String k = "extended";
	public static void main(String argv[])
	{
		Base b = new Derived();
		System.out.println("main: intance created: "+b.i+" "+b.j);
		b.amethod();
		//b.anotherMethod(); //This method i+i+" "+js not visible to
		// an extended interface type reference.
		Derived d = new Derived();
		d.amethod();
		d.anotherMethod();
	}
	public void amethod()
	{
		System.out.println("Derived.amethod() "+i+" "+j);
	}
	public void anotherMethod()
	{
		System.out.println("Derived.anotherMethod() "+i+" "+j+" "+k);
	}
}