Study List

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


Things to do:  
overriding clone() example  
finish inner class notes  


