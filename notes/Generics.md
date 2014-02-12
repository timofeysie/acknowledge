# Generics #

- type parameters (also called type variables)
 * E - Element (used a lot by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
- A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.
- a generic type invocation, which replaces T with some concrete value, 
 such as Integer:
		Box<Integer> integerBox;	
- this invocation CANNOT BE STATIC because a class's static field is a class-level variable shared by all non-static objects of the class.
Similar to an ordinary method invocation, but instead of passing an argument to a method, you are passing a type argument.
- methods parameterized by type are called polymorphic methods.
- the T in Foo<T> is a type parameter
- the String in Foo<String> f is a type argument.  
- parameterized type = invocation of a generic type.
- To instantiate this class, use the new keyword, as usual, but place <Integer> between the class name and the parenthesis:
	Box<Integer> integerBox = new Box<Integer>();
- you can replace the type arguments required to invoke the constructor of a generic class with an empty set of type arguments (<>) as long as the compiler can determine, or infer, the type arguments from the context. This pair of angle brackets, <>, is informally called the diamond. 
    Box<Integer> integerBox = new Box<>();
- If the actual type argument is omitted, you create a raw type of Box<T>:
	Box rawBox = new Box();
- For backward compatibility, assigning a parameterized type to its raw type is allowed:
	Box<String> stringBox = new Box<>();
	Box rawBox = stringBox;               // OK
- But if you assign a raw type to a parameterized type, you get a warning:
	Box rawBox = new Box();           // rawBox is a raw type of Box<T>
	Box<Integer> intBox = rawBox;     // warning: unchecked conversion
- type inference, allows you to invoke a generic method as an ordinary method
PECS stands for producer extends, consumer super.
boolean addAll(Collection<? extends E> c)
This ? extends E makes sure that you can not only add collection of type E but also of subtype of E.  
List<Number> numbers = new ArrayList<Number>();
ArrayList<Integer> integers = new ArrayList<Integer>();
ArrayList<Long> longs = new ArrayList<Long>();
ArrayList<Float> floats = new ArrayList<Float>();
numbers.addAll(integers);
numbers.addAll(longs);
numbers.addAll(floats);
public static <T> boolean addAll(Collection<? super T> c, T... elements) ;
In this method you are adding elements of type T to the collection c. super is used instead of extends because elements are added into the collection c whereas in the previous example of Collection interface addAll method elements were read from the collection . 

- inference determines that the second argument being passed to the pick method is of type Serializable:
	static <T> T pick(T a1, T a2) { return a2; }
	Serializable s = pick("d", new ArrayList<String>());
- type witness specifies the type parameter to invoke the generic method addBox
BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
- Alternatively, if you omit the type witness, a Java compiler automatically infers (from the method's arguments) the type parameter 
	BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
- You can replace the type arguments required to invoke the constructor of a generic class with the diamond <>
- the inference algorithm uses only invocation arguments, target types, and possibly an obvious expected return type to infer types.
- The target type of an expression is the data type that the Java compiler expects depending on where the expression appears.
	static <T> List<T> emptyList();
...
	List<String> listOne = Collections.emptyList();
- This statement is expecting an instance of List<String>; this data type is the target type. 
- Alternatively, you could use a type witness and specify the value of T as follows:
	List<String> listOne = Collections.<String>emptyList()
	- ;

Multiple Bounds
	Class A { /* ... */ }
	interface B { /* ... */ }
	interface C { /* ... */ }
	class D <T extends A & B & C> { /* ... */ }
- If one of the bounds is a class, it must be specified first.
	class D <T extends B & A & C> { /* ... */ }  // compile-time error


# Wildcards #
- A wildcard parameterized type denotes a family of types comprising concrete instantiations of a generic type.  
- The kind of the wildcard being used determines which concrete parameterized types belong to the family. 
- A wildcard parameterized type is not a concrete type that could appear in a new expression.  A wildcard parameterized type is similar to an interface type in the sense that reference variables of a wildcard parameterized type can be declared, but no objects of the wildcard parameterized type can be created. 
	Collection<?> coll = new ArrayList<String>(); 
- unbounded wildcard parameterized types are An instantiation of a generic type where all type arguments are the unbounded wildcard
	Pair<?,?> and Map<?,?>
- Assignment of another instantiation to the unbounded wildcard instantiation is permitted without warnings; assignment of the unbounded wildcard instantiation to another instantiation is illegal. 
	ArrayList <?> anyList = new ArrayList<Long>();  
	ArrayList<String> stringList = new ArrayList<String>(); 
	anyList    = stringList; 
	stringList = anyList;      // error
- raw type and the unbounded wildcard parameterized type are semantically equivalent. But Certain operations performed on the raw type yield "unchecked" warnings, The same operations on unbounded wildcard parameterized type, errors. 
- Wildcard parameterized type can NOT be used for the following purposes (different from non-parameterized classes and interfaces): 
1. for creation of objects 
2. for creation of arrays (except unbounded wildcard)
3. in exception handling
4. in instanceof expressions (except unbounded wildcard)
5. as supertypes
6. in a class literal
- it is illegal that a wildcard parameterized type appears in a  new expression.
- a wildcard parameterized type is like an interface type:  you can declare reference variables of the type, but you cannot create objects of the type.
- Intgerfaces:
	Cloneable clon1 = new Date(); 
	Cloneable clon2 = new Cloneable();     // error
- Wildcard
	ArrayList<?> coll1 = new ArrayList <String> (); 
	ArrayList<?> coll2 = new ArrayList <?> (); // error
- concrete parameterized types are List<String> , Map<String,Date> , but not List<? extends Number> or Map<String,?> .


# Upper Bounded Wildcards #
	List<Number> 
is more restrictive than 
	List<? extends Number> 
because the former matches a list of type Number only, whereas the latter matches a list of type Number or any of its subclasses.
- The following matches Foo and any subtype of Foo. The process method can access the list elements as type Foo:
public static void process(List<? extends Foo> list) { /* ... */ }
public static void process(List<? extends Foo> list) {
    for (Foo elem : list) { /* ... */ }
}

	public void boxTest(Box<Number> n) { /* ... */ }
- you ARE NOT allowed to pass in Box<Integer> or Box<Double>!
- Box<Integer> is not a subtype of Box<Number> even though Integer is a subtype of Number. 
- generic classes or interfaces are not related merely because there is a relationship between their types. 
- However, you can use wildcards to create a relationship between generic classes or interfaces.
- The common parent of List<Number> and List<Integer> is List<?>

- wildcard capture. When the compiler infers the type of a wildcard. (and when you see an error message that contains the phrase "capture of", the compiler believes that you are assigning the wrong type to a variable)

- Guidelines for Wildcard Use (when to use an upper bounded wildcard and when to use a lower bounded wildcard)
 This page provides some guidelines to follow when designing your code.
- "In" Variables serve up data to the code. copy(src, dest).  The 'src' argument provides the data to be copied, so it is the "in" parameter.  defined with an upper bounded wildcard, using 'extends'.  when the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard.
- "Out" Variables hold data for use elsewhere. The 'dest' argument accepts data, so it is the "out" parameter.  lower bounded wildcard,   using 'super'.
- "Both" for "in" and "out" purposes, do not use a wildcard.
- Using a wildcard as a return type should be avoided because it forces programmers using the code to deal with wildcards. (So why is Java forcing programmers to deal with wildcards?) 
- type erasure Replaces all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
- type erasure Inserts type casts if necessary to preserve type safety.
Generate bridge methods to preserve polymorphism in extended generic types
- Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.
- During type erasure all type parameters are replaced with their first bound if the type parameter is bounded, or Object if the type parameter is unbounded.
- Type erasure has consequences related to variable arguments (varargs) methods whose varargs formal parameter has a non-reifiable type.
-  reifiable types' information is fully available at runtime. (primitives, non-generic types, raw types, and invocations of unbound wildcards)
- Non-reifiable typess information has been removed at compile-time by type erasure — invocations of generic types that are not defined as unbounded wildcards. A non-reifiable type does not have all of its information available at runtime. i.e: List<String> and List<Number>
- The JVM cannot tell the difference between these types at runtime
- non-reifiable types cannot be used: in an instanceof expression, for example, or as an element in an array.

- Heap pollution occurs when a variable of a parameterized type refers to an object that is not of that parameterized type and gives an unchecked warning at compile-time.
- If you ensure that your code compiles without warnings, then no heap pollution can occur.
- Generic methods that include vararg input parameters can cause heap pollution.
- Prevent Warnings from Varargs Methods with Non-Reifiable Formal Parameters, if you declare a varargs method that has parameters of a parameterized type, and you ensure that the body of the method does not throw a ClassCastException or other similar exception due to improper handling of the varargs formal parameter by adding the following annotation to static and non-constructor method declarations: @SafeVarargs

Restrictions on Generics
- Cannot Instantiate Generic Types with Primitive Types
	Pair<int, char> p = new Pair<>(8, 'a');  // compile-time error
	Pair<Integer, Character> p = new Pair<>(8, 'a'); // autoboxes 8 to Integer.valueOf(8) and 'a' to  new Character('a'):
- Cannot Create Instances of Type Parameters: There is a workaround however using reflection.  See BoxDemo.java
- The runtime does not keep track of type parameters, so it cannot tell the difference between an ArrayList<Integer> and an ArrayList<String>., so you Cannot Use Casts or instanceof with Parameterized Types.
- You cannot create arrays of parameterized types. If arrays of parameterized lists were allowed, the previous code would fail to throw the desired ArrayStoreException.
- Cannot Create, Catch, or Throw Objects of Parameterized Types.  You can, however, use a type parameter in a throws clause:
class Parser<T extends Exception> { 
	public void parse(File file) throws T { /* OK */ } }
- Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type.  A class cannot have two overloaded methods that will have the same signature after type erasure.

FAQ
- A generic anonymous class would be nonsensical.  Anonymous classes do not have a name, but the name of a generic class is needed for declaring an instantiation of the class and providing the type arguments.
- exception handling mechanism is a runtime mechanism and the Java virtual machine does not know anything about Java generics.
-  instantiations of a generic type share the same runtime type Because of type erasure.
	runtime type of ArrayList<String> : class java.util. ArrayList 
    runtime type of ArrayList<Long>   : class java.util. ArrayList
- upcasts, from a subtype up to a supertype, such as the casts from String to Object or from LinkedList<String> to List<String>  They are automatic conversions that the compiler performs implicitly, even without an explicit cast expression in the source code. if an upcast appears somewhere in the source code then it is a purely static (compile time) cast that does not have a dynamic (runtime - potentially unsafe) part.
-  we do not expect ClassCastExceptions when we extract an element from a list of strings.  This type of dynamic (implicit?) cast is considered a violation of the type-safety principle. the compiler emits "unchecked" warnings for every dynamic cast whose target type is a parameterized type.  Note that an upcast whose target type is a parameterized type does not lead to an "unchecked" warning, because the upcast has no dynamic part.

- you can, but you should not, declare a reference variable of an array type whose component type is a concrete parameterized type. it is neither helpful nor type-safe.
- use arrays of raw types, arrays of unbounded wildcard parameteriezd types, or collections of concrete parameteriezd types as a workaround.
- an array reference variable with parameterized component type): 

	Pair<String,String>[] arr = null;  // fine 
	arr = new Pair<String,String>[2] ; // error: generic array creation


