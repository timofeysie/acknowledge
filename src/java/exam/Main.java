class A {A(){System.out.print("1st:Super ");}}
public class Main extends A
{
	public static void main(String[] args) {
		new Main(1L).Main();
		System.out.println();
		System.out.println("---");
		new Main().Main();
	}

	public Main(int x) {
		this();
		System.out.print(" 3rd:"+(x*2));
	}
	public Main(long x) {
		this((int)x);
		System.out.print(" 4th:"+x);
	}
	public Main() {
		super();
		System.out.print(" 2nd:No arg");
	}
	void Main() {
		System.out.print(" 5th: method");
	}
}