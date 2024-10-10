public class Test8
{
	static String s1 = "Java";
	public static void main(String args[]) {
		String s2 = "Java";
		String s3 = new String(s1);
		System.out.println("1 "+(s1==s2));        // true
		System.out.println("2 "+(s1.equals(s2))); // true
		System.out.println("3 "+(s3==s1)); 	   	  // false
		System.out.println("4 "+(s3.equals(s1))); // true
		System.out.println("5 "+(Test9.s4==s1));  // true
	}
}
class Test9
{
	static String s4 = "Java";
}