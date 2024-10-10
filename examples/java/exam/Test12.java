import java.util.Vector;

public class Test12
{
	static String name;
	static int number;
	static Object obj;
	static Vector <String> vec;

	public static void main(String[] args) 
	{
		int y;
		System.out.println("y before init "+y);
		y = 100;
		name = "Java Tiger";
		number = 13;
		obj = 13;
		vec = new Vector<>();

		System.out.println(name+" "+name.hashCode());
		change(name);
		System.out.println(name+" "+name.hashCode());

		System.out.println(number);
		change(number);
		System.out.println(number);

		System.out.println(obj+" "+obj.hashCode());
		change(obj);
		System.out.println(obj+" "+obj.hashCode());

		System.out.println(vec+" "+vec.size());
		change(vec);
		System.out.println(vec+" "+vec.size());
	}

	public static void change(String in)
	{
		in = in.substring(0,in.length()-3);
	}

	private static void change(int in)
	{
		in = 1;
	}

	private static void change(Object in)
	{
		in = 1;
	}

	private static void change(Vector<String> in)
	{
		in.add("one");
	}
}