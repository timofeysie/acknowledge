public class A {
    private int member = 20;

    private String method()
    {
      return "hello";
    }

    def publicMethod (String name_)
    {
      def localVar = member + 5;
      def localVar2 = "Parameter: ${name_}";
      return {
        println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
      }
    }
}
