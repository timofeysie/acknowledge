# Generics #
- For generics to work, you need to supply objects, not primitives.
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
- the T in Foo<T> is a type parameter
- the String in Foo<String> f is a type argument.  
- An invocation of a generic type is generally known as a parameterized type.
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
	List<String> listOne = Collections.<String>emptyList();

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


