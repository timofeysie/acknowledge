/** Virtual Method Invocation = Polymorphism */
class A {public A(){System.out.println("a");}
	public String toString(){return("A");}}
class B extends A {public B(){System.out.println("b");}
	public String toString(){return("B");}}
class C extends B {public C(){System.out.println("c");}
	public String toString(){return("C");}}
class D {public static void main(String [] args)
{A a = new B();System.out.print(a.toString());
 C c = new C();System.out.print(c.toString());}}