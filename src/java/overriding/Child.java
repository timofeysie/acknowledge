/*
The variable p refers to the Child class object. 
The statement p.method2() on execution will first look for method2() 
in Child class. Since there is no method2() in child class, 
the method2() of Parent class will be invoked and thus Parent's 
method2() will be printed. Now from the method2() , there is a call 
to method1(). Please note that method1() of Parent class is private, 
because of which the same method (method1() of Parent class) will be
invoked. Had this method (method1() of Parent class) been 
public/protected/friendly (default), Child's class method1() 
would be called.
*/
class Parent
{
	void method1(){System.out.println("Parent1");}
	public void method2(){System.out.println("Parent2"); method1();}
}
class Child extends Parent
{
	public void method1(){System.out.println("Child1");}
	 public static void main(String args[])
	 {
	 	Parent p = new Child();
	 	p.method2();
	 }
}