public class BitMask
{
	public static void main(String[] args) 
    {
      int bitmask = 0x0002;
      int val = 0x0012;
      // prints "2"
      System.out.println(val+" & "+bitmask+" = "+(val & bitmask));
      System.out.println("exclusive OR "+val+" ^ "+bitmask+" = "+(val ^ bitmask));
      System.out.println("inclusive OR "+val+" | "+bitmask+" = "+(val | bitmask));
      System.out.println("bitwise complement ~ "+val+" = "+(~val)+" flip the bits to a negative");
    }

}