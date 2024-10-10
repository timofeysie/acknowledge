class A {}
class B extends A {}
class C extends B {}
class D extends C {}
public class Test24
{
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		Object obj = b;
		if ((obj instanceof B) && !(obj instanceof C))
		{
			System.out.println("B true "+obj.getClass());

		}
		obj = c;
		if ((obj instanceof C) && !(obj instanceof D))
		{
			System.out.println("C true "+obj.getClass());

		}
		obj = d;
		if ((obj instanceof D) && !(obj instanceof C))
		{
			System.out.println("D true "+obj.getClass());
		}

	}
}