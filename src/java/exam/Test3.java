import java.util.*;

class Test3
{
	public String toString() {
		return "Test3";
	}

	public static void main(String[] args) 
	{
		//firstTest();
		//secondTest();
		thirdTest();
	}

	private static void thirdTest()
	{
		Set<Test3> s = new HashSet<Test3>();
		s.add(new Test3()); // Test3 cannot be cast to Comparable.
		s.add(new Test3());
		s.add(new Test3());
		for (Test3 out: s)
			System.out.println(out);
	}

	private static void secondTest()
	{
		ArrayList<Object> a = new ArrayList<>();
		a.add(new A());
		a.add(new B());
		a.add(new C());
		for (Object object:a)
			System.out.println(object);
	}

	/**
	*Runtime exception: ClassCastException: Test3 cannot be cast to Comparable.
	*Either Test3 has to implement Comparable, or you need to provide a comparator when creating the TreeSet.
	*/
	private static void firstTest()
	{
		Set<Test3> s = new TreeSet<Test3>();
		s.add(new Test3()); // Test3 cannot be cast to Comparable.
		s.add(new Test3());
		s.add(new Test3());
		for (Test3 out: s)
			System.out.println(out);
	}
}

class A{}
class B extends A{}
class C extends B{}