println "Closures"
println "closures do not require a class or a method name."
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
println "The more traditional syntax is also available, "
println "and also note that in Groovy you can elide parenthesis "
println "in many situations, so these two variations are also legal:"
stuff = new SomeCollection();
  stuff.each { println it }     // Look ma, no parens
  stuff.each ({ println it })   // Strictly traditional

println ""
println "You cannot do this with a variable of type closure"
println "When you are not defining a closure inline to a method call, "
println "you cannot use this syntax"
//counter = {count, item -> count + item  }
//stuff.inject(0) counter               // Illegal!  No Groovy for you!
println ""
println "use the more verbose syntax:"
def counter = {count, item -> count + item  }
stuff.inject(0,counter)
println ""
println "Closures as keys"
println "You can use a closure as a key. However, when putting it into "
println "the map you must 'escape' it (as you would any other identifier "
println "you don't want treated as a string) by enclosing it in parens, like so:"
f = { println "f called" }
m = [ (f): 123 ]
println "When accessing the value of the closure in the map you must "
println "use get(f) or m[f] as m.f will treat f as a string."
println m.get(f)    // 123
println m[f]        // 123
println m.f         // null
println "Closures as values"
println "You can use a closure an a value and call that closure as if "
println "it were a method on the map, similarly to Expandos."
m = [ f: { println 'f called' } ]
m.f()    // f called
m = new Expando( f: { println 'f called' } )
m.f()      // f called
println ""
println "Extending groovy with the use directive"
println "You can provide your own specialized methods supporting closures "
println "by implementing a Java class containing such methods. "
println "These methods must be static and contain at least two parameters. "
println "The first parameter to the method must be the type on which "
println "the method should operate, and the last parameter must be "
println "a Closure type"
/*
dir = new File("/tmp")
use(ClassWithEachDirMethod.class) {
  dir.eachDir {
    println it
  }
}
*/
println "Button actin inner class"
println ""
println "Button b = new Button ('Push Me');"
println "  b.onClick (new Action()" 
println "{"
println "    public void execute (Object target)"
println "    {"
println "      buttonClicked();"
println "    }"
println "  });"
println ""
println "Streamlined Groovy version"
println ""
println "Button b = new Button ('Push Me');"
println "  b.onClick { buttonClicked() }"
println ""
println ""
import example.GVector
def gVect = new GVector()
gVect.add(2)
gVect.add(3)
gVect.add(4)
def c1 = { numberToSquare -> numberToSquare * numberToSquare }
gVect.apply(c1) // the elements in the GVector have all been squared.
println ""
c2 = { value -> println(value) }
gVect.apply(c2) // the elements in the GVector have all been printed.
println ""
gVect.apply{ value -> println(value) }  // elements in GVector have been printed.
println ""
import example.Employee
// no such property salary for class employess
def emps = [180, 140, 160].collect{ val -> new Employee(salary:val) }
println emps.size()           // prints 3
// println highPaid(emps).size() // prints 2  this is just an example
println "In this example, the closure block { e -> e.salary > threshold } "
println "refers to the threshold variable defined in the highPaid() method."
println " The example also used a closure to create the emps list."

println ""
println "There are cases you may want to take more arguments but "
println "not using varargs/Object[]. For example, as an API provider, "
println "you expose an API that take a closure as argument. "
println "The closure may define one or two parameters up to the user. "
println "(this is a typical case when passing JavaScript function) "
println "The following is an example about how to simulate such behaivior:"

/* Example Code
import example.User
// user code
def user1 = new User(username:'user1', password:'pass1', version:0)
update( user1, [
			password:
			{
				p,e-> Hash.md5(p, e.salt) 
			}, 
			version:
			{
				v-> v+1 
			}
		] //assume there is a MD5 util
)
*/
println ""
println "@DelegatesTo supports multiple modes:"
println "Simple delegation"
// def build(@DelegatesTo(BuilderItem) cl) { ... }}
//
println ""
println "Delegation strategy"
println "In this mode, you must specify both the delegate class and "
println "a delegation strategy. This must be used if the closure will "
println "not be called with the default delegation strategy, "
println "which is Closure.OWNER_FIRST.
def build(@DelegatesTo(strategy=Closure.DELEGATE_FIRST, value=BuilderItem) { ... }
println ""
println "Delegate to parameter"
println "In this variant, we will tell the compiler that we are delegating "
println "to another parameter of the method. Take the following code:

def exec(Object target, Closure code) {
   def clone = code.rehydrate(target, this, this)
   clone()
}"
println ""
def email = new Email()
exec(email) {
   from '...'
   to '...'
   send()
}
print;n ""
println "Each of the method calls are delegated to the email parameter. "
println "This is a widely used pattern which is also supported by "
println "@DelegatesTo using a companion annotation:"
def exec(@DelegatesTo.Target target, @DelegatesTo code) { ... }
println ""
import representing.Acknowledger
def acknowkledge = new Acknowkledge()
exec(greeter) 
{
   sayHello()
}