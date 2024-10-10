interface A {
	double aMethod(int a);
}
interface B {
	double bMethod(int a, int b);
}

// class X extendes A { double aMethod(int a);}
// interface Y implements B { double bMethod(int x, int y);}
 interface Z extends A { float cMethod(int a, int b);}
 class P implements B { double aMethod(int a);}
 abstract class Q implements A, B {
	public double aMethod(int a) {return a * a * 5.16;}
}
