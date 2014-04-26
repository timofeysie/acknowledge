interface A {}
class B implements A {}
class C extends B {}
public class Test16 {
	public static void main(String[] args) {
			A a1 = new B();
			A b1 = new C();
			a1 = b1;
			C b2 = (C)a1;
		}	
}