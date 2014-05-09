class Base{
   void method1() throws java.io.IOException, NullPointerException{
      someMethod("arguments");
      // some I/O operations
   }
   int someMethod(String str){
      if(str == null) throw new NullPointerException();
      else return str.length();
   }
}
public class NewBase extends Base{
      void method1(){
           someMethod("args");
      }
      void method2(){
         System.out.println("method2");
      }
      public static void main(String[] args) {
         Base a = new Base();
         NewBase b = new NewBase();
         a = b;
         //a.methodo2(); cannot find symbol
         // b = a; // required NewBase
      }
}