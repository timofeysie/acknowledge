public class IntegerMethods
{
	
	public static void main(String[] args) 
	{
		Integer pos = 5;
		Integer neg = -5;
		int	pos_hob = Integer.highestOneBit(pos);
		int	neg_hob = Integer.highestOneBit(neg);
		System.out.println("positive highest one bit "+pos_hob);
		System.out.println("negative highest one bit "+neg_hob);
		System.out.println(Integer.toBinaryString(pos_hob));
		System.out.println(Integer.toBinaryString(neg_hob));
		String binary_65 = "01000000";
		int radix = 2;
		Integer num_65 = Integer.valueOf(binary_65, radix);
		System.out.println(binary_65+" = "+num_65);
		testEquality();
	}

	private static void testEquality()
	{
		Integer n1 = new Integer(0);
		Byte n2 = new Byte((byte)0);
		System.out.println("equals "+n1.equals(n2));
		System.out.println("==     "+(n1 == (int)n2));
		

		Integer aa = Integer.valueOf("12");
    	Integer bb = Integer.valueOf("12");
    	if(aa==bb)System.out.println("aa==bb");
    	if(aa!=bb)System.out.println("aa!=bb");
    	if(aa.equals(bb))System.out.println("aa.equals(bb)");
    	Integer ee = new Integer("12");
    	Integer ff = new Integer("12");
    	if(ee==ff)System.out.println("ee==ff");
    	if(ee!=ff)System.out.println("ee!=ff");
    	if(ee.equals(ff))System.out.println("ee.equals(ff)");
	}
}