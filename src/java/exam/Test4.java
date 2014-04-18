class A {
	int a =200;
	A(int b) {this.a=b;}
}
public class Test4 {
	static void a1(int a) {a=-1;}
	static void a1(A a) {a.a=-1;}
	public static void main(String as[]) {
	int a=100;
	a1(a);
	A b = new A(400);
	a1(b);
	System.out.print(a+" "+b.a);
	}
}