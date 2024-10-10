interface Runnable {}
interface Observer {}
class A implements Runnable{} 
class B extends A implements Observer {}  
public class Test21
{
	public static void main(String[] args) 
	{
		A a = new A();
		B b = new B();
		//Object o1 = a; Runnable r1 = o;
		Object o2 = a; Runnable r2 = (Runnable) o2;
		//Object o3 = a; Observer ob = (Observer) o;
		//Object o4 = b; Observer o2 = o;
		Object o5 = b; Runnable r3 = (Runnable) b;
		Object o6 = b; Runnable r4 = b;
		//b = a; will throw a compile error: incompatible types: required B, found A.
		//b = (B)a; will compile but throw a runtime error: java.lang.ClassCastException
	}
}