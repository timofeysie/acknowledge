Generics
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

