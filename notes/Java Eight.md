Java Eight 
- unlike local and anonymous classes, lambda expressions do not have any shadowing issues 
- Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. 
- like local and anonymous classes, a lambda expression can only access local variables and parameters of the enclosing block that are final or effectively final. 
- The data type these methods expect is called the target type and you can only use lambda expressions in situations in which the Java compiler can determine a target type: Variable declarations, Assignments, Return statements, Array initializers, Method or constructor arguments, Lambda expression bodies, Conditional expressions, ?:, Cast expressions

###Default Methods###
**Virtual extension methods**, or, as they are often called, **defender methods**, can now be added to interfaces providing a default implementation of the declared behavior. interfaces can now implement methods & it doesn’t break the implementations.

Interface Methods: Default methods and abstract methods in interfaces are inherited like instance methods. 
- However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
Rule # 1: Instance methods are preferred over interface default methods.  Pegasus.identifyMyself() returns the string "I am a horse."

```
public class Pegasus extends Horse implements Flyer, Mythical 
{
    public static void main(String... args) 
    {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}
class Horse{public String identifyMyself(){return "I am a horse.";}}
interface Flyer 
{
    default public String identifyMyself() 
    {
        return "I am able to fly.";
    }
}
public interface Mythical 
{
    default public String identifyMyself() 
    {
        return "I am a mythical creature.";
    }
}
```
Rule # 2: Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself() returns the string "I am able to lay eggs."
```
public interface Animal 
{
    default public String identifyMyself() 
    {
        return "interface_animal";
    }
}
public interface EggLayer extends Animal 
{
    default public String identifyMyself() 
    {
        return "I am able to lay eggs.";
    }
}
public interface FireBreather extends Animal 
{ 
    default public String identifyMyself() 
    {
        return "I am able to breathe fire.";
    }
}
public class Dragon implements EggLayer, FireBreather 
{
    public static void main (String... args) 
    {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
```
  This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 
- Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.



- overriding.interface methods contians code that needs Java 8.

Nested Classes

- captured variable: a local class can only access local variables that are declared final.
- in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters.
Starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. 


