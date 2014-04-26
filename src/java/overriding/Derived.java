class Base {
	int i = 1999;
	public void aMethod() 
	{
		System.out.println("Base.amethod()");
	}
	Base() {
		aMethod();
		System.out.println("Base<init>");
	}
}
public class Derived extends Base {
	int i = -1;
	public static void main(String[] args) {
		Base b = new Derived();
		System.out.println(b.i);
		b.aMethod();
	}
	public void aMethod(){System.out.println("Derived.aMethod()");}
}