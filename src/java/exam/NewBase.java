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
}