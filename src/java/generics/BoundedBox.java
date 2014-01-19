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

// if you to define constraint such as that the type should
// be a Number and it should implement Comparable.
public static <T extends Number & Comparable<? super T>> int compareNumbers(T t1, T t2)
{
    return t1.compareTo(t2);
}

//It makes sure that you can only compare two numbers which
// implement Comparable. Multiple bounds follows the same
// constraints as followed by the a class i.e. T can't extend
// two classes ,you have to first specify the class then the
// interface, and T can extend any number of interfaces.
public static <T extends String & Number > int compareNumbers(T t1, T t2) 
// does not work..can't have two classes

public static <T extends Comparable<? super T> & Number > int compareNumbers(T t1, T t2) 
// does not work..

public static <T extends CharSequence & Comparable<T>> int compareNumbers(T t1, T t2)
// works..multiple interfaces

public abstract class RelationshipTable<SubjectType, RelationshipType extends
Enum<RelationshipType> & Related, ObjectType> 
{

}

public interface Operation <ArgType, ResultType> 
{
    public ResultType run (ArgType argument);
}
public class Session 
{
    public <ArgType, ResultType> Future<ResultType> runOperation (Operation <ArgType, ResultType> op, ArgType arg) { ... }
}

public interface Identifiable<T extends Identifier<? super What>, What> 
{
    public T getIdentifier();
}

public interface Identifier<T> 
{
    public long getID();
}

public class User extends Identifiable<UserIdentifier, User> { ... }

public class UserIdentifier extends Identifier<User> { ... }
