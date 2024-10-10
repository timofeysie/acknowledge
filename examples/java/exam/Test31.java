public class Test31 {
	final Object obj;
	Test31() {
		obj = null; // 1
		System.out.println(obj instanceof Object); // 2
		Integer i = new Integer("1"); // 3
		//obj = i; // 4
	}
	public static void main(String args []) {
		Test31 example = new Test31();
		System.out.println(example.obj);
	}
}