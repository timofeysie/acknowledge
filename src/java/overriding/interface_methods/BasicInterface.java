interface BasicInterface
{
	public static final int constant = 1;
	public abstract void method();
}

abstract class BasicAbstract implements BasicInterface
{
	private int constant2;
	//public void method() { /** done **/ }
	abstract void method2();
	// abstract synchronized not allowed!
}