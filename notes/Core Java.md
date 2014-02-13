Core Java

- Enhancements in Java 5: Generics, Enhanced for loop, Auto(un)boxing, Typesafe Enums, Varargs, Annotations
- Enhancements in Java 6: Collections framework, Webstart, Drag and drop, Instrumentation, i18n, I/O support, jar files, JDBC4
- Constant Interface Antipattern: putting static memebers into an interface and inherting that to leave of the class name of static methos.  So we have the static import.
- varags (variable arguments) are the elipses (...) part indicates that an array or a sequence of arguments may be used in its place.  It must be in the final argument position or a method signature.
- the compiler translates the varargs formal parameter into an array. 
- for each in example.  (Vector v) for (String s:v) {print(s);}

Nested Classes
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



Enums
All enums implicitly extend java.lang.Enum.  Since Java does not support multiple inheritance, an enum cannot extend anything else.
An interface name can be used anywhere a type can be used.

Questions and Exercises: Inheritance
1.a and c incorrect.  How do you hide an inherited method?  It's considered a bad programming practice, but the table in Overriding and Hiding Methods section shows the effect of declaring a method with the same signature as a method in the superclass.
http://docs.oracle.com/javase/tutorial/java/IandI/override.html

Instance Methods - An instance method in a subclass with the same signature overrides the superclass's method.  An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.  
- the version of the hidden static method that gets invoked is the one in the superclass
- the version of the overridden instance method that gets invoked is the one in the subclass.

Static Methods - If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.  The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.

Interface Methods - Default methods and abstract methods in interfaces are inherited like instance methods. 
** What the hell is a default method?***

However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
- Instance methods are preferred over interface default methods.  Pegasus.identifyMyself returns the string "I am a horse."

- Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself returns the string "I am able to lay eggs."

This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 

Modifiers
The access specifier for an overriding method can allow more, but not less, access than the overridden method. For example, a protected instance method in the superclass can be made public, but not private, in the subclass.

You will get a compile-time error if you attempt to change an instance method in the superclass to a static method in the subclass, and vice versa.

You can prevent a class or method from being subclassed by using the final keyword.


Numbers 

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


Packages
- package private are All the top-level, non-public types in the same file as a pulic class.
- Importing java.awt.* imports all of the types in the java.awt package, but it does not import java.awt.color, java.awt.font, etc...  To import more, do this:
    import java.awt.*;
    import java.awt.color.*;

Numbers

- Signed numbers are positive to negative numbers where 0 is the middle.  For 8-bit numbers, unsigned values range from 0 to 255.  For signed two's-complement integers, the values range from -128 to 127.  The last bit is used as the +/- sign, and this makes arithmatics faster on computers.

byte: 8-bit signed two's complement integer. -128 to 127 (inclusive). useful for saving memory in large arrays: a variable's range can serve as a form of documentation.

short: 16-bit signed two's complement integer. -32,768 to 32,767 (inclusive). Same notes as byte

int: 32-bit signed two's complement integer, -2 to the power of 31 to 2 to the power of 31 - 1. In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 232-1. Use the Integer class to use int data type as an unsigned integer. See the section The Number Classes for more information. Static methods like compareUnsigned, divideUnsigned etc have been added to the Integer class to support the arithmetic operations for unsigned integers.

long: The long data type is a 64-bit two's complement integer. The signed long has a minimum value of -2 to the power of 63 and a maximum value of 2 to the power of 63-1. In Java SE 8 and later, you can use the long data type to represent an unsigned 64-bit long, which has a minimum value of 0 and a maximum value of 264-1. The unsigned long has a minimum value of 0 and maximum value of 2 to the power of 64-1. Also has compareUnsigned, divideUnsigned.

float: The float data type is a single-precision 32-bit IEEE 754 floating point. Its range of values is beyond the scope of this discussion, but is specified in the Floating-Point Types, Formats, and Values section of the Java Language Specification. As with the recommendations for byte and short, use a float (instead of double) if you need to save memory in large arrays of floating point numbers. This data type should never be used for precise values, such as currency. For that, you will need to use the java.math.BigDecimal class instead. Numbers and Strings covers BigDecimal and other useful classes provided by the Java platform.

double: The double data type is a double-precision 64-bit IEEE 754 floating point. Its range of values is beyond the scope of this discussion, but is specified in the Floating-Point Types, Formats, and Values section of the Java Language Specification. For decimal values, this data type is generally the default choice. As mentioned above, this data type should never be used for precise values, such as currency.

- Single-precision floating-point format is a computer number format that occupies 4 bytes (32 bits, and  double is 64 bits.  The first bit is the signed bit, the next 8 bits are exponent value, the remaining 23 bits are the fraction. (IEEE 754 standard)

boolean: true and false. represents one bit of information, but its "size" isn't something that's precisely defined.

char: single 16-bit Unicode character. min '\u0000' (or 0) max'\uffff' (65,535 inclusive).

- String objects are immutable, which means that once created, their values cannot be changed.
    int hexVal = 0x1a; //  The number 26, in hexadecimal
    int binVal = 0b11010; // The number 26, in binary
    double d1 = 123.4;
    // same value as d1, but in scientific notation
    double d2 = 1.234e2;
    float f1  = 123.4f;

- "Unicode escape" such as '\u0108' (capital C with circumflex), or "S\u00ED Se\u00F1or" (Sí Señor in Spanish). Always use 'single quotes' for char literals and "double quotes" for String literals. Unicode escape sequences may be used elsewhere in a program (such as in field names

 - special escape sequences for char and String literals: \b (backspace), \t (tab), \n (line feed), \f (form feed), \r (carriage return), \" (double quote), \' (single quote), and \\ (backslash).

- null may be assigned to any variable, except variables of primitive types

- class literal, formed by taking a type name and appending ".class"; for example, String.class. This refers to the object (of type Class) that represents the type itself.

-  an underscore character to separate digits in groups of three, similar to how you would use a punctuation mark like a comma, or a space, as a separator.

The following example shows other ways you can use the underscore in numeric literals:

long creditCardNumber = 1234_5678_9012_3456L;
float pi =  3.14_15F;
long hexBytes = 0xFF_EC_DE_5E;
long hexWords = 0xCAFE_BABE;
long maxLong = 0x7fff_ffff_ffff_ffffL;
byte nybbles = 0b0010_0101;
long bytes = 0b11010010_01101001_10010100_10010010;

- you cannot place underscores in the following places:

At the beginning or end of a number
Adjacent to a decimal point in a floating point literal
Prior to an F or L suffix
In positions where a string of digits is expected

