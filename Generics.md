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




