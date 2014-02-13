Java Eight 
- unlike local and anonymous classes, lambda expressions do not have any shadowing issues 
- Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. 
- like local and anonymous classes, a lambda expression can only access local variables and parameters of the enclosing block that are final or effectively final. 
- The data type these methods expect is called the target type and you can only use lambda expressions in situations in which the Java compiler can determine a target type: Variable declarations, Assignments, Return statements, Array initializers, Method or constructor arguments, Lambda expression bodies, Conditional expressions, ?:, Cast expressions