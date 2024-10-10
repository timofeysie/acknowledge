class Inside {
	String name;
	public void change()
	{
		this.name = "changed by Inside";
	}
}

class Outside implements String
{
	String name;
	public void change()
	{
		this.name = "hange";
	}
}

public class Pass
{
	private void PassOut()
	{
		String name = "Java Tiger";
		System.out.println(name+" "+name.hashCode());
		change(name);
		System.out.println(name+" "+name.hashCode());
		StringBuffer name2 = new StringBuffer("Java Tiger");
		System.out.println("name1.equals(name2)? "+name.equals(name2));
		System.out.println(name2+" "+name2.hashCode());
		change(name2);
		System.out.println(name2+" "+name2.hashCode());
		Inside in = new Inside();
		in.name = "before";
		System.out.println("name: "+in.name);
		change(in);
		System.out.println("name: "+in.name);
		in.change();
		System.out.println("name: "+in.name);
	}

	public static void change(Inside in)
	{
		in.name = "changed";
	}
	public static void change(String in)
	{
		in = in.substring(0,in.length()-3);
		System.out.println(in+" "+in.hashCode());
	}
	public static void change(StringBuffer in)
	{
		in = in.append(" Milk");
		System.out.println(in+" "+in.hashCode());
	}

	public static void main(String[] args) {
		Pass p = new Pass();
		p.PassOut();
	}
}