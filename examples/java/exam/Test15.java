/**
* The class compiles, but throws a runtime java.lang.ClassCastException: 
*  A cannot be cast to B.
* But if we were to change the cast to a different type of object, say Integer,
* then we would get a compile error: inconvertable types.
* required: Integer
* found: A
* So the compiler knows it should be A, but lets it pass at compile time.
*  Strange.  The notes from the exam state: The code trying to assign a
* super class object into a sublass object by type casting.  Hence it will
* throw ClassCastException at runtime.
* The runtime exception is the same for question 2.
*/
class A {}
class B extends A {}
class C {}
public class Test15
{
	public static void main(String[] args) {
		// question 1:
		A a = new A();
		B b = (B)a; // runtime java.lang.ClassCastException
		// question 2:
		A B = new A();
		B A = new B();
		// question 2 refigured:
		//A = (B)B;
		//A a = new A();
		//B b = new B();
		//b = (B)a;
		// test 1
		//A a = new A();
		//B b = (B)a;
		// test 2
		A a = new A();
		//B b = (C)a; // compile time error incompatible types
	}
}