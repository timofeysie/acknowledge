
// Needs an enclosing object?  Anyhow, this is just for an example,
// not to be run.

/* In Java, a tree would be represented using an abstract 
super-class for the trees, and one concrete sub-class 
per node or leaf. In a functional programming language, 
one would use an algebraic data-type for the same purpose. 
Scala provides the concept of case classes which is somewhat 
in between the two. Here is how they can be used to define 
the type of the trees for our example: */

abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

/* classes Sum, Var and Const are declared as case classes means that they differ from standard classes in several respects:

- the new keyword is not mandatory to create instances of these
classes (i.e., one can write Const(5) instead of new Const(5)),
- getter functions are automatically defined for the constructor parameters (i.e., it is possible to get the value of the v constructor parameter of some instance c of class Const just by writing c.v),
- default definitions for methods equals and hashCode are provided, which work on the structure of the instances and not on their identity,
- a default definition for method toString is provided, and prints the value in a “source form” (e.g., the tree for expression x+1 prints as Sum(Var(x),Const(1))),
- instances of these classes can be decomposed through pattern matching. */

/* a function to evaluate an expression in some environment. The aim of the environment is to give values to variables. For example, the expression x+1 evaluated in an environment which associates the value 5 to variable x, written { x -> 5 }, gives 6 as result.

We therefore have to find a way to represent environments. We could of course use some associative data-structure like a hash table, but we can also directly use functions! An environment is really nothing more than a function which associates a value to a (variable) name. The environment { x -> 5 } given above can simply be written as follows in Scala: */
//{ case "x" => 5 }

/*We could of course always use the type String => Int for environments, but it simplifies the program if we introduce a name for this type, and makes future changes easier. 
From then on, the type Environment can be used as an alias of the type of functions from String to Int.*/
// type Environment = String => Int

/* the value of a sum of two expressions is simply the sum of the value of these expressions; the value of a variable is obtained directly from the environment; and the value of a constant is the constant itself. Expressing this in Scala is not more difficult: */
def eval(t: Tree, env: Environment): Int = t match {
  case Sum(l, r) => eval(l, env) + eval(r, env)
  case Var(n)    => env(n)
  case Const(v)  => v

/*This evaluation function works by performing pattern matching on the tree t. Intuitively, the meaning of the above definition should be clear:
1. it first checks if the tree t is a Sum, and if it is, it binds the left sub-tree to a new variable called l and the right sub-tree to a variable called r, and then proceeds with the evaluation of the expression following the arrow; this expression can (and does) make use of the variables bound by the pattern appearing on the left of the arrow, i.e., l and r,
2. if the first check does not succeed, that is, if the tree is not a Sum, it goes on and checks if t is a Var; if it is, it binds the name contained in the Var node to a variable n and proceeds with the right-hand expression,
3. if the second check also fails, that is if t is neither a Sum nor a Var, it checks if it is a Const, and if it is, it binds the value contained in the Const node to a variable v and proceeds with the right-hand side,
4. finally, if all checks fail, an exception is raised to signal the failure of the pattern matching expression; this could happen here only if more sub-classes of Tree were declared.
*/

/* why not define eval as a method of class Tree and its subclasses?
We could have done it actually, since Scala allows method definitions in case classes just like in normal classes. 
Deciding whether to use pattern matching or methods is therefore a matter of taste, but it also has important implications on extensibility:
1. when using methods, it is easy to add a new kind of node as this can be done just by defining a sub-class of Tree for it; on the other hand, adding a new operation to manipulate the tree is tedious, as it requires modifications to all sub-classes of Tree,
2. when using pattern matching, the situation is reversed: adding a new kind of node requires the modification of all functions which do pattern matching on the tree, to take the new node into account; on the other hand, adding a new operation is easy, by just defining it as an independent function.
*/

def derive(t: Tree, v: String): Tree = t match {
  case Sum(l, r) => Sum(derive(l, v), derive(r, v))
  case Var(n) if (v == n) => Const(1)
  case _ => Const(0)
}
/*
1. the derivative of a sum is the sum of the derivatives,
2. the derivative of some variable v is one if v is the variable relative to which the derivation takes place, and zero otherwise,
3. the derivative of a constant is zero.
 the case expression for variables has a guard, an expression following the if keyword. This guard prevents pattern matching from succeeding unless its expression is true. Here it is used to make sure that we return the constant 1 only if the name of the variable being derived is the same as the derivation variable v. The second new feature of pattern matching used here is the wildcard, written _, which is a pattern matching any value, without giving it a name.
*/

/* Now perform several operations on the expression (x+x)+(7+y): it first computes its value in the environment { x -> 5, y -> 7 }, then computes its derivative relative to x and then y. */

def main(args: Array[String]) {
  val exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
  val env: Environment = { case "x" => 5 case "y" => 7 }
  println("Expression: " + exp)
  println("Evaluation with x=5, y=7: " + eval(exp, env))
  println("Derivative relative to x:\n " + derive(exp, "x"))
  println("Derivative relative to y:\n " + derive(exp, "y"))
}
