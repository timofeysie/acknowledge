package seven.one.mathical;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Locale;
import java.text.*;

public class Format{

    static Logger log = Logger.getLogger(Format.class);

  static public void customFormat(String pattern, double value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      System.out.println(value + "  " + pattern + "  " + output);
  }
    
  public void entryPoint() 
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
      System.out.format("%08d%n", n);    //  -->  "00461012"
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
        double e = 43.32;
        double f = -4.5;
        int c = 16, d = 45;
        log.info("Basic Math Methods ---");
        log.info("Absolute: Returns the absolute value of the argument.");
        log.info(String.format("Math.abs(%.3f) = %.3f%n",a,Math.abs(a)));
        log.info(String.format("Math.abs(%.3f) = %.3f%n",f,Math.abs(f)));
        log.info("Ceiling: Returns the smallest integer that is greater than or equal to the argument.");
        log.info(" Returned as a double.");
        log.info(String.format("Math.ceil(%.2f) = %.0f%n",b,Math.ceil(b)));
        log.info(String.format("Math.ceil(%.2f) = %.0f%n",e,Math.ceil(e)));
        log.info(String.format("Math.ceil(%.2f) = %.0f%n",f,Math.ceil(f)));
        log.info("Floor: Returns the largest integer that is less than or equal to the argument.");
        log.info(" Returned as a double.");
        log.info(String.format("Math.floor(%.2f) = %.0f%n",b,Math.floor(b)));
        log.info(String.format("Math.floor(%.2f) = %.0f%n",f,Math.floor(f)));
        log.info("R(Rounded)Integer: Returns the integer that is closest in value to the argument.");
        log.info("Returned as a double.");
        log.info(String.format("Math.rint(%.2f) = %.0f%n",b,Math.rint(b)));
        log.info(String.format("Math.rint(%.2f) = %.0f%n",e,Math.rint(e)));
        log.info("Min and Max of two numbers:");
        log.info(String.format("Math.max(%d,%d) = %d%n",c,d,Math.max(c, d)));
        log.info(String.format("Math.min(%d,%d) = %d%n",c,d,Math.min(c, d)));
        log.info("long round(double d) or int round(float f)");
        log.info("Returns the closest long or int, as indicated by the method's return type, to the argument:");
        //log.info(String.format("Math.round(%.2f) = %.0f%n",b,Math.round(b)));
        //log.info(String.format("Math.round(%.2f) = %.0f%n",e,Math.round(e)));
        double a1 = -1.5;
        log.info("Math.round("+b+") = "+Math.round(b));
        log.info("Math.round("+e+") = "+Math.round(e));
        log.info("Math.round("+a1+") = "+Math.round(a1));
        log.info("Math.rint("+a1+") = "+Math.rint(a1));
        /*
        double d1 = 100.675;
      double e1 = 100.500;
      float f1 = 100;
      float g1 = 90f;

      System.out.println(Math.round(d1));
      System.out.println(Math.round(e1)); 
      System.out.println(Math.round(f1)); 
      System.out.println(Math.round(g1)); 
      */
      }

    private static void logarithmicMethods()
    {
        System.out.println("logarithmic methods ---");
        double x = 11.635;
        double y = 2.76;
        log.info(String.format("The value of " + "E is %.4f%n",
                          Math.E));
        System.out.println("E is the base of natural logarithms");
        log.info(String.format("exp(%.3f) " + "is %.3f%n",
                          x, Math.exp(x)));
        log.info(String.format("log(%.3f) is " + "%.3f%n",
                          x, Math.log(x)));
        log.info(String.format("pow(%.3f, %.3f) " + "is %.3f%n",
                          x, y, Math.pow(x, y)));
        log.info(String.format("sqrt(%.3f) is " + "%.3f%n",
                          x, Math.sqrt(x)));
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