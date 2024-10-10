class A{
  public A() { System.out.println("A"); } // A1
  public A(String s) {  this();  System.out.println("A :"+s);  }  // A2
}

class B extends A{
  public int B(String s) {  System.out.println("B :"+s);  return 0; } // B1
}
class C extends B{
    private C(){ super(); } // C1 calls A1
    public C(String s){  this();  System.out.println("C :"+s);  } // C2
    public C(int i){} // C3
}
public class D {
	public static void main(String[] args) {
		C c = new C("hELLO");
		A a = new A();
		B b = new B();
		a = b;
		b = (B)a;
		c = (C)a;
	}
}