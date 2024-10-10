interface I
{
	void m1();
}
abstract class Klass
{
	void m1() {}
}
class SubClass extends Klass implements I
{
	public void m1() {
		if (false) ; else ; 
		// if (true) else; else without if error
	}
	final static public void main (String[ ] arguments ) { }
}