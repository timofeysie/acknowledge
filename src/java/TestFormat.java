import java.util.Calendar;
import java.util.Locale;
import java.text.*;

public class TestFormat {

  static public void customFormat(String pattern, double value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      System.out.println(value + "  " + pattern + "  " + output);
  }
    
  public static void main(String[] args) 
  {
      int bitmask = 0x001B;
      int val = 0x0008;
      // prints "2"
      System.out.println(val+" & "+bitmask+" = "+(val & bitmask));
      System.out.println("exclusive OR "+val+" ^ "+bitmask+" = "+(val ^ bitmask));
      System.out.println("inclusive OR "+val+" | "+bitmask+" = "+(val | bitmask));
      System.out.println("bitwise complement ~ "+val+" = "+(~val)+" flip the bits to a negative");
    
        String it = "123";
        int len = it.length();
        System.out.println(it+" length "+len);
        
      System.out.println("byte "+Byte.MIN_VALUE+" "+Byte.MAX_VALUE);
      System.out.format("short %,8d "+" %,8d%n ", Short.MIN_VALUE, Short.MAX_VALUE);
      System.out.format("int %,8d "+" %,8d%n ", Integer.MIN_VALUE, Integer.MAX_VALUE);
      System.out.format("long %,8d "+" %,8d%n ", Long.MIN_VALUE, Long.MAX_VALUE);
      System.out.format("float %,8f "+" %,8f%n ", Float.MIN_VALUE, Float.MAX_VALUE);
      System.out.format("double %,8f "+" %,8f%n ", Double.MIN_VALUE, Double.MAX_VALUE);
      
      long n = 461012;
      System.out.format("%d%n", n);      //  -->  "461012"
      System.out.printf("%08d%n", n);    //  -->  "00461012"
      System.out.format("%+8d%n", n);    //  -->  " +461012"
      System.out.format("Comma separated: %,8d%n", n);    // -->  " 461,012"
      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"

      float f = 123456.789f;
      customFormat("###,###.###", 123456.789);
      customFormat("###.##", 123456.789);
      customFormat("000000.000", 123.78);
      customFormat("$###,###.###", 12345.67); 
      double pi = Math.PI;
      System.out.format("%f%n", pi);       // -->  "3.141593"
      System.out.format("%.3f%n", pi);     // -->  "3.142"
      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
      System.out.format(Locale.FRANCE,
                        "%-10.4f%n%n", pi); // -->  "3,1416"
      Calendar c = Calendar.getInstance();
      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
      System.out.format("%tD%n", c);    // -->  "05/29/06"
      System.out.format(Locale.KOREA, "%tY %tB %te%n", c, c, c);
      basicMathMethod();
      logarithmicMethods();
      trigonometricFunctions();
    }

    private static void basicMathMethod()
    {
        double a = -191.635;
        double b = 43.74;
        int c = 16, d = 45;
        System.out.println("Basic Math Methods ---");
        System.out.printf("The absolute value " + "of %.3f is %.3f%n", 
                          a, Math.abs(a));
        System.out.printf("The ceiling of " + "%.2f is %.0f%n", 
                          b, Math.ceil(b));
        System.out.printf("The floor of " + "%.2f is %.0f%n", 
                          b, Math.floor(b));
        // rint = Return integer closest to arg
        System.out.printf("The rint of %.2f " + "is %.0f%n", 
                          b, Math.rint(b));
        System.out.printf("The max of %d and " + "%d is %d%n",
                          c, d, Math.max(c, d));
        System.out.printf("The min of of %d " + "and %d is %d%n",
                          c, d, Math.min(c, d));
    }

    private static void logarithmicMethods()
    {
        System.out.println("logarithmic methods ---");
        double x = 11.635;
        double y = 2.76;
        System.out.printf("The value of " + "E is %.4f%n",
                          Math.E);
        System.out.println("E is the base of natural logarithms");
        System.out.printf("exp(%.3f) " + "is %.3f%n",
                          x, Math.exp(x));
        System.out.printf("log(%.3f) is " + "%.3f%n",
                          x, Math.log(x));
        System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",
                          x, y, Math.pow(x, y));
        System.out.printf("sqrt(%.3f) is " + "%.3f%n",
                          x, Math.sqrt(x));
    }

    private static void trigonometricFunctions()
    {
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        System.out.println("Trigonomic funtions ---");
        System.out.format("The value of pi " + "is %.4f%n",
                           Math.PI);
        System.out.format("The sine of %.1f " + "degrees is %.4f%n",
                          degrees, Math.sin(radians));
        System.out.format("The cosine of %.1f " + "degrees is %.4f%n",
                          degrees, Math.cos(radians));
        System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
                          degrees, Math.tan(radians));
        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", 
                          Math.sin(radians), 
                          Math.toDegrees(Math.asin(Math.sin(radians))));
        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", 
                          Math.cos(radians),  
                          Math.toDegrees(Math.acos(Math.cos(radians))));
        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", 
                          Math.tan(radians), 
                          Math.toDegrees(Math.atan(Math.tan(radians))));
    }

    public enum Sex 
    {
        MALE, FEMALE
    }

}