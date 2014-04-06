Study List

x shadows all other xs (local variable)
inner class x this.x shadows outer class x   
Outer class x ShadowTest.this.x  

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

(Imagine biting an English letter so that the top half falls off and lands next to the bottom half. Now there is nothing floating above, but double and longer/wider down below.)

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
```

Operators make expressions.
Expressions make statements.
Statements make blocks.
Operators -> Expressions -> Statements -> Blocks

```
Set<String> s = new HashSet<String>();
```
Referring to collections only by their interface prevents you from 
using any nonstandard operations.

nondestructive idioms, first copy:
Set<Type> union/inter/diff = new HashSet<Type>(s1);
union.addAll(s2);
intersection.retainAll(s2);
difference.removeAll(s2);

- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.


```
// Compile error cannot be referenced from a static context
Animal.testClassMethod()      - static Animal
Animal.testInstanceMethod()   - compile error
myAnimal.testClassMethod()    - static Animal Hidden
myAnimal.testInstanceMethod() - instance Cat
Cat.testClassMethod()         - static Cat
Cat.testInstanceMethod        - compile error
myCat.testClassMethod         - static Cat
myCat.testInstanceMethod      - instance Cat overriding

Animal.testClassMethod()      - static Animal
myAnimal.testClassMethod()    - static Animal Hidden
Cat.testClassMethod()         - static Cat
myCat.testClassMethod         - static Cat

Animal.testInstanceMethod()   - compile error
myAnimal.testInstanceMethod() - instance Cat
Cat.testInstanceMethod        - compile error
myCat.testInstanceMethod      - instance Cat overriding
```
            Class           Instance  
Animal      Animal          x  
myAnimal    Animal Hidden   Cat  
Cat         Cat             x  
myCat       Cat             Cat Overriding  

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
Output:
Parent 2
Parent 1
C is correct. The code will compile without any error and also will not give any run time error. The variable p refers to the Child class object. The statement p.method2() on execution will first look for method2() in Child class. Since there is no method2() in child class, the method2() of Parent class will be invoked and thus &quot;Parent's method2()&quot; will be printed. Now from the method2() , there is a call to method1(). Please note that method1() of Parent class is private, because of which the same method (method1() of Parent class) will be invoked. Had this method (method1() of Parent class) been public/protected/friendly (default), Child's class method1() would be called. Thus C is correct answer.' )

Add to inheritance
- If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. 
You can use the inherited members as is, replace them, hide them, or supplement them with new members:
- A nested class has access to all the private members of its enclosing class—both fields and methods. Therefore, a public or protected nested class inherited by a subclass has indirect access to all of the private members of the superclass.

###Nested Classes###  
Two types:  
1. Static nested classes
2. Non-static nested classes (inner classes(local/anonymous))
- two kinds of inner classes:
A. local classes
B. anonymous classes.
However, you cannot declare constructors in an anonymous class.

**The Three Kinds of Exceptions**  
1. Checked exceptions: subject to the Catch or Specify Requirement. All exceptions are checked exceptioSns, except for those indicated by Error, RuntimeException, and their subclasses.
2. Errors: exceptional conditions that are external (not subject to the Catch or Specify Requirement)
3. Runtime exceptions: exceptional conditions that are internal to the app(bugs, not subject to the Catch or Specify Requirement)
```
catch (IOException|SQLException ex) {
```
- If a catch block handles more than one exception type, then the catch parameter is implicitly final.
try-with-resources statement declares one or more resources.   Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
```
try (
        ZipFile zf = new ZipFile(zipFileName);
        BufferedWriter writer = newBufferedWriter(Path, charset)
    ) { ...
```
- the close() methods of resources are called in the opposite order of their creation.
- any catch or finally block is run after the resources declared have been closed.

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
bitwise inclusive OR    |  
logical AND     &&  
logical OR      ||  
ternary         ? :  
assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=  
```
	int i = 1;
	int j = 1;
	int k = ++i * j++;  // ijk is 2-2-2
```	

When the supertypes of a class or interface provide multiple 
default methods with the same signature, the Java compiler follows 
inheritance rules to resolve the name conflict. 
These rules are driven by the following two principles:
Rule # 1:
Instance methods are preferred over interface default methods.
The method Pegasus.identifyMyself returns the string I am a horse.

- an overriding method can allow more, but not less, access than the overridden method. ie: a protected instance method in the superclass can be made public, but not private, in the subclass.
Order: public, protected, (no modifier), private

Keywords: goto, strictfp, const, transient, native, synchronized

#Abstract & Interface#
- All methods declared in an interface are implicitly public, so the public modifier can be omitted.
- Method definitions inside interfaces cannot be private or protected.
- All constant values defined in an interface are implicitly public, static, and final and these can be omitted.
- All of the methods in an interface are implicitly abstract, so the abstract modifier is not used. (it could be—it's just not necessary).
- Unlike interfaces, abstract classes can contain fields that are not static and final, and they can contain implemented methods. 
- An abstract class may have static fields and static methods that can be used with a class reference—for: AbstractClass.staticMethod()—as with any other class.

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

###Trick Questions###
```
interface Rideable 
{
	String getGait();
}
public class Camel implements Rideable 
{
	int weight = 2;
	public static void main(String[] args) 
	{
		new Camel().go(8);
	}
	void go(int speed) 
	{
		++speed;
		weight++;
		int walkrate = speed * weight;
		System.out.print(walkrate + getGait());
	}
	String getGait() 
	{
		return " mph, lope";
	}
}
```
error: getGait() in Camel cannot implement getGait() in Rideable
attempting to assign weaker access privileges; was public
- This happens becuase "methods in an interface are implicitly public, so the public modifier can be omitted." but the default for a class is package private.
class A.  class B extends A.
A a = new B().go() output: B
B b = new A() compile error- incompatible types: required: A found: B 

Arrays are objects, so
int a[] = {1,2,3,4}
print(a instanceof Object) prints true.

```
boolean a = true;
boolean b = false;
boolean c = true;
if (a && (b = c)) 
```
- an assignment statement also has a value equal to the value being 
assigned, hence (b = c) evaluates to true and subsequently a 
(b = c) evaluates to true

```
float x = 0.1f;
while (x != 1.1) {
System.out.printf("x = %f%n", x);
x = x + 0.1f;
}
```
The number 0.1 cannot be stored precisely in base two in the same way that the
decimal equivalent of the fraction 1/3 cannot be represented exactly (0.333333…).
The result of adding this number repeatedly to x will result in a number that is not
quite 1.1. The comparison, x != 1.1, will return true and the loop will never end.
The output of the printf statement does not show this difference:
```
…
x = 0.900000
x = 1.000000
x = 1.100000
x = 1.200000
x = 1.300000
...
```

-0.0 == 0.0 is true.


###The String Class###
- boolean ends/startsWith(String su/prefix)
- boolean startsWith(String prefix, int offset) 
- int compareTo/IgnoreCase(String anotherString)
- boolean equals/IgnoreCase(String anotherString)  
- boolean regionMatches(int toffset, String other, int ooffset, int len) 
- boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
- boolean matches(String regex)
- int length()
- string1.concat(string2)
- String substring(int beginIndex)
- String[] split(String regex)
- String[] split(String regex, int limit)
- CharSequence subSequence(int beginIndex, int endIndex)
- String replace(char oldChar, char newChar)
- String replace(CharSequence target, CharSequence replacement)	
- String replaceAll(String regex, String replacement)
- String replaceFirst(String regex, String replacement)
- boolean ends/startsWith(String suf/prefix)
- boolean startsWith(String prefix, int offset)
- int compareTo(String anotherString)
- int compareToIgnoreCase(String str)
- boolean equals(Object anObject)
- boolean equalsIgnoreCase(String anotherString)
- boolean regionMatches(int toffset, String other, int ooffset, int len)
- boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
- boolean matches(String regex)


Things to do:   
- TreeSet stores its elements in a red-black tree
- Questions and Exercises: Nested Classes
- www.javapepare.com this site is for tests 5 and 6.  We need test 7!
Does it include IO and Concurrency?  Platfrom Environment or RegExps?
IO and COncurrency are definately on the Level II exam, but platform and regexp?  OK, Section 5, Item 2 has regexps.
- gocertify.com test 2 questions 4:  What are the "the rules of promotion for binary operands"?
- FileInputStreams
- Serializable
- Constructor class?
