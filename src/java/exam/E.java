class E
{
	int i;
	E(int i)
	{
		this.i = i;
	}
	protected void finalize()
	{
		System.out.println(i);
	}
	public static void main(String[] args) {
		E e1 = new E(5);
		e1.finalize();
		E e2 = new E(10);
		e1=null;e2=null;
		System.gc();
	}
}