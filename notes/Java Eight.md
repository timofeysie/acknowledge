Java Eight 
- unlike local and anonymous classes, lambda expressions do not have any shadowing issues 
- Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. 
- like local and anonymous classes, a lambda expression can only access local variables and parameters of the enclosing block that are final or effectively final. 
- The data type these methods expect is called the target type and you can only use lambda expressions in situations in which the Java compiler can determine a target type: Variable declarations, Assignments, Return statements, Array initializers, Method or constructor arguments, Lambda expression bodies, Conditional expressions, ?:, Cast expressions

###Default Methods###
**Virtual extension methods**, or, as they are often called, **defender methods**, can now be added to interfaces providing a default implementation of the declared behavior. interfaces can now implement methods & it doesn’t break the implementations.

- overriding.interface methods contians code that needs Java 8.

Nested Classes

- captured variable: a local class can only access local variables that are declared final.
- in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters.
Starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. 


