class Test5
{
	Integer num1;
	int num2;
	static Integer num3;
	static int num4;
	public static void main(String[] args) {
		Integer num = 9;
		Test5 t = new Test5();
		t.bMethod(num);
		t.num1 = 1;
		t.num2 = 2;
		t.aMethod(t.num2);
		t.bMethod(t.num1);
		System.out.println(num);
		System.out.println(t.num1);
		System.out.println(t.num2);
		t.cMethod(t);
		System.out.println("cMethod");
		System.out.println(t.num1);
		System.out.println(t.num2);

		num3 = 3;
		num4 = 4;
		dMethod(num3);
		eMethod(num3);
		dMethod(num4);
		eMethod(num4);
		System.out.println("Num3 "+num3);
		System.out.println("Num4 "+num4);
		System.out.println("cMethod");
	}
	public void aMethod(int a)
	{
		a=a++;
	}

	public void bMethod(Integer a)
	{
		a=a++;
	}

	public void cMethod(Test5 t)
	{
		t.num1+=1;
		t.num2+=1;
	}

	public static void dMethod(int a)
	{
		a=a++;
	}

	public static void eMethod(Integer a)
	{
		a=a++;
	}
}