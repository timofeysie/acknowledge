package overriding.interface_methods;

/**
* when the supertypes of a class or interface provide multiple default 
* methods with the same signature, the Java compiler follows inheritance 
* rules to resolve the name conflict.
* Rule # 2:
* Methods that are already overridden by other candidates are ignored. 
* This circumstance can arise when supertypes share a common ancestor.
*/
public class FlyingCar implements OperateCar, FlyCar 
{
    // ...
    public int startEngine(EncryptedKey key) 
    {
        FlyCar.super.startEngine(key);
        OperateCar.super.startEngine(key);
    }
}

public interface OperateCar 
{
    // ...
    default public int startEngine(EncryptedKey key) 
    {
        // Implementation
    }
}

public interface FlyCar 
{
    // ...
    default public int startEngine(EncryptedKey key) 
    {
        // Implementation
    }
}