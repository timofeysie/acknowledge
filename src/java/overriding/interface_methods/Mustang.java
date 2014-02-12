package overriding.interface_methods;

/**
* when the supertypes of a class or interface provide multiple default 
* methods with the same signature, the Java compiler follows inheritance 
* rules to resolve the name conflict.
* Rule # 4:
* Inherited instance methods from classes can override abstract interface
* methods. Consider the following interfaces and classes.
* The method Mustang.identifyMyself returns the string "I am a horse."
* The class Mustang inherits the method identifyMyself from the class Horse,
* which overrides the abstract method of the same name in the interface Mammal.
* Note: Static methods in interfaces are never inherited.
*/
public interface Mammal 
{
    String identifyMyself();
}

public class Horse 
{
    public String identifyMyself() 
    {
        return "I am a horse.";
    }
}

public class Mustang extends Horse implements Mammal 
{
    public static void main(String... args) 
    {
        Mustang myApp = new Mustang();
        System.out.println(myApp.identifyMyself());
    }
}
