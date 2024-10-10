public class FinalInit
{
	final int i;
	FinalInit() {}
	FinalInit(int _i) {i = _i;}
	FinalInit(Object o) {i = 2;}
	public static void main(String[] args) 
	{
		FinalInit fi = new FinalInit();
		System.out.println("i is "+fi.i);
	}
}