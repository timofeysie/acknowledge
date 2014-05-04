public class AccountBal
{
	public int getBalance(Short amt){return amt*2;}
	public double getBalance(double amt){return amt*3;}
	//public long getBalance(long amt){return amt*4;}
	public static void main(String[] args) {
		AccountBal ac = new AccountBal();
		Double val = 20d;
		System.out.println(ac.getBalance(val));
		//test(10);
		//byte b = 1;
		//Byte b = 1;
		//Character c = 1;
		//Short s = 1;
		//float f = 1f;
		//Float f = 1f;
		//long l = 1L;
		test(val);
	}

	public static void test(Byte b) {System.out.println("Byte");}
	public static void test(byte b) {System.out.println("byte");}
	public static void test(Character b) {System.out.println("Character");}
	public static void test(char b) {System.out.println("char");}
	public static void test(Short b) {System.out.println("Short");}
	public static void test(short b) {System.out.println("short");}
	//public static void test(Integer b) {System.out.println("Integer");}
	//public static void test(int b) {System.out.println("int");}
	public static void test(Float b) {System.out.println("Float");}
	public static void test(float b) {System.out.println("float");}
	public static void test(Long b) {System.out.println("Long");}
	public static void test(long b) {System.out.println("long");}
	public static void test(Double b) {System.out.println("Double");}
	public static void test(double b) {System.out.println("double");}
}
/* float will not fit into a Float, but a double.  
 If we cancel out the double, then it will fit into the Float method.
 float to float, double, Float, end.
 Float Float, float, double, end.
 int to int, long, float, double, Integer, end.
 Integer to Integer, int, long, float, double, end
 byte to byte, short, int, long, float, double, Byte, end.
 Byte to Byte, byte, short, int...
 char to char, int, long, float, double, Character, end.
 Character to Character, char, int, long, float, double, end.
 short to short, int, long, float, double, Short, end.
 Short to Short, short, int, long, float, double, end.
 float double Float end.
 long to long, float, double, Long, end.
*/
