/**
* when the supertypes of a class or interface provide multiple default 
* methods with the same signature, the Java compiler follows inheritance 
* rules to resolve the name conflict.
* Rule # 2:
* Methods that are already overridden by other candidates are ignored. 
* This circumstance can arise when supertypes share a common ancestor.
*/
abstract class Animal 
{
    public String identifyMyself() 
    {
        return "interface_animal";
    }
}

abstract class EggLayer extends Animal 
{
    public String identifyMyself() 
    {
        return "lay_eggs_extends_animal";
    }
}

abstract class FireBreather extends Animal 
{ 
    public String identifyMyself() 
    {
        return "fire_breather_extends_animal";
    }
}

/**
* The method Dragon.identifyMyself returns the string 
* "I am able to lay eggs.""
*/
public class Dragon7 implements EggLayer, FireBreather 
{
    public static void main (String... args) 
    {
        Dragon7 dragon = new Dragon7();
        System.out.println(dragon.identifyMyself());
    }
}