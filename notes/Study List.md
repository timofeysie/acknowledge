'curly' braces    {}   
'square' brackets []   
parenthesis       ()   

- when you use an interface as a return type the object returned must implement the specified interface.

- byte: 8-bit min -128 max 127
- char: 16-bit min'\u0000' (or 0) max'\uffff' (65,535)
- short: 16-bit min -32,768 max 32,767
- int: 32-bit min -2,147,483,648(-2 tt 31)max 2,147,483,647(2 tt 31-1)
- float: 32-bit
- long: 64-bit min -2 tt 63 max 2 tt 63-1.
- double: 64-bit

byte 		8  If you Bite a  
char/short  16 character it's shorter  
int/float   32 inthe float but  
long/double 64 longer in the double.  

Instance override  
Static hide.  

- A subclass does not inherit the private members of its parent class. 
- virtual method invocation: (polymorphism aspect), call method referred to in a variable, not the method that is defined by the variable's type
```
class A(){String toString(print("A"));}
class B(){String toString(print("B"));}
class C(){public static void main(String [] args)
{
	A a = new B();
	a.toString(); // prints B
}

class Parent
{
	private void method1(){System.out.println("Parent1");}
	public void method2(){System.out.println("Parent2"); method1();}
}
class Child extends Parent
{
	public void method1()
	{System.out.println("Child1");}
	 public static void main(String args[])
	 {Parent p = new Child();p.method2();}
}
```
Output:  
Parent 2  
Parent 1  
The variable p refers to the Child class object. The statement p.method2() on execution will first look for method2() in Child class. Since there is no method2() in child class, the method2() of Parent class will be invoked and thus Parent's method2() will be printed. Now from the method2() , there is a call to method1(). Please note that method1() of Parent class is private, because of which the same method (method1() of Parent class) will be invoked. Had this method (method1() of Parent class) been public/protected/friendly (default), Child's class method1() would be called. Thus C is correct answer.' )
- If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. 
You can use the inherited members as is, replace them, hide them, or supplement them with new members:
- A nested class has access to all the private members of its enclosing class—both fields and methods. Therefore, a public or protected nested class inherited by a subclass has indirect access to all of the private members of the superclass.

###Nested Classes###    
1. Static nested classes  
2. Non-static nested classes (inner classes)  
2A. local classes  
2B. anonymous classes.  
- cannot declare constructors in an anonymous class.

**The Three Kinds of Exceptions**   
1. Checked exceptions: subject to the Catch or Specify Requirement. All exceptions are checked exceptions, except for those indicated by Error, RuntimeException, and their subclasses.
2. Errors: exceptional conditions that are external (not subject to the Catch or Specify Requirement)
3. Runtime exceptions: exceptional conditions that are internal to the app(bugs, not subject to the Catch or Specify Requirement)

```
try (
        ZipFile zf = new ZipFile(zipFileName);
        BufferedWriter writer = newBufferedWriter(Path, charset)) 
{ ...
```
- try-with-resources statement declares one or more resources.   Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
- the close() methods of resources are called in the opposite order of their creation.
- any catch or finally block is run after the resources declared have been closed.

```
catch (IOException|SQLException ex) {
```
- If a catch block handles more than one exception type, then the catch parameter (ex) is implicitly final.


Operators		Precedence    
postfix			expr++ expr--  
unary			++expr --expr +expr -expr ~ !  
multiplicative	* / %  
additive		+ -  
shift			<< >> >>>  
relational      < > <= >= instanceof  
equality        == !=  
bitwise AND     &  
bitwise exclusive OR    ^   
bitwise inclusive OR   |    
logical AND     &&    
logical OR      ||    
ternary         ? :    
assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=    
```
	int i = 1;
	int j = 1;
	int k = ++i * j++;  
	// ijk is 2-2-2. if we use i instead of j there then k will be 4.
```	

- an overriding method can allow more, but not less, access than the overridden method. Order: public, protected, (no modifier), private

Keywords: goto, strictfp, const, transient, native, synchronized

#Abstract & Interface#
- All methods declared in an interface are implicitly public & abstract, so the public modifier can be omitted.  They cannot be private or protected.
- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.
- Unlike interfaces, abstract classes can contain fields that are not static and final, and they can contain implemented methods. 
- An abstract class may have static fields and static methods that can be used with a class reference—for: AbstractClass.staticMethod()—as with any other class.

###Collection Interface###
```
int size()  
boolean isEmpty()  
boolean contains()  
boolean add()  
boolean remove()  
Iterator<E> iterator()  
boolean containsAll()  
boolean addAll()  
boolean removeAll()  
boolean retainAll()  
void clear()  
Object[] toArray()  
```

###Iterator Interface###
```
boolean hasNext()  
E next()  
void remove()  
```

###Set Interface & Implementations###
Set: cannot contain duplicate elements.   
Has only methods inherited from Collection    
Two Set instances are equal if they contain the same elements.  
Set implementations:    
- HashSet: unordered
- TreeSet: ABC...
- LinkedHashSet: insertion-order 

###List Interface###
An ordered Collection (sequence).  
May contain duplicate elements.  
Equal if they contain the same elements in the same order.  
Same Collection methods plus the following:   
```
    E get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
    List<E> subList(int from, int to); // range
```

###List Iterator Interface### Iterator plus the following:
```
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
    int nextIndex();
    int previousIndex();
    void remove();
    void set(E e);
    void add(E e);
}
```

###List Implementations###
- ArrayList
- LinkedList - optional operations 
- clone
- addFirst
- getFirst
- removeFirst
- addLast
- getLast
- removeLast  
(LinkedList also implements the Queue interface)
CopyOnWriteArrayList - No sync necessary, event-handler lists, in which 
change is infrequent
- Vector
- Stack: (LIFO), extends class Vector with push, pop, peek, empty, and search

~       Unary bitwise complement: reverses 0s and 1s    
<<      Signed left shift fills the right bits by zero.  
>_>     Signed right shift fills the left most bit by the sign bit  
>_>_>   Unsigned (0 fill) right shift fills the leftmost bits by zeros   
&       Bitwise AND  both 1 = 1, otherwise 0  
^       Bitwise exclusive OR XOR same = 0, diff = 1  
|       Bitwise inclusive OR both 0 = 0, otherwise 1  
  
1100100 100  
1000000 64  &  
-----------  
1000000 64  

1100100 100  
1000000 64  ^  
-----------  
0100100 36  

1100100 100  
1000000 64  |  
-----------  
1100100 100  

00000100 4  100  
00001000 8  1,000  
00010000 16 10,000  
00100000 32 100,000  
01000000 64 1,000,000  
10000000 128 10,000,000  

###Object###
clone()   
boolean equals(Object obj)   
protected  void	finalize()   
Class getClass()   
int hashCode()   
void notify()   
void notifyAll()   
String toString()   
wait()   

###The String Class###
boolean endsWith()  
boolean startsWith()   
int compareTo  
int compareToIgnoreCase()  
boolean matches()  
boolean regionMatches()  
String substring()  
String[] split()  
CharSequence subSequence()  
String replace()  
String replaceAll()  
String replaceFirst()  
boolean equals()  
boolean equalsIgnoreCase()  

###The StringBuilder Class###
setLength()  
append()  
delete()  
insert()  
replace()  
setCharAt()  
reverse()  

###Pattern###
static Pattern compile(String regex)  
static Pattern compile(String regex, int flags)  
int flags()  
Matcher matcher(CharSequence input)  
static boolean matches(String regex, CharSequence input)  
String pattern()  
static String quote(String s)  
String[] split(CharSequence input)  
String[] split(CharSequence input, int limit)  
String toString()  


Defaults

- The initial capacity of a ArrayList created with its default
constructor is 10.
