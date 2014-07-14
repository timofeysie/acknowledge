interface A {}
class B implements A {}
class C extends B {}
class D {}
class E extends D {}
public class Test16 {
	public static void main(String[] args) {
			A a1 = new B();
			A b1 = new C();
			a1 = b1;
			C b2 = (C)a1;
			/*
			// A a2 = (A) new D(); // Runtime ClassCastException
			//D d3 = new D();
			//E e1 = (E)d3; // Compile Error: inconvertable types
			//D d4 = new D();
			//E e1 = (E)d4; // runtime error: D cannot be cast to D
			//F f2 = (Test16)d4; // compile time error. required Test16, found D.
			A a_b = new B();
			A a_c = new C();
			a_b = a_c; // all OK.
			C c_c = (C)a_b;
			//A a_a_d = (A) new D(); // runtime error: D cannot be cast to an A.
			D d_d = new D();
			E e_e_d = (E)d_d; // runtime error: D cannot be cast to E
			*/
		}	
}
/*
class A {} // D
class B extends A {} // E extends D
class C {}
		A a = new A();
		B b = (B)a; // runtime java.lang.ClassCastException
		B b = (C)a; // compile time error incompatible types

class A {} // now D
class B extends A {} Now E
public class Test15
{
	public static void main(String[] args) {
		A obj1 = new A(); // D d3 = new D();
		B obj2 = (B)obj1; // E e1 = (E)d3;
	}
}

Here, Phone becomes D, and Roamable becomes A
interface RoamableA {}
class Phone {}
public class Tablet extends Phone implements Roamable {
    public static void main(String... args) {
        Roamable var = (Roamable) new Phone();
    }
}
*/