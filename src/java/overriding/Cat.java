public class Cat extends Animal 
{
    public static void testClassMethod() 
    {
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
        
        System.out.println(" Animal.testClassMethod() "+Animal.testClassMethod());
        System.out.println(" Animal.testInstanceMethod() "+Animal.testInstanceMethod());
        System.out.println(" myAnimal.testClassMethod() "+myAnimal.testClassMethod());
        System.out.println(" myAnimal.testInstanceMethod() "+myAnimal.testInstanceMethod());
        System.out.println(" Cat.testClassMethod() "+Cat.testClassMethod());
        System.out.println(" Cat.testInstanceMethod() "+Cat.testInstanceMethod());
        System.out.println(" myCat.testClassMethod() "+myCat.testClassMethod());
        System.out.println(" myCat.testInstanceMethod() "+myCat.testInstanceMethod());


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