/**
* This will not compile due to the getName() method call.  The reference
* variable used to invoke the method is of type A.  The getName() method 
* is class A throws a Throwable, which is not handled at the place where
* it is invoked.  Even though the actual object at runtime is of type B,
* the compiler looks for a matching method in class A.  It finds the method
* in the superclass which declares to throw the Throwable and gives and error
* that Throwable should be caught or declared to be thrown.
*If we surround the getName() method call in a try catch block,
* then the class will compile:
*/
abstract class A {
	String name = "OCA Java SE 7";
	abstract String getName() throws Throwable;
}
class B extends A {
	String s = "OCP Java SE 7";
	String getName()throws Exception {
		if (true) throw new Exception("Error");return s;
	}
}
public class Test14 {
	public static void main(String[] args) {
		A obj = new B();
		try
		{
			System.out.println(obj.getName());
		} catch (Throwable t)
		{
			System.out.println("throwable");
		}
	}
}