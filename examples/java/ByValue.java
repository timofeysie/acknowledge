public class ByValue
{
	void getValues(int[] arg1, int[] arg2) {
    	arg1[0] = 1;
    	arg2[0] = 2;
	}
	void caller() {
    	int[] x = new int[1];
    	int[] y = new int[1];
    	getValues(x, y);
    	System.out.println("Result1: " + x[0] + " " + y[0]);
	}

	public static void main(String[] args) 
	{
		ByValue bv = new ByValue();
		bv.caller();	
		SetValues sv = new SetValues();
		int[] x = new int[1];
    	int[] y = new int[1];
    	sv.getValues(x, y);
    	System.out.println("Result2: " + x[0] + " " + y[0]);

	}
}