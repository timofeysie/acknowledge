interface MyIface{};
class A {};
class B extends A implements MyIface{};
class C implements MyIface{};
public class MyFace
{
	public static void main(String[] args) 
	{
		A a = new A();
  		B b = new B();
  		C c = new C();
		//c = (C) b; 
		MyIface i = c;
	}
}