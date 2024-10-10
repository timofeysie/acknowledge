package seven.one.polymorphism;
class A {
	int var = 1;
	String str = "a";
	public A(){/*System.out.print("a");*/}
    public String toString(){return("A "+toString2());}
    private String toString2(){return("A2");}}
class B extends A {
	int var = 2;
	String str = "b";
	public B(){/*System.out.print("b");*/}
    public String toString(){toString2();return("B "+toString2());}
    public String toString2(){return("B2");}}
class C extends B {
	int var = 3;
	String str = "c";
	public C(){/*System.out.print("c");*/}
    public String toString(){return("C");}
	public String toString2(){return("C2");}}
class D {public static void main(String [] args)
{A a_b = new B();System.out.print(a_b.toString()+" "+a_b.var+" "+a_b.str);
 C c_c = new C();System.out.print(c_c.toString());
 //B b_a = new A();System.out.print(b_a.toString());
 //C c_a = new A();System.out.print(c_a.toString()); required new C()
 //C c_b = new B();System.out.print(c_b.toString()); "          "
}}
