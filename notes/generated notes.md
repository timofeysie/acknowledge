
ListsTest
HashSet         [3, 2, 10, 1, 0, 7, 6, 5, 4, 9, 8] unordered
TreeSet         [0, 1, 10, 2, 3, 4, 5, 6, 7, 8, 9] ordered
LinkedHashSet   [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10] insertion order
Arrays          [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10] sequence
Random list     [8, 6, 3, 0, 5, 10, 1, 4, 2, 7, 9]
ArrayList       [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10] insertion order?
swap(list,0,10) [10, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9]
replace(l,0,z)  [10, 8, 7, 6, 5, 4, 3, 2, 1, z, 9]
dealHand(l,1)   [10, 8, 7, 6, 5, 4, 3, 2, 1, z]

InitializationTest
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

OuterClassTest
Another class could only run the code if it has access to our outer class  
becuase it has default, or package access so any class within the same  
package as OuterClass will be able to run the code below without any issues.  
OuterClass outer = new OuterClass();
OuterClass.InnerClass inner1 = outer.new InnerClass();
InnerClass.accessOuter: The outer class's privInt is 10
A one line version:
OuterClass.InnerClass inner = new OuterClass().new InnerClass().accessOuter();
The 'new' keyword creates the inner class instance frpm an existing outer class instance,
instead of using the 'new' keyword to create a brand new instance.

Nested Class
OuterClass.Nested nested = new OuterClass.Nested();
nested.nestedClassMethod(); // This is OK
Nestic Class Method: 
non-static variables cannot be accessed from a static context
outer.outerClassMethod(); // but does not compile
This has private access in OuterClass

Creating an instance of a subclass of SomeClass where
methods are being defined at the same time that an instance of a class is created.
It's anonymous because the subclass has no name
SomeClass anonymous = new SomeClass() {
    public void someClassMethod() {log.info(anonymous method call);}};

This would create an instance of the Anonymous class:
SomeClass some_class = new SomeClass();
outer.createAnonymousSubclassOfSomeClass();
the implications of an anonymous inner class using polymorphism are that
using the anonymous inner class reference variable type you can only call methods
that are defined inside the type (the class) of the reference variable. 
Using our example, this means that with anonymous reference we can only call methods
that are defined inside SomeClass.

PolyTest
A a = new B() output: B var 1 str a
B b = new A() error- incompatible types: required: A found: B 
B b = new C() output: C var 2 str b
