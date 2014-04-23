public class IntegerTest
{

    public static void main(String[] args) 
    {
    	compare(127, 127);
    	compare(128, 128);
        int hex = 0x42; // 66
        int oct = 042;  // 34
        int oct2 = 052; // 42
        int bin = 0b101010; // 42
        System.out.println("hex "+hex+" oct "+oct+" bin "+bin+" oct2 "+oct2);
        System.out.println(Integer.valueOf("52",8)); // 42
    }

    private static void compare(Integer i1, Integer j1)
    {
    	if(i1 == j1)
    		System.out.println(i1+" same");
    	else
    		System.out.println(i1+" not same");
    }

}