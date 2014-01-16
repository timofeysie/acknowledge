package overriding.interface_methods;

/**
* When the supertypes of a class or interface provide multiple 
* default methods with the same signature, the Java compiler follows 
* inheritance rules to resolve the name conflict. 
* These rules are driven by the following two principles:
* Rule # 1:
* Instance methods are preferred over interface default methods.
* The method Pegasus.identifyMyself returns the string I am a horse.
*/
public class Pegasus extends Horse implements Flyer, Mythical 
{
    public static void main(String... args) 
    {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}

public class Horse 
{
    public String identifyMyself() 
    {
        return "I am a horse.";
    }

}

public interface Flyer 
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