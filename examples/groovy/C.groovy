class C {
    private int member = 20;

    private method()
    {
      println ("hello");
    }

    def publicMethod (String name_)
    {
      def localVar = member + 5
      def localVar2 = "Parameter: name_";
      return {
        println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
        // nite the curly bracket after return must be there or else
        // an error is trhown.
      }
    }
}

