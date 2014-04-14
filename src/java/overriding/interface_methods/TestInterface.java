public class TestInterface
{
	public abstract class InnerTest
	{
		abstract void f();
	}

	public static void main(String[] args) {
		TestInterface t = new TestInterface();
		//t.f(); // cannot be found
		TestInterface.InnerTest test = t.new InnerTest()
		{
			public void f() 
			{ 
				System.out.println("Inner f");
			}
		};
		test.f(); // works fine
	}
}