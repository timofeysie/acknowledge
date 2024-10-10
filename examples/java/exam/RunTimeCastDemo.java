class A {}
class B extends A {}
class C extends B {}
/**
* downcast: cast a reference along the class hierarchy in a direction from the root class towards the children or subclasses, 
* upcast:   cast from the sub classes towards the root, need not use a cast operator in this case.
*/
public class RunTimeCastDemo {
	public static void main(String args[]) {
		A a = new A(); // X
		B b = new B(); // Y
		C c = new C(); // Z
		A ab = new B(); // compiles ok (up the hierarchy) upcast B to A.
		A ac = new C(); // compiles ok (up the hierarchy) upcast C to A.
		B bc = new C(); // OK also. C to B upcast
		//	B ba = new A();   A is not a B, A to B downcast- needs cast
		//	C ca = new A();   A is not a C, ditto.
		A ab2 = b; // compiles ok (y is subclass of X) upcast
		A ac2 = c; // compiles ok (z is subclass of X) upcast
		// B bba = (B)a; // compiles ok but produces runtime error: A cannot be cast to a B
		// C cca = (C)a; // compiles ok but produces runtime error: A cannot be cast to a C
		B bb_ab2 = (B)ab2; // compiles and runs ok (ab2 is type B)
		C cc_ac2 = (C)ac2; // compiles and runs ok (x2 is type Z)
		B b3 = (B)c;  //   inconvertible types (siblings)
		//C c3 = (C)b;  //   inconvertible types (siblings) runtime error: B cannot be cast to C
		Object o = c;
		Object o1 = (B) o; // compiles ok but produces runtime error (Wrong! runs fine)
	}
}