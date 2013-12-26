println "Closures"
println "In functional language parlance,"
println "such an anonymous code block might be referred to as "
println "an anonymous lambda expression in general "
println "or lambda expression with unbound variables "
println "or a closed lambda expression if it didn't contain "
println "references to unbound variables like threshold"
println "Groovy makes no such distinction."
println "syntax:"
println "{ [closureArguments->] statements }"
println "examples of valid clusres (or not, they all give errors):"
// { item++ } // this is ambiguous
// { def item -> item++ }
// L;{ item++ }
// ;{ item++ }
// { println it }
// { ++it }
// { name -> println name }
// { String x, int y -> println "hey ${x} the value is ${y}" }
{ reader ->
  while (true) 
  {
      def line = reader.readLine()
  }
}
println "The examples could definitely be made more real-life MWS"
println ""
println "properties of closures can be summarized in this manner:"
println ""
println "1. one implicit method (never specified): doCall()"
println "2. invoked via call() or an unnamed () which both call doCall()"
println "3. 1...N statically typed or untyped args. 1st parameter is" 
println "   an implicit untyped argument 'it' if none named."
println "   If no args it will be null."
println "4. The developer does not have to use it for the first parameter."
println "   If they wish to use a different name, they may specify it"
println "   in the parameter list."
println "5. Closures always return a value."
println "   This may occur via either an explicit return statement,"
println "   or as the value of the last statement in the closure body" 
println "  (e.g. an explicit return statement is optional)."
println "6. A closure may reference any variables defined within"
println "   its enclosing lexical scope. Any such variable is said"
println "   to be bound to the closure."
println "7. Any variables bound to a closure are available to the closure"
println "   even when the closure is returned outside of the enclosing scope."
println "8. Closures are first class objects in Groovy,"
println "   and are always derived from the class Closure."
println "   Code which uses closures may reference them via"
println "   untyped variables or variables typed as Closure."
println "9. The body of a closure is not executed until it is explicitly"
println "   invoked, e.g. a closure is not invoked at its definition time."
println "10. A closure may be curried so that a copy of the closure"
println "   is made with one or more of its parameters fixed to a constant"
println "   value."
println ""
println "varibale scope"
A sample = new A();
def closureVar = sample.publicMethod("Xavier");
closureVar();
println "the closure inside of publicMethodhas access to all variables "
println "that publicMethod may legally access."
println "the variables bound with the closure also live on."
println ""
println "This will not work:"
B aB = new B();
  closureVar = aB.bMethod("Xavier");
  closureVar();

println "we now have a class B which dynamically instantiates "
println "an object of type Aand then calls A.publicMethod()."
println "However, in this code the closure within publicMethod() "
println "is trying to reference a member from B, and this is "
println "not allowed since the compiler cannot statically determine "
println "that this is available."
println ""
println "the special owner variable which can be used when a "
println "closure argument is hiding an object member variable."
HiddenMember hm  = new HiddenMember()
hm.getClosure("Tim")
println "THis does nothing."
println ""
println "Closure creation and invocation"
println "Closures are created implicitly when their surrounding scope encounters them. "
println "For example, in the following code two closures are created:"
  C anA = new C();
  closureVar = anA.publicMethod("Xavier");
  closureVar();
  closureVar2 = anA.publicMethod("Xavier");
  closureVar2();
println "closureVar holds a reference to a different closure object than closureVar2"
println "you cannot new a closure programmatically"
println ""
println "explict call mechanism is to use the call() method:"
closureVar.call();
println ""
println "or the implict nameless invocation:"
closureVar();
println ""
println "Currying Closures"
println "Fixing Closure Arguments to Constant Values Via Currying"
println "You can fix the values for one or more arguments to a closure "
println "instance using the curry() method from the Closuretype."
println "KNown as currying in functional programming "
def c2 = { arg1, arg2-> println "${arg1} ${arg2}" }
def d2 = c2.curry("foo")
d2("bar")
println "See:"
println "http://groovy.codehaus.org/Functional+Programming+with+Groovy"
println ""
println "Special Case: Passing Closures to Methods"
println "if the last argument of a method is of type Closure, "
println "you may invoke the method with an explicit closure block "
println "outside of the parenthesis"
SomeCollection stuff = new SomeCollection();
  stuff.each() { println it }
println "In SomeCollection we added a body or get this error:"
println "You defined a method without a body"
println ""
println ""




