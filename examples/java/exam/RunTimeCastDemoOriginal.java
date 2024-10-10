class X {}
class Y extends X {}
class Z extends Y {}
/**
* downcast: cast a reference along the class hierarchy in a direction from the root class towards the children or subclasses, 
* upcast:   cast from the sub classes towards the root, need not use a cast operator in this case.
*/
public class RunTimeCastDemoOriginal {
	public static void main(String args[]) {
		X x = new X();
		Y y = new Y();
		Z z = new Z();
		X xy = new Y(); // compiles ok (up the hierarchy) upcast
		X xz = new Z(); // compiles ok (up the hierarchy)
		Y yz = new Z();  
		//		Y y1 = new X();  // X is not a Y: incompatible type (siblings) 
		//		Z z1 = new X();  // X is not a Z: incompatible types (downcast, needs cast)
		X x1 = y; // compiles ok (y is subclass of X)
		X x2 = z; // compiles ok (z is subclass of X)
		//Y y1 = (Y) x; // compiles ok but produces runtime error: X cannot be cast to a Y
		//Z z1 = (Z) x; // compiles ok but produces runtime error
		Y y2 = (Y) x1; // compiles and runs ok (x1 is type Y)
		Z z2 = (Z) x2; // compiles and runs ok (x2 is type Z)
		Y y3 = (Y) z;  //   inconvertible types (siblings)
		// Z z3 = (Z) y;  //   inconvertible types (siblings) // runtime ClassCastException
		Object o = z;
		Object o1 = (Y) o; // compiles ok but produces runtime error (wrong!  no error)
	}
}