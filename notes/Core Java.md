#Duration:  150 minutes#  
#Number of Questions: 90#  
22 minutes x 4  
1.6 minutes a question   
22 questions/37 minutes a quarter    
45 questions/75 minutes a half  

###TOC###
Arrays  
Serializable
PDF Collections
Assert  
Identifiers   
Shadowing   
Objects  
Variables  
Return from a Method  
Branching Statements
Controlling Access  
Pass by Value  
Numbers  
PrintStream  
Math  
Operators  
Shift Operators
Expressions, Statements, and Blocks  
Control Flow Statements  
Initialization  
Nested Classes  
Enums  
Inheritance  
Object Class  
Clone  
Abstract & Interface  
Switch  
Methods  
Modifiers  
Packages  
Regular Expressionses  
Exceptions  
Collection Interface  
Set Interface & Implementations  
List Interface  
List Iterator Interface  
List Implementations  

###Arrays###
```
int[] arr1, arr2;
```

Both arr1 and arr2 are declared as arrays.  
Data type ---------- Default value (for fields)  
boolean ------------ false  
byte ---------------- 0  
char --------------- '\u0000'  
short --------------- 0  
int ------------------ 0  
long --------------- 0L  
float --------------- 0.0f  
double ------------- 0.0d  
String (or obj) ---- null  

```
int grades[][] = new int[ROWS][COLS];
```

we could have created the same grades array as:
```
grades = new int[ROWS][];
grades[0] = new int[COLS];
grades[1] = new int[COLS];
```

- an array with different row lengths. Arrays of
this type are called ragged arrays.
```
grades[0] = new int[4];
grades[1] = new int[2];
```

###Comparing Arrays  
```
println(arr1 == arr2); //Displays false
```

arr1 and arr2 which are array reference variables
and not the arrays.
```
println(arr1.equals(arr2)); // Displays false
```

Object equivalency refers to the comparison of two object reference variables
Object value equivalency refers to the condition where two distinct objects are 

considered to be equivalent because their internal values are the same.

```
out.println(Arrays.equals(arr1,arr2)); // Displays true
```

the so called **deepEquals** method.  
```
static final int ROWS = 2;  
static final int COLS = 3;  
int grades[][] = new int[ROWS][COLS];  
grades = new int[ROWS][]; // same as  
grades[0] = new int[COLS]; // this  
grades[1] = new int[COLS]; // and this  
grades[0][0] = 0;  
grades[0][1] = 1;  
grades[0][2] = 2;  
grades[1][0] = 3;  
grades[1][1] = 4;  
grades[1][2] = 5;  
int grades2[][];  
   
grades2 = new int[ROWS][];   
grades2[0] = new int[COLS];  
grades2[1] = new int[COLS];  
grades2[0][0] = 0;  
grades2[0][1] = 1;  
grades2[0][2] = 2;  
grades2[1][0] = 3;  
grades2[1][1] = 4;  
grades2[1][2] = 5;  
System.out.println(grades == grades2); // false  
System.out.println(grades.equals(grades2)); // false  
System.out.println(Arrays.equals(grades, grades2)); // false   
System.out.println(Arrays.deepEquals(grades, grades2)); // true  
```

Using the equality operator only works properly if the two reference variables reference the same object.  
Using the array's equals method ditto.
Using the Array's class equals method This will work for one-dimensional arrays.
Using the Array's class deepEquals method performs a deeper comparison using
the object's equals method.

###Copying Arrays  

```

int arr1[] = new int[5];   
int arr2[] = new int[5];    
for(int i = 0; i < arr1.length; i++) {    
arr1[i] = i; }    

```

**Simple element-by-element copy**:  
```   
for(int i = 0; i < arr1.length; i++) {  
arr2[i] = arr1[i]; }  
```

**the System.arraycopy** method attempts to copy all, or part, of one array to
another. Provide the beginning positions and the number of elements to copy.
```
System.arraycopy(arr1, 0, arr2, 0, 5);
```

(To copy the first three elements of arr1 to the last three elements
of arr2: System.arraycopy(arr1, 0, arr2, 2, 3); // 0 0 0 1 2)

```
StringBuilder arr3[] = new StringBuilder[4];   
arr3[0] = new StringBuilder("Pine");    
arr3[1] = new StringBuilder("Oak");    
arr3[2] = new StringBuilder("Maple");    
arr3[3] = new StringBuilder("Walnut");    
StringBuilder arr4[] = new StringBuilder[4];    
System.arraycopy(arr3, 0, arr4, 0, 4);    
```

However, arr4 contains the same object reference variables used by arr3. The
corresponding element of both arrays reference the same object. The creation of an identical array with references to distinct strings is achieved with the following code:
```
for (int i = 0; i < arr3.length; i++) {
arr4[i] = new StringBuilder(arr3[i]); }
```
- We created a new StringBuilder object for-each element of the destination array.  This approach is necessary if a deep copy is needed.

**the Arrays.copyOf method** creates a new array based on an existing array.
The arguments are the original array and how many elements to copy.  
```
arr2 = Arrays.copyOf(arr1, 3); // 0 1 2
```  
The new array can be larger than the original array as illustrated with the
following code:  
```
arr2 = Arrays.copyOf(arr1, 10); // 0 1 2 3 4 0 0 0 0 0
```  
The last five elements of arr2 will be padded with zeros.  If the array is an array of objects, a copy of the original object is assigned to the new array.

**the Arrays.copyOfRange method** creates a new array based on a subrange
of elements in an existing array. The arguments are the original, the beginning index and the ending index exclusive.
```
arr2 = Arrays.copyOfRange(arr1, 3, 5); // 3 4
```  
(Notice that the last argument is not a valid index for the arr1 array. This works here because the last argument is exclusive. It does not include that element.)
```
arr2 = Arrays.copyOfRange(arr1, 3, 8); // 3 4 0 0 0
```  
- the new array is padded with zeros:

**the clone method** creates a copy of an array:  
```
arr2 = arr1.clone();
```    
However, this only makes a shallow copy of the original object. With an array of primitives such as the above integer array, this is not a problem. With an array of references to objects, both arrays will reference the same objects.

- "passing a reference" to the arr2 array "by value". if we modify the arr parameter, the original arr2 variable is not modified.  
```  
System.out.println("Length of arr2: " + arr2.length); // 5
changeArray(arr2);                                    // 100
System.out.println("Length of arr2: " + arr2.length); // 5
...
private static void changeArray(int arr[]) {
arr = new int[100];
System.out.println("Length of arr: " + arr.length); }
```  

### The java.util.Arrays class 
```
int arr1[] = new int[5];
ArrayList list = new ArrayList();
list.add("item 1");
list.add("item 2");
Object arr2[] = {"item 3", new Integer(5), list};
String arr3[] = {"Pine", "Oak", "Maple", "Walnut"};
```  
Next, we will fill the integer array with the number 5 using the fill method:
```
Arrays.fill(arr1,5);
```   
The asList, toString, and deepToString methods are then used against these
arrays, shown as follows:
```
println(Arrays.asList(arr3)); // [Pine, Oak, Maple, Walnut]
println(Arrays.toString(arr1)); // [5, 5, 5, 5, 5]
println(Arrays.deepToString(arr2)); // [item 3, 5, [item 1, item 2]]
```  
- the asList() method takes its array argument and returns a java.util.List. If either the array or the list is modified, their corresponding elements are modified. This is demonstrated in the following example:
```
List list2 = Arrays.asList(arr3);
list2.set(0, "Birch");
println(Arrays.toString(arr3)); // [Birch, Oak, Maple, Walnut]
```  

Arrays provide **Locality of reference** results in faster read and write operations (important for virtual operating systems) faster than accessing elements of a linked list when the linked list is spread across the memory.


###Serializable###
If a class or any of its superclasses implements either 
- the java.io.Serializable interface or its subinterface (like java.awt.Button), 
- java.io.Externalizable.  

 the class's definition ("class file") itself is not recorded.
 - the system responsible for deserializing and to determine how to locate and load the necessary class files. ie:a JAR file or load the class definitions by using information stored in the directory  
```
// Create the object to be bound  
Button b = new Button("Push me");  
// Perform the bind  
ctx.bind("cn=Button", b);  
// You can then read the object back using Context.lookup  
// Check that it is bound  
Button b2 = (Button)ctx.lookup("cn=Button");  
System.out.println(b2);  

public final void writeObject(Object x) throws IOException
```
The above method serializes an Object and sends it to the output stream. Similarly, the ObjectInputStream class contains the following method for deserializing an object:
```
public final Object readObject() throws IOException, 
                                 ClassNotFoundException
```

To be serialized successfully, two conditions must be met:
- The class must implement the java.io.Serializable interface.
- All of the fields in the class must be serializable. If a field is not serializable, it must be marked transient. 


###PDF Collections###
The remove method is an optional Iterator method. If an attempt is made to use
this method and the implementation of the interface does not support this method, then an UnsupportedOperationException exception is thrown.
The ListIterator interface, when available, is an alternative to the Iterator
interface. It uses the same methods and provides additional capabilities including:    
• Traversal of the list in either direction  
• Modification of its elements  
• Access to the element's position  
Iterator interface    
• next:   
• hasNext:  
• remove:  
ListIterator interface    
• previous:  
• hasPrevious  
• nextIndex:   
• previousIndex:  
• add:   

ArrayList   
• Access is performed in constant time  
• Insertion/deletion is performed in linear time  

not synchronized. When an iterator is obtained for a ArrayList object, it is susceptible to possible simultaneous overwrites with loss of data if modified in a concurrent fashion. When multiple threads access the same object, it is possible that they may all write to the object at the same time, that is, concurrently. When this simultaneous overwrite occurs, a ConcurrentModificationException exception is thrown.

- The initial capacity of a ArrayList created with its default
constructor is 10.  

```
ArrayList<String> creatures = new ArrayList<String>();  
creatures.add("Mutant");  
creatures.add("Alien");  
creatures.add("Zombie");  
println(creatures); // [Mutant, Alien, Zombie]  
creatures.add(1,"Godzilla");  
println(creatures); //[Mutant, Godzilla, Alien, Zombie]  
ArrayList<String> cuddles = new ArrayList<String>();  
cuddles.add("Tribbles");  
cuddles.add("Ewoks");  
creatures.addAll(2, cuddles);  
System.out.println(creatures);  
// [Mutant, Godzilla, Tribbles, Ewoks, Alien, Zombie]  
String element = creatures.get(2); // Tribbles  
System.out.println(creatures.indexOf("Tribbles")); // 2  
Iterator<String> iterator = creatures.iterator();  
while(iterator.hasNext()) {  
    System.out.print(iterator.next() + " ");  
}  
System.out.println();  
  
ListIterator<String> listIterator = creatures.listIterator();  
while(listIterator.hasNext()) {  
    System.out.print(listIterator.next() + " ");  
}  
System.out.println();  

while(listIterator.hasPrevious()) {  
    System.out.print(listIterator.previous() + " ");  
}  
System.out.println();  

Collections.sort(creatures);  
System.out.println(creatures);  
// [Alien, Ewoks, Godzilla, Mutant, Tribbles, Zombie]  
creatures.set(0,"Ghoul");  
System.out.println(creatures);  
// [Ghoul, Godzilla, Tribbles, Ewoks, Alien, Zombie]  
```

- Traverse with for statement, for-each statement, Iterator, or ListIterator

Encapsulating collections
- When using a collection within a class, hide the collection


###Classes### 
- (p.185)  
To create an immutable object:  
• Make the class final which means that it cannot be extended (covered in the Using the final keyword with classes section in Chapter 7, Inheritance and Polymorphism)  
• Keep the fields of the class private and ideally final  
• Do not provide any methods that modify the state of the object, that is do not provide setter or similar methods  
• Do not allow mutable field objects to be changed  
```
public Date getDate() {
return new Date(date.getTime());
}
```  
the getDate method created a new Date object based on the header's
date field. Any Date object is mutable, so by returning a copy of the date as opposed to a reference to the current date, the user is unable to access and otherwise modify the private field.

###Default Constructor###    
If the programmer adds a constructor to the class, then the class will no longer have a default constructor added automatically. The programmer must explicitly add a default constructor for the class to have one.  Imagine this constructor is the only one in the class:
```
public Employee(String name) { }
```  
If we try to create an object using the default constructor, as shown in the following code snippet, then we will get a syntax error:
```
Employee employee1 = new Employee();
```  
The error message that is generated is as follows:
no suitable constructor found for Employee()
-If a "constructor" has a return type, it is actually a method that happens to have the same name as the class. This is true even if the return type is void, as illustrated in the following code snippet:
```
public void Employee(String name) {
}
Employee employee = new Employee();
employee.Employee("Calling a method");
```  
- While this is legal, it is not good style  

initialization sequence is a bit more complex  
than described here. However, the general order is as follows:  
1. The zeroing of fields performed when the object is instantiated  
2. The initialization of final and static variables  
3. The assignment of instance variables initializers  
4. The execution of initialization blocks  
5. The code within a constructor  

Both the method calls in the following code snippet will invoke the same method:
```
Employee employee = new Employee();
employee.setEntityCode(42);
Employee.setEntityCode(42);
```  
However, it is not good practice to use a reference variable to invoke a static method.  Instead, always use the classname. Attempts to use an object will result in the following syntax warning:
```
Accessing static method setEntityCode
```  

Fields that have private or non-existent setters (mutator methods) are referred to as read-only fields. Fields that have private or non-existent getters are referred to as write-only (accessor) fields, but are not as common.

(TO Ch 6 summary)


###Assert###
"Exceptions address the robustness of your application (things that might happen) while assertions adOrder Number :3BMNGNE-BF3CF9, Email ID:timofeyc@hotmail.com, Quantity:1
dress the correctness of your application (something that should never happen."
- contains a boolean expression that you believe will be true when the assertion executes. If it is not true, the system will throw an error. 
When to use the assert keyword:  
- pre-conditions (in private methods only) - the requirements which a method requires its caller to fulfill
- post-conditions - verify the promises made by a method to its caller
- class invariants - validate object state
- unreachable-at-runtime code - parts of your program which you expect to be unreachable, but which cannot be verified as such at compile-time (often else clauses and default cases in switch statements)
```
assert Expression1;
```  
- Expression1: a boolean expression, if it is false throws an AssertionError with no detail message.  
```
assert Expression1 : Expression2 ;
```  
Expression2 - cannot be an invocation of a method that is declared void.)
- provides a message for the AssertionError as the error's detail message.  
Examples:

```

    assert fLength > oldLength; //post-condition: length has increased    
    //check the class invariant  
    assert hasValidState(): "Construction failed - not valid state.";  
    assert hasValidState(): this; // //check the class invariant  
```  

- assertions are enabled using a javac argument -enableassertions, or -ea at runtime or -disableassertions, or -da to disable (packageName or className for granularity)
- use assertions to provide feedback to yourself or your developer team
(state things that you (supposedly) know to be true).

###Identifiers###
- names of variables, functions, classes etc. 
- rules; a digit, letter _ or $
- 1st cannot be a digit.
- No reserved words; goto, strictfp, const, transient, native, synchronized


###Shadowing###
```
public class ShadowTest 
{  

    public int x = 1;  
    class FirstLevel {
        public int x = 2;  // member variable of the inner class
        void methodInFirstLevel(int x) {
            ("parameter   x "+x      +" shadows all other xs");
            ("inner class x "+this.x+" shadows outer class x"); 
            ("Outer class x "+ShadowTest.this.x              );
    }
}
```     
Output: 3 2 1 (with 3 as the parameter passed into the method)


- Same for a local variable:
void methodInFirstLevel2() 
{
    int x = 2;
- prints out 2(or parameter), 1, 0.

###Objects###
Real-world objects contain state and behavior.  
A software object's state is stored in fields.  
A blueprint for a software object is called a class.  
Common behavior can be defined in a superclass and inherited into a subclass using the extends keyword.  
A collection of methods with no implementation is called an interface.  

###Variables###
- Instance Variables (Non-Static Fields) 
- Class Variables (Static Fields) static modifier; one copy regardless of how many times the class has been instantiated. 
- Local Variables declared in braces of a method. only visible to the methods in which they are declared;
- A type's fields, methods, and nested types are collectively called its members.
- A variable declared within the opening and closing parenthesis of a method is called a parameter.
- Parameters refers to the list of variables in a method declaration. 
- Arguments are the actual values that are passed in when the method is invoked.
- Parameters classified as "variables" not "fields". other parameter-accepting constructs as well (constructors and exception handlers)

**compile-time constant** a primitive type or a string is defined as a constant and the value is known at compile time, the compiler replaces the constant name everywhere in the code with its value.
- The args variable is the parameter to a main method. parameters are always classified as "variables" not "fields". 

###Return from a method###
- Any method declared void doesn't need to return a value, but it may do so to branch out of a control flow block and exit the method.
- When a method uses a class name as its return type, such as whosFastest does, the class of the type of the returned object must be either a subclass of, or the exact class of, the return type. 
**covariant return type** means that the return type is allowed to vary in the same direction as the subclass when You override a method and define it to return a subclass of the original method,
- when you use an interface as a return type the object returned must implement the specified interface.
**explicit constructor invocation** From within a constructor, you can also use the 'this' keyword to call another constructor in the same class.

###Branching Statements###
- An unlabeled break statement terminates the innermost switch, for, while, or do-while statement
- A labeled break terminates an outer statement.
```
search:
        for (i = 0; i < arrayOfInts.length; i++) 
        {
            for (j = 0; j < arrayOfInts[i].length;j++) 
            {
                if (arrayOfInts[i][j] == searchfor) 
                {
                    foundIt = true;
                    break search;
                }
            }
        }
```
- A continue statement skips the current iteration of a for, while , or do-while loop. 
- The unlabeled form skips to the end of the innermost loop's body and evaluates the boolean expression that controls the loop.
- A labeled continue statement skips the current iteration of an outer loop marked with the given label. 
```
test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
                break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
```
- The return statement exits from the current method, and control flow returns to where the method was invoked. 
- The return statement has two forms: one that returns a value, and one that doesn't. 
- To return a value, put the value (or an expression that calculates the value) after the return keyword.
- When a method is declared void, use the form of return that doesn't return a value.


###Controlling Access###
- package-private: when a class (or member) has no explicit public(private/protected) modifyer.
- The protected modifier specifies that the member can only be accessed within its own package (as with package-private) and, in addition, by a subclass of its class in another package.
- Public fields tend to link you to a particular implementation and limit your flexibility in changing your code.

Access Levels  
Modifier....Class...Package.Subclass.World  
public......Y.......Y.......Y........Y  
protected...Y.......Y.......Y........N  
no modifier.Y.......Y.......N........N  
private.....Y.......N.......N........N  


###Pass by Value###
- Reference data type parameters (objects) are passed into methods by value. However, the values of the object's fields can be changed in the method (see RelatableCircle.java in the innards directory)
- for example:
```
        ValueCircle myCircle = new ValueCircle(5,5);
        TestValueCircle test_circle = new TestValueCircle();
        test_circle.moveCircle(myCircle, 23, 56);
```
Even thought myCircle is not returned from the moveCircle method, the changes that happen in that method are reflected in the reference.
- if moveCircle changes the values, they are changed in the calling method as well.  However, if it creates a new object, that object loses its reference after the method returns.
- The difficult thing can be to understand that Java passes objects as references and those references are passed by value.  object references are passed by value. "call by value where the value is a reference" (Barbara Liskov re CLU language 1974), "call by sharing" (sometimes called "call by object-sharing or simply call by object")
- The references are pointers to an address.  Thats' why the value of the object is the same.
- In C you can assign a pointer, pass the pointer to a method, follow the pointer in the method and change the data that was pointed to. However, you cannot change where that pointer points.  In C++, Ada, Pascal and other languages that support pass-by-reference, you can actually change the variable that was passed.
- Java is by value for built-in types, and by value of the pointer for object types.
- however, primitive types are not changed by the method.
- my take: Java is a pass-by-address(or primitive) language.


###Numbers
The eight primitive data types supported by the Java programming language: boolean, byte, char, short, int, float, long, double.   
"If you bite a char short inthe float it's long in the double"   

- boolean: true/false. one bit of information, but its "size" isn't something that's precisely defined.  
- byte: 8-bit signed two's complement integer. min -128 max 127 (incl).  
- char: single 16-bit Unicode character. min'\u0000' (or 0) max'\uffff' (or 65,535 inclusive).  
- short: a 16-bit signed two's complement integer.min -32,768 max 32,767 (inclusive).use a short to save memory in large arrays, in situations where the memory savings actually matters.  
- int: 32-bit signed two's complement integer, min -2,147,483,648 max 2,147,483,647  (-2 to the 31 and a maximum value of 2 tt 31-1). In Java SE 8 and later, you can use unsigned 32-bit integer, min 0 max 2 tt 32-1. Use the Integer methods compareUnsigned, divideUnsigned etc to support the arithmetic operations for unsigned integers.
- float: single-precision 32-bit IEEE 754 floating point. range specified in the Floating-Point Types, Formats, and Values section of the Java Language Spec. As with the recommendations for byte and short, use a float (instead of double) if you need to save memory in large arrays of floating point numbers. not for precise values, such as currency. For that, use the java.math.BigDecimal
- long: 64-bit two's complement integer. signed min -2 tt 63 max 2 tt 63-1. Java SE 8 has an unsigned 64-bit long:min 0 and a max 2 tt 64-1. Use this data type when you need a range of values wider than those provided by int. Also compareUnsigned, divideUnsigned etc
- double: double-precision 64-bit IEEE 754 floating point. (Range in Java Spec). decimal default choice. should never be used for precise values

A 64-bit register can store 2tt64 (over 18 quintillion or 1.8×10 to the 19th power) different values. Hence, a processor with 64-bit memory addresses can directly access 264 bytes (=16 exbibytes) of byte-addressable memory.

Decimal numbers (for example 1.3) are of type double by default. To make them of type float they must be followed by F (say, 1.3F).

Integral type negative numbers are generated using the following three step process:

1. Convert 18 to binary 0001 0010
2. Interchanging 0s and 1s 1110 1101
3. Adding 1 -- 1110 11

```
    Integer.toBinaryString(18);
    bin = ~bin;
    bin+=1;

                    00000 10010 = 18
bin = ~bin;         11111 01101 = -19
bin+=1;             11111 01110 = -18
bin = bin>>1;       11111 10111 = -9
bin = bin << 1;     11111 01110 = -18
bin = bin >>> 1;    11111 10111 = 2147483639

0000 0000 0
0000 0001 1
0000 0010 2
0000 0011 3
0000 0100 4
0000 0101 5
0000 0110 6
0000 0111 7
0000 1000 8
0000 1001 9
0000 1010 10
0000 1011 11
0000 1100 12
0000 1101 13
0000 1110 14
0000 1111 15
0001 0000 16
0001 0001 17
0001 0010 18
0001 0011 19
0001 0100 20

00000100 4  100
00001000 8  1,000
00010000 16 10,000
00100000 32 100,000
01000000 64 1,000,000
10000000 128 10,000,000

```
- most significant bit (MSB, high-order bit, left-most bit) highest # to the left or the sign bit of a signed binary number in one's or two's complement notation, 1 = - and 0 = +
Assignment Operators: C /= A is equivalent to C = C / A
- The byteValue, shortValue, and similar methods of the Number class convert one numeric type to another. The valueOf method converts a string to a number, and the toString method converts a number to a string.
- To format a string containing numbers for output, you can use the printf() or format() methods in the PrintStream class. 
- Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes

```
List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(i);
```
becomes:
```
List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(Integer.valueOf(i));
```

**Autoboxing a Primitive** happens when a primitive value is:
- Passed as a parameter to a method that expects an object of the corresponding wrapper class.
- Assigned to a variable of the corresponding wrapper class.

Unboxing is Converting an object of a wrapper type (Integer) to its corresponding primitive (int) value. The Java compiler applies unboxing when an object of a wrapper class is:
- Passed as a parameter to a method that expects a value of the corresponding primitive type.
- Assigned to a variable of the corresponding primitive type.


###PrintStream###
- System.out is a PrintStream object, so you can invoke PrintStream where you have been using print or println. For example,
System.out.format(String format, Object... args);
- The format string contains plain text as well as format specifiers (begin with a percent sign (%) and end with a converter. The converter indicating the type of argument to be formatted. In between the percent sign (%) and the converter you can have optional flags and specifiers), which are special characters that format the arguments of Object... args
- format(Locale l, String format, Object... args)
```
long n = 461012;
System.out.format("Comma separated: %,8d%n", n);    
// -->  "Comma separated: 461,012" (newline)
      Calendar c = Calendar.getInstance();
      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
      System.out.format("%tD%n", c);    // -->  "05/29/06"
```
Or in a catch block:
```
System.err.format("IOException: %s%n", x);
```

###Math###
Math.E, the base of natural logarithms  
- double abs(double d)
- float abs(float f) or int, - long Returns the absolute value of the argument.  
```
Math.abs(-191.635) = 191.635  
Math.abs(-4.500) = 4.500  
```

- double ceil(double d)   Returns the smallest integer that is greater than or equal to the argument. Returned as a double.
```
Math.ceil(43.74) = 44  
Math.ceil(43.32) = 44  
Math.ceil(-4.50) = -4  
```

- double floor(double d)  Returns the largest integer that is less than or equal to the argument. Returned as a double.
```
Math.floor(43.74) = 43
Math.floor(-4.50) = -5
```

- double rint(double d)   Returns the integer that is closest in value to the argument. Returned as a double.
```
Math.rint(43.74) = 44
Math.rint(43.32) = 43
```

- long round(double d) or int round(float f)  Returns the closest long or int, as indicated by the method's return type, to the argument.
```
Math.round(43.74) = 44
Math.round(43.32) = 43
```

**The difference between rint and round**
rint:  
-  If two double values that are mathematical integers are equally close to the value of the argument, the result is the integer value that is even. Special cases: 
- If the argument value is already equal to a mathematical integer, then the result is the same as the argument. 
If the argument is NaN or an infinity or positive zero or negative zero, then the result is the same as the argument.
round:  
- The result is rounded to an integer by adding 1/2, taking the floor of the result, and casting the result to type int.
- In other words, the result is equal to the value of the expression: 
(int)Math.floor(a + 0.5f)
Special cases:  
- If the argument is NaN, the result is 0. 
- If the argument is negative infinity or any value less than or equal to the value of Integer.MIN_VALUE, the result is equal to the value of Integer.MIN_VALUE. 
- If the argument is positive infinity or any value greater than or equal to the value of Integer.MAX_VALUE, the result is equal to the value of Integer.MAX_VALUE.
```
Math.round(-1.5) = -1
Math.rint(-1.5) = -2.0
```

**NaN**
- 0.0 divided by 0.0 is arithmetically undefined. 
- Taking the square root of a negative number is also undefined.
```
System.out.println(0.0f / 0.0f);       // NaN
System.out.println(Math.sqrt(-1.0f));  // NaN
if (Float.isNaN(value)) // true if it's non a number
Float.isInfinite()  // similar to finind infinity
Double.isInfinite()
```

- double min(double arg1, double arg2) works with float int long  Returns the smaller of the two arguments.
- double max(double arg1, double arg2) also float int long  Returns the larger of the two arguments.
```
Math.max(16,45) = 45
Math.min(16,45) = 16
```

- pseudo-randomly selected number includes 0.0 but not 1.0. 
- 0.0 <= Math.random() < 1.0
- static double ceil(double(d)) : returns the smallest double value equal to a mathematical integer, that is not less than the argument. 
```
    ceil(3.4) // returns 4.0
    ceil(-2.3) // returns -2.0
    ceil(3.0) // returns 3.0
```




###Operators###
- remainder operator (modulus, modula) 10 % 3 is 1 because 10 divided by 3 leaves a remainder of 1.
- the % operator is not a true modulus operator, but computes the remainder, which may be negative (-13 % 64 = -13)
- logical complement operator "!".

```
result = result - 1; same as result -= 1;
// % remainder operator (modulus, modula)  
// result is now 10
result = result % 7; // result is now 3
//Same as
// result is now 10
result %= 7; // result is now 3
// result is now 10
result = result + 8;
// result is now 3
result = result % 7;
```

?:      Ternary (shorthand for if-then-else statement)  
~       Unary bitwise complement  
<<      Signed left shift  
\>>      Signed right shift  
\>>>     Unsigned right shift  
&       Bitwise AND  
^       Bitwise exclusive OR  
|       Bitwise inclusive OR  

- & and | can be used in logical AND bitwise operations
- When operators of equal precedence appear in the same expression, a rule must govern which is evaluated first. All binary operators except for the assignment operators are evaluated from left to right; assignment operators are evaluated right to left.

- Operators     Precedence  
postfix         expr++ expr--  
unary           ++expr --expr +expr -expr ~ !  
multiplicative  * / %  
additive        + -  
shift           << >> >>>  
relational      < > <= >= instanceof  
equality        == !=  
bitwise AND     &  
bitwise exclusive OR    ^  
bitwise inclusive OR    |  
logical AND     &&  
logical OR      ||  
ternary         ? :  
assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=  

**bitwise exclusive OR**
^ for booleans is the same as !=  
XOR   
27 = 11011  
14 = 01110  
----------  
21 = 10101  
if bits are the same, 0, different 1.

- logical && and || are short-circuited.  (left operand is evaluated before the right operator. If the result of the operation can be evaluated after computing the left operand, then the right side is not computed). different from bit-wise counterparts - bit-wise (&) and bit-wise (|). The bit-wise operators are not short-circuited.



###Shift operators###
<< The left shift operator fills the right bits by zero.
```
int i = 13; // 0000 1101
i = i << 2; // 0011 0100 
i is 52 (i × 4) 
```
\>>> Zero fill shift right fills the leftmost bits by zeros. So the result of applying the operator >>> is always positive.
```
int b = 13; // 0000 1101
b = b >_>_> 2; //0000 0011  = 3
int b = -11; // 1111 0101 
b = b >_>_> 2; // 1111 1101
```
So the result of applying zero fill right shift operator with operand two on -11 is 1073741821.
\>> Signed right shift operator fills the left most bit by the sign bit.- For positive numbers >_>_> is the same as \>> 
- For negative numbers;
```
int b = -11; // 1111 0101 
b = b >_> 2; // 1111 1101 (2's complement of -3) 
// Here the sign bit 1 gets filled in the two most significant bits.
```
The new value of b becomes -3.

###Assignments###
**Implicit widening** assigning an int to a long.  
**Explicit casting** when source is of larger size than destination is required. In this case, if no casting is provided then the program does not compile.
- defailt init value for.
char \u0000
int 0
- Variable defined inside a method are not implicitly initialized, where as array elements are implicitly initialized.

```
string (obj) null
String str1 = "first";
String str2 = new String("first");
String str3 = "first";
boolean test1 = (str1 == str2); false
boolean test2 = (str1 == str3); true

    ValueObject obj1 = new ValueObject(); obj1.value = "first";
    ValueObject obj2 = new ValueObject(); obj2.value = "first";
    ValueObject obj3 = obj1;
    boolean test1 = (obj1.value == obj2.value); //true
    boolean test2 = (obj1.value == obj3.value); //true
```
(note: object comparrison coming soon)

###Expressions, Statements, and Blocks###
```
aValue = 8933.234; // assignment statement
System.out.println("Acknowledge!"); // method invocation statement
```
- Operators may be used in building expressions, which compute values.
- Expressions are the core components of statements.
- Statements may be grouped into blocks.
- a compound expression 1 * 2 * 3
Operators -> expressions compute values -> statements -> blocks.

###Control Flow Statements###
- The do-while statement is similar to the while statement, but evaluates its expression at the bottom of the loop.

```
for ( ; ; ) {} // an infinite loop using the for statement
while (true) {} //  an infinite loop using the while statement
// enhanced for statement for iteration through Collections and arrays:
int[] numbers =   {1,2,3,4,5,6,7,8,9,10};
for (int item : numbers) 
{
    System.out.println("Count is: " + item);
}
```

###Initialization###
- static initialization blocks are normal block of code enclosed in braces, { }, and preceded by the static keyword.  
- They are called in the order that they appear in the source code.
- First static blocks, then constructors, then normal init blocks.

```
1st Object -------
w: static init block
x: static init block
S: super super constructor
s: super constructor
y: normal init block
z: normal init block
c: constructor
g: go method
2nd Object -------
S: super super constructor
s: super constructor
y: normal init block
z: normal init block
c: constructor
g: go method
```
- Note, if the above program were run from the main method inside Sequence.java, the two static init blocks would be called before the 1st Object.
- private static method defined in a class:

```
    public static varType myVar = initializeClassVariable();
    private static varType initializeClassVariable() 
    {
        // initialization code goes here
    }
```
- can be reused later if you need to reinitialize the class variable.
- Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword:
- The compiler copies initializer blocks into every constructor. can be used to share a block of code between multiple constructors.
- final method cannot be overridden in a subclass. 
- The method is final because calling non-final methods during instance initialization can cause problems.

```
class A {public A(){System.out.println("a");}
    public String toString(){return("A");}}
class B extends A {public B(){System.out.println("b");}
    public String toString(){return("B");}}
class C extends B {public C(){System.out.println("c");}
    public String toString(){return("C");}}
class D {public static void main(String [] args)
{A a = new B();System.out.print(a.toString());
 C c = new C();System.out.print(c.toString());}}
```
Output: a b Ba b c C


###Nested Classes###  
- Logical grouping of classes — Nesting such "helper classes" makes a package more streamlined.
- Increased encapsulation — Outer class members can be declared private.
- More readable, maintainable code - places the code closer to where it is used.

- Two types:  
1. Static nested classes
2. Non-static nested classes (inner classes(local/anonymous))

1. Static Nested Classes   
- do not have access to other members of the enclosing class. 
- A nested class can be declared private, public, protected, or package private. 
- cannot refer directly to instance variables or methods defined in its enclosing. 
- Just like any other top-level class.
- accessed using the enclosing class name:

```
Outer.StaticNested nestedObj = new Outer.StaticNested();
```

2. Inner Classes  
- has access to other members of the enclosing class, even if they are declared private.
- cannot define any static members itself.
- To instantiate an inner class, you must first instantiate the outer class. 
- Objects that are instances of an inner class exist within an instance of the outer class.

```
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
- two kinds of inner classes:
A. local classes
B. anonymous classes.

A. Local classes  
- defined in a block (between balanced braces)
- usually defined in the body of a method
- also in a for loop, or an if clause.
- a local class can only access local variables that are declared final.
- Declarations of a type (such as a variable) in a local class shadow declarations in the enclosing scope that have the same name.
- Local classes are like inner classes because they cannot define or declare any static members.
 Local classes are non-static because they have access to instance members of the enclosing block. Consequently, they cannot contain most kinds of static declarations.
- You cannot declare an interface inside a block; interfaces are inherently static. 
- You cannot declare static initializers or member interfaces in a local class.


LocalClassExample.java creates a local class like this:

```
PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
```

- A local class can have static members provided that they are constant variables. (A constant variable A variable is a variable of primitive type or type String that is declared final and initialized with a compile-time constant expression. 

B. Anonymous classes   
- more concise code. 
- declare and instantiate a class at the same time.
- like local classes except that they do not have a name. 
- Use if you need to use a local class only once.
- anonymous classes are expressions, which means you define the class in another expression

Anonymous classes have the same access to local variables of the enclosing scope as local classes:
- has access to the members of its enclosing class.
- cannot access local variables in its enclosing scope that are not declared as final or effectively final
- Like nested classes, declarations of a type (such as a variable) in an anonymous class shadow declarations in the enclosing scope that have the same name.

Anonymous classes also have the same restrictions as local classes with respect to their members:
- You cannot declare static initializers or member interfaces in an anonymous class.
- An anonymous class can have static members provided that they are constant variables.

Note that you can declare the following in anonymous classes:
- Fields
- Extra methods (even if they do not implement any methods of the supertype)
- Instance initializers
- Local classes
- However, you cannot declare constructors in an anonymous class.


###Enums###
- All enums implicitly extend java.lang.Enum.  Since Java does not support multiple inheritance, an enum cannot extend anything else.
- Enum constants are implicitly static and final 
- implicitly implement both Serializable and Comparable 
```
public enum Sex 
{
    MALE, FEMALE
}
```
The enum declaration defines a class (called an enum type). The enum class body can include methods and other fields. 
- a static values method returns an array containing all of the values of the enum in the order they are declared. i.e: with the for-each construct
```
for (Planet p : Planet.values()) {
    System.out.printf("Your weight on %s is %f%n",
                      p, p.surfaceWeight(mass));
}
```
Another example:
```
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);
}
```
- type-safe and has there own name-space. It means your enum will have a type for example "Currency" in below example and you can not assign any value other than specified in Enum Constants.
```  
public enum Currency {PENNY, NICKLE, DIME, QUARTER};
Currency coin = Currency.PENNY;
coin = 1; //compilation error
```
- you need to define a member variable and a constructor because PENNY (1) is actually calling a constructor which accepts int value , see below example.
```
public enum Currency 
{
        PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
        private int value;
        private Currency(int value) {this.value = value;}
        @Override
        public String toString() 
        {
            switch (this) 
            {
            case PENNY:
              System.out.println("Penny: " + value);break;
            case NICKLE:
              System.out.println("Nickle: " + value);break;
            case DIME:
              System.out.println("Dime: " + value);break;
            case QUARTER:
              System.out.println("Quarter: " + value);
            }  
            return super.toString();
        }
} 
```
- Constructors must be private else a compilation error.
- since constants are final you can safely compare them using "==" 
```
Currency usCoin = Currency.DIME;
if(usCoin == Currency.DIME) // true
```
- can define abstract methods inside Enum in Java and can also provide different implementation for different instances of enum in java.  Let’s see an example of using abstract method inside enum in java
```
public enum Currency implements Runnable{
          PENNY(1) {
                  @Override
                  public String color() {
                          return "copper";
                  }
          }, NICKLE(5) {
                  @Override
                  public String color() {
                          return "bronze";
                  } 
    ...
    private int value;
    public abstract String color();
    ...
```




###Inheritance###
- overriding: instance method in the subclass that has the same signature as the one in the superclass
- hiding: a static method in the subclass that has the same signature as the one in the superclass. 
- A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.
- static methods cannot be overridden since they are invoked on the class itself, not the obj.

```
    Object obj = new MountainBike(); // implicit casting
    MountainBike myBike = (MountainBike)obj; // explicit casting
    // the above causes an error without the cast
    if (obj instanceof MountainBike) 
    {
        MountainBike myBike = (MountainBike)obj;
    }
```
- implicit casting is not allowed in all types of transformations

**virtual method invocation** an aspect of polymorphism, is when the jvm calls the appropriate method for the object that is referred to in each variable, not the method that is defined by the variable's type
"The JVM specifically utilizes a virtual method table for virtual method dispatch:  An object's dispatch table will contain the addresses of the object's dynamically bound methods. Method calls are performed by fetching the method's address from the object's dispatch table. The dispatch table is the same for all objects belonging to the same class, and is therefore typically shared between them. Objects belonging to type-compatible classes (for example siblings in an inheritance hierarchy) will have dispatch tables with the same layout: the address of a given method will appear at the same offset for all type-compatible classes. Thus, fetching the method's address from a given dispatch table offset will get the method corresponding to the object's actual class." (Andrew Hare)

```
// virtual method invocation
class A {public String toString(){return("A");}}
class B extends A {public String toString(){return("B");}}
class C {public static void main(String [] args)
{A a = new B();System.out.print(a.toString());}}
// prints B because the jvm calls the appropriate method 
```
- HOWEVER if you try:

```
B b = new A();
```
the class will not compile: error, incompatible types:   
required: A  
found:    B  

- The compiler automatically provides a no-argument, default constructor for any class without constructors. This default constructor will call the no-argument constructor of the superclass.
- constructor chaining: If a constructor does not explicitly invoke a superclass constructor, the Java compiler automatically inserts a call to the no-argument constructor of the superclass. If the super class does not have a no-argument constructor, you will get a compile-time error.   But Oject has one.  there will be a whole chain of constructors called, all the way back to the constructor of Object.
- Methods called from constructors should generally be declared final. If a constructor calls a non-final method, a subclass may redefine that method with surprising or undesirable results.
- final classes cannot be subclassed, useful when creating an immutable class like the String class.

###Object###
```
protected Object clone() throws CloneNotSupportedException  
public boolean equals(Object obj)  
protected void finalize() throws Throwable  
public final Class getClass()  // cannot be overridden
public int hashCode()  
public String toString()  
notify, notifyAll, and wait   
```
- If an object contains a reference to an external object, override clone() to decouple them so that it clones the object and ObjExternal, Otherwise a change in ObjExternal made by one object will be visible in its clone also as the original object and its clone are not independent, so that the object and its clone are truly independent.
- If you override equals(), you must override hashCode() as well.
- A hash code is the object's memory address in hexadecimal.
- if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are equated
- finalize() may be invoked on an object when it becomes garbage.
- You cannot override getClass().
- getClass().getSimpleName()
- getClass().getSuperclass() // its superclass 
- getClass().getInterfaces() // interfaces it implements
- getFields().getMethods() // other methods (of 50) in Class.class

###Clone###
- create an object with similar state as the original object.
- use

```
protected Object clone() throws CloneNotSupportedException
```

or:

```
public Object clone() throws CloneNotSupportedException
```

if you are going to write a clone() method to override the one in Object.
- If an object contains a reference to an external object, a change in ObjExternal made by one object will be visible in its clone also. 
— to decouple them, you must override clone() so that it clones the object and ObjExternal. Then the original object references ObjExternal and the clone references a clone of ObjExternal, so that the object and its clone are truly independent

#Abstract & Interface#
- Java does not permit multiple inheritance(can only extend one class) but interfaces provide an alternative because you can implement more than one interface (an interface can extend any number of interfaces). 
- An interface name can be used anywhere a type can be used. 
- If a class includes abstract methods, the class itself must be declared abstract
- All methods declared in an interface are implicitly public, so the public modifier can be omitted.
- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.
- method definitions inside interfaces cannot be private or protected.

If an abstract class is subclassed and contians unimplemented methods, it must also be declared abstract.
- All of the methods in an interface are implicitly abstract, so the abstract modifier is not used. (it could be—it's just not necessary).
- Unlike interfaces, abstract classes can contain fields that are not static and final, and they can contain implemented methods. 
- Such abstract classes are similar to interfaces, except that they provide a partial implementation, leaving it to subclasses to complete the implementation. 
- If an abstract class contains only abstract method declarations, it should be declared as an interface instead.
- Multiple interfaces can be implemented by classes anywhere in the class hierarchy, whether or not they are related to one another in any way. Think of Comparable or Cloneable, for example.
- By comparison, abstract classes are most commonly subclassed to share pieces of implementation. A single abstract class is subclassed by similar classes that have a lot in common (the implemented parts of the abstract class), but also have some differences (the abstract methods).
- You can define an abstract class that does not implement all of an interface method.
- An abstract class may have static fields and static methods that can be used with a class reference—for: AbstractClass.staticMethod()—as with any other class.
- The combination of 'abstract' and 'synchronized' modifiers is not allowed.


###Switch###  
Works with
- byte and Byte
- short and Short
- char and Character
- int & Integer
- enum
- String  
 
 the switch block can be labeled with one or more case or default labels. The switch statement evaluates its expression, then executes all statements that follow the matching case label. (until a break?)

break statements are necessary because without them, statements in switch blocks fall through: All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.
```
        int j =2;
        switch (j)
        {
            case 1:System.out.println("1");
            case 2:System.out.println("2");
            case 3:System.out.println("3");
            case 4:System.out.println("4");
                break;
            case 5:System.out.println("5");
        }
```
Output: 2,3,4
The String in the switch expression is compared with the expressions associated with each case label as if the String.equals() method were being used


###Methods###
- Overriding Instance Methods: An instance method in a subclass with the same signature overrides the superclass's method.  An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.
**covariant return type** when an overridden method returns a subtype of the method in the superclass.  

An overriding method can also return a subtype of the type returned by the overridden method.   
- the version of the hidden static method that gets invoked is the one in the superclass (doesnt this depend if it's called from the static Class or an instance of the class? See our notes below)
- the version of the overridden instance method that gets invoked is the one in the subclass.
- Hidden Static Methods: If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.  The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.

```
Animal.testClassMethod()      - static Animal
myAnimal.testClassMethod()    - static Animal Hidden
Cat.testClassMethod()         - static Cat
myCat.testClassMethod         - static Cat

Animal.testInstanceMethod()   - compile error
myAnimal.testInstanceMethod() - instance Cat
Cat.testInstanceMethod        - compile error
myCat.testInstanceMethod      - instance Cat overriding
```
A smaller chart showing the calls to testClass/Instance methods:
            Class           Instance  
Animal      Animal          x  
myAnimal    Animal Hidden   Cat  
Cat         Cat             x  
myCat       Cat             Cat Overriding    

Here is the original code:
```
class Animal {
    static void testClassMethod() {print("class method in Animal");}
    void testInstanceMethod() {print("instance method in Animal");}
}
class Cat extends Animal {
    static void testClassMethod() {print("class method in Cat");}
    void testInstanceMethod() {print("instance method in Cat");}

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();      // #1. class method in Animal
        myAnimal.testInstanceMethod(); // #2. instance method in Cat
    }
}
```
As promised, the version of the hidden method that gets invoked is the one in the superclass, and the version of the overridden method that gets invoked is the one in the subclass.
(Isn't this the opposite of what happens in virtual method invocation?)
And what about this test question?:
```
class Parent
{
    private void method1(){System.out.println("Parent1");}
    public void method2(){System.out.println("Parent2"); method1();}
}
class Child extends Parent
{
    public void method1(){System.out.println("Child1");}
     public static void main(String args[])
     {
        Parent p = new Child();
        p.method2();
    }
}
```
Output:  
Parent2  
Parent1  
Because the method1 in Chile is private, the method1 in Parent is called.  If it was package private, protected or public, the Child method would be called.

StackOverflow: over-riding supports late binding, so which method is called is decided at run time.  (run-time polymorphism) #2
Hiding is for all others (static methods, instance members, static members) and is based on early binding (compile time) #1

Interface Methods: Default methods and abstract methods in interfaces are inherited like instance methods. 
** What the hell is a default method?***
- However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
Rule # 1: Instance methods are preferred over interface default methods.  Pegasus.identifyMyself() returns the string "I am a horse."

```
public class Pegasus extends Horse implements Flyer, Mythical 
{
    public static void main(String... args) 
    {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}
class Horse{public String identifyMyself(){return "I am a horse.";}}
interface Flyer 
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
```
Rule # 2: Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself() returns the string "I am able to lay eggs."
```
public interface Animal 
{
    default public String identifyMyself() 
    {
        return "interface_animal";
    }
}
public interface EggLayer extends Animal 
{
    default public String identifyMyself() 
    {
        return "I am able to lay eggs.";
    }
}
public interface FireBreather extends Animal 
{ 
    default public String identifyMyself() 
    {
        return "I am able to breathe fire.";
    }
}
public class Dragon implements EggLayer, FireBreather 
{
    public static void main (String... args) 
    {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
```
  This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 
- Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.

###Modifiers###
- an overriding method can allow more, but not less, access than the overridden method. ie: a protected instance method in the superclass can be made public, but not private, in the subclass.
Order: public, protected, (no modifier), private
- change an instance method in the superclass to a static method in the subclass, or vice versa = compile-time error.

You can prevent a class or method from being subclassed by using the final keyword.

###Packages###
- package private are All the top-level, non-public types in the same file as a public class.
- Importing java.awt.* imports all of the types in the java.awt package, but it does not import java.awt.color, java.awt.font, etc...  To import more, do this:

```
    import java.awt.*;
    import java.awt.color.*;
    import java.awt.font.*;
```

###Regular Expressions2###
Where did the original notes go?  Starting over...
\d  A digit: [0-9]
\D  A non-digit: [^0-9]
\s  A whitespace character: [ \t\n\x0B\f\r]
\S  A non-whitespace character: [^\s]
\w  A word character: [a-zA-Z_0-9]
\W  A non-word character: [^\w]


###Exceptions###  
**The Catch or Specify Requirement** code that might throw certain exceptions must be enclosed by either of the following:
- A try statement that catches the exception. The try must provide a handler for the exception (catch block)
- A method that specifies that it can throw the exception. The method must provide a throws clause that lists the exception in its method declaration

**Exception handler**  
- The runtime system searches the call stack for a method that contains a block of code that can handle the exception. This block of code is called an exception handler.
- An exception handler is considered appropriate if the type of the exception object thrown matches the type that can be handled by the handler.
- If the runtime system searches all the methods on the call stack without finding an appropriate exception handler the runtime system (program) terminates.

**The Three Kinds of Exceptions**  
1. checked exception  
2. error  
3. runtime exception  

1- Checked exceptions are subject to the Catch or Specify Requirement. All exceptions are checked exceptioSns, except for those indicated by Error, RuntimeException, and their subclasses.

2 - errors are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from. Errors are not subject to the Catch or Specify Requirement.  Thrown when a dynamic linking failure or other hard failure in the Java virtual machine occurs.

3 - runtime exceptions are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from. These usually indicate programming bugs, such as logic errors or improper use of an API.  not subject to the Catch or Specify Requirement.  Exception subclass, RuntimeException, is reserved for exceptions that indicate incorrect use of an API. Ie: NullPointerException, which occurs when a method tries to access a member of an object through a null reference.

Try & Catch
- A try statement does not have to have a catch block if it has a finally block.
- a single catch block can handle more than one type of exception (Java 7) to reduce code duplication and lessen the temptation to catch an overly broad exception.
- specify exceptions and separate each with a vertical bar (|):

```
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
```
- If a catch block handles more than one exception type, then the catch parameter is implicitly final. In this example, the catch parameter ex is final and therefore you cannot assign any values to it within the catch block.
- The runtime system always executes the statements within the finally block regardless of what happens within the try block. 
- The try-with-resources statement declares one or more resources.   Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

```
try (
        java.util.zip.ZipFile zf =
             new java.util.zip.ZipFile(zipFileName);
        java.io.BufferedWriter writer = 
            java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
    ) { ...
```
- the close methods of resources are called in the opposite order of their creation.
- an exception can be thrown from the try block, and up to two exceptions can be thrown from the try-with-resources statement when it tries to close the ZipFile and BufferedWriter objects.
- If an exception is thrown from the try block and one or more exceptions are thrown from the try-with-resources statement, then those exceptions thrown from the try-with-resources statement are suppressed
- the exception thrown by the block is the one that is thrown by the writeToFileZipFileContents method. 
- You can retrieve these suppressed exceptions by calling the Throwable.getSuppressed() method from the exception thrown by the try block.

```
try (Statement stmt = con.createStatement()) 
{
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) 
    {
        String coffeeName = rs.getString("COF_NAME");
        int supplierID = rs.getInt("SUP_ID");
        float price = rs.getFloat("PRICE");
        int sales = rs.getInt("SALES");
        int total = rs.getInt("TOTAL");
        System.out.println(coffeeName + ", " + supplierID + ", " + 
           price + ", " + sales + ", " + total);
    }
} catch (SQLException e) 
{
    JDBCTutorialUtilities.printSQLException(e);
}
```
- JDBC 4.1 and later API.
- any catch or finally block is run after the resources declared have been closed.
- The Closeable interface extends the AutoCloseable interface. 
- The close method of the Closeable interface throws exceptions of type IOException while the close method of the AutoCloseable interface throws exceptions of type Exception. 
- subclasses of the AutoCloseable interface can override this behavior of the close method to throw specialized exceptions, such as IOException, or no exception at all.

The runtime system checks handlers in the order in which they appear after the try statemen until its matches the type of exception that was thrown, and if found the runtime system ends its search for an appropriate exception handler. 

After the exception handler executes, the runtime system passes control to the finally block. Code in the finally block executes regardless of the exception caught above it.

To specify that a method can throw exceptions, add a throws clause to the method declaration followed by a comma-separated list of all the exceptions thrown by that method.  ie:
```
public void writeList() throws IOException {
```
- you can throw only objects that inherit from the java.lang.Throwable class.
- a method does not have to contain a throws clause for EmptyStackException (or to state that it might occur) because it is not a checked exception.

**Chained Exceptions** help you know when one exception causes another, when apps responds to an exception by throwing another exception (one causes the other).
```
Throwable that support chained exceptions.

Throwable getCause()
Throwable initCause(Throwable)
Throwable(String, Throwable)
Throwable(Throwable)
```
The Throwable argument to initCause and the Throwable constructors is the exception that caused the current exception. getCause returns the exception that caused the current exception, and initCause sets the current exception's cause.  
ex:
```
try {...} catch (IOException e) 
{ throw new SampleException("Other IOException", e); }
```
-  how to call the getStackTrace method on the exception object.

```
catch (Exception cause) {
    StackTraceElement elements[] = cause.getStackTrace();
    for (int i = 0, n = elements.length; i < n; i++) {       
        System.err.println(elements[i].getFileName()
            + ":" + elements[i].getLineNumber() 
            + ">> "
            + elements[i].getMethodName() + "()");
    }
}
```
- sends the output to a file using the logging facility in the java.util.logging package.

```
try 
{
    Handler handler = new FileHandler("OutFile.log");
    Logger.getLogger("").addHandler(handler);    
} catch (IOException e) 
{
    Logger logger = Logger.getLogger("package.name"); 
    StackTraceElement elements[] = e.getStackTrace();
    for (int i = 0, n = elements.length; i < n; i++) 
    {
        logger.log(Level.WARNING, elements[i].getMethodName());
    }
}
```

You should write your own exception classes if you answer yes to any of the following questions; 
- Do you need an exception type that isn't represented by those in the Java platform?
- Would it help users if they could differentiate your exceptions from those thrown by classes written by other vendors?
- Does your code throw more than one related exception?
- If you use someone else's exceptions, will users have access to those exceptions?
- or should your package be independent and self-contained?

 If a client can reasonably be expected to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception.

###ClassNotFoundException###
Occurs in the following cases:
1) When we try to load a class by using Class.forName() method and .class file or binary of class is not available in classpath.
2) When Classloader try to load a class by using findSystemClass () method.
3) While using loadClass() method of class ClassLoader in Java.


- Checked Exceptions  
ClassNotFoundException          cnfe  
IOException                     ioe  
IerruptedException                
NoSuchMethodException  

- Un-Checked Exceptions    
ArithmeticException  
ArrayIndexOutOfBoundsException  aioobe  
IllegalArgumentException          
NullPointerException            npe  
NumberFormatException           nfe  
  

Read more: http://javarevisited.blogspot.com/2011/08/classnotfoundexception-in-java-example.html#ixzz2xqdcUdwm

-------------------------
###Collection Interface###
```
public interface Collection<E> extends Iterable<E> {
    int size(); // cardinality
    boolean isEmpty();
    boolean contains(Object element);
    boolean add(E element);
    boolean remove(Object element);
    Iterator<E> iterator();
    boolean containsAll(Collection< ? > c); // true if c is subset
    boolean addAll(Collection< ? extends E> c); // union
    boolean removeAll(Collection< ? > c); // transforms set into the (asymmetric) set difference
    boolean retainAll(Collection< ? > c); // intersection of two sets
    void clear();
    Object[] toArray();
    <T> T[] toArray(T[] a);
}

public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove(); //optional
}
```



###Set Interface & Implementations###
Set: cannot contain duplicate elements.  
Has only methods inherited from Collection  
Two Set instances are equal if they contain the same elements.
Set implementations:  
- HashSet: unordered
- TreeSet: orders elements based on their values ABC...
- LinkedHashSet: orders elements based insertion-order 

```
Set<String> s = new HashSet<String>();
```
The code refers to the Collection by its interface type (Set) rather than by its implementation type (HashSet).  
Can change implementations by changing the constructor.
This prevents you from using any nonstandard operations.
If you want the program to print the word list in alphabetical order, 
change the Set's implementation type from HashSet to TreeSet.

To nondestructively find union, intersection, or set difference of two sets, copy one set before calling the appropriate bulk 
operation:
```
Set<Type> union = new HashSet<Type>(s1);
union.addAll(s2);
Set<Type> intersection = new HashSet<Type>(s1);
intersection.retainAll(s2);
Set<Type> difference = new HashSet<Type>(s1);
difference.removeAll(s2);
```

###List Interface###
An ordered Collection (sequence).
May contain duplicate elements.
Equal if they contain the ss elements in the same order.
Same Collection methods plus the following:
```
    E get(int index);                         // Positional accesser
    int indexOf(Object o);                    // Searches
    int lastIndexOf(Object o);
    ListIterator<E> listIterator();           // Iterations
    ListIterator<E> listIterator(int index);
    List<E> subList(int from, int to);        // Range-view
```
- The set and remove operations (from Collections) return the old value that is being overwritten or removed
- half-open range: subList, returns a List view of the portion of this list whose indices range from fromIndex, inclusive, to toIndex, exclusive. (mirrors the typical for loop)
- use the List returned by subList only as a transient object — to perform one or a sequence of range operations on the backing List. 

###List Iterator Interface###
```
public interface ListIterator<E> extends Iterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
    int nextIndex();
    int previousIndex();
    void remove(); //optional
    void set(E e); //optional
    void add(E e); //optional
}
```
- The first call to previous returns the same element as the last call to next. Similarly, the first call to next after a sequence of calls to previous returns the same element as the last call to previous.

- the behavior of the two boundary cases: (1) a call to previousIndex when the cursor is before the initial element returns -1 and (2) a call to nextIndex when the cursor is after the final element returns list.size()
- remove() the last element returned by next or previous.
- set() overwrites the last element returned by next or previous with the specified element.

###List Implementations###
1. general-purpose and 2. special-purpose.

1. General-Purpose  
- ArrayList
- LinkedList. 
ArrayList offers 
- constant-time positional access
- fast
- does not have to allocate a node object for each element in the List, 
- can take advantage of System.arraycopy when it has to move multiple
 elements at the same time. 
- a Vector without the synchronization overhead.
- tuning parameter: the initial capacity
(the number of elements the ArrayList can hold before it has to grow)

LinkedList
- If you frequently add elements to the beginning of the List
- iterate over the List to delete elements from its interior
- Positional access requires linear-time in a LinkedList
- constant-time in an ArrayList
- the constant factor for LinkedList is much worse.
- no tuning parameters and seven 

optional operations 
- clone
- addFirst
- getFirst
- removeFirst
- addLast
- getLast
- removeLast  
(LinkedList also implements the Queue interface)

2. Special-purpose

CopyOnWriteArrayList 
- backed up by a copy-on-write array
- similar in nature to CopyOnWriteArraySet. 
- No synchronization is necessary, even during iteration, 
- iterators are guaranteed never to throw ConcurrentModificationException. 
- well suited to maintaining event-handler lists, in which 
change is infrequent, and 
traversal is frequent and potentially time-consuming.

###Map Interface Map###
An object that maps keys to values. 
- A map cannot contain duplicate keys; each key can map to at most one value.
- three collection views
1. a set of keys, 
2. a collection of values
3. a set of key-value mappings. 
- The order defined by iterators
- TreeMap class, make specific guarantees as to their order
- HashMap class, do not.

models the mathematical function abstraction
- put 
- get
- remove
- containsKey
- containsValue
- size
- empty
- putAll 
- clear 
- keySet
- entrySet 
- values

Three general-purpose Map implementations (and their set analogies): 
HashMap         (HashSet)          unordered
TreeMap         (TreeSet)          ordered   
LinkedHashMap   (LinkedHashSet)    insertion order