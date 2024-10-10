public class TestBasicInterface extends BasicAbstract
{
	public static void main(String[] args) 
	{
		TestBasicInterface tbi = new TestBasicInterface();
		tbi.method();
		tbi.method2();
	}

	@Override
	public void method2()
	{
		// from BasicAbstract
		constant2 = 2;
		System.out.println("constant2 set "+constant2);
	}
}