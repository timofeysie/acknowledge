Core Java

- Enhancements in Java 5: Generics, Enhanced for loop, Auto(un)boxing, Typesafe Enums, Varargs, Annotations
- Enhancements in Java 6: Collections framework, Webstart, Drag and drop, Instrumentation, i18n, I/O support, jar files, JDBC4
- Constant Interface Antipattern: putting static memebers into an interface and inherting that to leave of the class name of static methos.  So we have the static import.
- varags (variable arguments) are the elipses (...) part indicates that an array or a sequence of arguments may be used in its place.  It must be in the final argument position or a method signature.
- the compiler translates the varargs formal parameter into an array. 
- for each in example.  (Vector v) for (String s:v) {print(s);}

#TOC#
Objects
Variables
Initialization
Nested Classes
Enums
Inheritance
Object class
Abstract & Interface
Methods
Modifiers
Numbers
Packages
Regular Expressionses


#Objects#
Real-world objects contain state and behavior.
A software object's state is stored in fields.
A blueprint for a software object is called a class.
Common behavior can be defined in a superclass and inherited into a subclass using the extends keyword.
A collection of methods with no implementation is called an interface.

#Variables#
- Instance Variables (Non-Static Fields) 
- Class Variables (Static Fields) static modifier; one copy regardless of how many times the class has been instantiated. 
- Local Variables declared in braces of a method. only visible to the methods in which they are declared;
- Parameters classified as "variables" not "fields". other parameter-accepting constructs as well (constructors and exception handlers)
- A type's fields, methods, and nested types are collectively called its members.

#Initialization#
- static initialization blocks are normal block of code enclosed in braces, { }, and preceded by the static keyword.  They are called in the order that they appear in the source code.
- private static method defined in a class:
    public static varType myVar = initializeClassVariable();
    private static varType initializeClassVariable() {
        // initialization code goes here
    }
- can be reused later if you need to reinitialize the class variable.
- Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword:
- The compiler copies initializer blocks into every constructor. can be used to share a block of code between multiple constructors.
- final method cannot be overridden in a subclass. 
- The method is final because calling non-final methods during instance initialization can cause problems.

#Nested Classes#
There are Static nested classes, but Non-static nested classes are called inner classes.
A nested class can be declared private, public, protected, or package private. 

class OuterClass {
    ...
    static class StaticNestedClass 
    {
        // cannot refer directly to instance variables or methods defined in its enclosing class
        //  just like any other top-level class.
    }

    // to create an object for the static nested class, use this syntax:
	OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

    class InnerClass 
    {
        //  have access to other members of the enclosing class, even if they are declared private.
        // cannot define any static members itself.
    }

    // To instantiate an inner class, you must first instantiate the outer class. 
    // Then, create the inner object within the outer object with this syntax:
	OuterClass.InnerClass innerObject = outerObject.new InnerClass();

	// two kinds of inner classes: local classes and anonymous classes.
}

#Enums#
All enums implicitly extend java.lang.Enum.  Since Java does not support multiple inheritance, an enum cannot extend anything else.
An interface name can be used anywhere a type can be used.

#Inheritance#
Questions and Exercises: Inheritance
1.a and c incorrect.  How do you hide an inherited method?  It's considered a bad programming practice, but the table in Overriding and Hiding Methods section shows the effect of declaring a method with the same signature as a method in the superclass.
http://docs.oracle.com/javase/tutorial/java/IandI/override.html
- overriding: instance method in the subclass that has the same signature as the one in the superclass
- hiding: a static method in the subclass that has the same signature as the one in the superclass
- A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.
- implicit casting:
    Object obj = new MountainBike();
- explicit casting:
    MountainBike myBike = (MountainBike)obj; // error without the cast
    if (obj instanceof MountainBike) {
        MountainBike myBike = (MountainBike)obj;
    }
- virtual method invocation, an aspect of polymorphism, is when the jvm calls the appropriate method for the object that is referred to in each variable, not the method that is defined by the variable's type
- constructor chaining: If a constructor does not explicitly invoke a superclass constructor, the Java compiler automatically inserts a call to the no-argument constructor of the superclass. If the super class does not have a no-argument constructor, you will get a compile-time error.   But Oject has one.  there will be a whole chain of constructors called, all the way back to the constructor of Object.
- Methods called from constructors should generally be declared final. If a constructor calls a non-final method, a subclass may redefine that method with surprising or undesirable results.
- final classes cannot be subclassed, useful when creating an immutable class like the String class.

#Object#
protected Object clone() throws CloneNotSupportedException
public boolean equals(Object obj)
protected void finalize() throws Throwable 
public final Class getClass()
public int hashCode()
public String toString()
notify, notifyAll, and wait 
- If an object contains a reference to an external object, you may need to override clone() to get correct behavior. Otherwise, a change in ObjExternal made by one object will be visible in its clone also. This means that the original object and its clone are not independent—to decouple them, you must override clone() so that it clones the object and ObjExternal. Then the original object references ObjExternal and the clone references a clone of ObjExternal, so that the object and its clone are truly independent.
- If you override equals(), you must override hashCode() as well.
- A hash code is the object's memory address in hexadecimal.
- if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are equated
- finalize() may be invoked on an object when it becomes garbage.
- You cannot override getClass().
- getClass().getSimpleName()
- getClass().getSuperclass() // its superclass 
- getClass().getInterfaces() // interfaces it implements
- getFields() getMethods() // other methods (of 50) in Class.class


#Abstract & Interface#
- If a class includes abstract methods, the class itself must be declared abstract
- if an abstract class is subclassed and contians unimplemented methods, it must also be declared abstract.
- All of the methods in an interface are implicitly abstract, so the abstract modifier is not used. (it could be—it's just not necessary).
- Unlike interfaces, abstract classes can contain fields that are not static and final, and they can contain implemented methods. 
- Such abstract classes are similar to interfaces, except that they provide a partial implementation, leaving it to subclasses to complete the implementation. 
- If an abstract class contains only abstract method declarations, it should be declared as an interface instead.
- Multiple interfaces can be implemented by classes anywhere in the class hierarchy, whether or not they are related to one another in any way. Think of Comparable or Cloneable, for example.
- By comparison, abstract classes are most commonly subclassed to share pieces of implementation. A single abstract class is subclassed by similar classes that have a lot in common (the implemented parts of the abstract class), but also have some differences (the abstract methods).
- You can define an abstract class that does not implement all of an interface method.
- An abstract class may have static fields and static methods that can be used with a class reference—for: AbstractClass.staticMethod()—as with any other class.


#Methods#
Overriding Instance Methods - An instance method in a subclass with the same signature overrides the superclass's method.  An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.  
- the version of the hidden static method that gets invoked is the one in the superclass
- the version of the overridden instance method that gets invoked is the one in the subclass.

Hidden Static Methods - If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.  The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.

Interface Methods - Default methods and abstract methods in interfaces are inherited like instance methods. 
** What the hell is a default method?***

However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
- Instance methods are preferred over interface default methods.  Pegasus.identifyMyself returns the string "I am a horse."

- Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself returns the string "I am able to lay eggs."

This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 

#Modifiers#
- an overriding method can allow more, but not less, access than the overridden method. ie: a protected instance method in the superclass can be made public, but not private, in the subclass.
- change an instance method in the superclass to a static method in the subclass, or vice versa = compile-time error.

You can prevent a class or method from being subclassed by using the final keyword.


#Numbers# 

Assignment Operators: C /= A is equivalent to C = C / A

The byteValue, shortValue, and similar methods of the Number class convert one numeric type to another. The valueOf method converts a string to a number, and the toString method converts a number to a string.

To format a string containing numbers for output, you can use the printf() or format() methods in the PrintStream class. 

What Integer method would you use to convert a string expressed in base 5 into the equivalent int? For example, how would you convert the string "230" into the integer value 65? Show the code you would use to accomplish this task.

What Double method can you use to detect whether a floating-point number has the special value Not a Number (NaN)?

Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(i);

becomes:

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(Integer.valueOf(i));

autoboxing happens when a primitive value is:
- Passed as a parameter to a method that expects an object of the corresponding wrapper class.
- Assigned to a variable of the corresponding wrapper class.

unboxing is Converting an object of a wrapper type (Integer) to its corresponding primitive (int) value. The Java compiler applies unboxing when an object of a wrapper class is:
- Passed as a parameter to a method that expects a value of the corresponding primitive type.
- Assigned to a variable of the corresponding primitive type.


#Packages#
- package private are All the top-level, non-public types in the same file as a pulic class.
- Importing java.awt.* imports all of the types in the java.awt package, but it does not import java.awt.color, java.awt.font, etc...  To import more, do this:
    import java.awt.*;
    import java.awt.color.*;


#Regular Expressionses#

Instances of the Pattern class are immutable and are safe for use by multiple concurrent threads. Instances of the Matcher class are not safe for such use.
