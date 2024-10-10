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
            Class           Instance
Animal      Animal          x
myAnimal    Animal Hidden   Cat
Cat         Cat             x
myCat       Cat             Cat Overriding
*/
public class Cat extends Animal 
{
    public static void testClassMethod(String message) 
    {
        // non static variable super cannot be referenced from a static context
        //super.testClassMethod("Super Class Cat ============= ");
        // This method will be hidden when invoked from the superclass
        System.out.println(message+"The static method in Cat");
    }

    public void testInstanceMethod(String message) 
    {
        System.out.println(message+"The instance method in Cat");
        //super.testInstanceMethod("Super Instance Cat ========== ");
    }

    public static void main(String[] args) 
    {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        String message = null;
        System.out.println("The version of the hidden static method ");
        System.out.println("that gets invoked is the one in the superclass");
        message = "Animal.testClassMethod() ==== ";Animal.testClassMethod(message); // The static method in Animal
        System.out.println("Animal.testInstanceMethod() = Cannot be referenced from a static context");
        System.out.println("Hidden Cat, Static Animal ------");
        message = "myAnimal.testClassMethod() == ";myAnimal.testClassMethod(message); // static method in Animal
        message = "myAnimal.testInstanceMethod() ";myAnimal.testInstanceMethod(message); // the instance method in Cat
        message = "Cat.testClassMethod() ======= ";Cat.testClassMethod(message); // the static method in Cat
        System.out.println("Cat.testInstanceMethod() ==== Cannot be referenced from a static context");
        message = "myCat.testClassMethod() ===== ";myCat.testClassMethod(message); // the static method in Cat        
        System.out.println("Overriding Cat --------------");
        message = "myCat.testInstanceMethod() == ";myCat.testInstanceMethod(message); // the instance method in Cat

        myCat.testNonStaticInstanceMethod(myCat);
        

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

    private void testNonStaticInstanceMethod(Animal myAnimal)
    {
        String message = "Animal.testInstanceMethod()";
        //Animal.testInstanceMethod(message);
        //Still cannot be referenced from a static context");
        message = "Cat.testInstanceMethod()";
        //Cat.testInstanceMethod(message);
        //" ==== Cannot be referenced from a static context");
        // The static context now is the using the Class to access the method.
    }
    
}