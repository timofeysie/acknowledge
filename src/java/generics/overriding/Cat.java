package overriding;

/**
*The distinction between hiding a static method and overriding an instance 
* method has important implications:
* The version of the overridden instance method that gets invoked is 
* the one in the subclass.
* The version of the hidden static method that gets invoked depends 
* on whether it is invoked from the superclass or the subclass.
*
* The Cat class overrides the instance method in Animal and 
* hides the static method in Animal. 
*/
public class Cat extends Animal 
{
    public static void testClassMethod() 
    {
        // This method will be hidden when invoked from the superclass
        System.out.println("The static method in Cat");
    }

    public void testInstanceMethod() 
    {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) 
    {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        System.out.println("The version of the hidden static method "):
        System.out.println("that gets invoked is the one in the superclass,");
        System.out.println("Animal.testClassMethod() ======== ");
        Animal.testClassMethod(); // The static method in Animal
        System.out.println("Animal.testInstanceMethod() ===== ");
        System.out.println("Cannot be referenced from a static contect");
        System.out.println("myAnimal.testClassMethod() ====== ");
        myAnimal.testClassMethod(); // static method in Animal
        System.out.println("myAnimal.testInstanceMethod() === ");
        myAnimal.testInstanceMethod(); // the instance method in Cat
        System.out.println("Cat.testClassMethod() =========== ");
        Cat.testClassMethod(); // the static method in Cat
        System.out.println("Cat.testInstanceMethod() ======== ");
        System.out.println("Cannot be referenced from a static contect");
        System.out.println("myCat.testClassMethod() ========= ");
        myCat.testClassMethod(); // the static method in Cat
        System.out.println("myCat.testInstanceMethod() ====== ");
        myCat.testInstanceMethod(); // the instance method in Cat

        String base5String = "230";
        int result = Integer.valueOf(base5String, 5);
        System.out.println("The base 5 int "+result);

        double var = 1000;
        if (var == Double.NaN) 
        {
            System.out.println(var+" is NaN");
        } else
        {
            System.out.println(var+" is aN");
        }

    }
    
}