/** Virtual Method Invocation = Polymorphism */
class A {public A(){System.out.println("<init>a");}
	public String toString(){return("method A");}
	public static void toString(String msg){System.out.println(msg);}}
class B extends A {public B(){System.out.println("<init>b");}
	public String toString(){return("method B");}
	public static void toString(String msg){System.out.println(msg);}}
class C extends B {public C(){System.out.println("<init>c");}
	public String toString(){return("method C");}
	public static void toString(String msg){System.out.println(msg);}}
class D 
{
	public static void main(String [] args)
	{
		A a = new B();System.out.println(a.toString());
		A.toString("a_b static A.toString");
 		a.toString("a_b static a.toString");
		B b = new B();System.out.println(b.toString());
		B.toString("b_b static B.toString");
 		b.toString("b_b static b.toString");
 		C c = new C();System.out.println(c.toString());
 		C.toString("c_c static C.toString");
 		c.toString("c_c static c.toString");
 	}
}