interface I{}
class A implements I{}
class B extends A {}
class C extends B{}
public class Test20
{
	public static void main(String[] args) {
		A a = new A();
		B b = new B(); 
		// a = (B)(I)b;
		a = (I)b; // incompatible types: required A, found I
	}
}