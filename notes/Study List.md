Study List

- when you use an interface as a return type the object returned must implement the specified interface.

- byte: 8-bit min -128 max 127
- char: 16-bit min'\u0000' (or 0) max'\uffff' (65,535)
- short: 16-bit min -32,768 max 32,767
- int: 32-bit min -2,147,483,648(-2 tt 31)max 2,147,483,647(2 tt 31-1)
- float: 32-bit
- long: 64-bit min -2 tt 63 max 2 tt 63-1.
- double: 64-bit

byte 		8  If you Bite a
char/short  16 character it's shorter
int/float   32 inthe float but
long/double 64 longer in the double.

(Imagine biting an English letter so that the top half falls off and lands next to the bottom half. Now there is nothing floating above, but double and longer/wider down below.)

Instance override
Static hide.

- A subclass does not inherit the private members of its parent class. 
- virtual method invocation: (polymorphism aspect), call method referred to in a variable, not the method that is defined by the variable's type
```
class A(){String toString(print("A"));}
class B(){String toString(print("B"));}
class C(){public static void main(String [] args)
{
	A a = new B();
	a.toString(); // prints B
}
```

perators make expressions.
Expressions make statements.
Statements make blocks.
Operators -> Expressions -> Statements -> Blocks

```
Set<String> s = new HashSet<String>();
```
Referring to collections only by their interface prevents you from 
using any nonstandard operations.

nondestructive idioms, first copy:
Set<Type> union/inter/diff = new HashSet<Type>(s1);
union.addAll(s2);
intersection.retainAll(s2);
difference.removeAll(s2);

- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.


```
// Compile error cannot be referenced from a static context
Animal.testClassMethod()      - static Animal
Animal.testInstanceMethod()   - compile error
myAnimal.testClassMethod()    - static Animal Hidden
myAnimal.testInstanceMethod() - instance Cat
Cat.testClassMethod()         - static Cat
Cat.testInstanceMethod        - compile error
myCat.testClassMethod         - static Cat
myCat.testInstanceMethod      - instance Cat overriding

Animal.testClassMethod()      - static Animal
myAnimal.testClassMethod()    - static Animal Hidden
Cat.testClassMethod()         - static Cat
myCat.testClassMethod         - static Cat

Animal.testInstanceMethod()   - compile error
myAnimal.testInstanceMethod() - instance Cat
Cat.testInstanceMethod        - compile error
myCat.testInstanceMethod      - instance Cat overriding
```
            Class           Instance  
Animal      Animal          x  
myAnimal    Animal Hidden   Cat  
Cat         Cat             x  
myCat       Cat             Cat Overriding  

Add to inheritance
- If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. 
You can use the inherited members as is, replace them, hide them, or supplement them with new members:
- A nested class has access to all the private members of its enclosing class—both fields and methods. Therefore, a public or protected nested class inherited by a subclass has indirect access to all of the private members of the superclass.

###Nested Classes###  
Two types:  
1. Static nested classes
2. Non-static nested classes (inner classes(local/anonymous))
- two kinds of inner classes:
A. local classes
B. anonymous classes.
However, you cannot declare constructors in an anonymous class.

**The Three Kinds of Exceptions**  
1. Checked exceptions: subject to the Catch or Specify Requirement. All exceptions are checked exceptioSns, except for those indicated by Error, RuntimeException, and their subclasses.
2. Errors: exceptional conditions that are external (not subject to the Catch or Specify Requirement)
3. Runtime exceptions: exceptional conditions that are internal to the app(bugs, not subject to the Catch or Specify Requirement)
```
catch (IOException|SQLException ex) {
```
- If a catch block handles more than one exception type, then the catch parameter is implicitly final.
try-with-resources statement declares one or more resources.   Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
```
try (
        ZipFile zf = new ZipFile(zipFileName);
        BufferedWriter writer = newBufferedWriter(Path, charset)
    ) { ...
```
- the close() methods of resources are called in the opposite order of their creation.
- any catch or finally block is run after the resources declared have been closed.

Operators		Precedence    
postfix			expr++ expr--  
unary			++expr --expr +expr -expr ~ !  
multiplicative	* / %  
additive		+ -  
shift			<< >> >>>  
relational      < > <= >= instanceof  
equality        == !=  
bitwise AND     &  
bitwise exclusive OR    ^  
bitwise inclusive OR    |  
logical AND     &&  
logical OR      ||  
ternary         ? :  
assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=  
```
	int i = 1;
	int j = 1;
	int k = ++i * j++;  // ijk is 2-2-2
```	


Things to do:  
- overriding clone() example  
- TreeSet stores its elements in a red-black tree
- binary negative no. example, using ~
- Questions and Exercises: Nested Classes
- www.javapepare.com this site is for tests 5 and 6.  We need test 7!
Does it include IO and Concurrency?  Platfrom Environment or RegExps?
IO and COncurrency are definately on the Level II exam, but platform and regexp?  OK, Section 5, Item 2 has regexps.
- test this: The compiler copies initializer blocks into every constructor. can be used to share a block of code between multiple constructors. (Initialization)
