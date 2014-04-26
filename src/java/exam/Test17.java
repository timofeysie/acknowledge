class C extends A {public C() {System.out.println("C");}} // B
class A { public A(){System.out.println("A");}}
class B extends C {public B(){System.out.println("B");}}  // C
public class Test17 {
	public static void main(String[] args) {
			System.out.println("Test16");
			B c = new B();
			// prints ACB, (which is ABC)
		}	
}