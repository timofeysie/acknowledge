/**
* Synonyms for random:
* haphazard, chance accidentalstar
* indiscriminate desultory promiscuous
*/
public class Aimless
{
	

	public static void main(String[] args) 
	{
		int a = 1;
		int b = 3;
		int result = a % b;
        System.out.println(a+" % "+b+" = "+result+" from the remainder operator");
    
        System.out.println(++a); // 2
        System.out.println(a++); // 2.  will be 3 on next use.
        System.out.println(a); // 3

        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println("bitwise AND: 0x000F & 0x2222 = ");
        System.out.println(val & bitmask);

        int x=0b101;
		int y=0b110;
		int z=~y;

        System.out.println("~"+y+" = "+~y);
        System.out.println("~"+Integer.toBinaryString(y)+" = "+Integer.toBinaryString(z));
        
        Aimless desultory = new Aimless();
        desultory.bitwise();
    }

    private void bitwise()
    {
     int a = 60;	/* 60 = 0011 1100 */  
     int b = 13;	/* 13 = 0000 1101 */
     int c = 0;

     c = a & b;       /* 12 = 0000 1100 */ 
     System.out.println(a+" & "+b+" = " + c+" bitwise AND");
     System.out.println(Integer.toBinaryString(a)+" & "+Integer.toBinaryString(b)+" = " + Integer.toBinaryString(c)+" binary");
     c = a | b;       /* 61 = 0011 1101 */
     System.out.println(a+" | "+b+" = " + c+" bitwise inclusive OR");
     System.out.println(Integer.toBinaryString(a)+" | "+Integer.toBinaryString(b)+" = " + Integer.toBinaryString(c));
     c = a ^ b;       /* 49 = 0011 0001 */
     System.out.println(a+" ^ "+b+" = " + c+" bitwise exclusive OR");
     System.out.println(Integer.toBinaryString(a)+" ^ "+Integer.toBinaryString(b)+" = " + Integer.toBinaryString(c));
     c = ~a;          /*-61 = 1100 0011 */
     System.out.println("~"+a+" = " + c+" unary bitwise complement operator");
     System.out.println("~"+Integer.toBinaryString(a)+" = " + Integer.toBinaryString(c));
     c = a << 2;     /* 240 = 1111 0000 */
     System.out.println(a+" << 2 = " + c+" signed left shift operator");
     System.out.println(Integer.toBinaryString(a)+" << "+Integer.toBinaryString(2)+" = " + Integer.toBinaryString(c));
     c = a >> 2;     /* 215 = 1111 */
     System.out.println(a+" >> 2  = " + c+" signed right shift");
     System.out.println(Integer.toBinaryString(a)+">> "+Integer.toBinaryString(2)+"  = " + Integer.toBinaryString(c));
     c = a >>> 2;     /* 215 = 0000 1111 */
     System.out.println(a+" >>> 2 = " + c+" unsigned right shift operator");
     System.out.println(Integer.toBinaryString(a)+" >>> "+Integer.toBinaryString(2)+" = " + Integer.toBinaryString(c));
  }


}