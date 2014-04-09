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
	}
}