class SomeClass 
{
	void method1() { }
	public void method2() { }
	private void method3() { }
	protected void method4() { }
}
public class SomeClassAccessDemo 
{
	public void someMethod(String[] parameters) 
	{
		SomeClass sc = new SomeClass();
		sc.method1();
		sc.method2();
		sc.method3(); // only private methods are not visible.
		sc.method4();
	}
}