packacge generics;

{
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}

/**
 * Generic version of the Box class.
 * Type Parameter Naming Conventions
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 * @param <T> the type of the value being boxed
 */
public class Box<T> 
{
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}

public class SomeClass()
{

	public static void main(String[] args) 
	{
		// a generic type invocation, which replaces T with some concrete value, 
		// such as Integer:
		Box<Integer> integerBox;	
		// similar to an ordinary method invocation, but instead of 
		// passing an argument to a method, you are passing a type argument

		// will not compile
		//List<Number> numbers = new ArrayList<Integer>(); 
		// Generics does not support sub-typing which means 
		// that List is not considered to be a sub-type of List,
		// where S is a subtype of T. For example,

	}
}