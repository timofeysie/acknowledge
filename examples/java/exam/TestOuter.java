class TestOuter
{
	static Integer num = 200;

	TestOuter()
	{
		num = 400;
	}

	static class TestInner
	{
		TestInner()
		{
			System.out.print(num);
		}
	}

	public static void main(String[] args) {
		//TestOuter to = new TestOuter();
		//new TestOuter().TestInner(); error: cannot find symbol TestInner()
		new TestOuter.TestInner();
	}
}