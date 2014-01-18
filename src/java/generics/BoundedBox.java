packacge generics;

public class BoundedBox<T> 
{

    private T t;          

    public void set(T t) 
    {
        this.t = t;
    }

    public T get() 
    {
        return t;
    }

    public <U extends Number> void inspect(U u)
    {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        BoundedBox<Integer> integerBox = new BoundedBox<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect("some text"); // error: this is still String!
    }
}

// multiple bounds:

<T extends B1 & B2 & B3>
// A type variable with multiple bounds is a subtype of all the types listed in the bound. If one of the bounds is a class, it must be specified first. For example:

Class A { /* ... */ }
interface B { /* ... */ }
interface C { /* ... */ }

class D <T extends A & B & C> { /* ... */ }
// If bound A is not specified first, you get a compile-time error:
class D <T extends B & A & C> { /* ... */ }  // compile-time error