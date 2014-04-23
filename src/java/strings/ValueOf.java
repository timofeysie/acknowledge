public class ValueOf 
{
    public static void main(String[] args) 
    {
        System.out.println("int i = 10;");
        System.out.println("int n = i++%5;");
        int i = 10;
        int n = i++%5;
        System.out.println("i "+i+" n "+n);
        System.out.println("int n = ++i%5;");
        i = 10;
        n = ++i%5;
        System.out.println("i "+i+" n "+n);
        // this program requires two 
        // arguments on the command line 
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue(); 
            float b = (Float.valueOf(args[1])).floatValue();
            // do some arithmetic
            System.out.println("a + b = " +(a + b));
            System.out.println("a - b = " +(a - b));
            System.out.println("a * b = " +(a * b));
            System.out.println("a / b = " +(a / b));
            System.out.println("a % b = " +(a % b));
        } else {
            System.out.println("This program " +
                "requires two command-line arguments.");
        }
        String tim1 = "Tim";
        StringBuffer tim2 = new StringBuffer("Tim");
        StringBuilder tim3 = new StringBuilder("Tim");
        assert !tim1.equals(tim2): "String and StringBuffer not equal";
        assert tim1.contentEquals(tim2): "Contents are not equal";
        assert tim1.contentEquals(tim3): "Builder contents are not equal";
    }
}