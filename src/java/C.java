/** Virtual Method Invocation = Polymorphism */
class A {public String toString(){return("A");}}
class B extends A {public String toString(){return("B");}}
class C {public static void main(String [] args)
{
	A a = new B();
	System.out.print(a.toString());
	// cannot call methodC from a.
}
	public void methodC()
	{
		System.out.println("methodC"));
	}
}
// prints B because the jvm calls the appropriate method 
// for the object that is referred to in the variable, 
// not the method that is defined by the variable's type