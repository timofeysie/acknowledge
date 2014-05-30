package p2;
import p1.Parent;
public class Child extends Parent {
	public static void main(String [] args) {
		new Child().childMethod();
	}
	void childMethod() {
		System.out.print("This "+this.parentMethod());
		Parent p = new Parent();
		//System.out.prin(" parent "+p.parentMethod());
	}
}