class Inner
{
	public static void main(String[] args) 
	{
		Inner inner = new Inner();
		inner.new Outer().innerMethod();
	}

	final int num = 2399;

	class Outer
	{
		int num = 9932;
		void innerMethod()
		{
			System.out.println(Inner.this.num);
			System.out.println(this.num);
		}
	}
}