interface BasicInterface
{
	public static final int constant1 = 1;
	public abstract void method();
}

abstract class BasicAbstract implements BasicInterface
{
	public int constant2;
	public void method() { System.out.println("constant1 "+constant1); }
	abstract void method2();
	// abstract synchronized not allowed!
}