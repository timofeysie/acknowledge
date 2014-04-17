class Test5
{
	public static void main(String[] args) {
		Interger num = 9;
		Test t = new Test();
		t.aMoethod(num);
		System.out.println(num);
	}
	public void aMethod(int a)
	{
		a=a++;
	}
}