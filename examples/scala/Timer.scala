

/* The oncePerSecond function gets a 
call-back function as an argument.
Unit takes no arguments and returns nothing 
(similar to void in C/C++).*/
object Timer {
	def oncePerSecond(callback: () => Unit) {
		while (true) { callback(); Thread sleep 1000 }
	}
	def timeFlies() {
		println("time flies like an arrow...")
	}
	def main(args: Array[String]) {
		oncePerSecond(timeFlies)
	}
}
/* the function timeFlies is only defined in order to be passed 
to the oncePerSecond function. Using anonymous functions: */
object TimerAnonymous {
	def oncePerSecond(callback: () => Unit) {
		while (true) { callback(); Thread sleep 1000 }
	}
	def main(args: Array[String]) {
		oncePerSecond(() =>
		println("time flies like an arrow..."))
	}
}
/* the => separates the function’s argument list from its body. 
The argument list is empty, as witnessed by the () on the left
of the arrow. */

/* Classes in Scala can have parameters. */
class Complex(real: Double, imaginary: Double) {
	def re() = real
	def im() = imaginary
}
/*The arguments must be passed when creating an instance of class 
Complex, as follows: new Complex(1.5, 2.3)
The return type of these two methods will be inferred automatically 
by the compiler, which looks at the right-hand side
of these methods and deduces that both return a value of type Double. */

/* the methods re and im is that, in order to call them, one has to
put an empty pair of parenthesis after their name, as the following example shows.*/
object ComplexNumbers {
	def main(args: Array[String]) {
		val c = new Complex(1.2, 3.4)
		println("imaginary part: " + c.im())
	}
}

/* To access the real and imaginary parts like if they were
fields, without putting the empty pair of parenthesis, define 
them as methods without arguments. Such methods differ
from methods with zero arguments in that they don’t have parenthesis after their
name, neither in their definition nor in their use. Our Complex class can be rewritten
as follows.*/
class Complex2(real: Double, imaginary: Double) {
	def re = real
	def im = imaginary
	/*When no super-class is specified, scala.AnyRef 
	is implicitly used. To explicitly specify that a 
	method overrides another one use the override modifier*/
	override def toString() = "" + re + (if (im < 0) "" else "+") + im + "i"
	
}

