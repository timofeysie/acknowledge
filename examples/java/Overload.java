public class Overload
{
	void aMethod(Object ob) { System.out.println("Object"); }
	void aMethod(String ob) { System.out.println("String"); }
	void aMethod(Float ob) {  System.out.println("Float"); }

	static void f(Object a, boolean b) {}
    static void f(int a, Object b) {}

    static void m(int a, boolean b) { f(a, b); } // ambiguous
    
	public static void main(String[] args) 
	{
		Overload overload = new Overload();
		overload.aMethod(0.0); // autoboxed as a Double object!
	}
}