import java.util.*;

class Test13
{
	public static void main(String[] args) {
		ArrayList<String> a =new ArrayList<String>();
		a.add("one");
		a.add("two");
		a.add("three");
		// String[] s = a.toArray(new String[3]);
		String[] s = (String[])a.toArray();
		for (String str:s)
		{
			System.out.println(str);
		}
	}
}