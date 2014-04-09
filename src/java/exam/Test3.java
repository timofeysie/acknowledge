import java.util.*;

class Test3
{
	public String toString() {
		return "Test3";
	}

	public static void main(String[] args) {
		Set<Test3> s = new TreeSet<Test3>();
		s.add(new Test3()); // Test3 cannot be cast to Comparable.
		s.add(new Test3());
		s.add(new Test3());
		for (Test3 out: s)
			System.out.println(out);
	}
	/**
	Either Test3 has to implement Comparable, or you need to provide a comparator when creating the TreeSet.
	 */
}