/**
* 1. logically grouping classes that are only used in one place
* 2. increases encapsulation
* 3. more readable and maintainable code
*/
class OuterClass 
{

    /**
    * just like any other top-level class
    * Cannot refer directly to instance variables or 
    * methods defined in its enclosing class: 
    * it can use them only through an object reference.
    */
    static class StaticNestedClass 
    {
        // accessed using the enclosing class name:
		// OuterClass.StaticNestedClass
    }
    
    /**
    * because I'm associated with an instance, 
    * I cannot define any static members myself.
    */
    class InstanceInnerClass 
    {
        
    }

    //  two special kinds of inner classes: 

    // local classes

    // anonymous classes.

    public static void main(String[] args) 
    {
    	OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();	

    	OuterClass outerObject = new OuterClass();
    	OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    }

}