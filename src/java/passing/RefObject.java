/**
* When a metho which takes an object argument is invoked, the method obtains
* a copy of the object reference from the calling method.  So altering the
* object within the method affects the original object passed.  Hence the
* output "RefObject_200" will be printed.
* The method1() call merely sets the copy of the reference to null, but
* does not change the object, or the original reference to the object held
* in the refOb variable.
*/
public class RefObject {
	String class_name = "RefObject";
	RefObject() {
		className = "RefObject_200";
	}
	static void method1(Object ob) {
		ob = null;
	}
	public static void main(String[] args) {
		RefObject refOb = new RefObject();
		method1(refOb);
		System.out.println(RefOb.className);
	}
}