public class Test11
{
	int subTotal;
	static int total;
	public void calculate()
	{
		int local;
		local = this.total; //1
		local = this.subTotal; //2
		this.total = total; //3
		//this.local = 4; // 4
		//this = new Test11(); // 5
	}

	public static void main(String ... args) 
	{
		Integer  arg = 30;
		switch(arg)
		{
			default:
				System.out.println("default"); // seems unreachable
			case 10:
				System.out.println("100");
			case 20:
				System.out.println("200");
		}
		Character c = new Character('c');
		Character n = null;
		//boolean equ = c.equals(n);
		//int compare = c.compareTo(n);
		Character a = new Character('a');
		boolean equ = c.equals(a);
		int compare = c.compareTo(a);
		System.out.println(equ+" "+compare);

	}
}