public class Mock2
{
	public abstract class InnterTest
	{
		abstract void f();
	}
	public static void main(String[] args) {
		Mock2 m = new Mock2();
		Mock2.InnterTest test = m.new InnterTest()
		{
			public void f()
			{
				System.out.println("Inner f");
			}
		};
		test.f();
	}
}