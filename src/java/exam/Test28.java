class Super { static String ID = "QBANK"; }
class Junior extends Super { static {System.out.println("In Junior");}}
class Sub extends Junior { static { System.out.print("In Sub"); }}
public class Test28 extends Sub { public static void main(String[] args){
      System.out.println(Sub.ID);
      Test28 t28 = new Test28();
   }
}