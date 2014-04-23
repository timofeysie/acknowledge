import java.lang.*;

public class DoubleMethods {

   public static void main(String[] args) {

     Double d1 = new Double(-1.0/0.0);
     Double d2 = new Double(0.0/0.0);
  
     // returns true if this Double value is a Not-a-Number (NaN) 
     System.out.println(d1 + " = " + d1.isNaN()); // false
  
     // returns false for other cases
     System.out.println(d2 + " = " + d2.isNaN()); // true

     	double var = 0; // false
    	System.out.println(var+" is Not a Number? "+(var == Double.NaN));
    Double d3 = 20.5;
    Float f1 = 20.5f;
    assert d3.equals(f1): "Double Float equality";
   }
}  